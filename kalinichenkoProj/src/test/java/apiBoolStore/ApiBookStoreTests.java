package apiBoolStore;

import bookStore.AppiHelper;
import org.junit.Test;

public class ApiBookStoreTests {
    AppiHelper apiBookStoreTests = new AppiHelper();

    @Test
    public void getToken() {
      String token = apiBookStoreTests.getToken();
    }
}
