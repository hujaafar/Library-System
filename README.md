# Library Management System

A comprehensive Java-based library management system designed to streamline the management of books and library members. This application supports a wide range of operations, including adding, deleting, and searching for books and members, as well as issuing and returning books.

## Key Features

- **Book Management**: Add, delete, view, and search books by their unique accession number.
- **Member Management**: Add, delete, view, and search library members by their CPR number.
- **Book Issuance**: Issue books to members with validation for limits and availability.
- **Book Returns**: Manage the return of issued books with automated updates to the system.
- **Issued Books Tracking**: View all books issued to a specific member.
- **System Validation**: Includes error handling for invalid inputs and constraints (e.g., ISBN validation, member and book uniqueness).

## Project Architecture

The project follows a modular architecture, ensuring clear separation of concerns:

1. **`Book.java`**: Defines the structure and behavior of a book in the system, including attributes like title, authors, publisher, publication year, ISBN, and accession number.
2. **`LibMember.java`**: Represents a library member with attributes such as name, gender, CPR number, telephone number, and the list of issued books.
3. **`LibrarySystem.java`**: Implements the core system logic, including management of books and members, as well as issuance and return functionalities.
4. **`LibraryMain.java`**: Serves as the entry point, providing a command-line interface for users to interact with the system.

## Technology Stack

- **Programming Language**: Java
- **Java Version**: Compatible with JDK 8 and above
- **Storage**: In-memory storage using `LinkedList`

## Prerequisites

- Java Development Kit (JDK) 8 or higher.
- A terminal or IDE (e.g., IntelliJ IDEA, Eclipse) to compile and run the program.

## Installation & Execution

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
