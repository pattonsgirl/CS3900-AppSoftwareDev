CREATE DATABASE IF NOT EXISTS school;
USE school;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL
);

INSERT INTO school.students (firstName, lastName) VALUES ("John", "Doe");