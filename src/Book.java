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

        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
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

    public String toString() {
        return String.format(
                "%-10s : %-20s\n%-10s : %-20s\n%-10s : %8.2f\n%-10s : %-20s\n%-10s : %-20s",
                "Title", title,
                "Author", author,
                "Price", price,
                "Publisher", publisher,
                "ISBN", isbn
        );
    }

    public boolean equals(Object obj) {
        if (this == obj) // Check if the two references point to the same object
            return true;
        if (obj == null || getClass() != obj.getClass()) // Check for null and class type
            return false;

        Book other = (Book) obj; // Cast to Book
        return this.title.equalsIgnoreCase(other.title) &&
                this.author.equalsIgnoreCase(other.author) &&
                this.price == other.price &&
                this.publisher.equalsIgnoreCase(other.publisher) &&
                this.isbn.equals(other.isbn);
    }

    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

