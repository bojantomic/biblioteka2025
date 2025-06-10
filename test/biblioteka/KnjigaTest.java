package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class KnjigaTest {

    private Knjiga knjiga;

    @BeforeEach
    void setUp() {
        knjiga = new Knjiga();
    }
    
    @AfterEach
    void tearDown() {
        knjiga = null;
    }

    @Test
    void testSetNaslovValidan() {
        knjiga.setNaslov("Na Drini cuprija");
        assertEquals("Na Drini cuprija", knjiga.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setNaslov(null));
    }

    @Test
    void testSetNaslovPrazan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setNaslov(""));
    }

    @Test
    void testSetIsbnValidan() {
        knjiga.setIsbn(1234567890L);
        assertEquals(1234567890L, knjiga.getIsbn());
    }

    @Test
    void testSetIsbnNevalidanNula() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(0));
    }
    
    @Test
    void testSetIsbnNevalidanNegativan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(-1));
    }

    @Test
    void testSetIzdavacValidan() {
        knjiga.setIzdavac("Laguna");
        assertEquals("Laguna", knjiga.getIzdavac());
    }

    @Test
    void testSetIzdavacNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setIzdavac(null));
    }

    @Test
    void testSetIzdavacPrazan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdavac(""));
    }

    @Test
    void testSetIzdanjeValidno() {
        knjiga.setIzdanje(1);
        assertEquals(1, knjiga.getIzdanje());
    }
    
    @Test
    void testSetIzdanjeValidno2() {
        knjiga.setIzdanje(2);
        assertEquals(2, knjiga.getIzdanje());
    }

    @Test
    void testSetIzdanjeNevalidno() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdanje(0));
    }

    @Test
    void testSetAutori() {
        Autor autor1 = new Autor();
        autor1.setIme("Ivo");
        autor1.setPrezime("Andric");

        List<Autor> autori = Arrays.asList(autor1);
        knjiga.setAutori(autori);
        assertEquals(autori, knjiga.getAutori());
    }

    @ParameterizedTest
    @CsvSource({
    	"111, 111, true",
    	"111, 222, false"
    })
    void testEquals(long isbn1, long isbn2, boolean isti) {
        Knjiga k1 = new Knjiga();
        Knjiga k2 = new Knjiga();
        k1.setIsbn(isbn1);
        k2.setIsbn(isbn2);
        assertEquals(isti, k1.equals(k2));
    }
   
    @Test
    void testHashCodeIstiIsbn() {
        Knjiga k1 = new Knjiga();
        Knjiga k2 = new Knjiga();
        k1.setIsbn(555);
        k2.setIsbn(555);
        assertEquals(k1.hashCode(), k2.hashCode());
    }

    @Test
    void testToStringSadrziNaslovIzdavac() {
        knjiga.setNaslov("Prokleta avlija");
        knjiga.setIsbn(1000);
        knjiga.setIzdavac("Klett");
        knjiga.setIzdanje(45);
        
        Autor autor1 = new Autor();
        autor1.setIme("Ivo");
        autor1.setPrezime("Andric");

        List<Autor> autori = Arrays.asList(autor1);
        knjiga.setAutori(autori);
        String tekst = knjiga.toString();
        assertTrue(tekst.contains("Prokleta avlija"));
        assertTrue(tekst.contains("Klett"));
        assertTrue(tekst.contains("1000"));
        assertTrue(tekst.contains("45"));
        assertTrue(tekst.contains("Ivo"));
        assertTrue(tekst.contains("Andric"));
    }
}
