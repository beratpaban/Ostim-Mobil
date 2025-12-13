### 🏗️ Bölüm 1: Java Sınıflarını Oluşturma (Arka Plan)

Önce "Birey" ve "Sporcu" sınıflarını oluşturarak işin temelini atalım.

#### 1\. Ana Sınıf: `Birey.java`

Burada **Kapsülleme (Encapsulation)** yapacağız. Değişkenleri gizli (private) yapıp, getter/setter ile erişim vereceğiz.

```java
public class Birey {
    // Kapsülleme: Değişkenler private (dışarıya kapalı)
    private String adSoyad;
    private double boy; // Metre cinsinden (Örn: 1.75)
    private double kilo;

    // Getter ve Setter Metotları
    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public double getBoy() { return boy; }
    public void setBoy(double boy) { this.boy = boy; }

    public double getKilo() { return kilo; }
    public void setKilo(double kilo) { this.kilo = kilo; }

    // VKE Hesaplama Metodu (Kilo / Boy * Boy)
    public double vkeHesapla() {
        return this.kilo / (this.boy * this.boy);
    }
}
```

#### 2\. Alt Sınıf: `Sporcu.java`

Burada **Kalıtım (Inheritance)** kullanacağız. `extends` diyerek Birey sınıfındaki boy, kilo, isim gibi özellikleri miras alacağız.

```java
// "extends Birey" diyerek Birey sınıfının tüm özelliklerini miras aldık.
public class Sporcu extends Birey {
    
    // Bu sınıfa özel değişken
    private int kosuSuresi;

    public int getKosuSuresi() { return kosuSuresi; }
    public void setKosuSuresi(int kosuSuresi) { this.kosuSuresi = kosuSuresi; }

    // Kalori Hesaplama: Dakikada 10 kalori yandığını varsayıyoruz.
    public int kaloriYakimiHesapla() {
        return kosuSuresi * 10; 
    }
}
```

-----

### 🎨 Bölüm 2: Ekran Tasarımı (XML)

`activity_main.xml` dosyasında tasarımı yaparken bileşenlere vereceğin **ID**'ler çok önemli. Java'da bu ID'leri kullanacağız.

*Özetle XML ekranında şunlar olmalı:*

1.  **EditText (id: etAd):** İsim girmek için.
2.  **EditText (id: etBoy):** Boy girmek için (`inputType="numberDecimal"`).
3.  **EditText (id: etKilo):** Kilo girmek için (`inputType="numberDecimal"`).
4.  **EditText (id: etSure):** Süre girmek için (`inputType="number"`).
5.  **Button (id: btnAnaliz):** "Durum Analizi" yazacak.
6.  **Button (id: btnKalori):** "Kalori Cetveli" yazacak.
7.  **TextView (id: tvSonuc):** Sonuçları göstermek için büyük bir alan.

-----

### 💻 Bölüm 3: Kodlama ve Mantık (MainActivity.java)

Şimdi parçaları birleştiriyoruz. Burada **If-Else** ve **For Döngüsü** kullanacağız.

```java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1. Tanımlamalar
    EditText etAd, etBoy, etKilo, etSure;
    Button btnAnaliz, btnKalori;
    TextView tvSonuc;

    // Sınıfımızdan nesne üretiyoruz
    Sporcu yeniSporcu = new Sporcu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. XML ile Bağlama
        etAd = findViewById(R.id.etAd);
        etBoy = findViewById(R.id.etBoy);
        etKilo = findViewById(R.id.etKilo);
        etSure = findViewById(R.id.etSure);
        btnAnaliz = findViewById(R.id.btnAnaliz);
        btnKalori = findViewById(R.id.btnKalori);
        tvSonuc = findViewById(R.id.tvSonuc);

        // --- BUTON 1: DURUM ANALİZİ (VKE & IF-ELSE) ---
        btnAnaliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verileri alıp sayıya çeviriyoruz
                String boyStr = etBoy.getText().toString();
                String kiloStr = etKilo.getText().toString();

                if (!boyStr.isEmpty() && !kiloStr.isEmpty()) {
                    double gelenBoy = Double.parseDouble(boyStr);
                    double gelenKilo = Double.parseDouble(kiloStr);

                    // Nesneye verileri gönder (Setter)
                    yeniSporcu.setBoy(gelenBoy);
                    yeniSporcu.setKilo(gelenKilo);

                    // Hesaplamayı yap
                    double vke = yeniSporcu.vkeHesapla();
                    String durum = "";

                    // KARAR YAPILARI (IF - ELSE IF - ELSE)
                    if (vke < 18.5) {
                        durum = "Zayıf";
                    } else if (vke >= 18.5 && vke < 25) {
                        durum = "Normal / Sağlıklı";
                    } else if (vke >= 25 && vke < 30) {
                        durum = "Fazla Kilolu";
                    } else {
                        durum = "Obezite Sınırı";
                    }

                    tvSonuc.setText("VKE Değeriniz: " + String.format("%.2f", vke) + "\nSağlık Durumu: " + durum);
                }
            }
        });

        // --- BUTON 2: KALORİ CETVELİ (FOR DÖNGÜSÜ) ---
        btnKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sureStr = etSure.getText().toString();

                if (!sureStr.isEmpty()) {
                    int toplamSure = Integer.parseInt(sureStr);
                    String tabloMetni = "--- KALORİ YAKIM CETVELİ ---\n";

                    // DÖNGÜ (FOR LOOP)
                    // 5'ten başlayıp, girilen süreye kadar 5'er 5'er artacak.
                    // (i = i + 5) mantığı burada çok önemli.
                    for (int i = 5; i <= toplamSure; i = i + 5) {
                        int yakilanKalori = i * 10; // Dakikada 10 kalori varsayımı
                        tabloMetni += i + ". Dakika sonunda: " + yakilanKalori + " kalori yakıldı.\n";
                    }

                    tvSonuc.setText(tabloMetni);
                } else {
                    Toast.makeText(MainActivity.this, "Lütfen süre giriniz!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
```

### 🚀 Kodun Çalışma Mantığı (Özet)

1.  **OOP (Nesne Tabanlı Programlama):**
      * `Sporcu` sınıfını `Birey` sınıfından miras aldık. Böylece boy ve kilo işlemleri için tekrar kod yazmadık, ana sınıftaki (Birey) kodu kullandık.
2.  **Karar Yapısı (If-Else):**
      * VKE sonucuna (örneğin 26.5) baktık. `if` blokları sırasıyla kontrol etti. 25 ile 30 arasında olduğu için "Fazla Kilolu" sonucunu değişkene atadı.
3.  **Döngü (For Loop):**
      * Kullanıcı 20 dakika girdiyse döngü şöyle çalışır:
          * `i=5` -\> 5. Dakika: 50 Kalori
          * `i=10` -\> 10. Dakika: 100 Kalori
          * `i=15` -\> 15. Dakika: 150 Kalori
          * `i=20` -\> 20. Dakika: 200 Kalori
      * Her turda metin birleştirilerek (`+=`) alt alta yazdırılır.

Bu kodları sırasıyla uyguladığında, hem **sağlık hesaplaması yapan** hem de **spor verisi listeleyen** harika bir uygulaman olacak. Başarılar\!