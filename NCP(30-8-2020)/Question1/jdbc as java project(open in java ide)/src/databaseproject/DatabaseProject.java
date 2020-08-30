package databaseproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class DatabaseProject extends javax.swing.JFrame{
Connection con;
    
    public static void main(String[] args) throws SQLException {
        DatabaseProject pro=new DatabaseProject();
        pro.createConnection();
        pro.createtable();
        pro.insertValues();
        pro.sqlqueries1();
        pro.sqlqueries2();
        pro.sqlqueries3();
    }
    void createtable(){
        try{
        String d="CREATE TABLE student("
                +"id int NOT NULL,"
                +"roll int NOT NULL,"
                +"name varchar(100) NOT NULL,"
                +"age int NOT NULL,"
                +"cgpa float NOT NULL,"
                +"Company varchar(100) NOT NULL,"
                +"PRIMARY KEY(roll)"
                +");";
        Statement stmt=con.createStatement();
        stmt.execute(d);
        System.out.println("Table Created");
        stmt.close();
     }catch(SQLException ex){
    Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    void insertValues(){
        try{
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (1,1,'Zara',20,9.8,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (2,3,'Dan',20,9.1,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (3,2,'David',20,9.0,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (4,5,'Zack',20,8.1,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (5,4,'Efron',20,7.1,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (6,6,'Angelina',20,3.1,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (7,8,'Jolie',20,4.1,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (8,9,'Brad',20,5.5,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (9,7,'Pitt',20,4.5,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (10,10,'Daniel',20,7.2,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (11,12,'Craig',20,7.9,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (12,11,'Ridley',20,8.9,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (13,14,'Scott',20,9.9,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (14,13,'Martin',20,10.0,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (15,15,'George',20,1.1,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (16,19,'Clooney',20,1.2,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (17,17,'David',20,3.2,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (18,18,'Beckam',20,5.5,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (19,16,'Joe',20,4.4,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (20,25,'Chandler',20,3.3,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (21,24,'Ross',20,2.2,'infosys')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (22,23,'Rachel',20,8.5,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (23,22,'Monica',20,8.4,'tcs')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (24,21,'Phoebe',20,8.8,'cts')");
            stmt.executeUpdate("INSERT INTO student (id,roll,name,age,cgpa,Company) VALUES (25,20,'Arjun',20,9.1,'cts')");
            
            System.out.println("Values Inserted");
            stmt.close();
        }catch(SQLException ex){
    Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    void sqlqueries1(){
        try{
        PreparedStatement statement=con.prepareStatement("SELECT * FROM student WHERE cgpa>8.0");
        ResultSet result=statement.executeQuery();
        ArrayList<String> array=new ArrayList<String>();
        System.out.println("Query1 where cgpa>8.0");
        System.out.println("ID ROLL NAME AGE CGPA COMAPANY");
        while(result.next()){
            System.out.print(result.getString("id"));
            System.out.print("    ");
            System.out.print(result.getString("roll"));
            System.out.print("    ");
            System.out.print(result.getString("name"));
            System.out.print("    ");
            System.out.print(result.getString("age"));
            System.out.print("    ");
            System.out.print(result.getString("cgpa"));
            System.out.print("    ");
            System.out.print(result.getString("Company"));
            System.out.print("    ");
            System.out.println();
        }
        System.out.println("\n");
        
    }catch(SQLException ex){
    Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
    }
}
     void sqlqueries2(){
        try{
        PreparedStatement statement=con.prepareStatement("SELECT * FROM student WHERE Company = 'infosys'");
        ResultSet result=statement.executeQuery();
        ArrayList<String> array=new ArrayList<String>();
        System.out.println("Query2 where company=infosys");
        System.out.println("ID ROLL NAME AGE CGPA COMAPANY");
        while(result.next()){
            System.out.print(result.getString("id"));
            System.out.print("    ");
            System.out.print(result.getString("roll"));
            System.out.print("    ");
            System.out.print(result.getString("name"));
            System.out.print("    ");
            System.out.print(result.getString("age"));
            System.out.print("    ");
            System.out.print(result.getString("cgpa"));
            System.out.print("    ");
            System.out.print(result.getString("Company"));
            System.out.print("    ");
            System.out.println();
        }
        System.out.println("\n");
        
    }catch(SQLException ex){
    Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
    }
}
     void sqlqueries3(){
        try{
        System.out.println("Query 3 sort based on roll number");
        PreparedStatement statement=con.prepareStatement("SELECT * FROM student ORDER BY roll ASC");
        ResultSet result=statement.executeQuery();
        ArrayList<String> array=new ArrayList<String>();
        System.out.println("ID ROLL NAME AGE CGPA COMAPANY");
        while(result.next()){
            System.out.print(result.getString("id"));
            System.out.print("   ");
            System.out.print(result.getString("roll"));
            System.out.print("   ");
            System.out.print(result.getString("name"));
            System.out.print("   ");
            System.out.print(result.getString("age"));
            System.out.print("   ");
            System.out.print(result.getString("cgpa"));
            System.out.print("   ");
            System.out.print(result.getString("Company"));
            System.out.print("   ");
            System.out.println();
        }
        System.out.println("\n");
    }catch(SQLException ex){
    Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    void createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","joker123");
            System.out.println("Connection Success");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
    
}
