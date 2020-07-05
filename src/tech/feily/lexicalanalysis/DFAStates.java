package tech.feily.lexicalanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author FeilyZhang
 *
 */
public class DFAStates {

	private static Map<Set<Integer>, Boolean> states = new HashMap<>();
	
	public static Set<Integer> isExistUnMarked() {
		for (Set<Integer> key : states.keySet()) {
			if (!states.get(key)) {
				states.put(key, true);
				return key;
			}
		}
		return null;
	}
	
	public static void push(Set<Integer> key) {
		states.put(key, false);
	}
	
	public static boolean contains(Set<Integer> key) {
		return states.containsKey(key);
	}
	
	public static Map<Set<Integer>, Boolean> getStates() {
		return states;
	}
	
}
