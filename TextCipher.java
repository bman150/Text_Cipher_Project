import java.util.Scanner;
/*A Java Program that lets user input text and prompt user to select
a cipher to encrypt the text. Then the encrypted text is outputed.
*/
public class TextCipher {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter some text you want encrypted: ");
        String userText = myScanner.nextLine();
        
        System.out.println();
        System.out.println("*****Ciphers!*****");
        System.out.println("*****************");
        System.out.println("Caesar");
        System.out.println("Hill");
        System.out.println("Monoalphabetic");
        System.out.print("enter a cipher from the list above: ");
        String userCipher = myScanner.nextLine();

        myScanner.close();

        if (userCipher.equalsIgnoreCase("caesar")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + "Caesar return value here!");
        }
        else if (userCipher.equalsIgnoreCase("monoalphabetic")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + "Monoa;phabetic return value here!");
        }
        else if (userCipher.equalsIgnoreCase("hill")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + "Hill return value here!");
        }
        else {
            System.out.println("That is not an optional cipher");
        }

    }
}
