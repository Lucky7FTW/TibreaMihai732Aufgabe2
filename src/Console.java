import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. 5 Produkte hinzufugen
                    2. Produkt CRUD
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
                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Console console = new Console();

        console.initialiseData(produktRepository);

        Service service = new Service(produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Produkt> produktRepository) {
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
    }

}