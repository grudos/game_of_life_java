package projekt.swiat.organizmy.rosliny;

import java.util.Random;

import projekt.swiat.Organizm;
import projekt.swiat.organizmy.Roslina;
import projekt.swiat.organizmy.Zwierze;

public class Guarana extends Roslina {

	public Guarana(int x, int y, int id) {
		this.sila = 0;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "g";
		this.nazwa = "Guarana";
	}

	@Override
	public void akcja() {
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
						&& (swiat.czyZajete(x - 1, y) == 1) && (swiat.czyZajete(x + 1, y) == 1)) 
				{
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
				}
				else if (y == swiat.getWysokosc() - 1 && x == swiat.getSzerokosc() - 1
						&& (swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)) 
				{
					break;
				} 
				else if (opcja == 0 && y > 0 && swiat.czyZajete(x, y - 1) == 0) 
				{
					swiat.stworzOrganizm(new Guarana(x, y - 1, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + "\n");
					break;
				}
				else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0)
				{
					swiat.stworzOrganizm(new Guarana(x, y + 1, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + "\n");
					break;
				}
				else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0) 
				{
					swiat.stworzOrganizm(new Guarana(x - 1, y, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + "\n");
					break;
				} 
				else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
				{
					swiat.stworzOrganizm(new Guarana(x + 1, y, swiat.getID_swiata()));
					komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + "\n");
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
		if (atakujacy instanceof Zwierze) 
		{
			atakujacy.setOrganizmSila(atakujacy.getOrganizmSila() + 3);
			super.kolizja(atakujacy);
		}
		return 0;
	}
}
