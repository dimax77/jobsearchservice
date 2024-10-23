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
- **Exposed**: ORM library used for database interaction (if applicable).
- **Koin**: Dependency injection framework for Kotlin (optional).
- **JWT Authentication**: Secure access using JSON Web Tokens for authentication.

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
