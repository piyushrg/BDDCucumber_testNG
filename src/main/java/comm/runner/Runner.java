package comm.runner;

import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"comm/stepDefinations","comm/runner"},
        tags = "@opencart",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Runner  {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setupClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void tearDown(){
        testNGCucumberRunner.finish();
    }

}
