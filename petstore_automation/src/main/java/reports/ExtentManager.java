package reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentSparkReporter htmlReporter;
	  public static ExtentReports extent;
	  public static ExtentTest test;

	  public static void setExtent() throws IOException {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		  String path = "G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//test-output//ExtentReport//"
				  + timeStamp
		            + "TestExecutionReport"
		            + ".html";
	    htmlReporter = new ExtentSparkReporter(
	        path);
	    htmlReporter.loadXMLConfig("G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//src//main//resources//extent-config.xml");

	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    htmlReporter.config().setDocumentTitle("Simple Automation Report");
	    htmlReporter.config().setReportName("Test Report");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environemnt","QA");
	    extent.setSystemInfo("user","Reyad Hassan");
		
	  }

	  public static void endReport() {
	    extent.flush();
	  }

}
