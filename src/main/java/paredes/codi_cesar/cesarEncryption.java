package paredes.codi_cesar;

class cesarEncryption {

    private cesarEncryption() {
    }

    // Método para encriptar el texto
    public static String encrypt(String text, int llave) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char ch = (char) (((int) currentChar + llave - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar + llave - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    // Método para desencriptar el texto
    public static String decrypt(String text, int llave) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char ch = (char) (((int) currentChar - llave - 65 + 26) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar - llave - 97 + 26) % 26 + 97);
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
