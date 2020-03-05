package cmpt355.example.hinky.ast.node;

import java.util.List;

public class Program extends AstNode
{
    private List<Statement> statements;

    public Program(List<Statement> statements)
    {
        setStatements(statements);
    }

    public List<Statement> getStatements()
    {
        return statements;
    }

    public void setStatements(List<Statement> statements)
    {
        for(Statement statement : statements)
        {
            reparent(statement);
        }
        this.statements = statements;
    }

    @Override
    public List<? extends AstNode> children()
    {
        return statements;
    }

    @Override
    public String toString()
    {
        return "program";
    }
}
