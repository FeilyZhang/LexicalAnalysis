package tech.feily.lexicalanalysis.regular;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author FeilyZhang
 *
 */
public class TreeNode implements Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = 725243500405488876L;
    private String val;
    private boolean isleft;
    private boolean isright;
    private Character leftRel;
    private Character rightRel;
    private TreeNode leftNode;
    private TreeNode rightNode;
    
    public TreeNode() {
        
    }
    
    public TreeNode(String val, 
            boolean isleft, boolean isright,
            Character leftRel, Character rightRel,
            TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.isleft = isleft;
        this.isright = isright;
        this.leftRel = leftRel;
        this.rightRel = rightRel;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
    
    
    public boolean isIsleft() {
        return isleft;
    }

    public void setIsleft(boolean isleft) {
        this.isleft = isleft;
    }

    public boolean isIsright() {
        return isright;
    }

    public void setIsright(boolean isright) {
        this.isright = isright;
    }

    public Character getLeftRel() {
        return leftRel;
    }
    public void setLeftRel(Character leftRel) {
        this.leftRel = leftRel;
    }
    
    public Character getRightRel() {
        return rightRel;
    }
    public void setRightRel(Character rightRel) {
        this.rightRel = rightRel;
    }
    
    public TreeNode getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
    
    public TreeNode getRightNode() {
        return rightNode;
    }
    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
    
    @Override
    public TreeNode clone() throws CloneNotSupportedException {
        return (TreeNode) super.clone();
    }
    public TreeNode deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (TreeNode)objectInputStream.readObject();
    }
    
    @Override
    public String toString() {
        String ls = "", rs = "";
        if (isleft) {
            ls += "{ val = " + leftNode.getVal() + "}";
        } else {
            if (leftNode != null) {
                ls += leftNode.toString();
            } else {
                ls += "nil";
            }
        }
        if (isright) {
            rs += "{ val = " + rightNode.getVal() + "}";
        } else {
            if (rightNode != null) {
                rs += rightNode.toString();
            } else {
                rs += "nil";
            }
        }
        return "{[TreeNode]-val = " + val + ", leftRel = " + leftRel + ", rightRel = " + rightRel + 
                ", leftNode = " + ls + ", rightNode = " + rs + "}";
    }
    
}
