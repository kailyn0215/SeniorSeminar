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
- Start by creating array list of the student names, emails, the time they filled out the survey, along w/ their list + priority
- Create list with session names, ids, and presenters
- Rearrange student priority based on the time they filled out the survey/if they filled out the survey (maybe do this outside of the code)
- use 2x2 array (like battleship) for classrooms and time slots
- (possibly) go down the list of their first choices and assign based off of that then continue for 2nd 3rd etc...
