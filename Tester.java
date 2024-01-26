import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Student> unassignedList = new ArrayList<Student>();
        ArrayList<Session> sessionList = new ArrayList<Session>();
        int[] seshPopularity = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean[] seshDouble = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}; // true if session is in top 7 (meaning they get a second )
        int[] topSesh = {0, 0, 0, 0, 0, 0, 0}; //top 7 sessions
        int temp = 0;
 
        String tempName; //temporary name holder for sessions/students
        int tempId; //temporary id for sessions
        String tempProctor; //temporary proctor name for sessions
        String tempTime; //temporary time for students
        String tempUser; //temporary username for students
        int choice1; //temporary students choices
        int choice2;
        int choice3;
        int choice4;
        int choice5;

        try { //try catch for students data table
            File students = new File("SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv");
            Scanner stuScanner = new Scanner(students);
            int count = 0;
            while (stuScanner.hasNextLine()) {
                String currentStudent[] = stuScanner.nextLine().split(",");
                tempTime = currentStudent[0];
                tempName = currentStudent[1];
                tempUser = currentStudent[2];

                //not sure if this whole thing will work how i want it to but its ok !!
                choice1 = Integer.parseInt(currentStudent[3]); //number 1 choice
                seshPopularity[choice1] = seshPopularity[choice1] + 5; //adds 5 to the session's popularity points
                //System.out.println("added 5 to session " + choice1 + "'s popularity");

                choice2 = Integer.parseInt(currentStudent[4]); //2
                seshPopularity[choice2] = seshPopularity[choice2] + 4;

                choice3 = Integer.parseInt(currentStudent[5]); //3
                seshPopularity[choice3] = seshPopularity[choice3] + 3;

                choice4 = Integer.parseInt(currentStudent[6]); //4
                seshPopularity[choice4] = seshPopularity[choice4] + 2;

                choice5 = Integer.parseInt(currentStudent[7]); //5
                seshPopularity[choice5] = seshPopularity[choice5] + 1;

                if(choice1 > 0) {
                    studentList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5)); // if they made any choices
                }
                else {
                    unassignedList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5)); // if they didnt make any choices
                }
                
                count++;
            }
            System.out.println("Finished student try catch for a total of " + (count) + " students.");
            stuScanner.close();
            for(int x = 0; x < 19; x++) {
                System.out.println("Session " + (x) + " has a popularity of " + seshPopularity[x]);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv' into the program.");
            e.printStackTrace();
        }

        // NEED TO WORK ON THIS BUT I NEED A BREAK ITS TOO CONFUSING RN

        /* for(int i = 1; i < 19; i++) { // each session (18 total excluding the people who didnt fill out the form (their # is 0))
           for(int y = 0; y < 7; y+=) { //each spot for top sessions (7 total)
                if(seshPopularity[i] > topSesh[y]) { //if the current session has more popularity than the one its being compared to
                    int y2 = y; // variable to keep track of how far into the 7 most popular sessions it is
                    while(y2 < 7) { // when its not the last of the most popular
                        temp = topSesh[y2];
                        seshPopularity[i] // dlfkjdksjf IDK
                    }
                }
            }
        } */

        try { //try catch for sessions data table
            File sessions = new File("SeniorSeminarSessions.xlsx - Sheet1.csv");
            Scanner seshScanner = new Scanner(sessions);
            int count = 0;
            while (seshScanner.hasNextLine()) {
                String currentSession[] = seshScanner.nextLine().split(",");
                tempName = currentSession[0];
                tempId = Integer.parseInt(currentSession[1]);
                tempProctor = currentSession[2];
                sessionList.add(new Session(tempName, tempId, tempProctor, seshPopularity[tempId])); // need to add something to get rid of something with little popularity (session 4 haha)
                count++;
            }
            System.out.println("Finished session try catch for a total of " + (count) + " sessions.");
            seshScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx - Sheet1.csv' into the program.");
            e.printStackTrace();
        }

        
    }
}