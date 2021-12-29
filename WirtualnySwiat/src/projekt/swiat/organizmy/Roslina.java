package projekt.swiat.organizmy;

import projekt.swiat.Organizm;

public abstract class Roslina extends Organizm {

	public abstract void akcja();

	public abstract void rozmnazanie();

	@Override
	public int kolizja(Organizm atakujacy) {
		super.kolizja(atakujacy);
		return 0;
	}
}
