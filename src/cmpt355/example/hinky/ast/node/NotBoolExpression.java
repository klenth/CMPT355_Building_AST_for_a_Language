package cmpt355.example.hinky.ast.node;

import java.util.List;

public class NotBoolExpression extends BooleanExpression {

    private BooleanExpression expr;

    public NotBoolExpression(BooleanExpression expr) {
        setExpr(expr);
    }

    public BooleanExpression getExpr() {
        return expr;
    }

    public void setExpr(BooleanExpression expr) {
        this.expr = reparentNonNull(expr);
    }

    @Override
    public List<BooleanExpression> children() {
        return List.of(expr);
    }

    @Override
    public String toString() {
        return "not";
    }
}
