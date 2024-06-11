package horoscopes.data;

import horoscopes.api.Horoscope;

public record TodaysHoroscope(Horoscope today, Horoscope tomorrow) {
}
