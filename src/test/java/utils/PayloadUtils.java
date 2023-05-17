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
}
