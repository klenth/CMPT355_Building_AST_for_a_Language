package cmpt355.example.hinky.ast.node;

import java.util.List;
import java.util.Objects;

public class BinaryBoolExpression extends BooleanExpression {

    private Expression left, right;
    private String op;

    public BinaryBoolExpression(Expression left, Expression right, String op) {
        setLeft(left);
        setRight(right);
        setOp(op);
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = reparentNonNull(left);
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = reparentNonNull(right);
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = Objects.requireNonNull(op);
    }

    @Override
    public List<Expression> children() {
        return List.of(left, right);
    }

    @Override
    public String toString() {
        return op;
    }
}
