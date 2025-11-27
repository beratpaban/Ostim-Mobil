📚 Ders: Gelişmiş Komutlar - Metotlar (Methods)
Hedef Kitle: 11. Sınıf / Mobil Uygulamalar Dersi Konu: 5.1. [cite_start]Metot Amaç: Kod tekrarını önlemek ve programları yönetilebilir parçalara bölmek.
1. Metot Nedir? Neden Kullanırız? 🤔
Bir program yazarken aynı kodu tekrar tekrar yazdığını fark ettin mi? Bu hem yorucu hem de hata yapmaya çok açık bir yöntemdir. İşte burada devreye Metotlar girer!
💡 Günlük Hayattan Örnek: Bir yemek tarifi düşün. Her seferinde "2 yumurta kır, çırp, un ekle, karıştır..." diye uzun uzun anlatmak yerine, bu işlemlerin hepsine "Kek Çırp" adını veriyoruz. Ne zaman kek yapacak olsak sadece "Kek Çırp" diyoruz. İşte metotlar da kodların "paketlenmiş" halidir.
Temel Prensip: DRY (Don't Repeat Yourself - Kendini Tekrar Etme) Yazılım dünyasında altın kural budur. [cite_start]Aynı işi yapan kodları bir blok haline getirip isimlendirirsek, kodumuz daha düzenli olur.
2. Bir Metodun Anatomisi (Yapısı) 🦴
Bir metot tanımlarken belirli kurallara uyarız. [cite_start]Java dilinde bir metodun iskeleti şöyledir:
// Erişim Belirleyici - Dönüş Tipi - Metot Adı - (Parametreler)
   public             void          selamVer    () {
       // Metot Gövdesi (Yapılacak İşler)
       System.out.println("Merhaba!");
   }


Erişim Belirleyici (public/private): Metoda kimlerin ulaşabileceğini belirler. (Şimdilik private veya public kullanacağız).
Geri Dönüş Tipi (void/int/String...): Metot işini bitirince bize bir cevap veriyor mu? Vermiyorsa void yazılır.
Metot Adı: Metoda verdiğimiz isimdir. (Standartlara göre Camel Case yazılır: hesapla, veriGetir gibi) [cite_start].
Parametre Listesi: Metodun çalışması için dışarıdan malzemeye ihtiyacı var mı? Varsa parantez içine yazılır.
3. Metot Çeşitleri
A. Değer Döndürmeyen Metotlar (Void) 🛑
Bu metotlar, verilen emri yerine getirir ve işi bitirir. Geriye bir sayı veya yazı göndermezler.
Örnek: Arkadaşına "Kapıyı kapat" dedin. O da kalkıp kapıyı kapattı. İşlem bitti. Sana bir şey vermesine gerek yok.
Java Kodu Örneği: [cite_start]Ekrana sadece "Merhaba" yazan basit bir metot:
// Metodun Tanımlanması
private void selamVer() {
    // Sadece mesaj gösterir, geriye bir veri göndermez.
    Toast.makeText(getApplicationContext(), "Merhaba", Toast.LENGTH_LONG).show();
}

// Metodun Çağrılması (Kullanılması)
selamVer(); 


B. Değer Döndüren Metotlar (Return) ↩️
Bu metotlar bir işlem yapar ve sonucunu bize geri döndürür. İşlem sonucunu yakalayıp başka bir yerde kullanmak istiyorsak bu türü seçeriz.
Örnek: Arkadaşına "5 ile 10'u toplayınca kaç eder?" diye sordun. O işlemi zihninde yapar ve sana "15" cevabını verir. İşte o cevap, return edilen değerdir.
Java Kodu Örneği: [cite_start]İki sayıyı toplayıp sonucu bize veren metot:
// int: Bu metot geriye bir tam sayı döndürecek demektir.
private int topla() {
    return 5 + 10; // return ifadesi sonucu gönderir.
}

// Kullanımı
int sonuc = topla(); // sonuc değişkeni artık 15 değerini taşır.


C. Parametre Alan Metotlar 📥
Metotların daha akıllı olması için onlara dışarıdan veri (malzeme) gönderebiliriz. Buna parametre denir.
Örnek: Bir blender düşün. İçine muz atarsan muzlu süt yapar, çilek atarsan çilekli süt yapar. Blender aynıdır (metot), ama içine attığın malzeme (parametre) sonucu değiştirir.
Java Kodu Örneği: [cite_start]Dışarıdan gönderilen iki sayıyı toplayan metot:
// Parantez içindeki değişkenler parametrelerdir.
private int topla(int sayi1, int sayi2) {
    return sayi1 + sayi2;
}

// Kullanımı
int sonuc1 = topla(10, 20); // Sonuç 30 olur
int sonuc2 = topla(5, 3);   // Sonuç 8 olur


4. Metotlarda Aşırı Yükleme (Method Overloading) 🏋️
Aynı isme sahip birden fazla metot oluşturabiliriz! [cite_start]Ancak bir şartımız var: Parametre sayıları veya türleri farklı olmalı. Buna "Aşırı Yükleme" denir.
Neden Gerekli? Kullanıcının bazen 2 sayıyı, bazen 3 sayıyı toplaması gerekebilir. İkisi için de topla ismini kullanmak işimizi kolaylaştırır.
Java Kodu Örneği:
// 1. Durum: İki sayıyı toplar
private int topla(int sayi1, int sayi2) {
    return sayi1 + sayi2;
}

// 2. Durum: Üç sayıyı toplar (Aynı isim, farklı parametre sayısı)
private int topla(int sayi1, int sayi2, int sayi3) {
    return sayi1 + sayi2 + sayi3;
}

// Kullanımı
topla(5, 10);      // 1. metot çalışır
topla(5, 10, 20);  // 2. metot çalışır


📝 Özet ve İpuçları (Cheat Sheet)
[ ] DRY Prensibi: Kod tekrarından kaçın, metot kullan.
[ ] void: Metot geriye bir şey döndürmeyecekse kullanılır.
[ ] return: Metodun sonucunu çağıran yere göndermek için kullanılır (void olmayanlarda zorunludur).
[ ] Parametre: Metoda iş yapması için dışarıdan gönderilen veridir.
[ ] Overloading: Aynı isimli metotları, farklı parametrelerle kullanma sanatıdır.
🧠 Alıştırma Sorusu
Soru: Aşağıdaki senaryoyu koda döken bir metot yazın.
Metodun adı alanHesapla olsun.
Metot iki tane tam sayı (kısa kenar, uzun kenar) parametre alsın.
Bu sayıları çarpıp sonucu (alanı) geriye döndürsün (return).
Cevap:
<details> <summary>Cevabı Görmek İçin Tıkla</summary>
private int alanHesapla(int kisaKenar, int uzunKenar) {
    int alan = kisaKenar * uzunKenar;
    return alan;
}


</details>
Öğretmenim, bu notları öğrencilerinizle Notion üzerinden paylaşabilir veya sınıfta tahtaya yansıtarak üzerinden geçebilirsiniz. Bir sonraki adımda Sınıf ve Nesne (Class and Object) kavramlarına geçmemizi ister misiniz?
