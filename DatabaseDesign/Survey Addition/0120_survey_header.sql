USE work_order_pro;

-- survey_header
--
DROP TABLE IF EXISTS survey_header;

-- Create Table
CREATE TABLE survey_header
(
  survey_number      INTEGER  NOT NULL  AUTO_INCREMENT  COMMENT 'Survey Number'
 ,work_order_number  INTEGER  NOT NULL                  COMMENT 'Work Order Number'
 ,survey_date        DATE     NOT NULL                  COMMENT 'Survey Date'

,PRIMARY KEY (survey_number)
)
COMMENT 'Survey Header'
;

ALTER TABLE survey_header
  ADD CONSTRAINT survey_header_work_order_fk
  FOREIGN KEY    (work_order_number)
  REFERENCES     work_order (work_order_number)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;



-- Verify table and data
SELECT * FROM work_order_pro.survey_header;
