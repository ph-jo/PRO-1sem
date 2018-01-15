public class DictionaryDemo {

	public static void main(String[] args) {
		Dictionary dictionary = new DictionaryLinked();
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		dictionary.put(8, "Hans");
		dictionary.put(3, "Viggo");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.get(8));

		dictionary.put(7, "Bent");
		dictionary.put(2, "Lene");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());
		System.out.println(dictionary.remove(3));

		System.out.println(dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println(dictionary.get(8));

		System.out.println(dictionary.remove(8));
		System.out.println(dictionary.get(8));
		System.out.println(dictionary.get(3));
		System.out.println(dictionary.get(2));
		System.out.println(dictionary.put(8, "Jonathan"));
		System.out.println(dictionary.put(8, "Jemila"));
		System.out.println(dictionary.get(8));
		System.out.println(dictionary.remove(8));
		System.out.println(dictionary.get(8));
		System.out.println(dictionary.isEmpty() + " | Antal elementer " +
				"i listen " + dictionary.size());
		System.out.println(dictionary.remove(7) + " og " + dictionary.remove(2));
		System.out.println(dictionary.isEmpty() + " | Antal elementer " +
				"i listen " + dictionary.size());
	}
	
}
