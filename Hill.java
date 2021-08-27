// This class encrypts text using a Hill Cipher.
public class Hill {
    // Hill encryption key.
    String key = "GYBNQKURP";

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
}
