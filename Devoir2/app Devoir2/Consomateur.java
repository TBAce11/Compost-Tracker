import java.util.ArrayList; // import the ArrayList class

public class Consomateur extends Utilisateur {
        ArrayList<String> TypeDechet = new ArrayList<String>(); 
        ArrayList<Integer> tabNote = new ArrayList<Integer>(); 
        protected int note ;
        
        protected String Adresse ;
        protected int Telephone ;

        protected String capacite;
        protected String activites; 
        

        
        
        
        
        public Consomateur (int id,String Nom,String Adresse,String Mdp,String Email,int Telephone,String activites,String TypeDechet,String capacite) {
            this.id=id;
            this.Nom=Nom;
            this.Adresse=Adresse;
            this.Mdp=Mdp;
            this.Email=Email;

            this.Telephone=Telephone;
            this.activites=activites;
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


       

    //--------- getters

   
    
    
    public String getAdresse() {
        return Adresse;
    } 

    public int getTelephone() {
        return Telephone;
    } 

    
    
    
   
    //--------- setters
    
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

        
        
      

       
       
}

