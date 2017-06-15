import javafx.print.Printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Jona on 08-06-2017.
 */
public class Kamp implements Comparable<Kamp> {

    private String sted;
    private LocalDate dato;
    private LocalTime tid;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    public Deltagelse createDeltagelse() {
        Deltagelse deltagelse = new Deltagelse();
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

    public ArrayList<String> afbud() {
        ArrayList<String> afbud = new ArrayList<>();
        for (Deltagelse deltagelse : deltagelser) {
            if (deltagelse.isAfbud()) {
                String temp = deltagelse.getSpiller().getNavn() + " " + deltagelse.getBegrundelse();
                afbud.add(temp);
            }
        }
        return afbud;
    }

    public String toString() {
        return sted + " " + dato + " " + tid;
    }

    public int compareTo(Kamp kamp) {
        if (this.dato.isBefore(kamp.getDato())) {
            return -1;
        }
        else if (this.dato.isAfter(kamp.getDato())) {
            return 1;
        }
        else {
            if (this.tid.isBefore(kamp.getTid())) {
                return -1;
            }
            else if (this.tid.isAfter(kamp.getTid())) {
                return 1;
            }
            else {
                if (this.sted.compareTo(kamp.getSted()) < 0) {
                    return -1;
                }
                else if (this.sted.compareTo(kamp.getSted()) > 0) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }

    public void spillerHonorar(String tekstfil) {
        try {
            PrintWriter out = new PrintWriter("tekstfil");
            for (Deltagelse deltagelse : deltagelser) {
                if (!deltagelse.isAfbud()) {
                    String temp = deltagelse.getSpiller().getNavn() + " " + deltagelse.getSpiller().kampHonorar();
                    System.out.println(temp);
                    out.println(temp);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
