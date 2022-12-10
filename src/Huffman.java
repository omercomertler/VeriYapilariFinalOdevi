

import java.util.PriorityQueue;
import java.util.Scanner;
public class Huffman {

	

		public static boolean isLetter(char c) {
		    return Character.isLetter(c);
		  }

		public static void printCode(HuffmanNode node, String s)
	    {
	 
	        if (node.left == null && node.right == null && isLetter(node.c)) {
	 
	            System.out.println(node.c + ":" + s);
	 
	            return;
	        }
	        printCode(node.left, s + "0");
	        printCode(node.right, s + "1");
	    }


		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			 
	        int n = 8;
	        char[] char_array = { 'A', 'B', 'C', 'D', 'E','F','G','H'};
	        int[] char_frequency = { 10,11,12,13,14,15,16,17 };
	 
	        
	        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());
	 
	        for (int i = 0; i < n; i++) {
	 
	            
	            HuffmanNode node = new HuffmanNode();
	 
	            node.c = char_array[i];
	            node.data = char_frequency[i];
	 
	            node.left = null;
	            node.right = null;
	 
	            
	            queue.add(node);
	        }
	        HuffmanNode root = null;
	        
	        
	        while (queue.size() > 1) {
	 
	            
	            HuffmanNode min_freq = queue.peek();
	            queue.poll();
	 
	            
	            HuffmanNode secondMin_freq = queue.peek();
	            queue.poll();
	 
	            
	            HuffmanNode f = new HuffmanNode();
	 
	            
	            f.data = min_freq.data + secondMin_freq.data;
	            f.c = '-';
	 
	            
	            f.left = min_freq;
	 
	            
	            f.right = secondMin_freq;
	 
	            
	            root = f;
	 
	            
	            queue.add(f);
	        }
	 
	        
	        printCode(root, "");

		}

	


	}

