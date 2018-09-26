package javacodes;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {

	
	public static void main(String[] args) {
		ArrayList<Integer> tree = new ArrayList<Integer>();
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(2);
		tree.add(5);
		
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int[] visited = new int[tree.size()];
		
		for (int value : tree) {
			System.out.println(value);
			q.add(value);
			
		}
		
		
	}
	
}
