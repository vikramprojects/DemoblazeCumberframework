package DbTestrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//Login and product 
@CucumberOptions
	(features="C:\\Users\\vikram\\eclipse-workspace\\demoblazeframework\\src\\test\\java\\features\\Dbloginandproduct.feature",  //the path of the specific feature file
	glue= {"Stepdefination"}, //the path of the step defination file
	plugin= {"pretty","html:Demoblaze-out.html", "json:json_output/Demoblaze.json","junit:junit_xml/Demoblaze.xml"}, //to generate different type of report
	monochrome=true, //display the console output in a readable format 
	dryRun=true, //to check the mapping between feature file and step defination file
	tags="@tag1")


//Signup
/*
 * @CucumberOptions (features=
 * "C:\\Users\\vikram\\eclipse-workspace\\demoblazeframework\\src\\test\\java\\features\\Dbloginandproduct.feature",
 * glue= {"Stepdefination"}, plugin=
 * {"pretty","html:target/HTMLdemoreports.checkbox"}, monochrome=true, //can be
 * change into false dryRun=true, //can be change into false tags="@tag1")
 */




public class Testrunner {

}
