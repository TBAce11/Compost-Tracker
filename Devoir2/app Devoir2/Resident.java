import java.util.ArrayList; // import the ArrayList class

public class Resident extends Utilisateur {
    

        ArrayList<Integer> Bacid = new ArrayList<Integer>(); 
        ArrayList<String> BacContenu = new ArrayList<String>();
        ArrayList<Boolean> BacEtats = new ArrayList<Boolean>(); 
         
        
      
        protected String Prenom ;
        
        protected String Adresse ;
        protected int Telephone ;
        
        
        
        
        
        public Resident (int id,String Nom,String Prenom,String Mdp,String Email) {  
            
            
            this.id=id;
            this.Nom=Nom;
            this.Prenom=Prenom;
            this.Mdp=Mdp;
            this.Email=Email;
	        
        }

        //------------------- Methode
        
        //ajouter bac
        public void EnregistrerBac(int Bid,String BType){
           Bacid.add(Bid);
           BacContenu.add(BType);
           BacEtats.add(true);
        } 

        //suprimer bac 
        public void suprBac(int Bid){
            int index ;
            index =IndexBac(Bid);
            Bacid.remove(index);
            BacContenu.remove(index);
            BacEtats.remove(index);
        } 

        //chercher bac avec id
        public int IndexBac(int SerchId){
            for (int i = 0; i < Bacid.size(); i++) {
                if (SerchId==Bacid.get(i)){
                    return i;
                }
                
            }
            return (-1);
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

