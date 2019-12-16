package stone.ast;

import java.util.Iterator;
import java.util.List;

public class ASTList extends ASTree {
    protected List<ASTree> children;
    public ASTList(List<ASTree> children) {
        this.children = children;
    }
    @Override
    public ASTree child(int i) {
        return this.children.get(i);
    }

    @Override
    public int numChildren() {
        return this.children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return this.children.iterator();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTree child : children) {
            builder.append(sep);
            sep = " ";
            builder.append(child.toString());
        }
        return builder.append(')').toString();
    }

    @Override
    public String location() {
        for (ASTree child : children) {
            String s = child.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }
}
