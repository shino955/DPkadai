package iteratorTest;

public interface Iterator {
	public void first(); // 取り出し位置を最初の要素へ変える
	public void next(); // 取り出し位置を次の要素へ変える
	public boolean isDone(); // 取り出し位置が最後を超えたか？
	public Object getItem(); // 現在の取り出し位置から取り出す
}

class MusicCD {
private String name; // 名称
private int price; // 価格
public MusicCD(String name, int price) { // コンストラクタ
this.name= name;
this.price = price;
}
public String getName() { // 名称を取得
return name;
}
public int getPrice() { // 価格を取得
return price;
}
}


class MusicCDListIterator implements Iterator {
private MusicCDListAggregate aggregate;
private int current;
public MusicCDListIterator(MusicCDListAggregate aggregate) {
this.aggregate = aggregate;
}
@Override
public void first() {
current = 0;
}
@Override
public void next() {
current += 1;
}
@Override
public boolean isDone() {
if (current >= aggregate.getNumberOfStock()) {
return true;
}
else {
return false;
}
}
@Override
public Object getItem() {
return aggregate.getAt(current);
}
}

interface Aggregate {
public Iterator createIterator();
}

class MusicCDListAggregate implements Aggregate {
private MusicCD[] list = new MusicCD[20];
private int numberOfStock;
@Override
public Iterator createIterator() {
return new MusicCDListIterator(this);
}
public void add(MusicCD music) {
list[numberOfStock] = music;
numberOfStock += 1;
}
public Object getAt(int number) {
return list[number];
}
public int getNumberOfStock() {
return numberOfStock;
}
}

