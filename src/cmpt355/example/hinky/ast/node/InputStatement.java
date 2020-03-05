package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class InputStatement extends Statement {

    public List<AstNode> items;

    public InputStatement(List<AstNode> items) {
        setItems(items);
    }

    public List<AstNode> getItems() {
        return items;
    }

    public void setItems(List<AstNode> items) {
        this.items = reparentNonNull(items);
    }

    @Override
    public String toString() {
        return "input";
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
                .addAll(items)
                .build();
    }
}

