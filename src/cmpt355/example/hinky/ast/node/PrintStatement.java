package cmpt355.example.hinky.ast.node;
import java.util.*;
import cmpt355.example.hinky.util.*;

public class PrintStatement extends AstNode {

    // Needs to update to List<Item>
    private List<AstNode> itemList;

    public PrintStatement( List<AstNode> itemList ) {
        setItemList( itemList );
    }

    public List<AstNode> getItemList() {
        return itemList;
    }

    public void setItemList( List<AstNode> itemList ) {
        this.itemList = reparentNonNull( itemList ); //itemList can be empty
    }

    @Override
    public String toString() {
        return "print";
    }

    @Override
    public List<AstNode> children() {
        return Lists.<AstNode>builder()
            .addAll( itemList )
            .build();
    }
}
