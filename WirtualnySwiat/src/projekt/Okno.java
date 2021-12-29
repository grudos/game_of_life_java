package projekt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import projekt.swiat.Swiat;

public class Okno extends JFrame implements ActionListener {

	private JButton bBarszczSosnowskiego, bGuarana, bMlecz, bTrawa, bWilczeJagody;
	private JButton bAntylopa, bCyberOwca, bCzlowiek, bLis, bOwca, bWilk, bZolw;
	private JLabel lRoslina, lZwierze, lCzlowiek;
	private Swiat swiat;
	private int mX, mY;

	public Okno(int mX, int mY) {
		setmX(mX);
		setmY(mY);

		setSize(460, 500);
		setTitle("Wirtualny Swiat - dodaj Organizm");
		setLayout(null);

		lRoslina = new JLabel("Dodaj rosline: ", SwingConstants.CENTER);
		lRoslina.setBounds(25, 30, 375, 30);
		lRoslina.setOpaque(true);
		lRoslina.setFont(new Font("Calibri", Font.BOLD, 20));
		add(lRoslina);

		bBarszczSosnowskiego = new JButton("Barszcz Sosnowskiego");
		bBarszczSosnowskiego.setBounds(50, 90, 175, 30);
		add(bBarszczSosnowskiego);
		bBarszczSosnowskiego.addActionListener(this);

		bWilczeJagody = new JButton("Wilcze Jagody");
		bWilczeJagody.setBounds(250, 90, 150, 30);
		add(bWilczeJagody);
		bWilczeJagody.addActionListener(this);

		bGuarana = new JButton("Guarana");
		bGuarana.setBounds(50, 150, 100, 30);
		add(bGuarana);
		bGuarana.addActionListener(this);

		bMlecz = new JButton("Mlecz");
		bMlecz.setBounds(175, 150, 100, 30);
		add(bMlecz);
		bMlecz.addActionListener(this);

		bTrawa = new JButton("Trawa");
		bTrawa.setBounds(300, 150, 100, 30);
		add(bTrawa);
		bTrawa.addActionListener(this);

		lZwierze = new JLabel("Dodaj zwierze: ", SwingConstants.CENTER);
		lZwierze.setBounds(25, 210, 375, 30);
		lZwierze.setOpaque(true);
		lZwierze.setFont(new Font("Calibri", Font.BOLD, 20));
		add(lZwierze);

		lCzlowiek = new JLabel("Na planszy moze znajdowac sie tylko jeden Czlowiek.", SwingConstants.CENTER);
		lCzlowiek.setBounds(25, 235, 375, 30);
		lCzlowiek.setOpaque(true);
		lCzlowiek.setFont(new Font("Calibri", Font.BOLD, 12));
		add(lCzlowiek);

		bAntylopa = new JButton("Antylopa");
		bAntylopa.setBounds(50, 270, 100, 30);
		add(bAntylopa);
		bAntylopa.addActionListener(this);

		bCyberOwca = new JButton("CyberOwca");
		bCyberOwca.setBounds(175, 270, 100, 30);
		add(bCyberOwca);
		bCyberOwca.addActionListener(this);

		bCzlowiek = new JButton("Czlowiek");
		bCzlowiek.setBounds(300, 270, 100, 30);
		add(bCzlowiek);
		bCzlowiek.addActionListener(this);

		bLis = new JButton("Lis");
		bLis.setBounds(50, 330, 100, 30);
		add(bLis);
		bLis.addActionListener(this);

		bOwca = new JButton("Owca");
		bOwca.setBounds(175, 330, 100, 30);
		add(bOwca);
		bOwca.addActionListener(this);

		bWilk = new JButton("Wilk");
		bWilk.setBounds(300, 330, 100, 30);
		add(bWilk);
		bWilk.addActionListener(this);

		bZolw = new JButton("Zolw");
		bZolw.setBounds(50, 390, 100, 30);
		add(bZolw);
		bZolw.addActionListener(this);

	}

	public int getmX() {
		return mX;
	}

	public int getmY() {
		return mY;
	}

	public void setmX(int mX) {
		this.mX = mX;
	}

	public void setmY(int mY) {
		this.mY = mY;
	}

	public void setSwiat(Swiat swiat) {
		this.swiat = swiat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Przycisk = e.getSource();
		if (Przycisk == bBarszczSosnowskiego)
		{
			swiat.dodajOrganizm(getmX(), getmY(), "b");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bWilczeJagody) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "j");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bGuarana) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "g");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bMlecz) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "m");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bTrawa) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "t");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bAntylopa) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "A");
			setVisible(false);
			dispose();
		}
		else if (Przycisk == bCyberOwca) {
			swiat.dodajOrganizm(getmX(), getmY(), "$");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bCzlowiek) 
		{
			if (swiat.getJestCzlowiek() == 0) 
			{
				swiat.dodajOrganizm(getmX(), getmY(), "C");
				setVisible(false);
				dispose();
			}
		} 
		else if (Przycisk == bLis) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "L");
			setVisible(false);
			dispose();
		}
		else if (Przycisk == bOwca) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "O");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bWilk) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "W");
			setVisible(false);
			dispose();
		} 
		else if (Przycisk == bZolw) 
		{
			swiat.dodajOrganizm(getmX(), getmY(), "Z");
			setVisible(false);
			dispose();
		}
	}
}
