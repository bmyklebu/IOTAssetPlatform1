package de.bmyklebu.gui;

import de.bmyklebu.logic.CsvFileHandler;
import de.bmyklebu.model.Asset;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static de.bmyklebu.settings.ApplicationTexts.USER_MSG_PLEASE_ENTER_EVERYTHING;
import static de.bmyklebu.settings.ApplicationTexts.USER_MSG_SAVED_SUCCESSFULLY;

/**
 * Nimmt die Events der GUI entgegen und
 * leitet die weitere Logik ein.
 */
public class UiController implements Initializable {

    //region 0. Konstanten
    //endregion

    //region 1. Decl. and Init Attribute
    @FXML
    private ListView<Asset> lvCustomers;

    /**
     * In Spitzenklammern den Objekttyp angegben den die ComboBox anzeigt
     * sprich den Typ der Eintraege
     */
    @FXML
    private ComboBox<String> cboPronoun;

    @FXML
    private TextField txtAssetId;

    @FXML
    private TextField txtAssetName;

    @FXML
    private TextField txtAssetType;


    @FXML
    private TextField txtAssetMaxTemp;

    @FXML
    private TextField txtAssetMinTemp;

    @FXML
    private TextField txtAssetIP;

    @FXML
    private CheckBox cbAssetState;




    /**
     * Enthaelt alle Kunden die zur Laufzeit
     * gelesen, angelegt, geaendert oder geloescht werden.
     */
    private List<Asset> listOfAllAssets;
    //endregion

    //region 2. Konstruktor

    /**
     * Standardkonstruktor
     * zum dirketen auslesen der Kunden aus der Dateie
     */
    public UiController() {
    }

    //endregion

    //region 3. Initalsieren

    /**
     * Wird aufgerufen sobald der Controller verwendet werden kann,
     * und befuellt Steuereleemente mit Standardwerten und/oder Text.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //1. Kombobox befuellen


        //2. ListViewBefuellen
        updateListView();
    }


    //endreigon

    //region 4. Kunde speichern

    /**
     * Liest alle Kunden aus checkt ob diese valide sind
     * und speichert den Kunden in eine Datei
     */
    public void onClickSubmitCustomer() {


        //Alle Kundendaten auslesen bei Falscheingabe ist der Rueckgabewert null
        Asset assetFromUi = this.getCustomerDataFromUi();

        //Checken ob alle Daten richtig waren
        if (assetFromUi != null) {

            //Einen neuen Kunden zur Liste hinzufuegenA
            this.listOfAllAssets.add(assetFromUi);

            //Veraenderung in die Dateis speichern TODO speater durch DBAufrufersetzen
            CsvFileHandler.getInstance().saveCustomersToCsvFile(this.listOfAllAssets);

            //DEBUG
            System.out.println(USER_MSG_SAVED_SUCCESSFULLY);

            resetCustomerDataTextFields();

            //TODO updateListView
            updateListView();
        } else {
            //DEBUG
            System.out.println("Nicht gespeichert");
        }
    }
    //endregion

    //region Hilfsmethoden und Funktionen

    /**
     * TODO Update ListView befuellt die ListView
     */
    private void updateListView() {
        this.listOfAllAssets = CsvFileHandler.getInstance().readCustomersFromFile();


        ObservableList<Asset> observableAssetList = FXCollections.observableList(listOfAllAssets);

        this.lvCustomers.getItems().clear();
        this.lvCustomers.setItems(observableAssetList);

        this.lvCustomers.setOrientation(Orientation.VERTICAL);

        LvCustomersCallback lvCustomersCallback = new LvCustomersCallback();
        this.lvCustomers.setCellFactory(lvCustomersCallback);
//TODO CellFactory
//		this.lvCustomers.setCellFactory(new Callback<ListView<Asset>, ListCell<Asset>>() {
//

//			}
//		});

        //TODO Listener der ListView
        this.lvCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Asset>() {
            @Override
            public void changed(ObservableValue<? extends Asset> observableCustomers,
                                Asset prevAsset, Asset currentAsset) {

                //Checken ob was genau selktiert ist und nur bei richtiger Selektierung weiter machen
                if ((currentAsset != null) && (!currentAsset.equals(prevAsset))) {

                    //TODO Anzeigen des aktuellen Kunden mit neuer erstellter Methode
                    fillCustomerDataInGui(currentAsset);
                }

            }
        });
    }




    /**
     * Liest alle Kundendaten von der Ui (Konsole)
     * aus und generiert ein neuen {@link Asset}, sollten
     * die Eingabedaten valide (hier in userem Fall nur nicht leer) sein.
     * und gibt diesen befuellt zurueck. Sind die Eingabedaten nicht valide
     * (minimum eine Eingabe war leer oder bestand nur aus Leerzeichen) dann
     * wird null zurueck gegeben. Es gibt nur einen Kunden mit richtigen Daten
     *
     * @return customerFromUi : {@link Asset} : Neuer befuellter Kunde bei richtigen Eingaben
     * bei <b>Falscheingabe</b> wird <b> >null< </b> zurueck gegeben.
     */
    private Asset getCustomerDataFromUi() {
        //Decl and Init
        Asset assetFromUi = null;
        boolean  isUserInputValid = true;


        String strAssetID = this.txtAssetId.getText();
        String strAssetName  = this.txtAssetName.getText();
        String strAssetType = this.txtAssetType.getText();
        String strAssetMaxTemp = this.txtAssetMaxTemp.getText();
        String strAssetMinTemp = this.txtAssetMinTemp.getText();
        String strAssetIP = this.txtAssetIP.getText();
        String strAssetState = this.cbAssetState.getText();



        //place all values in an array for checking
        String[] strUserInput = {
                strAssetID,
                strAssetName,
                strAssetType,
                strAssetMaxTemp,
                strAssetMinTemp,
                strAssetIP

        };


        //Alle Eingabedaten durchlaufen
        for (String strValue : strUserInput) {

            //Wenn etwas leer ist gilt es als nicht korrekt / valide
            if (strValue.isEmpty() || strValue.isBlank()) {
                isUserInputValid = false;
            }
        }

        //Checken ob es falsch Eingaben gab
        if (isUserInputValid) {

            //Neues Kundenobjekt anlegen/generieren/instanziieren
            assetFromUi = new Asset();


            //Alle gecheckten Eingabedaten per setter dem Kundenobjekt geben
            assetFromUi.setAssetID(strAssetID);
            assetFromUi.setAssetName(strAssetName);


            assetFromUi.setAssetType(strAssetType);
            assetFromUi.setAssetMaxTemp(strAssetMaxTemp);
            assetFromUi.setAssetMinTemp(strAssetMinTemp);
            assetFromUi.setAssetIp(strAssetIP);
            assetFromUi.setAssetState(Boolean.parseBoolean(strAssetState));











        } else {
            //Userhinweis ausgeben
            System.out.println(USER_MSG_PLEASE_ENTER_EVERYTHING);
        }

        return assetFromUi;
    }

    /**
     * Nimmt einen Kunden entgegen und traegt dessen Daten in
     * die Steuerelemente ein
     * @param assetToShowInGui : {@link Asset} : Kunde der angezeigt werden soll
     */
    private void fillCustomerDataInGui(Asset assetToShowInGui) {



        this.txtAssetId.setText(assetToShowInGui.getAssetID());
        this.txtAssetName.setText(assetToShowInGui.getAssetName());


        this.txtAssetType.setText(assetToShowInGui.getAssetType());
        this.txtAssetMaxTemp.setText(assetToShowInGui.getAssetMaxTemp());

        this.txtAssetMinTemp.setText(assetToShowInGui.getAssetMinTemp().toString());
        this.txtAssetIP.setText(Boolean.toString(assetToShowInGui.getAssetState()));


    }


    /**
     * Alle Eingabefelder fuer Kundendaten
     * leeren
     */
    private void resetCustomerDataTextFields() {


        //Eingabefocus auf Anredefeld setzen

        this.txtAssetId.setText("");
        this.txtAssetName.setText("");


        this.txtAssetType.setText("");

        this.txtAssetMaxTemp.setText("");
        this.txtAssetMinTemp.setText("");
        this.txtAssetIP.setText("");


    }


    //endregion
}
