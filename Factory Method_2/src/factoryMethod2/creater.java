package factoryMethod2;

//Createrクラスに相当
//テレビとラジオを製造する大工場
abstract class Koujyou {
public final Seihin create() {
Seihin seihin = factoryMethod(); touroku(seihin);
return seihin;
}
public abstract Seihin factoryMethod();
public abstract void touroku(Seihin s);
}

//ConcreateCreatorクラスに相当その1
//テレビ製造工場
class TvKoujyou extends Koujyou {
public Seihin factoryMethod() {
return new Television();
}
public void touroku(Seihin s) {
Television t = (Television) s;
t.numberring();
t.setDate(Date.today());
}
}

//ConcreateCreatorクラスに相当その2
//ラジオ製造工場
class RadioKoujyou extends Koujyou {
public Seihin factoryMethod() {
return new Radio();
}
public void touroku(Seihin s) {
Radio r = (Radio) s;
r.numberring();
}
}

//Productクラスに相当
//作られる製品の型
abstract class Seihin {
public abstract void print();
}

//ConcreateProductクラスに相当その1
//製造されるテレビの型
class Television extends Seihin {
private int tvSerialNumber;
private String date;
public void numberring() {
tvSerialNumber = Counter.getTvNumber();
}
public void setDate(String date) {
this.date = date;
}
public void print() {
System.out.println("このテレビに関する情報:");
System.out.println(" 製造番号:" + tvSerialNumber);
System.out.println(" 製造年月日:" + date);
	}
}

//ConcreateProductクラスに相当その2
//製造されるラジオの型
class Radio extends Seihin {
private int radioSerialNumber;
public void numberring() {
radioSerialNumber = Counter.getRadioNumber();
}
public void print() {
	System.out.println("このラジオに関する情報:");
	System.out.println(" 製造番号:" + radioSerialNumber);
	}
}

//登録用に使用する日付用クラス
//テレビ製造に使用
class Date {
public static String today() {
return "2004/01/20";
	}
}

//テレビ・ラジオそれぞれの製品番号用クラス
class Counter {
private static int tvNum = 100;
private static int radioNum = 76;
public static int getTvNumber() {
return tvNum++;
}
public static int getRadioNumber() {
return radioNum++;
	}
}


