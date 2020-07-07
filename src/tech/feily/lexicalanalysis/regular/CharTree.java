package tech.feily.lexicalanalysis.regular;

/**
 * 
 * @author FeilyZhang
 *
 */
public class CharTree implements Tree {

    private TreeNode head;
    private TreeNode tail;
    
    public CharTree() {
        
    }
    public CharTree(Character c) {
        this.tail = new TreeNode(-1, null, null, null, null);
        this.head = new TreeNode(0, c, null, this.tail, null);
    }

    @Override
    public TreeNode getHead() {
        return head;
    }
    @Override
    public void setHead(TreeNode head) {
        this.head = head;
    }

    @Override
    public TreeNode getTail() {
        return tail;
    }
    @Override
    public void setTail(TreeNode tail) {
        this.tail = tail;
    }
    
    @Override
    public String toString() {
        return "[CharTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }

}
