package ua.javarush.cryptoanalyser;

import ua.javarush.cryptoanalyser.components.Encoding;
import ua.javarush.cryptoanalyser.components.Interface;

public class Main {
    public static void main(String[] args) {
        switch (Interface.CONSOLE_INTERFACE.selectOperationType()) {
            case ENCODE:
                Interface.CONSOLE_INTERFACE.selectUserFilePath();
                Interface.CONSOLE_INTERFACE.selectResultFilePath();
                Interface.CONSOLE_INTERFACE.selectShiftingKey("Введите ключ для для смещения:");
                Encoding.encode();
                break;
            case DECODE:
                Interface.CONSOLE_INTERFACE.selectUserFilePath();
                Interface.CONSOLE_INTERFACE.selectResultFilePath();
                Interface.CONSOLE_INTERFACE.selectShiftingKey("Введите ключ для для смещения:");
                Encoding.decode();
                break;
            case BRUTEFORCE:
                Interface.CONSOLE_INTERFACE.selectUserFilePath();
                Interface.CONSOLE_INTERFACE.selectResultFilePath();
                Interface.CONSOLE_INTERFACE.showBruteforceVariants();
                Interface.CONSOLE_INTERFACE.selectShiftingKey("Введите ключ который подходит для расшифровки");
                Encoding.decode();
        }
        System.out.println("Спасибо за использование программы");
    }
}
