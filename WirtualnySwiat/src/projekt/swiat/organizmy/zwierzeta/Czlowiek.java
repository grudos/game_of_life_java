package projekt.swiat.organizmy.zwierzeta;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import projekt.swiat.organizmy.Zwierze;

public class Czlowiek extends Zwierze {

	protected int moc_tura = 0;
	protected int aktywacja_mocy = 0;
	protected int dezaktywacja_tura = 5;
	protected int kliknieto = -1;

	public Czlowiek(int x, int y, int id) {
		this.sila = 5;
		this.inicjatywa = 4;
		this.x = x;
		this.y = y;
		this.id = id;
		this.symbol = "C";
		this.nazwa = "Czlowiek";

	}

	public Czlowiek() {
		this.sila = 5;
		this.inicjatywa = 4;
		this.symbol = "C";
		this.nazwa = "Czlowiek";
	}

	public int getMocTura() {
		return moc_tura;
	}

	public int getAktywacjaMocy() {
		return aktywacja_mocy;
	}

	public int getDezaktywacjaTura() {
		return dezaktywacja_tura;
	}

	public void setMocTura(int moc_tura) {
		this.moc_tura = moc_tura;
	}

	public void setAktywacjaMocy(int aktywacja_mocy) {
		this.aktywacja_mocy = aktywacja_mocy;
	}

	public void setDezaktywacjaTura(int dezaktywacja_tura) {
		this.dezaktywacja_tura = dezaktywacja_tura;
	}

	public void mocAktywna() {
		if (y > 0 && swiat.czyZajete(x, y - 1) == 1 && swiat.czyObokJestBarszcz(x, y - 1) == 1)
		{
			swiat.smiercOrganizmu_x_y(x, y - 1);
			komentator.dajInformacje(this.nazwa + " niszczy organizm obok dzieki CALOPALENIU " + '\n');
		}
		if (y < swiat.getWysokosc() - 1 && swiat.czyZajete(x, y + 1) == 1 && swiat.czyObokJestBarszcz(x, y + 1) == 1)
		{
			swiat.smiercOrganizmu_x_y(x, y + 1);
			komentator.dajInformacje(this.nazwa + " niszczy organizm obok dzieki CALOPALENIU " + '\n');
		}
		if (x > 0 && swiat.czyZajete(x - 1, y) == 1 && swiat.czyObokJestBarszcz(x - 1, y) == 1) 
		{
			swiat.smiercOrganizmu_x_y(x - 1, y);
			komentator.dajInformacje(this.nazwa + " niszczy organizm obok dzieki CALOPALENIU " + '\n');
		}
		if (x < swiat.getSzerokosc() - 1 && swiat.czyZajete(x + 1, y) == 1 && swiat.czyObokJestBarszcz(x + 1, y) == 1) 
		{
			swiat.smiercOrganizmu_x_y(x + 1, y);
			komentator.dajInformacje(this.nazwa + " niszczy organizm obok dzieki CALOPALENIU " + '\n');
		}
		moc_tura++;
		setMocTura(moc_tura);
		if (moc_tura == 5)
		{
			komentator.dajInformacje(this.nazwa + " czas jego umiejetnosci CALOPALENIA skonczyl sie " + '\n');
			moc_tura = 0;
			aktywacja_mocy = 0;
			setMocTura(moc_tura);
			setAktywacjaMocy(aktywacja_mocy);
		}
	}

	@Override
	public void rozmnazanie() {

	}

	public void lewo() {
		this.x = this.x - 1;
	}

	public void prawo() {
		this.x = this.x + 1;
	}

	public void gora() {
		this.y = this.y - 1;
	}

	public void dol() {
		this.y = this.y + 1;
	}

	@Override
	public void akcja() {
		int dzialanie = 5 - getDezaktywacjaTura();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				frame.dispose();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				kliknieto = 1;
				int klawisz = e.getKeyCode();

				if (klawisz == KeyEvent.VK_UP) 
				{
					if (y > 0)
					{
						gora();
						if (aktywacja_mocy == 1)
						{
							mocAktywna();
						}
					}
				} else if (klawisz == KeyEvent.VK_DOWN) 
				{
					if (y < swiat.getWysokosc() - 1)
					{
						dol();
						if (aktywacja_mocy == 1)
						{
							mocAktywna();
						}
					}
				} 
				else if (klawisz == KeyEvent.VK_LEFT) 
				{
					if (x > 0) 
					{
						lewo();
						if (aktywacja_mocy == 1)
						{
							mocAktywna();
						}
					}
				} 
				else if (klawisz == KeyEvent.VK_RIGHT) 
				{
					if (x < swiat.getSzerokosc() - 1) 
					{
						prawo();
						if (aktywacja_mocy == 1) 
						{
							mocAktywna();
						}
					}
				} 
				else if (moc_tura == 0 && dezaktywacja_tura >= 5 && klawisz == KeyEvent.VK_C) 
				{
					komentator.dajInformacje("Czlowiek uruchomil swoja umiejetnosc CALOPALENIE " + '\n');
					aktywacja_mocy = 1;
					dezaktywacja_tura = 0;
					setAktywacjaMocy(aktywacja_mocy);
					setDezaktywacjaTura(dezaktywacja_tura);
				}
			}
		});
		this.poprzedni_x = x;
		this.poprzedni_y = y;
		frame.setFocusTraversalKeysEnabled(false);
		frame.setFocusable(true);
		frame.setFocusableWindowState(true);

		komentator.dajInformacje("Podaj kierunek ruchu dla Czlowieka na poczatek tury " + '\n');

		if (dzialanie > 0 && aktywacja_mocy == 0) 
		{
			komentator.dajInformacje("Umiejetnosc CALOPALENIE bedzie do aktywowania za "+ (char) (dzialanie + 48) + " tur" + '\n');
		} 
		else if (dzialanie == 0 && aktywacja_mocy == 0) 
		{
			komentator.dajInformacje(this.nazwa + " jego umiejetnosc CALOPALENIE mozna aktywowac " + '\n');
		}

		if (aktywacja_mocy == 0) 
		{
			dezaktywacja_tura++;
			setDezaktywacjaTura(dezaktywacja_tura);
		}
	}
}
