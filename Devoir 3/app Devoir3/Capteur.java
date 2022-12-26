public class Capteur {
    private int poidsBac, niveauRemplissageBac;

    /**
     * Instancie un poids allant de 1 à 25kg et un pourcentage de niveau de remplissage aux capteurs des trois
     * catégories de déchets émis par les résidents
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