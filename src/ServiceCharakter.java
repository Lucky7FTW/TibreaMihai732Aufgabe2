import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;


public class ServiceCharakter {
    private Repository<Charakter> charakterRepository;

    public ServiceCharakter(Repository<Charakter> charakterRepository) {
        this.charakterRepository = charakterRepository;
    }

    public List<Charakter> alleKundenZuruckgeben() {
        return charakterRepository.getAllElements();
    }

    public void createACharakter(String name, String ort){
        int id = -1;
        for (Charakter k : charakterRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charakterRepository.addElement(new Charakter(id,name,ort,new ArrayList<>()));
    }

    public Charakter getCharakter(int id){
        for (Charakter p : charakterRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Charakter nicht gefunden");
    }

    public void updateCharakter(Charakter kunde){
        for (Charakter p : charakterRepository.getAllElements()){
            if (p.getId() == kunde.getId()){
                int index = charakterRepository.getAllElements().indexOf(p);
                p.setName(kunde.getName());
                p.setOrt(kunde.getOrt());
                charakterRepository.updateElement(index,p);
                break;
            }
        }
    }

    public void deleteCharakter(int id){
        for (Charakter p : charakterRepository.getAllElements()){
            if (p.getId() == id){
                charakterRepository.remove(p);
                break;
            }
        }
    }



}
