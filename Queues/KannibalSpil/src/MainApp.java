public class MainApp {

    public static void main(String[] args) {
        Kannibal kannibalSpil = new Kannibal();

        kannibalSpil.addPerson(new Person("Jonathan"));
        kannibalSpil.addPerson(new Person("Mikkel"));
        kannibalSpil.addPerson(new Person("Asbjørn"));
        kannibalSpil.addPerson(new Person("Søren"));
        kannibalSpil.addPerson(new Person("Henrik"));
        kannibalSpil.addPerson(new Person("Lasse"));
        kannibalSpil.addPerson(new Person("Anders"));
        kannibalSpil.addPerson(new Person("Jens"));
        kannibalSpil.addPerson(new Person("Alexander"));

        kannibalSpil.selectFirstPerson(4);
        System.out.println(kannibalSpil.toString());
    }

}
