# Final Project Elements Rubric

## Core Requirements (or project final score is a 0)

1. Database builds, runs, and can be connected to
2. Microservice builds, runs, and can respond to resources
3. Frontend builds, runs, and presents a frontend site

## Documentation Requirements

- Project README.md contains (or links to) business case & agile requirements of the project
- Project README.md contains (or links to) documentation on how to build each major project component

## Core Application Capabilities

- Frontend presents all records of some resource using information stored in the database
- Frontend allows user to create a **new** record for some resource and stores the update in the database
- Frontend allows user to update an **existing** record for some resource and stores the update in the database
- Frontend allows user to **filter** records for some resource using information stored in the database

## Design / Testing Requirements

- Logical model aligns with final database implementation
- Wireframe(s) for expected user interaction align with final product or changes remaining are noted in `FutureWork.md`
- Swagger template defined to test a resource & it's endpoints
- Resource at microservice level handles some common errors (ex. record not found, improper user input)
- Jest tests defined to test frontend service responses
- Frontend handles some common errors (ex. bad data type in field, email format incorrect)
