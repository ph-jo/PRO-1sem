import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> unionSet = new HashSet<>();
		for (T element : s1) {
			unionSet.add(element);
		}
		for (T element : s2) {
			unionSet.add(element);
		}
		return unionSet;
	}

	public static <T> Set<T> union2(Set<T> s1, Set<T> s2) {
		Set<T> unionSet = new HashSet<>();
		unionSet.addAll(s1);
		unionSet.addAll(s2);
		return unionSet;
	}

	public static <T> Set<T> differens(Set<T> s1, Set<T> s2) {
		Set<T> differenceSet = new HashSet<>();
		for (T element : s1) {
			if (!s2.contains(element)) {
				differenceSet.add(element);
			}
		}
		return differenceSet;

	}

	public static <T> Set<T> intesection(Set<T> s1, Set<T> s2) {
		Set<T> intersectionSet = new HashSet<>();
		for (T element : s1) {
			if (s2.contains(element)) {
				intersectionSet.add(element);
			}
		}
		return intersectionSet;
	}
}