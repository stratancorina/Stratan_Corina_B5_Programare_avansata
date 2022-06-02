package com;

import java.util.Locale;

public class DisplayLocales {

    public void display() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales)
            System.out.println(locale.toString());
    }

}