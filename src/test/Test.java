package test;

import fileList.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("01","Minh Ngọc",23));
        list.add(new Student("02", "Thu Trang",20));
        writeFile(list);
        try {
            InputStream is = new FileInputStream("C:\\File Codegym\\New folder\\docs\\MinitestList\\input.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            OutputStream os = new FileOutputStream("C:\\File Codegym\\New folder\\docs\\MinitestList\\output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            List<Student> students = (List<Student>) ois.readObject();
            oos.writeObject(students);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void writeFile(List<Student> students){
        try{
            OutputStream os = new FileOutputStream("C:\\File Codegym\\New folder\\docs\\MinitestList\\input.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(students);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
