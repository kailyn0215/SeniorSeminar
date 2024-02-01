# SeniorSeminar
A Java based solution to minimize scheduling conflicts.

Info:
- 5 sessions
- 5 classrooms available for each session (25 sessions in total, 18 available sessions)
- maximum of 16 people allowed in each session
- each session can run a maximum of 2 times (can't run two of the same session at the same time)
- each person can't be in the same session twice
- if cutting a session there must be a good reason

Plan:
- Start by creating array list of the student names, emails, the time they filled out the survey, along w/ their list + priority (with remade excel sheet)
- Create list with session names, ids, and presenters (with separate excel sheet)
- Rearrange student priority based on the time they filled out the survey/if they filled out the survey (do this outside of the code)
- use 2x2 array (like battleship) for classrooms and time slots
- (possibly) go down the list of their first choices and assign based off of that then continue for 2nd 3rd etc... - not sure abt this yet bc im not sure how it will turn out
- while going down the list keep track of which ones are most popular/least popular (points system 5 pts for first choice, 1 pt for last, etc) + which ones need a second session (at least 7 i think)
- maybe array thing of rooms & times?

1/18 update:
figured out how to read the excel files (i know its dumb)
got the try catch for sessions working + printing the session names, ids, and proctors
started the try catch for students
added to the session.java file to get the sessions to work (added variables etc)
added some variables to tester as well in order to get try catch working
also thought about how to optimize the students choices, maybe go to the side based on popularity? ex:
time: 1, 2, 3, 4, 5
rooms:
1 --- 1, 2, 3, 4, 5
2 --- 6, 7, 8, 9, 10
(i am now realizing that this is not formatting the way i want it to)
maybe more of a change for people to get their top choices since the popular ones wont all be in timeslot 1?

1/22 update:
fixed some issues with the student excel sheet
finished reading both files
able to read off the list of people or sessions
yay!!!

2/1 update:
got a list organized based off of the popularity of the sessions
planning on using this list of ids to create the table of sessions (need to come up with a plan for this </3)

1/26 update:
made get/set functions in both student + sessions files
brainstormed on how to schedule the different sessions
worked on sorting the most popular sessions to make a 2nd iteration of them (need to keep working on this and integrating removing the smallest sessions to create more room for more popular sessions)
