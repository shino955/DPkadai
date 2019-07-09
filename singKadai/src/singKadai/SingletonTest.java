package singKadai;

public class SingletonTest{
	public static void main(String[] args) {
		Renban seizouban = Renban.getNumber();
		seizouban.seizou();
		seizouban.print();
		Renban seizouban2 = Renban.getNumber();
		seizouban2.seizou();
		seizouban2.print();
	}

}
class Renban{
	private static Renban Number = new Renban();
	private int Num;
	private String bangou;


	public static Renban getNumber() {
		return Number;
	}

	public void seizou(){
		Num += 1;
		bangou = String.format("%04d", Num);
	}

	public void print(){
	System.out.println("----------------");
	System.out.println("製造番号 : " + bangou);
	}
}