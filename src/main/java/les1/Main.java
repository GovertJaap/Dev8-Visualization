package les1;

import org.json.simple.JSONObject;
import processing.core.PApplet;

public class Main extends PApplet
{
    private static JSONObject earthQuakeJsonObject = new JSONObject();


    public void settings()
    {

    }

    public void setup()
    {

    }

    public void draw()
    {
    }

    public static void main(String[] args) {
        JSONGetter jsonGetter = new JSONGetter();

        try
        {
            Main.earthQuakeJsonObject = jsonGetter.getJSONArray("http://apis.is/earthquake/is");
            PApplet.main(new String[] { Main.class.getName() });
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
