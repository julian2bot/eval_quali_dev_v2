package fr.univ_orleans.iut45.menus;

import java.util.ArrayList;
import java.util.List;
import java.io.Reader;

import com.google.gson.Gson;

class Menu {
    protected List<Plat> entrees;
    protected List<Plat> plats_principaux;
    protected List<Plat> desserts;

    public Menu(List<Plat> entrees,
                List<Plat> plats_principaux,
                List<Plat> desserts) {
        this.entrees = entrees;
        this.plats_principaux = plats_principaux;
        this.desserts = desserts;
    }

    public List<Plat> getEntrees() {
        return this.entrees;
    }

    public List<Plat> getPlatsPrincipaux() {
        return this.plats_principaux;
    }

    public List<Plat> getDesserts() {
        return this.desserts;
    }

    public static Menu fromJson(Reader r) {
        Gson gson = new Gson();
        return gson.fromJson(r, Menu.class);
    }
    public boolean estComplet() {
        if (this.entrees.size() == 0 || this.plats_principaux.size() == 0 || this.desserts.size() == 0)
            return false;
        return true;
    }
    public boolean contientDeLaViande() {
        for (int i=0 ; i < this.plats_principaux.size() ; i++) {
            if (this.plats_principaux.get(i).contientViande()) {}
                return true;

        }
        return false;
    }


    public boolean contientPasDAlergene(String alergene) {
        for (int i=0 ; i < this.plats_principaux.size() ; i++) {
                if (this.plats_principaux.get(i).getListAlergene().contains(alergene))
                    return false;
        }
        for (int j=0 ; j < this.plats_principaux.size() ; j++) {
            if (this.plats_principaux.get(j).getListAlergene().contains(alergene))
                return false;
        }
        for (int k=0 ; k < this.plats_principaux.size() ; k++) {
            if (this.plats_principaux.get(k).getListAlergene().contains(alergene))
                return false;
        }
        return true;

        }

    public List<String> quelAlergene() {
        List<String> lesAlergene = new ArrayList<>();
        for (int i=0 ; i < this.plats_principaux.size() ; i++) {
            lesAlergene.add(this.plats_principaux.get(i).getListAlergene());

    for (int j=0 ; j < this.plats_principaux.size() ; j++) {
        lesAlergene.add(this.plats_principaux.get(j).getListAlergene());

    }
    for (int k=0 ; k < this.plats_principaux.size() ; k++) {
        lesAlergene.add(this.plats_principaux.get(k).getListAlergene());

    }
    return lesAlergene;

    }
}
