import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class

public class Resident extends Utilisateur {
    

        ArrayList<Integer> Bacid = new ArrayList<Integer>(); 
       
        
      
        protected String Prenom ;
        
        protected String Adresse ;
        protected String Telephone ;
        
        
        
        
        
        public Resident (int id,String Nom,String Prenom,String Telephone,String Mdp,String Email,String Adresse) {  
            
            
            this.id=id;
            this.Nom=Nom;
            this.Prenom=Prenom;
            this.Mdp=Mdp;
            this.Email=Email;
            this.Adresse=Adresse;
            this.Telephone=Telephone;
	        
        }

        //------------------- Methode
        
        //ajouter bac
        public void newBac(int Bid){
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

