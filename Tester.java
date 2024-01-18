import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Session> sessionList = new ArrayList<Session>();
        
        String tempName; //temporary name holder for sessions
        int tempId; //temporary id for sessions
        String tempProctor; //temporary proctor name for sessions

        try { //try catch for sessions data table
            File sessions = new File("SeniorSeminarSessions.xlsx - Sheet1.csv");
            Scanner seshScanner = new Scanner(sessions);
            int count = 0; //i dont remember why i added this rn </3
            while (seshScanner.hasNextLine()) {
                String currentSession[] = seshScanner.nextLine().split(",");
                tempName = currentSession[0];
                tempId = Integer.parseInt(currentSession[1]);
                tempProctor = currentSession[2];
                sessionList.add(new Session(tempName, tempId, tempProctor));
                count++;
            }
            System.out.println("Finished session try catch for a total of " + (count) + " sessions.");
            seshScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx - Sheet1.csv' into the program.");
            e.printStackTrace();
        }

        /*try {
            File students = new File("SeniorSeminarStudent.xlsx - Sheet1.csv");
        }
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx - Sheet1.csv' into the program.");
            e.printStackTrace();
        }*/
    }
}