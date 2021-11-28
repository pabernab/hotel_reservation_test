import java.sql.*;
import java.util.Scanner;
import java.sql.Date;

public class MyJDBC {

    public static void main(String[] args) {
        try {

            Scanner scan = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_system", "root",
                    "password");

            System.out.print("Your user Id: ");
            int userId = scan.nextInt();

            System.out.print("Room id: ");
            int roomID = scan.nextInt();

            System.out.println("Start date(format: yyyy-mm-dd): ");
            String startDate = scan.next();

            System.out.println("End date(format: yyyy-mm-dd): ");
            String endDate = scan.next();

            scan.close();

            PreparedStatement stmt = connection.prepareStatement(
                    "insert into `reservation` (uID, roomID, startDate, endDate, updatedAt)  values(?, ?, ? , ?, current_date )");

            stmt.setInt(1, userId);
            stmt.setInt(2, roomID);
            stmt.setDate(3, Date.valueOf(startDate));
            stmt.setDate(4, Date.valueOf(endDate));
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}