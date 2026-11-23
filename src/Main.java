package src;

import java.util.Scanner;

import src.clases.LlistaPacients;
import src.clases.Pacient;
import src.clases.PacientAltres;
import src.clases.PacientCardiologia;
import src.clases.PacientGinecologia;
import src.clases.PacientTraumatologia;

/**
 * Programa principal de la gestió de la sala d'espera d'urgències.
 * Mostra el menú i s'ocupa només de l'entrada/sortida amb l'usuari.
 */
public class Main {
    static Scanner teclat = new Scanner(System.in);


    /**
     * Mètode principal: crea la sala d'espera i mostra el menú fins que
     * l'usuari tria sortir.
     *
     * @param args no s'utilitzen
     */
    public static void main(String[] args) {
        LlistaPacients llista = new LlistaPacients(30);

        boolean sortir = false;
        while (!sortir) {
            mostrarMenu();
            int opcio = llegirEnter("Tria una opció: ");

            switch (opcio) {
                case 1:
                    afegirPacient(llista);
                    break;
                case 2:
                    System.out.println("Pendent: assignar grau d'urgència.");
                    break;
                case 3:
                    System.out.println("Pendent: incrementar el grau d'urgència a tothom.");
                    break;
                case 4:
                    System.out.println("Pendent: treure el pacient més urgent.");
                    break;
                case 5:
                    System.out.println("Pendent: guardar la sala (fitxer serialitzat).");
                    break;
                case 6:
                    System.out.println("Pendent: carregar la sala (fitxer serialitzat).");
                    break;
                case 7:
                    System.out.println("Pendent: carregar pacients d'un fitxer de text.");
                    break;
                case 8:
                    mostrarPacients(llista);
                    break;
                case 9:
                    System.out.println("Pendent: consultes.");
                    break;
                case 10:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
        teclat.close();
    }


    /**
     * Mostra les opcions del menú principal per pantalla.
     */
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Afegir un nou pacient a la sala d'espera.");
        System.out.println("2. Assignar el grau d'urgència a un pacient (cribratge).");
        System.out.println("3. Incrementar el grau d'urgència a tots els pacients.");
        System.out.println("4. Treure el pacient més urgent de la sala.");
        System.out.println("5. Guardar la sala en un fitxer serialitzat.");
        System.out.println("6. Carregar la sala d'un fitxer serialitzat.");
        System.out.println("7. Carregar pacients d'un fitxer de text.");
        System.out.println("8. Mostrar tots els pacients.");
        System.out.println("9. Consultes.");
        System.out.println("10. Sortir del programa.");
    }


    /**
     * Demana per teclat les dades d'un pacient nou, el crea segons la seva
     * especialitat i l'afegeix a la llista. Si la sala és plena, mostra un missatge.
     *
     * @param llista llista de pacients de la sala d'espera
     */
    public static void afegirPacient(LlistaPacients llista) {
        System.out.print("Codi: ");
        String codi = teclat.nextLine();
        System.out.print("Nom: ");
        String nom = teclat.nextLine();
        int edat = llegirEnter("Edat: ");
        System.out.print("Té al·lèrgia a algun medicament? (s/n): ");
        boolean alergia = teclat.nextLine().equalsIgnoreCase("s");

        System.out.println("Especialitat: 1. Ginecologia  2. Traumatologia  3. Cardiologia  4. Altres");
        int tipus = llegirEnter("Tria l'especialitat: ");

        Pacient p;
        switch (tipus) {
            case 1:
                System.out.print("És el primer fill? (s/n): ");
                boolean primerFill = teclat.nextLine().equalsIgnoreCase("s");
                System.out.print("Té diabetis gestacional? (s/n): ");
                boolean diabetis = teclat.nextLine().equalsIgnoreCase("s");
                p = new PacientGinecologia(codi, nom, edat, alergia, primerFill, diabetis);
                break;
            case 2:
                System.out.print("Zona del cos on té la lesió: ");
                String zona = teclat.nextLine();
                p = new PacientTraumatologia(codi, nom, edat, alergia, zona);
                break;
            case 3:
                int minuts = llegirEnter("Minuts des de l'inici dels símptomes: ");
                p = new PacientCardiologia(codi, nom, edat, alergia, minuts);
                break;
            case 4:
                System.out.print("Breu explicació del que li passa: ");
                String descripcio = teclat.nextLine();
                p = new PacientAltres(codi, nom, edat, alergia, descripcio);
                break;
            default:
                System.out.println("Especialitat no vàlida, no s'ha afegit el pacient.");
                return;
        }

        if (llista.afegir(p)) {
            System.out.println("Pacient afegit:" + p.toString());
        } else {
            System.out.println("La sala d'espera és plena, no es pot afegir el pacient.");
        }
    }


    /**
     * Mostra per pantalla tots els pacients de la sala, o un missatge si és buida.
     *
     * @param llista llista de pacients de la sala d'espera
     */
    public static void mostrarPacients(LlistaPacients llista) {
        if (llista.getNumElem() == 0) {
            System.out.println("La sala d'espera és buida.");
        } else {
            System.out.println(llista.toString());
        }
    }


    /**
     * Llegeix un número enter per teclat. Si l'usuari no escriu un número,
     * captura l'excepció i el torna a demanar.
     *
     * @param missatge text que es mostra abans de llegir
     * @return el número enter llegit
     */
    public static int llegirEnter(String missatge) {
        while (true) {
            System.out.print(missatge);
            try {
                return Integer.parseInt(teclat.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Cal escriure un número enter.");
            }
        }
    }


}
