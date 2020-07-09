package tech.feily.lexicalanalysis.regular;

import java.io.IOException;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Constructing NFA from regular expression.
 * 
 * @author FeilyZhang
 * @since 1.0.1
 * @version 1.0.1
 */
public class RegularExp {

    private int i = 0, j = 0;
    private String pattern;
    private char[] inputChars;
    
    public RegularExp(String pattern, char[] inputChars) {
        this.pattern = pattern;
        this.inputChars = inputChars;
    }
    
    public Tree buildTree() throws ClassNotFoundException, IOException {
        Map<String, Tree> ard = new HashMap<>();
        ard.putAll(initializeCharTree(inputChars));
        List<SubExp> ret = getSubExp(pattern);
        for (SubExp r : ret) {
            Tree treeTemp = null;
            String all = "", part = "";
            boolean isor = false, isini = false;
            while ((part = getSubstr(r, ret, ret.get(ret.size() - 1))) != null) {
                if (part.equals("(")) {
                    all += part;
                } else if (part.equals(")")) {
                    all += part;
                } else if (part.equals("|")) {
                    isor = true;
                    all += part;
                } else if (part.equals("*")) {
                    treeTemp = new ClosureTree(treeTemp);
                    all += part;
                } else if (part.length() == 1 && !isini) {
                    treeTemp = depthFirst(ard.get(part).deepClone());
                    isini = true;
                    all += part;
                } else if (part.length() > 1 && !isini) {
                    treeTemp = depthFirst(ard.get(part).deepClone());
                    isini = true;
                    all += part;
                } else if (isor) {
                    treeTemp = new OrTree(treeTemp, depthFirst(ard.get(part).deepClone()));
                    isor = false;
                    all += part;
                } else {
                    treeTemp = new AndTree(treeTemp, depthFirst(ard.get(part).deepClone()));
                    all += part;
                }
            }
            ard.put(all, treeTemp);
        }
        return ard.get(pattern);
    }

    private Tree depthFirst(Tree tree) {
        TreeNode root = tree.getHead();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.setVal(String.valueOf(new Date().getTime()) + String.valueOf(Math.random()));
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
        }
        return tree;
    }
    
    private String getSubstr(SubExp subExp, List<SubExp> subExps, SubExp pattern) {
        List<SubExp> copys = new LinkedList<>();
        copys.addAll(subExps);
        copys.remove(subExp);
        copys.remove(pattern);
        while (i != subExp.getTo() - subExp.getFrom() + 1) {
            while (j != copys.size()) {
                if (i + subExp.getFrom() == copys.get(j).getFrom()) {
                    i += copys.get(j).getTo() - copys.get(j).getFrom() + 1;
                    String ret = copys.get(j).getSubExp();
                    j = 0;
                    return ret;
                } else j++;
            }
            j = 0;
            return String.valueOf(subExp.getSubExp().charAt(i++));
        }
        i = 0;
        return null;
    }
    
    private List<SubExp> getSubExp(String exp) {
        int index = 0;
        List<SubExp> subExp = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        while (index < exp.length()) {
            if (exp.charAt(index) == '(') stack.push(index);
            else if (exp.charAt(index) == ')') {
                int start = stack.pop();
                SubExp sub = new SubExp(exp.substring(start, index + 1), start, index);
                addEleToList(sub, subExp);
            }
            index++;
        }
        addEleToList(new SubExp(exp, 0, exp.length() - 1), subExp);
        return subExp;
    }
    
    private void addEleToList(SubExp exp, List<SubExp> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSubExp().equals(exp.getSubExp())) {
                return;
            }
        }
        list.add(exp);
    }
    
    private Map<String, Tree> initializeCharTree(char[] cs) {
        Map<String, Tree> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            map.put(String.valueOf(cs[i]), new CharTree(cs[i]));
        }
        return map;
    }
    
}
