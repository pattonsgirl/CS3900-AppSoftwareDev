# Dev Ops - Assignment 1 - Container Intro

## Purpose / Objectives

- Check that containerization environment is configured on system
- Basics of Docker commands / control
- Working within container environments*

## Description

Clone the assignment repository.  

The overall goal is to, in a container, run MariaDB, initialize your database using a pre-set script & make a query to validate that it is operational.

1. Build your Dockerfile:
    - MariaDB as a base image (FROM)
    - COPY initialization script
    - RUN script (TODO: check if needed)
2. Build an image / start a container using the Dockerfile (run)
3. Run the following SQL query to validate connection (TODO)

## Deliverable(s)

- Dockerfile added to assignment repo
- README file includes:
  - Commands used to complete assignment
  - Screenshot of successful container build process 
  - Screenshot of running container process
  - Screenshot of SQL query validation

# Rubric

- Dockerfile that builds a container per specification (1 pt)
- Documentation states how to build and run the assignment container (1 pt)
- Screenshot of successful container build process (1 pt)
- Screenshot of running container process (1 pt)
- Screenshot of SQL query validation (1 pt)
