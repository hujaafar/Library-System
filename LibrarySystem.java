import java.util.LinkedList;

/**
 * Represents the Library System with functionalities for managing books and members.
 */
public class LibrarySystem {
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    /** Constructor initializes empty lists and sizes */
    public LibrarySystem() {
        booksList = new LinkedList<>();
        membersList = new LinkedList<>();
        booksListSize = 0;
        membersListSize = 0;
    }

    /** Add a book to the library */
    public boolean addBook(Book book) {
        if (book == null || book.getTitle().isEmpty() || book.getIsbn().length() != 13) {
            System.out.println("Invalid book details. ISBN must be 13 characters, and title must not be empty.");
            return false;
        }
        for (Book b : booksList) {
            if (b.equals(book)) {
                System.out.println("Book already exists in the system.");
                return false; // Book already exists
            }
        }
        booksList.add(book);
        booksListSize++;
        return true;
    }

    /** Delete a book by accession number */
    public boolean deleteBook(long accessionNum) {
        for (Book book : booksList) {
            if (book.getAccessionNum() == accessionNum) {
                if (book.getIssuedTo() != null) {
                    System.out.println("Cannot delete book because it is currently issued to a member.");
                    return false; // Book is issued
                }
                booksList.remove(book);
                booksListSize--;
                return true;
            }
        }
        System.out.println("Book with accession number " + accessionNum + " not found.");
        return false; // Book not found
    }

    /** Add a member to the library */
    public boolean addMember(LibMember member) {
        if (member == null || member.getFirstName().isEmpty() || member.getCprNum() <= 0) {
            System.out.println("Invalid member details. First name must not be empty and CPR number must be valid.");
            return false;
        }
        for (LibMember m : membersList) {
            if (m.equals(member)) {
                System.out.println("Member already exists in the system.");
                return false; // Member already exists
            }
        }
        membersList.add(member);
        membersListSize++;
        return true;
    }

    /** Delete a member by CPR number */
    public boolean deleteMember(long cprNum) {
        for (LibMember member : membersList) {
            if (member.getCprNum() == cprNum) {
                if (member.getNumBooksIssued() > 0) {
                    System.out.println("Cannot delete member because they have issued books.");
                    return false; // Member has issued books
                }
                membersList.remove(member);
                membersListSize--;
                return true;
            }
        }
        System.out.println("Member with CPR number " + cprNum + " not found.");
        return false; // Member not found
    }

    /** Check if books list is empty */
    public boolean isEmptyBooksList() {
        return booksList.isEmpty();
    }

    /** Check if members list is empty */
    public boolean isEmptyMembersList() {
        return membersList.isEmpty();
    }

    /** Get the size of the books list */
    public int sizeBooksList() {
        return booksListSize;
    }

    /** Get the size of the members list */
    public int sizeMembersList() {
        return membersListSize;
    }

    /** Search for a book by accession number */
    public int searchBook(long accessionNum) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getAccessionNum() == accessionNum) return i;
        }
        return -1; // Book not found
    }

    /** Search for a member by CPR number */
    public int searchMember(long cprNum) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getCprNum() == cprNum) return i;
        }
        return -1; // Member not found
    }

    /** Issue a book to a member */
    public boolean issueBook(long accessionNum, long cprNum) {
        int bookIndex = searchBook(accessionNum);
        int memberIndex = searchMember(cprNum);

        if (bookIndex == -1) {
            System.out.println("Book with accession number " + accessionNum + " not found.");
            return false;
        }
        if (memberIndex == -1) {
            System.out.println("Member with CPR number " + cprNum + " not found.");
            return false;
        }
        Book book = booksList.get(bookIndex);
        LibMember member = membersList.get(memberIndex);

        if (book.getIssuedTo() != null) {
            System.out.println("Book is already issued to another member.");
            return false;
        }
        if (member.getNumBooksIssued() >= 10) {
            System.out.println("Member has already issued the maximum number of books.");
            return false;
        }

        member.issueBook(book);
        book.setIssuedTo(member);
        return true;
    }

    /** Return a book to the library */
    public boolean returnBook(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            System.out.println("Book with accession number " + accessionNum + " not found.");
            return false; // Book not found
        }

        Book book = booksList.get(bookIndex);
        LibMember member = book.getIssuedTo();
        if (member == null) {
            System.out.println("Book is not issued to any member.");
            return false; // Book is not issued
        }

        member.returnBook(book);
        book.setIssuedTo(null);
        return true;
    }

    /** Print details of all books issued to a member */
    public void printBooksIssued(long cprNum) {
        int memberIndex = searchMember(cprNum);
        if (memberIndex == -1) {
            System.out.println("Member with CPR number " + cprNum + " not found.");
            return;
        }
        LibMember member = membersList.get(memberIndex);
        System.out.println("Books issued to " + member.getFirstName() + " " + member.getLastName() + ":");
        for (Book book : member.getBooksIssued()) {
            if (book != null) System.out.println(book);
        }
    }

    /** Check if a book is issued */
    public boolean isBookIssued(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            System.out.println("Book with accession number " + accessionNum + " not found.");
            return false; // Book not found
        }
        return booksList.get(bookIndex).getIssuedTo() != null;
    }

    /** Getters for private fields */
    public LinkedList<Book> getBooksList() { return booksList; }
    public LinkedList<LibMember> getMembersList() { return membersList; }
}
