import java.util.ArrayList;
import java.util.List;

class Student {

    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student \n{ \n id = " + id + ",\n name = " + name + ",\n marks = " + marks + "\n}\n";
    }
}

interface StudentIterator {
    public boolean hasNext();

    public Student getNext();
}

class StudentCollection {

    List<Student> ls = new ArrayList<Student>();

    public void addStudent(Student s) {
        ls.add(s);
    }

    public void removeStudent(Student s) {
        ls.remove(s);
    }

    public StudentIterator getIterator() {
        return new StandardIterator();
    }

    public StudentIterator choiceIterator(String choice) {
        if (choice.equalsIgnoreCase("Marks")) {
            return new CustomisedIterator();
        } else {
            return new StandardIterator();
        }
    }

    private class StandardIterator implements StudentIterator {
        int position;

        public boolean hasNext() {
            if (position < ls.size()) {
                return true;
            }
            return false;
        }

        public Student getNext() {
            Student s = ls.get(position);
            position++;

            return s;
        }
    }

    private class CustomisedIterator implements StudentIterator {
        int position;

        public boolean hasNext() {
            while (position < ls.size()) {
                Student s = ls.get(position);
                if (s.getMarks() >= 100) {
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        public Student getNext() {
            Student s = ls.get(position);
            position++;

            return s;
        }
    }
}

public class ITERATOR_STUDENT {
    public static void main(String[] args) {
        StudentCollection s = new StudentCollection();
        Student s1 = new Student(101, "Prayag", 100);
        Student s2 = new Student(102, "Aniket", 99);
        Student s3 = new Student(103, "Denil", 90);
        Student s4 = new Student(104, "Bhavya", 80);

        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);
        s.addStudent(s4);

        System.out.println("Students with greater than or equal to 100 marks are : ");
        StudentIterator snew = s.choiceIterator("Marks");
        while (snew.hasNext()) {
            System.out.println(snew.getNext());
        }
    }
}
