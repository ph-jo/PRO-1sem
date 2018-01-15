/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
    private Node[] buckets;
    private int currentSize;

    private class Node {
        public Object data;
        public Node next;
    }

    /**
     * Constructs a hash table.
     * @param bucketsLength the length of the buckets array
     */
    public HashSetChaining(int size) {
        buckets = new Node[size];
        currentSize = 0;
    }

    /**
     * Tests for set membership.
     * @param x an object
     * @return true if x is an element of this set
     */
    public boolean contains(Object x) {
        int h = hashValue(x);
        Node bucket = buckets[h];
        boolean found = false;
        while (!found && bucket != null) {
            if (bucket.data.equals(x)) {
                found = true;
            } else {
                bucket = bucket.next;
            }
        }
        return found;
    }

    /**
     * Adds an element to this set.
     * @param x an object
     * @return true if x is a new object, false if x was already in the set
     */
    public boolean add(Object x) {
        int h = hashValue(x);
        Node bucket = buckets[h];
        boolean found = false;
        while (!found && bucket != null) {
            if (bucket.data.equals(x)) {
                found = true;
            } else {
                bucket = bucket.next;
            }
        }
        
        if (!found) {
            rehash();
            Node newNode = new Node();
            newNode.data = x;
            newNode.next = buckets[h];
            buckets[h] = newNode;
            currentSize++;
        }

        return !found;
    }

    /**
     * Removes an object from this set.
     * @param x an object
     * @return true if x was removed from this set, false if x was not an element of this set
     */
    public boolean remove(Object x) {
        int h = hashValue(x);
        if (!contains(x)) return false;

        Node before = null;
        Node now = buckets[h];

        while (now.next != null && now.data != x) {
            before = now;
            now = now.next;
        }

        if (now.data == x) {
            if (before == null) {
                buckets[h] = now.next;
                currentSize--;
                return true;
            }
            else {
                before.next = now.next;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    public void rehash() {
        if (currentSize / buckets.length > 0.75) {
            Node[] newBuckets = new Node[buckets.length * 2];
            for (int i = 0; i < buckets.length - 1; i++) {
                if (buckets[i] != null) {
                    int h = buckets[i].hashCode();
                    if (h < 0) {
                        h = -h;
                    }
                    h = h % newBuckets.length;
                    newBuckets[h] = buckets[i];
                }
            }
            buckets = newBuckets;
        }
    }

    private int hashValue(Object x) {
        int h = x.hashCode();
        if (h < 0) {
            h = -h;
        }
        h = h % buckets.length;
        return h;
    }

    /**
     * Gets the number of elements in this set.
     * @return the number of elements
     */
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < buckets.length; i++) {
            Node temp = buckets[i];
            if (temp != null) {
                result += i + "\t";
                while (temp != null) {
                    result += temp.data + " (h:" + hashValue(temp.data) + ")\t";
                    temp = temp.next;
                }
                result += "\n";
            }
        }
        return result;
    }

}
