public class MainApp {

    public static void main(String[] args) {
        MainDictionary<Integer, String> dno = new MainDictionary<>();
        System.out.println(dno.put(1, "Jonathan"));
        System.out.println(dno.put(2, "Lars"));
        System.out.println(dno.put(2, "Lort"));
        System.out.println(dno.size());
        System.out.println(dno.remove(2));
        System.out.println(dno.size());
        System.out.println(dno.remove(1));
        System.out.println(dno.size());
    }
}
