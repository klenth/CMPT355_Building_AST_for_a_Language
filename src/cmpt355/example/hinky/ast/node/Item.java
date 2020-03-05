package cmpt355.example.hinky.ast.node;

import cmpt355.example.hinky.util.Lists;

import java.util.List;

public class Item extends AstNode {
	private String str;
	private Expression expr;

	public Item(Expression expr) {
		setExpr(expr);
	}

	public Item(String str) {
		setStr(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = reparentNonNull(expr);
	}

	// check type: String
	public boolean isString() {
		return (str != null);
	}

	// check type: Expression
	public boolean isExpression() {
		return (expr != null);
	}

	@Override
	public List<? extends AstNode> children() {
		return Lists.<AstNode>builder()     // list builder in util by Kathy
				.addIfPresent(expr)
				.build();
	}

	@Override
	public String toString() {
		return "item";
	}
}
