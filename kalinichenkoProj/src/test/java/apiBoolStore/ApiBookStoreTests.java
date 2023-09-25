package apiBoolStore;

import bookStore.AppiHelper;
import bookStore.respossDto.ApiLoginResponseDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

public class ApiBookStoreTests {
    Logger logger = Logger.getLogger(getClass());
    AppiHelper apiBookStoreTests = new AppiHelper();
    ApiLoginResponseDto User = apiBookStoreTests.getUser();

    @Before
    public void beforeTest() {

        apiBookStoreTests.deleteAllBooks(User.getToken(), User.getUserId());
        logger.info("all books from user collection was delete");

    }

    @Test
    public void addBookToUserCollection() {
        String isbn = apiBookStoreTests.getAllBooksList().getBooks().get(0).getIsbn();
        logger.info("isbn of the first book = " + isbn);

        apiBookStoreTests.addBookToUserCollection(User.getUserId(), User.getToken(), isbn);
        logger.info(String.format("book %s was added to user collection" , isbn));
        int booksInUserCollection = apiBookStoreTests.getBooksInUserCollection(User.getToken(), User.getUserId()).getBooks().size();

        Assert.assertEquals("Books in user collection is not 1 ", 1, booksInUserCollection);
        Assert.assertEquals("Isbn of the first book in user collection is not " + isbn, isbn, apiBookStoreTests.getAllBooksList().getBooks().get(0).getIsbn());

    }

    @After
    public void afterTest() {
        apiBookStoreTests.deleteAllBooks(User.getToken(), User.getUserId());}
}
