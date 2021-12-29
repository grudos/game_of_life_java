package projekt.swiat.organizmy;

import java.util.Random;

import projekt.swiat.Organizm;

public abstract class Zwierze extends Organizm {

	@Override
	public void akcja() {
		this.poprzedni_x = x;
		this.poprzedni_y = y;
		Random r = new Random();
		int ruch = r.nextInt(4);

		if (ruch == 0 && y > 0) 
		{
			this.y = y - 1;
		}
		else if (ruch == 1 && x > 0) 
		{
			this.x = x - 1;
		}
		else if (ruch == 2 && x < swiat.getSzerokosc() - 1)
		{
			this.x = x + 1;
		} 
		else if (ruch == 3 && y < swiat.getWysokosc() - 1)
		{
			this.y = y + 1;
		}
	}

	@Override
	public int kolizja(Organizm atakujacy) {
		if (atakujacy.getOrganizmSymbol().equals(this.symbol))
		{
			atakujacy.setY(atakujacy.getPoprzedniY());
			atakujacy.setX(atakujacy.getPoprzedniX());
			return 1;
		}
		else
		{
			super.kolizja(atakujacy);
			return 0;
		}
	}

	public int superKolizja(Organizm atakujacy) {
		super.kolizja(atakujacy);
		return 0;
	}

	public abstract void rozmnazanie();
}
