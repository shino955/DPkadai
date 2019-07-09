package stateTest;

public class Statechange {
	public static void main(String[] args) {
		Dog pochi = new Dog();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.shokuji();
		pochi.print();
		pochi.shokuji();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.roudou();
		pochi.print();
		}
}

class Dog {
private DogState myState;
public Dog() {
		myState = TanoshiiState.getInstance();
}
public void roudou() {
	myState.tukareta(this);
}
public void shokuji() {
	myState.tabeta(this);
}
public void changeState(DogState d) {
myState = d;
}
public void print() {
	System.out.print("現在、わたしは「");
	System.out.print( myState.toString() );
	System.out.println("」です。");
}
}

abstract class DogState {
public abstract void tukareta(Dog yobidashimoto); //疲れた！
public abstract void tabeta(Dog yobidashimoto); //食べた!
}

//楽しい状態
class TanoshiiState extends DogState {
private static TanoshiiState s = new TanoshiiState();
private TanoshiiState() {}
public static DogState getInstance() {
return s;
}
public void tukareta(Dog moto) {
moto.changeState(FutsuuState.getInstance()); //普通状態に遷移
}
public void tabeta(Dog moto) {
	// 楽しい状態の時食べても変化しない
}
public String toString() {
return "楽しい状態";
}
}

//普通状態
class FutsuuState extends DogState {
private static FutsuuState s = new FutsuuState();
private FutsuuState() {}
public static DogState getInstance() {
return s;
}
public void tukareta(Dog moto) {
moto.changeState(IrairaState.getInstance()); //イライラ状態に遷移
}
public void tabeta(Dog moto) {
moto.changeState(TanoshiiState.getInstance()); //楽しい状態に遷移
}
public String toString() {
return "普通状態";
}
}

//イライラ状態
class IrairaState extends DogState {
private static IrairaState s = new IrairaState();
private IrairaState() {}
public static DogState getInstance() {
return s;
}
public void tukareta(Dog moto) {
	moto.changeState(byoukiState.getInstance()); //病気状態に遷移
}
public void tabeta(Dog moto) {
moto.changeState(TanoshiiState.getInstance()); //楽しい状態に遷移
}
public String toString() {
return "いらいら状態";
}
}

//病気状態
class byoukiState extends DogState {
private static byoukiState s = new byoukiState();
private byoukiState() {}
public static DogState getInstance() {
return s;
}
public void tukareta(Dog moto) {
	// 病気状態の時疲れても変化しない
}
public void tabeta(Dog moto) {
moto.changeState(FutsuuState.getInstance()); //普通状態に遷移
}
public String toString() {
return "病気状態";
}
}