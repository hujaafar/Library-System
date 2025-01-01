/**
 * Represents a Library Member in the Library System.
 */
public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued;
    private int numBooksIssued;

    /** Default constructor */
    public LibMember() {
        this.firstName = "";
        this.lastName = "";
        this.gender = 'U';
        this.cprNum = 0;
        this.teleNum = "";
        this.booksIssued = new Book[10];
        this.numBooksIssued = 0;
    }

    /** Constructor with parameters */
    public LibMember(String firstName, String lastName, char gender, long cprNum, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cprNum;
        this.teleNum = teleNum;
        this.booksIssued = new Book[10];
        this.numBooksIssued = 0;
    }

    /** Getters and Setters */
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public long getCprNum() { return cprNum; }
    public void setCprNum(long cprNum) { this.cprNum = cprNum; }
    public String getTeleNum() { return teleNum; }
    public void setTeleNum(String teleNum) { this.teleNum = teleNum; }
    public Book[] getBooksIssued() { return booksIssued; }
    public int getNumBooksIssued() { return numBooksIssued; }

    /** Issue a book to the member */
    public boolean issueBook(Book book) {
        if (numBooksIssued < 10) {
            booksIssued[numBooksIssued++] = book;
            return true;
        }
        return false;
    }

    /** Return a book */
    public boolean returnBook(Book book) {
        for (int i = 0; i < numBooksIssued; i++) {
            if (booksIssued[i].equals(book)) {
                booksIssued[i] = booksIssued[--numBooksIssued];
                booksIssued[numBooksIssued] = null;
                return true;
            }
        }
        return false;
    }

    /** Override equals to compare members by CPR number */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibMember member = (LibMember) obj;
        return cprNum == member.cprNum;
    }

    /** Override toString to display member details */
    @Override
    public String toString() {
        return "LibMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", cprNum=" + cprNum +
                ", teleNum='" + teleNum + '\'' +
                ", numBooksIssued=" + numBooksIssued +
                '}';
    }
}
