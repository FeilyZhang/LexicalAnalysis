package tech.feily.lexicalanalysis.regular;

public class ClosureTree implements Tree {

    private TreeNode head;
    private TreeNode tail;

    public ClosureTree(TreeNode node) {
        this.head = node;
        this.tail = node;
    }
    public ClosureTree(Tree right) {
        this.tail = new TreeNode(-1, null, null, null, null);
        this.head = new TreeNode(-1, '��', '��', this.tail, right.getHead());
        right.getTail().setLeftNode(this.tail);
        right.getTail().setLeftRel('��');
        right.getTail().setRightNode(right.getHead());
        right.getTail().setRightRel('��');
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
        return "[ClosureTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }
    
}
