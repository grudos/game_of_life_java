package projekt.swiat;

import java.util.Comparator;

public class sortowanieInicjatywa implements Comparator<Organizm> {
	@Override
	public int compare(Organizm organizm_1, Organizm organizm_2) {

		int porownajInicjatywa = organizm_2.getInicjatywa() - organizm_1.getInicjatywa();

		if (porownajInicjatywa == 0) 
		{
			int porownajID = organizm_1.getID() - organizm_2.getID();
			return porownajID;
		} 
		else 
		{
			return porownajInicjatywa;
		}
	}
}