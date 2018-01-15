public class Navn implements Comparable<Navn> {

    private String fornavn;
    private String efternavn;

    public Navn(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    @Override
    public String toString() {
        return "Navn{" +
                "fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                '}';
    }

    @Override
    public int compareTo(Navn o) {
        if (this.fornavn.compareTo(o.fornavn) == 0) {
            return 0;
        }
        else if(this.fornavn.compareTo(o.fornavn) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
