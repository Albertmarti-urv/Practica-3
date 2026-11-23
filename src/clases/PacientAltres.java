package src.clases;

/**
 * Pacient d'altres especialitats. Guarda una breu explicació del que li passa.
 */
public class PacientAltres extends Pacient {
    private String descripcio;


    /**
     * Constructor de la classe PacientAltres.
     *
     * @param codi       codi identificador donat al mostrador
     * @param nom        nom del pacient
     * @param edat       edat del pacient en anys
     * @param alergia    true si té al·lèrgia a algun medicament
     * @param descripcio breu explicació que ha donat el pacient
     */
    public PacientAltres(String codi, String nom, int edat, boolean alergia, String descripcio) {
        super(codi, nom, edat, alergia);
        this.descripcio = descripcio;
    }


    /**
     * Retorna un String amb les dades del pacient.
     *
     * @return text amb la informació del pacient
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tDescripció:" + descripcio;
    }


    /**
     * Consulta la breu explicació del pacient.
     *
     * @return la descripció
     */
    public String getDescripcio() {
        return descripcio;
    }


    /**
     * Aquesta especialitat no suma punts extra al grau d'urgència.
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
     * @return "Altres"
     */
    @Override
    public String getEspecialitat() {
        return "Altres";
    }


}
