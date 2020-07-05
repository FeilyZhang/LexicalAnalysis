package tech.feily.lexicalanalysis;

public class DFATest {

    public static void main(String[] args) {
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
    }

}
