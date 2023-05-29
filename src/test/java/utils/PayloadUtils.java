package utils;

public class PayloadUtils {

    public static String getPetPayload(int petId, String petName, String petStatus) {
        String payload ="";
        return payload;
    }

    public static String getSlackMessagePayload(String msgText) {
        String msgPayload = "{\n" +
                "  \"channel\": \"C052ZQBE39D\",\n" +
                "  \"text\": \"" + msgText + "\"\n" +
                "}";

        return msgPayload;
    }
    public static String getRecordPayload(String petName, String gender, String postCode){
        String recordPayload = "{\n" +
                "  \"id\": 777,\n" +
                "  \"name\": \"Barney\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"birthDate\": \"2019-12-25\",\n" +
                "  \"address\": \"1111 east 11st avenue\",\n" +
                "  \"city\": \"Tampa\",\n" +
                "  \"state\": \"FL\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"phone\": \"111-111-1111\",\n" +
                "  \"email\": \"barney@gmail.com\",\n" +
                "  \"postcode\": \"11111\",\n" +
                "  \"height\": 1,\n" +
                "  \"weight\": 1,\n" +
                "  \"bmi\": 1\n" +
                "}";
        return recordPayload;
    }
    public static String getProductPayload(){
        String productPayload = "{\n" +
                "  \"id\": 69,\n" +
                "  \"name\": \"Amlodipine\",\n" +
                "  \"description\": \"drug\",\n" +
                "  \"image\": \"string\",\n" +
                "  \"price\": 14,\n" +
                "  \"inStock\": true,\n" +
                "  \"category\": {\n" +
                "    \"id\": 12,\n" +
                "    \"name\": \"Vitaliy\",\n" +
                "    \"active\": false\n" +
                "  }\n" +
                "}";
        return productPayload;

    }
}
