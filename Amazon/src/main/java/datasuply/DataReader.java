package datasuply;

import database.ConnectToMongoDB;
import database.ConnectToMySQL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static ConnectToMySQL connectToMySQL = new ConnectToMySQL();
    public static List<String> getListOfItems(){
        List<String> list = new ArrayList<String>();
        list.add("java books");
        list.add("tooth paste");
        list.add("coffee");
        list.add("laptop");
        list.add("honey");
        list.add("Comic Books");

        return list;
    }
    public static List<String> getItemsListFromDB()throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToMySQL.readDataBase("ItemList", "items");
        return list;
    }
}

