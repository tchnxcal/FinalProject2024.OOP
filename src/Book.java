public class Book {
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

