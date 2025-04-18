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

    
}