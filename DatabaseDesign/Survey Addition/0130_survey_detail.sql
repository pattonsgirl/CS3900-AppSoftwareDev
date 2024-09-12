USE work_order_pro;

-- survey_detail
--
DROP TABLE IF EXISTS survey_detail;

-- Create Table
CREATE TABLE survey_detail
(
  survey_detail_number    INTEGER  NOT NULL  AUTO_INCREMENT  COMMENT 'Survey Detail Number'
 ,survey_number           INTEGER  NOT NULL                  COMMENT 'Survey Number'
 ,survey_question_number  INTEGER  NOT NULL                  COMMENT 'Survey Question Number'
 ,question_score          TINYINT  NOT NULL                  COMMENT 'Question Score'

,PRIMARY KEY (survey_detail_number)
)
COMMENT 'Survey Detail'
;

ALTER TABLE survey_detail
  ADD CONSTRAINT survey_detail_survey_header_fk
  FOREIGN KEY    (survey_number)
  REFERENCES     survey_header (survey_number)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE survey_detail
  ADD CONSTRAINT survey_detail_survey_question_fk
  FOREIGN KEY    (survey_question_number)
  REFERENCES     survey_question (survey_question_number)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;



-- Verify table and data
SELECT * FROM work_order_pro.survey_detail;
