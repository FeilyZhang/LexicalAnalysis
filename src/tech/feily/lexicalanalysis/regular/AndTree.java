/**
 * 
 */
package tech.feily.lexicalanalysis.regular;

/**
 * @author FeilyZhang
 *
 */
public class AndTree implements Tree {

    private TreeNode head;
    private TreeNode tail;

    public AndTree(Tree left, Tree right) {
        this.tail = new TreeNode(-1, null, null, null, null);
        left.setTail(right.getHead());
        this.head = left.getHead();
        this.tail = left.getTail();
    }

    @Override
    public TreeNode getHead() {
        return head;
    }
    public void setHead(TreeNode head) {
        this.head = head;
    }

    @Override
    public TreeNode getTail() {
        return tail;
    }
    public void setTail(TreeNode tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "[OrTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }
    
}
