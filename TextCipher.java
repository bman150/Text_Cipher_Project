import java.util.Scanner;
import java.io.*;
/*A Java Program that lets user input text and prompt user to select
a cipher to encrypt the text. Then the encrypted text is outputed.
*/
public class TextCipher {
    public static char normalChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    //For use in monoalphabetic cipher encryption
    public static char codedChar[] = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
    'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
    'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    //Ceasar cipher encryption
    public static StringBuffer caesarCipher(String text) {
        int s = 4;
        StringBuffer result = new StringBuffer();

        for (int i=0; i<text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            }
            else {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    //Monoalphabetic cipher encryption
    public static String monoAlphaCipher(String text) {
        String encryptedString = "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (text.charAt(i) == normalChar[j]) {
                    encryptedString += codedChar[j];
                    break;
                }
                if (text.charAt(i) < 'a' || text.charAt(i) > 'z') {
                    encryptedString += text.charAt(i);
                    break;
                }
            }
        }
        return encryptedString;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter some text you want encrypted: "); //Prompt user for text.
        String userText = myScanner.nextLine();
        
        System.out.println("Caesar, or Monoalphabetic");
        System.out.print("enter a cipher from the list above: "); //Prompt user to enter a chipher
        String userCipher = myScanner.nextLine();

        myScanner.close();

        if (userCipher.equalsIgnoreCase("caesar")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + caesarCipher(userText));
        }
        else if(userCipher.equalsIgnoreCase("monoalphabetic")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + monoAlphaCipher(userText));
        }
        else {
            System.out.println("That is not an optional cipher");
        }

    }
}
