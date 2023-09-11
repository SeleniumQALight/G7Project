package apiTests;

import api.dto.responseDto.HW2.UserBookActions;
import api.dto.responseDto.HW2.UserLoginActions;
import org.junit.Before;
import org.junit.Test;

public class ApiTestHw2 {
    private String token;
    private String userId;

    @Before
    public void ValidLogin() {
        UserLoginActions userLogin = new UserLoginActions("vladqaauto", "Vladqaauto7773$");
        token = userLogin.getToken();
        userId = userLogin.getUserId();
    }

    @Test
    public void testBookstoreActions() {
        UserBookActions userBookActions = new UserBookActions(token, userId);
        String bookISBN = "9781449325862";
        userBookActions.deleteAllBooksForUser();
        userBookActions.getAllBooks();
        userBookActions.addBookToUser(bookISBN);
        userBookActions.verifyUserHasSingleBook(bookISBN);
    }

}
