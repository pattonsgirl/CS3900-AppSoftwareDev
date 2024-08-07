# Dev Ops - Assignment 1 - Containerizing the Development Environment

## Purpose / Objectives

- Check that container engine (Docker) is configured on system
- Basics of Docker commands / control
- Testing connection to containerized environment

## Description

Clone the assignment repository.  The assignment repository will include a script to initialize a database in MariaDB.

1. Build a Dockerfile with the following specifications:
    - MariaDB as a base image (FROM)
    - COPY initialization script
    - RUN script (TODO: check if needed)
2. Build a container image using the Dockerfile
3. Start / run a (detached?) container using the container image
3. Run the following SQL query to validate connection (TODO)

## Deliverable(s)

To your assignment repository, include the following files:

- Dockerfile
- Project files required by Dockerfile
- container-build.md file documenting:
  - Commands used to complete assignment
    - This should be done such that you can reference it throughout the course
  - Screenshot of successful container build process 
  - Screenshot of running container process
  - Screenshot of SQL query validation

## Rubric

Score: # out of 5 points

- Dockerfile that builds a container per specification (1 pt.)
- Documentation states how to build and run the assignment container (1 pt.)
- Screenshot of successful container build process (1 pt.)
- Screenshot of running container process (1 pt.)
- Screenshot of SQL query validation (1 pt.)
