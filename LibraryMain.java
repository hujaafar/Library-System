import java.util.Scanner;

/**
 * Main class to test the LibrarySystem functionalities.
 */
public class LibraryMain {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem(); // Initialize the library system
        Scanner scanner = new Scanner(System.in);
        int choice = 0; // Initialize choice

        do {
            try {
                System.out.println("\n===== Library System Menu =====");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Add Member");
                System.out.println("4. Delete Member");
                System.out.println("5. Issue Book");
                System.out.println("6. Return Book");
                System.out.println("7. Print Books Issued to Member");
                System.out.println("8. Check if Book is Issued");
                System.out.println("9. Search Book by Accession Number");
                System.out.println("10. Search Member by CPR Number");
                System.out.println("11. Display All Books");
                System.out.println("12. Display All Members");
                System.out.println("13. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine()); // Read and parse user input

                switch (choice) {
                    case 1: // Add Book
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Enter author1: ");
                        String author1 = scanner.nextLine().trim();
                        System.out.print("Enter author2: ");
                        String author2 = scanner.nextLine().trim();
                        System.out.print("Enter publisher: ");
                        String publisher = scanner.nextLine().trim();
                        System.out.print("Enter year of publication: ");
                        int year = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter ISBN (13 digits): ");
                        String isbn = scanner.nextLine().trim();

                        if (isbn.length() != 13) {
                            System.out.println("Error: ISBN must be 13 digits.");
                            break;
                        }

                        Book newBook = new Book(title, author1, author2, publisher, year, isbn);
                        if (library.addBook(newBook)) {
                            System.out.println("Book added successfully.");
                        } else {
                            System.out.println("Failed to add book. Please check the input.");
                        }
                        break;

                    case 2: // Delete Book
                        System.out.print("Enter accession number to delete: ");
                        long accessionNum = Long.parseLong(scanner.nextLine().trim());
                        if (library.deleteBook(accessionNum)) {
                            System.out.println("Book deleted successfully.");
                        } else {
                            System.out.println("Failed to delete book. Check if it is issued or exists.");
                        }
                        break;

                    case 3: // Add Member
                        System.out.print("Enter first name: ");
                        String firstName = scanner.nextLine().trim();
                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine().trim();
                        System.out.print("Enter gender (M/F): ");
                        char gender = scanner.nextLine().trim().charAt(0);
                        System.out.print("Enter CPR number: ");
                        long cprNum = Long.parseLong(scanner.nextLine().trim());
                        System.out.print("Enter telephone number: ");
                        String teleNum = scanner.nextLine().trim();

                        LibMember newMember = new LibMember(firstName, lastName, gender, cprNum, teleNum);
                        if (library.addMember(newMember)) {
                            System.out.println("Member added successfully.");
                        } else {
                            System.out.println("Failed to add member. Please check the input.");
                        }
                        break;

                    case 4: // Delete Member
                        System.out.print("Enter CPR number to delete: ");
                        long memberCPR = Long.parseLong(scanner.nextLine().trim());
                        if (library.deleteMember(memberCPR)) {
                            System.out.println("Member deleted successfully.");
                        } else {
                            System.out.println("Failed to delete member. Ensure they have no issued books.");
                        }
                        break;

                    case 5: // Issue Book
                        System.out.print("Enter accession number: ");
                        long issueBookNum = Long.parseLong(scanner.nextLine().trim());
                        System.out.print("Enter CPR number: ");
                        long issueCPRNum = Long.parseLong(scanner.nextLine().trim());
                        if (library.issueBook(issueBookNum, issueCPRNum)) {
                            System.out.println("Book issued successfully.");
                        } else {
                            System.out.println("Failed to issue book. Check member or book details.");
                        }
                        break;

                    case 6: // Return Book
                        System.out.print("Enter accession number: ");
                        long returnBookNum = Long.parseLong(scanner.nextLine().trim());
                        if (library.returnBook(returnBookNum)) {
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Failed to return book. Check if it is issued.");
                        }
                        break;

                    case 7: // Print Books Issued to Member
                        System.out.print("Enter CPR number: ");
                        long printCPR = Long.parseLong(scanner.nextLine().trim());
                        library.printBooksIssued(printCPR);
                        break;

                    case 8: // Check if Book is Issued
                        System.out.print("Enter accession number: ");
                        long checkIssuedAccNum = Long.parseLong(scanner.nextLine().trim());
                        if (library.isBookIssued(checkIssuedAccNum)) {
                            System.out.println("Book is issued.");
                        } else {
                            System.out.println("Book is not issued.");
                        }
                        break;

                    case 9: // Search Book by Accession Number
                        System.out.print("Enter accession number to search: ");
                        long searchBookAccNum = Long.parseLong(scanner.nextLine().trim());
                        int bookIndex = library.searchBook(searchBookAccNum);
                        if (bookIndex != -1) {
                            System.out.println("Book found: " + library.getBooksList().get(bookIndex));
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 10: // Search Member by CPR Number
                        System.out.print("Enter CPR number to search: ");
                        long searchMemberCPR = Long.parseLong(scanner.nextLine().trim());
                        int memberIndex = library.searchMember(searchMemberCPR);
                        if (memberIndex != -1) {
                            System.out.println("Member found: " + library.getMembersList().get(memberIndex));
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;

                    case 11: // Display All Books
                        System.out.println("Books in the library:");
                        for (Book book : library.getBooksList()) {
                            System.out.println(book);
                        }
                        break;

                    case 12: // Display All Members
                        System.out.println("Members in the library:");
                        for (LibMember member : library.getMembersList()) {
                            System.out.println(member);
                        }
                        break;

                    case 13: // Exit
                        System.out.println("Exiting Library System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid input for character field.");
            } catch (Exception e) {
                System.out.println("Error: Unexpected input. Please try again.");
            }
        } while (choice != 13);

        scanner.close();
    }
}
