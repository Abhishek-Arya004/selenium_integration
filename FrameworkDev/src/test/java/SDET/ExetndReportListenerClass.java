package SDET;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExetndReportListenerClass implements ITestListener {

	public ExtentSparkReporter sparkreporter; // Report , UI or location, theme

	public ExtentReports extent; // for common info

	public ExtentTest test;// creating a test entry in report and update the report

	public void onStart(ITestContext context) {
		// not implemented

		sparkreporter = new ExtentSparkReporter("myreport.html");// location

		sparkreporter.config().setDocumentTitle("Automation Test Report");// title of report
		sparkreporter.config().setReportName("Regression Testing");// Name of Report
		sparkreporter.config().setTheme(Theme.DARK);// theme of report

		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);

		extent.setSystemInfo("Computername", "Local server");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");

	}

	public void onTestStart(ITestResult result) {
		// not implemented

	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is  " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		// not implemented

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is  " + result.getName());
		test.log(Status.FAIL, "Test case Failed is  " + result.getThrowable());
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Pictures\\133604949049551202.jpg").build());
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIP is  " + result.getName());

	}

	public void onFinish(ITestContext context) {
		// not implemented

		extent.flush();
	}

}
