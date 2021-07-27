import java.util.Scanner;

/*A Java Program that lets user input text and prompt user to select
a cipher to encrypt the text. Then the encrypted text is outputed.
*/
import java.util.Scanner;
public class TextCipher {
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

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter some text you want encrypted: "); //Prompt user for text.
        String userText = myScanner.nextLine();
        
        System.out.println("Caesar");
        System.out.print("enter a cipher from the list above: "); //Prompt user to enter a chipher
        String userCipher = myScanner.nextLine();

        if (userCipher.equalsIgnoreCase("caesar")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + caesarCipher(userText));
        }
        else {
            System.out.println("That is not an optional cipher");
        }

    }
}
