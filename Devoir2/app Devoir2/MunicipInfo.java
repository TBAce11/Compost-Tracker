import java.util.ArrayList; // import the ArrayList class

public class MunicipInfo {
    ArrayList<Consomateur> tabConsomateur = new ArrayList<Consomateur>(); 

    public MunicipInfo () {
        tabConsomateur.add(new Consomateur (10, "Consomateur10","a","a", "a", 456, "activites", "aaa", "capacite"));
        tabConsomateur.add(new Consomateur (11, "Consomateur11","a","b", "b", 456, "activites", "aaa", "capacite"));
        tabConsomateur.add(new Consomateur (12, "Consomateur12","a","c", "c", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (13, "Consomateur13","a","d", "d", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (14, "Consomateur14","a","e", "e", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (15, "Consomateur15","a","f", "f", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (16, "Consomateur16","a","g", "g", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (17, "Consomateur17","a","h", "h", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (18, "Consomateur18","a","i", "i", 456, "activites", "TypeDechet", "capacite"));
        tabConsomateur.add(new Consomateur (19, "Consomateur19","a","j", "j", 456, "activites", "TypeDechet", "capacite"));
    }


    public ArrayList<Consomateur> ListConsomateur() {
        return tabConsomateur;
    } 
    public void addConsomateur(Consomateur newCons) {
        tabConsomateur.add(newCons);
    } 

    //liste de tout les bac
    ArrayList<Bac> Bac = new ArrayList<Bac>(); 
    //ajoute un bac a la liste des bac
    public void addBac(Bac newBac) {
        Bac.add(newBac);
    } 

    //chercher bac avec id
    public Bac IndexBac(int SerchId){
        for (int i = 0; i < Bac.size(); i++) {
            Bac serchBac=Bac.get(i);
            if (SerchId==serchBac.getid()){
                return serchBac;
            }
            
        }
        return (null);
    } 
    //Chercher par Type
    public ArrayList<Consomateur> chercherParType(String type){
        Consomateur serchConsomateur;
        ArrayList<Consomateur> filtreConsomateurs = new ArrayList<Consomateur>(); 
        for (int i = 0; i < tabConsomateur.size(); i++) {
            serchConsomateur=tabConsomateur.get(i);
            if (serchConsomateur.CercherParType (type)){
                filtreConsomateurs.add(serchConsomateur);
            }
            
        }
        return (filtreConsomateurs);
    } 

    //Chercher par nom
    public Consomateur chercherParNom(String nom){
        Consomateur serchConsomateur;
        
        for (int i = 0; i < tabConsomateur.size(); i++) {
            serchConsomateur=tabConsomateur.get(i);
            if (serchConsomateur.getNom().compareTo(nom)==0){
                return (serchConsomateur);
            }
            
        }
        return (null);
    } 
    public void postMessage(String message) {
        System.out.println("Message envoyer");
    }

}
