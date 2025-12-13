### 🏗️ Bölüm 1: Mimari Tasarım (Java Sınıfları)

Önce uygulamanın beynini oluşturan sınıfları yazalım.

#### 1\. Ana Sınıf: `BankaHesabi.java`

Bu sınıf, her hesapta olması gereken temel özellikleri taşır.

  * **Kapsülleme (Encapsulation):** Değişkenleri `private` yaparak korumaya alıyoruz.
  * **Metotlar:** Para yatırma ve çekme işlemlerini burada tanımlıyoruz ki kod tekrarı yapmayalım.

<!-- end list -->

```java
public class BankaHesabi {
    // 1. Değişkenler (Private - Gizli)
    private String isimSoyisim;
    private double bakiye;

    // 2. Getter ve Setter Metotları (Erişim için)
    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public double getBakiye() {
        return bakiye;
    }

    // Bakiyeyi direkt değiştirmek yerine para yatır/çek metotlarını kullanacağız
    // Ama başlangıç için setBakiye de durabilir.
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    // 3. İşlem Metotları
    public void paraYatir(double miktar) {
        this.bakiye += miktar; // Bakiyeye ekle
    }

    public void paraCek(double miktar) {
        this.bakiye -= miktar; // Bakiyeden düş
    }
}
```

#### 2\. Alt Sınıf: `VadeliHesap.java`

Bu sınıf, `BankaHesabi` sınıfının tüm özelliklerini **miras (inheritance)** alır. Yani `isim` ve `bakiye` değişkenlerini tekrar yazmamıza gerek kalmaz.

```java
// "extends BankaHesabi" diyerek mirası aldık
public class VadeliHesap extends BankaHesabi {
    
    // Bu sınıfa özel değişken
    private double faizOrani; 

    // Constructor (Yapıcı Metot) - İsteğe bağlı ama faiz oranını baştan verelim
    public VadeliHesap() {
        this.faizOrani = 0.20; // Örneğin %20 Faiz oranı varsayılan olsun
    }

    public double getFaizOrani() {
        return faizOrani;
    }

    public void setFaizOrani(double faizOrani) {
        this.faizOrani = faizOrani;
    }
}
```

-----

### 🎨 Bölüm 2: Ekran Tasarımı (XML)

`activity_main.xml` dosyasında tasarımı yaparken aşağıdaki bileşenleri ve **ID**'lerini kullanmalısın.

  * **Tasarım İpuçları:**
      * Sayı girilecek alanlarda `android:inputType="numberDecimal"` kullan ki klavye sadece sayı göstersin.
      * Bileşen ID'leri: `etIsim`, `etTutar`, `etVade`, `btnYatir`, `btnCek`, `btnHesapla`, `tvBilgi`.

-----

### 💻 Bölüm 3: Programlama Mantığı (MainActivity.java)

Burası uygulamanın kalbi. İstenen **If/Else** ve **For Döngüsü** mantıklarını burada kuracağız.

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
    EditText etIsim, etTutar, etVade;
    Button btnYatir, btnCek, btnHesapla;
    TextView tvBilgi;

    // Sınıfımızdan nesne üretiyoruz (Global alanda)
    VadeliHesap musteriHesabi = new VadeliHesap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Bağlamalar (findViewById)
        etIsim = findViewById(R.id.etIsim);
        etTutar = findViewById(R.id.etTutar);
        etVade = findViewById(R.id.etVade);
        btnYatir = findViewById(R.id.btnYatir);
        btnCek = findViewById(R.id.btnCek);
        btnHesapla = findViewById(R.id.btnHesapla);
        tvBilgi = findViewById(R.id.tvBilgi);

        // Başlangıç ayarı
        musteriHesabi.setBakiye(0); // Hesap 0 TL ile başlar

        // --- BUTON 1: PARA YATIR ---
        btnYatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tutarStr = etTutar.getText().toString();
                
                if (!tutarStr.isEmpty()) {
                    double miktar = Double.parseDouble(tutarStr);
                    
                    // Sınıfın metodunu kullanıyoruz
                    musteriHesabi.paraYatir(miktar);
                    
                    // Ekrana bilgi yazdır
                    guncelBakiyeyiGoster();
                }
            }
        });

        // --- BUTON 2: PARA ÇEK (VALIDATION / KONTROL) ---
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tutarStr = etTutar.getText().toString();

                if (!tutarStr.isEmpty()) {
                    double cekilecekMiktar = Double.parseDouble(tutarStr);
                    double mevcutBakiye = musteriHesabi.getBakiye();

                    // --- IF / ELSE KONTROLÜ (İstenen Kısım) ---
                    if (cekilecekMiktar > mevcutBakiye) {
                        // Para yetersizse
                        tvBilgi.setText("HATA: Yetersiz Bakiye!\nMevcut Paranız: " + mevcutBakiye + " TL");
                    } else {
                        // Para yeterliyse işlemi yap
                        musteriHesabi.paraCek(cekilecekMiktar);
                        guncelBakiyeyiGoster();
                    }
                }
            }
        });

        // --- BUTON 3: KAZANÇ HESAPLA (DÖNGÜLER) ---
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vadeStr = etVade.getText().toString();

                if (!vadeStr.isEmpty()) {
                    int yil = Integer.parseInt(vadeStr);
                    
                    // Hesaplama için geçici bir bakiye değişkeni alıyoruz
                    double anaPara = musteriHesabi.getBakiye();
                    double faizOrani = musteriHesabi.getFaizOrani();
                    
                    String sonucMetni = "--- VADELİ HESAP TABLOSU ---\nBaşlangıç Parası: " + anaPara + " TL\n\n";

                    // --- FOR DÖNGÜSÜ (İstenen Kısım) ---
                    // 1. yıldan başlayıp girilen yıla kadar döner
                    for (int i = 1; i <= yil; i++) {
                        
                        // Basit Bileşik Faiz Mantığı:
                        // Her yıl, paranın üzerine faiz eklenir.
                        double buYilinKazanci = anaPara * faizOrani;
                        anaPara = anaPara + buYilinKazanci;

                        // Metne ekle
                        sonucMetni += i + ". Yıl Sonu: " + String.format("%.2f", anaPara) + " TL\n";
                    }

                    // Döngü bitince hepsini yazdır
                    tvBilgi.setText(sonucMetni);
                }
            }
        });
    }

    // Yardımcı Metot: Sürekli aynı kodu yazmamak için
    private void guncelBakiyeyiGoster() {
        tvBilgi.setText("Sayın " + etIsim.getText().toString() + "\n" +
                        "Güncel Bakiyeniz: " + musteriHesabi.getBakiye() + " TL");
    }
}
```

### ✅ Ödevi Tamamlarken Dikkat Etmen Gerekenler

1.  **Sıralama:** Önce Java sınıflarını (`BankaHesabi`, `VadeliHesap`) oluştur, sonra XML tasarımını yap, en son `MainActivity` kodlarını yaz.
2.  **Hata Önleme:** `if (!tutarStr.isEmpty())` kontrollerini ekledim. Bu, kullanıcı kutucuğu boş bırakıp butona basarsa uygulamanın çökmesini (Crash) engeller.
3.  **Mantık:**
      * **Para Çekerken:** `if` ile bakiyenin yetip yetmediğini kontrol ettik.
      * **Faiz Hesaplarken:** `for` döngüsü ile her yıl paranın nasıl katlandığını adım adım hesaplatıp yazdırdık.

