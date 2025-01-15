import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private ControllerProdukt controller;
    private ControllerCharakter controller2;

    public Console(ControllerProdukt controller,ControllerCharakter controller2) {
        this.controller = controller;
        this.controller2= controller2;
    }
    public Console() {}

    public void setController(ControllerProdukt controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. 5 Produkte hinzufugen/Charakter hinzufungne
                    2. Produkt CRUD
                    3. Kunde CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {;
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Kunde hinzufugen
                            2. Alle Kunden sehen
                            3. Einen bestimmten Charkater finden
                            4. Einen Charkater aktualisieren
                            5. Einen Charkater loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller2.createCharakter(); break;}
                        case 2: {controller2.alleCharaktereAnschreiben(); break;}
                        case 3: {controller2.showCharakter(); break;}
                        case 4: {controller2.updateCharakter(); break;}
                        case 5: {controller2.deleteCharakter(); break;}
                        case 0:break;
                    }
                }
                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Charakter> charakterRepository = new Repository<>();
        Console console = new Console();

        console.initialiseData(charakterRepository,produktRepository);

        ServiceProdukt service = new ServiceProdukt(produktRepository);
        ServiceCharakter service2 = new ServiceCharakter(charakterRepository);
        ControllerProdukt controller = new ControllerProdukt(service);
        ControllerCharakter controller2 = new ControllerCharakter(service2);

        console = new Console(controller,controller2);
        console.run();
    }

    public void initialiseData(Repository<Charakter> charakterRepository,Repository<Produkt> produktRepository) {
        Produkt produkt1 = new Produkt("Salami", 20, "Klausenburg");
        Produkt produkt2 = new Produkt("Pizza", 200, "Bucharest");
        Produkt produkt3 = new Produkt("Auto", 100, "Muchen");
        Produkt produkt4 = new Produkt("Messer", 700, "Monaco");
        Produkt produkt5 = new Produkt("Farbstoff", 150, "Brasov");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);


        List<Produkt> listeKunde1 = new ArrayList<>();
        listeKunde1.add(produkt1); listeKunde1.add(produkt3); listeKunde1.add(produkt4);
        Charakter charakter1 = new Charakter(1,"Max","Rumanien",listeKunde1);

        List<Produkt> listeKunde2 = new ArrayList<>();
        listeKunde2.add(produkt2); listeKunde2.add(produkt3);
        Charakter charakter2 = new Charakter(2,"Ioana","Italien",listeKunde2);

        List<Produkt> listeKunde3 = new ArrayList<>();
        listeKunde3.add(produkt3); listeKunde3.add(produkt5);
        Charakter charakter3 = new Charakter(3,"Mark","Russland",listeKunde3);

        List<Produkt> listeKunde4 = new ArrayList<>();
        listeKunde3.add(produkt1); listeKunde3.add(produkt5);
        Charakter charakter4 = new Charakter(3,"Anita","Amerika",listeKunde4);

        charakterRepository.addElement(charakter1);
        charakterRepository.addElement(charakter2);
        charakterRepository.addElement(charakter3);
        charakterRepository.addElement(charakter4);
    }

}