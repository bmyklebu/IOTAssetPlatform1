package de.bmyklebu.logic;

import de.bmyklebu.model.Asset;
import de.rhistel.ConsoleReader;

import java.util.List;

import static de.bmyklebu.settings.ApplicationTexts.*;
import static de.bmyklebu.settings.UserCommands.*;

/**
 * Startet den Aufbau der
 * verschiedenen Programmteile
 * und kontrolliert den Programmflussad
 */
public class CmdController {
    //region 0.Konstanten
    private static final int NON_VALID_INDEX_VALUE = -1;
    //endregion

    //region 1. Decl. and Init Attribute / Variablen

    /**
     * Enthaelt alle Kunden die zur Laufzeit
     * gelesen, angelegt, geaendert oder geloescht werden.
     */
    private List<Asset> listOfAllAssets;

    //endregion

    //region 2. Konstruktor

    /**
     * Standardkonstruktor
     * zum direkten generieren
     * der Kundenliste {@link CmdController#listOfAllAssets}
     */
    public CmdController() {

        //Generiert eine leere Kundenliste
        this.listOfAllAssets = CsvFileHandler.getInstance().readCustomersFromFile();

    }
    //endregion


    //region 3. Hauptmenus

    /**
     * Gibt den Programmnamen und das Hauptmenu aus und
     * wertet den die Usereingabe aus um die weiteren
     * Programmfunktionen passend dazu einzuleitet
     */




    //endregion

    //region 4. Kundenverwaltung



    /**
     * Legt einen neuen Kunden an
     */
//    private void addNewCustomer() {
//
//        //Alle Kundendaten auslesen bei Falscheingabe ist der Rueckgabewert null
//        Asset assetFromUi = this.getCustomerDataFromUi();
//
//        //Checken ob alle Daten richtig waren
//        if (assetFromUi != null) {
//
//            //Einen neuen Kunden zur Liste hinzufuegenA
//            this.listOfAllAssets.add(assetFromUi);
//
//            //Veraenderung in die Dateis speichern
//            CsvFileHandler.getInstance().saveCustomersToCsvFile(this.listOfAllAssets);
//
//            //Usernachricht Aktualisierung war erfolgreich
//            System.out.println(USER_MSG_SAVED_SUCCESSFULLY);
//        }
//    }


    /**
     * TODO UPDATE
     * Aendert einen durch den Index bestimmten Kunden innerhalb
     * der Liste.
     */
//
//    private void updateCustomer() {
//
//        //Checken ob die Liste nicht leer ist
//        if (!this.checkIfCustomerListIsEmpty()) {
//
//            //Alle Kunden anzeigen lassen
//            this.showAllCustomers();
//
//            //Index auslesen
//            int indexOfCustomerToEdit = this.getValidIndex();
//
//            //Checken ob der eingelesene Index gueltig ist
//            if (indexOfCustomerToEdit > NON_VALID_INDEX_VALUE) {
//
//                //Alle Kundendaten auslesen bei Falscheingabe ist der Rueckgabewert null
//                Asset editedAsset = this.getCustomerDataFromUi();
//
//                //Checken ob alle Daten richtig waren
//                if (editedAsset != null) {
//
//                    //Einen bestehenden Kunden in der  Liste mit den neuen Daten ersetzen
//                    this.listOfAllAssets.set(indexOfCustomerToEdit, editedAsset);
//
//                    //Veraenderung in die Dateis speichern
//                    CsvFileHandler.getInstance().saveCustomersToCsvFile(this.listOfAllAssets);
//
//                    //Usernachricht Aktualisierung war erfolgreich
//                    System.out.println(USER_MSG_UPDATED_SUCCESSFULLY);
//                }
//
//            }
//
//        }
//
//    }

    /**
     * TODO DELETE
     * Zeigt alle Kunden an, erwartet eine Usersereingabe
     * des Indizes des Kunden der geloscht werden soll.
     * Macht eine Sicherheitsabfrage und loescht den Kunden
     */



    /**
     * Kunde ausgeben mit der ToStringFunktion
     * Zeigt alle erfassten Kunden an
     */
//    private void showAllCustomers() {
//
//        if (!this.checkIfCustomerListIsEmpty()) {
//
//            /**
//             * Ausgbae wenn der Index benotigt wird um
//             * zum Beispiel einen speziellen Kunden auszuwaehlen/zu identifizieren
//             */
//            String strCustomerFormatPattern = INDEX_TEXT + " [ %s ]"
//                    + FIRST_NAME_TEXT + " %s"
//                    + LAST_NAME_TEXT + " %s"
//                    + BDAY_TEXT + " %s";
//
//            for (int index = 0; index < listOfAllAssets.size(); index++) {
//
//                //Aktueller Kunde aus Kundenliste auslesen
//                Asset m = listOfAllAssets.get(index);
//
//                System.out.println(
//                        String.format(strCustomerFormatPattern, index, m.getAssetID(), m.getAssetName(), m.getAssetType()));
//            }
//
//            System.out.println("\n");
//
//        }
//    }


    //endregion

    //region 5. BMI-Berechnung

//    private int getValidIndex() {
//        //Userausgabe zur Eingabeauafforderung
//        int indexToReturn = NON_VALID_INDEX_VALUE;
//
//        int indexFromUi = readIntUserCmd(true);
//
//        if ((indexFromUi > -1) && (indexFromUi < listOfAllAssets.size())) {
//            indexToReturn = indexFromUi;
//        } else {
//            System.out.println(USER_MSG_NO_SUCH_INDEX);
//        }
//
//        return indexToReturn;
//    }

    /**
     * Ueberprueft ob die Liste leer ist.
     * Sollte Sie leer sein gibt diese Methode
     * eine passende Hinweismeldung aus
     *
     * @return isEmpty : boolean : true == Leer Liste - false == Liste ist nicht leer
     * Meldung wurde ausgegeben
     */
//    private boolean checkIfCustomerListIsEmpty() {
//        boolean isEmpty = listOfAllAssets.isEmpty();
//
//        if (isEmpty) {
//            System.out.println(USER_MSG_NO_CUSTOMERS_YET);
//        }
//        return isEmpty;
//    }

    /**
     * Liest die Usereingabe aus und gibt Sie zurueck
     *
     * @param isIndex : boolean : true == Index Eingabauffroderung wird
     *                gedruckt false == Wird nicht gedruckt
     *
     * @return iUserCmd : int : Usereingabekommando
     */
//    private int readIntUserCmd(boolean isIndex) {
//        int iUserCmd = -1;
//
//        //Eingabeaufforderung
//        if (isIndex) {
//            //Index auslesen
//            System.out.println(INPUT_PREFIX + ENTER_INDEX);
//            iUserCmd = ConsoleReader.readIntValue();
//        }else{
//            //Menuoption auslesen
//            iUserCmd = ConsoleReader.readIntOption();
//        }
//
//        return iUserCmd;
//    }


    //endregion

}