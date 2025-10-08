public class Main {
    public static void main(String[] args) {

        System.out.println("===================== ÖRNEK 1: EHLİYET YETERLİLİK KONTROLÜ =====================");

        // 'final' anahtar kelimesi ile bir sabit oluşturuyoruz. Bu değer program
        // boyunca değiştirilemez.
        final int EHLIYET_YASI = 18; // Ehliyet almak için gereken minimum yaş.

        // --- Durum 1: Yaş yeterli ---
        System.out.println("--- Durum 1 ---");
        int basvuraninYasi1 = 20; // Başvuran kişinin yaşını bir değişkene atıyoruz.

        // Başvuranın yaşının, ehliyet yaşından büyük veya eşit olup olmadığını '>='
        // operatörü ile kontrol ediyoruz.
        // (20 >= 18) karşılaştırmasının sonucu 'true' (doğru) olacaktır.
        boolean ehliyetAlabilirMi1 = basvuraninYasi1 >= EHLIYET_YASI;

        // Sonucu ekrana yazdırıyoruz.
        System.out.println("Başvuranın yaşı: " + basvuraninYasi1);
        System.out.println("Ehliyet alabilir mi?: " + ehliyetAlabilirMi1); // Beklenen çıktı: true
        System.out.println(); // Boşluk

        // --- Durum 2: Yaş yeterli değil ---
        System.out.println("--- Durum 2 ---");
        int basvuraninYasi2 = 16; // Yaşı 16 olarak değiştirip tekrar deniyoruz.

        // (16 >= 18) karşılaştırmasının sonucu 'false' (yanlış) olacaktır.
        boolean ehliyetAlabilirMi2 = basvuraninYasi2 >= EHLIYET_YASI;

        System.out.println("Başvuranın yaşı: " + basvuraninYasi2);
        System.out.println("Ehliyet alabilir mi?: " + ehliyetAlabilirMi2); // Beklenen çıktı: false

        System.out.println("============================= ÖRNEK 1 BİTİŞ =====================================\n");

        System.out.println("===================== ÖRNEK 2: OYUN REKORU KIRILDI MI? ===========================");
        // Oyundaki rekoru bir değişkende saklıyoruz.
        int enYuksekSkor = 15000;

        // --- Durum 1: Rekor kırıldı ---
        System.out.println("--- Durum 1 ---");
        int oyuncununSkoru1 = 17500; // Oyuncunun yeni skorunu belirliyoruz.
        System.out.println("Oyuncunun Skoru: " + oyuncununSkoru1);

        // '>' (büyüktür) operatörü ile oyuncunun skorunun rekordan yüksek olup
        // olmadığını kontrol ediyoruz.
        boolean rekorKirildiMi = oyuncununSkoru1 > enYuksekSkor;

        // '==' (eşittir) operatörü ile iki skorun birbirine tam olarak eşit olup
        // olmadığını kontrol ediyoruz.
        boolean rekorEgalendiMi = oyuncununSkoru1 == enYuksekSkor;

        // '!=' (eşit değildir) operatörü ile iki skorun birbirinden farklı olup
        // olmadığını kontrol ediyoruz.
        boolean skorlarFarkliMi = oyuncununSkoru1 != enYuksekSkor;

        // Sonuçları ekrana yazdırıyoruz.
        System.out.println("Rekor Kırıldı mı?: " + rekorKirildiMi); // Beklenen: true
        System.out.println("Rekor Egalendi mi?: " + rekorEgalendiMi); // Beklenen: false
        System.out.println("Skorlar Farklı mı?: " + skorlarFarkliMi); // Beklenen: true
        System.out.println();

        // --- Durum 2: Rekor kırılamadı ---
        System.out.println("--- Durum 2 ---");
        int oyuncununSkoru2 = 14000; // Oyuncunun skorunu rekorun altında bir değer yapıyoruz.
        System.out.println("Oyuncunun Skoru: " + oyuncununSkoru2);

        // Aynı karşılaştırmaları yeni skor için de yapıyoruz.
        rekorKirildiMi = oyuncununSkoru2 > enYuksekSkor;
        rekorEgalendiMi = oyuncununSkoru2 == enYuksekSkor;
        skorlarFarkliMi = oyuncununSkoru2 != enYuksekSkor;

        System.out.println("Rekor Kırıldı mı?: " + rekorKirildiMi);
        System.out.println("Rekor Egalendi mi?: " + rekorEgalendiMi);
        System.out.println("Skorlar Farklı mı?: " + skorlarFarkliMi);

        System.out.println("============================= ÖRNEK 2 BİTİŞ =====================================\n");

        System.out.println("===================== ÖRNEK 3: ALIŞVERİŞ BÜTÇESİ ================================");

        // --- Durum 1: Paramız yetiyor ---
        System.out.println("--- Durum 1 ---");

        // Ondalıklı para miktarları için 'double' veri tipini kullanıyoruz.
        double cuzdandakiPara1 = 85.50;
        double urunFiyati1 = 79.99;

        // Ürün fiyatının, cüzdandaki paradan küçük veya ona eşit olup olmadığını '<='
        // operatörü ile kontrol ediyoruz.
        // (79.99 <= 85.50) karşılaştırmasının sonucu 'true' (doğru) olacaktır.
        boolean paramYeterliMi1 = urunFiyati1 <= cuzdandakiPara1;

        System.out.println("Cüzdandaki Para: " + cuzdandakiPara1);
        System.out.println("Ürün Fiyatı: " + urunFiyati1);
        System.out.println("Bu ürünü alabilir miyim?: " + paramYeterliMi1); // Beklenen çıktı: true
        System.out.println();

        // --- Durum 2: Paramız yetmiyor ---
        System.out.println("--- Durum 2 ---");
        double cuzdandakiPara2 = 85.50;
        double urunFiyati2 = 90.0; // Ürün fiyatını cüzdandaki paradan yüksek bir değer yapıyoruz.

        // (90.0 <= 85.50) karşılaştırmasının sonucu 'false' (yanlış) olacaktır.
        boolean paramYeterliMi2 = urunFiyati2 <= cuzdandakiPara2;

        System.out.println("Cüzdandaki Para: " + cuzdandakiPara2);
        System.out.println("Ürün Fiyatı: " + urunFiyati2);
        System.out.println("Bu ürünü alabilir miyim?: " + paramYeterliMi2);

        System.out.println("============================= ÖRNEK 3 BİTİŞ =====================================\n");

        System.out.println("===================== BONUS: ATM PIN KODU KONTROLÜ ==============================");

        // Doğru PIN kodunu programda değiştirilemeyen bir sabit olarak tanımlıyoruz.
        final int DOGRU_PIN = 1923;

        // --- Durum 1: Yanlış PIN girildi ---
        System.out.println("--- Durum 1: Yanlış PIN ---");
        int girilenPin1 = 1234;

        // Girilen PIN'in doğru PIN'e eşit olup olmadığını '==' ile kontrol ediyoruz.
        // (1234 == 1923) -> false
        boolean pinDogruMu1 = girilenPin1 == DOGRU_PIN;

        // Girilen PIN'in doğru PIN'den farklı olup olmadığını '!=' ile kontrol
        // ediyoruz. (1234 != 1923) -> true
        boolean pinYanlisMi1 = girilenPin1 != DOGRU_PIN;

        System.out.println("Girilen PIN: " + girilenPin1);
        System.out.println("Girilen PIN Doğru mu?: " + pinDogruMu1); // Beklenen: false
        System.out.println("Girilen PIN Yanlış mı?: " + pinYanlisMi1); // Beklenen: true
        System.out.println();

        // --- Durum 2: Doğru PIN girildi ---
        System.out.println("--- Durum 2: Doğru PIN ---");
        int girilenPin2 = 1923; // Bu sefer doğru PIN'i giriyoruz.

        // (1923 == 1923) -> true
        boolean pinDogruMu2 = girilenPin2 == DOGRU_PIN;

        // (1923 != 1923) -> false
        boolean pinYanlisMi2 = girilenPin2 != DOGRU_PIN;

        System.out.println("Girilen PIN: " + girilenPin2);
        System.out.println("Girilen PIN Doğru mu?: " + pinDogruMu2);
        System.out.println("Girilen PIN Yanlış mı?: " + pinYanlisMi2);

        System.out.println("============================= BONUS BİTİŞ =========================================\n");
    }
}