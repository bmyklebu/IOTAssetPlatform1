package de.bmyklebu.logic;

import de.bmyklebu.model.Asset;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHandler {

    //region 0. Constants
    private static final String FILE_PATH = "src/de/bmyklebu/assets/";
    private static final String FILE_TYPE_CSV = ".csv";
    //private static final String FILE_TYPE_TXT  = ".txt";
    private static final String FILE_NAME = "/assets" + FILE_TYPE_CSV;
    //private static final String FULL_FILE_PATH = FILE_PATH + FILE_NAME;
    //endregion

    //region 1.  Decl. and Init Attribute
    private static CsvFileHandler instance;
    //endregion

    //region 2. Constructor

    /**
     * Private Konstruktor
     */
    private CsvFileHandler() {

    }

    //endregion

    //region 3. Getter and Setter

    /**
     * returns the only one syncronised instance (thread safety)
     * and generates this the first time it is called,
     * if called again it will return the current instance
     *
     * @return instance: {@link CsvFileHandler} : Only Instance, Singleton ftw
     */
    public static synchronized CsvFileHandler getInstance() {
        if (instance == null) {
            instance = new CsvFileHandler();
        }

        return instance;
    }
    //endregion

    //region 4. Speichern

    /**
     * Saves the assets to a CSV file
     *
     * @param assetsToSave : {@link Asset} : assets to save
     */
    public void saveAssetsToCsvFile(List<Asset> assetsToSave) {

        //Decl. and Init Schreibgeraetschaften
        File myNewFolder = null;
        File myFileToSave = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter out = null;


        try {

            //define new folder
            myNewFolder = new File(FILE_PATH);

            //Check if folder exists if not make a new one
            if (!myNewFolder.exists()) {
                myNewFolder.mkdir();
            }

            //define new file
            myFileToSave = new File(myNewFolder.getAbsolutePath() + FILE_NAME);

            //define file output stream using myFileToSave
            fos = new FileOutputStream(myFileToSave, false);

            //define the outpustream writer and what charset it should use
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            //write / buffer the values stored in the osw into out
            out = new BufferedWriter(osw);

            //for loop, write all values stored in out
            for (Asset c : assetsToSave) {
                out.write(c.getAllAttributesAsCsvLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            try {
                if (out != null) {
                    out.close();
                }

                if (osw != null) {
                    osw.close();
                }

                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region 5. read file

    /**
     * read asset data from a file and return it in list form
     *
     * @return strReadLines : {@link Asset} : assets read from file.
     */
    public List<Asset> readCustomersFromFile() {
        //Decl anbd Init
        List<Asset> customersFromFile = new ArrayList<>();

        File myNewFolder = null;
        File myFileToRead = null;

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader in = null;

        try {

            //Neuer Ordner definieren
            myNewFolder = new File(FILE_PATH);

            //1.) Neue Datei definieren
            myFileToRead = new File(myNewFolder.getAbsolutePath() + FILE_NAME);

            if (myFileToRead.exists()) {

                //read everything within the file
                fis = new FileInputStream(myFileToRead);

                //reads the data in the fis and puts it into the InputStreamReader isr
                isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

                //buffered reader can now read the file using the information in isr
                in = new BufferedReader(isr);

                boolean eof = false;

                while (!eof) {

                    //read the content/line of in
                    String strReadCsvLine = in.readLine();

                    //2.check if we have reached the end of the file
                    if (strReadCsvLine == null) {
                        eof = true;
                    } else {
                        //create new asset
                        Asset singleAssetFromFile = new Asset();

                        //read lines are given attributes
                        singleAssetFromFile.setAllAttributesFromCsvLine(strReadCsvLine);

                        //add assets to list
                        customersFromFile.add(singleAssetFromFile);
                    }

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (isr != null) {
                    fis.close();
                }

                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return customersFromFile;
    }
    //endregion
}
