package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	
	private Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}
	
	@Test
	@DisplayName("Test za bezparametarski konstruktor")
	void testAutor() {
		assertNotNull(a);
	}
	
	@Test
	@Timeout(5)
	void testAutorStringString() {
		a = new Autor("Mika", "Mikic");
		
		assertNotNull(a);
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}

	@Test
	void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		NullPointerException e = assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null) );
		
		assertEquals("Ime ne sme biti null", e.getMessage());
	}
	
	@Test
	void testSetImePrazno() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setIme("") );
	}

	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null) );
	}
	
	@Test
	void testSetPrezimePrazno() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setPrezime("") );
	}
	
	@Test
	void testToString() {
		a.setIme("Mika");
		a.setPrezime("Lazic");
		
		assertTrue( a.toString().contains("Mika") );
		assertTrue( a.toString().contains("Lazic") );
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Mika, Peric, Pera, Peric, false",
		"Pera, Mikic, Pera, Peric, false",
		"Mika, Mikic, Pera, Peric, false"
	})
	void testEquals(String ime1, String prezime1, String ime2, String prezime2, boolean ocekivano){
		a = new Autor(ime1, prezime1);
		
		Autor a2 = new Autor(ime2, prezime2);
		
		assertEquals(ocekivano, a.equals(a2));
	}
	
}
