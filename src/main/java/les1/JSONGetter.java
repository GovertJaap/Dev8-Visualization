package les1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * Created by Kraaijeveld on 25-4-2016.
 */
public class JSONGetter
{
    private JSONObject jsonObject = new JSONObject();

    private String readUrl(String urlString) throws Exception
    {
        BufferedReader reader = null;
        try
        {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        }
        finally
        {
            if (reader != null)
                reader.close();
        }
    }

    public JSONObject getJSONArray(String url) throws Exception
    {
        try
        {
            String jsonText = readUrl(url);
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonText);

            System.out.println(jsonObject.get("results"));

        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
