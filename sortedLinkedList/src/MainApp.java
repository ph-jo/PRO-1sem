public class MainApp {

    public static void main(String[] args) {
        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        sortedLinkedList.addElement("Jonathan");
        sortedLinkedList.addElement("Anders");
        sortedLinkedList.addElement("Peter");
        sortedLinkedList.addElement("Mikkel");
        sortedLinkedList.addElement("Jemila");
        sortedLinkedList.addElement("Oliver");
        sortedLinkedList.addElement("Søren");
        sortedLinkedList.addElement("Asbjørn");
        sortedLinkedList.addElement("Henrik");
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Oliver"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Anders"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Asbjørn"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Jemila"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Jonathan"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Peter"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Mikkel"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Søren"));
        System.out.println(sortedLinkedList);
        System.out.println("Størrelsen på listen er: " + sortedLinkedList.countElements());
        System.out.println(sortedLinkedList.removeElement("Henrik"));
    }
}