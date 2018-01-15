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
	 *
	 * @param rootData the new data for the root
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
		BinaryTree<E> newTree = new BinaryTree<>(rootData);
		E oldData = data();
		root = newTree.root;
		return oldData;
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
		else {
			int sum;
			sum = size(n.left) + size(n.right);
			return 1 + sum;
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

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.left);
			System.out.println(n.data);
			printInOrder(n.right);
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node n) {
		if (n != null) {
			System.out.println(n.data);
			printPreOrder(n.left);
			printPreOrder(n.right);
		}
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node n) {
		if (n != null) {
			printPostOrder(n.left);
			printPostOrder(n.right);
			System.out.println(n.data);
		}
	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node n) {
		if (n == null) return 0;
		else {
			int sumLeft, sumRight;
			sumLeft = sum(n.left);
			sumRight = sum(n.right);
			return (Integer) n.data + sumLeft + sumRight;
		}
	}

	public int avg() {
		return sum(root) / size(root);
	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
}
