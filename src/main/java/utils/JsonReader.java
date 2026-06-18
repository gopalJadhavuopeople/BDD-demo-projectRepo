package utils;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.User;

import java.io.FileReader;

public class JsonReader {
    public static User getUser(String userType) {

        try {

            FileReader reader =
                    new FileReader("src/main/resources/testdata/login.json");

            JsonObject jsonObject =
                    JsonParser.parseReader(reader).getAsJsonObject();

            JsonObject userObject =
                    jsonObject.getAsJsonObject(userType);

            return new Gson().fromJson(userObject, User.class);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }
}
