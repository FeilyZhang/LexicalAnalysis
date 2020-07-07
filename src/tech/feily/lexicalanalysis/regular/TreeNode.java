package tech.feily.lexicalanalysis.regular;

/**
 * 
 * @author FeilyZhang
 *
 */
public class TreeNode {

    private Integer val;
    private Character leftRel;
    private Character rightRel;
    private TreeNode leftNode;
    private TreeNode rightNode;
    
    public TreeNode(Integer val, 
            Character leftRel, Character rightRel,
            TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.leftRel = leftRel;
        this.rightRel = rightRel;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    
    public Integer getVal() {
        return val;
    }
    public void setVal(Integer val) {
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
        return "val = " + val + ", leftRel = " + leftRel + ", rightRel = " + rightRel + 
                ", leftNode = " + leftNode.toString() + ", rightNode = " + rightNode.toString();
    }
    
}
