import java.util.NoSuchElementException;

/**
 * This class implements a binary search tree whose nodes hold objects that
 * implement the Comparable interface.
 */
public class BinarySearchTree<E extends Comparable<E>> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Inserts a new node into the tree.
	 * 
	 * @param obj
	 *            the object to insert
	 */
	public void add(E obj) {
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
	}

	/**
	 * Tries to find an object in the tree.
	 * 
	 * @param obj
	 *            the object to find
	 * @return true if the object is contained in the tree
	 */
	public boolean find(E obj) {
		Node current = root;
		boolean found = false;
		while (current != null && found == false) {
			int d = current.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return found;
	}

	public E findMax() {
		return findMax(root);
	}

	private E findMax(Node n) {
		if (n == null || n.right == null) {
			return n.data;
		}
		else {
			E max;
			max = findMax(n.right);
			return max;
		}
	}

	public E removeMin() {
		if (root == null) throw new NoSuchElementException();

		Node current = root;
		if (current.left != null) {
			while (current.left.left != null) {
				current = current.left;
			}
			if (current.left.right != null) {
				E temp = current.left.data;
				current.left = current.left.right;
				return temp;
			}
			else {
				E temp = current.left.data;
				current.left = null;
				return temp;
			}
		}
		else if (current.right != null) {
			E temp = root.data;
			root = current.right;
			return temp;
		}
		else {
			E temp = root.data;
			root = null;
			return temp;
		}
	}

	/**
	 * Tries to remove an object from the tree. Does nothing if the object is
	 * not contained in the tree.
	 * 
	 * @param obj
	 *            the object to remove
	 */
	public void remove(E obj) {
		// Find node to be removed
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else {
				parent = toBeRemoved;
				if (d > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}

		if (found) {
			// toBeRemoved contains obj
			// If one of the children is empty, use the other
			if (toBeRemoved.left == null || toBeRemoved.right == null) {
				Node newChild;
				if (toBeRemoved.left == null) {
					newChild = toBeRemoved.right;
				} else {
					newChild = toBeRemoved.left;
				}

				if (parent == null) {
					// Found in root
					root = newChild;
				} else if (parent.left == toBeRemoved) {
					parent.left = newChild;
				} else {
					parent.right = newChild;
				}

			} else {
				// Neither subtree is empty
				// Find smallest element of the right subtree
				Node smallestParent = toBeRemoved;
				Node smallest = toBeRemoved.right;
				while (smallest.left != null) {
					smallestParent = smallest;
					smallest = smallest.left;
				}

				// Smallest contains smallest child in right subtree
				// Move contents, unlink child
				toBeRemoved.data = smallest.data;
				if (smallestParent == toBeRemoved) {
					smallestParent.right = smallest.right;
				} else {
					smallestParent.left = smallest.right;
				}
			}
		}
	}

	/**
	 * Prints the contents of the tree in sorted order.
	 */
	public void print() {
		print(root);
		System.out.println();
	}

	/**
	 * Prints a node and all of its descendants in sorted order.
	 * 
	 * @param parent
	 *            the root of the subtree to print
	 */
	private void print(Node parent) {
		if (parent != null) {
			print(parent.left);
			System.out.print(parent.data + " ");
			print(parent.right);
		}
	}

	/**
	 * A node of a tree stores a data item and references to the left and right
	 * child nodes.
	 */
	private class Node {
		private E data;
		private Node left;
		private Node right;

		/**
		 * Inserts a new node as a descendant of this node.
		 * 
		 * @param newNode
		 *            the node to insert
		 */
		private void addNode(Node newNode) {
			int comp = newNode.data.compareTo(data);
			if (comp < 0) {
				if (left == null) {
					left = newNode;
				} else {
					left.addNode(newNode);
				}
			} else if (comp > 0) {
				if (right == null) {
					right = newNode;
				} else {
					right.addNode(newNode);
				}
			}
		}
	}
}
