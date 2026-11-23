package src.clases;

/**
 * Pacient de cardiologia. Guarda els minuts que han passat des de l'inici
 * dels símptomes.
 */
public class PacientCardiologia extends Pacient {
    private int minutsSimptomes;


    /**
     * Constructor de la classe PacientCardiologia.
     *
     * @param codi            codi identificador donat al mostrador
     * @param nom             nom del pacient
     * @param edat            edat del pacient en anys
     * @param alergia         true si té al·lèrgia a algun medicament
     * @param minutsSimptomes minuts des de l'inici dels símptomes
     */
    public PacientCardiologia(String codi, String nom, int edat, boolean alergia, int minutsSimptomes) {
        super(codi, nom, edat, alergia);
        this.minutsSimptomes = minutsSimptomes;
    }


    /**
     * Retorna un String amb les dades del pacient.
     *
     * @return text amb la informació del pacient
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tMinuts des dels símptomes:" + minutsSimptomes;
    }


    /**
     * Consulta els minuts des de l'inici dels símptomes.
     *
     * @return els minuts
     */
    public int getMinutsSimptomes() {
        return minutsSimptomes;
    }


    /**
     * Calcula els punts extra: 0.1 per cada 5 minuts des de l'inici dels
     * símptomes (divisió entera: 22 minuts donen 0.4).
     *
     * @return punts extra del pacient
     */
    @Override
    public double puntsExtra() {
        return (minutsSimptomes / 5) * 0.1;
    }


    /**
     * Consulta el nom de l'especialitat.
     *
     * @return "Cardiologia"
     */
    @Override
    public String getEspecialitat() {
        return "Cardiologia";
    }


}
