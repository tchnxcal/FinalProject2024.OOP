import java.util.ArrayList;

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
