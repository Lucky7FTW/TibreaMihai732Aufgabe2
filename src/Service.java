import model.Produkt;

import java.util.List;

public class Service {
    private Repository<Produkt> produktRepository;

    public Service(Repository<Produkt> produktRepository) {
        this.produktRepository = produktRepository;
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name,int preis, String jahreszeit){
        produktRepository.addElement(new Produkt(name,preis,jahreszeit));
    }

    public Produkt getProdukt(String name){
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkt produkt){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setHerkunftsregion(produkt.getHerkunftsregion());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }




}
