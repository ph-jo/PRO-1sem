import java.util.LinkedList;

public class Kannibal {

    private LinkedList<Person> personer;
    private int sizeOfStep;
    private int startIndex;

    public Kannibal() {
        this.personer = new LinkedList<>();
        this.sizeOfStep = 5;
        this.startIndex = 0;
    }

    public void addPerson(Person p) {
        personer.add(p);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < personer.size()) {
            if (startIndex + 5 > personer.size()) {
                sb.append(personer.get(startIndex-1));
                startIndex = (startIndex + sizeOfStep) % personer.size();
                i++;
            }
            else {
                sb.append(personer.get(startIndex-1));
                startIndex += sizeOfStep;
                i++;
            }
        }
        return sb.toString();
    }

    public void selectFirstPerson(int startIndex) {
        this.startIndex = startIndex;
    }
}
