public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree2 = new BinaryTree<>("2");
        BinaryTree<String> binaryTree4 = new BinaryTree<>("4");

        BinaryTree<String> binaryTreePlus1 = new BinaryTree<>("+", binaryTree2, binaryTree4);
        BinaryTree<String> binaryTree7 = new BinaryTree<>("7");

        BinaryTree<String> binaryTreeVenstreGange = new BinaryTree<>("*", binaryTreePlus1, binaryTree7);

        BinaryTree<String> binaryTree3 = new BinaryTree<>("3");
        BinaryTree<String> binaryTree8 = new BinaryTree<>("8");

        BinaryTree<String> binaryTreeHøjrePlus = new BinaryTree<>("+", binaryTree3, binaryTree8);

        BinaryTree<String> root = new BinaryTree<>("+", binaryTreeVenstreGange, binaryTreeHøjrePlus);

        System.out.println("Expected: +" + "\nActual: " + root.data());
        System.out.println(root.countElements("+"));
        System.out.println();
        root.print();
        System.out.println();
        System.out.println(root.height());
        System.out.println();
        System.out.println();
        System.out.println(root.value());
    }
}
