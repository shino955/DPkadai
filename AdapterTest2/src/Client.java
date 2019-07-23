
public class Client {
	public static void main(String[] args) {
		Dengen d;
		d = new AcAdapter();
		int denatsu = d.kyuuden();
		System.out.println( denatsu + "V で給電されています" );
	}
}

interface Dengen { // Target
	public int kyuuden();
}

	class Consent { // Adaptee
	public int power() {
	return 100;
	}
}

class AcAdapter implements Dengen { // Adapter
		private Consent consent = new Consent();
		public int kyuuden() {
		return (int)(consent.power() * 0.16);
	}
}

