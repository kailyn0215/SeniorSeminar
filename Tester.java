import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

/*i have no idea how to parse through a excel sheet so im putting these here are reference for future when i implement it 
  https://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file
  i dont think we learned this in class so idk what else to do :(
*/

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<String> sessions = new ArrayList<String>();

        try {
            File students = new File("SeniorSeminarSessions.xlsx");
            Scanner myReader = new Scanner(students);
            int count = 0;
            while (myReader.hasNextLine()) {
                String currentSession= myReader.nextLine();
                sessions.add(currentSession);
                System.out.println("Added " + sessions.get(count) + " to session list");
                count++;
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx' into the program.");
            e.printStackTrace();
        }
    }
}