package cmpt355.example.hinky.ast;

import cmpt355.example.hinky.HinkyBaseVisitor;
import cmpt355.example.hinky.HinkyParser;
import cmpt355.example.hinky.ast.node.AstNode;
import cmpt355.example.hinky.ast.node.Expression;
import cmpt355.example.hinky.ast.node.NumberExpression;

public class Visitor extends HinkyBaseVisitor<AstNode> {

    @Override
    public NumberExpression visitNumberExpression(HinkyParser.NumberExpressionContext ctx) {
        return new NumberExpression(Double.parseDouble(ctx.getText()));
    }


}
