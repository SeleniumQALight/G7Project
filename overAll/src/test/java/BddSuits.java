import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                RunCucumberTest1.class,
                RunCucumberTest.class
        }
)
public class BddSuits {
}
