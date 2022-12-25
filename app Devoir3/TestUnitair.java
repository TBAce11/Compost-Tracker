import java.util.ArrayList;

public class TestUnitair {

    public static void main(String[] args) {
        System.out.println(TestUnitairIS());
    }

    // Test Ismail Simo 20153080
    // cette fonction fait trois test unitaire de succes ,d'Echec et sanitaire
    // elle return un Boolean qui est True seulment si les 3 teste sont valider
    public static Boolean TestUnitairIS() {
        // on genere la liste de conssomateur dans MunicipInfo
        MunicipInfo.ListConsomateur();
        // test succes---------------------------
        // on en parametre l'id du consommateur que on veut recuperer
        // pour id=12 on doit avoir le conssomateur quia pour nom Consomateur12
        Consomateur test1 = MunicipInfo.getConsommateur(12);
        // le nom du conssomateur
        String test1Nom = test1.getNom();
        // Boolean qui prend true si le test est valide sinon false
        Boolean resultTest1;
        if ("Consomateur12".compareTo(test1Nom) == 0) {
            resultTest1 = true;
        } else {
            resultTest1 = false;
        }
        // test Echec---------------------------
        // pour id=20 on doit avoir la valeur null
        Consomateur test2 = MunicipInfo.getConsommateur(20);
        Boolean resultTest2;
        if (test2 == null) {
            resultTest2 = true;
        } else {
            resultTest2 = false;
        }

        // test sanitaire---------------------------
        // pour id=12 on doit avoir le conssomateur qui a pour nom Consomateur12 en
        // plusiere etape
        // reccupere le consomateur qui a pour id 12 on recupere sont id
        // avec l'id que on a recuperer on recherche le conssomateur avec l'id
        Consomateur test3 = MunicipInfo.getConsommateur(MunicipInfo.getConsommateur(12).getid());
        // le nom du conssomateur
        String test3Nom = test3.getNom();
        // Boolean qui prend true si le test est valide sinon false
        Boolean resultTest3;
        if ("Consomateur12".compareTo(test3Nom) == 0) {
            resultTest3 = true;
        } else {
            resultTest3 = false;
        }

        return (resultTest1 && resultTest2 && resultTest3);
    }

    // Testes fait par Christie Embeya Kongandji, matricule:20170397
    // les variables Resultat1 et Resultat3 sont initialisés avec des
    // valeurs par défauts soit false et Resultat2 è true.
    // j'utilise une boucle "for" pour parcourir la liste de Bac et mettre fin à la
    // boucle dès qu'un test est concluant.
    // retourne la conjonction des résultats de chaque test
    public static boolean TestUnitairCh() {

        MunicipInfo Municip = new MunicipInfo();

        Bac bac1 = new Bac(4, "5575", "12 mai", "indeterminé");
        Municip.addBac(bac1);
        int idTest1 = 4;
        int idTest2 = 5;

        ArrayList<Bac> Bac = ReadBac.getBacsDatabase();
        boolean Resultat1 = false;

        for (int i = 0; i < Bac.size(); i++) {
            Bac serchBac = Bac.get(i);
            // Tester son succès
            // Pour une entrée correcte, on retourne "4"
            if (idTest1 == serchBac.getid()) {
                Resultat1 = true;
                break;

            }
        }

        Boolean Resultat2 = true;
        for (int n = 0; n < Bac.size(); n++) {
            Bac serchBac2 = Bac.get(n);

            if (idTest2 == serchBac2.getid()) {
                Resultat2 = false;
                break;
            }
        }
        Boolean Resultat3 = false;
        for (int x = 0; x < Bac.size(); x++) {
            Bac serchBac3 = Bac.get(x);

            if (idTest1 == serchBac3.getid()) {
                Resultat3 = true;
                break;
            }
        }
        return Resultat1 && Resultat2 && Resultat3;

    }
}
