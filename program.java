import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInfoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество, дата рождения (dd.mm.yyyy), номер телефона, пол (f/m)");
        String input = scanner.nextLine();

        try {
            String[] inputData = input.split(",");
            if (inputData.length != 5) {
                throw new InvalidInputException("Неверное количество данных");
            }

            String fullName = inputData[0].trim();
            String birthDate = inputData[1].trim();
            String phoneNumber = inputData[2].trim();
            char gender = inputData[3].trim().charAt(0);

            validateBirthDate(birthDate);
            validatePhoneNumber(phoneNumber);
            validateGender(gender);

            String lastName = fullName.split(" ")[0];
            saveToFile(lastName, input);
            System.out.println("Данные успешно сохранены в файл " + lastName + ".txt");
        } catch (InvalidInputException | InvalidDateException | InvalidPhoneNumberException | InvalidGenderException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateBirthDate(String birthDate) throws InvalidDateException {
        // Реализуйте проверку формата и корректности даты рождения
    }

    private static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        // Реализуйте проверку формата и корректности номера телефона
    }

    private static void validateGender(char gender) throws InvalidGenderException {
        if (gender != 'f' && gender != 'm') {
            throw new InvalidGenderException("Неверно указан пол");
        }
    }

    private static void saveToFile(String fileName, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
            writer.write(data);
            writer.newLine();
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class InvalidGenderException extends Exception {
    public InvalidGenderException(String message) {
        super(message);
    }
}
