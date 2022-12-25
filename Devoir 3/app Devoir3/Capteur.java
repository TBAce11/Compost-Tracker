public class Capteur {
    int poidsBac, niveauRemplissageBac;

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