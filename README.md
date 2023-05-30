# UrbondoAnnouncementService

Social network for condominium residents

## Table of Contents

1. [Overview](#description)
2. [Technologies](#tech-stack)
3. [Getting Started](#getting-started)
4. [Building](#build)
5. [REST APIs](#rest-apis)
6. [Announcement](#announcement)
7. [Category](#category)

## Description

A server side project in purpose of exposing APIs that are used to CRUD announcements.

## Tech stack

* Java 17
* Spring Boot
* AWS Dynamo DB
* JUnit5
* Mockito

## Getting Started

Create the particular tables on AWS DynamoDB and make sure to provide your AWS credentials in order to run successfully
the app.

### Build

From the root folder, just execute the following command which will build/run unit and integration tests.

`./gradlew clean build`

### REST APIs

#### Announcement

1. Fetch announcement by id `GET /announcement/{id}`

   Response `200`

    ```json
    {
      "id": "e3b42f92-37ea-4a6c-813c-46155e23197c",
      "title": "Clean the top roof",
      "body": "We need to align to arrange a slot for cleaning the top roof.",
      "categoryId": "c637723f-a816-4644-94fc-8ae232018bfe",
      "categoryTitle": "Building A",
      "userId": "4399f1dc-610f-4a39-bb1d-a0edec19b905"
    }
    ```

   Response `404 NOT FOUND`
   ```json
    {
      "message": "announcement id:{id} is not found"
    }
    ```

2. Add new announcement `POST /announcement`

   Request body
   ```json
    {
      "title": "Electricity maintenance",
      "body": "We need to ABC company urgently this week.",
      "categoryId": "c637723f-a816-4644-94fc-8ae232018bfe",
      "categoryTitle": "Building A",
      "userId": "4399f1dc-610f-4a39-bb1d-a0edec19b905"
    }
    ```
   Response `201`
   ```json
   {
      "id": "e0716138-442d-43a8-a6e1-1e846c678d5a"
   }
   ```
   A bad request gets returned when either one of field gets blank.
   Response `400 BAD REQUEST`
   ```json
   {
     "message": "{validation's message}"
   }
   ```

3. Update an existing announcement `PUT /announcement/{id}`

   Request body
   ```json
    {
      "id": "e0716138-442d-43a8-a6e1-1e846c678d5a",
      "title": "Electricity maintenance",
      "body": "We need to ABC company urgently this week.",
      "categoryId": "c637723f-a816-4644-94fc-8ae232018bfe",
      "categoryTitle": "Building B"
    }
    ```

   Response `200`
    ```json
    {
      "id": "e0716138-442d-43a8-a6e1-1e846c678d5a",
      "title": "Electricity maintenance",
      "body": "We need to ABC company urgently this week.",
      "categoryId": "c637723f-a816-4644-94fc-8ae232018bfe",
      "categoryTitle": "Building B",
      "userId": "4399f1dc-610f-4a39-bb1d-a0edec19b905"
    }
    ```

   Response `404 NOT FOUND`
   ```json
   {
     "message": "announcement id:{id} is not found"
   }
   ```

   A bad request gets returned when either one of field gets blank.
   Response `400 BAD REQUEST`
   ```json
   {
     "message": "{validation's message}"
   }
   ```

4. Delete an existing announcement `DELETE /announcement/{id}`

   Response `204`

   Response `404 NOT FOUND`
   ```json
   {
     "message": "user id:{id} is not found"
   }
   ```