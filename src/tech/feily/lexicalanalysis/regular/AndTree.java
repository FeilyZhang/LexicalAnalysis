/**
 * 
 */
package tech.feily.lexicalanalysis.regular;

/**
 * @author FeilyZhang
 *
 */
public class AndTree implements Tree {

    private TreeNode head = new TreeNode();
    private TreeNode tail = new TreeNode();;
    
    public AndTree(Tree left, Tree right) {
        this.head = left.getHead();
        TreeNode node = left.getTail();
        node.setLeftNode(right.getHead().getLeftNode());
        node.setLeftRel(right.getHead().getLeftRel());
        node.setRightNode(right.getHead().getRightNode());
        node.setRightRel(right.getHead().getRightRel());
        node.setVal(right.getHead().getVal());
        left.setTail(node);
        this.tail = right.getTail();
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
        return "{[AndTree]-head = " + head.toString() + ", tail = " + tail.toString() + "}";
    }
    
}
