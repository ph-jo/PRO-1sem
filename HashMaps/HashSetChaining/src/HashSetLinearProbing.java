/**
 * This class implements a hash set using an array and linear probing to handle collisions.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private enum State { DELETED }

	/**
	 * Constructs a hash table.
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 * @param x an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
	    int h = hashValue(x);
	    int i = 1;
	    while (i < buckets.length) {
            if (buckets[h] != null && buckets[h] != State.DELETED && buckets[h].equals(x)) {
                return true;
            }
            else {
                h = (h + i) % buckets.length;
                i++;
            }
        }
		return false;
	}

	/**
	 * Adds an element to this set.
	 * @param x an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
        int h = hashValue(x);
        int i = 1;
		rehash();
        while (i < buckets.length) {
            if (buckets[h] == null || buckets[h] == State.DELETED) {
            	buckets[h] = x;
                currentSize++;
                return true;
            } else {
                h = (h + i) % buckets.length;
                i++;
            }
        }
        return false;
    }

	/**
	 * Removes an object from this set.
	 * @param x an object
	 * @return true if x was removed from this set, false if x was not an element of this set
	 */
	public boolean remove(Object x) {
	    if (!contains(x)) return false;
	    int h = hashValue(x);
	    int i = 1;

	    while (i < buckets.length) {
	        if (buckets[h].equals(x)) {
	            buckets[h] = State.DELETED;
	            currentSize--;
	            return true;
            }
            else {
	            h = (h + i) % buckets.length;
	            i++;
            }
        }
        return false;
	}

	/**
	 * Gets the number of elements in this set.
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	public void rehash() {
		if (currentSize / buckets.length > 0.75) {
			Object[] newBuckets = new Object[2 * buckets.length];
			for (int i = 0; i < buckets.length - 1; i++) {
				int h = buckets[i].hashCode();
				if (h < 0) {
					h = -h;
				}
				h = h % newBuckets.length;
				newBuckets[h] = buckets[i];
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

	@Override
	public String toString() {
		String result = "";
	    for (int i = 0; i < buckets.length; i++) {
	        int value = buckets[i] != null && !buckets[i].equals(State.DELETED) ? 
	                hashValue(buckets[i]) : -1;
			result += i + "\t" + buckets[i] + "(h:" + value + ")\n";
		}
	    return result;
	}

}
