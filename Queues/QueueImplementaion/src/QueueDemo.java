public class QueueDemo {
	public static void main(String[] args) {
		/*IQueue q = new CircularArrayQueue();
		q.enqueue("Tom");
		q.enqueue("Diana");
		q.enqueue("Harry");
		q.enqueue("Thomas");
		q.enqueue("Bob");
		q.enqueue("Brian");
		System.out.println(q.getFront());
		System.out.println(q.isEmpty() + " " + q.size());
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		System.out.println();
		System.out.println(q.isEmpty() + " " + q.size());
		System.out.println();*/

/*		IQueue queue = new Queue();
		queue.enqueue("Jonathan");
		queue.enqueue("Jemila");
		queue.enqueue("Mikkel");
		queue.enqueue("Tove");
		queue.enqueue("Jens");
		System.out.println(queue.getFront());
		System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
		while (!queue.isEmpty()) {
			System.out.println("Fjerner fra listen: " + queue.dequeue());
		}
		System.out.println();
		System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());
		queue.enqueue("Jonathan");
		queue.enqueue("Jemila");
		queue.enqueue("Mikkel");
		queue.enqueue("Tove");
		queue.enqueue("Jens");
		System.out.println(queue.getFront());
		while (!queue.isEmpty()) {
			System.out.println("Fjerner fra listen: " + queue.dequeue());
		}
		System.out.println();
		System.out.println(queue.isEmpty() + " | Antal elementer: " + queue.size());*/

		IQueue linkedlist = new QueueLinkedList();
		System.out.println(linkedlist.isEmpty() + " | Antal elementer: " + linkedlist.size());
		linkedlist.enqueue("Jonathan");
		linkedlist.enqueue("Jemmila");
		linkedlist.enqueue("Mikkel");
		linkedlist.enqueue("Tove");
		linkedlist.enqueue("Jens");
		System.out.println(linkedlist.getFront());
		System.out.println(linkedlist.isEmpty() + " | Antal elementer: " + linkedlist.size());
		while (!linkedlist.isEmpty()) {
			System.out.println("Fjerner fra listen: " + linkedlist.dequeue());
		}
		System.out.println(linkedlist.isEmpty() + " | Antal elementer: " + linkedlist.size());
		linkedlist.enqueue("Jonathan");
		linkedlist.enqueue("Jemmila");
		linkedlist.enqueue("Mikkel");
		linkedlist.enqueue("Tove");
		linkedlist.enqueue("Jens");
		System.out.println(linkedlist.getFront());
		while (!linkedlist.isEmpty()) {
			System.out.println("Fjerner fra listen: " + linkedlist.dequeue());
		}
	}
}