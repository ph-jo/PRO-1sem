public class Indkoeber implements Observer {

    private String navn;

    public Indkoeber(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        Bogtitel bogtitel = (Bogtitel) s;
        if (bogtitel.getAntal() < 6) {
            System.out.println("10x " + bogtitel.getTitel() + " bestilles nu hjem.");
            bogtitel.indkoebTillager(10);
        }
    }
}
