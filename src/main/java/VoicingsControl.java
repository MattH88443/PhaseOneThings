import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoicingsControl {

    public static void listVoicings(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT VoicingID, ChordID, HighE, B, G, D, A, LowE FROM Voicings");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int VoicingID = results.getInt(1);
                int ChordID = results.getInt(2);
                int HighE = results.getInt(3);
                int B = results.getInt(4);
                int G = results.getInt(5);
                int D = results.getInt(6);
                int A = results.getInt(7);
                int LowE = results.getInt(8);
                System.out.println(VoicingID + " " + ChordID + " " + LowE+A+D+G+B+HighE);
            }
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
