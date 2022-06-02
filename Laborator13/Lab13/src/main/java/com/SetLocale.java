package com;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
public class SetLocale {

    public void set(Locale locale){
        Locale.setDefault(locale);
    }
}
