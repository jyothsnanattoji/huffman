package HuffmanImplementaion;

import java.util.*;
import java.util.Map.Entry;
import Run.TreeNode;

public class EncodeDecodeImplementation implements huffmanInterface{

    public void generate(String msg)
    {
        
        HashMap<Character, Integer> charCountMap = characterFreq(msg);
        PriorityQueue<TreeNode> pq = new PriorityQueue<>();
        for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
            // add a leaf node of all the map values into the queue
            TreeNode temp = new TreeNode(entry.getKey(), entry.getValue());
            pq.add(temp);
        }
        // while there is more than 1 node left in the queue
        while (pq.size() > 1) {
            TreeNode left = pq.poll();
            TreeNode right = pq.poll();
            // compute the sum of the least freq 2 nodes
            int sum = left.count + right.count;
            TreeNode temp = new TreeNode(sum, left, right);
            // add the new node formed into the priority queue
            pq.add(temp);
        }
        // the node remaing is the root node
         TreeNode root = pq.peek();
        
         generateTree(root, "",  huffmanCode);

    }

    public HashMap<Character, Integer> characterFreq(String msg) {
        //generate character Frequency
        char[] chars = msg.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        // using a map to count and store the frequency of each character
        for (char c : chars) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    public void generateTree(TreeNode root, String str, Map<Character, String> huffmancode)
     {
        if (root == null)
        return;
        // checks if node is a leafnode
        if (root.left == null && root.right == null)
            huffmanCode.put(root.ch,  str );

        // add 0 to the left and 1 to the right if not leaf
        generateTree(root.left, str + "0", huffmanCode);
        generateTree(root.right, str + "1", huffmanCode);
    }

    @Override
    public StringBuilder encodeString(String msg) {
        char[] chars=msg.toCharArray();
        StringBuilder sb1=new StringBuilder();
        for (char c : chars) {
            sb1.append(huffmanCode.get(c));
        }
        return sb1;
    }

    @Override
    public StringBuilder decodeString(String msg) {
        StringBuilder sb2= new StringBuilder();
        StringBuilder sb1=new StringBuilder(msg);
         String temp = "";
         for (int i = 0; i < sb1.length(); i++) {
             temp += sb1.charAt(i);
             // System.out.println(sb1.charAt(i));
             if (huffmanCode.containsValue(temp)) {
                 for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
                     if (Objects.equals(entry.getValue(), temp)) {
                         sb2.append(entry.getKey());
                     }
                 }
                 temp = "";
             }
         }
         return sb2;
    }     
    
}
