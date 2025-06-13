package biblioteka;

import java.util.Objects;

/**
 * Predstavlja autora knjige koji ima ime i prezime.
 * 
 *  @author Bojan Tomić
 */
public class Autor {
	
	/**
	 * Ime autora kao String
	 */
	private String ime;
	
	/**
	 * Prezime autora kao String
	 */
	private String prezime;
	
	/**
	 * Inicijalizuje objekat sa atributima koji imaju default vrednosti
	 */
	public Autor() {
	}

	/**
	 * Inicijalizuje instancu autora sa unetim imenom i prezimenom
	 * 
	 * @param ime Ime autora koje se unosi u objekat. Ime ne sme biti null niti prazno.
	 * @param prezime Prezime autora koje se unosi u objekat. Prezime ne sme biti 
	 * null niti prazno. 
	 */
	public Autor(String ime, String prezime) {
		setIme(ime);
		setPrezime(prezime);
	}
	
	/**
	 * Vraća ime autora
	 * 
	 * @return Ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja novo ime autora.
	 * 
	 * Uneto ime ne sme biti null niti prazno.
	 * 
	 * @param ime Ime autora kao String
	 * 
	 * @throws java.lang.NullPointerException Ako je uneto ime null
	 * @throws java.lang.IllegalArgumentException Ako je uneto ime prazan String
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazno");
		
		this.ime = ime;
	}

	/**
	 * Vraća prezime autora
	 * 
	 * @return Prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja novo prezime autora.
	 * 
	 * Uneto prezime ne sme biti null niti prazno.
	 * 
	 * @param prezime Prezime autora kao String
	 * 
	 * @throws java.lang.NullPointerException Ako je uneto prezime null
	 * @throws java.lang.IllegalArgumentException Ako je uneto prezime prazan String
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazno");
		
		this.prezime = prezime;
	}

	/**
	 * Vraća String sa svim podacima o autoru.
	 * 
	 * @return String sa svim podacima u formatu 
	 * "Autor [ime=####, prezime=####]" odnosno na primer:
	 * "Autor [ime=Pera, prezime=Peric]"
	 */
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	/**
	 * Vraća hash code zasnovan na imenu i prezimenu autora.
	 * 
	 * @return hash code prema imenu i prezimenu.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	/**
	 * Poredi dva autora prema imenu i prezimenu.
	 * 
	 * @param obj Drugi autor sa kojim se poredi
	 * 
	 * @return 
	 * <ul>
	 * 
	 * <li><b>true</b> - ako je uneti objekat različit od null, ako je klase Autor i
	 * ako su i ime i prezime isti kao kod prvog autora.</li>
	 * 
	 * <li><b>false</b> - u svim ostalim slučajevima.</li>
	 * 
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

}
