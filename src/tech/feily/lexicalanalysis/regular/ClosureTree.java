package tech.feily.lexicalanalysis.regular;

import java.util.Date;

public class ClosureTree implements Tree {

    private TreeNode head;
    private TreeNode tail;

    public ClosureTree(TreeNode node) {
        this.head = node;
        this.tail = node;
    }
    public ClosureTree(Tree right) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), null, null, null, null);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), '¦Å', '¦Å', this.tail, right.getHead());
        TreeNode node = right.getTail();
        node.setLeftNode(this.tail);
        node.setLeftRel('¦Å');
        node.setRightNode(right.getHead());
        node.setRightRel('¦Å');
        right.setTail(node);/*
        right.getTail().setLeftNode(this.tail);
        right.getTail().setLeftRel('¦Å');
        right.getTail().setRightNode(right.getHead());
        right.getTail().setRightRel('¦Å');*/
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
