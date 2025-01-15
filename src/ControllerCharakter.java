import model.Charakter;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCharakter {

    private final ServiceCharakter service;

    public ControllerCharakter(ServiceCharakter service) {
        this.service = service;
    }

    public void alleCharaktereAnschreiben(){
        for (Charakter charakter: service.alleKundenZuruckgeben())
            System.out.println(charakter);
    }

    public void createCharakter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();

        service.createACharakter(name,ort);
    }

    public void showCharakter(){
        for (Charakter charakter: service.alleKundenZuruckgeben())
            System.out.println(charakter);

        System.out.println("ID des Charakters:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getCharakter(id));
    }

    public void updateCharakter(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Charakters, der geupdated werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Charakter charakter = new Charakter(id,name,ort,new ArrayList<>());
        service.updateCharakter(charakter);
    }

    public void deleteCharakter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Charakter, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteCharakter(id);
    }



}
