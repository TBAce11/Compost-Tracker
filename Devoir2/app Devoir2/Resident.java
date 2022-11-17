import java.util.ArrayList; // import the ArrayList class

public class Resident extends Utilisateur {
    

        ArrayList<Integer> Bacid = new ArrayList<Integer>(); 
       
         
        
      
        protected String Prenom ;
        
        protected String Adresse ;
        protected int Telephone ;
        
        
        
        
        
        public Resident (int id,String Nom,String Prenom,String Mdp,String Email,String Adresse) {  
            
            
            this.id=id;
            this.Nom=Nom;
            this.Prenom=Prenom;
            this.Mdp=Mdp;
            this.Email=Email;
            this.Adresse=Adresse;
	        
        }

        //------------------- Methode
        
        //ajouter bac
        public void newBac(int Bid){
           Bacid.add(Bid);
        } 

        

        






       

      //--------- getters
    
    

    public String getPrenom() {
        return Prenom;
    } 
    
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

