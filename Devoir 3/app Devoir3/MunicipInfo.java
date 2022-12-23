import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class


public class MunicipInfo {
    static ArrayList<Consomateur> tabConsomateur =new ArrayList<>();

    public MunicipInfo () {
       
         
    }


    public static ArrayList<Consomateur> ListConsomateur() {
         //ajoute les consomateur deja present
         try {
             tabConsomateur =ReadConsomateur.getConsomateursDatabase();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tabConsomateur;
    } 
    //quand on valide linscription dun consomateur on ajoute ces donner a la database
    public void valideConsomateur(Consomateur newCons) {
        tabConsomateur.add(newCons);
        int id=newCons.getid();
        String Nom=newCons.getNom();
        String Adresse=newCons.getAdresse();
        String Mdp=newCons.getMdp();
        String Email=newCons.getEmail();
        String Telephone=newCons.getTelephone();
        String activites=newCons.getActivites();
        String TypeDechet=newCons.getTypeDeche();
        String capacite=newCons.getCapacite();
        try {
			ReadConsomateur.addConsomateur( id, Nom, Adresse, Mdp, Email, Telephone, activites, TypeDechet, capacite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

    //liste de tout les bac
    ArrayList<Bac> Bac = ReadBac.getBacsDatabase(); 
    //ajoute un bac a la liste des bac
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
    //Chercher par Type un consomateur
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
        System.out.println("Message envoyer");
    }



  
    //liste des lots
    private ArrayList<Lot> lotList= new ArrayList<Lot>();
    //ajoute les lots 
    
    public ArrayList<Lot> listLot() {
        //ajoute les lots 
        return ReadLot.getLotsDatabase();
    }
    public Lot getLot(int idsearch) {
        for (int i = 0; i < lotList.size(); i++) {
            Lot serchLot=lotList.get(i);
            if (serchLot.getid()==idsearch){
                return (serchLot);
            }
            
        }
        return (null);
    }


    public void ConsomateurLot(Lot lotTraitment) {

        System.out.println("Le lot n° "+lotTraitment.getid()+" qui trait les dechet de type "+ lotTraitment.gettype());
        System.out.println("    Date de passage des camions: "+lotTraitment.getDateRamassage());
        System.out.println("    Livraison des déchets : "+lotTraitment.getDateRamassage());
        System.out.println("    Staut (état des déchets): "+lotTraitment.getStatut());
        System.out.println("    Les dechet seront livrais par le/les consomateur suivant:");
        ArrayList <Integer> listIdCons=lotTraitment.tabLotCons();    
        for (int i = 0; i < listIdCons.size(); i++) {
            //recupere le bac correspondant
            int idCons=listIdCons.get(i);
            Consomateur cons =getConsommateur(idCons);
            System.out.println("        Le Consommateur "+cons.getNom()+" qui a pour activité "+cons.getActivites());
            
        
            }
    }
}
