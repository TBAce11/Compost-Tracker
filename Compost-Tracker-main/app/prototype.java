import java.util.Scanner; // import the Scanner class 

class Main {
  public static void main(String[] args) {
    mainmenu(); 
  }
  public  static Integer getInput() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    Integer input;
    
    // Enter username and press Enter
    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter "); 
    input = scan.nextInt();   
       
    return(input); 
  }  

  //fonction des onglet pour retourner au menu principale
  public static void retoureMenuP() {
    System.out.println("\n0-Retour au menu principale"); 
    Integer input=getInput();
    if (input==0){
      mainmenu();
    }else {
      System.out.println("réessayer taper '0' pour retourner au menu principale");
      retoureMenuP();
    }
  
  }
  //fonction du menu principale pour chnger d'onglet 
  public static void chargerOnglet() {
    Integer input=getInput();
    if (input==1){
      menu1();
    }else if  (input==2){
      menu2();
    }else if  (input==3){
      menu3();
    }else if  (input==4){
      menu4();
    }else if  (input==5){
      menu5();
    }else if  (input==6){
      menu6();
    }else if  (input==7){
      menu7();
    }else if  (input==8){
      menu8();
    }else if  (input==9){
      menu9();
    }
  }
  //-------------------------------------------
  //Fonction qui load le menu Principale
  public static void mainmenu() {

    String[] menuP = {"1-S'inscrire comme résident\n", "2-Enregistrer un bac\n", "3-Afficher l'état des mes bacs\n", "4-Afficher les métriques écologiques\n","5-Voir l'état de traitement des déchets municipaux\n", "6-Voir les activités que je maintiens\n", "7-Signaler un problème à la ville\n", "8-Trouver un consommateur\n","9-S'inscrire comme consommateur\n",};
    System.out.println("Menu BINECO \n\n###########\n"+menuP[0]+menuP[1]+menuP[2]+menuP[3]+menuP[4]+menuP[5]+menuP[6]+menuP[8]); 
    chargerOnglet();

  
    
  }
  //--------------------------------------------------------------------------
  //Fonction qui charge chaque onglets 
  public static void menu1() {

    
    System.out.println("\n###########\n S'inscrire comme résident\nNom:\nPrenom:\nAdesse:\nAdresse courriel:\nTelephone:\nNuméro d'un bac:"); 
    retoureMenuP();
  
    
  }

  public static void menu2() {

    System.out.println("\n###########\n Entrer le numero un bac:"); 
    retoureMenuP();
  
  }

  public static void menu3() {

    System.out.println("\n###########\nLa derniere fois que les bac on ete fider est le JJ/MM/AAAA"); 
    retoureMenuP();
  
  }

  public static void menu4() {

    System.out.println("\n###########\nLa masse de dechet traiter par le programe Bineco ce mois est de X kg pour la ville et Y kg au niveaux municipale"); 
    retoureMenuP();
  
  }

  public static void menu5() {

    System.out.println("\n###########\nLes decher recuperer cette semaine sont acheminer vers le consomateur X seront ariver le JJ/MM/AAAA et traiter le JJ/MM/AAAA"); 
    retoureMenuP();
  
  }

  public static void menu6() {

    System.out.println("\n###########\nLes dechet recuperer grace a BINECO sont utiliser de diverse maniere tel que..."); 
    retoureMenuP();
  
  }
  public static void menu7() {

    System.out.println("\n###########\nSignaler un probleme\nNom:\nPrenom:\nAdesse:\nAdresse courriel:\nType de Probleme\nType de Probleme:\nDesciption du probleme:"); 
   
    retoureMenuP();
  
  }
  
  public static void menu8() {

    System.out.println("\n###########\nTrouver un consommateur\nRechercher le nom, appliquer des filtre ranger dans un ordre particulier"); 
    retoureMenuP();
  
  }
  public static void menu9() {

    System.out.println("\n###########\nS'inscrire comme consommateur\nNom:\nAdresse courriel:\nTelephone:\nType de déchets traités:\nCapacité de traitement:\nActivités d'exploitation:");
    

    retoureMenuP();
  
  }



}