package tech.feily.lexicalanalysis.nfa;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author FeilyZhang
 *
 */
public class NFA {
    
    private Integer[][][] nfaTable;
    private char[] inputChars;
    private Set<Integer> initStates;
    private char nil;
    private int num;

    public NFA(Integer[][][] nfaTable, char[] inputChars, char nil) {
        this.nfaTable = nfaTable;
        this.inputChars = inputChars;
        this.nil = nil;
        this.num = 65;
        this.initStates = new HashSet<>();
    }
    
    public DFAHolder toDFA() {
        initializeStates();
        Map<Integer, Map<Set<Integer>, Character>> seq = new HashMap<>();
        Map<Map<Set<Integer>, Character>, Integer> afseq = new HashMap<>();
        Map<Map<Set<Integer>, Character>, Set<Integer>> rst = new HashMap<>();
        DFAStates.push(initStates);
        Set<Integer> ret = DFAStates.isExistUnMarked();
        while (ret != null) {
            for (char c : inputChars) {
                Set<Integer> states = calClosure(move(ret, c));
                if (!DFAStates.contains(states)) DFAStates.push(states);
                Map<Set<Integer>, Character> key = new HashMap<>();
                key.put(ret, c);
                rst.put(key, states);
                seq.put(num, key);
                afseq.put(key, num++);
            }
            ret = DFAStates.isExistUnMarked();
        }
        return new DFAHolder(seq, afseq, rst);
    }
    
    public Set<Integer> move(Set<Integer> set, char c) {
        Set<Integer> rst = new HashSet<>();
        int index = 0;
        Integer[] rows = new Integer[set.size()];
        for (Integer s : set) {
            rows[index++] = s;
        }
        for (int i = 0; i < rows.length; i++) {
            Integer[] ret = nfaTable[rows[i]][map(c)];
            if (ret.length != 0) {
                addArrToSet(ret, rst);
            }
        }
        return rst;
    }
    
    /**
     * This method is used to initialize initial states of DFA.
     */
    private void initializeStates() {
        Deque<Integer> stack = new LinkedList<>();
        initStates.add(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer[] ret = nfaTable[stack.pop()][map(nil)];
            if (ret.length != 0) addArrToStackAndSet(ret, stack, initStates);
        }
    }
    
    /**
     * This method provides a mapping from a character to an index.
     * 
     * @param c
     * @return
     */
    private Integer map(char c) {
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] == c) return i;
        }
        return -1;
    }
    
    /**
     * This method is used to calculate the non initial state set of DFA.
     * 
     * @param seed This parameter is used to initialize state set.
     * @return The result of state set obtained by calculation.
     */
    public Set<Integer> calClosure(Set<Integer> seed) {
        Set<Integer> rst = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        addArrToStackAndSet(seed, stack, rst);
        while (!stack.isEmpty()) {
            Integer[] ret1 = nfaTable[stack.pop()][map(nil)];
            if (ret1.length != 0) addArrToStackAndSet(ret1, stack, rst);
        }
        return rst;
    }

    private <T> void addArrToSet(T[] arr, Set<T> set) {
        for (T t : arr) {
            set.add(t);
        }
    }
    
    private <T> void addArrToStackAndSet(Set<T> arr, Deque<T> deque, Set<T> set) {
        for (T t : arr) {
            deque.push(t);
            set.add(t);
        }
    }
    
    private <T> void addArrToStackAndSet(T[] arr, Deque<T> deque, Set<T> set) {
        for (T t : arr) {
            deque.push(t);
            set.add(t);
        }
    }
    
}
