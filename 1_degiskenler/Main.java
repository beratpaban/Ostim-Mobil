public class Main {
    public static void main(String[] args) {

        System.out.println("===================== ÖRNEK 1: OYUN KÜTÜPHANESİ =====================");
        String oyunAdi = "Stardew Valley";
        float oyunFiyati = 24.5f;
        boolean oyunYukluMu = false;

        System.out.println("Oyun Adı: " + oyunAdi);
        System.out.println("Oyun Fiyatı: " + oyunFiyati);
        System.out.println("Yüklü mü?: " + oyunYukluMu);

        System.out.println("===================== ÖRNEK 1: BİTİŞ ================================");

        System.out.println("===================== ÖRNEK 2: GÜNLÜK HAYATTAN VERİLER ==============");
        short sayfaSayisi = 4500;
        short gunlukAdimSayisi = 8500;
        float havaSicakligi = 24.5f;
        boolean kosullariKabulEtti = false;

        System.out.println("Sayfa Sayısı: " + sayfaSayisi);
        System.out.println("Günlük Adım Sayısı: " + gunlukAdimSayisi);
        System.out.println("Hava Sıcaklığı: " + havaSicakligi);
        System.out.println("Koşulları Kabul Etti: " + kosullariKabulEtti);

        System.out.println("===================== ÖRNEK 2: BİTİŞ ================================");

        System.out.println("===================== ÖRNEK 3: İnternet Paketi Takibi ===============");
        int aylikPaketGB = 25;
        int toplamPaketMB = aylikPaketGB * 1024;
        int kullanilanMB = 6500;
        int kalanPaketMB = toplamPaketMB - kullanilanMB;

        System.out.println("Kalan İnternet Hakkınız (MB): " + kalanPaketMB);

        System.out.println("===================== ÖRNEK 3: BİTİŞ ================================");

        System.out.println("===================== ÖRNEK 4: AKILLI TELEFON KİMLİĞİ ===============");
        String marka = "Apple";
        String model = "16 Pro";
        float ekranBoyutu = 6.5f;
        short depolamaGB = 128;
        boolean nfcVarMi = true;

        System.out.println("---- Telefonun Özellikleri ----");
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Ekran Boyutu: " + ekranBoyutu);
        System.out.println("Depolama (GB): " + depolamaGB + " GB");
        System.out.println("NFC Var mı?: " + nfcVarMi);
        System.out.println("-------------------------------");

        System.out.println("===================== ÖRNEK 4: BİTİŞ ================================");

    }
}