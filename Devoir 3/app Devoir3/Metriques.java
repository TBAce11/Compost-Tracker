import java.util.ArrayList;

public class Metriques {
    /**
     * Classe de calcul de toutes les métriques liées aux résidents à l'aide des données observées par les capteurs
     */
    int Nr, Pr, Nc, Pc, No, Po, masseTotale, tauxContamination, tauxDiversion;
    double facteurPN, facteurPNU, ecoScore;
    Capteur capteurRecyclage, capteurCompost, capteurOrdures;
    static ArrayList<Integer> UsageRecyclables = new ArrayList<>();
    static ArrayList<Integer> UsageCompostables = new ArrayList<>();
    static ArrayList<Integer> ProportionRecyclage = new ArrayList<>();
    static ArrayList<Integer> ProportionCompostage = new ArrayList<>();

    public Metriques() {
        this.capteurRecyclage = new Capteur();
        this.capteurCompost = new Capteur();
        this.capteurOrdures = new Capteur();
        this.Pr = capteurRecyclage.getPoidsBac();
        this.Pc = capteurCompost.getPoidsBac();
        this.Po = capteurOrdures.getPoidsBac();
        this.Nr = capteurRecyclage.getNiveauRemplissageBac();
        this.Nc = capteurCompost.getNiveauRemplissageBac();
        this.No = capteurOrdures.getNiveauRemplissageBac();
        this.masseTotale = masseTotale(this.Pr, this.Pc, this.Po);
        this.tauxContamination = tauxContamination(this.Pr, this.Pc, this.Po);
        this.tauxDiversion = tauxDiversion(this.Pr, this.Po);
        this.facteurPN = FacteurPN(this.Nr, this.Pr, this.Nc, this.Pc, this.No, this.Po);
        this.facteurPNU = FacteurPNU(this.Nr, this.Pr, this.Nc, this.Pc, this.No, this.Po);
        this.ecoScore = EcoScore(this.Nr, this.Pr, this.Nc, this.Pc, this.No, this.Po);
    }

    /**
     * Calcul de la masse totale des trois types de déchets émis par le résident
     * @param Pr
     *      Poids des déchets recyclables
     * @param Pc
     *      Poids des déchets compostables
     * @param Po
     *      Poids des ordures ménagères
     * @return Pr + Pc + Po
     *      Masse totale
     */
    public int masseTotale(int Pr, int Pc, int Po) {
        return Pr + Pc + Po;
    }

    /**
     * Calcul du taux de déchets recyclables contaminés
     * @param Pr
     *      Poids des déchets recyclables
     * @param Pc
     *      Poids des déchets compostables
     * @param Po
     *      Poids des ordures ménagères
     * @return taux
     *      Taux de contamination
     */
    public int tauxContamination(int Pr, int Pc, int Po) {
        double taux = ((double) Pr / (Pc + Po)) * 100;

        if (taux > 100) {
            taux = 100;
        }

        return (int) taux;
    }

    /**
     * Calcul du taux de matières recyclables réellement recyclées
     * @param Pr
     *      Poids des déchets recyclables
     * @param Po
     *      Poids des ordures ménagères
     * @return Pr / (Pr + Po) * 100
     *      Taux de diversion
     */
    public int tauxDiversion(int Pr, int Po) {
        return (int)(((double) Pr / (Pr + Po)) * 100);
    }

    /**
     * Calcul du facteur PN issu de l'ÉcoScore
     * @param Nr
     *      Niveau de remplissage des déchets recyclables
     * @param Pr
     *      Poids des déchets recyclables
     * @param Nc
     *      Niveau de remplissage des déchets compostables
     * @param Pc
     *      Poids des déchets compostables
     * @param No
     *      Niveau de remplissage des ordures ménagères
     * @param Po
     *      Poids des ordures ménagères
     * @return (PNr(Nr, Pr) + PNc(Nc, Pc)) / (PNo(No, Po) + 1)
     *      Facteur PN
     */
    public double FacteurPN(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
        return ((double) (PNr(Nr, Pr) + PNc(Nc, Pc)) / (PNo(No, Po) + 1));
    }

    /**
     * Calcul du facteur PNU issu de l'ÉcoScore
     * @param Nr
     *      Niveau de remplissage des déchets recyclables
     * @param Pr
     *      Poids des déchets recyclables
     * @param Nc
     *      Niveau de remplissage des déchets compostables
     * @param Pc
     *      Poids des déchets compostables
     * @param No
     *      Niveau de remplissage des ordures ménagères
     * @param Po
     *      Poids des ordures ménagères
     * @return (Math.log(PNr(Nr, Pr) * UR + PNc(Nc, Pc) * UC + 1) / ((PNo(No, Po) + 1)))
     *      Facteur PNU
     */
    public Double FacteurPNU(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
        UsageRecyclables.clear();
        UsageCompostables.clear();

        //Ajoute l'usage relatif aux déchets
        UsageRecyclables.add(80); //Er1
        UsageRecyclables.add(70); //Er2

        UsageCompostables.add(60); //Ec1
        UsageCompostables.add(90); //Ec2

        ///Ajoute des proportions relatives au bac
        //NR
        ProportionRecyclage.add(80);
        ProportionRecyclage.add(70);
        //NC
        ProportionCompostage.add(60);
        ProportionCompostage.add(90);

        int UR = 0;
        int UC = 0;

        for (int i = 0; i < UsageCompostables.size(); i++) {
            //recupere le bac correspondant
            UR += ProportionRecyclage.get(i) * UsageRecyclables.get(i);
            UC += ProportionCompostage.get(i) * UsageCompostables.get(i);
        }
        UR = UR / getMax(UsageCompostables);
        UC = UC / getMax(UsageCompostables);

        return (Math.log(PNr(Nr, Pr) * UR + PNc(Nc, Pc) * UC + 1) / ((PNo(No, Po) + 1)));

    }

    /**
     * Calcul de l'ÉcoScore
     * @param Nr
     *      Niveau de remplissage des déchets recyclables
     * @param Pr
     *      Poids des déchets recyclables
     * @param Nc
     *      Niveau de remplissage des déchets compostables
     * @param Pc
     *      Poids des déchets compostables
     * @param No
     *      Niveau de remplissage des ordures ménagères
     * @param Po
     *      Poids des ordures ménagères
     * @return FacteurPN(Nr, Pr, Nc, Pc, No, Po) / FacteurPNU(100, Pr, 100, Pc, 0, Po)
     *      ÉcoScore
     */
    public Double EcoScore(int Nr, int Pr, int Nc, int Pc, int No, int Po) {
        return (FacteurPN(Nr, Pr, Nc, Pc, No, Po) / FacteurPNU(100, Pr, 100, Pc, 0, Po));
    }

    //Calcul de facteurs
    public int PNr(int Nr, int Pr) {
        return Nr * Pr;
    }

    public int PNc(int Nc, int Pc) {
        return Nc * Pc;
    }

    public int PNo(int No, int Po) {
        return No * Po;
    }

    /**
     * Calcul de l'usage relatif des déchets maximal
     * @param tab
     *      Tableau des pourcentages d'usages relatifs des déchets
     * @return max
     *      Usage relatif des déchets maximal
     */
    public int getMax(ArrayList<Integer> tab) {
        int max = 0;
        for (int i = 0; i < tab.size(); i++) {
            //recupere le bac correspondant
            int value = tab.get(i);
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public int getMasseTotale() {
        return this.masseTotale;
    }

    public int getTauxContamination() {
        return this.tauxContamination;
    }

    public int getTauxDiversion() {
        return this.tauxDiversion;
    }

    public double getFacteurPN() {
        return this.facteurPN;
    }

    public double getFacteurPNU() {
        return this.facteurPNU;
    }

    public double getEcoScore() {
        return this.ecoScore;
    }

}