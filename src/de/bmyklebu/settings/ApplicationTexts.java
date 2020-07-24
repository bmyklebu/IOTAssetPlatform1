package de.bmyklebu.settings;


/**
 * Enthaelt alle Programmtexte
 */
public class ApplicationTexts {

    //region 0 General messages and texts
    public static final String USER_MSG_PREFIX = "\n<<\t";
    public static final String USER_MSG_SUFFIX = "\t>>\n";
    public static final String USER_MSG_SAVE_SUCCESS = "save successful";
    public static final String USER_MSG_SAVE_FAILURE = "save unsuccessful";


    public static final String USER_MSG_PLEASE_ENTER_EVERYTHING = USER_MSG_PREFIX
            + "Please complete the fields"
            + USER_MSG_SUFFIX;




    //endregion

    //region 1 Private Constructor
    /**
     * Standard Constructor
     */
    private ApplicationTexts() {
        //private constructor - cannot be directly called outside of class
    }
    //endregion


}
