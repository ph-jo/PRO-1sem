public class MainApp {

    public static void main(String[] args) {
        // Testning af ArrayStack

/*        ArrayStack stack = new ArrayStack();
        System.out.println(stack.isEmpty());
        stack.push("Jonathan");
        System.out.println(stack.peek());
        stack.push("Anders");
        System.out.println(stack.peek());
        stack.push("Alexander");
        System.out.println(stack.peek());
        stack.push("Jens");
        System.out.println(stack.peek());
        stack.push("Tove");
        System.out.println(stack.peek());
        stack.push("Jemila");
        System.out.println(stack.peek());
        stack.push("Mikkel");
        System.out.println(stack.peek());
        stack.push("Alexanderv2");
        System.out.println(stack.peek());
        stack.push("Benjamin");
        System.out.println(stack.peek());
        stack.push("Søren");
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Removes: " + stack.pop());*/

        // Testning af DROPOUT-stack

        /*DropOutStack dstack = new DropOutStack();
        System.out.println(dstack.isEmpty());
        dstack.push("Jonathan");
        System.out.println(dstack.peek());
        dstack.push("Mikkel");
        System.out.println(dstack.peek());
        dstack.push("Jonathan");
        System.out.println(dstack.peek());
        dstack.push("Mikkel");
        System.out.println(dstack.peek());
        dstack.push("Jonathan");
        System.out.println(dstack.peek());
        dstack.push("Mikkel");
        System.out.println(dstack.peek());
        dstack.push("Jonathan");
        System.out.println(dstack.peek());
        System.out.println();
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.isEmpty());*/

        // Testning af LINKEDLIST DROPOUT-stack
        DropOutStackLinkedList linkedList = new DropOutStackLinkedList();
        /*System.out.println("Tjekker om listen er tom: " + linkedList.isEmpty());
        linkedList.push("Jonathan");
        System.out.println("Tjekker om listen er tom: " + linkedList.isEmpty());
        linkedList.push("Mikkel");
        System.out.println("Kigger på sidste element: " + linkedList.peek());
        System.out.println("Popper fra listen: " + linkedList.pop());
        System.out.println("Popper fra listen: " + linkedList.pop());
        System.out.println("Tjekker om listen er tom: " + linkedList.isEmpty());*/
        System.out.println("Tilføjer 6 til listen");
        linkedList.push("Jonathan");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jemila");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jonathan");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jemila");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jonathan");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jemila");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Tjekker om linkedlist er tom: " + linkedList.isEmpty());
        System.out.println("Tilføjer 6 elementer til listen: ");
        linkedList.push("Jonathan");
        linkedList.push("Mikkel");
        linkedList.push("Anders");
        linkedList.push("Søren");
        linkedList.push("Henrik");
        linkedList.push("Oliver");
        System.out.println("\n\nPeeker første element i linkedlist: " + linkedList.peek());
        linkedList.push("Jens");
        System.out.println("Peeker første element i linkedlist: " + linkedList.peek());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Fjerner: " + linkedList.pop());
        System.out.println("Tjekker om linkedlist er tom: " + linkedList.isEmpty());
    }
}