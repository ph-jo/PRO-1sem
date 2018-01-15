public class BinaryTreeIntegerDemo {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree15 = new BinaryTree<>(15);

        BinaryTree<Integer> binaryTree11 = new BinaryTree<>(11, null, binaryTree15);

        BinaryTree<Integer> binaryTree25 = new BinaryTree<>(25);

        BinaryTree<Integer> binaryTree30 = new BinaryTree<>(30, binaryTree25, null);

        BinaryTree<Integer> binaryTree22 = new BinaryTree<>(22, binaryTree11, binaryTree30);

        BinaryTree<Integer> binaryTree88 = new BinaryTree<>(88);

        BinaryTree<Integer> binaryTree90 = new BinaryTree<>(90, binaryTree88, null);

        BinaryTree<Integer> binaryTree77 = new BinaryTree<>(77, null, binaryTree90);

        BinaryTree<Integer> binaryTree45 = new BinaryTree<>(45, binaryTree22, binaryTree77);

        System.out.println(binaryTree45.size());
        System.out.println(binaryTree45.data());
        System.out.println(binaryTree45.height());
        System.out.println();
        binaryTree45.printInOrder();
        System.out.println();
        binaryTree45.printPreOrder();
        System.out.println();
        binaryTree45.printPostOrder();
        System.out.println();
        System.out.println(binaryTree45.sum());
        System.out.println();
        System.out.println(binaryTree45.avg());
    }
}
