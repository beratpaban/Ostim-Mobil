### 🏗️ Bölüm 1: Java Sınıflarını Oluşturma (Backend)

Önce "Urun" ve "TaksitliUrun" sınıflarını oluşturarak işin iskeletini kuralım.

#### 1\. Ana Sınıf: `Urun.java`

Burada **Kapsülleme (Encapsulation)** yapacağız. Değişkenleri gizli (private) tutup, onlara ulaşmak için kapı (Getter/Setter) açacağız.

```java
public class Urun {
    // Kapsülleme: Değişkenler private (dışarıya kapalı)
    private String urunAdi;
    private double hamFiyat;

    // Getter ve Setter Metotları (Sağ tık -> Generate -> Getter and Setter diyerek otomatik oluşturabilirsin)
    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public double getHamFiyat() {
        return hamFiyat;
    }

    public void setHamFiyat(double hamFiyat) {
        this.hamFiyat = hamFiyat;
    }

    // KDV Hesaplama Metodu (%20 KDV varsayalım)
    public double kdvliFiyatHesapla() {
        return this.hamFiyat * 1.20; // Fiyatı 1.20 ile çarpmak %20 eklemek demektir.
    }
}
```

#### 2\. Alt Sınıf: `TaksitliUrun.java`

Burada **Kalıtım (Inheritance)** kullanacağız. `extends` anahtar kelimesi ile `Urun` sınıfının tüm özelliklerini bu sınıfa aktaracağız.

```java
// "extends Urun" diyerek Urun sınıfının özelliklerini miras aldık.
public class TaksitliUrun extends Urun {
    
    // Bu sınıfa özel değişken
    private int taksitSayisi;

    public int getTaksitSayisi() {
        return taksitSayisi;
    }

    public void setTaksitSayisi(int taksitSayisi) {
        this.taksitSayisi = taksitSayisi;
    }

    // Aylık ödeme tutarını hesaplayan metot
    public double aylikOdemeHesapla() {
        double toplamFiyat = kdvliFiyatHesapla(); // Miras aldığımız metodu kullandık
        return toplamFiyat / taksitSayisi;
    }
}
```

-----

### 🎨 Bölüm 2: Ekran Tasarımı (XML)

`activity_main.xml` dosyasında kullanıcı arayüzünü oluşturacağız. Burada bileşenlere verdiğimiz **ID**'ler çok önemli çünkü Java tarafında bu isimlerle çağıracağız.

*Özetle XML yapın şu bileşenleri içermeli:*

1.  **EditText (id: etUrunAdi):** Ürün ismi girmek için.
2.  **EditText (id: etFiyat):** Fiyat girmek için (`inputType="numberDecimal"` olmalı).
3.  **EditText (id: etTaksit):** Taksit sayısı için (`inputType="number"` olmalı).
4.  **Button (id: btnKdv):** "KDV Ekle" yazacak.
5.  **Button (id: btnPlan):** "Plan Oluştur" yazacak.
6.  **Button (id: btnTemizle):** "Temizle" yazacak.
7.  **TextView (id: tvSonuc):** Sonuçları göstermek için büyük bir alan.

-----

### 💻 Bölüm 3: Kodlama ve Mantık (MainActivity.java)

Şimdi parçaları birleştirme zamanı. Burada **Karar Yapıları (If-Else)** ve **Döngüler (For)** kullanacağız.

```java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Uyarı mesajları için

public class MainActivity extends AppCompatActivity {

    // 1. Tanımlamalar
    EditText etUrunAdi, etFiyat, etTaksit;
    Button btnKdv, btnPlan, btnTemizle;
    TextView tvSonuc;

    // Sınıfımızdan nesne üretiyoruz
    TaksitliUrun yeniUrun = new TaksitliUrun();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. XML ile Bağlama (findViewById)
        etUrunAdi = findViewById(R.id.etUrunAdi);
        etFiyat = findViewById(R.id.etFiyat);
        etTaksit = findViewById(R.id.etTaksit);
        btnKdv = findViewById(R.id.btnKdv);
        btnPlan = findViewById(R.id.btnPlan);
        btnTemizle = findViewById(R.id.btnTemizle);
        tvSonuc = findViewById(R.id.tvSonuc);

        // --- BUTON 1: KDV HESAPLA ---
        btnKdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten veriyi alıp Double'a çeviriyoruz
                String fiyatStr = etFiyat.getText().toString();
                
                if (!fiyatStr.isEmpty()) {
                    double gelenFiyat = Double.parseDouble(fiyatStr);
                    
                    // Nesneye veriyi gönderiyoruz (Setter)
                    yeniUrun.setHamFiyat(gelenFiyat);
                    
                    // Metodu çağırıp sonucu alıyoruz
                    double kdvliFiyat = yeniUrun.kdvliFiyatHesapla();
                    
                    tvSonuc.setText("Ürün: " + etUrunAdi.getText().toString() + "\n" +
                                    "KDV'li Satış Fiyatı: " + kdvliFiyat + " TL");
                }
            }
        });

        // --- BUTON 2: ÖDEME PLANI OLUŞTUR ---
        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taksitStr = etTaksit.getText().toString();
                String fiyatStr = etFiyat.getText().toString();

                if (!taksitStr.isEmpty() && !fiyatStr.isEmpty()) {
                    int taksit = Integer.parseInt(taksitStr);
                    double fiyat = Double.parseDouble(fiyatStr);

                    // Nesneye verileri set ediyoruz
                    yeniUrun.setTaksitSayisi(taksit);
                    yeniUrun.setHamFiyat(fiyat);

                    // --- KONTROL YAPISI (IF-ELSE) ---
                    if (taksit > 12) {
                        tvSonuc.setText("HATA: Maksimum 12 taksit yapılabilir!");
                        Toast.makeText(MainActivity.this, "Taksit sayısı çok fazla!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Taksit uygunsa hesapla
                        double aylikTutar = yeniUrun.aylikOdemeHesapla();
                        String sonucMetni = "TOPLAM TUTAR: " + yeniUrun.kdvliFiyatHesapla() + " TL\n\n";

                        // --- DÖNGÜ (FOR LOOP) ---
                        // 1'den başlayıp taksit sayısına kadar dönecek
                        for (int i = 1; i <= taksit; i++) {
                            sonucMetni += i + ". Taksit: " + aylikTutar + " TL\n"; 
                            // += operatörü metnin sonuna ekleme yapar
                        }

                        tvSonuc.setText(sonucMetni);
                    }
                }
            }
        });

        // --- BUTON 3: TEMİZLE ---
        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUrunAdi.setText("");
                etFiyat.setText("");
                etTaksit.setText("");
                tvSonuc.setText("Sonuçlar burada görünecek...");
            }
        });
    }
}
```

### 🚀 Nasıl Çalışır?

1.  **Kalıtım:** `TaksitliUrun` sınıfı, `Urun` sınıfındaki `kdvliFiyatHesapla` metodunu miras aldığı için hem KDV'yi hesaplayabiliyor hem de taksit bölebiliyor.
2.  **Kapsülleme:** Değişkenlere direkt `yeniUrun.hamFiyat = 500` diyerek ulaşamıyoruz (çünkü private). Mecburen `setHamFiyat(500)` kullanıyoruz. Bu da veriyi koruyor.
3.  **Döngü:** Kullanıcı 3 taksit girdiyse, `for` döngüsü 3 kere dönüyor ve alt alta "1. Taksit...", "2. Taksit..." yazılarını birleştiriyor.

Bu kodları sırasıyla projene eklediğinde ödevin eksiksiz tamamlanmış olacaktır. Başarılar dilerim\!