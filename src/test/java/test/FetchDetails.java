package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.response.Response;
import methods.Details;
import methods.GetterSetter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.List;


public class FetchDetails {

    ExtentReports extent;
    public static String reportPath;
    public static String OrganizationName = GetterSetter.getOrganizationName();
    public static String LocationName = GetterSetter.getsetLocationName();

    @BeforeSuite
    public void setUp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportPath = "./Reports/ExtentReport_" + timeStamp + ".html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

     @Test(priority = 1, dataProvider = "LoginCredentials" ,enabled = true)
    public void details(String organizationName, String locationName){
         ExtentTest orgDetails = extent.createTest("Organization Details For: " + organizationName);
         String inputOrg = organizationName;
         OrganizationName=inputOrg.split("\\(")[0].trim();
         String inputLoc = locationName;
         LocationName = inputLoc.split("\\(")[0].trim();
        Response response = Details.fetchDetails(orgDetails);
         extent.flush();

    }
    @Test(priority = 2, dataProvider = "LoginCredentials",enabled = false)
    public void details1(String organizationName, String locationName){
        String inputOrg = organizationName;
        OrganizationName=inputOrg.split("\\(")[0].trim();
        String inputLoc = locationName;
        LocationName = inputLoc.split("\\(")[0].trim();
        Response response = Details.fetchDetails1();
    }

    @DataProvider(name = "LoginCredentials")
    public Object[][] credentialsProvider() {
        List<List<String>> credentials = utilities.Csv_reader.ReadCsvData();
        Object[][] data = new Object[credentials.size()][2];
        for (int i = 0; i < credentials.size(); i++) {
            List<String> credential = credentials.get(i);
            data[i][0] = credential.get(0); // organizationName
            data[i][1] = credential.get(1); // LocationName
        }
        return data;
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
