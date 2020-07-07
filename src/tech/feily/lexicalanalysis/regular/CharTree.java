package tech.feily.lexicalanalysis.regular;

import java.util.Date;

/**
 * 
 * @author FeilyZhang
 *
 */
public class CharTree implements Tree {

    private TreeNode head;
    private TreeNode tail;
    
    public CharTree() {
        
    }
    public CharTree(Character c) {
        this.tail = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), null, null, null, null);
        this.head = new TreeNode(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()), c, null, this.tail, null);
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
        return "[CharTree]-head = " + head.toString() + ", tail = " + tail.toString();
    }

}
