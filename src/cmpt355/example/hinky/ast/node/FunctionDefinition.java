package cmpt355.example.hinky.ast.node;

import java.util.List;
import java.util.Objects;

public class FunctionDefinition extends Statement {

    private String id;
    private List<String> parameters;
    private Expression body;

    public FunctionDefinition(String id, List<String> parameters, Expression body) {
        setId(id);
        setParameters(parameters);
        setBody(body);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = Objects.requireNonNull(parameters);
    }

    public Expression getBody() {
        return body;
    }

    public void setBody(Expression body) {
        this.body = reparentNonNull(body);
    }

    @Override
    public List<Expression> children() {
        return List.of(body);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Define function ").append(id).append('(');
        for (int i = 0; i + 1 < parameters.size(); ++i)
            sb.append(parameters.get(i)).append(',');
        sb.append(parameters.get(parameters.size() - 1)).append(")");
        return sb.toString();
    }
}
