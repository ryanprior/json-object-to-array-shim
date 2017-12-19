package com.ryanprior.json_shim;
import com.eclipsesource.json.*;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        InputStreamReader cin = new InputStreamReader(System.in);
        try {
            // get JSON object from stdin
            JsonObject inJSON = Json.parse(cin).asObject();

            // transform object to list
            JsonArray outJSON = new JsonArray();
            for(JsonObject.Member member : inJSON) {
                String name = member.getName();
                JsonValue value = member.getValue();
                JsonObject newObject  = new JsonObject();
                newObject.add("name", name);
                newObject.add("value", value);
                outJSON.add(newObject);
            }

            // write  JSON object to stdout
            OutputStreamWriter out = new OutputStreamWriter(System.out);
            outJSON.writeTo(out, WriterConfig.PRETTY_PRINT);
            out.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
