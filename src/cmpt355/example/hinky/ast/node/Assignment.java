package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class Assignment extends Statement {
    private Expression value;
    private String id;

    public Assignment(String id) {
        this.id = id;
    }

    public Assignment(Expression value) {
        setValue(value);
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = reparent(value);
    }


    @Override
    public List<? extends AstNode> children() {
        return Lists.<AstNode>builder()
                .add(value)
                .build();
    }

    @Override
    public String toString() {
        return "assignment";
    }
}
