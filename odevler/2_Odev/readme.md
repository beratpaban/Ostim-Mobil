
# 📱 Mobil Uygulamalar 2. Ödev Çözümü

Bu proje, **Döngü Yapıları** ve **Metotlar** konularını pekiştirmek amacıyla hazırlanmıştır. Uygulama; faktöriyel hesaplama, sayıları toplama ve çarpım tablosu oluşturma işlevlerini yerine getirir.

---

## 🛠️ 1. Bölüm: Arayüz Tasarımı (XML)

Aşağıdaki kodlar `res/layout/activity_main.xml` dosyasına aittir. Bileşenler dikey olarak sıralanmıştır.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="[http://schemas.android.com/apk/res/android](http://schemas.android.com/apk/res/android)"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center_horizontal">

    <EditText
        android:id="@+id/editTextSayi"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Bir sayı giriniz..."
        android:inputType="number"
        android:textSize="20sp" />

    <Button
        android:id="@+id/btnFaktoriyel"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="Faktöriyel Hesapla" />

    <Button
        android:id="@+id/btnTopla"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="0'dan N'e Kadar Topla" />

    <Button
        android:id="@+id/btnCarpim"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="Çarpım Tablosunu Göster" />

    <TextView
        android:id="@+id/textViewSonuc"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="Sonuç burada görünecek"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:textColor="#333333"/>

</LinearLayout>
````

-----

## 💻 2. Bölüm: Java Kodlama (MainActivity)

Aşağıdaki kodlar `MainActivity.java` dosyasına aittir. İstenilen 3 metot ve **Challenge (Hata Kontrolü)** yapısı dahil edilmiştir.

```java
package com.example.odev2; // Kendi paket adınız buraya gelecek

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // A. Tanımlamalar
    EditText editTextSayi;
    Button btnFaktoriyel, btnTopla, btnCarpim;
    TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ID Eşleştirmeleri (Bağlantılar)
        editTextSayi = findViewById(R.id.editTextSayi);
        btnFaktoriyel = findViewById(R.id.btnFaktoriyel);
        btnTopla = findViewById(R.id.btnTopla);
        btnCarpim = findViewById(R.id.btnCarpim);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        // C. Buton Tıklama Olayları

        // 1. Faktöriyel Butonu
        btnFaktoriyel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hata Kontrolü (Challenge +10 Puan)
                if (bosAlanKontrolu()) return; 

                int girilenSayi = Integer.parseInt(editTextSayi.getText().toString());
                int sonuc = faktoriyelHesapla(girilenSayi);
                textViewSonuc.setText("Faktöriyel Sonucu: " + sonuc);
            }
        });

        // 2. Toplama Butonu
        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bosAlanKontrolu()) return;

                int girilenSayi = Integer.parseInt(editTextSayi.getText().toString());
                int sonuc = toplamiBul(girilenSayi);
                textViewSonuc.setText("Toplam Sonucu: " + sonuc);
            }
        });

        // 3. Çarpım Tablosu Butonu
        btnCarpim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bosAlanKontrolu()) return;

                int girilenSayi = Integer.parseInt(editTextSayi.getText().toString());
                // Bu metot void olduğu için sonucu kendi içinde yazdırır
                carpimTablosuYazdir(girilenSayi); 
            }
        });
    }

    // --- B. Metotların Yazılması ---

    // 1. Metot: Faktöriyel Hesaplama (Geriye Değer Döndüren)
    public int faktoriyelHesapla(int sayi) {
        int sonuc = 1;
        for (int i = 1; i <= sayi; i++) {
            sonuc = sonuc * i; // veya sonuc *= i;
        }
        return sonuc;
    }

    // 2. Metot: Toplam Hesaplama (Geriye Değer Döndüren)
    public int toplamiBul(int sayi) {
        int toplam = 0;
        for (int i = 0; i <= sayi; i++) {
            toplam = toplam + i; // veya toplam += i;
        }
        return toplam;
    }

    // 3. Metot: Çarpım Tablosu (Void - Değer Döndürmeyen)
    public void carpimTablosuYazdir(int sayi) {
        String tabloMetni = ""; // Metinleri birleştirmek için boş String
        
        for (int i = 1; i <= 10; i++) {
            // Örnek: 5 x 1 = 5 (Alt satıra geç)
            tabloMetni += sayi + " x " + i + " = " + (sayi * i) + "\n";
        }
        
        textViewSonuc.setText(tabloMetni);
    }

    // 🚀 CHALLENGE METODU: Boş Alan Kontrolü
    // Bu metot true dönerse alan boştur, false dönerse doludur.
    public boolean bosAlanKontrolu() {
        if (editTextSayi.getText().toString().isEmpty()) {
            Toast.makeText(this, "Lütfen bir sayı giriniz!", Toast.LENGTH_SHORT).show();
            return true; // Hata var, işlem yapma
        }
        return false; // Hata yok, devam et
    }
}
```

-----

## 📝 Proje Notları & Puanlama Kontrolü

  * [x] **XML Tasarımı:** EditText (Number), 3 Buton ve 1 TextView eksiksiz eklendi.
  * [x] **Metot 1 (Faktöriyel):** `int` dönüş tipli ve `for` döngüsü kullanıldı.
  * [x] **Metot 2 (Toplam):** `int` dönüş tipli ve sayaçlı döngü kullanıldı.
  * [x] **Metot 3 (Çarpım Tablosu):** `void` yapıda tasarlandı ve sonucu doğrudan TextView'e yazdırdı. `\n` kaçış karakteri kullanıldı.
  * [x] **OnClicks:** Tüm butonlar ilgili metotları çağırıyor.
  * [x] **İsimlendirme:** `camelCase` kuralına (örn: `faktoriyelHesapla`) uyuldu.
  * [x] **Challenge (+10 Puan):** Kullanıcı sayı girmeyip butona basarsa uygulama çökmez, "Lütfen bir sayı giriniz" uyarısı verir.