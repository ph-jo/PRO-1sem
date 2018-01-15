public class MainApp {

    public static void main(String[] args) {
        SortedDoublyLinkedList linkedList = new SortedDoublyLinkedList();
        linkedList.addElement("Jonathan");
        linkedList.addElement("Anders");
        linkedList.addElement("Peter");
        linkedList.addElement("Mikkel");
        linkedList.addElement("Jemila");
        linkedList.addElement("Oliver");
        linkedList.addElement("Søren");
        linkedList.addElement("Asbjørn");
        linkedList.addElement("Henrik");
        System.out.println("Størrelsen af linked list: " + linkedList.countElements());
        System.out.println(linkedList.toString());
        System.out.println(linkedList.removeElement("Jonathan"));
        System.out.println(linkedList.toString());
        System.out.println(linkedList.removeElement("Søren"));
        System.out.println(linkedList.toString());
        System.out.println(linkedList.removeElement("Oliver"));
        System.out.println(linkedList.toString());
        System.out.println(linkedList.removeElement("Anders"));
        System.out.println(linkedList.removeElement("Asbjørn"));
        System.out.println("Størrelsen af linked list: " + linkedList.countElements());
        System.out.println(linkedList);
        System.out.println(linkedList.removeElement("Henrik"));
        System.out.println(linkedList.removeElement("Mikkel"));
        System.out.println(linkedList);
        System.out.println(linkedList.removeElement("Peter"));
        System.out.println(linkedList);
        System.out.println(linkedList.removeElement("Jemila"));
        System.out.println("Størrelsen af linked list: " + linkedList.countElements());

        linkedList.addElement("Jonathan");
        linkedList.addElement("Anders");
        linkedList.addElement("Peter");
        linkedList.addElement("Mikkel");
        linkedList.addElement("Jemila");
        linkedList.addElement("Oliver");
        linkedList.addElement("Søren");
        linkedList.addElement("Asbjørn");
        linkedList.addElement("Henrik");

        System.out.println(linkedList);

        System.out.println("Fjerner første element: " + linkedList.removeFirst());
        System.out.println();
        System.out.println("Linked list after removing the first element: ");
        System.out.println(linkedList.toString());

        System.out.println();
        linkedList.addElement("Alexander");
        System.out.println("Linked list after insertion of Alexander: ");
        System.out.println(linkedList.toString());
        System.out.println();

        while (linkedList.countElements() != 0) {
            System.out.println(linkedList.removeFirst());
        }

        System.out.println("\nEfter slettelsen: " + linkedList.toString() + " og størrelsen er: " + linkedList.countElements());

        System.out.println();
        System.out.println();
        linkedList.addElement("Jonathan");
        linkedList.addElement("Anders");
        linkedList.addElement("Peter");
        linkedList.addElement("Mikkel");
        linkedList.addElement("Jemila");
        linkedList.addElement("Oliver");
        linkedList.addElement("Søren");
        linkedList.addElement("Asbjørn");
        linkedList.addElement("Henrik");

        System.out.println(linkedList);

        System.out.println();
        System.out.println("Removing last element: " + linkedList.removeLast());
        System.out.println("Linked list after removing the last element: ");
        System.out.println(linkedList.toString());

        System.out.println();
        while (linkedList.countElements() != 0) {
            System.out.println(linkedList.removeLast());
        }
        System.out.println();
        System.out.println("\nEfter slettelsen: " + linkedList.toString() + " og størrelsen er: " + linkedList.countElements());
    }
}
