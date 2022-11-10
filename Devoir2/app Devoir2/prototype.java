import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList class

class  prototype {
  public static void main(String[] args) {
    mainmenu(); 
  }

  static ArrayList<Utilisateur> individus = new ArrayList<>();

  public static void mainmenu() {
    individus.add(new Resident (1,"nom","prenom","123","test@gmail.com"));

    System.out.println(individus);
    
  }



}