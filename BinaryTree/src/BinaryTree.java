/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 */
	public BinaryTree(E rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 * @param rootData the data for the root
	 * @param left the left subtree
	 * @param right the right subtree
	 */
	public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
		root = new Node();
		root.data = rootData;
		if (left != null) {
			root.left = left.root;
		}
		if (right != null) {
			root.right = right.root;
		}
	}

	/**
	 * Checks whether this tree is empty.
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Gets the data at the root of this tree.
	 * @return the root data
	 */
	public E data() {
		return root.data;
	}

	/**
	 * Gets the left subtree of this tree.
	 * @return the left child of the root
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.right;
		return result;
	}

	/**
	 * Replace the root data with some new data
	 * @param newData the new data for the root
	 * @return the data in the root before replacement
	 */
	public E replace(E newData) {
		E oldData = this.root.data;
		this.root.data = newData;
		return oldData;
	}

	public int countElements(E element) {
		return countElements(element, root);
	}

	private int countElements(E element, Node n) {
		if (n == null) return 0;
		else if (n.data.equals(element)) {
			return 1 + countElements(element, n.left) + countElements(element, n.right);
		}
		else return countElements(element, n.left) + countElements(element, n.right);
	}

	public int value() {
		return value(root);
	}

	private int value(Node n) {
		if (n == null) {
			return 0;
		}
		else if (!n.data.equals("+") && !n.data.equals("*")) {
			return Integer.parseInt((String) n.data);
		}
		else {
			if (n.data.equals("+")) {
				return value(n.left) + value(n.right);
			}
			else {
				return value(n.left) * value(n.right);
			}
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node n) {
		if (n == null) return 0;
		else {
			int sum;
			sum = Math.max(height(n.left), height(n.right));
			return 1 + sum;
		}
	}

	public void print() {
		print(root);
	}

	private void print(Node n) {
		if (n != null) {
			print(n.left);
			System.out.println(n.data);
			print(n.right);
		}
	}

	/**
	 * The size of the tree
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	// Private recursive helper method
	private int size(Node n) {
	    if (n == null) return 0;
		return 1 + size(n.left) + size(n.right);
	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
}
