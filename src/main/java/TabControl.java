import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TabControl {



    public static void addTab(String Artist, String Name, int UserID){
        Scanner input = new Scanner (System.in);
        try{
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Tabs (Artist, Name, UserID) VALUES (?,?,?)");
            ps. setString(1, Artist);
            ps.setString(2, Name);
            ps.setInt(3, UserID);
            ps.executeUpdate();
        } catch (Exception exception){
            System.out.println("Database error");
        }
    }

    public static void listTabs(){
        try {

            PreparedStatement ps = Main.db.prepareStatement("SELECT TabID, Artist, Name, UserID FROM Tabs");

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int TabID = results.getInt(1);
                String Artist = results.getString(2);
                String Name = results.getString(3);
                int UserID = results.getInt(4);
                System.out.println(TabID + ": Artist: " + Artist + " SongName: " + Name + " UserID: " + UserID);

            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void updateTab(int TabID, String Artist, String Name, int UserID){
        try{
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Tabs SET Artist = ?, Name = ?, UserID = ? WHERE TabID = ?");
            ps.setString(1, Artist);
            ps.setString(2, Name);
            ps.setInt(3, UserID);
            ps.setInt(4, TabID);
            ps.executeUpdate();
        }catch (Exception exception){
            System.out.println("Database error");
        }
    }

    public static void deleteTab(int TabID) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Tabs WHERE TabID = ?");
            ps.setInt(1, TabID);
            ps.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Database error");
        }
    }













}
