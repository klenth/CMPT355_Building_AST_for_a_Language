package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class VariableExpression extends Expression {

    private String name;

    public VariableExpression(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<AstNode> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return name;
    }
}
