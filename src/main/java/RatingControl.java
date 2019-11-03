import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingControl {


    public static void addRating(int Rating, int TabID, int UserID) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Ratings (Rating, TabID, UserID) VALUES (?,?,?)");

            ps.setInt(1, Rating);
            ps.setInt(2,  TabID);
            ps.setInt(3, UserID);
            ps.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }

    }

    public static void listRatings(){
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT Rating, TabID, UserID FROM Ratings");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int Rating = results.getInt(1);
                int TabID = results.getInt(2);
                int UserID = results.getInt(3);
                System.out.println("Rating: " + Rating + " TabID: " + TabID + " UserID: " + UserID);
            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void updateRating(int Rating, int TabID, int UserID){
        try {
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Ratings SET Rating = ? WHERE TabID = ? AND UserID = ?");
            ps.setInt(1, Rating);
            ps.setInt(2, TabID);
            ps.setInt(3, UserID);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void deleteRating(int TabID, int UserID){
        try {
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Ratings WHERE TabID = ? AND UserID = ?");
            ps.setInt(1, TabID);
            ps.setInt(2, UserID);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }








}
