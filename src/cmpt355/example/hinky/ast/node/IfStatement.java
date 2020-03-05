package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;
import java.util.Optional;

public class IfStatement extends Statement {
	private Expression cond;
	private Statement trueStmt, falseStmt;

	public IfStatement(Expression cond, Statement trueStmt, Statement falseStmt) {
		setCond(cond);
		setTrueStmt(trueStmt);
		setFalseStmt(falseStmt);
	}

	public Expression getCond() {
		return cond;
	}

	public void setCond(Expression cond) {
		this.cond = reparentNonNull(cond); // use reparentNonNull to change the non-optional children's parent
	}

	public Statement getTrueStmt() {
		return trueStmt;
	}

	public void setTrueStmt(Statement trueStmt) {
		this.trueStmt = reparentNonNull(trueStmt);
	}

	public Optional<Statement> getFalseStmt() {
		return Optional.ofNullable(falseStmt);
	}

	public void setFalseStmt(Statement falseStmt) {
		this.falseStmt = reparent(falseStmt); // this is optional so we use reparent not reparentNotNull
	}

	@Override
	public List<AstNode> children() {
		return Lists.<AstNode>builder()     // list builder in util by Kathy
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
