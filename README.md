# Helpdesk System API Documentation

This repository contains the documentation for the API developed using Spring Boot and Spring Security for a Helpdesk system. The API provides endpoints to manage customers, technicals, and tickets.

## Endpoints

### Customers

- `GET /customers`: Retrieves all customers.
- `GET /customers/{id}`: Retrieves a specific customer by ID.
- `POST /customers`: Creates a new customer.
- `PUT /customers/{id}`: Updates an existing customer.
- `DELETE /customers/{id}`: Deletes a customer.

### Technicals

- `GET /technicals`: Retrieves all technicals.
- `GET /technicals/{id}`: Retrieves a specific technical by ID.
- `POST /technicals`: Creates a new technical (only accessible to admins).
- `PUT /technicals/{id}`: Updates an existing technical (only accessible to admins).
- `DELETE /technicals/{id}`: Deletes a technical (only accessible to admins).

### Tickets

- `GET /tickets`: Retrieves all tickets.
- `GET /tickets/{id}`: Retrieves a specific ticket by ID.
- `POST /tickets`: Creates a new ticket.
- `PUT /tickets/{id}`: Updates an existing ticket.

## User Roles

The API supports the following user roles:

- `customer`: All users are initially assigned the role of a customer.
- `technical`: Additional role assigned to technical users.
- `admin`: Additional role assigned to admin users.

## Ticket Status

Tickets can have the following statuses:

- `open`: Ticket is open and pending.
- `progress`: Ticket is in progress.
- `close`: Ticket has been resolved and closed.

## Authentication and Authorization

The API implements authentication and authorization using JWT (JSON Web Tokens). Users need to authenticate using their credentials to access the protected endpoints. Access to certain endpoints is restricted based on user roles:

- Customers can access customer-related endpoints (`/customers`) and ticket-related endpoints (`/tickets`).
- Technicals can access technical-related endpoints (`/technicals`) and ticket-related endpoints (`/tickets`).
- Admins have full access to all endpoints.

## Technologies Used

The API is developed using the following technologies:

- Spring Boot: A Java-based framework for building web applications.
- Spring Security: A framework that provides authentication and authorization capabilities.
- JWT: JSON Web Tokens for secure authentication and authorization.

## How to Run the API

1. Clone this repository.
2. Install the required dependencies specified in the project.
3. Build and run the application.
4. Access the API endpoints using a tool like Postman or a web browser.

Note: Make sure to set up the necessary database and provide the database configuration in the application properties file.
## Frontend Repository
The frontend source code can be found in the following repository: [Frontend Repository](https://github.com/leandro-portugal/helpdesk-web)
## Contributors

This API is developed and maintained by the following contributors:

- [Leandro Portugal](https://github.com/leandro-portugal)

Please feel free to contribute by submitting bug reports, feature requests, or pull requests to this repository.
