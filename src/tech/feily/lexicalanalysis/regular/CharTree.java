package tech.feily.lexicalanalysis.regular;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author FeilyZhang
 *
 */
public class CharTree implements Tree, Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = 3638266968310333754L;
    private TreeNode head;
    private TreeNode tail;
    
    public CharTree() {
        
    }
    public CharTree(Character c) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, null, null, null, null);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), false, false, c, null, this.tail, null);
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
    public CharTree clone() throws CloneNotSupportedException {
        return (CharTree) super.clone();
    }
    public CharTree deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (CharTree)objectInputStream.readObject();
    }
    @Override
    public String toString() {
        return "[CharTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }

}
