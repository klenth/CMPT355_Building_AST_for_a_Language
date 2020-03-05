package cmpt355.example.hinky.ast.node;
import cmpt355.example.hinky.util.Lists;

import java.util.List;
import java.util.Optional;

public class IfStatement extends Statement {

    private Expression cond;
    private Statement trueStmt, falseStmt;

    public IfStatement(Expression cond, Statement left, Statement right) {
        setCond(cond);
        setTrueStmt(left);
        setFalseStmt(right);

    }

    public Expression getCond() {
        return cond;
    }

    public void setCond(Expression cond) {
        this.cond = reparentNonNull(cond); //reparentNonNull because it's not optional
    }

    public Statement getTrueStmt() {
        return trueStmt;
    }

    public void setTrueStmt(Statement trueStmt) {
        this.trueStmt = trueStmt;
    }

    public Optional<Statement> getFalseStmt() {
        return Optional.ofNullable(falseStmt);
    }

    public void setFalseStmt(Statement falseStmt) {
        this.falseStmt = reparent(falseStmt); // reparent because it's optional
    }

    @Override
    public List<? extends AstNode> children() {
        return Lists.<AstNode>builder()
                .add(cond)
                .add(trueStmt)
                .add(falseStmt)
                .build();
    }
    @Override
    public String toString() {
        return "if";
    }
}
