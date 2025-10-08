public class Main {
    public static void main(String[] args) {

        System.out.println("===================== ÖRNEK 1: TAKDİR BELGESİ (&& Operatörü) =====================");

        // --- Durum 1: Takdir alabiliyor ---
        System.out.println("--- Durum 1 ---");

        // Gerekli değişkenleri tanımlıyoruz. 'double' ondalıklı sayılar, 'int' tam
        // sayılar içindir.
        double notOrtalamasi1 = 92.5;
        int zayifSayisi1 = 0;

        // Takdir alma şartını '&&' (VE) operatörü ile kontrol ediyoruz.
        // Bu operatör, her iki şartın da doğru (true) olmasını gerektirir.
        // (92.5 >= 85) ifadesi DOĞRU (true)
        // (0 == 0) ifadesi DOĞRU (true)
        // Sonuç: true && true -> true olur.
        boolean takdirAlabilirMi1 = (notOrtalamasi1 >= 85) && (zayifSayisi1 == 0);

        // Sonuçları ekrana yazdırıyoruz.
        System.out.println("Not Ortalaması: " + notOrtalamasi1);
        System.out.println("Zayıf Sayısı: " + zayifSayisi1);
        System.out.println("Takdir belgesi alabilir mi?: " + takdirAlabilirMi1);
        System.out.println(); // Okunabilirliği artırmak için bir satır boşluk.

        // --- Durum 2: Zayıf dersi olduğu için takdir alamıyor ---
        System.out.println("--- Durum 2 ---");
        double notOrtalamasi2 = 92.5;
        int zayifSayisi2 = 1;

        // '&&' operatöründe şartlardan biri bile yanlış (false) ise sonuç yanlış olur.
        // (92.5 >= 85) ifadesi DOĞRU (true)
        // (1 == 0) ifadesi YANLIŞ (false)
        // Sonuç: true && false -> false olur.
        boolean takdirAlabilirMi2 = (notOrtalamasi2 >= 85) && (zayifSayisi2 == 0);

        System.out.println("Not Ortalaması: " + notOrtalamasi2);
        System.out.println("Zayıf Sayısı: " + zayifSayisi2);
        System.out.println("Takdir belgesi alabilir mi?: " + takdirAlabilirMi2);
        System.out.println("============================= ÖRNEK 1 BİTİŞ =====================================");
        System.out.println("\n"); // Örnekler arasına daha fazla boşluk koyalım.

        System.out.println("===================== ÖRNEK 2: SİNEMA İZNİ (|| Operatörü) =======================");
        // --- Durum 1: Hafta sonu olduğu için sinemaya gidebiliyor ---
        System.out.println("--- Durum 1 ---");

        // 'boolean' değişkenler sadece true ya da false değeri alabilir.
        boolean odevBittimi1 = false;
        boolean haftaSonumu1 = true;

        // Sinema şartını '||' (VEYA) operatörü ile kontrol ediyoruz.
        // Bu operatör için şartlardan sadece birinin doğru (true) olması yeterlidir.
        // (ödev bitti mi?) -> YANLIŞ (false)
        // (hafta sonu mu?) -> DOĞRU (true)
        // Sonuç: false || true -> true olur.
        boolean sinemayaGidebilirMi1 = odevBittimi1 || haftaSonumu1;

        System.out.println("Ödevler bitti mi?: " + odevBittimi1);
        System.out.println("Hafta sonu mu?: " + haftaSonumu1);
        System.out.println("Sinemaya gidebilir miyim?: " + sinemayaGidebilirMi1);
        System.out.println();

        // --- Durum 2: İki şart da sağlanmadığı için sinemaya gidemiyor ---
        System.out.println("--- Durum 2 ---");
        boolean odevBittimi2 = false;
        boolean haftaSonumu2 = false;

        // '||' operatöründe sonucun yanlış (false) olması için her iki şartın da yanlış
        // olması gerekir.
        // (ödev bitti mi?) -> YANLIŞ (false)
        // (hafta sonu mu?) -> YANLIŞ (false)
        // Sonuç: false || false -> false olur.
        boolean sinemayaGidebilirMi2 = odevBittimi2 || haftaSonumu2;

        System.out.println("Ödevler bitti mi?: " + odevBittimi2);
        System.out.println("Hafta sonu mu?: " + haftaSonumu2);
        System.out.println("Sinemaya gidebilir miyim?: " + sinemayaGidebilirMi2);
        System.out.println("============================= ÖRNEK 2 BİTİŞ =====================================");
        System.out.println("\n");

        System.out.println("===================== ÖRNEK 3: MESAJ GÖNDERME (! Operatörü) ======================");
        // --- Durum 1: Mesaj kutusu dolu ---
        System.out.println("--- Durum 1 ---");

        // Metinleri saklamak için 'String' değişkeni kullanılır.
        String mesajMetni1 = "Merhaba, nasılsın?";

        // '.isEmpty()' metodu, String boş ise 'true', dolu ise 'false' değeri verir.
        // "Merhaba, nasılsın?" metni dolu olduğu için 'mesajKutusuBosMu1' değişkeni
        // 'false' olur.
        boolean mesajKutusuBosMu1 = mesajMetni1.isEmpty();

        // '!' (DEĞİL) operatörü, bir boolean değerin tam tersini alır.
        // Kuralımız: Mesaj kutusu boş DEĞİLSE gönderilebilir.
        // 'mesajKutusuBosMu1' değişkeni 'false' olduğu için, !false -> true olur.
        boolean mesajGonderilebilirMi1 = !mesajKutusuBosMu1;

        System.out.println("Mesaj Metni: \"" + mesajMetni1 + "\"");
        System.out.println("Mesaj kutusu boş mu?: " + mesajKutusuBosMu1);
        System.out.println("Mesaj gönderilebilir mi?: " + mesajGonderilebilirMi1);
        System.out.println();

        // --- Durum 2: Mesaj kutusu boş ---
        System.out.println("--- Durum 2 ---");
        String mesajMetni2 = "";

        // Metin boş olduğu için '.isEmpty()' metodu 'true' değeri verir.
        boolean mesajKutusuBosMu2 = mesajMetni2.isEmpty();

        // 'mesajKutusuBosMu2' değişkeni 'true' olduğu için, !true -> false olur.
        boolean mesajGonderilebilirMi2 = !mesajKutusuBosMu2;

        System.out.println("Mesaj Metni: \"" + mesajMetni2 + "\"");
        System.out.println("Mesaj kutusu boş mu?: " + mesajKutusuBosMu2);
        System.out.println("Mesaj gönderilebilir mi?: " + mesajGonderilebilirMi2);
        System.out.println("============================= ÖRNEK 3 BİTİŞ =====================================");
        System.out.println("\n");

        System.out.println("===================== BONUS ÖRNEK: ONLINE OYUN GİRİŞ ===========================");

        // --- Durum 1: Seviye 25, yasaklı değil, premium değil ---
        System.out.println("--- Durum 1 ---");
        int oyuncuSeviyesi1_bonus = 25;
        boolean hesapYasakliMi1_bonus = false;
        boolean premiumUyeMi1_bonus = false;
        // Kural: seviye >= 20 VE (yasaklı DEĞİL VEYA premium üye)
        // (!false || false) -> (true || false) -> true
        // (25 >= 20) -> true
        // Sonuç: true && true -> true
        boolean macaKatilabilirMi1_bonus = oyuncuSeviyesi1_bonus >= 20
                && (!hesapYasakliMi1_bonus || premiumUyeMi1_bonus);
        System.out.println("Sonuç: " + macaKatilabilirMi1_bonus); // Çıktı: true
        System.out.println();

        // --- Durum 2: Seviye 15, yasaklı değil, premium değil ---
        System.out.println("--- Durum 2 ---");
        int oyuncuSeviyesi2_bonus = 15;
        boolean hesapYasakliMi2_bonus = false;
        boolean premiumUyeMi2_bonus = false;
        // Seviye şartı (15 >= 20) en başta false olduğu için, '&&' operatörü nedeniyle
        // sonuç direkt false olur.
        boolean macaKatilabilirMi2_bonus = oyuncuSeviyesi2_bonus >= 20
                && (!hesapYasakliMi2_bonus || premiumUyeMi2_bonus);
        System.out.println("Sonuç: " + macaKatilabilirMi2_bonus); // Çıktı: false
        System.out.println();

        // --- Durum 3: Seviye 25, yasaklı, premium üye ---
        System.out.println("--- Durum 3 ---");
        int oyuncuSeviyesi3_bonus = 25;
        boolean hesapYasakliMi3_bonus = true;
        boolean premiumUyeMi3_bonus = true;
        // Kural: seviye >= 20 VE (yasaklı DEĞİL VEYA premium üye)
        // (!true || true) -> (false || true) -> true
        // (25 >= 20) -> true
        // Sonuç: true && true -> true
        boolean macaKatilabilirMi3_bonus = oyuncuSeviyesi3_bonus >= 20
                && (!hesapYasakliMi3_bonus || premiumUyeMi3_bonus);
        System.out.println("Sonuç: " + macaKatilabilirMi3_bonus); // Çıktı: true
        System.out.println();

        // --- Durum 4: Seviye 25, yasaklı, premium değil ---
        System.out.println("--- Durum 4 ---");
        int oyuncuSeviyesi4_bonus = 25;
        boolean hesapYasakliMi4_bonus = true;
        boolean premiumUyeMi4_bonus = false;
        // Kural: seviye >= 20 VE (yasaklı DEĞİL VEYA premium üye)
        // (!true || false) -> (false || false) -> false
        // (25 >= 20) -> true
        // Sonuç: true && false -> false
        boolean macaKatilabilirMi4_bonus = oyuncuSeviyesi4_bonus >= 20
                && (!hesapYasakliMi4_bonus || premiumUyeMi4_bonus);
        System.out.println("Sonuç: " + macaKatilabilirMi4_bonus); // Çıktı: false

        System.out.println("============================= BONUS ÖRNEK BİTİŞ ==================================");
    }
}