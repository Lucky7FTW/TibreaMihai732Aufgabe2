package model;

public class Produkt {
    String name;

    int preis;

    String Herkunftsregion;

    public Produkt(String name, int preis, String herkunftsregion) {
        this.name = name;
        this.preis = preis;
        this.Herkunftsregion = herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getHerkunftsregion() {
        return Herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        Herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkte{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", Herkunftsregion='" + Herkunftsregion + '\'' +
                '}';
    }
}
