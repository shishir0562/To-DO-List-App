/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coder
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class ToDoModel {
    
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private boolean connectionFlag = false;
    private ArrayList<String> items;
    String sql=null;
    ToDoModel(){
        openConnection();
        createTable();
    }
    private void createTable(){
        try{
            sql = "CREATE TABLE IF NOT EXISTS data(id INTEGER NOT NULL, item VARCHAR2(500) NOT NULL, mark INTEGER NOT NULL, PRIMARY KEY(id));";
            stmt.execute(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    private void openConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:‪‪DATABASE.db");
            stmt=conn.createStatement();
            connectionFlag = true;
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            connectionFlag = false;
        }
    }
    public void addItem(String item){
        int mark = 0;
        sql = "INSERT INTO data(item, mark)"+"VALUES('"+item+"', '"+mark+"');";
        try{
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<String> getAllItems(){
        sql = "SELECT id, item from  data where MARK = 0;";
        items = new ArrayList<>();
        String str;
        try{
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                str = String.valueOf(rs.getInt("id"))+" ";
                str = str+ rs.getString("item");
                items.add(str);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
     return items;  
    }
    public ArrayList<String> searchItem(String item){ 
        
        String s = "'"+"%"+item+"%"+"'";
        sql = "SELECT item from data where MARK = 0 and item LIKE"+s+";";
        items = new ArrayList<>();
        try{
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                items.add(rs.getString("item"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }
    
    public void markItem(int index){
        sql = "UPDATE data SET mark = 1 where id ="+index+";";
        try{
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
