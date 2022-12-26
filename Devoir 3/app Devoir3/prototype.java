import java.text.DecimalFormat;
import java.util.Scanner; // import the Scanner class
import java.util.ArrayList; // import the ArrayList clas
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;

class prototype {

  /**Main class Bineco
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {

    ResidentTab = ReadResident.getResidentsDatabase();
    updateUserTab();
    mainMenu();

  }

  static MunicipInfo Municip = new MunicipInfo();
  // tableaux qui contient les utilisateur inscris
  static ArrayList<Utilisateur> UserTab = new ArrayList<>();
  // tableaux qui contient les utilisateur en atttente de valisdation
  static ArrayList<Utilisateur> attenteUser = new ArrayList<>();

  // tableaux qui contient les resident inscris
  static ArrayList<Resident> ResidentTab = new ArrayList<>();

  // menu principale
  /**Fonction qui revient au menu principal.
   * 
   */
  public static void mainMenu() {

    System.out.println("MAIN MENU ");
    System.out.println("1-Connexion");
    System.out.println("2-S'inscrire Comme resident");
    System.out.println("3-S'inscrire Comme Consomateur");

    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");

    GestionMainMenu();

  }

  // tab qui contient tous les utilisateur resident et consomateur
  public static void updateUserTab() {
    UserTab.clear();
    UserTab.addAll(ResidentTab);
    UserTab.addAll(Municip.ListConsomateur());

  }

  // changer dongler au menu
  /**Menu principal lors de l'ouverture de l'application
   * 
   */
  public static void GestionMainMenu() {
    int menu1 = getInputInt();
    // si on s'inscrie
    if (menu1 == 1) {
      Utilisateur ActualUser = MenuConnexion();
      if (ActualUser == null) {
        System.out.println("réessayer taper '1','2' ou '3' pour changer d'onglet");
        GestionMainMenu();
      } else {
        // a changer
        if (ActualUser instanceof Resident) {
          Resident user = (Resident) ActualUser;
          MenuResident(user);
        } else {
          Consomateur user = (Consomateur) ActualUser;
          MenuConsomateur(user);
        }
      }
    }
    // si on se connect
    else if (menu1 == 2) {
      NewResident();
      System.out.println("Votre dossier et enregistrer et seras traite par nos agent dans les plus brefs délais");
      mainMenu();

    } else if (menu1 == 3) {
      NewConsomateur();
      System.out.println("Votre dossier et enregistrer et seras traite par nos agent dans les plus brefs délais");
      mainMenu();

    }
    // si on tape un mauvais input
    else {
      System.out.println("réessayer taper '1','2' ou '3' pour changer d'onglet");
      GestionMainMenu();
    }

  }

  // ------------------------------------------------------------------------------------
  // ------------------------------------------------------------------------------------
  // menu quand un resident est connecte
  /**Menu du résident avec 8 inputs différents. 
   * @param ActualResident
   */
  public static void MenuResident(Resident ActualResident) {

    System.out.println("Menu Resident de l'utilisateur" + ActualResident.getNom());

    System.out.println("0-Revenir au menus principale");
    System.out.println("1-Enregistrer un bac");
    System.out.println("2-Afficher l'état des mes bacs");
    System.out.println("3-Métriques");
    System.out.println("4-Voir l'état de traitement des déchets municipaux");
    System.out.println("5-Signaler un problème à MunicipInfo");
    System.out.println("6-Trouver un consommateur");
    System.out.println("7-Modifier Mon Profil");
    System.out.println("8-Noter une activité");

    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");
    GestionMenuResident(ActualResident);
  }

  // menu quand un consomateur est connecte
  /**Menu du consommateur avec 4 inputs différents. 
   * @param ActualUser
   */
  public static void MenuConsomateur(Consomateur ActualUser) {

    System.out.println("Menu Consomateur de l'utilisateur " + ActualUser.getNom());
    System.out.println("0-Revenir au menus principale");
    System.out.println("1-Notifier les résidents");
    System.out.println("2-Modifier mon Profil");
    System.out.println("3-Ajouter une activité");
    System.out.println("4-Supprimer une activité");

    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");
    GestionMenuConsomateur(ActualUser);
  }

  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------
  // methode des menu de resident

  /**Méthode pour receuillir l'input et rediriger vers la méthode correspondante.
   * @param ActualResident
   */
  public static void GestionMenuResident(Resident ActualResident) {
    int input = getInputInt();
    // si le Resident veux revenir au menus principale
    if (input == 0) {
      mainMenu();

    }
    // si le Resident veux Enregistrer un bac
    else if (input == 1) {
      EnregistrerBac(ActualResident);
    }
    // si le Resident veux Afficher l'état des mes bacs
    else if (input == 2) {
      EtatBacs(ActualResident);

    }
    // si le Resident veux acceder a ces Métriques
    else if (input == 3) {

      Metriques(ActualResident);
    }
    // si le Resident veux Voir l'état de traitement des déchets municipaux
    else if (input == 4) {

      EtatTraitement(ActualResident);
    }
    // si le Resident veux Signaler un problème à MunicipInfo
    else if (input == 5) {

      signalerProbleme(ActualResident);
    }
    // si le Resident veux Trouver un consommateur
    else if (input == 6) {
      TrouverConsomateur(ActualResident);

    } else if (input == 7) {
      ModifProfil(ActualResident);

    }
    else if (input == 8) {
      noterActivite(ActualResident);

    }
    // si le Resident rentre un mauvais input
    else {
      System.out.println("réessayer taper '0' ou '1' pour changer d'onglet");
      GestionMenuResident(ActualResident);
    }
  }

  // methode des action de resident
  /**Méthode pour noter une activité.
   * @param ActualResident
   */
  public static void noterActivite(Resident ActualResident){

    System.out.println("Entrer l'activité que vous voulez noter");
    String nom = getInputString();
    System.out.println("Entrer une note");
    String note = getInputString();
    try {
      ArrayList<Activite> activites = ReadActivite.getActiviteDatabase();
     for (Activite activite : activites) 
     {
        if (activite.getNom().compareTo(nom)==0){
          ReadActivite.modifActivite( nom, note, 2);
        }
      updateUserTab();
      }
    }
     catch (IOException exception) {
      System.out.println("L'activité n'a pas été notée");
    }
    MenuResident(ActualResident);
  }






  /**Méthode pour enregistrer un bac.
   * @param ActualResident
   */
  public static void EnregistrerBac(Resident ActualResident) {
    // rentre id
    System.out.println("Enter le code fourni par le code qr ");
    int id = getInputInt(); // Read user input
    // rentre Adresse
    System.out.println("Enter Votre Adresse ");
    String Adresse = getInputString(); // Read user input
    // rentre DateEmission
    System.out.println("Enter la Date d'emission ");
    String DateEmission = getInputString(); // Read user input
    // rentre le type
    System.out.println("Enter le type du bac");
    String type = getInputString(); // Read user input

    Bac NewBac = new Bac(id, Adresse, DateEmission, type);
    ActualResident.newBac(id);
    Municip.addBac(NewBac);
    System.out.println("bac a ete ajouter");
    MenuResident(ActualResident);
  }

  /**Méthode pour vérifier l'état de ses bacs.
   * @param ActualResident
   */
  public static void EtatBacs(Resident ActualResident) {
    // recupere la list des id des bac du resident
    ArrayList<Integer> listIdBac = ActualResident.getBacId();
    for (int i = 0; i < listIdBac.size(); i++) {
      // recupere le bac correspondant
      Bac residentBac = Municip.IndexBac(listIdBac.get(i));
      System.out.println("Le Bac n° " + listIdBac.get(i) + " de type " + residentBac.getType() + " est remplie a "
          + residentBac.getremplissage() + "%");
      MenuResident(ActualResident);
    }

  }

  /**Méthode qui permet d'afficher les métriques.
   * @param ActualResident
   */
  public static void Metriques(Resident ActualResident) {
    final DecimalFormat df = new DecimalFormat("#.##");

    System.out.println("Voici les métriques propres à votre production de déchets ménagers: \n");

    System.out.println("Métriques municipales \n");
    System.out.println("Taux de contamination: " + ActualResident.Metriques.getTauxContamination() + "%");
    System.out.println("Taux de diversion: " + ActualResident.Metriques.getTauxDiversion() + "% \n");

    System.out.println("Métriques personelles \n");
    System.out.println("Masse totale: " + ActualResident.Metriques.getMasseTotale() + " kg");
    System.out.println("Facteur PN: " + df.format(ActualResident.Metriques.getFacteurPN()));
    System.out.println("Facteur PNU: " + df.format(ActualResident.Metriques.getFacteurPNU()));
    System.out.println("Score ÉCOLO: " + df.format(ActualResident.Metriques.getEcoScore()) + " \n\n");

    MenuResident(ActualResident);
  }

  /**Méthode qui permet d'afficher l'état de traitement de ses déchets selon le numéro de lot.
   * @param ActualResident
   */
  public static void EtatTraitement(Resident ActualResident) {
    System.out.println("L'état de traitement des déchets municipaux");

    System.out.println("Entre le numero du lot ou 0 pour revenir en ariere");
    int Num = getInputInt();

    ArrayList<Lot> ListLotTraitment = Municip.listLot();
    for (int i = 0; i < ListLotTraitment.size(); i++) {
      // recupere le bac correspondant
      Lot LotTraitment = ListLotTraitment.get(i);
      if (Num == LotTraitment.getid()) {
        Municip.ConsomateurLot(LotTraitment);
        GestionMenuResident(ActualResident);
      } else if (0 == LotTraitment.getid()) {
        GestionMenuResident(ActualResident);
      } else {
        EtatTraitement(ActualResident);
      }

    }

  }

  /**Méthode qui permet de signaler un problème à travers MunicipInfo.
   * @param ActualResident
   */
  public static void signalerProbleme(Resident ActualResident) {
    String message = getInputString();
    Municip.postMessage(message);
    GestionMenuResident(ActualResident);
  }

  // fonction qui oriente et effectu la recherche de consomateur
  /**Méthode afin de trouver un consommateur, par nom ou par type de déchet traité.
   * @param ActualResident
   */
  public static void TrouverConsomateur(Resident ActualResident) {
    System.out.println("Pour noter un consomateur il faut le chercher par son nom exact");
    System.out.println("0-Retour menu Resident");
    System.out.println("1-Chercher pas nom");
    System.out.println("2-Chercher par type");
    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");

    int input = getInputInt();
    // action du menu
    if (input == 0) {
      mainMenu();

    }

    // chercher par nom
    else if (input == 1) {
      System.out.println("Enter le nom du consomateur ");
      String nom = getInputString();
      Consomateur ConsTrouver = Municip.chercherParNom(nom);
      // si aucun nom ne match
      if (ConsTrouver == null) {
        System.out.println("Aucun consomateur correspondant");
        TrouverConsomateur(ActualResident);
      }
      // si on trouve un nom sois on renvois au menu soit on note le consomateur
      else {
        System.out.println("Le consomateur " + ConsTrouver.getNom() + " a ete trouver");
        System.out.println("0-retour menu Resident");
        System.out.println("1-Noter le consomateur");
        System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");
        int newinput = getInputInt();
        if (newinput == 0) {
          mainMenu();

        }
        // noter un conssomateur
        else if (newinput == 1) {
          System.out.println("entrer une note");
          int note = getInputInt();
          ConsTrouver.newNote(note);
          TrouverConsomateur(ActualResident);

        }
      }

    } else if (input == 2) {
      // on recupere un type
      System.out.println("Enter un type de dechet ");
      String type = getInputString();

      // on affiche une liste des consomateur qui corresponde a un type
      System.out.println("Les Consomateur qui traite " + type + " sont les suivant:");
      ArrayList<Consomateur> tabConsFiltrer = Municip.chercherParType(type);
      for (int i = 0; i < tabConsFiltrer.size(); i++) {
        System.out.println(" -Consomateur:" + tabConsFiltrer.get(i).getNom());
      }
      if (tabConsFiltrer.size() == 0) {
        System.out.println("Aucun Consomateur corespond");
      }
      TrouverConsomateur(ActualResident);

    } else {
      System.out.println("réessayer taper '0','1'ou '2' pour changer d'onglet");
      TrouverConsomateur(ActualResident);
    }

  }

  /**Méthode afin de modifier son profil résident.
   * @param ActualResident
   */
  public static void ModifProfil(Resident ActualResident) {
    System.out.println("Pour modifier votre compte suivez les instructions.");
    System.out.println("1-Pour modifier votre compte");
    System.out.println("2-Pour retourner au menu Resident");
    int newinput = getInputInt();
    if (newinput == 1) {
      int id = ActualResident.getid();
      System.out.println("Enter votre nom");
      String nom = getInputString();
      System.out.println("Entrer votre prenom");
      String prenom = getInputString();
      System.out.println("Enter votre adresse");
      String adresse = getInputString();
      System.out.println("Enter votre numéro de téléphone");
      String telephone = getInputString();
      System.out.println("Enter votre mot de passe");
      String Mdp = getInputString();
      System.out.println("Enter votre adresse mail");
      String mail = getInputString();

      try {
        ReadResident.modifResident(id, nom, 1);
        ReadResident.modifResident(id, prenom, 2);
        ReadResident.modifResident(id, telephone, 3);
        ReadResident.modifResident(id, Mdp, 4);
        ReadResident.modifResident(id, mail, 5);
        ReadResident.modifResident(id, adresse, 6);
        updateUserTab();
      } catch (IOException exception) {
        System.out.println("La modification n'a pas été faite");
      }
      MenuResident(ActualResident);

    } else if (newinput == 2) {
      MenuResident(ActualResident);
    } else {
      System.out.println("réessayer taper '1'ou '2' pour changer d'onglet");
      ModifProfil( ActualResident);
    }

  }

  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------
  // methode le menu de consomateur

  /**Méthode qui permet de rediriger vers les différentes options du menu consommateur.
   * @param ActualConsomateur
   */
  public static void GestionMenuConsomateur(Consomateur ActualConsomateur) {
    int input = getInputInt();
    // si leConsomateur veux revenir au menus principale
    if (input == 0) {
      mainMenu();

    }
    // si le Consomateur veux Notifier les résidents
    else if (input == 1) {
      System.out.println("Notifier les résidents");
      System.out.println("\nEntrer le messge a transmettre");
      String message = getInputString();
      MenuConsomateur(ActualConsomateur);

    } else if (input == 2) {
      System.out.println("Pour modifier votre profil suivez les instructions.");
      System.out.println("1-Pour modifier votre compte");
      System.out.println("2-Pour retourner au menu Consomateur");
      int Input = getInputInt();
      if (Input == 1) {
        int id = ActualConsomateur.getid();
        System.out.println("Enter votre nom");
        String nom = getInputString();
        System.out.println("Enter votre adresse");
        String adresse = getInputString();
        System.out.println("Enter votre mot de passe");
        String Mdp = getInputString();
        System.out.println("Enter votre adresse mail");
        String mail = getInputString();
        System.out.println("Enter votre numéro de téléphone");
        String telephone = getInputString();
        System.out.println("Vos activités");
        String activite = getInputString();
        System.out.println("Enter Type de déchet");
        String type = getInputString();
        System.out.println("Enter votre capacité");
        String capacite = getInputString();
        try {
          ReadConsomateur.modifConsomateur(id, nom, 1);
          ReadConsomateur.modifConsomateur(id, adresse, 2);
          ReadConsomateur.modifConsomateur(id, Mdp, 3);
          ReadConsomateur.modifConsomateur(id, mail, 4);
          ReadConsomateur.modifConsomateur(id, telephone, 5);
          ReadConsomateur.modifConsomateur(id, activite, 6);
          ReadConsomateur.modifConsomateur(id, type, 7);
          ReadConsomateur.modifConsomateur(id, capacite, 8);
          updateUserTab();
        } catch (IOException exception) {
          System.out.println("La modification n'a pas été faite");
        }
        MenuConsomateur(ActualConsomateur);
      } else if (Input == 2) {
        MenuConsomateur(ActualConsomateur);;
      }

    } else if (input == 3) {
      System.out.println("Entrer le nom de l'activité");
      String nom = getInputString();
      System.out.println("Entrer le type de déchet");
      String typeDechet = getInputString();
      try {
        ReadActivite.addActivite(nom, typeDechet, 0);

      } catch (IOException exception) {
        System.out.println("L'activité n'a pas été crée");
      }
      MenuConsomateur( ActualConsomateur);
    } else if (input == 4){
      System.out.println("\nLe nom de l'activiter que vous voulez suprimer");
      String nom=getInputString();
      ReadActivite.suppActivite(nom);
      MenuConsomateur( ActualConsomateur);
    }

    // si le Consomateur rentre un mauvais input
    else {
      System.out.println("réessayer taper '0' ou '1' pour changer d'onglet");
      GestionMenuConsomateur(ActualConsomateur);
    }
  }

  // methode des action de consomateur
  /**Méthode pour ajouter un type de déchet à son profil. 
   * @param ActualUser
   * @param type
   */
  public static void ajouterType(Consomateur ActualUser, String type) {

    ActualUser.newTypeDechet(type);
    updateUserTab();
  }

  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------

  // conexxion recupere les input
  /**Menu de connexion qui vérifie si on est inscrit ou non. 
   * @return
   */
  public static Utilisateur MenuConnexion() {
    int id = Connexion();
    Utilisateur connecte = null;
    // si on trouve pas d'utilisateur qui coresspond
    if (id == -1) {
      System.out.println("l'utilisateur na pas était trouver réessayez ou inscrivez vous");
      return connecte;
    } else {
      connecte = getUserByID(id);
      return connecte;
    }

  }

  // conexxion recupere les input
  /**Méthode de receuil d'inputs pour la connexion. 
   * @return
   */
  public static int Connexion() {
    System.out.println("CONNEXION");
    System.out.println("Email: ");
    String UserMail = getInputString();

    System.out.println("Mots de passe: ");
    String UserMdp = getInputString();

    return verifUser(UserMail, UserMdp);

  }

  // verifie si cette utilisateur existe dans le tableau
  public static int verifUser(String Email, String mdp) {

    Utilisateur userVerif;
    // on parcours le tableaux et verifie si un utilisateur correspon au parametre
    for (int i = 0; i < UserTab.size(); i++) {

      userVerif = UserTab.get(i);
      // System.out.println(userVerif.getEmail()+" "+Email);
      String verifEmail = userVerif.getEmail();
      String verifMdp = userVerif.getMdp();

      if (verifEmail.compareTo(Email) == 0 && verifMdp.compareTo(mdp) == 0) {
        int id = userVerif.getid();
        return id;
      }
    }
    return (-1);

  }

  /**Méthode pour rechercher un utilisateur grace à son identifiant. 
   * @param id
   * @return
   */
  public static Utilisateur getUserByID(int id) {
    // code to be execut
    Utilisateur userVerif;
    for (int i = 0; i < UserTab.size(); i++) {

      userVerif = UserTab.get(i);

      int idTab = userVerif.getid();

      if (idTab == id) {

        return userVerif;
      }
    }
    return null;
  }

  // fonction qui cree un input string
  /**Méthode qui récupère les inputs de forme string.
   * @return
   */
  public static String getInputString() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    String input;
    input = scan.next();

    return (input);
  }

  // fonction qui cree un input Int
  /**Méthode qui récupère les inputs de forme int.
   * @return
   */
  public static int getInputInt() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    int input;
    input = scan.nextInt();

    return (input);
  }

  // ajoute un residant a la liste d'utilisateur en attente
  /**Méthode qui rajoute un résident nouvellement inscrit à la liste d'attente
   * en attendant la validation de son compte.
   */
  public static void NewResident() {

    // rentre le nom
    // Create a Scanner object
    System.out.println("Enter Votre nom ");
    String userNom = getInputString(); // Read user input

    // rentre le prenom

    System.out.println("Enter Votre prenom ");
    String userPrenom = getInputString();

    // rentre le mot de passe

    System.out.println("Enter Votre mot de passe ");
    String userMdp = getInputString();

    // rentre Telephone

    System.out.println("Enter Votre numero de Telephone ");
    String Telephone = getInputString();
    // rentre l'Email

    System.out.println("Enter Votre Email ");
    String userEmail = getInputString();

    // rentre l'adresse

    System.out.println("Enter Votre Adresse ");
    String userAdresse = getInputString();

    // rentre id

    System.out.println("Enter Le code unique fourni par la municipaliter ");
    int code = getInputInt();

    // ajoute l'utilisateur a une liste d'utilisateur en attandant que leur compte
    // soit valider
    attenteUser.add(new Resident(code, userNom, userPrenom, Telephone, userMdp, userEmail, userAdresse));
    updateUserTab();
  }

  // ajoute un conssomateur a la liste d'utilisateur en attente
  /**Méthode qui rajoute un consommateur nouvellement inscrit à la liste d'attente
   * en attendant la validation de son compte.
   * 
   */
  public static void NewConsomateur() {

    // rentre le nom
    // Create a Scanner object
    System.out.println("Enter Votre nom ");
    String userNom = getInputString(); // Read user input

    // rentre l'adresse

    System.out.println("Enter Votre Adresse ");
    String userAdresse = getInputString();

    // rentre le mot de passe

    System.out.println("Enter Votre mot de passe ");
    String userMdp = getInputString();
    // rentre l'Email

    System.out.println("Enter Votre Email ");
    String userEmail = getInputString();
    // rentre telephone
    System.out.println("Enter votre numero de telephone");
    String Telephone = getInputString();

    // rentre activiter
    System.out.println("Enter votre activiter");
    String activiter = getInputString();

    System.out.println("Enter le type de dechet que vous traite ");
    System.out.println("(vous pourrez en ajouter quand vous serez connecter)");
    String TypeDechet = getInputString();

    System.out.println("Enter votre capaciter de traitment");
    String capacite = getInputString();

    System.out.println("Enter Le code unique fourni par la municipaliter ");
    int code = getInputInt();

    // ajoute l'utilisateur a une liste d'utilisateur en attandant que leur compte
    // soit valider
    attenteUser.add(
        new Consomateur(code, userNom, userAdresse, userMdp, userEmail, Telephone, activiter, TypeDechet, capacite));
    updateUserTab();
  }

}
