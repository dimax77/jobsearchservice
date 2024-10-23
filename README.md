# Job and Resume API

**Job and Resume API** is a Kotlin-based project that utilizes [Ktor](https://ktor.io) for handling HTTP requests and responses. The project provides an API for managing job listings, company information, and user resumes. It allows companies to post job openings and users to create and update their resumes.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Setup and Installation](#setup-and-installation)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Build and Run the Application](#build-and-run-the-application)
  - [Testing the API](#testing-the-api)
- [API Endpoints](#api-endpoints)
  - [Jobs](#jobs)
  - [Companies](#companies)
  - [Resumes](#resumes)
  - [Authentication](#authentication)
- [Usage Examples](#usage-examples)
  - [Create a Job Listing](#create-a-job-listing-post-jobs)
  - [Get a List of Jobs](#get-a-list-of-jobs-get-jobs)
  - [Register a New User](#register-a-new-user-post-authregister)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Job Listings**: Companies can create, update, and delete job listings.
- **Resume Management**: Users can create, edit, and view their resumes.
- **Company Profiles**: Companies can manage their profiles and post new job vacancies.
- **User Profiles**: Users can create and manage their profiles, including uploading resumes and applying for jobs.
- **RESTful API**: Simple and intuitive API for interaction with the job database and user resumes.

## Technologies

- **Kotlin**: Primary language for developing the application.
- **Ktor**: Framework for building the backend server and handling HTTP requests.
- **Database**: Integration with a database for storing job listings, company information, and user resumes (can be PostgreSQL, MySQL, or any other supported database).


## Setup and Installation

### Prerequisites

- **JDK 11+**: You need to have Java Development Kit (JDK) 11 or higher installed.
- **Gradle**: The project uses Gradle as its build tool.
- **Database**: Set up a database (e.g., PostgreSQL or MySQL) and configure connection settings in the project.

### Clone the Repository

1. Clone the repository:

   ```bash
   git clone git@github.com:dimax77/jobsearchservice.git
   cd jobsearchservice

### Build and Run the Application:

1. Build the project using Gradle:
   
   ```bash
   ./gradlew build

2. Run the application:

   ``` bash
   ./gradlew  :server:run

### Testing the API

Once the server is running, you can test the API using tools like Postman or cURL.

## API Endpoints

### Jobs

- **GET** `/jobs`: Get a list of all job listings.
- **GET** `/jobs/{id}`: Get a specific job listing by ID.
- **POST** `/jobs`: Create a new job listing.
- **PUT** `/jobs/{id}`: Update a job listing by ID.
- **DELETE** `/jobs/{id}`: Delete a job listing by ID.

### Companies Endpoints

- **GET** `/companies`: Get a list of all companies.
- **GET** `/companies/{id}`: Get company information by ID.
- **POST** `/companies`: Create a new company profile.
- **PUT** `/companies/{id}`: Update company information.
- **DELETE** `/companies/{id}`: Delete a company profile.

### Resumes Endpoints

- **GET** `/resumes`: Get a list of all resumes.
- **GET** `/resumes/{id}`: Get a specific resume by ID.
- **POST** `/resumes`: Create a new resume.
- **PUT** `/resumes/{id}`: Update an existing resume.
- **DELETE** `/resumes/{id}`: Delete a resume by ID.

### Authentication Endpoints

- **POST** `/auth/login`: Authenticate users and generate JWT tokens.
- **POST** `/auth/register`: Register a new user account.

## Usage Examples

### Create a Job Listing (POST /jobs)

```bash
  curl -X POST http://localhost:8080/jobs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Software Engineer",
    "description": "Develop and maintain software applications",
    "companyId": 1,
    "location": "Remote",
    "salary": "80,000 - 100,000 USD"
  }'

```
### Get a List of Jobs (GET /jobs)

```bash
curl -X GET http://localhost:8080/jobs

```
### Register a New User (POST /auth/register)

```bash
curl -X POST http://localhost:8080/auth/register \
-H "Content-Type: application/json" \
-d '{
  "email": "user@example.com",
  "password": "securepassword"
}'
```

## Contributing

Contributions are welcome! To contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
3. Make your changes and commit them:
  ```bash
  git commit -m 'Add new feature'
```
4 Push to the branch:
  ```bash
  git push origin feature-branch
```
5. Open a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
