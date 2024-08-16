package org.sfa.request.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterUtil {

    public static String formatDate(ZonedDateTime dateTime, Locale locale) {
        String pattern = getDatePattern(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return dateTime != null ? dateTime.format(formatter) : null;
    }

    private static String getDatePattern(Locale locale) {
        String language = locale.getLanguage();

        switch (language) {
            case "en":
                return "MM/dd/yyyy hh:mm:ss a"; // English (US)
            case "zh":
                return "yyyy年MM月dd日 HH:mm:ss"; // Mandarin (China)
            case "hi":
                return "dd-MM-yyyy HH:mm:ss"; // Hindi (India)
            case "es":
                return "dd/MM/yyyy HH:mm:ss"; // Spanish (Spain)
            case "fr":
                return "dd/MM/yyyy HH:mm:ss"; // French (France)
            case "de":
                return "dd.MM.yyyy HH:mm:ss"; // German (Germany)
            case "ja":
                return "yyyy年MM月dd日 HH:mm:ss"; // Japanese (Japan)
            case "te":
                return "dd-MM-yyyy HH:mm:ss"; // Telugu (India)
            default:
                return "MM/dd/yyyy hh:mm:ss a"; // Default
        }
    }
}
