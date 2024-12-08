import java.util.ArrayList;

public class LibraryTest {
    public static void main(String[] args) {
        // Test 1: Create a library using the default constructor
        Library library = new Library();
        System.out.println("Test 1: Library Contents using Default Constructor");
        System.out.println(library);

        // Test 2: Search for a book by keyword
        System.out.println("\nTest 2: Search for 'George'");
        ArrayList<Book> searchResults = library.searchBook("George");
        if (searchResults.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }

        // Test 3: Create a custom library with a custom book list
        System.out.println("\nTest 3: Create a new Library with a custom ArrayList");
        ArrayList<Book> customBooks = new ArrayList<>();
        customBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 12.99, "HarperCollins", "9780547928227"));
        customBooks.add(new Book("To Kill a Mockingbird", "Harper Lee", 10.99, "J.B. Lippincott & Co.", "9780061120084"));
        Library customLibrary = new Library(customBooks);
        System.out.println(customLibrary);

        // Test 4: Use the copy constructor
        System.out.println("\nTest 4: Test the copy constructor");
        Library copiedLibrary = new Library(library);
        System.out.println("Copied Library Contents:");
        System.out.println(copiedLibrary);

        // Test 5: Compare libraries using the equals method
        System.out.println("\nTest 5: Compare Original Library with Copied Library using equals");
        if (library.equals(copiedLibrary)) {
            System.out.println("The libraries are identical.");
        } else {
            System.out.println("The libraries are different.");
        }

        // Test 6: Test ISBN status check
        System.out.println("\nTest 6: Check ISBN Status for a few books");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle() + ": ISBN Status = " + book.checkIsbnStatus());
        }
    }
}

