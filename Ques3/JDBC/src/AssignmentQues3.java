import java.sql.*;
import java.util.Scanner;

public class AssignmentQues3 {
    public static final String url = "jdbc:mysql://localhost:3306/c11_java_students";
    public static final String username = "root";
    public static final String password = "Asmita#132";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--- Student Management Menu ---");
                System.out.println("1. View All Students");
                System.out.println("2. Add Student");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> viewStudents(connection);
                    case 2 -> addStudent(connection, scanner);
                    case 3 -> updateStudent(connection, scanner);
                    case 4 -> deleteStudent(connection, scanner);
                    case 5 -> {
                        System.out.println("Exiting Program...");
                        return;
                    }
                    default -> System.out.println("Invalid Choice. Try Again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private static void viewStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM studentshw";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            boolean hasRecords = false;

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                hasRecords = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                float sgpa = rs.getFloat("sgpa");

                System.out.printf("ID: %d | Name: %s | Age: %d | SGPA: %.2f%n", id, name, age, sgpa);
            }

            if (!hasRecords) {
                System.out.println("No student records found. Please add records to view them.");
            }
        }
    }

    private static void addStudent(Connection connection, Scanner scanner) throws SQLException {
        String query = "INSERT INTO studentshw (name, age, sgpa) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            scanner.nextLine(); // Consume leftover newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            System.out.print("Enter SGPA: ");
            float sgpa = scanner.nextFloat();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setFloat(3, sgpa);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        int generatedId = keys.getInt(1);
                        System.out.println("Student Added Successfully with ID: " + generatedId);
                    }
                }
            } else {
                System.out.println("Insert failed.");
            }
        }
    }

    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID of Student to Update: ");
        int id = scanner.nextInt();

        System.out.println("Choose field(s) to update:");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. SGPA");
        System.out.println("4. All");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        String query;
        PreparedStatement ps;

        switch (choice) {
            case 1 -> {
                query = "UPDATE studentshw SET name = ? WHERE id = ?";
                ps = connection.prepareStatement(query);
                scanner.nextLine(); // Consume leftover newline
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                ps.setString(1, name);
                ps.setInt(2, id);
            }
            case 2 -> {
                query = "UPDATE studentshw SET age = ? WHERE id = ?";
                ps = connection.prepareStatement(query);
                System.out.print("Enter new Age: ");
                int age = scanner.nextInt();
                ps.setInt(1, age);
                ps.setInt(2, id);
            }
            case 3 -> {
                query = "UPDATE studentshw SET sgpa = ? WHERE id = ?";
                ps = connection.prepareStatement(query);
                System.out.print("Enter new SGPA: ");
                float sgpa = scanner.nextFloat();
                ps.setFloat(1, sgpa);
                ps.setInt(2, id);
            }
            case 4 -> {
                query = "UPDATE studentshw SET name = ?, age = ?, sgpa = ? WHERE id = ?";
                ps = connection.prepareStatement(query);
                scanner.nextLine(); // Consume leftover newline
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Age: ");
                int age = scanner.nextInt();
                System.out.print("Enter new SGPA: ");
                float sgpa = scanner.nextFloat();
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setFloat(3, sgpa);
                ps.setInt(4, id);
            }
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Student Updated Successfully." : "Update Failed or ID Not Found.");
        ps.close();
    }

    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        String query = "DELETE FROM studentshw WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            System.out.print("Enter ID of Student to Delete: ");
            int id = scanner.nextInt();

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student Deleted Successfully." : "Delete Failed or ID Not Found.");
        }
    }
}
