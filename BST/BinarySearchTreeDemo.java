public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(45);
        binarySearchTree.add(22);
        binarySearchTree.add(77);
        binarySearchTree.add(11);
        binarySearchTree.add(30);
        binarySearchTree.add(77);
        binarySearchTree.add(90);
        binarySearchTree.add(88);
        binarySearchTree.add(15);
        binarySearchTree.add(25);

        binarySearchTree.print();
        System.out.println("Finder maksimum: " + binarySearchTree.findMax());
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
        System.out.println("Removes: " + binarySearchTree.removeMin());
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
        binarySearchTree.print();
        System.out.println("Removes: " + binarySearchTree.removeMin());
    }

}
