package horoscopes.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import horoscopes.api.Horoscope;
import horoscopes.data.DailyHoroscopes;
import horoscopes.data.Starsign;
import horoscopes.data.TodaysHoroscope;
import horoscopes.data.TodaysHoroscopeId;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class DailyHoroscopeUtil {

    private final long totalNumberOfHoroscopes = 24;

    private final DailyHoroscopes dailyHoroscopes = new DailyHoroscopes();

    public Map<Starsign, TodaysHoroscope> getTodaysHoroscopes() {

        final Map<Starsign, TodaysHoroscope> todaysHoroscopes = new HashMap<>();

        for (Starsign starsign : Starsign.values()) {

            TodaysHoroscopeId todaysHoroscopeId = getTodaysHoroscopeId(starsign);
            Horoscope todaysHoroscope = getHoroscope(todaysHoroscopeId.today(), starsign);
            Horoscope tomorrowsHoroscope = getHoroscope(todaysHoroscopeId.tomorrow(), starsign);
            todaysHoroscopes.put(starsign, new TodaysHoroscope(todaysHoroscope, tomorrowsHoroscope));
        }

        return todaysHoroscopes;
    }

    private Horoscope getHoroscope(Long id, Starsign starsign) {

        //todo - lookup id in db
        final String horoscopeTemplate = dailyHoroscopes.getHoroscopeTemplateById(id);
        //todo - replace placeholder with starsign name
        String horoscope = horoscopeTemplate.replaceAll("\\{starsign}", starsign.name());

        return new Horoscope(id, starsign, horoscope);
    }

    private TodaysHoroscopeId getTodaysHoroscopeId(Starsign sign) {

        LocalDate today = LocalDate.now();
        long numberOfDaysSinceEpoch = ChronoUnit.DAYS.between(LocalDate.MIN, today);

        long dayOffset = numberOfDaysSinceEpoch % totalNumberOfHoroscopes;
//        let gap = (totalNumberOfHoroscopes - 24)/2;

        long todaysId = (sign.ordinal() + dayOffset) % totalNumberOfHoroscopes;
        // need to make sure tomorrows will be set as "today" the following day, so just adding 1
        // this does mean the tomorrow horoscope will be the same as today for another starsign
        long tomorrow = (todaysId + 1) % totalNumberOfHoroscopes;

        return new TodaysHoroscopeId(todaysId, tomorrow);
    }
}
