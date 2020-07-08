package tech.feily.lexicalanalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import tech.feily.lexicalanalysis.regular.RegularExp;
import tech.feily.lexicalanalysis.regular.SubExp;
import tech.feily.lexicalanalysis.regular.TreeNode;

public class Main {
    static int i = 0, j = 0;
    public static void main(String[] args) throws ClassNotFoundException, IOException {/*
        Integer[][][] nfaTable = {
                {{1, 7}, {}, {}},
                {{2, 4}, {}, {}},
                {{}, {3}, {}},
                {{6}, {}, {}},
                {{}, {}, {5}},
                {{6}, {}, {}},
                {{1, 7}, {}, {}},
                {{}, {8}, {}},
                {{}, {}, {9}},
                {{}, {}, {}}
        };
        char[] inputChars = {'¦Å', 'a', 'b'};
        DFAHolder holder = new NFA(nfaTable, inputChars, inputChars[0]).toDFA();
        System.out.println(holder.getRst().toString());
        System.out.println("".length());*/
        //getSubExp("((a|b)a(a|(b|a)))(((a)))");
        //List<SubExp> ret = getSubExp("((a|b)a(a|(b|a)))(((a)))");
        /*
        String rst;
        while ((rst = getSubstr(ret.get(ret.size() - 1), ret)) != null) {
            System.out.println(rst);
        }*/
        //for (SubExp s : ret) {
          //  System.out.println(s.toString());
        //}
        char[] inputChars = {'¦Å', 'a', 'b'};//((a|(a|b))(ab))
        System.out.println(new RegularExp("(a|b)*ab", inputChars).buildTree().toString());
    }

//subExp.getFrom()
    public static String getSubstr(SubExp subExp, List<SubExp> subExps) {
        List<SubExp> copys = new LinkedList<>();
        copys.addAll(subExps);
        copys.remove(subExp);
        while (i != subExp.getTo() - subExp.getFrom() + 1) {
            while ( j != copys.size() - 1) {
                if (i + subExp.getFrom() == copys.get(j).getFrom()) {
                    i += copys.get(j).getTo() - copys.get(j).getFrom() + 1;
                    return copys.get(j).getSubExp();
                } else j++;
            }
            j = 0;
            return String.valueOf(subExp.getSubExp().charAt(i++));
        }
        return null;
    }
    
    public static List<SubExp> getSubExp(String exp) {
        int index = 0;
        List<SubExp> subExp = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        while (index < exp.length()) {
            if (exp.charAt(index) == '(') stack.push(index);
            else if (exp.charAt(index) == ')') {
                int start = stack.pop();
                SubExp sub = new SubExp(exp.substring(start, index + 1), start, index);
                subExp.add(sub);
            }
            index++;
        }
        subExp.add(new SubExp(exp, 0, exp.length() - 1));
        return subExp;
    }
    /*
    public static void getSubExp(String exp) {
        int seq = 65, index = 0;
        Map<String, String> subExp = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        while (index < exp.length()) {
            if (exp.charAt(index) == '(') stack.push(index);
            else if (exp.charAt(index) == ')') {
                int start = stack.pop();
                subExp.put(String.valueOf((char)seq), exp.substring(start, index + 1));
                exp = exp.substring(0, start) + String.valueOf((char)seq++) + exp.substring(index + 1, exp.length());
                index = start;
            }
            index++;
        }
        subExp.put(String.valueOf((char)seq), exp);
        System.out.println(subExp.toString());
    }
    */
    
}
