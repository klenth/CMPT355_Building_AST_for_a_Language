package cmpt355.example.hinky.ast;

import cmpt355.example.hinky.HinkyBaseVisitor;
import cmpt355.example.hinky.HinkyParser;
import cmpt355.example.hinky.ast.node.AstNode;
import cmpt355.example.hinky.ast.node.Expression;
import cmpt355.example.hinky.ast.node.FunctionDefinition;
import cmpt355.example.hinky.ast.node.NumberExpression;
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
}
