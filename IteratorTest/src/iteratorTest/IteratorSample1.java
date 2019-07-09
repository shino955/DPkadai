package iteratorTest;

public class IteratorSample1 {
public static void main(String[] args) {
MusicCDListAggregate gameListAggregate = new MusicCDListAggregate();
Iterator iterator = gameListAggregate.createIterator();
gameListAggregate.add(new MusicCD("エリーゼのために", 2700));
gameListAggregate.add(new MusicCD("さくら", 1300));
gameListAggregate.add(new MusicCD("くるみ割り人形", 3000));
gameListAggregate.add(new MusicCD("We are the world", 5000));
iterator.first(); // まず探す場所を先頭位置にしてもらう
while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
MusicCD game = (MusicCD)iterator.getItem(); // はいどうぞ (と受取る)
System.out.println(game.getName());
iterator.next(); // 次を頂戴
}
}
}
