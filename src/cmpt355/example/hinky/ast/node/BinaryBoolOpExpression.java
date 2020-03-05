package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class BinaryBoolOpExpression extends BooleanExpression {

    private Expression left;
    private Expression right;
    private String op;

    public BinaryBoolOpExpression(Expression left, Expression right, String op) {
        setLeft(left);
        setRight(right);
        setOp(op);
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOp() {
        return op;
    }

    public void setLeft(Expression left) {
        this.left = reparentNonNull(left);
    }

    public void setRight(Expression right) {
        this.right = reparentNonNull(right);
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
                .add(left)
                .add(right)
                .build();
    }

    @Override
    public String toString() {
        return "boolExOp";
    }
}
