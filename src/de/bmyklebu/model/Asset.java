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
public class Asset extends de.bmyklebu.model.ABaseModel {

    //region 0 Constants


    private static final int SPLIT_INDEX_ASSET_ID = 0;
    private static final int SPLIT_INDEX_ASSET_NAME = 1;
    private static final int SPLIT_INDEX_ASSET_TYPE = 2;

    private static final int SPLIT_INDEX_ASSET_MAX_TEMP = 3;
    private static final int SPLIT_INDEX_ASSET_MIN_TEMP = 4;

    private static final int SPLIT_INDEX_ASSET_IP = 5;

    //endregion

    //region 1 Decl. and Init variables

    private String strAssetID;

    private String strAssetName;
    private String strAssetType;
    private String strAssetMaxTemp;
    private String strAssetMinTemp;

    private String strAssetIp;





    //endregion

    //region 2 Constructor

    /**
     * Standard Constuctor
     * used to directly initialise attributes
     */
    public Asset() {


        this.strAssetID = DEF_VALUE_STR;
        this.strAssetName = DEF_VALUE_STR;
        this.strAssetType = DEF_VALUE_STR;

        this.strAssetMaxTemp = DEF_VALUE_STR;
        this.strAssetMinTemp = DEF_VALUE_STR;

        this.strAssetIp = DEF_VALUE_STR;


    }

    //endregion

    //region 3 Getter und Setter
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


    /**
     * get all attributes from csv as a line
     * returns a single line splitt by a data splitter ";"
     * @return returns a csv line
     */
    @Override
    public String getAllAttributesAsCsvLine() {
        String strCsvLine = "";

        strCsvLine += this.strAssetID + DATA_ATTRIBUTE_SPLITTER;

        strCsvLine += this.strAssetName + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetType + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetMaxTemp + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetMinTemp + DATA_ATTRIBUTE_SPLITTER;
        strCsvLine += this.strAssetIp + DATA_ATTRIBUTE_SPLITTER+ "\n";


        return strCsvLine;
    }


    /**
     *
     * @param strCsvLine : {@link String} : CSV-Zeile der konkret abgleiteten Kindklasse die alle Attribute
     * @throws Exception
     */
    @Override
    public void setAllAttributesFromCsvLine(String strCsvLine) throws Exception {


        //Split Asset data
        String[] strSplitArrayCustomerData = strCsvLine.split(DATA_ATTRIBUTE_SPLITTER);

        //set Asset data from read line to class variables
        this.strAssetID = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_ID];
        this.strAssetName = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_NAME];
        this.strAssetType = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_TYPE];

        this.strAssetMaxTemp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_MAX_TEMP];
        this.strAssetMinTemp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_MIN_TEMP];

        this.strAssetIp = strSplitArrayCustomerData[SPLIT_INDEX_ASSET_IP];

    }




    //endregion

    //region 4 toString()


    @Override
    public String toString() {
        return "Asset{" +
                "strAssetID='" + strAssetID + '\'' +
                ", strAssetName='" + strAssetName + '\'' +
                ", strAssetType='" + strAssetType + '\'' +
                ", iAssetMaxTemp=" + strAssetMaxTemp +'\'' +
                ", iAssetMinTemp=" + strAssetMinTemp +'\'' +
                ", strAssetIp='" + strAssetIp + '\'' +
                '}';
    }


    //endregion

}
