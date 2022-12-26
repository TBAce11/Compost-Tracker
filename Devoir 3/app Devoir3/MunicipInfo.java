import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MunicipInfo {
    static ArrayList<Consomateur> tabConsomateur = new ArrayList<>();
    ArrayList<Bac> Bac = ReadBac.getBacsDatabase(); //liste de tous les bacs enregistrés
    private ArrayList<Lot> lotList = new ArrayList<Lot>(); //liste des lots

    /**
     * Contructeur vide de MunicipInfo
     */
    public MunicipInfo () {}

    /**
     * Ajoute les consommateurs présents sur la base de donnée Consomateur.txt dans un tableau
     * @return tabConsomateur
     *      Tableau de consommateurs inscrits
     */
    public static ArrayList<Consomateur> ListConsomateur() {
         try {
             tabConsomateur = ReadConsomateur.getConsomateursDatabase();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tabConsomateur;
    } 
    //quand on valide linscription dun consomateur on ajoute ces donner a la database

    /**
     *Lorsqu'on valide l'inscription d'un consommateur, on ajoute ses informations à la base de donnée Consomateur.txt
     * @param newCons
     *      Instance de Consomateur passée en paramètre
     */
    public void valideConsomateur(Consomateur newCons) {
        tabConsomateur.add(newCons);
        int id=newCons.getid();
        String Nom=newCons.getNom();
        String Adresse=newCons.getAdresse();
        String Mdp=newCons.getMdp();
        String Email=newCons.getEmail();
        String Telephone=newCons.getTelephone();
        Activite activites=newCons.getActivites();
        String TypeDechet=newCons.getTypeDechet();
        String capacite=newCons.getCapacite();
        try {
			ReadConsomateur.addConsomateur( id, Nom, Adresse, Mdp, Email, Telephone, activites, TypeDechet, capacite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Ajoute le bac à la liste des bacs enregistrés
     * @param newBac
     *      Instance de Bac passée en paramètre
     */
    public void addBac(Bac newBac) {
        Bac.add(newBac);
        int id=newBac.getid();
       
        String Adresse=newBac.getAdresse();
        String DateEmission=newBac.getDateEmission();
        String type=newBac.getType();
        
        try {
			ReadBac.addBac( id, Adresse, DateEmission, type);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    } 

    /**
     * Recherche de bac avec ID
     * @param SearchId
     *      ID du bac à chercher
     * @return searchBac
     *      Bac correspondant à l'ID lancé en paramètre
     */
    public Bac IndexBac(int SearchId){
        for (int i = 0; i < Bac.size(); i++) {
            Bac searchBac=Bac.get(i);
            if (SearchId==searchBac.getid()){
                return searchBac;
            }
        }
        return (null);
    } 

    /**
     * Recherche de consomateurs prenant en charge un type de déchets précis
     * @param type
     *      Type de déchet utilisé comme correspondance
     * @return filtreConsomateurs
     *      Liste de consomateurs filtrée par la correspondance par type
     */
    public ArrayList<Consomateur> chercherParType(String type){
        Consomateur serchConsomateur;
        ArrayList<Consomateur> filtreConsomateurs = new ArrayList<Consomateur>(); 
        for (int i = 0; i < tabConsomateur.size(); i++) {
            serchConsomateur=tabConsomateur.get(i);
            if (serchConsomateur.ChercherParType (type)){
                filtreConsomateurs.add(serchConsomateur);
            }
            
        }
        return (filtreConsomateurs);
    } 

    /**
     * Recherche d'un consomateur à partir d'un nom passé en paramètre
     * @param nom
     *      Nom du consomateur recherché
     * @return serchConsomateur
     *      Consomateur trouvé par correspondance de nom
     */
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

    public static Consomateur getConsommateur(int id){
        Consomateur serchConsomateur;
        
        for (int i = 0; i < tabConsomateur.size(); i++) {
            serchConsomateur=tabConsomateur.get(i);
            if (serchConsomateur.getid()==id){
                return (serchConsomateur);
            }
            
        }
        return (null);
    }

    public void postMessage(String message) {
        System.out.println("Message envoyé.");
    }

    /**
     * Ajout des lots au sein de la base de données
     * @return ReadLot.getLotsDatabase()
     *
     */
    public ArrayList<Lot> listLot() {
        //ajoute les lots 
        return ReadLot.getLotsDatabase();
    }

    /**
     * Recherche de lot par correspondance d'ID
     * @param idSearch
     *      ID de recherche
     * @return searchLot
     *      Résultat de la recherche de lot
     */
    public Lot getLot(int idSearch) {
        for (int i = 0; i < lotList.size(); i++) {
            Lot searchLot=lotList.get(i);
            if (searchLot.getid()==idSearch){
                return (searchLot);
            }
            
        }
        return (null);
    }

    /**
     * Affichage des détails du lot en traitement en paramètre
     * @param lotTraitement
     */
    public void ConsomateurLot(Lot lotTraitement) {

        System.out.println("Le lot n° "+lotTraitement.getid()+" qui trait les dechet de type "+ lotTraitement.gettype());
        System.out.println("    Date de passage des camions: "+lotTraitement.getDateRamassage());
        System.out.println("    Livraison des déchets : "+lotTraitement.getDateRamassage());
        System.out.println("    Staut (état des déchets): "+lotTraitement.getStatut());
        System.out.println("    Les dechet seront livrais par le/les consomateur suivant:");
        ArrayList <Integer> listIdCons=lotTraitement.tabLotCons();    
        for (int i = 0; i < listIdCons.size(); i++) {
            //recupere le bac correspondant
            int idCons=listIdCons.get(i);
            Consomateur cons =getConsommateur(idCons);
            System.out.println("        Le Consommateur "+cons.getNom()+" qui a pour activité "+cons.getActivites());
            }
    }
}
