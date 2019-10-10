import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TabControl {



    public static void addTab(String TabURL, String SongName, String Creator){
        Scanner input = new Scanner (System.in);
        try{
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Tabs (TabURL, SongName, Creator) VALUES (?,?,?)");
            ps. setString(1, TabURL);
            ps.setString(2, SongName);
            ps.setString(3, Creator);
        } catch (Exception exception){
            System.out.println("Database error");
        }
    }

    public static void listTabs(){
        try {

            PreparedStatement ps = Main.db.prepareStatement("SELECT TabID, TabURL, SongName, Creator FROM Tabs");

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int TabID = results.getInt(1);
                String TabURL = results.getString(2);
                String SongName = results.getString(3);
                String Creator = results.getString(4);
                System.out.println(TabID + ": TabURL: " + TabURL + " SongName: " + SongName + " Creator: " + Creator);

            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void updateTab(String TabURL, String SongName, String Creator, int TabID){
        try{
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Tabs SET TabURL = ?, SongName = ?, Creator = ? WHERE TabID = ?");
            ps.setString(1, TabURL);
            ps.setString(2, SongName);
            ps.setString(3, Creator);
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
