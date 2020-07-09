package tech.feily.lexicalanalysis.nfa;

import java.util.Map;
import java.util.Set;

/**
 * 
 * @author FeilyZhang
 *
 */
public class DFAHolder {
    
    private Map<Integer, Map<Set<Integer>, Character>> seq;
    private Map<Map<Set<Integer>, Character>, Integer> afseq;
    private Map<Map<Set<Integer>, Character>, Set<Integer>> rst;
    
    public DFAHolder() {
        
    }
    
    public DFAHolder(Map<Integer, Map<Set<Integer>, Character>> seq, 
            Map<Map<Set<Integer>, Character>, Integer> afseq, 
            Map<Map<Set<Integer>, Character>, Set<Integer>> rst) {
        this.seq = seq;
        this.afseq = afseq;
        this.rst = rst;
    }
    
    public Map<Integer, Map<Set<Integer>, Character>> getSeq() {
        return seq;
    }
    public void setSeq(Map<Integer, Map<Set<Integer>, Character>> seq) {
        this.seq = seq;
    }

    public Map<Map<Set<Integer>, Character>, Integer> getAfseq() {
        return afseq;
    }
    public void setAfseq(Map<Map<Set<Integer>, Character>, Integer> afseq) {
        this.afseq = afseq;
    }
    
    public Map<Map<Set<Integer>, Character>, Set<Integer>> getRst() {
        return rst;
    }
    public void setRst(Map<Map<Set<Integer>, Character>, Set<Integer>> rst) {
        this.rst = rst;
    }
    
    @Override
    public String toString() {
        return "seq = " + seq.toString() + ", rst = " + rst.toString();
    }
    
}