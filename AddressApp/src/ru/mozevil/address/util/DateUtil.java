package ru.mozevil.address.util;

/**
 * Created by Женя on 07.08.2017.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Вспомогательные функции для работы с датами.
 *
 * @author Marco Jakob
 */
public class DateUtil {

    /** Шаблон даты, используемый для преобразования.*/
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** Форматировщик даты. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Возвращает полученную дату в виде отформатированной строки.
     * Используется определенный выше {@link DateUtil#DATE_PATTERN}.
     *
     * @param date дата, которая будет возвращена в виде строки
     * @return отформатированную строку
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Преобразует строку, которая отформатированна по правилам
     * шаблона {@link DateUtil#DATE_PATTERN} в объект {@link LocalDate}.
     *
     * Возвращает null, если строка не может быть преобразована.
     *
     * @param dateString дата в виде String
     * @return объект даты или null, если строка не может быть преобразована
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Проверяет, является ли строка корректной датой.
     *
     * @param dateString
     * @return true, если строка является корректной датой
     */
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }

}
