package src.clases;

/**
 * Pacient de ginecologia: dona que està de part. Guarda si és el primer
 * fill i si té diabetis gestacional.
 */
public class PacientGinecologia extends Pacient {
    private boolean primerFill;
    private boolean diabetisGestacional;


    /**
     * Constructor de la classe PacientGinecologia.
     *
     * @param codi                codi identificador donat al mostrador
     * @param nom                 nom de la pacient
     * @param edat                edat de la pacient en anys
     * @param alergia             true si té al·lèrgia a algun medicament
     * @param primerFill          true si és el primer fill
     * @param diabetisGestacional true si té diabetis gestacional
     */
    public PacientGinecologia(String codi, String nom, int edat, boolean alergia,
            boolean primerFill, boolean diabetisGestacional) {
        super(codi, nom, edat, alergia);
        this.primerFill = primerFill;
        this.diabetisGestacional = diabetisGestacional;
    }


    /**
     * Retorna un String amb les dades de la pacient.
     *
     * @return text amb la informació de la pacient
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tPrimer fill:" + primerFill +
                "\n\tDiabetis gestacional:" + diabetisGestacional;
    }


    /**
     * Indica si és el primer fill.
     *
     * @return true si és el primer fill
     */
    public boolean getPrimerFill() {
        return primerFill;
    }


    /**
     * Indica si la pacient té diabetis gestacional.
     *
     * @return true si té diabetis gestacional
     */
    public boolean getDiabetisGestacional() {
        return diabetisGestacional;
    }


    /**
     * Calcula els punts extra: 0.3 si és el primer fill i 0.5 si té
     * diabetis gestacional.
     *
     * @return punts extra de la pacient
     */
    @Override
    public double puntsExtra() {
        double punts = 0;
        if (primerFill)
            punts = punts + 0.3;
        if (diabetisGestacional)
            punts = punts + 0.5;
        return punts;
    }


    /**
     * Consulta el nom de l'especialitat.
     *
     * @return "Ginecologia"
     */
    @Override
    public String getEspecialitat() {
        return "Ginecologia";
    }


}
