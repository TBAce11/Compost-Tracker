import java.util.ArrayList; // import the ArrayList class

public class Consomateur extends Utilisateur {
    
        ArrayList<Integer> tabNote = new ArrayList<Integer>(); 
        protected int note ;
        
        protected String Adresse ;
        protected int Telephone ;

        protected int capTraitement;
        protected String exploitation; 

//string ou array au choix
        protected String TypeDechet ;
        
        
        
        
        public Consomateur () {
            
	        
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

