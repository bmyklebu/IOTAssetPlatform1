package de.bmyklebu.model;

/**
 * Diese Klasse repraesentiert
 * einen Kunden. Mit folgenden
 * Eigenschaften.
 * <p>
 * Diese Klasse ist eine Modelklasse,
 * Datenhaltungsklasse.
 * [P]lain [O]ld [J]ava [O]bject - Klasse
 * <p>
 * Enthaelt keinerlei Logik und wird gentutzt
 * um Daten komfortabel von Programmteil A zu
 * Programmteil B zu schieben.
 */
public class Asset extends de.rhistel.model.ABaseModel {

    //region 0. Konstanten


    private static final int SPLIT_INDEX_ASSET_ID = 0;
    private static final int SPLIT_INDEX_ASSET_NAME = 1;
    private static final int SPLIT_INDEX_ASSET_TYPE = 2;

    private static final int SPLIT_INDEX_ASSET_MAX_TEMP = 3;
    private static final int SPLIT_INDEX_ASSET_MIN_TEMP = 4;

    private static final int SPLIT_INDEX_ASSET_IP = 5;
    private static final int SPLIT_INDEX_ASSET_STATE = 6;

    //endregion

    //region 1. Decl. and Init Attribute

    //TODO strTitele wird zu EProun und das wird im Konsturktor und dem Getter und Setter geaendert.


    private String strAssetID;
    private String strAssetName;
    private String strAssetType;

    private String strAssetMaxTemp;
    private String strAssetMinTemp;


    private String strAssetIp;
    private boolean bAssetState;




    //endregion

    //region 2. Konstruktor mit genererien lassen mit alt + einfg / rechtsklick generate -> SELECT NONE

    /**
     * Standardkonstuktor
     * Zum direkten initalisieren
     * aller Attribute der Klasse
     */
    public Asset() {


        this.strAssetID = DEF_VALUE_STR;
        this.strAssetName = DEF_VALUE_STR;
        this.strAssetType = DEF_VALUE_STR;

        this.strAssetMaxTemp = DEF_VALUE_STR;
        this.strAssetMinTemp = DEF_VALUE_STR;

        this.strAssetIp = DEF_VALUE_STR;
        this.bAssetState = DEF_VALUE_BOOLEAN;





    }

    //endregion

    //region 3. Getter und Setter generieren lassen mit Strg + - Einfg oder Rechtsklick->Generate


    public String getAssetID() {
        return strAssetID;
    }

    public void setAssetID(String strAssetID) {
        this.strAssetID = strAssetID;
    }

    public String getAssetName() {
        return strAssetName;
    }

    public void setAssetName(String strAssetName) {
        this.strAssetName = strAssetName;
    }

    public String getAssetType() {
        return strAssetType;
    }

    public void setAssetType(String strAssetType) {
        this.strAssetType = strAssetType;
    }

    public String getAssetMaxTemp() {
        return strAssetMaxTemp;
    }

    public void setAssetMaxTemp(String strAssetMaxTemp) {
        this.strAssetMaxTemp = strAssetMaxTemp;
    }

    public String getAssetMinTemp() {
        return strAssetMinTemp;
    }

    public void setAssetMinTemp(String strAssetMinTemp) {
        this.strAssetMinTemp = strAssetMinTemp;
    }

    public String getAssetIp() {
        return strAssetIp;
    }

    public void setAssetIp(String strAssetIp) {
        this.strAssetIp = strAssetIp;
    }

    public boolean getAssetState() {
        return bAssetState;
    }

    public void setAssetState(boolean bAssetState) {
        this.bAssetState = bAssetState;
    }

    /**
     * Gibt alle Attribiute inklusive der Adddresse
     * als CSV-Zeile zurueck.<br>
     * <p>
     * Beispiel:<br>
     * <br>
     * <ol>
     *
     *         <ol>
     *
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_ID} - {@link Asset#strAssetID}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_NAME} - {@link Asset#strAssetName}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_TYPE} - {@link Asset#strAssetType}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_MAX_TEMP} - {@link Asset#strAssetMaxTemp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_MIN_TEMP} - {@link Asset#strAssetMinTemp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_IP} - {@link Asset#strAssetIp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_STATE} - {@link Asset#bAssetState}</li>
     *
     *     </ol>
     *     </li>
     *     <li>
     *
     *         <ol>
     *
     *             </ol>
     * </ol>
     * Attribute:  strTitle;strFirstName;strLastName;strBday;iAge;iSex;dblHeight;dblWeight;strPhoneNr;strEmail<br>
     * <p>
     * Splitindex:  0                         1                   2              3<br>
     * Attribute:  #address.getStreet(),address.getHouseNr(),address.getZip(),address.getCity()<br>
     * <br>
     * Es sind in der {@link Asset#setAllAttributesFromCsvLine(String)}drei Splits durch zufuerren das:
     * <br>
     * <ol>
     * <li>Split der Hauptwerte hier in der Klasse {@link Asset} nach dem # dieses trennt Address und Kundenwerte.</li>
     * <li>plit der Kundenwerte hier in der Klasse {@link Asset} nach dem ;</li>
     * </ol>
     *
     * @return strCsvLine : {@link String} : CSV-Line
     */
    @Override
    public String getAllAttributesAsCsvLine() {
        String strCsvLine = "";



        strCsvLine += this.strAssetID + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetName + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetType + DATA_ATTRIBUTE_SPLITTER;

        strCsvLine += this.strAssetMaxTemp + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetMinTemp + DATA_ATTRIBUTE_SPLITTER;

        strCsvLine += this.strAssetIp + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.bAssetState + DATA_ATTRIBUTE_SPLITTER + "\n";



        return strCsvLine;
    }

    /**
     * Setzt alle Attribiute inklusive der Adddresse
     * basierend auf der in {@link Asset#getAllAttributesAsCsvLine()}
     * generierten CSV-Zeile.
     * <p>
     * <p>
     * Beispiel:<br>
     * <br>
     * <ol>
     *
     *         <ol>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_ID} - {@link Asset#strAssetID}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_NAME} - {@link Asset#strAssetName}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_TYPE} - {@link Asset#strAssetType}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_MAX_TEMP} - {@link Asset#strAssetMaxTemp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_MIN_TEMP} - {@link Asset#strAssetMinTemp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_IP} - {@link Asset#strAssetIp}</li>
     *     <li>{@link Asset#SPLIT_INDEX_ASSET_STATE} - {@link Asset#bAssetState}</li>
     *
     *     </ol>
     *     </li>
     *     <li>
     *
     * </ol>
     * Attribute:  strTitle;strFirstName;strLastName;strBday;iAge;iSex;dblHeight;dblWeight;strPhoneNr;strEmail<br>
     * <p>
     * Splitindex:  0                         1                   2              3<br>
     * Attribute:  #address.getStreet(),address.getHouseNr(),address.getZip(),address.getCity()<br>
     * <br>
     * Es sind in der {@link Asset#setAllAttributesFromCsvLine(String)}drei Splits durch zufuerren das:
     * <br>
     * <ol>
     * <li>Split der Hauptwerte hier in der Klasse {@link Asset} nach dem # dieses trennt Address und Kundenwerte.</li>
     * <li>plit der Kundenwerte hier in der Klasse {@link Asset} nach dem ;</li>
     * <li>Split
     */
    @Override
    public void setAllAttributesFromCsvLine(String strCsvLine) throws Exception {


        //3. Kundendaten splitten
        String[] strSplitArrayCustomerData = strCsvLine.split(DATA_ATTRIBUTE_SPLITTER);

        //4. Kundendaten setzen

        this.strAssetID = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_ID];
        this.strAssetName = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_NAME];
        this.strAssetType = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_TYPE];

        this.strAssetMaxTemp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_MAX_TEMP];
        this.strAssetMinTemp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_MIN_TEMP];

        this.strAssetIp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_IP];
        this.bAssetState = Boolean.parseBoolean(strSplitArrayCustomerData[SPLIT_INDEX_ASSET_STATE]);




        //5. Address Daten splitten und setzen lassen
        //this.customerAddress.setAllAttributesFromCsvLine(strCsvLineCustomerAddressData);

    }




    //endregion

    //region 4. toString() Funktionen generieren lassen mit Strg + Einfg oder Rechtsklick->Generate


    @Override
    public String toString() {
        return "Asset{" +
                "strAssetID='" + strAssetID + '\'' +
                ", strAssetName='" + strAssetName + '\'' +
                ", strAssetType='" + strAssetType + '\'' +
                ", iAssetMaxTemp=" + strAssetMaxTemp +'\'' +
                ", iAssetMinTemp=" + strAssetMinTemp +'\'' +
                ", strAssetIp='" + strAssetIp + '\'' +
                ", bAssetState=" + bAssetState +'\'' +
                '}';
    }


    //endregion

}
