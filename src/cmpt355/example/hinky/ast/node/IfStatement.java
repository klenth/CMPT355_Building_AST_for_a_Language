package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.Optional;

public class IfStatement extends Statement {
    private Expression cond;
    private Statement trueStmt, falseStmt;

    public IfStatement(Expression cond, Statement trueStmt, Statement falseStmt) {
        setCond(cond);
        setTrueStatement(trueStmt);
        setFalseStatement(falseStmt);
    }

    public Expression getCond() {
        return cond;
    }

    public void setCond(Expression cond) {
        this.cond = reparentNonNull(cond); // reparentNotNull because it's not optional
    }

    public Statement getTrueStatement() {
        return trueStmt;
    }

    public void setTrueStatement(Statement trueStatement) {
        this.trueStmt = trueStatement;
    }

    public Statement getFalseStatement() {
        return falseStmt;
    }

    public Optional<Statement> getFalseStmt() {
        return Optional.ofNullable(falseStmt);
    }

    public void setFalseStatement(Statement falseStatement) {
        this.falseStmt = falseStatement;
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
                .add(cond)
                .add(trueStmt)
                .addIfPresent(falseStmt)
                .build();
    }

    @Override
    public String toString() {
        return "if";
    }
}
