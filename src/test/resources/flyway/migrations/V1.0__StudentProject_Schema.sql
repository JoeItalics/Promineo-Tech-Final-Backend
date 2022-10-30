DROP TABLE IF EXISTS StudentClasses;
DROP TABLE IF EXISTS students;

DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS classes;

CREATE TABLE IF NOT EXISTS Classes(classPK VARCHAR(20) primary key, subject TEXT, gradeYear INTEGER); 
CREATE TABLE IF NOT EXISTS Students(studentPK VARCHAR(20) primary key, firstName TEXT, lastName TEXT, gradeYear INT);
CREATE TABLE IF NOT EXISTS Assignments(assignmentName TEXT, classId VARCHAR(20), firstName TEXT, lastName TEXT, assignmentGrade INT, FOREIGN KEY(classId) REFERENCES Classes(classPK) ON DELETE CASCADE);
CREATE TABLE IF NOT EXISTS StudentClasses(studentPK VARCHAR(20), classPK VARCHAR(20), FOREIGN KEY(studentPK) REFERENCES Students(studentPK) ON DELETE CASCADE, FOREIGN KEY(classPK) REFERENCES Classes(classPK) ON DELETE CASCADE); 

INSERT INTO CLASSES(classPK, subject, gradeYear) VALUES("MATH110", "MATH", 110);
INSERT INTO CLASSES(classPK, subject, gradeYear) VALUES("MATH210", "MATH", 210);
INSERT INTO CLASSES(classPK, subject, gradeYear) VALUES("ALGBRA310", "ALGBRA", 310);
INSERT INTO CLASSES(classPK, subject, gradeYear) VALUES("CMP410", "CMP", 410);

INSERT INTO Students(studentPK, firstName, lastName, gradeYear) VALUES("JOSEITALI7781", "Joseph", "Italico", 12);
INSERT INTO Students(studentPK, firstName, lastName, gradeYear) VALUES("AlexKren2312", "Alex", "Krendik", 4);

INSERT INTO Assignments(assignmentName, classId, firstName, lastName, assignmentGrade) VALUES(" Week 1 Alegbra practice", "ALGBRA310", "Joseph", "Italico", 75);
INSERT INTO Assignments(assignmentName, classId, firstName, lastName, assignmentGrade) VALUES(" Week 1 Math practice", "MATH110", "Alex", "Krendik", 85);
INSERT INTO Assignments(assignmentName, classId, firstName, lastName, assignmentGrade) VALUES(" Java Week 18 Final Project", "CMP410", "Alex", "Krendik", 92);



INSERT INTO STUDENTCLASSES(studentPK, classPK) VALUES("JOSEITALI7781", "ALGBRA310");
INSERT INTO STUDENTCLASSES(studentPK, classPK) VALUES("AlexKren2312", "MATH110");
INSERT INTO STUDENTCLASSES(studentPK, classPK) VALUES("AlexKren2312", "CMP410");