/**
 * 
 */
package tech.feily.lexicalanalysis.regular;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author FeilyZhang
 *
 */
public class AndTree implements Tree, Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = -1625571569180509074L;
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
    public AndTree clone() throws CloneNotSupportedException {
        return (AndTree) super.clone();
    }
    public AndTree deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (AndTree)objectInputStream.readObject();
    }
    @Override
    public String toString() {
        return "{[AndTree]-head = " + head.toString() + ", tail = " + tail.toString() + "}";
    }
    
}
