# Dev Ops - Assignment 2 - GitHub Actions

## Purpose / Objectives

- Setting up a build automation and pipelines using GitHub Actions
- Building and pushing container images to DockerHub

## Description

Create / verify access to an [account on DockerHub](https://hub.docker.com/)

Create a [Personal Access Token with Read & Write as the scope](https://docs.docker.com/security/for-developers/access-tokens/).  Save Token to a trusted file / location.

Create an image repository in DockerHub named `YOURLASTNAME-WOPro-Service`

Create & clone the `devops-assignment-2-YOURUSERNAME` repository (see Pilot for link)

In the repository settings, create a secret in "Secrets and variables" -> Actions -> Repository secret.  Add your PAT for your DockerHub account as a secret.  Note the name assigned to the secret for use in your workflow.

Add a GitHub Actions Workflow to a folder named `.github` in a folder named `workflows`.

The workflow should run any time a commit is pushed to the **main** branch.

The workflow should perform the following `job`s:
- compile the WorkOrder Pro Spring application to a Java JAR
- build the JAR application into a container image
- push the Docker image to your account on DockerHub

Trigger the workflow to run. Verify success by checking that the image was pushed to DockerHub with a timestamp that reflects when the image should have been pushed based on when the GitHub Workflow was triggered.

Edit the file named `build-pipeline.md` to contain:
- A summary of workflow tasks (describe what the workflow does)  You may refer to code snippets, but just the code with no explanation will not get credit.
- Link to your DockerHub repository where your image was pushed to (`YOURLASTNAME-WOPro-Service`)
- Link to the summary / results of your latest Workflow logs.

## Deliverables

To your `devops-assignment-2-YOURUSERNAME` repository, verify the following files exist per assignment taskings:

- Completed YAML file for GitHub Actions workflow (in `.github/workflows` folder)
- `build-pipeline.md` includes:
  - Written summary of workflow tasks
  - Link to the image artifact in DockerHub
  - Link to Workflow Action Run Results Summary

In Pilot, submit the link to your assignment repository to the Dropbox.

## Rubric

Score: # out of 5 points

- Written summary of workflow tasks accurately describes workflow behavior (1 pt.)
- Completed YAML file for GitHub Actions workflow. (1 pt.)
- Link to Workflow Action Run Results Summary validates workflow successfully built and pushed the app and image without error (2 pt.)
- Link to image in DockerHub (1 pt.)
