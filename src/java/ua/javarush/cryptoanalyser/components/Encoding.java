package ua.javarush.cryptoanalyser.components;

import java.io.*;

public class Encoding {
    private static final char UNKNOWN_CHARACTER = '¿';
    private static final int UNKNOWN_CHARACTER_INDEX = -1;

    public static void encode() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.userFilePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Data.resultFilePath));

            while (bufferedReader.ready()) {
                int characterFromFile = bufferedReader.read();
                int indexFromAlphabet = Data.ALPHABET.indexOf((char)characterFromFile);
                int encryptedChar;
                if (indexFromAlphabet != UNKNOWN_CHARACTER_INDEX) {
                    int encryptedIndex = (indexFromAlphabet + Data.shiftingKey) % Data.ALPHABET.size();
                    encryptedChar = Data.ALPHABET.get(encryptedIndex);
                } else {
                    encryptedChar = UNKNOWN_CHARACTER;
                }
                bufferedWriter.write(encryptedChar);
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void decode() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.userFilePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Data.resultFilePath));

            while (bufferedReader.ready()) {
                int characterFromFile = bufferedReader.read();
                int indexFromAlphabet = Data.ALPHABET.indexOf((char)characterFromFile);
                int decryptedChar;
                if (indexFromAlphabet != UNKNOWN_CHARACTER_INDEX) {
                    int decryptedIndex = calculateDecryptedCharacterIndex(indexFromAlphabet, Data.shiftingKey);
                    decryptedChar = Data.ALPHABET.get(decryptedIndex);
                } else {
                    decryptedChar = UNKNOWN_CHARACTER;
                }
                bufferedWriter.write(decryptedChar);
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static String textExampleForBruteforce(int exampleLength, int decryptionKey) {
        StringBuilder textExample = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.userFilePath));

            for (int i = 0; i < exampleLength; i++) {
                if (!bufferedReader.ready()) {
                    break;
                }
                int characterFromFile = bufferedReader.read();
                int indexFromAlphabet = Data.ALPHABET.indexOf((char)characterFromFile);
                char decryptedChar;

                if (indexFromAlphabet != UNKNOWN_CHARACTER_INDEX) {
                    int decryptedIndex = calculateDecryptedCharacterIndex(indexFromAlphabet, decryptionKey);
                    decryptedChar = Data.ALPHABET.get(decryptedIndex);
                } else {
                    decryptedChar = UNKNOWN_CHARACTER;
                }
                textExample.append(decryptedChar);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textExample.toString();
    }

    private static int calculateDecryptedCharacterIndex(int index, int decryptionKey) {
        int revertedKey = decryptionKey % Data.ALPHABET.size();
        int result = index - revertedKey;
        return result >= 0 ? result : Data.ALPHABET.size() + result;
    }
}
