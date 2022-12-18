
public class Bac {
    private int id;
    private String Adresse;
    private String DateEmission;
    private String type;
    private boolean vide;

    private int CapMax=100;
    private int CapActuelle=0;

    public Bac (int id,String Adresse,String DateEmission,String type) {
        this.id=id;
        this.Adresse=Adresse;
        this.DateEmission=DateEmission;
        this.type=type;
        vide=true;
        
    }
    //quand on ajoute des ellement dans un bac
    public void remplire(int ajout) {
        CapActuelle+=ajout;
    } 
     //--------- getters

    public int getremplissage() {
        return CapActuelle/CapMax*100;
    } 

    public int getid() {
        return id;
    } 
    public String getAdresse() {
        return Adresse;
    } 
    public String getDateEmission() {
        return DateEmission;
    } 
    public String getType() {
        return type;
    } 
    public boolean getvide() {
        return vide;
    } 

    //--------- setters
    
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
    public void setDateEmission(String DateEmission) {
        this.Adresse = DateEmission;
    }
    public void settype(String type) {
        this.type = type;
    }
    public void setAdresse(boolean vide) {
        this.vide = vide;
    }
}
        
        
    
