package paredes.codi_cesar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest 
{

    // PRUEBA CON PALABRAS MAYUSUCLAS - ENCRIPTAR - ROT3
     @Test
    public void testEncryptSimple() {
        String result = cesarEncryption.encrypt("RESPIRAR", 3);
        assertEquals("UHVSLUDU", result);
    }


    // PRUEBA CON LETRAS FINALES DEL ALFABETO - ENCRIPTAR - ROT4
    @Test
    public void testEncryptWithWrapAround() {
        String result = cesarEncryption.encrypt("xilofonos y zaps", 4);
        assertEquals("bmpsjsrsw c detw", result); 
    }

    // PRUEBA CON MAYÚSCULAS -  ENCRIPTAR - ROT3
    @Test
    public void testEncryptWithLowerCase() {
        String result = cesarEncryption.encrypt("CASA OBLIGATORIA", 3);
        assertEquals("FDVD REOLJDWRULD", result);  // Prueba simple con minúsculas.
    }


    // PRUEBA CON MAYUSUCLAS Y MINÚSCULAS - ENCRIPTAR - ROT5
    @Test
    public void testEncryptMixedCase() {
        String result = cesarEncryption.encrypt("HelloWorld", 5);
        assertEquals("MjqqtBtwqi", result); 
    }


    // PRUEBA CON PALABRAS MAYUSUCLAS - DESENCRIPTAR - ROT3
    @Test
    public void testDecryptSimple() {
        String result = cesarEncryption.decrypt("FDVD REOLJDWRULD", 3);
        assertEquals("CASA OBLIGATORIA", result);  // Desencriptar una palabra simple.
    }

    // PRUEBA CON LETRAS FINALES DEL ALFABETO - DESENCRIPTAR - ROT4
    @Test
    public void testDecryptWithWrapAround() {
        String result = cesarEncryption.decrypt("bmpsjsrsw c detw", 4);
        assertEquals("xilofonos y zaps", result);  // Desencriptar cuando se da la vuelta al alfabeto.
    }

    // PRUEBA CON MAYUSCULAS Y MINUSUCLAS - DESENCRIPTAR - ROT5
    @Test
    public void testDecryptMixedCase() {
        String result = cesarEncryption.decrypt("MjqqtBtwqi", 5);
        assertEquals("HelloWorld", result); 
    }

    // PRUEBA CON MAYUSUCLAS Y MINÚSCULAS - DESENCRIPTAR - ROT5
    @Test
    public void testEncryptAndDecryptComplex() {
        String originalText = "ComplexTest123";
        int KEY = 7;
        String encrypted = cesarEncryption.encrypt(originalText, KEY);
        String decrypted = cesarEncryption.decrypt(encrypted, KEY);
        assertEquals(originalText, decrypted);
    }
}