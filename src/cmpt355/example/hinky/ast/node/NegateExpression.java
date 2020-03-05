package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class NegateExpression extends Expression
{
    private Expression expr;

    public NegateExpression(Expression expr)
    {
        setExpr(expr);
    }

    public Expression getExpr()
    {
        return expr;
    }

    public void setExpr(Expression expr)
    {
        this.expr = reparentNonNull(expr);
    }

    @Override
    public List<? extends AstNode> children()
    {
        return Lists.<Expression>builder()
                .add(expr)
                .build();
    }

    @Override
    public String toString()
    {
        return "negate";
    }
}
