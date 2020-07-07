package tech.feily.lexicalanalysis.regular;

/**
 * 
 * @author FeilyZhang
 *
 */
public class TreeNode {

    private String val;
    private Character leftRel;
    private Character rightRel;
    private TreeNode leftNode;
    private TreeNode rightNode;
    
    public TreeNode() {
        
    }
    
    public TreeNode(String val, 
            Character leftRel, Character rightRel,
            TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
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
    public String toString() {
        String ls = leftNode != null ? leftNode.toString() : "nil";
        String rs = rightNode != null ? rightNode.toString() : "nil";
        return "{[TreeNode]-val = " + val + ", leftRel = " + leftRel + ", rightRel = " + rightRel + 
                ", leftNode = " + ls + ", rightNode = " + rs + "}";
    }
    
}
