/*
 * Class: CMSC203 
 * Instructor: Professor Khandan
 * Description: The CryptoManagerTestStudent class checks and tests every test case inputed and checks if all the methods of the CryptoManager class passes.
 * Due: 03/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dave| Dawit Hailu
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CPP"));
		assertTrue(CryptoManager.isStringInBounds("\"CPP IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("Cpp"));
		assertFalse(CryptoManager.isStringInBounds("{CPP"));
		assertFalse(CryptoManager.isStringInBounds("\"{I LIKE CPP BETTER}\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("test", 3));
		assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
		assertEquals("5-0*\"", CryptoManager.caesarEncryption("WORLD", 30));
		assertEquals("BJJ?=T@", CryptoManager.caesarEncryption("GOODBYE", -5));
		assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("F=IAO\\>KJ@", CryptoManager.caesarEncryption("JAMES BOND", 700));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
		assertEquals("WORLD", CryptoManager.caesarDecryption("5-0*\"", 30));
		assertEquals("GOODBYE", CryptoManager.caesarDecryption("BJJ?=T@", -5));
		assertEquals("JAMES BOND", CryptoManager.caesarDecryption("F=IAO\\>KJ@", 700));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("E_U_94\\QX@VP[H%V#", CryptoManager.bellasoEncryption("DOES THIS CONCEPT", "APPLY THE SAME FOR ALL SENARIOS?"));
		assertEquals("_$/JJ#X]V#2^T%'[T2Q^VUW'[X_", CryptoManager.bellasoEncryption("OR DEPENDS ON THE ALGORTHIM", "PROFESSOR"));
		assertEquals("L['HD5FWV!JR3BQPXSF", CryptoManager.bellasoEncryption("INTERESTING CONCEPT", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("DOES THIS CONCEPT", CryptoManager.bellasoDecryption("E_U_94\\QX@VP[H%V#", "APPLY THE SAME FOR ALL SENARIOS?"));
		assertEquals("OR DEPENDS ON THE ALGORTHIM", CryptoManager.bellasoDecryption("_$/JJ#X]V#2^T%'[T2Q^VUW'[X_", "PROFESSOR"));
		assertEquals("INTERESTING CONCEPT", CryptoManager.bellasoDecryption("L['HD5FWV!JR3BQPXSF", "CMSC203"));

	}

}
