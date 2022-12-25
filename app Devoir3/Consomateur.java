import java.util.ArrayList; // import the ArrayList class

public class Consomateur extends Utilisateur {
        ArrayList<String> TypeDechet = new ArrayList<String>(); 
        ArrayList<Integer> tabNote = new ArrayList<Integer>(); 
        ArrayList<Activite> tabActivites= new ArrayList<Activite>(); 
        protected int note ;
        
        protected String Adresse ;
        protected String Telephone ;

        protected String capacite;
        protected Activite activites; 
        protected String activite;

        
        
        
        
        public Consomateur (int id,String Nom,String Adresse,String Mdp,String Email,String Telephone,String activite,String TypeDechet,String capacite) {
            this.id=id;
            this.Nom=Nom;
            this.Adresse=Adresse;
            this.Mdp=Mdp;
            this.Email=Email;
            this.activite=activite;
            this.Telephone=Telephone;
            this.TypeDechet.add(TypeDechet);
            this.capacite=capacite;
	        
        }

    //------------------- Methode
        public void newNote (int noteU){
            int totalNote =0;

            tabNote.add(noteU);
            for (int i = 0; i < tabNote.size(); i++) {
                totalNote += tabNote.get(i);
            }

            this.note= totalNote/tabNote.size();
        }

        public void newTypeDechet (String type){
            TypeDechet.add(type);
        }
        public Boolean CercherParType (String type){
            for (int i = 0; i < TypeDechet.size(); i++) {
                if (TypeDechet.get(i).compareTo(type)==0){
                    return true;
                }
           
            }
            return false;
          }
        

       
        public void newActivite ( String typeDechet, int note){
            Activite nouvelleActivite = new Activite(activite,typeDechet,note);
            tabActivites.add(nouvelleActivite);
        }


        public void noterActivite(String nom, int note){
            if (this.activites.getNom() == nom){
            this.activites.setNote(note);
            }
        }
    //--------- getters

   
    
    public String getTypeDeche() {
        return TypeDechet.get(0);
    } 
    public String getAdresse() {
        return Adresse;
    } 
    public Activite getActivites() {
        return activites;
    } 

    public String getTelephone() {
        return Telephone;
    } 
    public String getCapacite() {
        return capacite;
    } 

    
    
    
   
    //--------- setters
    
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;

    }

    public void setActivite(Activite activites){
        this.activite = activites.getNom();
      
    }
       
      
}

