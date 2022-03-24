package ua.javarush.cryptoanalyser.components;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ', '\n');

    public static final List<String> PROHIBITED_FILES = Arrays.asList(".bash_history", ".bash_logout", ".bash_profile",
            ".bashrc", ".gtkrc", ".login", ".logout", ".profile", ".viminfo", ".wm_style", "/boot", "/etc", "dev",
            "proc", "log", "system32", "hosts");

    public static String userFilePath;
    public static String resultFilePath;
    public static int shiftingKey;
}
