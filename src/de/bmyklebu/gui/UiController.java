package de.bmyklebu.gui;

import de.bmyklebu.logic.CsvFileHandler;
import de.bmyklebu.logic.DatapointFileHandler;
import de.bmyklebu.model.Asset;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static de.bmyklebu.settings.ApplicationTexts.*;


/**
 * Nimmt die Events der GUI entgegen und
 * leitet die weitere Logik ein.
 */
public class UiController implements Initializable {



    //region 0. Constants
    //endregion

    DatapointFileHandler dataPoints = new DatapointFileHandler();
    //region 1. Decl. and Init Attributes
    //declare FX gui items
    @FXML
    private ListView<Asset> lvAssets;
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
    @FXML
    private Label txtDatapointValues;
    @FXML
    public TextField txtAssetIDTestGenerator;
    @FXML
    public TextField txtAssetMaxTempTestGenerator;
    /**
     * Contains all Assets that are generated during runtime
     * in form of an Asset list
     */
    private List<Asset> listOfAllAssets;

    //endregion

    //region 2. Constructor

    /**
     * Standard Constructor
     * used to read Asset data from files
     */
    public UiController() {
    }

    //endregion

    //region 3. Initialisation

    //declare alert for data deletion - no data selected / deleted
    @FXML
    private void errorNoDataDeleted() {
        Alert errorDelete = new Alert(Alert.AlertType.ERROR);
        errorDelete.setTitle("Error");
        errorDelete.setContentText("No data could be deleted");
        errorDelete.showAndWait();

    }

    /**
     * Is called as soon as the UIController is used
     * it fills the control elements with standard values
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //fill list view
        updateListView();
    }

    //endreigon

    //region 4. save asset

    /**
     * reads all Assets and checks if they are valid
     * then saves them in a file
     */
    public void onClickSubmitAsset() {

        //reads all asset data in case of failure it returns null
        Asset assetFromUi = this.getAssetDataFromUi();

        //checks if all data is correct (not null)
        if (assetFromUi != null) {

            //add a new asset to Asset list
            this.listOfAllAssets.add(assetFromUi);

            //save changes in the csv file TODO in case of saving into a db -> change here
            CsvFileHandler.getInstance().saveAssetsToCsvFile(this.listOfAllAssets);

            //DEBUG console output if saved successfully TODO output to gui?
            System.out.println(USER_MSG_SAVE_SUCCESS);

            resetCustomerDataTextFields();

            updateListView();
        } else {
            //DEBUG output in case of save failure
            System.out.println(USER_MSG_SAVE_FAILURE);
        }
    }
    //endregion

    private void updateListView() {
        //listOfAllAssets in this class gets values from  the CSVFileHandler using method readCustomersFromFile
        this.listOfAllAssets = CsvFileHandler.getInstance().readCustomersFromFile();

        //create observable list and assign it to read from the observable list from the FXCollections class
        ObservableList<Asset> observableAssetList = FXCollections.observableList(this.listOfAllAssets);

        //get observable list and then clear it
        this.lvAssets.getItems().clear();

        //set observable list to get values from the previously created observableAssetList
        this.lvAssets.setItems(observableAssetList);

        //set scrolling behaviour / orientation
        this.lvAssets.setOrientation(Orientation.VERTICAL);

        //generates an object to generate cells
        LvAssetsCallback lvAssetsCallback = new LvAssetsCallback();

        //generate cells using the cell factory as param we use the lvAssetsCallback declared above
        this.lvAssets.setCellFactory(lvAssetsCallback);

        //get model assigned to lvAssets and get the selected item add a listener (which is an anonymous class)
        this.lvAssets.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Asset>() {
            @Override
            public void changed(ObservableValue<? extends Asset> observableAssets,
                                Asset prevAsset, Asset currentAsset) {

                //make sure current asset isnt null, also make sure it doesnt equel the previous asset (in list) - javafx bug
                if ((currentAsset != null) && (!currentAsset.equals(prevAsset))) {

                    fillCustomerDataInGui(currentAsset);
                }

            }
        });
    }

    /**
     * reads Asset data from the UI
     * and generates a new {@link Asset},
     * if the entries are valid (in this case not empty) then they are returned.
     *
     * if the entries are invalid (in this case empty) then a null is returned
     *
     * @return customerFromUi : {@link Asset} : return a newly created asset when the entries are crrect
     *
     * when entries <b>are not correct</b> return <b> >null< </b>.
     */
    private Asset getAssetDataFromUi() {
        //Decl and Init
        Asset assetFromUi = null;
        boolean isUserInputValid = true;

        //create vars to store newly created asset
        String strAssetID = this.txtAssetId.getText();
        String strAssetName = this.txtAssetName.getText();
        String strAssetType = this.txtAssetType.getText();
        String strAssetMaxTemp = this.txtAssetMaxTemp.getText();
        String strAssetMinTemp = this.txtAssetMinTemp.getText();
        String strAssetIP = this.txtAssetIP.getText();


        //place all values in an array for checking
        String[] strUserInput = {
                strAssetID,
                strAssetName,
                strAssetType,
                strAssetMaxTemp,
                strAssetMinTemp,
                strAssetIP

        };

        //cycle through all values
        for (String strValue : strUserInput) {

            //if values are empty they are not correct / valid
            if (strValue.isEmpty() || strValue.isBlank()) {
                isUserInputValid = false;
            }
        }

        //Check if is valid
        if (isUserInputValid) {

            //create new instance of Asset
            assetFromUi = new Asset();


            //using the setter method assign values
            assetFromUi.setAssetID(strAssetID);
            assetFromUi.setAssetName(strAssetName);
            assetFromUi.setAssetType(strAssetType);
            assetFromUi.setAssetMaxTemp(strAssetMaxTemp);
            assetFromUi.setAssetMinTemp(strAssetMinTemp);
            assetFromUi.setAssetIp(strAssetIP);

        } else {
            //User message when fields not filled out correctly
            System.out.println(USER_MSG_PLEASE_ENTER_EVERYTHING);
        }

        return assetFromUi;
    }

    /**
     * Accepts data from the type / class Asset
     * and assigns it to the control elements
     *
     * @param assetToShowInGui : {@link Asset} : Asset that should be displayed
     */
    private void fillCustomerDataInGui(Asset assetToShowInGui) {

        this.txtAssetId.setText(assetToShowInGui.getAssetID());
        this.txtAssetName.setText(assetToShowInGui.getAssetName());

        this.txtAssetType.setText(assetToShowInGui.getAssetType());
        this.txtAssetMaxTemp.setText(assetToShowInGui.getAssetMaxTemp());

        this.txtAssetMinTemp.setText(assetToShowInGui.getAssetMinTemp());
        this.txtAssetIP.setText(assetToShowInGui.getAssetIp());

    }

    /**
     * Empty all fields for Asset data
     */
    private void resetCustomerDataTextFields() {

        this.txtAssetId.setText("");
        this.txtAssetName.setText("");
        this.txtAssetType.setText("");
        this.txtAssetMaxTemp.setText("");
        this.txtAssetMinTemp.setText("");
        this.txtAssetIP.setText("");

    }

    /**
     * this method changes the existing asset an overwrites it with new data
     */
    public void onClickChangeAsset() {

        //gets the selected index value of dataset
        int selected = lvAssets.getSelectionModel().getSelectedIndex();
        Asset currentAsset = getAssetDataFromUi();

        if (currentAsset != null) {
            this.listOfAllAssets.set(selected, currentAsset);
            saveFile();
            resetCustomerDataTextFields();
        }
        updateListView();
    }

    /**
     * this method deletes the selected asset
     * if there is none selected the user is informed
     */
    public void onClickDeleteAsset() {

        int selectedIndex = lvAssets.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            this.listOfAllAssets.remove(selectedIndex);
            saveFile();
            updateListView();
        } else {
            errorNoDataDeleted();
        }
    }

    private void saveFile() {
        CsvFileHandler.getInstance().saveAssetsToCsvFile(this.listOfAllAssets);
    }

    /**
     * this method creates datapoints (mainly for test purposes)
     * and is called within the UI, it further calls the actual create Datapoint method
     *
     */
    public void onClickCreateDatapoints() {
        //prepare parameters
        int iMaxTempRange =Integer.parseInt(txtAssetMaxTempTestGenerator.getCharacters().toString());
        int iTestMachineID = Integer.parseInt(txtAssetIDTestGenerator.getCharacters().toString());

        dataPoints.createSimpleCsvFileWithParams(3,iTestMachineID,iMaxTempRange);
    }

    /**
     * this method displays the received datapoints for an asset
     */
    public void displayDatapointValues() {
    //call to display values
        txtDatapointValues.setText(dataPoints.simpleFileReaderBMY(getAssetDataFromUi().getAssetID()));
    }

    //endregion
}
