package de.bmyklebu.settings;

import de.bmyklebu.logic.CmdController;

import static de.bmyklebu.settings.UserCommands.*;

/**
 * Enthaelt alle Programmtexte
 */
public class ApplicationTexts {

    //region 1 Allgemeine Konstanten / Texte




    //endregion

    //region 3 Kundenverwaltungsmenu



    //endregion

    //region 4. Kundendaten Eingabeaufforderungstexte




    //endregion

    //region 5 BMI Text





    //region 5. UserMessages


    //region 3. Usernachrichten
    public static final String USER_MSG_PREFIX = "\n<<\t";
    public static final String USER_MSG_SUFFIX = "\t>>\n";



    public static final String USER_MSG_PLEASE_ENTER_EVERYTHING = USER_MSG_PREFIX
            + "Bitte alles ausfüllen"
            + USER_MSG_SUFFIX;



    public static final String USER_MSG_SAVED_SUCCESSFULLY   = USER_MSG_PREFIX
            + "Erfolgreich gespeichert"
            + USER_MSG_SUFFIX;

    //endregion

    //endregion

    //endregion

    //region 5. Privater Konstruktor

    /**
     * Standkonstruktor
     */
    private ApplicationTexts() {
        //Nichts zun tun ausser privat zu sein, damit kei Objekter ausserhalb generiert werden kann.
    }
    //endregion


}
