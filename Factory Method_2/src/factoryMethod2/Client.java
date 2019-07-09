package factoryMethod2;

//製品を要求するクライアント
public class Client {
public static void main(String[] args) {
Koujyou koujyou1 = new TvKoujyou(); //Koujou1にTvKoujou(テレビ工場)を指定
Koujyou koujyou2 = new RadioKoujyou(); //Koujou2にRadioKoujou(ラジオ工場)を指定
Seihin[] array = new Seihin[3];
array[0] = koujyou1.create(); //テレビを要求
array[1] = koujyou2.create(); //ラジオを要求
array[2] = koujyou1.create(); //テレビを要求
for (int i = 0; i < array.length; ++i) {
array[i].print();
		}
	}
}
