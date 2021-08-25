import java.util.Scanner;
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

    //HILL CIPHER ENCRYPTION
    // generates the key matrix for the key string
    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }
    // encrypts the text
    static void encrypt(int cipherMatrix[][], int keyMatrix[][], int textVector[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;
                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * textVector[x][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }
    // implements hill cipher
    static String hillCipher(String text, String key) {
        // get key matrix from the key string
        int [][]keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);
        int [][]textVector = new int[3][1];

        // generate vector for the text
        for (int i = 0; i < 3; i++) {
            textVector[i][0] = (text.charAt(i)) % 65;
        }
        int [][]cipherMatrix = new int[3][1];

        //generates the encrypted vector
        encrypt(cipherMatrix, keyMatrix, textVector);
        String CipherText = "";

        //generate encrypted text from encrypted vector
        for (int i = 0; i < 3; i++) {
            CipherText += (char)(cipherMatrix[i][0] + 65);
        }
        return CipherText;
    }

    public static void main(String[] args) {
        String key = "GYBNQKURP"; // key for use with hill cipher encryption

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter some text you want encrypted: "); //Prompt user for text.
        String userText = myScanner.nextLine();
        
        System.out.println();
        System.out.println("*****Ciphers!*****");
        System.out.println("*****************");
        System.out.println("Caesar");
        System.out.println("Hill");
        System.out.println("Monoalphabetic");
        System.out.print("enter a cipher from the list above: "); //Prompt user to enter a chipher
        String userCipher = myScanner.nextLine();

        myScanner.close();

        if (userCipher.equalsIgnoreCase("caesar")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + caesarCipher(userText));
        }
        else if (userCipher.equalsIgnoreCase("monoalphabetic")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + monoAlphaCipher(userText));
        }
        else if (userCipher.equalsIgnoreCase("hill")) {
            System.out.println("Original Text: " + userText);
            System.out.println("Cipher: " + userCipher);
            System.out.println("Encryption: " + hillCipher(userText, key));
        }
        else {
            System.out.println("That is not an optional cipher");
        }

    }
}
