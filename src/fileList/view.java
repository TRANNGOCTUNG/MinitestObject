package fileList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class view {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("01", "Minh Ngọc", 23));
        list.add(new Student("02", "Thu trang", 20));
        writeToFile(list, "Demo.dat");
        List<Student> studentList;
        studentList = readFile("Demo.dat");
        System.out.println(studentList);
    }

    public static void writeToFile(List<Student> students, String name) {
        File file = new File(name);
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFile(String name) {
        File file = new File(name);
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(is);
            List<Student> students = (List<Student>) oos.readObject();
            return students;
        } catch (IOException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }
}
