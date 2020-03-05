package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class WhileLoop extends Statement{

    private Expression cond;
    private Statement body;

    public WhileLoop(Expression cond, Statement body) {
        setCond(cond);
        setBody(body);
    }

    public Expression getCond() {
        return cond;
    }

    public void setCond(Expression cond) {
        this.cond = reparentNonNull(cond);
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = reparentNonNull(body);
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
                .add(cond)
                .add(body)
                .build();
    }

    @Override
    public String toString() {
        return "while";
    }
}
