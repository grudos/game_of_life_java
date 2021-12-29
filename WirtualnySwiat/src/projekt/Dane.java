package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekt.swiat.Swiat;

public class Dane extends JFrame implements ActionListener {

	private JButton bZapisz, bWczytaj;
	private JLabel lSzerokosc, lWysokosc;
	private JTextField tfSzerokosc, tfWysokosc;
	private int szerokosc, wysokosc;

	public Dane() {
		setSize(400, 250);
		setTitle("Wirtualny Swiat - konfiguracja");
		setLayout(null);

		lSzerokosc = new JLabel("Podaj szerokosc: ");
		lSzerokosc.setBounds(20, 20, 100, 30);
		lSzerokosc.setOpaque(true);
		add(lSzerokosc);

		tfSzerokosc = new JTextField("");
		tfSzerokosc.setBounds(150, 20, 150, 30);
		add(tfSzerokosc);

		lWysokosc = new JLabel("Podaj wysokosc: ");
		lWysokosc.setBounds(20, 80, 100, 30);
		lWysokosc.setOpaque(true);
		add(lWysokosc);

		tfWysokosc = new JTextField("");
		tfWysokosc.setBounds(150, 80, 150, 30);
		add(tfWysokosc);

		bZapisz = new JButton("Zapisz");
		bZapisz.setBounds(20, 160, 100, 30);
		add(bZapisz);
		bZapisz.addActionListener(this);

		bWczytaj = new JButton("Wczytaj");
		bWczytaj.setBounds(120, 160, 100, 30);
		add(bWczytaj);
		bWczytaj.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Przycisk = e.getSource();
		if (Przycisk == bZapisz) 
		{
			szerokosc = Integer.parseInt(tfSzerokosc.getText());
			wysokosc = Integer.parseInt(tfWysokosc.getText());
			Swiat swiat = new Swiat(szerokosc, wysokosc, 0);
			swiat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			swiat.setVisible(true);
			setVisible(false);
		} 
		else if (Przycisk == bWczytaj) 
		{
			File plik = new File("symulacja.txt");
			Scanner dane;
			try {
				dane = new Scanner(plik);
				String linia = dane.nextLine();
				String[] zmienne = linia.split(" ");
				szerokosc = Integer.parseInt(zmienne[0]);
				wysokosc = Integer.parseInt(zmienne[1]);
				dane.close();
				Swiat swiat = new Swiat(szerokosc, wysokosc, 1);
				swiat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				swiat.setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
