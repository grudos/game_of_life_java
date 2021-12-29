package projekt.swiat;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Komentator extends JFrame {
	protected int linie_informacje;
	protected String[] informacje = new String[10];
	protected JLabel lInformacje[] = new JLabel[10];
	protected int szerokosc, wysokosc;
	protected Swiat swiat;

	public Komentator(int szerokosc, int wysokosc) {
		setLinieInformacje(0);
		setSzerokosc(szerokosc);
		setWysokosc(wysokosc);
	}

	public void dajInformacje(String tekst) {
		linie_informacje++;
		if (linie_informacje <= 10) {
			informacje[linie_informacje - 1] = tekst;
		} else {
			for (int i = 1; i < 10; i++) {
				informacje[i - 1] = informacje[i];
			}
			linie_informacje = 10;
			informacje[linie_informacje - 1] = tekst;
		}
	}

	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public void setWysokosc(int wysokosc) {
		this.wysokosc = wysokosc;
	}

	public void setLinieInformacje(int linie_informacje) {
		this.linie_informacje = linie_informacje;
	}

	public void setSwiat(Swiat swiat) {
		this.swiat = swiat;
	}

	public int getSzerokosc() {
		return szerokosc;
	}

	public int getWysokosc() {
		return wysokosc;
	}

	public int getLinieInformacje() {
		return linie_informacje;
	}

	public void wypiszInformacje() {
		for (int l = 0; l < getLinieInformacje(); l++)
		{
			lInformacje[l] = new JLabel("", SwingConstants.CENTER);
			lInformacje[l].setBounds(getSzerokosc() * 25 + 75, (l + 1) * 25, 400, 25);
			lInformacje[l].setForeground(Color.black);
			lInformacje[l].setBackground(Color.white);
			lInformacje[l].setOpaque(true);
			swiat.add(lInformacje[l]);
			lInformacje[l].setText(informacje[l]);
		}
	}
}
