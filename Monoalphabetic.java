// This class encrypts text using a Monoalphabetic Cipher.
public class Monoalphabetic {
    public static char normalChar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
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
}
