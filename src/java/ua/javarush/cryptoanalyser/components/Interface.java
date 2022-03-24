package ua.javarush.cryptoanalyser.components;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Interface {
    public static final Interface CONSOLE_INTERFACE = new Interface();
    private final Scanner KEYBOARD_STRING_INPUT = new Scanner(System.in);
    private final Scanner KEYBOARD_NUMERIC_INPUT = new Scanner(System.in);
    private final int BRUTEFORCE_EXAMPLE_LENGTH = 15;


    private Interface() {

    }

    public OperationType selectOperationType() {
        while (true) {
            System.out.println("Введите число, которое означает тип операции: \n" + OperationType.allOperationTypesDescription());
            try {
                int selectedOperationType = KEYBOARD_NUMERIC_INPUT.nextInt();
                return OperationType.values()[selectedOperationType - 1];
            } catch (Exception e) {
                KEYBOARD_NUMERIC_INPUT.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public void selectUserFilePath() {
        System.out.println("Введите абсолютный путь к вашему файлу:");
        while (true) {
            try {
                String selectedUserFilePath = KEYBOARD_STRING_INPUT.nextLine();
                Path userFilePath = Paths.get(selectedUserFilePath);
                if (Files.exists(userFilePath) && !Files.isDirectory(userFilePath)) {
                    Data.userFilePath = selectedUserFilePath;
                    break;
                } else {
                    System.out.println("Файл по введенному пути не существует. Введите путь еще раз");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void selectResultFilePath() {
        System.out.println("Введите путь для сохранения результата:");
        while (true) {
            String selectedResultFilePath = KEYBOARD_STRING_INPUT.nextLine();
            if (validateFilePath(selectedResultFilePath)) {
                Data.resultFilePath = selectedResultFilePath;
                break;
            }
        }
    }

    public void selectShiftingKey(String message) {
        System.out.println(message);
        while (true) {
            try {
                int selectedShiftKey = KEYBOARD_NUMERIC_INPUT.nextInt();
                if (selectedShiftKey % Data.ALPHABET.size() == 0) {
                    System.out.println("Ключ не должен быть кратен " + Data.ALPHABET.size() + "\n" +
                            "Повторно введите ключ");
                    continue;
                }
                Data.shiftingKey = selectedShiftKey;
                break;
            } catch (Exception e) {
                KEYBOARD_NUMERIC_INPUT.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public void showBruteforceVariants() {
        for (int i = 1; i < Data.ALPHABET.size(); i++) {
            System.out.println("ключ " + i + " - " + Encoding.textExampleForBruteforce(BRUTEFORCE_EXAMPLE_LENGTH, i));
        }
    }

    private boolean validateFilePath(String filePath) {
        boolean validationResult = true;
        for (String prohibitedFile : Data.PROHIBITED_FILES) {
            if (filePath.contains(prohibitedFile)) {
                validationResult = false;
            }
        }
        return validationResult;
    }
}
