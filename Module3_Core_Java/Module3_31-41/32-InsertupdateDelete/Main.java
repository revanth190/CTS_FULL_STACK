public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a new student
        dao.insertStudent("Charlie", 23);

        // Update a student (change Charlie's name and age)
        dao.updateStudent(3, "Charles", 24); // Make sure ID 3 exists

          // Display all students
          dao.getAllStudents();
    }
}
