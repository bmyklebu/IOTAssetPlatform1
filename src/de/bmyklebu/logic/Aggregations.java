package de.bmyklebu.logic;

public class Aggregations extends DatapointFileHandler {


    private int getMaxDatapointTemperature(int[] iTempValues) {
        int max = iTempValues[0];
        for (int i = 0; i < iTempValues.length; i++) {
            if (iTempValues[i] > max){
                max = iTempValues[i];
            }
        }
        return max;
    }

    private int getMinDatapointTemperature(int[] iTempValues) {
        int imin = iTempValues[0];
        for (int i = 0; i < iTempValues.length; i++) {
            if (iTempValues[i] < imin){
                imin = iTempValues[i];
            }
        }
        return imin;
    }
}
