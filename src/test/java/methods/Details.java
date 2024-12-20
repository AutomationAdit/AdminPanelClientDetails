package methods;

import api.admin;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.Csv_Write;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static test.FetchDetails.LocationName;
import static test.FetchDetails.OrganizationName;


public class Details {

    public static String OrganizationID;
    public static String OrgName;
    public static String LocName;
    public static String LocationID;
    public static List<Map<String, Object>> clientDataList = new ArrayList<>();
    public static String CSV_FILE_PATH = "C:\\Users\\adit\\Desktop\\OutputSheet.csv";

    public static Response fetchDetails(ExtentTest test)
    {
        Response response = given()
                .header("x-access-adit-admin", GetterSetter.token)
                .header("Referer", "https://admin.adit.com/clients/locations")
                .header("Accept", "application/json, text/plain, */*")
                .when().get(admin.details);

        String strResponse = response.then().extract().response().asString();
        JSONObject jsonObject = new JSONObject(strResponse);
        JSONArray jsonarry = jsonObject.getJSONArray("data");

        for (int i = 0; i < jsonarry.length(); i++) {

            JSONObject jsonObject1 = jsonarry.getJSONObject(i);
            LocName = jsonObject1.getString("name");


            OrganizationID = jsonObject1.get("organization").toString();
            JSONObject jsonObject2 = jsonObject1.getJSONObject("loc_organization");
            OrgName = jsonObject2.getString("name");
            JSONArray jsonArray = jsonObject2.getJSONArray("location");
            for (int j = 0; j < 1; j++) {
                LocationID = jsonArray.getString(j);
                if (OrganizationName.equals(OrgName) || LocationName.equals(LocName)) {
                    ExtentTest orgDetails = test.createNode("Organization Details: " + OrgName);
                    System.out.println("OrganizationID: " + OrganizationID);
                    System.out.println("OrganizationName: " + OrgName);
                    System.out.println("LocationName: " + LocName);
                    System.out.println("LocationID: " + LocationID);
                    orgDetails.info("OrganizationID: " + OrganizationID);
                    orgDetails.info("OrganizationName: " + OrgName);
                    orgDetails.info("LocationName: " + LocName);
                    orgDetails.info("LocationID: " + LocationID);


                    Map<String, Object> clientData = new HashMap<>();

                    clientData.put("OrganizationID", OrganizationID);
                    clientData.put("OrganizationName", OrgName);
                    clientData.put("LocationName", LocName);
                    clientData.put("LocationID", LocationID);

                    clientDataList.add(clientData);
                }
            }
        }
            Csv_Write.writeToCSV(clientDataList, CSV_FILE_PATH);
        return response;
    }

    public static Response fetchDetails1() {
            Response responseT = given()
                    .header("x-access-adit-admin", GetterSetter.token)
                    .header("Referer", "https://admin.adit.com/clients/locations")
                    .header("Accept", "application/json, text/plain, */*")
                    .when().get(admin.details1);

            String strResponseT = responseT.then().extract().response().asString();
            JSONObject jsonObjectT = new JSONObject(strResponseT);
            JSONArray jsonarryT = jsonObjectT.getJSONArray("data");

            for (int k = 0; k < jsonarryT.length(); k++) {

                JSONObject jsonObjectT1 = jsonarryT.getJSONObject(k);
                LocName = jsonObjectT1.getString("name");

                OrganizationID = jsonObjectT1.get("organization").toString();
                JSONObject jsonObjectT2 = jsonObjectT1.getJSONObject("loc_organization");
                OrgName = jsonObjectT2.getString("name");
                if (OrganizationName.equals(OrgName)) {
                    JSONArray jsonArrayT = jsonObjectT2.getJSONArray("location");
                    for (int l = 0; l < jsonArrayT.length(); l++) {
                        LocationID = jsonArrayT.getString(l);
                        if (OrganizationName.equals(OrgName) || LocationName.equals(LocName)) {
                            System.out.println("Organization Name: " + OrganizationID);
                            System.out.println("OrganizationID: " + OrgName);
                            System.out.println("LocationName: " + LocName);
                            System.out.println("LocationID: " + LocationID);
                        }
                    }
                }
            }

        return responseT;
    }
}
