import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LinesControl {

    public static void addLine(int TabID, int LineID, String Lyrics){
        Scanner input = new Scanner (System.in);
        try{
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Lines (TabID, LineID, UserID) VALUES (?,?,?)");
            ps. setInt(1, TabID);
            ps.setInt(2, LineID);
            ps.setString(3, Lyrics);
            ps.executeUpdate();
        } catch (Exception exception){
            System.out.println("Database error");
        }
    }



    public static void listLines(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT LineID, TabID, LineIndex, Lyrics FROM Lines");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int LineID = results.getInt(1);
                int TabID = results.getInt(2);
                int Index = results.getInt(3);
                String Lyrics = results.getString(4);
                System.out.println(LineID + " " + TabID + " " + Index + " " + Lyrics);
            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
