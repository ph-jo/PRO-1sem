import java.util.NoSuchElementException;

public class SortedDoublyLinkedList {

    private class Node {
        public String data;
        public Node next;
        public Node previous;
    }

    private Node first;
    private Node last;

    public SortedDoublyLinkedList() {
        Node sentinelFirst = new Node();
        Node sentinelLast = new Node();
        sentinelFirst.previous = null;
        sentinelFirst.next = sentinelLast;
        sentinelLast.previous = sentinelFirst;
        sentinelLast.next = null;
        this.first = sentinelFirst;
        this.last = sentinelLast;
    }

    public void addElement(String element) {
        Node newNode = new Node();
        newNode.data = element;

        if (first.next == last || element.compareToIgnoreCase(first.next.data) < 0) {
            newNode.next = first.next;
            newNode.previous = first;
            first.next = newNode;
        }
        else {
            Node current = first.next, before = null;
            while (current.next != last && current.next != null && element.compareToIgnoreCase(current.data) > 0) {
                before = current;
                current = current.next;
            }
            if (element.compareToIgnoreCase(current.data) < 0) {
                newNode.previous = before;
                newNode.next = current;
                current.previous = newNode;
                before.next = newNode;
            }
            else {
                newNode.previous = current;
                newNode.next = last;
                current.next = newNode;
                last.previous = newNode;
            }
        }
    }

    public boolean removeElement(String element) {
        if (first.next == last) throw new NoSuchElementException();

        if (first.next.data == element) {
            if (first.next.next == last) {
                first.next = last;
                last.previous = first;
                return true;
            } else {
                first.next = first.next.next;
                first.next.next.previous = first.next;
                return true;
            }
        }

        Node current = first.next, before = null;
        while (current.next != last && current.data != element) {
            before = current;
            current = current.next;
        }
        if (current.data == element) {
            before.next = current.next;
            current.next.previous = before;
            return true;
        }
        return false;
    }

    public String removeFirst() {
        if (first.next == last) throw new NoSuchElementException();

        if (first.next.next == last) {
            String returnasdsadad = first.next.data;
            first.next = last;
            last.previous = first;
            return returnasdsadad;
        }
        else {
            String returnasdnasd = first.next.data;
            first.next.next.previous = first.next.next;
            first.next = first.next.next;
            return returnasdnasd;
        }
    }

    public String removeLast() {
        if (first.next == last) throw new NoSuchElementException();

        if (first.next.next == last) {
            String returnerdetherlort = first.next.data;
            first.next = last;
            last.previous = first;
            return returnerdetherlort;
        }
        else {
            String returneringstid = last.previous.data;
            last.previous = last.previous.previous;
            last.previous.next = last;
            return returneringstid;
        }

    }

    public int countElements() {
        Node currentPosition = first.next;
        int counter = 0;
        while (currentPosition.data != null) {
            currentPosition = currentPosition.next;
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first.next;
        while (current.data != null) {
            sb.append(current.data + " ");
            current = current.next;
        }

        return sb.toString();
    }
}