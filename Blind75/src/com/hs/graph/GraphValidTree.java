package com.hs.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		List<Set<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new HashSet<>());
		}

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		while (!queue.isEmpty()) {
			int curNode = queue.remove();

			// found loop
			if (visited[curNode]) {
				return false;
			}

			visited[curNode] = true;

			for (int nextNode : adjList.get(curNode)) {
				queue.add(nextNode);
				adjList.get(nextNode).remove(curNode);
			}
		}

		for (boolean e : visited) {
			if (!e) {
				return false;
			}
		}
		return true;
	}
}
