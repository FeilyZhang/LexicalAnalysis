package tech.feily.lexicalanalysis.regular;

public class SubExp {

    private String subExp;
    private int from;
    private int to;
    
    public SubExp(String subExp, int from ,int to) {
        this.subExp = subExp;
        this.from = from;
        this.to = to;
    }
    public String getSubExp() {
        return subExp;
    }
    public void setSubExp(String subExp) {
        this.subExp = subExp;
    }
    public int getFrom() {
        return from;
    }
    public void setFrom(int from) {
        this.from = from;
    }
    public int getTo() {
        return to;
    }
    public void setTo(int to) {
        this.to = to;
    }
    
    public String toString() {
        return "[SubExp]-subExp = " + subExp + ", from = " + from + ", to = " + to;
    }
}
