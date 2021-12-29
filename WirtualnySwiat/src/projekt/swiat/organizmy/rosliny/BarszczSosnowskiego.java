package projekt.swiat.organizmy.rosliny;

import java.util.Random;

import projekt.swiat.Organizm;
import projekt.swiat.organizmy.Roslina;

public class BarszczSosnowskiego extends Roslina {

	public BarszczSosnowskiego(int x, int y, int id) {
		this.sila = 10;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "b";
		this.nazwa = "Barszcz Sosnowskiego";
	}

	@Override
	public void akcja() {
		if (y > 0 && swiat.czyZajete(x, y - 1) == 1) 
		{
			swiat.smiercOrganizmuBarszcz(x, y - 1);
		}
		if (y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 1)
		{
			swiat.smiercOrganizmuBarszcz(x, y + 1);
		}
		if (x > 0 && swiat.czyZajete(x - 1, y) == 1)
		{
			swiat.smiercOrganizmuBarszcz(x - 1, y);
		}
		if (x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 1)
		{
			swiat.smiercOrganizmuBarszcz(x + 1, y);
		}

		Random r = new Random();
		int zasadzenie = 0;
		zasadzenie = r.nextInt(30);

		if (zasadzenie == 0) 
		{
			swiat.setID_swiata(swiat.getID_swiata() + 1);
			int opcja = 0;
			while (true) 
			{
				opcja = r.nextInt(4);
				if ((swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1)
						&& (swiat.czyZajete(x - 1, y) == 1) && (swiat.czyZajete(x + 1, y) == 1)) {
					break;
				}
				else if (y == 0 && x > 0 && x < swiat.getSzerokosc() - 1 && (swiat.czyZajete(x, y + 1) == 1)
						&& (swiat.czyZajete(x - 1, y) == 1) && (swiat.czyZajete(x + 1, y) == 1))
				{
					break;
				} 
				else if (y == swiat.getWysokosc() - 1 && x > 0 && x < swiat.getSzerokosc() - 1
						&& (swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)
						&& (swiat.czyZajete(x + 1, y) == 1)) 
				{
					break;
				} 
				else if (x == 0 && y > 0 && y < swiat.getWysokosc() - 1 && (swiat.czyZajete(x, y - 1) == 1)
						&& (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x + 1, y) == 1)) 
				{
					break;
				} 
				else if (x == swiat.getSzerokosc() - 1 && y > 0 && y < swiat.getWysokosc() - 1
						&& (swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1)
						&& (swiat.czyZajete(x - 1, y) == 1))
				{
					break;
				}
				else if (y == 0 && x == 0 && (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x + 1, y) == 1)) 
				{
					break;
				}
				else if (y == swiat.getWysokosc() - 1 && x == 0 && (swiat.czyZajete(x, y - 1) == 1)
						&& (swiat.czyZajete(x + 1, y) == 1)) 
				{
					break;
				} 
				else if (y == 0 && x == swiat.getSzerokosc() - 1 && (swiat.czyZajete(x, y + 1) == 1)
						&& (swiat.czyZajete(x - 1, y) == 1)) 
				{
					break;
				} else if (y == swiat.getWysokosc() - 1 && x == swiat.getSzerokosc() - 1
						&& (swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)) {
					break;
				}
				else if (opcja == 0 && y > 0 && swiat.czyZajete(x, y - 1) == 0) 
				{
					swiat.stworzOrganizm(new BarszczSosnowskiego(x, y - 1, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
					break;
				} 
				else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0) 
				{
					swiat.stworzOrganizm(new BarszczSosnowskiego(x, y + 1, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
					break;
				} 
				else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0) 
				{
					swiat.stworzOrganizm(new BarszczSosnowskiego(x - 1, y, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
					break;
				}
				else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0) 
				{
					swiat.stworzOrganizm(new BarszczSosnowskiego(x + 1, y, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
					break;
				}
			}
		}
	}

	@Override
	public void rozmnazanie() {

	}

	@Override
	public int kolizja(Organizm atakujacy) {
		super.kolizja(atakujacy);
		return 0;
	}
}
