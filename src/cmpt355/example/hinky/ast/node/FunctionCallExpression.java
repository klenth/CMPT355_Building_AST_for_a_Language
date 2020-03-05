package cmpt355.example.hinky.ast.node;

import java.util.List;
import java.util.Optional;

public class FunctionCallExpression extends Expression {
	private List<Expression> args;

	public FunctionCallExpression(List<Expression> args) {
		setArgs(args);
	}

	public Optional<List<Expression>> getArgs() {
		return Optional.ofNullable(args);
	}

	public void setArgs(List<Expression> args) {
		this.args = reparent(args);
	}

	@Override
	public List<? extends AstNode> children() {
		return this.args;
	}

	@Override
	public String toString() {
		return "function call";
	}
}
