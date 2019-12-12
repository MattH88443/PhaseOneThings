import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class COLControl {
    public static void addCOL(int ChordID, int LineID, int WordNumber){
        try{
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO ChordsOnLine (ChordID, LineID, WordNumber) VALUES (?,?,?)");
            ps.setInt(1, ChordID);
            ps. setInt(2, LineID);
            ps.setInt(3, WordNumber);
            ps.executeUpdate();
        } catch (Exception exception){
            System.out.println("Database error");
        }
    }



    public static void listCOLs(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ChordID, LineID, WordNumber FROM ChordsOnLine");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int ChordID = results.getInt(1);
                int LineID = results.getInt(2);
                int WordNumber = results.getInt(3);
                System.out.println(ChordID + " " + LineID + " " + WordNumber);
            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void updateCOL(int ChordID, int LineID, int WordNumber){
        try {
            PreparedStatement ps = Main.db.prepareStatement("UPDATE ChordsOnLine SET ChordID = ? WHERE LineID = ? AND WordNumber = ?");
            ps.setInt(1, ChordID);
            ps. setInt(2, LineID);
            ps.setInt(3, WordNumber);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
    public static void deleteCOL(int LineID, int WordNumber){
        try {
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM ChordsOnLine WHERE LineID = ? AND WordNumber = ?");
            ps.setInt(1, LineID);
            ps.setInt(2, WordNumber);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
