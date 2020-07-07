/**
 * 
 */
package tech.feily.lexicalanalysis.regular;

/**
 * @author FeilyZhang
 *
 */
public interface Tree {
    
    public abstract void setHead(TreeNode head);
    public abstract TreeNode getHead();
    
    public abstract void setTail(TreeNode tail);
    public abstract TreeNode getTail();
    
}
