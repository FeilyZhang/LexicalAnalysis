import java.util.Map;
import java.util.Set;

/**
 * 
 * @author FeilyZhang
 *
 */
public class DFAHolder {
	
	private Map<Map<Set<Integer>, Character>, Integer> seq;
	private Map<Map<Set<Integer>, Character>, Set<Integer>> rst;
	
	public DFAHolder() {
		
	}
	
	public DFAHolder(Map<Map<Set<Integer>, Character>, Integer> seq, 
			Map<Map<Set<Integer>, Character>, Set<Integer>> rst) {
		this.seq = seq;
		this.rst = rst;
	}
	
	public Map<Map<Set<Integer>, Character>, Integer> getSeq() {
		return seq;
	}
	public void setSeq(Map<Map<Set<Integer>, Character>, Integer> seq) {
		this.seq = seq;
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