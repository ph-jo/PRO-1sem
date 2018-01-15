import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<String> navneListe = new ArrayList<>();
        navneListe.add("Holme");
        navneListe.add("Skåde");
        navneListe.add("Viby");
        navneListe.add("Beder");
        navneListe.add("Stautrup");
        navneListe.add("Engdal");
        navneListe.add("Forældreskolen");
        navneListe.add("Malling");

        SearchableList<String> searchableList = new SearchableList<>(navneListe);
        System.out.println("Findes Malling i listen? " + searchableList.search("Malling"));
        System.out.println("Findes Riisskov i listen? " + searchableList.search("Riisskov"));

        String[] navneListen = new String[]{"Holme", "Skåde", "Viby", "Beder",
                                            "Stautrup", "Engdal", "Forældreskolen",
                                                        "Malling"};
        SearchableArray<String> searchableArray = new SearchableArray<>(navneListen);
        System.out.println("Findes Malling i listen? " + searchableArray.search("Malling"));
        System.out.println("Findes Riisskov i listen? " + searchableArray.search("Riisskov"));

        SearchableArrayBin<String> searchableArrayBin = new SearchableArrayBin<>(navneListen);
        System.out.println("Findes Malling i listen? " + searchableArrayBin.search("Malling"));
        System.out.println("Findes Riisskov i listen? " + searchableArrayBin.search("Riisskov"));
    }
}
