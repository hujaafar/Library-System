/**
 * Represents a Book in the Library System.
 */
public class Book {
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;

    private static long nextAccessionNum = 1001;

    /** Default constructor */
    public Book() {
        this.title = "";
        this.author1 = "";
        this.author2 = "";
        this.publisher = "";
        this.yearPublication = 0;
        this.isbn = "";
        this.accessionNum = nextAccessionNum++;
        this.issuedTo = null;
    }

    /** Constructor with parameters */
    public Book(String title, String author1, String author2, String publisher, int yearPublication, String isbn) {
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.isbn = isbn;
        this.accessionNum = nextAccessionNum++;
        this.issuedTo = null;
    }

    /** Getters and Setters */
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor1() { return author1; }
    public void setAuthor1(String author1) { this.author1 = author1; }
    public String getAuthor2() { return author2; }
    public void setAuthor2(String author2) { this.author2 = author2; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getYearPublication() { return yearPublication; }
    public void setYearPublication(int yearPublication) { this.yearPublication = yearPublication; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public long getAccessionNum() { return accessionNum; }
    public LibMember getIssuedTo() { return issuedTo; }
    public void setIssuedTo(LibMember issuedTo) { this.issuedTo = issuedTo; }

    /** Override equals to compare books by ISBN */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    /** Override toString to display book details */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author1='" + author1 + '\'' +
                ", author2='" + author2 + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublication=" + yearPublication +
                ", isbn='" + isbn + '\'' +
                ", accessionNum=" + accessionNum +
                ", issuedTo=" + (issuedTo != null ? issuedTo.getFirstName() : "None") +
                '}';
    }
}
