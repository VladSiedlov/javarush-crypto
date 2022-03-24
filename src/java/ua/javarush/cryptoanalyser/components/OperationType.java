package ua.javarush.cryptoanalyser.components;

public enum OperationType {
    ENCODE("шифрование"),
    DECODE("расшифровка"),
    BRUTEFORCE("брутфорс");

    public String description;

    OperationType(String description) {
        this.description = description;
    }

    public static String allOperationTypesDescription() {
        StringBuilder allOperationTypesDescription = new StringBuilder();

        for (OperationType operation : OperationType.values()) {
            allOperationTypesDescription.append(operation.ordinal() + 1 + " - " + operation.description + "\n");
        }
        return allOperationTypesDescription.toString();
    }
}
