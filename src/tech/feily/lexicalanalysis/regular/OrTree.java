package tech.feily.lexicalanalysis.regular;

import java.util.Date;

public class OrTree implements Tree {
    
    private TreeNode head;
    private TreeNode tail;

    public OrTree(Tree left, Tree right) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), null, null, null, null);
        left.getTail().setLeftRel('¦Å');
        left.getTail().setLeftNode(this.tail);
        right.getTail().setRightRel('¦Å');
        right.getTail().setLeftNode(this.tail);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), '¦Å', '¦Å', left.getHead(), right.getHead());
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
