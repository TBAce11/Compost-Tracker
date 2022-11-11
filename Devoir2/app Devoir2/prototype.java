import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList class

class  prototype {
  public static void main(String[] args) {
    mainmenu(); 
    
  }
  //tableaux qui contient les utilisateur inscris
  static ArrayList<Utilisateur> UserTab = new ArrayList<>();
  //tableaux qui contient les utilisateur en atttente de valisdation 
  static ArrayList<Utilisateur> attenteUser = new ArrayList<>();



  public static void mainmenu() {
    NewResident();
    UserTab.add(new Resident (1,"nom","prenom","456","test@gmail.com"));
    //System.out.println(UserTab.get(0).getEmail()+UserTab.get(0).getMdp()+UserTab.get(0).getid());
    System.out.println(verifUser("b","b"));
    System.out.println(verifUser("test@gmail.com","456"));
    
  }



//---------------------------------------------------------------------------
//---------------------------------------------------------------------------


  //verifie si cette utilisateur existe dans le tableau
  public static Boolean verifUser(String Email,String mdp) {
    
    Utilisateur userVerif;
    //on parcours le tableaux et verifie si un utilisateur correspon au parametre  
    for (int i = 0; i < UserTab.size(); i++) {
      
      userVerif=UserTab.get(i);
      //System.out.println(userVerif.getEmail()+" "+Email);
      String verifEmail=userVerif.getEmail();
      String verifMdp=userVerif.getMdp();
      if (verifEmail==Email && verifMdp==mdp ){
        
        return true;
      }
    }
    return false;
    
    
  }

  public  static String getInputString() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    String input;
    input = scan.next();
       
       
    return(input); 
  }  



//ajoute un residant a la liste d'utilisateur en attente 
  public static void NewResident() {

//rentre le nom
     // Create a Scanner object
    System.out.println("Enter Votre nom ");
    String userNom = getInputString();  // Read user input
    

//rentre le prenom
     
    System.out.println("Enter Votre prenom ");
    String userPrenom = getInputString();  

//rentre le mot de passe
      
    System.out.println("Enter Votre mot de passe ");
    String userMdp = getInputString(); 
//rentre l'Email 

    System.out.println("Enter Votre Email ");
    String userEmail = getInputString(); 


//changer de tab pour tab d'utilisateur en attente --version test
    UserTab.add(new Resident (idGenerator(),userNom,userPrenom,userMdp,userEmail));
    
  }



  //on genere un id unique selon la taille du tableau de user on pas du principe que on ne peux pas suprimer de compte
  public static int idGenerator() {
    //dernier user qui a reçus un id  
    Utilisateur userLastId;

    int nbUser=UserTab.size();
    int nbAttenteUser=attenteUser.size();
    //si il y a aucun user on retourn 1
    if (nbAttenteUser==0 && nbUser==0){
      return 1;
    }
    //si il y a pas d'utilisateur en attente on donne le dernier id atribuer dans la list de UserTab +1
    else if (nbAttenteUser==0 ){
      userLastId=UserTab.get(nbUser-1);
      return (userLastId.getid()+1);
    }
    //si il y a des utilisateur en attente on donne le dernier id atribuer dans la list de attenteUser +1
    else {
      userLastId=attenteUser.get(nbAttenteUser-1);
      return (userLastId.getid()+1);
    }
  }

  
   







}