import java.util.ArrayList; // import the ArrayList class


public class Lot {
    int id;
    String type;
    String parent;
    Lot[] sous_lots;
    String dateRamassage;
    String dateLivraison;
    String statut;
    int qte_total;
    int qte_traite;
    float taux_rejet;
    float cout;
    ArrayList <Integer> TabConsomateursId = new ArrayList<Integer>();
    String activites;

    public Lot (int id,String type,String dateRamassage,String dateLivraison, String activites,Integer ConsomateurId) {  
        
        
        this.id=id;
        this.type=type;
        this.dateRamassage=dateRamassage;
        this.dateLivraison=dateLivraison;
        this.activites=activites;
        this.TabConsomateursId.add(ConsomateurId);  
        this.statut="Acheminment en cour";      
    }



    //--------- getters

    public int getid() {
    return id;
    } 

    public String gettype() {
        return type;
    }
    public String getDateRamassage() {
    return dateRamassage;
    }  
    public String getDateLivraison() {
    return dateLivraison;
    } 
    public String getActivites() {
        return activites;
    }
    public String getStatut() {
        return statut;
    }

    public ArrayList <Integer> tabLotCons() {
        return TabConsomateursId;
    }

    

}