# Final Project Elements Rubric

## Core Requirements (or project final score is a 0)

1. Database builds, runs, and can be connected to
2. Microservice builds, runs, and can respond to resources
3. Frontend builds, runs, and presents a frontend site

## Individual Contributions (or team member will receive a 0)

- Team member made reasonable number of contributions to group project commit history between 12/1 & 12/11
    - Just a spelling update here or there is not considered a significant contribution

## Documentation Requirements

- Project `README.md` contains (or links to) business case & agile requirements of the project
- Project `README.md` contains (or links to) documentation on how to build each major project component
- Project `README.md` describes to the team / customer what parts of your application complete the checklist(s) below
- Project `README.md` in section titled `Future Work` describes remaining TODOs before the application could be considered complete
  - address remaining bugs
  - note partially implemented pieces
  - note unfulfilled features from the Business Requirements 

## Core Application Capabilities

- Frontend provides navigation & menuing features
- Frontend presents all records of some resource using information stored in the database
- Frontend allows user to create a **new** record for some resource and stores the update in the database
- Frontend allows user to update an **existing** record for some resource and stores the update in the database
- Frontend allows user to **filter** records for some resource using information stored in the database
- [Bonus] Frontend displays some business case valuable report of records in the database
    - Revisit your SQL Toolbox (and corresponding feedback) from DB Design Assignment 5
    - The report can be presented on the applicaiton landing page in as a menu option to select
    - Examples to jog the imagination:
        - number of pets adopted vs number of pets available for adoption
        - number of orders served vs number of orders open
        - total minutes ran and best time
        - number of / type of open car maintenance requests

## Design / Testing Requirements

- Logical model aligns with final database implementation
- Frontend presents interface considering good UI / UX principles
- Swagger template defined to test a resource & it's endpoints
- Resource at microservice level handles some common errors (ex. record not found, improper user input)
- Jest tests defined to test frontend service responses
- Frontend handles some common errors (ex. bad data type in field, email format incorrect)

## Project Scoring

- Raw Rubic Score: / 15 pts
- Weighted Score: / 100%


