import javax.sound.sampled.Line;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LinesControl {

    public static void addLine(int LineID, int TabID, int LineIndex, String Lyrics){
        try{
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Lines (LineID, TabID, LineIndex, Lyrics) VALUES (?,?,?,?)");
            ps.setInt(1, LineID);
            ps. setInt(2, TabID);
            ps.setInt(3, LineIndex);
            ps.setString(4, Lyrics);
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

    public static void updateLine(int LineID, String Lyrics, int LineIndex){
        try {
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Lines SET Lyrics = ?, LineIndex = ? WHERE LineID = ?");
            ps.setString(1, Lyrics);
            ps.setInt(2, LineIndex);
            ps.setInt(3, LineID);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
    public static void deleteLine(int LineID, int LineIndex){
        try {
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Lines WHERE LineID = ? AND LineIndex = ?");
            ps.setInt(1, LineID);
            ps.setInt(2, LineIndex);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
