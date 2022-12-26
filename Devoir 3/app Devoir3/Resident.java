import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class

public class Resident extends Utilisateur {
    ArrayList<Integer> Bacid = new ArrayList<Integer>();
    protected String Prenom;
    protected String Adresse;
    protected String Telephone;
    protected Metriques Metriques;

    /**
     * Contructeur du Resident où les métriques ne sont pas paramétrisées, mais bien générées automatiquement aussitôt
     * que le résident est créé
     * @param id
     * @param Nom
     * @param Prenom
     * @param Telephone
     * @param Mdp
     * @param Email
     * @param Adresse
     *
     * @return Resident
     *      Retourne une instance de Resident
     */
    public Resident(int id, String Nom, String Prenom, String Telephone, String Mdp, String Email, String Adresse) {
        this.id = id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Mdp = Mdp;
        this.Email = Email;
        this.Adresse = Adresse;
        this.Telephone = Telephone;
        this.Metriques = new Metriques();
    }

    //------------------- Methode

    /**
     * Ajout d'un bac au sein de la collection du résident à partir de son ID
     * @param Bid
     */
    public void newBac(int Bid) {
        Bacid.add(Bid);
    }

    //--------- getters
    public ArrayList<Integer> getBacId() {
        return Bacid;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getTelephone() {
        return Telephone;
    }

    //--------- setters

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

}

