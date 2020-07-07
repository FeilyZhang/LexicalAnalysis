package tech.feily.lexicalanalysis.regular;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegularExp {

    private int i = 0, j = 0;
    private boolean flag = false;
    private String pattern;
    private char[] inputChars;
    
    public RegularExp(String pattern, char[] inputChars) {
        this.pattern = pattern;
        this.inputChars = inputChars;
    }
    
    public Tree buildTree() {
        boolean isOr = false;
        boolean isClosure = false;
        boolean isInitial = false;
        String mark = "";
        Map<String, Tree> st = new HashMap<>();
        Deque<String> stack = new LinkedList<>();
        st.putAll(initializeCharTree(inputChars));
        List<SubExp> ret = getSubExp(pattern);
        for (SubExp s : ret) {
            System.out.println(s.getSubExp() + " " + s.getFrom() + " " + s.getTo());
        }
        System.out.println(ret.toString());
        for (SubExp r : ret) {
            String temp;
            Tree tempTree = null;System.out.println("all = " + r.getSubExp());
            while ((temp = getSubstr(r, ret, ret.get(ret.size() - 1))) != null) {
                System.out.println("next = " + temp);
                if (temp.equals("(")) {
                    stack.push(temp);System.out.println(" stack   " + stack.toString());
                } else if (temp.equals(")")) {
                    System.out.println("mark1 = " + mark + temp);
                    mark = stack.pop() + mark + temp;
                    System.out.println("mark = " + mark);
                    st.put(mark, tempTree);
                } else if (temp.equals("|")) {
                    isOr = true;
                    mark += temp;
                } else if (temp.equals("*")) {
                    isClosure = true;
                    mark += temp;
                } else {
                    if (temp.length() == 1 && !isInitial) {
                        tempTree = st.get(temp);System.out.println(tempTree.toString());
                        isInitial = true;
                    } else if (temp.length() > 1 && !isInitial) {
                        tempTree = st.get(temp);System.out.println(tempTree.toString());
                        isInitial = true;
                    } else if (isOr) {
                        tempTree = new OrTree(tempTree, st.get(temp));System.out.println(tempTree.toString());
                        isOr = false;
                    } else if (isClosure) {
                        tempTree = new ClosureTree(st.get(temp));System.out.println(tempTree.toString());
                        isClosure = false;
                    } /*else if (temp.length() > 1 && !isInitial) {
                        tempTree = st.get(temp);System.out.println(tempTree.toString());
                        isInitial = true;
                    }*/ else {
                        System.out.println("(ab)" + st.get("(ab)"));
                        tempTree = new AndTree(tempTree, st.get(temp));System.out.println(tempTree.toString());
                    }
                    mark += temp;
                    System.out.println(mark);
                }
            }
            mark = "";
            isInitial = false;
            st.put(r.getSubExp(), tempTree);
        }
        for (String s : st.keySet()) {
            System.out.println(s + " = " + st.get(s));
        }
        return st.get(pattern);
    }

    public String getSubstr(SubExp subExp, List<SubExp> subExps, SubExp pattern) {
        /*
        if (subExps.size() == 1) {
            while (i < subExp.getSubExp().length()) {
                return String.valueOf(subExp.getSubExp().charAt(i++));
            }
        } else if (subExps.size() == 2) {
            while (i < subExps.get(0).getSubExp().length() && !flag) {
                flag = true;System.out.println("enter");
                return String.valueOf(subExp.getSubExp().charAt(i++));
            }
        } else {
            List<SubExp> copys = new LinkedList<>();
            copys.addAll(subExps);
            copys.remove(subExp);
            while (i != subExp.getTo() - subExp.getFrom() + 1) {
                while (j != copys.size()) {
                    if (i == copys.get(j).getFrom()) {
                        i += copys.get(j).getTo() - copys.get(j).getFrom() + 1;
                        return copys.get(j).getSubExp();
                    } else j++;
                }
                j = 0;
                return String.valueOf(subExp.getSubExp().charAt(i++));
            }/*
            while (i != subExp.getTo() - subExp.getFrom() + 1) {
                while ( j != copys.size() - 1) {
                    if (i + subExp.getFrom() == copys.get(j).getFrom()) {
                        i += copys.get(j).getTo() - copys.get(j).getFrom() + 1;
                        return copys.get(j).getSubExp();
                    } else j++;
                }
                j = 0;
                return String.valueOf(subExp.getSubExp().charAt(i++));
            }*/
        /*}
        i = 0;
        flag = false;
        return null;*/
        List<SubExp> copys = new LinkedList<>();
        copys.addAll(subExps);
        copys.remove(subExp);
        copys.remove(pattern);
        while (i != subExp.getTo() - subExp.getFrom() + 1) {
            while (j != copys.size()) {
                //System.out.println(copys.toString());
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
    
    public List<SubExp> getSubExp(String exp) {
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
    
    public void addEleToList(SubExp exp, List<SubExp> list) {
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
