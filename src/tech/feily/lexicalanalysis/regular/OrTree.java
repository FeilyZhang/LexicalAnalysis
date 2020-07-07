package tech.feily.lexicalanalysis.regular;

public class OrTree implements Tree {
    
    private TreeNode head;
    private TreeNode tail;

    public OrTree(Tree left, Tree right) {
        this.tail = new TreeNode(-1, null, null, null, null);
        left.setTail(this.tail);
        right.setTail(this.tail);
        this.head = new TreeNode(0, '¦Å', '¦Å', left.getHead(), right.getHead());
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
        return "[OrTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }
    
}
