# 🛒 Mobil Uygulamalar 3. Ödev Çözümü: Sanal Market

Bu proje, Java'da **Sınıf (Class) yapısı**, **Constructor (Yapıcı Metot)** kullanımı ve **Metotlar** aracılığıyla nesnelerin yönetilmesi konularını pekiştirmek amacıyla hazırlanmıştır.

---

## 📦 1. Bölüm: Sınıf Tasarımı (Urun.java)

Bu sınıf, ürünlerin özelliklerini (değişkenler) ve yeteneklerini (metotlar) tanımlar.

**Dosya Yolu:** `java/com.example.sanalmarket/Urun.java`

```java
package com.example.sanalmarket;

import android.util.Log; // Logcat'e çıktı vermek için gerekli kütüphane

public class Urun {

    // A. Özellikler (Değişkenler - Public olarak tanımlandı)
    public String urunAdi;
    public double fiyat;
    public int stokAdedi;

    // B. Yapıcı Metot (Constructor)
    // Nesne oluşturulurken ilk değerleri atamak için kullanılır.
    public Urun(String urunAdi, double fiyat, int stokAdedi) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.stokAdedi = stokAdedi;
    }

    // --- C. Yetenekler (Metotlar) ---

    // 1. Bilgi Göster Metodu
    public void bilgiGoster() {
        // Logcat ekranında "SanalMarket" etiketiyle bilgileri gösterir.
        Log.i("SanalMarket", "--------------------------");
        Log.i("SanalMarket", "Ürün Adı: " + urunAdi);
        Log.i("SanalMarket", "Fiyat: " + fiyat + " TL");
        Log.i("SanalMarket", "Stok: " + stokAdedi + " adet");
    }

    // 2. Satış Yap Metodu (Stok Kontrollü)
    public void satisYap(int adet) {
        if (stokAdedi >= adet) {
            stokAdedi -= adet; // Stoktan düş
            Log.i("SanalMarket", "✅ Satış Başarılı! Satılan Adet: " + adet);
            Log.i("SanalMarket", "Kalan Stok: " + stokAdedi);
        } else {
            Log.e("SanalMarket", "❌ HATA: Yetersiz Stok! İstenen: " + adet + ", Mevcut: " + stokAdedi);
        }
    }

    // 3. Fiyat Güncelle Metodu
    public void fiyatGuncelle(double yeniFiyat) {
        this.fiyat = yeniFiyat;
        Log.i("SanalMarket", "🏷️ Fiyat Güncellendi! Yeni Fiyat: " + this.fiyat + " TL");
    }
}
````

-----

## 📱 2. Bölüm: Ana Ekran ve Test (MainActivity.java)

Bu bölümde `Urun` sınıfından nesneler türetilip metotları test edilmektedir.

**Dosya Yolu:** `java/com.example.sanalmarket/MainActivity.java`

```java
package com.example.sanalmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- SENARYO 1: Laptop Ürünü ---
        // 1. Nesne Üretme (Constructor kullanımı)
        Urun urun1 = new Urun("Gaming Laptop", 25000.0, 10);

        // 2. Metotları Test Etme
        urun1.bilgiGoster();          // Başlangıç bilgilerini yazdır
        urun1.satisYap(2);            // 2 tane sat
        urun1.fiyatGuncelle(27500.0); // Zam yap
        urun1.bilgiGoster();          // Son durumu gör

        
        // --- SENARYO 2: Telefon Ürünü (Hata Kontrolü Testi) ---
        Urun urun2 = new Urun("Akıllı Telefon", 15000.0, 3);
        
        urun2.bilgiGoster();
        urun2.satisYap(5); // Stoktan fazla satış denemesi (Hata vermeli)
    }
}
```

-----

## 🔍 Sonuçları Nasıl Göreceğim? (Logcat)

Bu ödevde sonuçları görmek için Android Studio'nun alt kısmındaki **Logcat** penceresini kullanıyoruz.

1.  Uygulamayı çalıştırın (Run).
2.  Alt paneldeki **Logcat** sekmesine tıklayın.
3.  Arama çubuğuna **`SanalMarket`** yazın (Metotlarda bu etiketi kullandık).
4.  Çıktılarınız aşağıdakine benzer olacaktır:

<!-- end list -->

```text
I/SanalMarket: --------------------------
I/SanalMarket: Ürün Adı: Gaming Laptop
I/SanalMarket: Fiyat: 25000.0 TL
I/SanalMarket: Stok: 10 adet
I/SanalMarket: ✅ Satış Başarılı! Satılan Adet: 2
I/SanalMarket: Kalan Stok: 8
I/SanalMarket: 🏷️ Fiyat Güncellendi! Yeni Fiyat: 27500.0 TL
...
I/SanalMarket: Ürün Adı: Akıllı Telefon
I/SanalMarket: Stok: 3 adet
E/SanalMarket: ❌ HATA: Yetersiz Stok! İstenen: 5, Mevcut: 3
```

-----

## ✅ Kontrol Listesi

  * [x] `Urun` sınıfı oluşturuldu.
  * [x] Değişkenler (`urunAdi`, `fiyat`, `stokAdedi`) public olarak tanımlandı.
  * [x] **Constructor** (Yapıcı Metot) yazıldı ve veriler eşitlendi.
  * [x] `bilgiGoster()` metodu ile veriler Logcat'e yazdırıldı.
  * [x] `satisYap()` metodunda **if-else** ile stok kontrolü yapıldı.
  * [x] `MainActivity` içinde `new` anahtar kelimesi ile nesneler üretildi ve test edildi.

<!-- end list -->

```