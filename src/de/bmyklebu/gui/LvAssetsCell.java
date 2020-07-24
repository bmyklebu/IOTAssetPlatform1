package de.bmyklebu.gui;

import de.bmyklebu.model.Asset;
import javafx.scene.control.ListCell;

public class LvAssetsCell extends ListCell<Asset> {
    @Override
    protected void updateItem(Asset assetToShowInCell, boolean empty) {

        //overrides updateItem in Cell class
        super.updateItem(assetToShowInCell, empty);

        if (empty || assetToShowInCell == null) {

            this.setText(null);

            this.setGraphic(null);
        } else {
            //define the values which are to be displayed in the List view
            this.setText("ID: "+assetToShowInCell.getAssetID() + "  Name: " +assetToShowInCell.getAssetName());
        }

    }
}