package biblioteka;

import java.util.List;
import java.util.Objects;

/**
 * Predstavlja knjigu sa osnovnim informacijama kao što su naslov, ISBN,
 * autori, izdavač i izdanje.
 * 
 * @author Bojan Tomić (javadoc napisao chatGPT)
 */
public class Knjiga {
    
    /** Naslov knjige. */
    private String naslov;

    /** ISBN broj knjige. Jedinstven identifikator. */
    private long isbn;

    /** Lista autora knjige. */
    private List<Autor> autori;

    /** Naziv izdavača. */
    private String izdavac;

    /** Redni broj izdanja knjige. */
    private int izdanje;

    /**
     * Vraća naslov knjige.
     * 
     * @return naslov knjige kao {@code String}
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Postavlja naslov knjige.
     * 
     * @param naslov naslov koji treba postaviti
     * @throws java.lang.NullPointerException ako je naslov {@code null}
     * @throws java.lang.IllegalArgumentException ako je naslov prazan string
     */
    public void setNaslov(String naslov) {
        if (naslov == null)
            throw new NullPointerException("Naslov ne sme biti null");
        
        if (naslov.isEmpty())
            throw new IllegalArgumentException("Naslov ne sme biti prazan");
        
        this.naslov = naslov;
    }

    /**
     * Vraća ISBN broj knjige.
     * 
     * @return ISBN broj kao {@code long}
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Postavlja ISBN broj knjige.
     * 
     * @param isbn broj koji treba postaviti
     * @throws java.lang.IllegalArgumentException ako je ISBN manji ili jednak nuli
     */
    public void setIsbn(long isbn) {
        if (isbn <= 0)
            throw new IllegalArgumentException("ISBN broj mora biti veci od nule");
        
        this.isbn = isbn;
    }

    /**
     * Vraća listu autora knjige.
     * 
     * @return lista autora kao {@code List<Autor>}
     */
    public List<Autor> getAutori() {
        return autori;
    }

    /**
     * Postavlja listu autora knjige.
     * 
     * @param autori lista autora
     */
    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }

    /**
     * Vraća naziv izdavača.
     * 
     * @return izdavač kao {@code String}
     */
    public String getIzdavac() {
        return izdavac;
    }

    /**
     * Postavlja naziv izdavača.
     * 
     * @param izdavac naziv izdavača
     * @throws java.lang.NullPointerException ako je izdavač {@code null}
     * @throws java.lang.IllegalArgumentException ako je izdavač prazan string
     */
    public void setIzdavac(String izdavac) {
        if (izdavac == null)
            throw new NullPointerException("Naziv izdavaca ne sme biti null");
        
        if (izdavac.isEmpty())
            throw new IllegalArgumentException("Naziv izdavaca ne sme biti prazan");
        
        this.izdavac = izdavac;
    }

    /**
     * Vraća redni broj izdanja knjige.
     * 
     * @return izdanje kao ceo broj
     */
    public int getIzdanje() {
        return izdanje;
    }

    /**
     * Postavlja redni broj izdanja knjige.
     * 
     * @param izdanje redni broj izdanja
     * @throws java.lang.IllegalArgumentException ako je izdanje manje od 1
     */
    public void setIzdanje(int izdanje) {
        if (izdanje < 1)
            throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
        
        this.izdanje = izdanje;
    }

    /**
     * Vraća string reprezentaciju objekta knjige.
     * 
     * @return string sa svim informacijama o knjizi u formatu
     * <p>"Knjiga [naslov=####, isbn=####, autori=#####, izdavac=####, izdanje=####]"</p>
     */
    @Override
    public String toString() {
        return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
                + ", izdanje=" + izdanje + "]";
    }

    /**
     * Računa hash kod na osnovu ISBN broja.
     * 
     * @return hash kod objekta
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    /**
     * Poredi dve knjige na osnovu ISBN broja.
     * 
     * @param obj objekat za poređenje
     * @return {@code true} ako imaju isti ISBN, inače {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Knjiga other = (Knjiga) obj;
        return isbn == other.isbn;
    }
}
