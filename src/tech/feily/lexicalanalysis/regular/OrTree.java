package tech.feily.lexicalanalysis.regular;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class OrTree implements Tree, Serializable, Cloneable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3217410647805235781L;
    private TreeNode head;
    private TreeNode tail;

    public OrTree(Tree left, Tree right) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, null, null, null, null);
        left.getTail().setLeftRel('¦Å');
        left.getTail().setLeftNode(this.tail);
        right.getTail().setRightRel('¦Å');
        right.getTail().setLeftNode(this.tail);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, '¦Å', '¦Å', left.getHead(), right.getHead());
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
    public OrTree clone() throws CloneNotSupportedException {
        return (OrTree) super.clone();
    }
    public OrTree deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (OrTree)objectInputStream.readObject();
    }
    
    @Override
    public String toString() {
        return "[OrTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }
    
}
