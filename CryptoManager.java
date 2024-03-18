/*
 * Class: CMSC203 
 * Instructor: Professor Khandan
 * Description: The CryptoManager class provides methods for encryption and decryption using different ciphers, 
 * 				including the Caesar and Bellaso ciphers. It ensures that characters are within the allowable bounds 
 * 				of ASCII codes and handles out-of-bound keys for both encryption and decryption. This class serves as 
 * 				a utility for text encryption and decryption operations.
 * Due: 03/17/2024
 * Platform/compiler: Eclips
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dave| Dawit Hailu
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		for (int i = 0; i < plainText.length(); i++) {
	        char c = plainText.charAt(i);
	        if (c < LOWER_RANGE || c > UPPER_RANGE) {
	            return false; // Character is outside the allowable bounds
	        }
	    }
	    return true; // All characters are within the allowable bounds
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		
		 StringBuilder encryptedText = new StringBuilder();
		 if (!isStringInBounds(plainText)) {
		        return "The selected string is not in bounds, Try again.";
		    }
		 while (key > RANGE) {
	            key -= RANGE;
	            
	        }
		 for (int i = 0; i < plainText.length(); i++) {
	            char originalChar = plainText.charAt(i);
	            char encryptedChar;

	            // Check if the character is within the allowable bounds
	            if (isStringInBounds(Character.toString(originalChar))) {
	                // Perform Caesar Cipher encryption
	                encryptedChar = (char) (((originalChar - LOWER_RANGE + key) % RANGE) + LOWER_RANGE);
	            } else {
	                // Character is outside the allowable bounds, leave it unchanged
	                encryptedChar = originalChar;
	                
	            }

	            encryptedText.append(encryptedChar);
	        }

	        return encryptedText.toString();
	    }
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		StringBuilder encryptedText = new StringBuilder();
		
		StringBuilder extendedKeyword = new StringBuilder();
		
		while (extendedKeyword.length() < plainText.length()) {
            extendedKeyword.append(bellasoStr);
        }

        for (int i = 0; i < plainText.length(); i++) {
            char originalChar = plainText.charAt(i);
            char bellasoChar = extendedKeyword.charAt(i);
            char encryptedChar;

            if (isStringInBounds(Character.toString(originalChar))) {
                // Calculate the offset by adding the ASCII values
                int offset = originalChar + bellasoChar;

                // Wrap around the offset to stay within the specified range
                while (offset > UPPER_RANGE) {
                    offset -= RANGE;
                }

                encryptedChar = (char) offset;
            } else {
                encryptedChar = originalChar;
            }

            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		 StringBuilder decryptedText = new StringBuilder();

		 while (key > RANGE) {
	            key -= RANGE;
	        }
	        for (int i = 0; i < encryptedText.length(); i++) {
	            char encryptedChar = encryptedText.charAt(i);
	            char decryptedChar;

	            if (isStringInBounds(Character.toString(encryptedChar))) {
	                decryptedChar = (char) (((encryptedChar - LOWER_RANGE - key + RANGE) % RANGE) + LOWER_RANGE);
	            } else {
	                decryptedChar = encryptedChar;
	                
	            }

	            decryptedText.append(decryptedChar);
	        }

	        return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		StringBuilder decryptedText = new StringBuilder();

		StringBuilder extendedKeyword = new StringBuilder();
        while (extendedKeyword.length() < encryptedText.length()) {
            extendedKeyword.append(bellasoStr);
        }

        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char bellasoChar = extendedKeyword.charAt(i);
            char decryptedChar;

            if (isStringInBounds(Character.toString(encryptedChar))) {
                // Calculate the offset by subtracting the ASCII values
                int offset = encryptedChar - bellasoChar;

                // Wrap around the offset to stay within the specified range
                while (offset < LOWER_RANGE) {
                    offset += RANGE;
                }

                decryptedChar = (char) offset;
            } else {
                decryptedChar = encryptedChar;
            }

            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString();
	}
}
