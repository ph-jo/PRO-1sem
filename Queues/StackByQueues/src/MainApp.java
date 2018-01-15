public class MainApp {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push("Jonathan");
        stack.push("Jemila");
        stack.push("Tove");
        stack.push("Jens");
        stack.push("Alexander");
        stack.push("Benjamin");
        System.out.println(stack.isEmpty() + " | Øverste element: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Fjerner fra stack: " + stack.pop());
        }
    }

}