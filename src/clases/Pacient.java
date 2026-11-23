package src.clases;
import java.io.Serializable;

/**
 * Classe abstracta que representa un pacient que arriba a la sala d'espera
 * d'urgències. Conté les dades comunes a totes les especialitats; cada
 * subclasse hi afegeix les seves dades i els seus punts extra d'urgència.
 */
public abstract class Pacient implements Serializable {
    private String codi;
    private String nom;
    private int edat;
    private boolean alergia;
    private double grauUrgencia;


    /**
     * Constructor de la classe Pacient.
     * El pacient arriba sense grau d'urgència (val -1 fins al cribratge).
     *
     * @param codi    codi identificador donat al mostrador
     * @param nom     nom del pacient
     * @param edat    edat del pacient en anys
     * @param alergia true si té al·lèrgia a algun medicament
     */
    public Pacient(String codi, String nom, int edat, boolean alergia) {
        this.codi = codi;
        this.nom = nom;
        this.edat = edat;
        this.alergia = alergia;
        this.grauUrgencia = -1;
    }


    /**
     * Retorna un String amb les dades comunes del pacient, amb salts de línia
     * i tabulacions.
     *
     * @return text amb la informació del pacient
     */
    @Override
    public String toString() {
        String aux = "\n\tCodi:" + codi + "\n\tNom:" + nom + "\n\tEdat:" + edat +
                "\n\tEspecialitat:" + getEspecialitat() + "\n\tAl·lèrgia:" + alergia +
                "\n\tGrau d'urgència:" + grauUrgencia;
        return aux;
    }


    /**
     * Consulta el codi identificador del pacient.
     *
     * @return el codi del pacient
     */
    public String getCodi() {
        return codi;
    }


    /**
     * Consulta el nom del pacient.
     *
     * @return el nom del pacient
     */
    public String getNom() {
        return nom;
    }


    /**
     * Consulta l'edat del pacient.
     *
     * @return l'edat en anys
     */
    public int getEdat() {
        return edat;
    }


    /**
     * Indica si el pacient té al·lèrgia a algun medicament.
     *
     * @return true si té al·lèrgia, false si no
     */
    public boolean getAlergia() {
        return alergia;
    }


    /**
     * Consulta el grau d'urgència del pacient.
     *
     * @return el grau d'urgència, o -1 si encara no s'ha fet el cribratge
     */
    public double getGrauUrgencia() {
        return grauUrgencia;
    }


    /**
     * Calcula el grau d'urgència del pacient: edat/20 més els punts extra
     * de la seva especialitat.
     *
     * @return el grau d'urgència calculat
     */
    public double calcularGrauUrgencia() {
        return edat / 20.0 + puntsExtra();
    }


    /**
     * Assigna al pacient el grau d'urgència calculat (moment del cribratge).
     */
    public void assignarGrauUrgencia() {
        grauUrgencia = calcularGrauUrgencia();
    }


    /**
     * Suma x punts al grau d'urgència del pacient, per simular que passa el temps.
     * Si encara no té grau assignat, no fa res.
     *
     * @param x punts a sumar
     */
    public void incrementarUrgencia(double x) {
        if (grauUrgencia != -1) {
            grauUrgencia = grauUrgencia + x;
        }
    }


    /**
     * Calcula els punts extra que l'especialitat suma al grau d'urgència.
     *
     * @return punts extra (0 si l'especialitat no en suma)
     */
    public abstract double puntsExtra();


    /**
     * Consulta el nom de l'especialitat del pacient.
     *
     * @return el nom de l'especialitat
     */
    public abstract String getEspecialitat();


}
