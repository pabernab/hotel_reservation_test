import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;


public class jdbc {

    public static void main(String[] args) {
        try {

            Scanner scan = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation", "root", "Trey1998$$$");

            System.out.print("Enter user Id: ");
            int userId = scan.nextInt();

            System.out.print("Enter room id: ");
            int roomID = scan.nextInt();

            System.out.println("Enter reservation date(format: yyyy-mm-dd): ");
            String resDate = scan.next();

            PreparedStatement stmt = connection.prepareStatement("insert into `room` (roomID, roomType)  values(?, ?)");

            stmt.setInt(1, userId);
            stmt.setInt(2, roomID);
            stmt.executeUpdate();

            if (resDate.equals(LocalDate.now().toString())){
                System.out.println("Thank you for checking in!");
            }
            else{
                System.out.println("Your reservation is not for today!");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


