# Database Design - Group Project Additions

## Purpose / Objectives

- Conceptual, Logical, & Physical Database Models for group project
- Initialize MariaDB container environment for group project
- Build physical database in container environment for group project
- Write basic queries to validate database configuration and data for group database

## Description

If you have not already, join your group's GitHub repository and clone the repository to your system.

Through the DB Design unit, you have been given assignments to individual present your understanding of the different models and database tools.  The group project component will focus on collecting these to one group-agreed-on decision and collection to build on going forward.

In your Group Project repository, create a folder named `DB` to contain the following elements.

Use a computer-based visualization tool (not pen and paper) to upload your group project models to file a file named `db-models.md` for the:
- Conceptual Model
- Logical Model
- Physical Model

These models should flow in agreement with each other.

`docker-compose.yml` that contains information needed to build the MariaDB container to your group project's database needs.

`init_PROJECTNAME.sql` that contains SQL statements to build the database per the physical model's specifications.

`README.md` that contains how group members will start the container, connect to it, and core SQL phrases to interact with the group database.
    - NOTE: This should be written such that all of your group members are comfortable referring to this guide when starting the DB in the future
    - NOTE: I recommend picking ONE group member who's updates to `init_PROJECTNAME.sql` will get committed to GitHub.  The others should NOT commit their updates in order to avoid merge conflicts.

`SQL Toolbox` that contains SQL queries to validate the database configuration and data for group database

## Deliverable(s)

The group repository needs to include the following:
- `db-models.md` containing:
    - Conceptual Model
    - Logical Model
    - Physical Model
    - Description / Justification of presented models
- `docker-compose.yml` to build container environment
- `init_PROJECTNAME.sql` to build database per physical model
- `README.md` with usage & SQL guidance
- `SQL Toolbox` folder with SQL queries

## Submission

Submit link to assignment repository in the Dropbox in Pilot.  Only ONE team member needs to remember to submit the link.

URL looks like: https://github.com/WSU-kduncan/cs3900-YOURGROUPNAME

## Rubric

Score: # out of 24 points

Since there has been in class discussion time to build each model and agree to the foundations as a group, who commits the collection of models and other required elements will not be tracked.

In the `DB` folder:

- `db-models.md` contains:
    - Conceptual Model ( / 3)
        - visualization provided
        - description provided
        - is understandable by all parties (business to developers)
    - Logical Model ( / 4)
        - visualization provided
        - description provided
        - shows primary key & non-key attributes of entities
        - shows relationship between entities using foreign keys
    - Physical model ( / 4)
        - visualization provided
        - description provided
        - platform specific
        - defines data types for attributes

- `docker-compose.yml` to builds container environment ( / 1)
- `init_PROJECTNAME.sql` to builds database per physical model ( / 5)
- `README.md` contains ( / 2)
    - usage instructions to build & connect to database
    - SQL command guidance
- `SQL Toolbox` folder with SQL queries ( / 5)


