public class MainApp {

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
        queue.enqueue("Jonathan");
        queue.enqueue("Jemila");
        queue.enqueue("Anders");
        queue.enqueue("Oliver");
        queue.enqueue("Mikkel");
        queue.enqueue("Peder");
        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
        while (!queue.isEmpty()) {
            System.out.println("Fjerner: " + queue.dequeue());
        }
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
        queue.enqueue("Jonathan");
        queue.enqueue("Jemila");
        queue.enqueue("Anders");
        queue.enqueue("Oliver");
        queue.enqueue("Mikkel");
        queue.enqueue("Peder");
        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
        queue.enqueue("Søren");
        System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
    }
}
