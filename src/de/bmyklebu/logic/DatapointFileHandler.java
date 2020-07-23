package de.bmyklebu.logic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatapointFileHandler {
    //region 0 constants
    private static final String FILE_PATH = "src/de/bmyklebu/files/";
    private static final String FILE_TYPE = ".csv";
    private static final String FILE_NAME = "bmyTest";
    private static final String SEPARATOR = ";";

    //endregion
    //region 1 init and declare

    //declare folders
    private File myFileToSave;
    private File myFolderToSave;

    //declare stuff for output
    private FileOutputStream fos;
    private OutputStreamWriter osw;
    private BufferedWriter out;

    //declare stuff for input
    private FileInputStream fis;
    private InputStreamReader isr;
    private BufferedReader in;

    //endregion

    //region 2 methods
//    public String simpleFileReader() {
//        File myNewFolder;
//        File myFileToRead;
//
//        String strReturnValues = "";
//
//        myFileToRead = new File(FILE_PATH + FILE_NAME + FILE_TYPE);
//
//        try {
//            //define file instance to readmyFileToRead = new File(myNewFolder.getAbsolutePath() + FILE_NAME);
//
//            //is the file to read there?
//            if (myFileToRead.exists()) {
//                //open connecting stream to file object (myFileToRead)
//                fis = new FileInputStream(myFileToRead);
//
//                //creates an inputstream reader that reads the fls AND uses the charecterset utf 8
//                isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//
//                //buffered reader can now read the file using the information in isr
//                in = new BufferedReader(isr);
//
//                System.out.println(in);
//
//                boolean eof = false;
//                while (!eof) {
//                    //1. read lines
//                    String strReadCsvLine = in.readLine();
//                    //String compare = strReadCsvLine.substring(0,1);
//
//                    //System.out.println(compare);
//                    if (strReadCsvLine == null) {
//                        eof = true;
//                    } else {
//                        String compare = strReadCsvLine.substring(0,1);
//                        //compare with static value TODO change to param value
//                        if (compare.equals("2")){
//
//                        }else{
//
//                        }
//                        System.out.println(compare);
//                        //read content of file and add new to strReturnValues
//                        strReturnValues += strReadCsvLine + "\n";
//                    }
//
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                in.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return strReturnValues;
//    }

    public String simpleFileReaderBMY(String paramAssetID ) {
        File myNewFolder;
        File myFileToRead;

        String strReturnValues = "";

        myFileToRead = new File(FILE_PATH + FILE_NAME + FILE_TYPE);

        try {
            //define file instance to readmyFileToRead

            //checks if there is a file to read there
            if (myFileToRead.exists()) {
                //open connecting stream to file object (myFileToRead)
                fis = new FileInputStream(myFileToRead);

                //creates an inputstream reader that reads the fls AND uses the charecterset utf 8
                isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

                //buffered reader can now read the file using the information in isr
                in = new BufferedReader(isr);

                System.out.println(in);

                boolean eof = false;
                while (!eof) {
                    //read lines
                    String strReadCsvLine = in.readLine();

                    if (strReadCsvLine == null) {
                        eof = true;
                    } else {
                        String compare = strReadCsvLine.substring(0,1);
                        //compare AssetID in CSV file line to AssetId that is selected
                        if (compare.equals(paramAssetID)){
                            strReturnValues += strReadCsvLine + "\n";
                        }else{
                            strReturnValues = "no Datapoints found";
                        }

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return strReturnValues;
    }
    //endregion

    /**
     * @param iRepetitions the number lines needed
     * @param iMachineNo   the machine number that is needed
     * @param iTemperature the max temperate that can be reached (values are randomly generated but may not exceed iTemperature)
     */
    public void createSimpleCsvFileWithParams(int iRepetitions, int iMachineNo, int iTemperature) {
        try {
            //Creates new instance of file --> converts file to abstract file name
            myFolderToSave = new File(FILE_PATH);

            //define folder
            if (!myFolderToSave.exists()) {
                myFolderToSave.mkdir();
            }
            //define file with path , name and suffix
            myFileToSave = new File(FILE_PATH + FILE_NAME + FILE_TYPE);

            //create stream which contains the object (file and content bla)
            fos = new FileOutputStream(myFileToSave, true);

            //define stream and with which charset it should be displayed
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            //create instance of buffered writer
            out = new BufferedWriter(osw);

            //create format to be used in the date formatter
            SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");

            //format the date using the pattern that we have  defined
            String strDate = dateformat.format(new Date());


            //build data string and datasets here
            for (int i = 0; i < iRepetitions; i++) {
                //generate random temperatures till (but not exceeding) temperature variable  iTemperature
                Double dblRandomTemperature = (Math.random() * iTemperature);

                //data gets strung together here here
                String strData = iMachineNo + SEPARATOR + strDate + SEPARATOR + dblRandomTemperature.intValue() + "\n";

                //data is written here
                out.write(strData);
            }


        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            // try catch block to close the writer
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
