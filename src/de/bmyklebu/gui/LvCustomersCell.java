package de.bmyklebu.gui;

import de.bmyklebu.model.Asset;
import javafx.scene.control.ListCell;

public class LvCustomersCell extends ListCell<Asset> {
    @Override
    protected void updateItem(Asset assetToShowInCell, boolean empty) {
        super.updateItem(assetToShowInCell, empty);

        if (empty || assetToShowInCell == null) {

        //Text der Stelle setzen
            this.setText(null);

            this.setGraphic(null);
        } else {
            this.setText(assetToShowInCell.getAssetName() + assetToShowInCell.getAssetID());
        }

    }
}