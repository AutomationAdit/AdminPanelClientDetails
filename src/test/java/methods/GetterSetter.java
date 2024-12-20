package methods;

public class GetterSetter {
    public static String OrganizationName;
    public static String setLocationName;


    public static String token = "eyJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI2NGNhNWQzNjFmMGRmYjAwMTJjN2I1YmUiLCJlbWFpbCI6ImpheS5wYXRpZGFyQGFkaXQuY29tIiwicm9sZSI6ImRldmVsb3BlciIsImNyZWF0ZWRfZGF0ZSI6IjIwMjMtMDgtMDJUMTM6NDI6MTQuNDAwWiIsInVzZXJTZXNzaW9uSWQiOiJlZjc5Mzk4ZC1iMmZiLTRjOTQtYWE0My00NGIwODE3Y2VlNmEifQ.oZ6tpEGZtbQkc99e4e_cdqPLUUCZoDPp4UFEUTQcwNg";

    // Organization
    public static String getOrganizationName() {return OrganizationName;}
    public static void setOrganizationName(String OrganizationName) {
        GetterSetter.OrganizationName = OrganizationName;
    }

    // Location
    public static String getsetLocationName() {
        return setLocationName;
    }
    public static void setLocationName(String setLocationName) {
        GetterSetter.setLocationName = setLocationName;
    }

}
