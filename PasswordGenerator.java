import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        // Prompt the user to specify character types to include in the password
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");
        
        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        
        // Display the generated password
        System.out.println("Generated password: " + password);
        
        scanner.close();
    }
    
    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_+=<>?";

        StringBuilder characterPool = new StringBuilder();
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeLowercase) {
            characterPool.append(lowercaseLetters);
        }
        if (includeUppercase) {
            characterPool.append(uppercaseLetters);
        }
        if (includeSpecialChars) {
            characterPool.append(specialCharacters);
        }

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be included.");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
