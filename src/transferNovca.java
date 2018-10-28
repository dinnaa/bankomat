

public class transferNovca extends Racun {

	private int izvorniRacun;
	private int targetRacun;
	private double iznosZaPrebacivanje;

	public transferNovca() {
	}
	public int getIzvorniRacun() {
		return izvorniRacun;
	}
	public void setIzvorniRacun(int izvorniRacun) {
		this.izvorniRacun = izvorniRacun;
	}
	public int getTargetRacun() {
		return targetRacun;
	}
	public void setTargetRacun(int targetRacun) {
		this.targetRacun = targetRacun;
	}
	public double getIznosZaPrebacivanje() {
		return iznosZaPrebacivanje;
	}
	public void setIznosZaPrebacivanje(double iznosZaPrebacivanje) {
		this.iznosZaPrebacivanje = iznosZaPrebacivanje;
	}
	public boolean provjeriValidnost() {
		boolean izvorniPostoji = false;
		boolean targetPostoji = false;
		boolean dovoljnoNovca = false;
		for (int i=0;i<racuni.size();i++) {
			if (racuni.get(i).getBrojRacuna()==izvorniRacun) {
				izvorniPostoji = true;
				if ((racuni.get(i).trenutnoStanjeRacuna - iznosZaPrebacivanje)>=0)
					dovoljnoNovca=true;
			}
			if (racuni.get(i).getBrojRacuna()==targetRacun)
				targetPostoji = true;
		}
		if (!izvorniPostoji) {
			System.out.println("Unijeti broj racuna za slanje ne postoji.");
			return false;
		}
		else if (!targetPostoji) {
			System.out.println("Unijeti broj racuna za primanje ne postoji.");
			return false;
		}
		else if (!dovoljnoNovca) {
			System.out.println("Nema dovoljno novca za transfer.");
			return false;
		}
		else if (!izvorniPostoji || !targetPostoji || !dovoljnoNovca)
			return false;
		else
			return true;
	}
	public void izvrsiTransfer() {
		for (int i=0;i<racuni.size();i++) {
			if (racuni.get(i).getBrojRacuna() == izvorniRacun)
				racuni.get(i).trenutnoStanjeRacuna -= iznosZaPrebacivanje;
			if (racuni.get(i).getBrojRacuna() == targetRacun)
				racuni.get(i).trenutnoStanjeRacuna += iznosZaPrebacivanje;
		}
	}
}
