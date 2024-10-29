# Dev Ops - Assignment 2 - GitHub Actions

## Purpose / Objectives

- Setting up a build automation and pipelines using GitHub Actions
- Building and pushing container images to DockerHub

## Description

Create / verify access to an [account on DockerHub](https://hub.docker.com/)

Create a [Personal Access Token with Read & Write as the scope](https://docs.docker.com/security/for-developers/access-tokens/).  Save Token to a trusted file / location.

Clone work-order-pro repo, add a GitHub Actions Workflow with a job to build the application, and a job to build/push the Docker image to your account on DockerHub.

The workflow should run any time a commit is pushed to the **main** branch.

Trigger the workflow to run. Verify success by checking that the image was pushed to DockerHub with a timestamp that reflects when the image should have been pushed based on when the GitHub Workflow was triggered.

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
