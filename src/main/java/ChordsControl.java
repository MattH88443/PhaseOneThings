import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChordsControl {
    public static void listChords(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ChordID, Root, Variant FROM Chords");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int ChordID = results.getInt(1);
                String Root = results.getString(2);
                String Variant = results.getString(3);
                System.out.println(ChordID + " " + Root+Variant);
            }
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
