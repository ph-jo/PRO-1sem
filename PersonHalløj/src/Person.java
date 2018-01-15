public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {

    private T navn;

    public Person(T navn) {
        this.navn = navn;
    }

    public T getNavn() {
        return navn;
    }

    public void setNavn(T navn) {
        this.navn = navn;
    }

    @Override
    public int compareTo(Person<T> o) {
        if (this.navn.compareTo(o.navn) == 0) {
            return 0;
        }
        else if (this.navn.compareTo(o.navn) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "navn=" + navn +
                '}';
    }
}
