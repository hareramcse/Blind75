package com.hs.tree;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(Node s, Node t) {
		if (s == null)
			return false;
		if (isSameTree(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(Node p, Node q) {
		if (p == null || q == null)
			return p == q;
		return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
