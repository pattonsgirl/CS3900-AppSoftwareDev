USE my_development_database;

-- ---------------------------------------------------------------------------------------------------------------------------
-- General Information Regarding Table
-- ---------------------------------------------------------------------------------------------------------------------------
-- SQL Table:        documents
-- Programmer:       Alison
-- Creation Date:    September 12,2024
-- Location:         my_development_database
-- Project:          RL-2213 - Examples of Creating Database Constraints
-- ---------------------------------------------------------------------------------------------------------------------------
-- Technical / Special Programming Logic / Notes and Considerations
-- ---------------------------------------------------------------------------------------------------------------------------
-- Disclaimers / Notes:
--
--
-- ---------------------------------------------------------------------------------------------------------------------------
-- Modification Log
-- ---------------------------------------------------------------------------------------------------------------------------
-- Mod#  Date      Programmer         Description
-- ----  --------  -----------------  ----------------------------------------------------------------------------------------
-- M01   09/12/24  Alison Eller       RL-2213 - Examples of Creating Database Constraints
-- ---------------------------------------------------------------------------------------------------------------------------
-- Create Table and Columns
-- ---------------------------------------------------------------------------------------------------------------------------
CREATE TABLE documents
(
  documents_id        BIGINT(20)    NOT NULL  AUTO_INCREMENT                                         COMMENT 'PK for Documents'

 ,company_id          BIGINT(20)    NOT NULL                                                         COMMENT 'FK to Company'

 ,document_type       VARCHAR(3)    NOT NULL                                                         COMMENT 'Document Type'
 ,onbase_item_number  VARCHAR(100)  NOT NULL                                                         COMMENT 'OnBase Item Number'
 ,expiration_date     DATE          NOT NULL                                                         COMMENT 'Expiration Date'

 ,added_by_user       VARCHAR(50)   NOT NULL  DEFAULT CURRENT_USER                                   COMMENT 'Added by User'
 ,added_by_winid      CHAR(6)                                                                        COMMENT 'Added by Win ID'
 ,added_by_origin     VARCHAR(200)  NOT NULL                                                         COMMENT 'Added by Program or Screen'
 ,added_timestamp     DATETIME      NOT NULL  DEFAULT CURRENT_DATETIME                               COMMENT 'Added Timestamp'

 ,changed_by_user     VARCHAR(50)   NOT NULL  DEFAULT CURRENT_USER                                   COMMENT 'Changed by User'
 ,changed_by_winid    CHAR(6)                                                                        COMMENT 'Changed by Win ID'
 ,changed_by_origin   VARCHAR(200)  NOT NULL                                                         COMMENT 'Changed by Program or Screen'
 ,changed_timestamp   DATETIME      NOT NULL  DEFAULT CURRENT_DATETIME  ON UPDATE CURRENT_DATETIME   COMMENT 'Changed Timestamp'

 ,PRIMARY KEY (documents_id)

)COMMENT 'Documents'
;


-- -------------------------------------------------------------------------------------------------
-- Define Foreign Key(s)
-- -------------------------------------------------------------------------------------------------
ALTER TABLE documents
  ADD CONSTRAINT  documents_company_fk
  FOREIGN KEY     (company_id)
  REFERENCES      company (company_id)
  ON DELETE       RESTRICT
  ON UPDATE       RESTRICT;


-- -------------------------------------------------------------------------------------------------
-- Define Unique Constraint(s)
-- -------------------------------------------------------------------------------------------------
ALTER TABLE documents
  ADD UNIQUE documents_company_id_onbase_item_number_uk (company_id, onbase_item_number);


-- -------------------------------------------------------------------------------------------------
-- Define Check Constraint(s)
-- -------------------------------------------------------------------------------------------------
ALTER TABLE documents
  ADD CONSTRAINT  documents_document_type_ck
  CHECK           (document_type IN ('w9', 'coi', 'vea'));


-- -------------------------------------------------------------------------------------------------
-- Define Additional Indexes (if needed)
-- -------------------------------------------------------------------------------------------------

