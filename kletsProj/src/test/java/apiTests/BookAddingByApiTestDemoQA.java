package apiTests;

import demoQAApi.AllBooksDto;
import demoQAApi.ApiHelperDemoQA;
import demoQAApi.BooksDetailsDto;
import demoQAApi.LoginResponseDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;


public class BookAddingByApiTestDemoQA {

    Logger logger = Logger.getLogger(getClass());
    ApiHelperDemoQA apiHelperDemoQA = new ApiHelperDemoQA();
    LoginResponseDto userInfo;


    @Before
    public void precondition() {
        userInfo = apiHelperDemoQA.getUserInfo();
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();
        logger.info("User ID: " + userId);
        logger.info("Token: " + token);

        apiHelperDemoQA.deleteBookByUserId(userId, token);
        logger.info("All user's books are deleted");


        int countOfBooks = apiHelperDemoQA.getUserProfile(userId, token).getBooks().size();
        logger.info(String.format("Count of books: %s", countOfBooks));
        Assert.assertEquals("Count of books is not 0", 0, countOfBooks);
    }

    @Test
    public void addBookToCollectionByApiTest() {

        String isbnBook = apiHelperDemoQA.getAllListOfBooks().getBooks().get(0).getIsbn();
        logger.info("ISBN of the first book from the list: " + isbnBook);

        apiHelperDemoQA.addBookToCollection(userInfo.getUserId(), isbnBook, userInfo.getToken());
        logger.info(String.format("Book with ISBN %s is added to collection", isbnBook));

        Assert.assertEquals("Book is not added to collection", 1, apiHelperDemoQA.getUserProfile(userInfo.getUserId(), userInfo.getToken()).getBooks().size());
        Assert.assertEquals("Isbn of the first book is ", isbnBook, apiHelperDemoQA.getUserProfile(userInfo.getUserId(), userInfo.getToken()).getBooks().get(0).getIsbn());


    }


}
