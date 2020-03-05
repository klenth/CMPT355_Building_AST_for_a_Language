package cmpt355.example.hinky.ast;

import cmpt355.example.hinky.HinkyBaseVisitor;
import cmpt355.example.hinky.HinkyParser;
import cmpt355.example.hinky.ast.node.*;
import cmpt355.example.hinky.util.Lists;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Visitor extends HinkyBaseVisitor<AstNode> {

    @Override
    public NumberExpression visitNumberExpression(HinkyParser.NumberExpressionContext ctx) {
        return new NumberExpression(Double.parseDouble(ctx.getText()));
    }

    @Override
    public FunctionDefinition visitFunctionDefinition(HinkyParser.FunctionDefinitionContext ctx) {
        String id = ctx.id.getText();
        List<String> params = Lists.map(ctx.params, p -> p.getText());
        Expression body = (Expression)visit(ctx.body);
        return new FunctionDefinition(id, params, body);
    }

    @Override
    public Item visitItem(HinkyParser.ItemContext ctx) {
        if (ctx.STRING() != null) {
            return new Item(ctx.STRING().getText());
        } else {
            return new Item((Expression)visit(ctx.expression()));
        }
    }

    @Override
    public PrintStatement visitPrint(HinkyParser.PrintContext ctx) {
        return new PrintStatement(
                Lists.map(ctx.itemList().items,
                        i -> visitItem(i))
        );
    }
}
