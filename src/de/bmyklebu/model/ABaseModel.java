package de.bmyklebu.model;

/**
 * this abstract class
 * defines all methods and characteristics
 * that should be used in the model classes.
 */
public abstract class ABaseModel {

    //region 0. Konstanten
    protected static final String DEF_VALUE_STR = ">noValueYet<";
    protected static final int    DEF_VALUE_INT = -1;
    protected static final boolean DEF_VALUE_BOOLEAN = false;


    protected static final String DATA_ATTRIBUTE_SPLITTER = ";";
    //endregion

    //region 1. Decl. and Init Attributes
    //endregion

    //region 2. Constructor

    //endregion

    //region 3. Getter und Setter

    //endregion

    //region 4. special methods and Functions

    /**
     * defines a method which has to be implemented in the derived child class
     * @return strCsvLine : {@link String} : CSV-Lines of concrete derived child classes
     */
    public abstract String getAllAttributesAsCsvLine();

    /**
     * Definiert diese Funktion vor, sodass alle abgeleitetet
     * Klasse diese Funktion implementieren muessen, da sich
     * die konrkete Funktionalitaet jedoch von Modelklasse
     * zu Modleklasse, wenn auch teilweise minimal. unterscheidt ist
     * hier das Schluesselwort abstract gewaehlt worden, und eine konkrete
     * Implementierung soll hier in dieser Klasse nicht stattfinden.
     * creates a definition
     *
     * @param strCsvLine : {@link String} : CSV-Zeile der konkret abgleiteten Kindklasse die alle Attribute
     *                   setzt
     */
    public abstract void setAllAttributesFromCsvLine(String strCsvLine) throws Exception;

    //public abstract String getAssetName();

    //endregion


}
