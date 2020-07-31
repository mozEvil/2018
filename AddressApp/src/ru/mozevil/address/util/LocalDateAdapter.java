package ru.mozevil.address.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by Женя on 09.08.2017.
 */

/**
 * Адаптер (для JAXB) для преобразования между типом LocalDate и строковым представлением даты
 * в стандарте ISO 8601, например как '2012-12-03'.
 *
 * @author Marco Jakob
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

}
