/**
 * Task #1
 *
 * @author: Nathan Angulo
 */

public class Book implements Cloneable {
    // Data members
    private String title;      // Book title, must be in title case
    private String author;     // Author's name
    private double price;      // Price of the book
    private String publisher;  // Publisher's name
    private String isbn;       // ISBN, should be 13 or 17 characters long

    // Default constructor
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown";
        this.price = 0.0;
        this.publisher = "Unpublished";
        this.isbn = "000-0-00-000000-0"; // Example of a default invalid ISBN
    }

    // Constructor with only title
    public Book(String title) {
        this.title = toTitleCase(title);
        this.author = "Unknown";
        this.price = 0.0;
        this.publisher = "Unpublished";
        this.isbn = "000-0-00-000000-0";
    }

    // Constructor with all data members
    public Book(String title, String author, double price, String publisher, String isbn) {
        this.title = toTitleCase(title);
        this.author = toTitleCase(author);
        this.price = price;
        this.publisher = toTitleCase(publisher);
        this.isbn = isbn;
    }

    // Copy constructor
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.publisher = other.publisher;
        this.isbn = other.isbn;
    }

    // Helper method to convert a string to title case
    private String toTitleCase(String input) {
        if (input == null || input.isEmpty()) return input;

        String[] words = input.split(" ");
        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Only capitalize the first character, leave the rest as-is
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1));
                titleCase.append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    // Method to check ISBN status
    public int checkIsbnStatus() {
        if (isbn == null || isbn.isEmpty()) {
            return -1; // Invalid ISBN
        }

        int length = isbn.replace("-", "").length();

        if (length == 10) {
            return 0; // ISBN10
        } else if (length == 13) {
            return 1; // ISBN13
        } else {
            return -1; // Invalid ISBN
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s : %-25s\n%-10s : %-25s\n%-10s : $%s\n%-10s : %-25s\n%-10s : %-25s",
                "Title", title,
                "Author", author,
                "Price", String.format("%.2f", price), // No extra spaces added
                "Publisher", publisher,
                "ISBN", isbn
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same instance
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null or different class
        Book other = (Book) obj;
        return this.title.equalsIgnoreCase(other.title) &&
                this.author.equalsIgnoreCase(other.author) &&
                this.price == other.price &&
                this.publisher.equalsIgnoreCase(other.publisher) &&
                this.isbn.equals(other.isbn);
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Getter and Setter Methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = toTitleCase(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = toTitleCase(author);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = toTitleCase(publisher);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}


