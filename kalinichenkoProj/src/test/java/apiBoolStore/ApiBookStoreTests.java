package apiBoolStore;

import bookStore.AppiHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

public class ApiBookStoreTests {
    Logger logger = Logger.getLogger(getClass());
    AppiHelper apiBookStoreTests = new AppiHelper();

    String userId = apiBookStoreTests.getUser().getUserId();
    String token = apiBookStoreTests.getUser().getToken();

    @Before
    public void beforeTest() {

        apiBookStoreTests.deleteAllBooks(token, userId);
        logger.info("all books from user collection was delete");

        int booksInUserCollection = apiBookStoreTests.getBooksInUserCollection(token, userId).getBooks().size();
        logger.info("books in user collection = " + booksInUserCollection);
        Assert.assertEquals("Books in user collection is not 0 ", 0, booksInUserCollection);
    }

    @Test
    public void addBookToUserCollection() {
        String isbn = apiBookStoreTests.getAllBooksList().getBooks().get(0).getIsbn();
        logger.info("isbn of the first book = " + isbn);

        apiBookStoreTests.addBookToUserCollection(userId, token, isbn);
        logger.info(String.format("book %s was added to user collection" , isbn));
        int booksInUserCollection = apiBookStoreTests.getBooksInUserCollection(token, userId).getBooks().size();

        Assert.assertEquals("Books in user collection is not 1 ", 1, booksInUserCollection);
        Assert.assertEquals("Isbn of the first book in user collection is not " + isbn, isbn, apiBookStoreTests.getAllBooksList().getBooks().get(0).getIsbn());

    }

    @After
    public void afterTest() {
        apiBookStoreTests.deleteAllBooks(token, userId);
        logger.info("all books from user collection was delete");
    }
}
