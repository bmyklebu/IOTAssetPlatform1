package de.bmyklebu.gui;


import de.bmyklebu.model.Asset;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class LvAssetsCallback implements Callback <ListView<Asset>, ListCell<Asset>>{
    /**
     * The <code>call</code> method is called when required, and is given a
     * single argument of type P, with a requirement that an object of type R
     * is returned.
     *
     * @param param The single argument upon which the returned value should be
     *              determined.
     *
     * @return An object of type R that may be determined based on the provided
     * parameter value.
     */
    @Override
    public ListCell<Asset> call(ListView<Asset> param) {
        return new LvAssetsCell();
    }
}