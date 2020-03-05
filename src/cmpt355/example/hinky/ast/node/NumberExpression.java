package cmpt355.example.hinky.ast.node;

import java.util.List;

public class NumberExpression extends Expression {

    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public List<? extends AstNode> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
