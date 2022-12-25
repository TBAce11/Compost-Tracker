public class Capteur {

    /**
     * Classe de capteur individuel prenant les mesures de poids (max: 25kg) et de remplissage de chaque type de résidu
     * @author Tarik Benakezouh
     */
    int poidsBac, niveauRemplissageBac;

    /**
     *
     *
     */
    public Capteur() {
        do {
            this.poidsBac = (int) (Math.random() * 25); //moyenne de kilogrammes maximum permis dans la ville
        } while (this.poidsBac == 0);
        this.niveauRemplissageBac = (int) (Math.random() * 100);
    }

    public int getPoidsBac() {
        return this.poidsBac;
    }

    public int getNiveauRemplissageBac() {
        return this.niveauRemplissageBac;
    }
}