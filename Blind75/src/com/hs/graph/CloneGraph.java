package com.hs.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new ArrayDeque<>();

		queue.add(node);
		map.put(node, new Node(node.val, new ArrayList<>()));
		while (!queue.isEmpty()) {
			Node h = queue.poll();

			for (Node neighbor : h.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
					queue.add(neighbor);
				}
				map.get(h).neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}