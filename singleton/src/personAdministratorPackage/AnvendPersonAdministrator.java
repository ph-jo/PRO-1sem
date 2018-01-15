package personAdministratorPackage;

public class AnvendPersonAdministrator {

    public static void main(String[] args) {
        PersonAdministrator padmin = PersonAdministrator.getPadmin();
        System.out.println(padmin.getPersonSet());
        Person person = new Person("Jonathan");
        padmin.addPerson(person);
    }

}