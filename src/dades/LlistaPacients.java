package src.dades;
import java.io.Serializable;

/**
 * Llista dels pacients de la sala d'espera d'urgències, implementada amb una
 * taula i un comptador d'elements (sense estructures de dades predefinides de Java).
 */
public class LlistaPacients implements Serializable {
    private Pacient[] llista;
    private int nElem;


    /**
     * Constructor que crea una llista buida amb capacitat per a mida pacients.
     *
     * @param mida nombre màxim de pacients que caben a la sala (30)
     */
    public LlistaPacients(int mida) {
        llista = new Pacient[mida];
        nElem = 0;
    }


    /**
     * Consulta el nombre de pacients que hi ha a la llista.
     *
     * @return nombre de pacients guardats
     */
    public int getNumElem() {
        return nElem;
    }


    /**
     * Consulta el pacient d'una posició de la llista.
     *
     * @param pos posició a consultar (de 0 a getNumElem()-1)
     * @return el pacient de la posició, o null si la posició no és vàlida
     */
    public Pacient getElement(int pos) {
        if (pos < 0 || pos >= nElem)
            return null;
        return llista[pos];
    }


    /**
     * Retorna un String amb tots els pacients de la llista, numerats.
     *
     * @return text amb el contingut de la llista
     */
    @Override
    public String toString() {
        String aux = "Llista amb " + nElem + " pacients:";
        for (int i = 0; i < nElem; i++) {
            aux = aux + "\n" + (i + 1) + ":" + llista[i].toString();
        }
        return aux;
    }


   /**
 * Afegeix un pacient al final de la llista (ordre d'arribada).
 * 
 * @param p pacient que arriba a la sala d'espera
 * @return true si s'ha pogut afegir el pacient, false si la sala ja és plena
 */
public boolean afegir(Pacient p) {
    if (nElem == llista.length) {
        // La sala ja és plena, no es pot afegir el pacient
        return false;
    }
    
    llista[nElem] = p;
    nElem++;
    return true;
}



    /**
     * Elimina de la llista el pacient amb el codi indicat, desplaçant els
     * elements següents perquè no quedin posicions buides.
     *
     * @param codi codi identificador del pacient a eliminar
     * @return el pacient eliminat, o null si no hi ha cap pacient amb aquest codi
     */
    public Pacient eliminar(String codi) {
        int i = 0;
        while (i < nElem && !llista[i].getCodi().equalsIgnoreCase(codi)) {
            i++;
        }
        if (i == nElem) // no s'ha trobat
            return null;
        Pacient eliminat = llista[i];
        // desplacem a l'esquerra tots els elements a partir de i
        for (int j = i; j < nElem - 1; j++) {
            llista[j] = llista[j + 1];
        }
        llista[nElem - 1] = null;
        nElem--;
        return eliminat;
    }


    /**
     * Assigna el grau d'urgència (cribratge) al pacient amb el codi indicat.
     *
     * @param codi codi identificador del pacient
     * @return true si s'ha trobat el pacient, false si no
     */
    public boolean assignarGrau(String codi) {
        // TODO
        return false;
    }


    /**
     * Suma x punts al grau d'urgència de tots els pacients de la llista.
     *
     * @param x punts a sumar
     */
    public void incrementarUrgencia(double x) {
        // TODO
    }


    /**
     * Treu de la llista el pacient amb el grau d'urgència més alt. En cas
     * d'empat, el que va arribar primer.
     *
     * @return el pacient tret, o null si la llista és buida
     */
    public Pacient treureMesUrgent() {
        // TODO
        return null;
    }


    /**
     * Compta quants pacients hi ha d'una especialitat.
     *
     * @param especialitat nom de l'especialitat (no distingeix majúscules i minúscules)
     * @return nombre de pacients de l'especialitat
     */
    public int comptarEspecialitat(String especialitat) {
        // TODO
        return 0;
    }


    /**
     * Busca el grau d'urgència més alt d'una especialitat.
     *
     * @param especialitat nom de l'especialitat (no distingeix majúscules i minúscules)
     * @return el grau més alt, o -1 si no hi ha cap pacient d'aquesta especialitat
     */
    public double maxUrgenciaEspecialitat(String especialitat) {
        // TODO
        return -1;
    }


    /**
     * Compta quants pacients tenen al·lèrgia a algun medicament.
     *
     * @return nombre de pacients amb al·lèrgia
     */
    public int comptarAlergies() {
        // TODO
        return 0;
    }


    /**
     * Compta quantes pacients de ginecologia tenen diabetis gestacional.
     *
     * @return nombre de pacients amb diabetis gestacional
     */
    public int comptarDiabetisGestacional() {
        // TODO
        return 0;
    }


    /**
     * Compta quants pacients de cardiologia porten més de x minuts des de
     * l'inici dels símptomes.
     *
     * @param x minuts amb què es compara
     * @return nombre de pacients de cardiologia amb més de x minuts
     */
    public int comptarCardiologiaMesMinuts(int x) {
        // TODO
        return 0;
    }


}
