package src.clases;

/**
 * Pacient de traumatologia. Guarda la zona del cos on té la lesió.
 */
public class PacientTraumatologia extends Pacient {
    private String zonaLesio;


    /**
     * Constructor de la classe PacientTraumatologia.
     *
     * @param codi      codi identificador donat al mostrador
     * @param nom       nom del pacient
     * @param edat      edat del pacient en anys
     * @param alergia   true si té al·lèrgia a algun medicament
     * @param zonaLesio zona del cos on té la lesió
     */
    public PacientTraumatologia(String codi, String nom, int edat, boolean alergia, String zonaLesio) {
        super(codi, nom, edat, alergia);
        this.zonaLesio = zonaLesio;
    }


    /**
     * Retorna un String amb les dades del pacient.
     *
     * @return text amb la informació del pacient
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tZona de la lesió:" + zonaLesio;
    }


    /**
     * Consulta la zona del cos on el pacient té la lesió.
     *
     * @return la zona de la lesió
     */
    public String getZonaLesio() {
        return zonaLesio;
    }


    /**
     * Traumatologia no suma punts extra al grau d'urgència.
     *
     * @return 0
     */
    @Override
    public double puntsExtra() {
        return 0;
    }


    /**
     * Consulta el nom de l'especialitat.
     *
     * @return "Traumatologia"
     */
    @Override
    public String getEspecialitat() {
        return "Traumatologia";
    }


}
