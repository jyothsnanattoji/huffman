package HuffmanImplementaion;

import java.util.*;
import Run.TreeNode;

public interface huffmanInterface {
    public void generate(String msg);
    
    public Map<Character, Integer> characterFreq(String msg);
    
    Map<Character, String> huffmanCode = new HashMap<>();

    public void  generateTree(TreeNode root, String str, Map<Character, String> huffmancode);

    public StringBuilder encodeString(String msg);

    public StringBuilder decodeString(String msg);

}
