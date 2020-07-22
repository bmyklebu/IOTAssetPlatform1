package de.bmyklebu.logic;

public class Aggregations extends DatapointFileHandler {

    /**
     * this method calculates the maximum value in a simple (1D) array
     * @param iTempValues the array that is to be checked
     * @return return the max value within an array
     */
    private int getMaxDatapointTemperature(int[] iTempValues) {
        int max = iTempValues[0];
        for (int i = 0; i < iTempValues.length; i++) {
            if (iTempValues[i] > max){
                max = iTempValues[i];
            }
        }
        return max;
    }

    /**
     * this method calculates the minimum value in a simple (1D) array
     * @param iTempValues the array that is to be checked
     * @return return the min values within an array
     */
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
