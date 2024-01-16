import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            File students = new File("Senior Seminar Sessions.xlsx");
            Scanner myReader = new Scanner(students);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'Senior Seminar Sessions.xlsx' and 'Senior Seminar Student.xlsx' into the program.");
            e.printStackTrace();
        }
    }
}