package personAdministratorPackage;

import java.util.Set;
import java.util.TreeSet;

public class PersonAdministrator {

    private Set<Person> personSet;
    private static PersonAdministrator padmin;

    private PersonAdministrator() {
        personSet = new TreeSet<>();
    }

    public static PersonAdministrator getPadmin() {
        if (padmin == null) {
            padmin = new PersonAdministrator();
        }
        return padmin;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void addPerson(Person p) {
        personSet.add(p);
    }

    public void removePerson(Person p) {
        personSet.remove(p);
    }
}
