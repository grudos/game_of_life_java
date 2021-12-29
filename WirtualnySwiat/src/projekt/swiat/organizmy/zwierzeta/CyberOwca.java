package projekt.swiat.organizmy.zwierzeta;

import java.util.Random;

import projekt.swiat.Organizm;

public class CyberOwca extends Owca {

	public CyberOwca(int x, int y, int id) {
		super(x, y, id);
		this.sila = 11;
		this.symbol = "$";
		this.nazwa = "CyberOwca";
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
				swiat.stworzOrganizm(new CyberOwca(x, y - 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 1 && y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 0)
			{
				swiat.stworzOrganizm(new CyberOwca(x, y + 1, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
			else if (opcja == 2 && x > 0 && swiat.czyZajete(x - 1, y) == 0)
			{
				swiat.stworzOrganizm(new CyberOwca(x - 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			} 
			else if (opcja == 3 && x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 0)
			{
				swiat.stworzOrganizm(new CyberOwca(x + 1, y, swiat.getID_swiata()));
				komentator.dajInformacje(this.nazwa + " rozmnozyl/a sie " + '\n');
				break;
			}
		}
	}

	@Override
	public void akcja() {
		Random r = new Random();
		int opcja = 0;

		if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x - 1, y).equals("b")
				&& swiat.getSymbol(x, y + 1).equals("b") && swiat.getSymbol(x, y - 1).equals("b"))
		{
			opcja = r.nextInt(4);
			if (opcja == 0) 
			{
				this.x = x + 1;
			}
			else if (opcja == 1) 
			{
				this.x = x - 1;
			}
			else if (opcja == 2)
			{
				this.y = y + 1;
			} 
			else if (opcja == 3) 
			{
				this.y = y - 1;
			}
		}

		else if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x - 1, y).equals("b")
				&& swiat.getSymbol(x, y + 1).equals("b")) 
		{
			opcja = r.nextInt(3);
			if (opcja == 0)
			{
				this.x = x + 1;
			}
			else if (opcja == 1)
			{
				this.x = x - 1;
			} 
			else if (opcja == 2) 
			{
				this.y = y + 1;
			}
		} 
		else if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x, y + 1).equals("b")
				&& swiat.getSymbol(x, y - 1).equals("b"))
		{
			opcja = r.nextInt(3);
			if (opcja == 0) 
			{
				this.x = x + 1;
			} 
			else if (opcja == 1)
			{
				this.y = y + 1;
			}
			else if (opcja == 2)
			{
				this.y = y - 1;
			}
		}
		else if (swiat.getSymbol(x - 1, y).equals("b") && swiat.getSymbol(x, y + 1).equals("b")
				&& swiat.getSymbol(x, y - 1).equals("b"))
		{
			opcja = r.nextInt(3);
			if (opcja == 0)
			{
				this.x = x - 1;
			} 
			else if (opcja == 1)
			{
				this.y = y + 1;
			}
			else if (opcja == 2) 
			{
				this.y = y - 1;
			}
		}

		else if (swiat.getSymbol(x, y + 1).equals("b") && swiat.getSymbol(x, y - 1).equals("b")) 
		{
			opcja = r.nextInt(2);
			if (opcja == 0) 
			{
				this.y = y + 1;
			} 
			else if (opcja == 1)
			{
				this.y = y - 1;
			}
		} 
		else if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x, y - 1).equals("b"))
		{
			opcja = r.nextInt(2);
			if (opcja == 0)
			{
				this.x = x + 1;
			}
			else if (opcja == 1)
			{
				this.y = y - 1;
			}
		} 
		else if (swiat.getSymbol(x - 1, y).equals("b") && swiat.getSymbol(x, y - 1).equals("b")) 
		{
			opcja = r.nextInt(2);
			if (opcja == 0)
			{
				this.x = x - 1;
			} 
			else if (opcja == 1)
			{
				this.y = y - 1;
			}
		}

		else if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x - 1, y).equals("b")) 
		{
			opcja = r.nextInt(2);
			if (opcja == 0) 
			{
				this.x = x + 1;
			} 
			else if (opcja == 1) 
			{
				this.x = x - 1;
			}
		}
		else if (swiat.getSymbol(x + 1, y).equals("b") && swiat.getSymbol(x, y + 1).equals("b"))
		{
			opcja = r.nextInt(2);
			if (opcja == 0)
			{
				this.x = x + 1;
			}
			else if (opcja == 1)
			{
				this.y = y + 1;
			}
		}

		else if (swiat.getSymbol(x - 1, y).equals("b") && swiat.getSymbol(x, y + 1).equals("b"))
		{
			opcja = r.nextInt(2);
			if (opcja == 0) 
			{
				this.x = x - 1;
			} 
			else if (opcja == 1)
			{
				this.y = y + 1;
			}
		}

		else if (swiat.getSymbol(x + 1, y).equals("b")) 
		{
			this.x = x + 1;
		} 
		else if (swiat.getSymbol(x - 1, y).equals("b"))
		{
			this.x = x - 1;
		} 
		else if (swiat.getSymbol(x, y + 1).equals("b"))
		{
			this.y = y + 1;
		}
		else if (swiat.getSymbol(x, y - 1).equals("b")) 
		{
			this.y = y - 1;
		} 
		else
		{
			super.akcja();
		}

	}

	@Override
	public int kolizja(Organizm atakujacy) {
		if (atakujacy.getOrganizmSymbol().equals("b")) 
		{
			komentator.dajInformacje(atakujacy.getNazwa() + " zostal/a zniszczony/na przez " + this.nazwa + '\n');
			swiat.smiercOrganizmu(atakujacy.getID());
			return -1;
		} 
		else if (atakujacy.getOrganizmSymbol().equals(this.symbol))
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
}
