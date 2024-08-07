# Dev Ops - Assignment 2 - GitHub Actions and ECS

## Purpose / Objectives

- Familiarity with AWS CloudFormation for configuring ECS (repositories, tasks, clusters, services)
- Setting up a build automation and pipelines using GitHub Actions

## Description

Clone assignment repository with starter application, AWS ECS configuration YAML, and GitHub Action workflow.

Fix the TODOs in the AWS ECS configuration YAML.  TODO: Run the YAML or is this used in the workflow?

Follow [GitHub guide](TODO: link) to setup automated deployments to AWS ECS for the application using a GitHub Action.

In the supplied GitHub Action workflow, add a step for building the container image.
  - Note: workflow is located in `.github/workflows` folder

Trigger the workflow to run.  Verify success by checking that resources were created in AWS as defined by the YAML template.

## Deliverables

To your assignment repository, add the following files:
- Completed YAML file for AWS ECS configuration
- Completed YAML file for GitHub Actions workflow (in `.github` `workflows` folder)
- build-pipeline.md includes:
  - Written summary of workflow tasks
  - Screenshots representing successful resource creation in AWS console.
  - Screenshots showing successful GitHub Action run.

## Rubric

Score: # out of 6 points

- Completed YAML file for AWS configuration (2 pt.)
- Completed YAML file for GitHub Actions workflow. (1 pt.)
- Written summary of workflow tasks accurately describes workflow behavior (1 pt.)
- Screenshots representing successful resource creation in AWS console. (1 pt.)
- Screenshots showing successful GitHub Actions run. (1 pt.)
