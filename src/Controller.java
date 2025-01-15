import model.Produkt;

import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben(){
        for (Produkt produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }

    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunftsregion");
        String herkunftsregion = sc.nextLine();

        service.createAProdukt(name, preis, herkunftsregion);
    }

    public void showAProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkt produkt = service.getProdukt(name);
        System.out.println(produkt);
    }


    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunftsregion:");
        String herkunftsregion = sc.nextLine();

        service.updateProdukt(new Produkt(name, preis, herkunftsregion));
    }

    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }


}
