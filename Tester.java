import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Session> sessions = new ArrayList<Session>();
        
        String tempName; //temporary name holder for sessions
        int tempId; //temporary id for sessions
        String tempProctor; //temporary proctor name for sessions

        try {
            File students = new File("SeniorSeminarSessions.xlsx - Sheet1.csv");
            Scanner myReader = new Scanner(students);
            int count = 0;
            while (myReader.hasNextLine()) {
                String currentSession[] = myReader.nextLine().split(",");
                tempName = currentSession[0];
                tempId = Integer.parseInt(currentSession[1]);
                tempProctor = currentSession[2];
                sessions.add(new Session(tempName, tempId, tempProctor));
                count++;
            }
            System.out.println("Finished session try catch for a total of " + (count) + " sessions.");
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx - Sheet1.csv' into the program.");
            e.printStackTrace();
        }
    }
}