# Microservices - Assignment 6 - Group Project Planning

## Purpose / Objectives

- Make DB updates based on feedback
- Take and apply API design concepts

## Assignment Description

Familiarize yourself with your group project database in cs3900-YOURGROUPNAME repository.

Familiarize yourself with your group project wireframes in cs3900-YOURGROUPNAME repository (pages the user should interact with, planned presentation of information).

Work with your group to make updated designs about your database or wireframes using the feedback in Issues in cs3900-YOURGROUPNAME repository

Each group member needs to **design** not implement a GET, POST, PUT, and DELETE mapping for their group project for an endpoint.  Ideally each group member makes a plan for a unique component to have the API team review your overall plans and understanding of the concepts.  The follow on assignment will focus on coding one endpoint.  The group project assignment will ask for a full implementation attempt.
    - The key elements to focus on for each :
        - what data the user **must provide** to complete the request 
            - pagination (page number, and number of results per page) in the GET request is an assumed feature, you don't need to detail it
        - what data will be returned
        - an outline of the query needed to interact with the database

You will need to document this with two parts
1. a written document named `ENDPOINT-design-LASTNAME.md` where endpoint is your tasked endpoint & last name is your last name that details how your endpoint plans to use GET, POST, PUT and DELETE mappings using key the elements noted above and any useful visualizations you wish to provide.
2. An attempt at making a Swagger API spec YML file for your endpoint named `ENDPOINT-design-LASTNAME.yml`.
    - Use [this as a template](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/WOMS-api-spec-withoutExamples.yaml)
        - Remove references to the WorkOrder Pro app.    

## Deliverable

Make a folder in your group project repository named `API-DESIGNS` (or use exist folder if a team member has already built one)

Add your API design plan for an endpoint to your group project database in cs3900-YOURGROUPNAME repository with two key pieces of documentation:
1. `ENDPOINT-design-LASTNAME.md` with your planned endpoint mappings
2. `ENDPOINT-design-LASTNAME.yml` with an **attempt** at planning your endpoint design in Swagger

In the Pilot Dropbox, link to your submissions of each document.

## Rubric

Microservices Assignment 6 Grading

Score:  / 2 points

1. Thoughtful attempt made at an API design written outline
2. Thoughtful attempt made at describing the plan in a Swagger template file
