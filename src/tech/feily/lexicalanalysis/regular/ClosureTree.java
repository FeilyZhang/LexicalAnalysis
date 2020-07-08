package tech.feily.lexicalanalysis.regular;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ClosureTree implements Tree, Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = 6633720429720137747L;
    private TreeNode head;
    private TreeNode tail;

    public ClosureTree(TreeNode node) {
        this.head = node;
        this.tail = node;
    }
    public ClosureTree(Tree right) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, null, null, null, null);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, '¦Å', '¦Å', this.tail, right.getHead());
        TreeNode node = right.getTail();
        node.setLeftNode(this.tail);
        node.setLeftRel('¦Å');
        node.setRightNode(right.getHead());
        node.setRightRel('¦Å');
        node.setIsright(true);
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
    public ClosureTree clone() throws CloneNotSupportedException {
        return (ClosureTree) super.clone();
    }
    public ClosureTree deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (ClosureTree)objectInputStream.readObject();
    }
    @Override
    public String toString() {
        return "[ClosureTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }
    
}
