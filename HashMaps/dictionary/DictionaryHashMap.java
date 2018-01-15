import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap implements Dictionary {

	private Map<Object, Object>[] tabel;
	private int N = 10;

	/**
	 * HashingMap constructor comment.
	 */
	public DictionaryHashMap() {
		tabel = new HashMap[N];
		for (int i = 0; i < N; i++) {
			tabel[i] = new HashMap<Object, Object>();
		}
	}

	@Override
	public Object get(Object key) {
		int i = key.hashCode() % N;
		Map<Object, Object> map = tabel[i];
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		return empty;
	}

	@Override
	public Object put(Object key, Object value) {
		int i = key.hashCode() % N;
		Map<Object, Object> map = tabel[i];
		if (map.get(key) != null) {
			return map.replace(key, value);
		}
		map.put(key, value);
		return null;
	}

	@Override
	public Object remove(Object key) {
		int i = key.hashCode() % N;
		Map<Object, Object> map = tabel[i];
		if (map.get(key) != null) {
			return map.remove(key);
		}
		return null;
	}

	@Override
	public int size() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += tabel[i].size();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append("Tabel["+ i +"] " + tabel[i] + "\n");
		}
		return sb.toString();
	}
}
