package by.itclass.model.factories;

import by.itclass.model.enums.Section;

import java.util.Locale;

public class SectionFactory {

    public static Section getKindSectionMenu(String section) {
        try {
            return Section.valueOf(section.toUpperCase());
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            return Section.TODAY;
        }

    }

}
