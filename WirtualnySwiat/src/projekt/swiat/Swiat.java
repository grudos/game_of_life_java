package projekt.swiat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import projekt.Okno;
import projekt.swiat.organizmy.rosliny.BarszczSosnowskiego;
import projekt.swiat.organizmy.rosliny.Guarana;
import projekt.swiat.organizmy.rosliny.Mlecz;
import projekt.swiat.organizmy.rosliny.Trawa;
import projekt.swiat.organizmy.rosliny.WilczeJagody;
import projekt.swiat.organizmy.zwierzeta.Antylopa;
import projekt.swiat.organizmy.zwierzeta.CyberOwca;
import projekt.swiat.organizmy.zwierzeta.Czlowiek;
import projekt.swiat.organizmy.zwierzeta.Lis;
import projekt.swiat.organizmy.zwierzeta.Owca;
import projekt.swiat.organizmy.zwierzeta.Wilk;
import projekt.swiat.organizmy.zwierzeta.Zolw;

public class Swiat extends JFrame implements ActionListener {

	private int szerokosc;
	private int wysokosc;
	private int zapis;
	private int ID_swiata;
	private int tworzenie;
	private int tura = 0;
	private int koniec_tury;
	private int jest_czlowiek = 0;
	private Vector<Vector<String>> plansza = new Vector<Vector<String>>();
	private Vector<Organizm> organizmy = new Vector<Organizm>();
	private JLabel pole[][];
	private Komentator komentator;
	private JButton bNowaTura, bZapis;
	private JLabel label, label2, label3;
	private int oknoSzerokosc, oknoWysokosc;

	public Swiat(int szerokosc, int wysokosc, int zapis) {
		setSzerokosc(szerokosc);
		setWysokosc(wysokosc);
		pole = new JLabel[wysokosc][szerokosc];

		for (int i = 0; i < wysokosc; i++) 
		{
			plansza.addElement(new Vector<String>(szerokosc));
		}

		if (szerokosc <= 12 && wysokosc <= 12) 
		{
			oknoSzerokosc = 750;
			oknoWysokosc = 300;
		} 
		else if (szerokosc > 12 && wysokosc > 12) 
		{
			oknoSzerokosc = 450 + szerokosc * 25;
			oknoWysokosc = wysokosc * 25;
		} 
		else if (szerokosc <= 12 && wysokosc > 12)
		{
			oknoSzerokosc = 750;
			oknoWysokosc = wysokosc * 25;
		} 
		else if (szerokosc > 12 && wysokosc <= 12) 
		{
			oknoSzerokosc = 750 + szerokosc * 25;
			oknoWysokosc = 300;
		}

		komentator = new Komentator(szerokosc, wysokosc);
		komentator.setSwiat(this);

		setSize(oknoSzerokosc + 75, oknoWysokosc + 125);
		setTitle("Wirtualny Swiat - symulacja");
		setLayout(null);
		
		bNowaTura = new JButton("Nowa tura");
		bNowaTura.setBounds(25, oknoWysokosc + 40, 100, 30);
		add(bNowaTura);
		bNowaTura.addActionListener(this);

		bZapis = new JButton("Zapis");
		bZapis.setBounds(125, oknoWysokosc + 40, 100, 30);
		add(bZapis);
		bZapis.addActionListener(this);

		label = new JLabel();
		label.setBounds(25, 25, szerokosc * 25, wysokosc * 25);
		label.setForeground(Color.black);
		label.setBackground(Color.white);
		label.setOpaque(true);
		add(label);

		label2 = new JLabel();
		label2.setBounds(szerokosc * 25 + 75, 25, 400, 250);
		label2.setForeground(Color.black);
		label2.setBackground(Color.white);
		label2.setOpaque(true);
		add(label2);

		label3 = new JLabel("", SwingConstants.CENTER);
		label3.setBounds(szerokosc * 25 + 75, 300, 400, 25);
		label3.setForeground(Color.black);
		label3.setOpaque(true);
		label3.setText("Jakub Grudowski, 180319");
		add(label3);

		setZapis(zapis);
		setTworzenie(1);
		setKoniecTury(0);
		wykonajTure();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Przycisk = e.getSource();
		if (Przycisk == bNowaTura) 
		{
			setKoniecTury(0);
			wykonajTure();
		}
		else if (Przycisk == bZapis) 
		{
			File plik = new File("symulacja.txt");
			try {
				PrintWriter dane = new PrintWriter(plik);
				dane.println(getSzerokosc() + " " + getSzerokosc() + " " + organizmy.size());

				for (int k = 0; k < organizmy.size(); ++k) 
				{
					if (organizmy.get(k) instanceof Czlowiek) 
					{
						Czlowiek c = (Czlowiek) organizmy.get(k);
						dane.println(organizmy.get(k).getOrganizmSymbol() + " " + organizmy.get(k).getOrganizmSila()
								+ " " + organizmy.get(k).getInicjatywa() + " " + organizmy.get(k).getX() + " "
								+ organizmy.get(k).getY() + " " + organizmy.get(k).getPoprzedniX() + " "
								+ organizmy.get(k).getPoprzedniY() + " " + organizmy.get(k).getID() + " "
								+ c.getMocTura() + " " + c.getAktywacjaMocy() + " " + c.getDezaktywacjaTura());
					}
					else 
					{
						dane.println(organizmy.get(k).getOrganizmSymbol() + " " + organizmy.get(k).getOrganizmSila()
								+ " " + organizmy.get(k).getInicjatywa() + " " + organizmy.get(k).getX() + " "
								+ organizmy.get(k).getY() + " " + organizmy.get(k).getPoprzedniX() + " "
								+ organizmy.get(k).getPoprzedniY() + " " + organizmy.get(k).getID());
					}
				}
				dane.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setZapis(int zapis) {
		this.zapis = zapis;
	}

	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public void setWysokosc(int wysokosc) {
		this.wysokosc = wysokosc;
	}

	public void setKoniecTury(int koniec_tury) {
		this.koniec_tury = koniec_tury;
	}

	public void setTworzenie(int tworzenie) {
		this.tworzenie = tworzenie;
	}

	public void setTura(int tura) {
		this.tura = tura;
	}

	public void setJestCzlowiek(int jest_czlowiek) {
		this.jest_czlowiek = jest_czlowiek;
	}

	public void setID_swiata(int ID_swiata) {
		this.ID_swiata = ID_swiata;
	}

	public int getSzerokosc() {
		return this.szerokosc;
	}

	public int getWysokosc() {
		return this.wysokosc;
	}

	public int getZapis() {
		return this.zapis;
	}

	public int getKoniecTury() {
		return koniec_tury;
	}

	public int getTworzenie() {
		return tworzenie;
	}

	public int getTura() {
		return this.tura;
	}

	public int getJestCzlowiek() {
		return this.jest_czlowiek;
	}

	public int getID_swiata() {
		return this.ID_swiata;
	}

	public int getSila(int x, int y) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (organizmy.get(i).getX() == x && organizmy.get(i).getY() == y) 
			{
				return organizmy.get(i).getOrganizmSila();
			}
		}
		return -1;
	}

	public String getSymbol(int x, int y) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (organizmy.get(i).getX() == x && organizmy.get(i).getY() == y) 
			{
				return organizmy.get(i).getOrganizmSymbol();
			}
		}
		return "";
	}

	public void smiercOrganizmu(int id) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (organizmy.get(i).getID() == id) 
			{
				if (organizmy.get(i).getOrganizmSymbol().equals("C")) 
				{
					setJestCzlowiek(0);
				}
			organizmy.remove(organizmy.get(i));
			break;
			}
		}
	}

	public void smiercOrganizmu_x_y(int x, int y) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (organizmy.get(i).getX() == x && organizmy.get(i).getY() == y) 
			{
				organizmy.remove(organizmy.get(i));
				break;
			}
		}
	}

	public void smiercOrganizmuBarszcz(int x, int y) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (organizmy.get(i).getX() == x && organizmy.get(i).getY() == y
					&& (organizmy.get(i).getOrganizmSymbol().equals("A") || organizmy.get(i).getOrganizmSymbol().equals("C")
					|| organizmy.get(i).getOrganizmSymbol().equals("L") || organizmy.get(i).getOrganizmSymbol().equals("O")
					|| organizmy.get(i).getOrganizmSymbol().equals("W")|| organizmy.get(i).getOrganizmSymbol().equals("Z"))) 
			{
				komentator.dajInformacje("Barszcz Sosnowskiego niszczy organizm obok \n");
				if (organizmy.get(i).getOrganizmSymbol().equals("C")) 
				{
					setJestCzlowiek(0);
				}
				organizmy.remove(organizmy.get(i));
				break;
			}
		}
	}

	public void stworzOrganizm(Organizm nowy) {
		this.ID_swiata = nowy.getID();
		this.ID_swiata++;
		organizmy.addElement(nowy);
		organizmy.lastElement().setSwiat(this);
		organizmy.lastElement().setKomentator(komentator);
	}

	public void stworzOrganizmPlik(String symbol, int sila, int inicjatywa, int x, int y, int poprzedni_x,int poprzedni_y, int id) 
	{
		if (symbol.equals("A")) 
		{
			organizmy.addElement(new Antylopa(x, y, id));
		} 
		else if (symbol.equals("b")) 
		{
			organizmy.addElement(new BarszczSosnowskiego(x, y, id));
		} 
		else if (symbol.equals("g")) 
		{
			organizmy.addElement(new Guarana(x, y, id));
		} 
		else if (symbol.equals("L")) 
		{
			organizmy.addElement(new Lis(x, y, id));
		} 
		else if (symbol.equals("m")) 
		{
			organizmy.addElement(new Mlecz(x, y, id));
		}
		else if (symbol.equals("O")) 
		{
			organizmy.addElement(new Owca(x, y, id));
		} 
		else if (symbol.equals("t")) 
		{
			organizmy.addElement(new Trawa(x, y, id));
		} 
		else if (symbol.equals("j")) 
		{
			organizmy.addElement(new WilczeJagody(x, y, id));
		} 
		else if (symbol.equals("W")) 
		{
			organizmy.addElement(new Wilk(x, y, id));
		} 
		else if (symbol.equals("Z")) 
		{
			organizmy.addElement(new Zolw(x, y, id));
		} 
		else if (symbol.equals("$")) 
		{
			organizmy.addElement(new Zolw(x, y, id));
		}

		organizmy.lastElement().setSwiat(this);
		organizmy.lastElement().setKomentator(komentator);
		organizmy.lastElement().setOrganizmSila(sila);
		organizmy.lastElement().setOrganizmInicjatywa(inicjatywa);
		organizmy.lastElement().setOrganizmPoprzedniX(poprzedni_x);
		organizmy.lastElement().setOrganizmPoprzedniY(poprzedni_y);
		organizmy.lastElement().setOrganizmSymbol(symbol);
	}

	public void stworzCzlowiekPlik(String symbol, int sila, int inicjatywa, int x, int y, int poprzedni_x,
			int poprzedni_y, int id, int moc_tura, int aktywacja_mocy, int dezaktywacja_tura) 
	{
		Czlowiek c = new Czlowiek(x, y, id);
		c.setSwiat(this);
		c.setKomentator(komentator);
		c.setOrganizmNazwa("Czlowiek");
		c.setOrganizmSila(sila);
		c.setOrganizmInicjatywa(inicjatywa);
		c.setOrganizmPoprzedniX(poprzedni_x);
		c.setOrganizmPoprzedniY(poprzedni_y);
		c.setOrganizmSymbol(symbol);
		c.setMocTura(moc_tura);
		c.setAktywacjaMocy(aktywacja_mocy);
		c.setDezaktywacjaTura(dezaktywacja_tura);
		organizmy.addElement(c);
		setJestCzlowiek(1);
	}

	public int czyZajete(int x, int y) {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			if (x == organizmy.get(i).getX() && y == organizmy.get(i).getY()) 
			{
				return 1;
			}
		}
		return 0;
	}

	public int czyObokJestBarszcz(int x, int y) 
	{
		if (plansza.get(y).get(x).equals("b")) 
		{
			return 0;
		} 
		else 
		{
			return 1;
		}
	}

	public void stworzOrganizmy() {
		int organizm = 1;
		Random r = new Random();
		Random o = new Random();
		int ile_organizmow = (szerokosc + wysokosc) / 2;
		int liczba_organizmow = r.nextInt(szerokosc / 2) + ile_organizmow;
		int x = 0;
		int y = 0;

		x = r.nextInt(szerokosc);
		y = r.nextInt(wysokosc);

		organizmy.addElement(new Czlowiek(x, y, ID_swiata));
		organizmy.lastElement().setSwiat(this);
		organizmy.lastElement().setKomentator(komentator);
		ID_swiata++;
		setJestCzlowiek(1);

		x = 0;
		y = 0;

		for (int i = 0; i < liczba_organizmow; i++) 
		{
			organizm = o.nextInt(11) + 1;
			while (true) 
			{
				x = r.nextInt(szerokosc);
				y = r.nextInt(wysokosc);
				if (czyZajete(x, y) != 1) 
				{
					break;
				}
			}

			if (organizm == 1)
			{
				organizmy.addElement(new Wilk(x, y, ID_swiata));
				ID_swiata++;
			}
			else if (organizm == 2)
			{
				organizmy.addElement(new Owca(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 3) 
			{
				organizmy.addElement(new Lis(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 4) 
			{
				organizmy.addElement(new Zolw(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 5) 
			{
				organizmy.addElement(new Antylopa(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 6)
			{
				organizmy.addElement(new Trawa(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 7)
			{
				organizmy.addElement(new Mlecz(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 8) 
			{
				organizmy.addElement(new Guarana(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 9) 
			{
				organizmy.addElement(new WilczeJagody(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 10)
			{
				organizmy.addElement(new BarszczSosnowskiego(x, y, ID_swiata));
				ID_swiata++;
			} 
			else if (organizm == 11)
			{
				organizmy.addElement(new CyberOwca(x, y, ID_swiata));
				ID_swiata++;
			}
			organizmy.lastElement().setSwiat(this);
			organizmy.lastElement().setKomentator(komentator);
		}
	}

	public void dodajOrganizm(int x, int y, String symbol) {
		if (symbol.equals("b"))
		{
			organizmy.addElement(new BarszczSosnowskiego(x, y, ID_swiata));
		} 
		else if (symbol.equals("g")) 
		{
			organizmy.addElement(new Guarana(x, y, ID_swiata));
		} 
		else if (symbol.equals("m"))
		{
			organizmy.addElement(new Mlecz(x, y, ID_swiata));
		} 
		else if (symbol.equals("t"))
		{
			organizmy.addElement(new Trawa(x, y, ID_swiata));
		} 
		else if (symbol.equals("j"))
		{
			organizmy.addElement(new WilczeJagody(x, y, ID_swiata));
		} 
		else if (symbol.equals("A")) 
		{
			organizmy.addElement(new Antylopa(x, y, ID_swiata));
		} 
		else if (symbol.equals("$"))
		{
			organizmy.addElement(new CyberOwca(x, y, ID_swiata));
		} 
		else if (symbol.equals("C"))
		{
			organizmy.addElement(new Czlowiek(x, y, ID_swiata));
			setJestCzlowiek(1);
		} 
		else if (symbol.equals("L"))
		{
			organizmy.addElement(new Lis(x, y, ID_swiata));
		} 
		else if (symbol.equals("O"))
		{
			organizmy.addElement(new Owca(x, y, ID_swiata));
		} 
		else if (symbol.equals("W")) 
		{
			organizmy.addElement(new Wilk(x, y, ID_swiata));
		}
		else if (symbol.equals("Z")) 
		{
			organizmy.addElement(new Zolw(x, y, ID_swiata));
		}
		organizmy.lastElement().setSwiat(this);
		organizmy.lastElement().setKomentator(komentator);
		ID_swiata++;
	}

	public void klikniecie(int mX, int mY) {
		if (plansza.get(mY).get(mX).equals("-")) 
		{
			Okno okno = new Okno(mX, mY);
			okno.setSwiat(this);
			okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			okno.setVisible(true);
		}
	}

	public void stworzSwiat() {
		for (int i = 0; i < wysokosc; i++) 
		{
			for (int j = 0; j < szerokosc; j++)
			{
				plansza.get(i).add(new String("-"));
			}
		}
	}

	public void stworzSwiatTura() 
	{
		for (int i = 0; i < wysokosc; i++)
		{
			for (int j = 0; j < szerokosc; j++)
			{
				plansza.get(i).set(j, "-");
			}
		}

	}

	public void rysujSwiat() {
		for (int i = 0; i < organizmy.size(); ++i) 
		{
			int y = organizmy.get(i).getY();
			int x = organizmy.get(i).getX();
			String symbol = organizmy.get(i).getOrganizmSymbol();
			plansza.get(y).set(x, symbol);
		}

		for (int i = 0; i < wysokosc; i++) 
		{
			for (int j = 0; j < szerokosc; j++) 
			{
				if (plansza.get(i).get(j) != "-") 
				{
					if (pole[i][j] != null) 
					{
						remove(pole[i][j]);
					}
					pole[i][j] = new JLabel("", SwingConstants.CENTER);
					pole[i][j].setBounds((j + 1) * 25, (i + 1) * 25, 25, 25);
					pole[i][j].setForeground(Color.black);

					if (plansza.get(i).get(j).equals("A")) 
					{
						pole[i][j].setBackground(Color.gray);
					} 
					else if (plansza.get(i).get(j).equals("b")) 
					{
						pole[i][j].setBackground(Color.magenta);
					} 
					else if (plansza.get(i).get(j).equals("g"))
					{
						pole[i][j].setBackground(Color.red);
					}
					else if (plansza.get(i).get(j).equals("L"))
					{
						pole[i][j].setBackground(Color.orange);
					} 
					else if (plansza.get(i).get(j).equals("m"))
					{
						pole[i][j].setBackground(Color.yellow);
					}
					else if (plansza.get(i).get(j).equals("O"))
					{
						pole[i][j].setBackground(Color.lightGray);
					} 
					else if (plansza.get(i).get(j).equals("t")) 
					{
						pole[i][j].setBackground(Color.green);
					} 
					else if (plansza.get(i).get(j).equals("j"))
					{
						pole[i][j].setBackground(Color.blue);
					} 
					else if (plansza.get(i).get(j).equals("W")) 
					{
						pole[i][j].setBackground(Color.black);
						pole[i][j].setForeground(Color.white);
					}
					else if (plansza.get(i).get(j).equals("Z"))
					{
						pole[i][j].setBackground(Color.darkGray);
						pole[i][j].setForeground(Color.white);
					} 
					else if (plansza.get(i).get(j).equals("C"))
					{
						pole[i][j].setBackground(Color.pink);
					} 
					else if (plansza.get(i).get(j).equals("$")) 
					{
						pole[i][j].setBackground(Color.cyan);
					}

					pole[i][j].setOpaque(true);
					add(pole[i][j]);
					pole[i][j].setText(plansza.get(i).get(j));
					pole[i][j].revalidate();
					pole[i][j].repaint();

				}
				else 
				{
					if (pole[i][j] != null) 
					{
						remove(pole[i][j]);
					}
					pole[i][j] = new JLabel("", SwingConstants.CENTER);
					pole[i][j].setBounds((j + 1) * 25, (i + 1) * 25, 25, 25);
					pole[i][j].setForeground(Color.black);
					pole[i][j].setBackground(Color.white);
					pole[i][j].setOpaque(true);
					int MX = j;
					int MY = i;
					pole[i][j].addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) 
						{
							int mX = MX;
							int mY = MY;
							klikniecie(mX, mY);
						}
					});
					add(pole[i][j]);
					pole[i][j].setText(plansza.get(i).get(j));
					pole[i][j].revalidate();
					pole[i][j].repaint();
				}
			}
		}
	}

	public void wykonajTure() {
		setTura(tura + 1);
		int[] ostatni_ruch = new int[2];
		ostatni_ruch[0] = 99;
		ostatni_ruch[1] = 0;

		if (getTworzenie() == 1) 
		{
			if (getZapis() == 0) 
			{
				stworzSwiat();
				stworzOrganizmy();
			} 
			else if (getZapis() == 1) 
			{
				stworzSwiat();
				setZapis(0);
				File plik = new File("symulacja.txt");
				Scanner dane;
				try {

					dane = new Scanner(plik);

					String linia = dane.nextLine();
					String[] zmienne = linia.split(" ");
					int liczba_organizmow = 0;
					int sila = 0, inicjatywa = 0, x = 0, y = 0, poprzedni_x = 0, poprzedni_y = 0, id = 0;
					int moc_tura = 0, aktywacja_mocy = 0, dezaktywacja_tura = 0;
					String symbol = "";
					szerokosc = Integer.parseInt(zmienne[0]);
					wysokosc = Integer.parseInt(zmienne[1]);
					liczba_organizmow = Integer.parseInt(zmienne[2]);
					linia = dane.nextLine();

					for (int i = 0; i < liczba_organizmow; i++) 
					{
						zmienne = linia.split(" ");
						symbol = zmienne[0];
						sila = Integer.parseInt(zmienne[1]);
						inicjatywa = Integer.parseInt(zmienne[2]);
						x = Integer.parseInt(zmienne[3]);
						y = Integer.parseInt(zmienne[4]);
						poprzedni_x = Integer.parseInt(zmienne[5]);
						poprzedni_y = Integer.parseInt(zmienne[6]);
						id = Integer.parseInt(zmienne[7]);

						if (symbol.equals("C")) 
						{
							moc_tura = Integer.parseInt(zmienne[8]);
							aktywacja_mocy = Integer.parseInt(zmienne[9]);
							dezaktywacja_tura = Integer.parseInt(zmienne[10]);
							stworzCzlowiekPlik(symbol, sila, inicjatywa, x, y, poprzedni_x, poprzedni_y, id, moc_tura,
									aktywacja_mocy, dezaktywacja_tura);
						} 
						else
						{
							stworzOrganizmPlik(symbol, sila, inicjatywa, x, y, poprzedni_x, poprzedni_y, id);
						}
						if (i < liczba_organizmow - 1)
						{
							linia = dane.nextLine();
						}
					}
					dane.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			setTworzenie(0);
		}

		if (getTura() == 2) 
		{
			rysujSwiat();
		}

		int j = 0;
		int ktory_organizm = 1;
		int start = 1;
		while (getKoniecTury() == 0 && getTura() > 2) 
		{
			Collections.sort(organizmy, new sortowanieInicjatywa());
			j = 0;
			if (start == 1) 
			{
				ktory_organizm = 1;
				start = 0;
			}

			for (j = 0; j <= organizmy.size(); ++j) 
			{
				if (j == organizmy.size()) 
				{
					break;
				}

				if (organizmy.get(j).getInicjatywa() < ostatni_ruch[0])
				{
					ostatni_ruch[0] = organizmy.get(j).getInicjatywa();
					ostatni_ruch[1] = organizmy.get(j).getID();
					break;
				}
				else if (organizmy.get(j).getInicjatywa() == ostatni_ruch[0] && organizmy.get(j).getID() > ostatni_ruch[1]) 
				{
					ostatni_ruch[0] = organizmy.get(j).getInicjatywa();
					ostatni_ruch[1] = organizmy.get(j).getID();
					break;
				}
			}
			if (j >= organizmy.size()) 
			{
				ostatni_ruch[0] = 99;
				ostatni_ruch[1] = 0;
				continue;
			}
			stworzSwiatTura();
			organizmy.get(j).akcja();
			for (int k = 0; k < organizmy.size(); ++k)
			{
				if (k != j && organizmy.get(j).getX() == organizmy.get(k).getX() && organizmy.get(j).getY() == organizmy.get(k).getY())
				{
					int wynik = organizmy.get(k).kolizja(organizmy.get(j));
					if (wynik == 1)
					{
						organizmy.get(k).rozmnazanie();
					}
				}
			}
			komentator.wypiszInformacje();
			rysujSwiat();

			ktory_organizm++;
			if (ktory_organizm > organizmy.size()) 
			{
				setKoniecTury(1);
			}
		}
	}
}
