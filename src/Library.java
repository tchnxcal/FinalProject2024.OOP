import java.util.ArrayList;

/**
 * Task #2
 *
 * @author: Nathan Angulo
 */

public class Library {
    // Data members
    private ArrayList<Book> books; // ArrayList of Book objects

    // Default constructor - adds 5 specific books to the library
    public Library() {
        books = new ArrayList<>();
        books.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 9.99, "HarperCollins", "9780064404990"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 14.99, "Scholastic", "9780439023528"));
        books.add(new Book("1984", "George Orwell", 16.99, "Penguin Books", "9780141393049"));
        books.add(new Book("A Game of Thrones", "George R.R. Martin", 17.99, "Bantam Books", "9780553386790"));
        books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 19.99, "William Morrow and Company", "9780547928210"));
    }

    // Constructor with a given ArrayList of books
    public Library(ArrayList<Book> books) {
        this.books = new ArrayList<>(books);
    }

    // Copy constructor - creates a deep copy of another Library
    public Library(Library other) {
        this.books = new ArrayList<>(other.books);
    }

    // Method to search for a book by keyword in the title or author
    public ArrayList<Book> searchBook(String keyword) {
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // equals method to check if two Library instances are the same
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library other = (Library) obj;
        return this.books.equals(other.books);
    }

    // toString method to display the entire contents of the library
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library Contents:\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    // Getter for the ArrayList of books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Setter for the ArrayList of books
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
