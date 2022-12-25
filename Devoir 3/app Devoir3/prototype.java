import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList clas
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;

class prototype {
  public static void main(String[] args) throws FileNotFoundException {

    ResidentTab = ReadResident.getResidentsDatabase();
    updatUserTab();
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
  public static void mainMenu() {

    System.out.println("MAIN MENU ");
    System.out.println("1-Connexion");
    System.out.println("2-S'inscrire Comme resident");
    System.out.println("3-S'inscrire Comme Consomateur");

    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");

    GestionmMainmenu();

  }

  // tab qui contient tous les utilisateur resident et consomateur
  public static void updatUserTab() {
    UserTab.clear();
    UserTab.addAll(ResidentTab);
    UserTab.addAll(Municip.ListConsomateur());

  }

  // changer dongler au menu
  public static void GestionmMainmenu() {
    int menu1 = getInputInt();
    // si on s'inscrie
    if (menu1 == 1) {
      Utilisateur ActualUser = MenuConnexion();
      if (ActualUser == null) {
        System.out.println("réessayer taper '1','2' ou '3' pour changer d'onglet");
        GestionmMainmenu();
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
      GestionmMainmenu();
    }

  }

  // ------------------------------------------------------------------------------------
  // ------------------------------------------------------------------------------------
  // menu quand un resident est connecte
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
    GestionsMenuResident(ActualResident);
  }

  // menu quand un consomateur est connecte
  public static void MenuConsomateur(Consomateur ActualUser) {

    System.out.println("Menu Consomateur de l'utilisateur " + ActualUser.getNom());
    System.out.println("0-Revenir au menus principale");
    System.out.println("1-Notifier les résidents");
    System.out.println("2-Modifier mon Profil");
    System.out.println("3-Ajouter une activité");
    System.out.println("4-Supprimer une activité");

    System.out.println("\nEnter le numero corespondant a longlet que vous voulais visiter ");
    GestionsMenuConssomateur(ActualUser);
  }

  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------
  // methode des menu de resident

  public static void GestionsMenuResident(Resident ActualResident) {
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
      Etatbacs(ActualResident);

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

      SignalerProblEme(ActualResident);
    }
    // si le Resident veux Trouver un consommateur
    else if (input == 6) {
      Trouverconsomateur(ActualResident);

    } else if (input == 7) {
      ModifProfil(ActualResident);

    }
    else if (input == 8) {
      noterActivite(ActualResident);

    }
    // si le Resident rentre un mauvais input
    else {
      System.out.println("réessayer taper '0' ou '1' pour changer d'onglet");
      GestionsMenuResident(ActualResident);
    }
  }

  // methode des action de resident
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
      updatUserTab();
      }
    }
     catch (IOException exception) {
      System.out.println("L'activité n'a pas été notée");
    }
    MenuResident(ActualResident);
  }






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

  public static void Etatbacs(Resident ActualResident) {
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

  public static void Metriques(Resident ActualResident) {

    System.out.println("Enter le Niveau de remplissage du bac de recyclage ");
    int Nr = getInputInt();

    System.out.println("Enter le Niveau de remplissage du bac de compostage ");
    int Nc = getInputInt();

    System.out.println("Enter le Niveau de remplissage du bac des ordures ");
    int No = getInputInt();

    System.out.println("Enter le Poids du recyclage ");
    int Pr = getInputInt();

    System.out.println("Enter le  Poids du compostage ");
    int Pc = getInputInt();

    System.out.println("Enter le Poids des ordures ");
    int Po = getInputInt();

    System.out.println("  Masse= " + MetriqueMasseTotal(Pr, Pc, Po));
    System.out.println("  Facteur PN = " + FacteurPN(Nr, Pr, Nc, Pc, No, Po));
    System.out.println("  Facteur PNU =" + FacteurPNU(Nr, Pr, Nc, Pc, No, Po));
    System.out.println("  Score ECOLO = " + Score(Nr, Pr, Nc, Pc, No, Po));
    System.out.println("taux de contamination = " + tauxContamination(Pr, Pc, Po));
    System.out.println("taux de diversion = " + tauxDiversion(Pr));
    MenuResident(ActualResident);

  }

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
        GestionsMenuResident(ActualResident);
      } else if (0 == LotTraitment.getid()) {
        GestionsMenuResident(ActualResident);
      } else {
        EtatTraitement(ActualResident);
      }

    }

  }

  public static void SignalerProblEme(Resident ActualResident) {
    String message = getInputString();
    Municip.postMessage(message);
    GestionsMenuResident(ActualResident);
  }

  // fonction qui oriente et effectu la recherche de consomateur
  public static void Trouverconsomateur(Resident ActualResident) {
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
        Trouverconsomateur(ActualResident);
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
          Trouverconsomateur(ActualResident);

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
      Trouverconsomateur(ActualResident);

    } else {
      System.out.println("réessayer taper '0','1'ou '2' pour changer d'onglet");
      Trouverconsomateur(ActualResident);
    }

  }

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
        updatUserTab();
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

  public static void GestionsMenuConssomateur(Consomateur ActualConsomateur) {
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
          updatUserTab();
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
      GestionsMenuConssomateur(ActualConsomateur);
    }
  }

  // methode des action de consomateur
  public static void ajouterType(Consomateur ActualUser, String type) {

    ActualUser.newTypeDechet(type);
    updatUserTab();
  }

  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------

  // conexxion recupere les input
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
  public static String getInputString() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    String input;
    input = scan.next();

    return (input);
  }

  // fonction qui cree un input Int
  public static int getInputInt() {
    // code to be executed
    Scanner scan = new Scanner(System.in);
    int input;
    input = scan.nextInt();

    return (input);
  }

  // ajoute un residant a la liste d'utilisateur en attente
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
    updatUserTab();
  }

  // ajoute un conssomateur a la liste d'utilisateur en attente
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
    updatUserTab();
  }

  // ----------------------------------------------------------------------------
  // ----------------------------------------------------------------------------
  // les metrique
  public static int MetriqueMasseTotal(int Pr, int Pc, int Po) {
    return Pr + Pc + Po;
  }

  public static int tauxContamination(int Pr, int Pc, int Po) {
    return Pr / (Pc + Po) * 100;
  }

  public static int tauxDiversion(int Pr) {
    // poids qui a reussi a etre recycler arbitraire (70%)
    int poidRecycler = Pr * (70 * 100);
    return poidRecycler / Pr * 100;
  }

  public static int FacteurPN(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
    return ((PNr(Nr, Pr) + PNc(Nc, Pc)) / (PNo(No, Po) + 1));
  }

  public static Double FacteurPNU(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
    // reste les table
    Usagerecyclables.clear();
    UsageCompostables.clear();
    // AJOUTE DE Usage relatif des déchets
    // ER1
    Usagerecyclables.add(80);
    Usagerecyclables.add(70);
    // EC1
    UsageCompostables.add(60);
    UsageCompostables.add(90);
    /// AJOUTE DE Proportions bac
    // NR
    ProportionRecyclage.add(80);
    ProportionRecyclage.add(70);
    // NC
    ProportionCompostage.add(60);
    ProportionCompostage.add(90);

    int UR = 0;
    int UC = 0;
    for (int i = 0; i < UsageCompostables.size(); i++) {
      // recupere le bac correspondant
      UR += ProportionRecyclage.get(i) * Usagerecyclables.get(i);
      UC += ProportionCompostage.get(i) * UsageCompostables.get(i);
    }
    UR = UR / getMax(UsageCompostables);
    UC = UC / getMax(UsageCompostables);

    return (Math.log(PNr(Nr, Pr) * UR + PNc(Nc, Pc) * UC + 1) / ((PNo(No, Po) + 1)));

  }

  public static Double Score(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
    return FacteurPN(Nr, Pr, Nc, Pc, No, Po) / FacteurPNUIdeal(Nr, Pr, Nc, Pc, No, Po);
  }

  // facteur
  public static int PNr(int Nr, int Pr) {
    return Nr * Pr;
  }

  public static int PNc(int Nc, int Pc) {
    return Nc * Pc;
  }

  public static int PNo(int No, int Po) {
    return No * Po;
  }

  // Usage relatif des déchets
  static ArrayList<Integer> Usagerecyclables = new ArrayList<>();

  static ArrayList<Integer> UsageCompostables = new ArrayList<>();

  // Proportions bac
  static ArrayList<Integer> ProportionRecyclage = new ArrayList<>();

  static ArrayList<Integer> ProportionCompostage = new ArrayList<>();

  public static int getMax(ArrayList<Integer> tab) {
    int max = 0;
    for (int i = 0; i < tab.size(); i++) {
      // recupere le bac correspondant
      int value = tab.get(i);
      if (max < value) {
        max = value;
      }

    }
    return max;
  }

  public static Double FacteurPNUIdeal(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
    // reste les table
    Usagerecyclables.clear();
    UsageCompostables.clear();
    // AJOUTE DE Usage relatif des déchets
    // ER1
    Usagerecyclables.add(80);
    Usagerecyclables.add(70);
    // EC1
    UsageCompostables.add(60);
    UsageCompostables.add(90);
    /// AJOUTE DE Proportions bac
    // NR
    ProportionRecyclage.add(80);
    ProportionRecyclage.add(70);
    // NC
    ProportionCompostage.add(60);
    ProportionCompostage.add(90);
    Nr = 100;
    Nc = 100;
    No = 0;

    int UR = 0;
    int UC = 0;
    for (int i = 0; i < UsageCompostables.size(); i++) {
      // recupere le bac correspondant
      UR += ProportionRecyclage.get(i) * Usagerecyclables.get(i);
      UC += ProportionCompostage.get(i) * UsageCompostables.get(i);
    }
    UR = UR / getMax(UsageCompostables);
    UC = UC / getMax(UsageCompostables);

    return (Math.log(PNr(Nr, Pr) * UR + PNc(Nc, Pc) * UC + 1) / ((PNo(No, Po) + 1)));

  }

}
