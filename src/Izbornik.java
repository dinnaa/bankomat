
import java.util.ArrayList;
import java.util.Scanner;

// uz koristenje aplikacije od Amre Selimovic //
public class Izbornik {
	public static ArrayList<Racun> racuni = new ArrayList<Racun>();
	static Scanner input = new Scanner(System.in);
	public static void option() {
		System.out.println("Izaberite opciju koju zelite(1,2 ili 3): ");
		System.out.println("1-Kreiranje racuna, 2-Transfer novca, 3-Ispis racuna");
		int biranjeOpcije = input.nextInt();
		while (biranjeOpcije != 1 && biranjeOpcije != 2 && biranjeOpcije != 3) {
			System.out.println("Izaberite tacnu opciju");
			biranjeOpcije = input.nextInt();
		}
		switch (biranjeOpcije) {
		case 1:
			kreiranjeRacuna();break;
		case 2:
			transferNovca();break;
		case 3:
			ispisRacuna();break;
		}
	}
	public static void kreiranjeRacuna() {
		Racun racun = new Racun();
		System.out.println("Unesite broj racuna(broj racuna mora imati 6 cifara) ");
		long brojRacuna = input.nextInt();
		while (brojRacuna <= 0 || brojRacuna<100000|| brojRacuna>=1000000) {
			System.out.println("Morate unijeti pozitivan broj sa 6 cifara.  ");
			brojRacuna = input.nextInt();
		}
		while (iskoristenBroj(brojRacuna)) {
			System.out.println("Upisani broj je zauzet.Unesite novi broj racuna.");
			brojRacuna = input.nextInt();
		}
		racun.setBrojRacuna(brojRacuna);
		System.out.println("Unesite vase ime:");
		String ime = input.next();
		racun.setImeVlasnika(ime);
		System.out.println("Da bi se racun aktivirao, morate uplatiti neki iznos. Unesite iznos koji uplacujete. ");
		double uplata=input.nextDouble();
		while (uplata<=0) {
			System.out.println("Iznos koji uplacujete mora biti pozitivan. ");
			uplata=input.nextDouble();
		}
		racun.dodajNovac(uplata);
		racuni.add(Racun.getbrojRacunaUkupno() - 1, racun);
		System.out.println("Racun je uspjesno kreiran.");
		System.out.println("Broj vaseg racuna je: " + racun.getBrojRacuna());
		option();
	}
	public static void transferNovca() {
		transferNovca transfer = new transferNovca();
		System.out.println("Unesite broj racuna sa kojeg zelite izvrsiti transfer");
		int sourceAcc = input.nextInt();
		transfer.setIzvorniRacun(sourceAcc);
		System.out.println("Unesite broj racuna na koji zelite prebaciti novac: ");
		int targetAcc = input.nextInt();
		transfer.setTargetRacun(targetAcc);
		System.out.println("Unesite iznos novca koji zelite prebaciti.  ");
		double iznosNovca=input.nextDouble();
		while (iznosNovca<=0) {
			System.out.println("Iznos novca mora biti pozitivan.");
			iznosNovca = input.nextDouble();
		}
		transfer.setIznosZaPrebacivanje(iznosNovca);
		if (transfer.provjeriValidnost()) {
			transfer.izvrsiTransfer();
			System.out.println("Transfer je uspjesno izvrsen.");
		} else {
			System.out.println("Transfer nije uspjesno izvrsen.");
		}
		option();
	}
	public static void ispisRacuna() {
		System.out.println("Unesite broj racuna: ");
		int broj = input.nextInt();
		while (broj<=0) {
			System.out.println("Unesite ispravan unos racuna: ");
			broj = input.nextInt();
		}
		Racun.ispisRacuna(broj);
		option();
	}
	public static boolean iskoristenBroj(long broj) {
		for(int i=0;i<racuni.size();i++) {
			if(racuni.get(i).getBrojRacuna()==broj)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		option();
	}
}