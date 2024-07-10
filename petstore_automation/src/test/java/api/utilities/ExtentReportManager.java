//package api.utilities;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportManager implements ITestListener{
//	public ExtentSparkReporter sparkReporter;
//	public ExtentReports extent;
//	public ExtentTest test;
//	
//	String repName;
//	
//	public void onStart(ITestContext testContext)
//	{		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//		repName="Test-Report-"+timeStamp+".html";
//		
//		File reportDir = new File("G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//reports//");
//		if (!reportDir.exists()) {
//		    reportDir.mkdirs();
//		}
//		String reportPath = reportDir.getAbsolutePath() + "/" + repName;
//		System.out.println("Report Path: " + reportPath);
//		sparkReporter = new ExtentSparkReporter(reportPath);
//				
////		sparkReporter= new ExtentSparkReporter("G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//reports//"+repName);//specify location of the report
////		sparkReporter = new ExtentSparkReporter("G:\\RedDot_Internship\\PetStore_API_RestAssured\\petstore_automation\\reports" + repName);
//				
//		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // Title of report
//		sparkReporter.config().setReportName("Pet Store Users API"); // name of the report
//		sparkReporter.config().setTheme(Theme.DARK);
//				
//		extent=new ExtentReports();
//		extent.attachReporter(sparkReporter);
//		extent.setSystemInfo("Application", "Pest Store Users API");
//		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//		extent.setSystemInfo("User Name", System.getProperty("user.name"));
//		extent.setSystemInfo("Environemnt","QA");
//		extent.setSystemInfo("user","Reyad Hassan");
//	}
//	
//		
//	public void onTestSuccess(ITestResult result)
//	{
//		test=extent.createTest(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.createNode(result.getName());
//		test.log(Status.PASS, "Test Passed");
//	}
//	
//	public void onTestFailure(ITestResult result)
//	{
//		test=extent.createTest(result.getName()); 
//		test.createNode(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.log(Status.FAIL, "Test Failed");
//		test.log(Status.FAIL, result.getThrowable().getMessage());
//	}
//	
//	public void onTestSkipped(ITestResult result)
//	{
//		test=extent.createTest(result.getName()); 
//		test.createNode(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.log(Status.SKIP, "Test Skipped");
//		test.log(Status.SKIP, result.getThrowable().getMessage());
//	}
//	
//	public void onFinish(ITestContext testContext)
//	{
//		extent.flush();
//	}
//	
//	
//	
//	
//
//}



//package api.utilities;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportManager implements ITestListener {
//    public ExtentSparkReporter sparkReporter;
//    public ExtentReports extent;
//    public ExtentTest test;
//
//    String repName;
//
//    public void onStart(ITestContext testContext) {
//        System.out.println("onStart method called");
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
//        repName = "Test Report " + timeStamp + ".html";
//        System.out.println("Report Name: " + repName);
//
//        String reportPath = "G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//reports//" + repName;
//        System.out.println("Report Path: " + reportPath);
//        sparkReporter = new ExtentSparkReporter(reportPath);// specify location of the report
//
//        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // Title of report
//        sparkReporter.config().setReportName("Pet Store Users API"); // name of the report
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Application", "Pest Store Users API");
//        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//        extent.setSystemInfo("User Name", System.getProperty("user.name"));
//        extent.setSystemInfo("Environemnt", "QA");
//        extent.setSystemInfo("user", "Reyad Hassan");
//    }
//
//    public void onTestSuccess(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.createNode(result.getName());
//        test.log(Status.PASS, "Test Passed");
//    }
//
//    public void onTestFailure(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.createNode(result.getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.FAIL, "Test Failed");
//        test.log(Status.FAIL, result.getThrowable().getMessage());
//    }
//
//    public void onTestSkipped(ITestResult result) {
//        test = extent.createTest(result.getName());
//        test.createNode(result.getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.SKIP, "Test Skipped");
//        test.log(Status.SKIP, result.getThrowable().getMessage());
//    }
//
//    public void onFinish(ITestContext testContext) {
//        System.out.println("onFinish method called");
//        extent.flush();
//    }
//}
