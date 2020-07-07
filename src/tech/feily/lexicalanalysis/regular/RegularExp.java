package tech.feily.lexicalanalysis.regular;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegularExp {

    private String pattern;
    private char[] inputChars;
    private int start = 0;
    
    public RegularExp(String pattern) {
        this.pattern = pattern;
    }
    
    public Tree buildTree() {
        Tree tree = null;
        boolean initial = false;
        Map<Character, CharTree> map = initializeCharTree(inputChars);
        while (pattern.length() != 0) {
            Character c = getChar(pattern);
            if (c != '|' && c != '*') {
                if (!initial) {
                    initial = true;
                    tree = map.get(c);
                }
                else {
                    Tree temp = map.get(c);
                    tree = new AndTree(tree, temp);
                }
            } else if (c == '|') {
                Tree temp = map.get(getChar(pattern));
                tree = new OrTree(tree, temp);
            } else if (c == '*') tree = new ClosureTree(tree);
        }
        return tree;
    }

    public Character getChar(String str) {
        for (; start < str.length(); start++) {
            if (str.charAt(start) != '(' && str.charAt(start) != ')') return str.charAt(start);
        }
        return null;
    }


    public List<String> getSubExp(String exp) {
        int index = 0;
        List<String> subExp = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        while (index < exp.length()) {
            if (exp.charAt(index) == '(') stack.push(index);
            else if (exp.charAt(index) == ')') {
                int start = stack.pop();
                subExp.add(exp.substring(start, index + 1));
            }
            index++;
        }
        subExp.add(exp);
        return subExp;
    }
    
    
    private Map<Character, CharTree> initializeCharTree(char[] cs) {
        Map<Character, CharTree> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], new CharTree(cs[i]));
        }
        return map;
    }
    
}
