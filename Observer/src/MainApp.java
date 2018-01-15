public class MainApp {

    public static void main(String[] args) {
        Saelger hansen = new Saelger("Hansen");

        Kunde læsehest1 = new Kunde("Læsehest1");
        Kunde læsehest2 = new Kunde("Læsehest2");
        Kunde læsehest3 = new Kunde("Læstehest3");

        Indkoeber jensen = new Indkoeber("Jensen");

        Bogtitel andersAnd = new Bogtitel("Anders And", 6);
        Bogtitel java = new Bogtitel("Java", 8);

        andersAnd.addObserver(hansen);
        andersAnd.addObserver(jensen);
        java.addObserver(jensen);

        java.etKoeb(læsehest1);
        java.etKoeb(læsehest2);
        java.etKoeb(læsehest3);
        andersAnd.etKoeb(læsehest1);
        andersAnd.etKoeb(læsehest2);
        andersAnd.etKoeb(læsehest3);
    }

}
