package projekt.swiat.organizmy.zwierzeta;

import java.util.Random;

import projekt.swiat.organizmy.Zwierze;

public class Owca extends Zwierze {

	public Owca(int x, int y, int id) {
		this.sila = 4;
		this.inicjatywa = 4;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "O";
		this.nazwa = "Owca";
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
				swiat.stworzOrganizm(new Owca(x, y - 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0) 
			{
				swiat.stworzOrganizm(new Owca(x, y + 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0) 
			{
				swiat.stworzOrganizm(new Owca(x - 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
			else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
			{
				swiat.stworzOrganizm(new Owca(x + 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
		}
	}
}
