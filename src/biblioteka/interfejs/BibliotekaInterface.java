package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

/**
 * Predstavlja biblioteku u kojoj mogu da se dodaju nove knjige,
 * brišu i pretražuju.
 * 
 * @author Bojan Tomić
 */
public interface BibliotekaInterface {
	
	/**
	 * Dodaje novu knjigu u biblioteku.
	 * 
	 * Knjiga ne sme biti null niti duplikat (odnosno
	 * da već postoji u biblioteci).
	 * 
	 * @param knjiga Nova knjiga koju treba dodati u biblioteku
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga već postoji
	 * u biblioteci
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	/**
	 * Briše postojeću knjigu iz biblioteke.
	 * 
	 * Knjiga ne sme biti null mora
	 * da već postoji u biblioteci.
	 * 
	 * @param knjiga Postojeća knjiga koju treba obrisati iz biblioteke
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga ne postoji
	 * u biblioteci
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	
	/**
	 * Vraća sve knjige iz biblioteke.
	 * 
	 * @return Listu sa svim knjigama iz biblioteke
	 * 
	 * @see java.util.List
	 */
	public List<Knjiga> vratiSveKnjige();
	
	/**
	 * Pretražuje biblioteku i pronalazi i vraća sve knjige
	 * koje odgovaraju kriterijumima pretrage.
	 * 
	 * @param autor Autor knjige (ili jedan od autora ako ih je više)
	 * @param isbn ISBN identifikator knjige
	 * @param naslov Deo naslova knjige (nije bitno da li su velika ili mala slova)
	 * @param izdavac Deo naziv izdavača knjige (nije bitno da li su velika ili mala slova)
	 * 
	 * @return Listu sa pronađenim knjigama ili praznu listu ako nema nijedne takve knjige
	 * 
	 * @throws java.lang.IllegalArgumentException ako nije unet nijedan kriterijum
	 * za pretragu tj. autor, naslov i izdavač su null a isbn broj je nula.
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, 
			String naslov, String izdavac);

}
