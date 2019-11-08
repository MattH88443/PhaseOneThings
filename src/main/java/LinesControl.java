import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LinesControl {
    public static void listLines(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT LineID, TabID, Index, Lyrics FROM Lines");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int LineID = results.getInt(1);
                int TabID = results.getInt(2);
                int Index = results.getInt(3);
                String Lyrics = results.getString(4);
            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
