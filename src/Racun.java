

public class Racun extends Izbornik {
	private long brojRacuna;
	private String ime;
	public double trenutnoStanjeRacuna;
	private static int brojSvihRacuna;

	public Racun() {
		brojSvihRacuna++;
	}
	public Racun(double trenutnoStanjeRacuna) {
		this.trenutnoStanjeRacuna = trenutnoStanjeRacuna;
	}
	public static int getbrojRacunaUkupno() {
		return brojSvihRacuna;
	}
	public long getBrojRacuna() {
		return brojRacuna;
	}
	public void setBrojRacuna(long brojRacuna) {
		this.brojRacuna = brojRacuna;
	}
	public String getImeVlasnika() {
		return ime;
	}
	public void setImeVlasnika(String imeVlasnika) {
		this.ime = imeVlasnika;
	}
	public double getTrenutnoStanjeRacuna() {
		return trenutnoStanjeRacuna;
	}
	public void dodajNovac(double iznos) {
		trenutnoStanjeRacuna=trenutnoStanjeRacuna+iznos;
	}
	public static void ispisRacuna(int brojRacuna) {
		for(int i=0;i<racuni.size();i++)
			if (racuni.get(i).brojRacuna==brojRacuna) {
				System.out.println(racuni.get(i).toString());
				return;
			}
		System.out.println("Unijeti racun nije pronadjen.");
	}
	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + ime + "\n Trenutno stanje: "
				+ trenutnoStanjeRacuna;
	}
}
