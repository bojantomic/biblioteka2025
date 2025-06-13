package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

/**
 * Implementira BibliotekaInterface tako što čuva knjige
 * u listi u memoriji (ArrayList implementacija)
 * 
 * @see java.util.ArrayList
 */
public class Biblioteka implements BibliotekaInterface {
	
	//Ovo je implementirano kao ArrayList zbog cestog dodavanja i pretrage
	/**
	 * Knjige se čuvaju u listi u memoriji preko ArrayList
	 * implementacije zbog čestog dodavanja i pretrage.
	 * 
	 * @see java.util.ArrayList
	 */
	private List<Knjiga> knjige = new ArrayList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Ta knjiga vec postoji u biblioteci");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (!knjige.contains(knjiga))
			throw new IllegalArgumentException("Ta knjiga ne postoji u biblioteci");
		
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn <= 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();
		
		for(Knjiga k: knjige)
			if (k.getNaslov().toUpperCase().contains(naslov.toUpperCase()))
				rezultati.add(k);
		
		return rezultati;
	}

}
