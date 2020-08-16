package datasuply;

import database.ConnectToExcelFile;

import java.io.IOException;

public class smallBussProducts {
    ConnectToExcelFile excelFile = new ConnectToExcelFile();
    public String[] getDataFromExcelFile() throws IOException {
        String path = System.getProperty("user.dir")+"/NYP/data/nyp-test-steps.xls";
        String [] data = excelFile.fileReader2(path,0);
        return data;
    }
}
