package projekt.swiat.organizmy.zwierzeta;

import java.util.Random;

import projekt.swiat.Organizm;
import projekt.swiat.organizmy.Zwierze;

public class Antylopa extends Zwierze {

	public Antylopa(int x, int y, int id) {
		this.sila = 4;
		this.inicjatywa = 4;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "A";
		this.nazwa = "Antylopa";
	}

	@Override
	public void rozmnazanie() {
		swiat.setID_swiata(swiat.getID_swiata() + 1);
		int opcja = 0;
		while (true)
		{
			Random r = new Random();
			opcja = r.nextInt(4);
			if ((swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)
					&& (swiat.czyZajete(x + 1, y) == 1)) 
			{
				break;
			} else if (y == 0 && x > 0 && x < swiat.getSzerokosc() - 1 && (swiat.czyZajete(x, y + 1) == 1)
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
			else if (y == swiat.getWysokosc() - 1 && x == swiat.getSzerokosc() - 1 && (swiat.czyZajete(x, y - 1) == 1)
					&& (swiat.czyZajete(x - 1, y) == 1)) 
			{
				break;
			} 
			else if (opcja == 0 && y > 0 && swiat.czyZajete(x, y - 1) == 0)
			{
				swiat.stworzOrganizm(new Antylopa(x, y - 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0) 
			{
				swiat.stworzOrganizm(new Antylopa(x, y + 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
			else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0)
			{
				swiat.stworzOrganizm(new Antylopa(x - 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
			{
				swiat.stworzOrganizm(new Antylopa(x + 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
		}
	}

	@Override
	public void akcja() {
		this.poprzedni_x = x;
		this.poprzedni_y = y;
		int ruch = 0;
		Random r = new Random();
		ruch = r.nextInt(8);
		if (ruch == 0) 
		{
			if (y > 1) 
			{
				this.y = y - 2;
			} 
			else if (y > 0) 
			{
				this.y = y - 1;
			}
		} 
		else if (ruch == 1) 
		{
			if (x > 1) 
			{
				this.x = x - 2;
			} 
			else if (x > 0) 
			{
				this.x = x - 1;
			}
		} 
		else if (ruch == 2)
		{
			if (x < swiat.getSzerokosc() - 2)
			{
				this.x = x + 2;
			} 
			else if (x < swiat.getSzerokosc() - 1) 
			{
				this.x = x + 1;
			}
		} 
		else if (ruch == 3) 
		{
			if (y < swiat.getWysokosc() - 2)
			{
				this.y = y + 2;
			} 
			else if (y < swiat.getWysokosc() - 1)
			{
				this.y = y + 1;
			}
		} 
		else if (ruch == 4 && y > 0)
		{
			this.y = y - 1;
		} 
		else if (ruch == 5 && x > 0)
		{
			this.x = x - 1;
		} 
		else if (ruch == 6 && x < swiat.getSzerokosc() - 1)
		{
			this.x = x + 1;
		} 
		else if (ruch == 7 && y < swiat.getWysokosc() - 1) 
		{
			this.y = y + 1;
		}
	}

	@Override
	public int kolizja(Organizm atakujacy) {
		if (atakujacy.getNazwa().equals(this.nazwa)) 
		{
			atakujacy.setY(atakujacy.getPoprzedniY());
			atakujacy.setX(atakujacy.getPoprzedniX());
			return 1;
		}
		int ucieczka = 0;
		Random r = new Random();
		ucieczka = r.nextInt(2);
		if (ucieczka == 0) 
		{
			super.superKolizja(atakujacy);
			return 0;
		}
		else if (ucieczka == 1) 
		{
			if ((swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)
					&& (swiat.czyZajete(x + 1, y) == 1)) 
			{
				return -1;
			}
			int opcja = 0;
			while (true) 
			{
				opcja = r.nextInt(4);
				if (opcja == 0 && y > 0 && swiat.czyZajete(x, y - 1) == 0) 
				{
					this.poprzedni_y = y;
					this.y = y - 1;
					break;
				} 
				else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0) 
				{
					this.poprzedni_y = y;
					this.y = y + 1;
					break;
				} 
				else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0)
				{
					this.poprzedni_x = x;
					this.x = x - 1;
					break;
				} 
				else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
				{
					this.poprzedni_x = x;
					this.x = x + 1;
					break;
				}
			}
			return 0;
		}
		return 0;
	}
}
