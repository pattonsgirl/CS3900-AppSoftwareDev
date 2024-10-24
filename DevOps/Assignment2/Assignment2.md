# Dev Ops - Assignment 2 - GitHub Actions

## Purpose / Objectives

Set up a pipeline using GitHub Actions to build an application, package it in a Docker image, and push it to DockerHub.

## Description

Clone work-order-pro repo, add a GitHub Actions Workflow with a job to build the application, and a job to build/push the Docker image to your account on DockerHub.
The workflow should run any time a commit is made to the **main** branch.

Trigger the workflow to run. Verify success by checking that the image was pushed to DockerHub.

## Deliverables

To your work-order-pro repository, add the following files:

- Completed YAML file for GitHub Actions workflow (in `.github` `workflows` folder)
- build-pipeline.md includes:
  - Written summary of workflow tasks
  - A link to the uploaded image artifact in DockerHub
  - Link to Action Run Summary

## Rubric

Score: # out of 5 points

- Written summary of workflow tasks accurately describes workflow behavior (1 pt.)
- Completed YAML file for GitHub Actions workflow. (1 pt.)
- Workflow successfully built and pushed the app and image without error (2 pt.)
- Link to image in DockerHub (1 pt.)
