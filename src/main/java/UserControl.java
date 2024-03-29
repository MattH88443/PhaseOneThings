import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserControl {

    public static void addUser(String Username, String Password, String FirstName, String LastName){
        try {

            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Users (Username, Password, FirstName, LastName) VALUES (?, ?, ?, ?)");

            ps.setString(1, Username);
            ps.setString(2, Password);
            ps.setString(3, FirstName);
            ps.setString(4, LastName);
            ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }

    }

    public static void listUsers(){
        try {

            PreparedStatement ps = Main.db.prepareStatement("SELECT UserID, Username, FirstName, LastName FROM Users");

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int UserID = results.getInt(1);
                String Username = results.getString(2);
                String FirstName = results.getString(3);
                String LastName = results.getString(4);
                System.out.println(UserID + ": Username: " + Username + " FirstName: " + FirstName + " LastName: " + LastName);
            }

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void updateUser(int UserID, String Username, String Password, String FirstName, String LastName){
        try{
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Users SET Username = ?, Password = ?, FirstName = ?, LastName = ? WHERE UserID = ?");

            ps.setString(1, Username);
            ps.setString(2, Password);
            ps.setString(3, FirstName);
            ps.setString(4, LastName);
            ps.setInt(5, UserID);
            ps.executeUpdate();
        }catch (Exception exception){
            System.out.println("Database error");
        }
    }

    public static void deleteUser(int UserID) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Users WHERE UserID = ?");
            ps.setInt(1, UserID);
            ps.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Database error");
        }
    }


























}
