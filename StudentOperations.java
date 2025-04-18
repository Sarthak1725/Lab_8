import java.util.ArrayList;
import java.util.List;

public class StudentOperations {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int prn, String batch) throws EmptyFieldException, DuplicatePRNException {
        if (name.isEmpty() || batch.isEmpty()) {
            throw new EmptyFieldException("Name or batch cannot be empty.");
        }
        for (Student s : students) {
            if (s.getPrn() == prn) {
                throw new DuplicatePRNException("Student with this PRN already exists.");
            }
        }
        students.add(new Student(name, prn, batch));
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
    
    public void searchStudent(int prn) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getPrn() == prn) {
                System.out.println(s);
                return;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    public void deleteStudent(int prn) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getPrn() == prn) {
                students.remove(s);
                System.out.println("Student with PRN " + prn + " has been deleted.");
                return;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    
}