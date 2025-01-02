package methods;

public class GetterSetter {
    public static String OrganizationName;
    public static String setLocationName;


    public static String token = "eyJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI2NGNhNWQzNjFmMGRmYjAwMTJjN2I1YmUiLCJlbWFpbCI6ImpheS5wYXRpZGFyQGFkaXQuY29tIiwicm9sZSI6ImRldmVsb3BlciIsImNyZWF0ZWRfZGF0ZSI6IjIwMjMtMDgtMDJUMTM6NDI6MTQuNDAwWiIsInVzZXJTZXNzaW9uSWQiOiIxZDI2NDRjNS1lZjA5LTQzM2MtOTdmYS0wOTViOGVmNjQ1YmIifQ.Zm_g6-txOmq6JjyyTZaO6dfsK_j1eUSVpNudN11MYHY";

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
