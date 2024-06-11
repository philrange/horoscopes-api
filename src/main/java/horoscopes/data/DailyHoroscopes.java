package horoscopes.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DailyHoroscopes {

    Map<String, String> horoscopeTemplates;

    public DailyHoroscopes() {
        loadData();
    }

    private void loadData() {

        Gson gson = new Gson();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/horoscopes/daily_horoscopes.json");

        if (resourceAsStream != null) {
            JsonReader reader = new JsonReader(new InputStreamReader(resourceAsStream));
            Type mapType = new TypeToken<Map<String, String>>(){}.getType();
            horoscopeTemplates = gson.fromJson(reader, mapType);
        } else {
            //todo

            //throw an error?
        }
    }

    public String getHoroscopeTemplateById(Long id) {
        if (horoscopeTemplates.containsKey(String.valueOf(id))) {
            return horoscopeTemplates.get(String.valueOf(id));
        } else {
            //todo - better error handling
            return "farts - horoscope id " + id + " not found";
        }
    }
}
