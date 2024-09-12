USE work_order_pro;

-- survey_question
--
DROP TABLE IF EXISTS survey_question;

-- Create Table
CREATE TABLE survey_question
(
  survey_question_number  INTEGER      NOT NULL  COMMENT 'Survey Question Number'
 ,survey_question         VARCHAR(75)  NOT NULL  COMMENT 'Survey Question'

,PRIMARY KEY (survey_question_number)
)
COMMENT 'Survey Question'
;

-- Insert data
INSERT INTO survey_question 
VALUES
 (1, 'On a scale of 0-9, rate the professionalism of the technician.')
,(2, 'On a scale of 0-9, rate the competance of the technician.')
,(3, 'On a scale of 0-9, how likely are you to recommend your technican?')
,(4, 'On a scale of 0-9, how happy are you with your product?');



-- Verify table and data
SELECT * FROM work_order_pro.survey_question;
