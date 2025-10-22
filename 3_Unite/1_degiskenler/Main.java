public class Main {
    public static void main(String[] args) {

        System.out.println("===================== ÖRNEK 1: OYUN KÜTÜPHANESİ =====================");

        // Metin (Yazı) tipinde bir veri saklamak için 'String' değişkeni oluşturuyoruz.
        String oyunAdi = "Stardew Valley";

        // Ondalıklı bir sayı saklamak için 'float' değişkeni oluşturuyoruz.
        // 'float' tipindeki değerlerin sonuna 'f' harfi eklenir.
        float oyunFiyati = 24.5f;

        // Sadece 'true' (doğru) veya 'false' (yanlış) değeri alabilen 'boolean'
        // değişkeni oluşturuyoruz.
        boolean oyunYukluMu = false;

        // Oluşturduğumuz değişkenlerin değerlerini ekrana yazdırıyoruz.
        System.out.println("Oyun Adı: " + oyunAdi);
        System.out.println("Oyun Fiyatı: " + oyunFiyati);
        System.out.println("Yüklü mü?: " + oyunYukluMu);

        System.out.println("===================== ÖRNEK 1: BİTİŞ ================================");
        System.out.println("\n"); // Çıktıda daha iyi görünmesi için bir satır boşluk bırakalım.

        System.out.println("===================== ÖRNEK 2: GÜNLÜK HAYATTAN VERİLER ==============");

        // 'int' gibi tam sayı tutar ama daha az yer kaplar. Küçük sayılar için
        // idealdir.
        short sayfaSayisi = 4500;
        short gunlukAdimSayisi = 8500;

        // Tekrar ondalıklı bir sayı için 'float' kullanıyoruz.
        float havaSicakligi = 24.5f;

        // Bir onayın durumunu tutmak için 'boolean' değişkeni.
        boolean kosullariKabulEtti = false;

        // Değişkenleri ekrana yazdırıyoruz.
        System.out.println("Sayfa Sayısı: " + sayfaSayisi);
        System.out.println("Günlük Adım Sayısı: " + gunlukAdimSayisi);
        System.out.println("Hava Sıcaklığı: " + havaSicakligi);
        System.out.println("Koşulları Kabul Etti: " + kosullariKabulEtti);

        System.out.println("===================== ÖRNEK 2: BİTİŞ ================================");
        System.out.println("\n");

        System.out.println("===================== ÖRNEK 3: İnternet Paketi Takibi ===============");

        // Tam sayı verileri için en sık kullanılan değişken tipi 'int' (integer).
        int aylikPaketGB = 25;

        // GB'ı MB'a çevirmek için matematiksel bir işlem yapıyoruz (1 GB = 1024 MB).
        int toplamPaketMB = aylikPaketGB * 1024;

        // Kullanılan internet miktarını bir değişkende tutuyoruz.
        int kullanilanMB = 6500;

        // Toplam paketten kullanılanı çıkararak kalanı buluyoruz.
        int kalanPaketMB = toplamPaketMB - kullanilanMB;

        // Sonucu ekrana yazdırıyoruz.
        System.out.println("Kalan İnternet Hakkınız (MB): " + kalanPaketMB);

        System.out.println("===================== ÖRNEK 3: BİTİŞ ================================");
        System.out.println("\n");

        System.out.println("===================== ÖRNEK 4: AKILLI TELEFON KİMLİĞİ ===============");

        // Bir telefonun özelliklerini farklı veri tiplerinde değişkenlerde saklıyoruz.
        String marka = "Apple";
        String model = "16 Pro";
        float ekranBoyutu = 6.5f;
        short depolamaGB = 128;
        boolean nfcVarMi = true;

        // Çıktının daha düzenli olması için başlıklar ekliyoruz.
        System.out.println("---- Telefonun Özellikleri ----");
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Ekran Boyutu: " + ekranBoyutu);
        // Yazdırırken metinle değişkeni birleştirerek daha açıklayıcı bir çıktı elde
        // edebiliriz.
        System.out.println("Depolama (GB): " + depolamaGB + " GB");
        System.out.println("NFC Var mı?: " + nfcVarMi);
        System.out.println("-------------------------------");

        System.out.println("===================== ÖRNEK 4: BİTİŞ ================================");

    }
}