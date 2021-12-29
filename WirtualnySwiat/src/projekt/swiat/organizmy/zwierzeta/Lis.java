package projekt.swiat.organizmy.zwierzeta;

import java.util.Random;

import projekt.swiat.organizmy.Zwierze;

public class Lis extends Zwierze {

	public Lis(int x, int y, int id) {
		this.sila = 3;
		this.inicjatywa = 7;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "L";
		this.nazwa = "Lis";
	}

	@Override
	public void rozmnazanie() {
		swiat.setID_swiata(swiat.getID_swiata() + 1);
		Random r = new Random();
		int opcja = 0;
		while (true)
		{
			opcja = r.nextInt(4);
			if ((swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)
					&& (swiat.czyZajete(x + 1, y) == 1)) 
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
			else if (y == swiat.getWysokosc() - 1 && x == swiat.getSzerokosc() - 1 && (swiat.czyZajete(x, y - 1) == 1)
					&& (swiat.czyZajete(x - 1, y) == 1))
			{
				break;
			} 
			else if (opcja == 0 && y > 0 && swiat.czyZajete(x, y - 1) == 0) 
			{
				swiat.stworzOrganizm(new Lis(x, y - 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
			else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0) 
			{
				swiat.stworzOrganizm(new Lis(x, y + 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
			else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0)
			{
				swiat.stworzOrganizm(new Lis(x - 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
			{
				swiat.stworzOrganizm(new Lis(x + 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
		}
	}

	@Override
	public void akcja() {
		if ((swiat.czyZajete(x, y - 1) == 1) && (swiat.czyZajete(x, y + 1) == 1) && (swiat.czyZajete(x - 1, y) == 1)
				&& (swiat.czyZajete(x + 1, y) == 1))
		{
			return;
		}
		Random r = new Random();
		int opcja = 0;
		while (true) 
		{
			this.poprzedni_x = x;
			this.poprzedni_y = y;
			opcja = r.nextInt(4);
			if (opcja == 0 && y > 0 && (swiat.czyZajete(x, y - 1) == 0
					|| (swiat.czyZajete(x, y - 1) == 1 && sila >= swiat.getSila(x, y - 1))))
			{
				this.y = y - 1;
				break;
			}
			else if (opcja == 1 && y < swiat.getWysokosc() - 1 && (swiat.czyZajete(x, y + 1) == 0
					|| (swiat.czyZajete(x, y + 1) == 1 && sila >= swiat.getSila(x, y + 1)))) 
			{
				this.y = y + 1;
				break;
			} 
			else if (opcja == 2 && x > 0 && (swiat.czyZajete(x - 1, y) == 0
					|| (swiat.czyZajete(x - 1, y) == 1 && sila >= swiat.getSila(x - 1, y)))) 
			{
				this.x = x - 1;
				break;
			}
			else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && (swiat.czyZajete(x + 1, y) == 0
					|| (swiat.czyZajete(x + 1, y) == 1 && sila >= swiat.getSila(x + 1, y))))
			{
				this.x = x + 1;
				break;
			}
		}
	}
}
