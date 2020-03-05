package cmpt355.example.hinky.ast.node;

import java.util.*;
import cmpt355.example.hinky.util.*;

public class IfStatement extends Statement {

    private Expression cond;
    private Statement trueStmt, falseStmt;

    public IfStatement( Expression cond, Statement trueStmt, Statement falseStmt ) {
        setCond( cond );
        setTrueStmt( trueStmt );
        setFalseStmt( falseStmt );
    }

    public Expression getCond() {
        return cond;
    }

    public void setCond( Expression cond ) {
        this.cond = reparentNonNull( cond ); //initialize and set parent
    }

    public Statement getTrueStmt() {
        return trueStmt;
    }

    public void setTrueStmt( Statement trueStmt ) {
        this.trueStmt = reparentNonNull( trueStmt );
    }

    /**
     * Since falseStmt can be null, return Optional
     * @return Optional<Statement>
     */
    public Optional<Statement> getFalseStmt() {
        // Optional.ofNullable() returns an empty Optional if the arg is null
        // or an Optional containing the specified value of non-null.
        return Optional.ofNullable( falseStmt );
    }

    // False statement is optional, can be null
    public void setFalseStmt( Statement falseStmt ) {
        this.falseStmt = reparent( falseStmt );
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
            .add( cond )
            .add( trueStmt )
            .addIfPresent( falseStmt )
            .build(); //can be null
    }

    /**
     * What you return in toString() should include an instance variables
     * that are not AstNodes themselves.
     * @return String
     */
    @Override
    public String toString() {
        return "if"; //return the type when displaying the ASt
    }


}
