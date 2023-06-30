package ro.qatools;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

public class ATest {


    @Test
    void testSeleniumIUrlAndReleaseCount() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", "aaa");
        jsonObject.put("count", 2);

        System.out.println(jsonObject.toString());

    }

}
