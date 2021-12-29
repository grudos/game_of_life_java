package projekt.swiat;

public abstract class Organizm {

	protected int sila;
	protected int inicjatywa;
	protected int x;
	protected int y;
	protected int poprzedni_x;
	protected int poprzedni_y;
	protected int id;
	protected String nazwa;
	protected String symbol;
	protected Swiat swiat;
	protected Komentator komentator;

	public abstract void rozmnazanie();

	public abstract void akcja();

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSwiat(Swiat swiat) {
		this.swiat = swiat;
	}

	public void setKomentator(Komentator komentator) {
		this.komentator = komentator;
	}

	public void setOrganizmSila(int sila) {
		this.sila = sila;
	}

	public void setOrganizmInicjatywa(int inicjatywa) {
		this.inicjatywa = inicjatywa;
	}

	public void setOrganizmPoprzedniX(int poprzedni_x) {
		this.poprzedni_x = poprzedni_x;
	}

	public void setOrganizmPoprzedniY(int poprzedni_y) {
		this.poprzedni_y = poprzedni_y;
	}

	public void setOrganizmSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setOrganizmNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPoprzedniX() {
		return poprzedni_x;
	}

	public int getPoprzedniY() {
		return poprzedni_y;
	}

	public int getID() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public int getInicjatywa() {
		return inicjatywa;
	}

	public int getOrganizmSila() {
		return sila;
	}

	public String getOrganizmSymbol() {
		return symbol;
	}

	public int kolizja(Organizm atakujacy) {
		if (atakujacy.getOrganizmSila() > this.sila) 
		{
			komentator.dajInformacje(this.nazwa + " zostal/a zniszczony/na przez " + atakujacy.getNazwa() + '\n');
			swiat.smiercOrganizmu(this.id);
			return -2;
		} 
		else if (atakujacy.getOrganizmSila() < this.sila) 
		{
			komentator.dajInformacje(atakujacy.getNazwa() + " zostal/a zniszczony/na przez " + this.nazwa + '\n');
			swiat.smiercOrganizmu(atakujacy.getID());
			return -1;
		} 
		else if (atakujacy.getID() < this.id) 
		{
			komentator.dajInformacje(this.nazwa + " zostal/a zniszczony/na przez " + atakujacy.getNazwa() + '\n');
			swiat.smiercOrganizmu(this.id);
			return -1;
		} 
		else 
		{
			komentator.dajInformacje(atakujacy.getNazwa() + " zostal/a zniszczony/na przez " + this.nazwa + '\n');
			swiat.smiercOrganizmu(atakujacy.getID());
			return -2;
		}
	}
}
