/**
 * 
 */
package tech.feily.lexicalanalysis.regular;

import java.io.IOException;

/**
 * @author FeilyZhang
 *
 */
public interface Tree {
    
    public abstract void setHead(TreeNode head);
    public abstract TreeNode getHead();
    
    public abstract void setTail(TreeNode tail);
    public abstract TreeNode getTail();
    
    public abstract Tree deepClone() throws IOException, ClassNotFoundException ;
    public abstract String toString();
    
}
