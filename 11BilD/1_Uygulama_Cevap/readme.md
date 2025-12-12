
# 🏃‍♂️ Sağlık Asistanım: Proje Çözüm ve Açıklama Dokümanı

Bu doküman, **Sağlık ve Spor Uygulaması** performans ödevinin çözüm adımlarını, kullanılan Java/Android kavramlarını ve kod mantığını detaylıca açıklamak için hazırlanmıştır.

---

## 📚 İçindekiler
1. [Proje Amacı](#proje-amacı)
2. [Bölüm 1: Sınıf Tasarımı (Backend)](#bölüm-1-sınıf-tasarımı-backend)
3. [Bölüm 2: Arayüz Tasarımı (Frontend)](#bölüm-2-arayüz-tasarımı-frontend)
4. [Bölüm 3: Kodlama ve Mantık (MainActivity)](#bölüm-3-kodlama-ve-mantık-mainactivity)
5. [Değerlendirme Kriterleri ve İpuçları](#değerlendirme-kriterleri-ve-ipuçları)

---

## Proje Amacı
Bu proje, öğrencilerin **Nesne Tabanlı Programlama (OOP)** temellerini (Kapsülleme, Kalıtım) ve temel algoritma yapılarını (Karar Yapıları, Döngüler) gerçek bir mobil uygulama senaryosu üzerinde uygulamasını hedefler.

---

## Bölüm 1: Sınıf Tasarımı (Backend)

Bu bölümde veri güvenliği ve kodun yeniden kullanılabilirliği esas alınmıştır.

### A. Temel Sınıf: `Birey.java`
Bu sınıf, uygulamadaki genel kullanıcı özelliklerini taşır.

* **Kapsülleme (Encapsulation):** Değişkenler `private` (özel) yapılarak dışarıdan doğrudan erişim engellenmiştir. Erişim `Getter` ve `Setter` metotları ile sağlanır. Bu, verinin kontrolsüz değiştirilmesini önler .
* **VKE Hesaplama Mantığı:** Vücut Kitle Endeksi formülü ($Kilo / Boy^2$) burada bir metot olarak tanımlanır.

**Örnek Kod Yapısı:**
```java
public class Birey {
    // Kapsülleme: Değişkenler private
    private String adSoyad;
    private double boy;
    private double kilo;

    // Getter ve Setter Metotları (Erişim için)
    public void setBoy(double boy) { this.boy = boy; }
    public double getBoy() { return boy; }
    
    public void setKilo(double kilo) { this.kilo = kilo; }
    public double getKilo() { return kilo; }

    // İşlem Metodu
    public double vkeHesapla() {
        return kilo / (boy * boy);
    }
}
````

### B. Alt Sınıf: `Sporcu.java`

Bu sınıf, `Birey` sınıfının özelliklerini miras alır ve üzerine sporcuya özgü özellikler ekler.

  * **Kalıtım (Inheritance):** `extends Birey` komutu ile `Birey` sınıfındaki boy, kilo gibi özellikler tekrar yazılmadan buraya aktarılır.
  * **Kalori Hesabı:** Dakika başına ortalama 10 kalori yakıldığı varsayılarak `süre * 10` formülü uygulanır.

**Örnek Kod Yapısı:**

```java
public class Sporcu extends Birey { // Birey sınıfından miras alındı
    private int kosuSuresi;

    public void setKosuSuresi(int sure) { this.kosuSuresi = sure; }

    public int kaloriYakimiHesapla() {
        return kosuSuresi * 10; // Örnek mantık: Dakikada 10 kalori
    }
}
```

-----

## Bölüm 2: Arayüz Tasarımı (Frontend)

Kullanıcı arayüzü `res/layout/activity_main.xml` dosyasında **ConstraintLayout** kullanılarak tasarlanır. Bu yerleşim türü, nesnelerin birbirine göre hizalanmasını sağlayarak ekran kaymalarını önler.

**Gerekli Bileşenler:**

1.  **EditText (Girdi Alanları):**
      * `etBoy`: `inputType="numberDecimal"` (Ondalıklı sayı girmek için).
      * `etKilo`: `inputType="numberDecimal"`.
      * `etSure`: `inputType="number"`.
2.  **Button (İşlem Düğmeleri):**
      * `btnAnaliz`: VKE hesaplamak için.
      * `btnKalori`: Kalori tablosu oluşturmak için.
3.  **TextView (Sonuç Ekranı):**
      * `tvSonuc`: Hesaplamaların yazdırılacağı alan.

-----

## Bölüm 3: Kodlama ve Mantık (MainActivity)

Bu bölümde arayüz ve sınıflar `MainActivity.java` dosyasında birleştirilir.

### Adım 1: Tanımlama ve Nesne Oluşturma

XML dosyasındaki bileşenler Java kodunda `findViewById` ile tanımlanır. Ayrıca `Sporcu` sınıfından bir nesne üretilir.

```java
// Sınıf seviyesinde tanımlamalar
EditText etBoy, etKilo, etSure;
TextView tvSonuc;
Sporcu yeniSporcu = new Sporcu(); // Nesne üretimi
```

### Adım 2: Durum Analizi (If-Else Yapısı)

"Durum Analizi" butonuna tıklandığında:

1.  Kullanıcıdan alınan veriler `Double.parseDouble()` ile sayıya çevrilir.
2.  `yeniSporcu.setBoy()` ve `setKilo()` ile nesneye aktarılır.
3.  `vkeHesapla()` metodu çağrılır.
4.  Çıkan sonuç **If-Else If-Else** karar yapısı ile kontrol edilir.

**Kod Mantığı:**

```java
double sonuc = yeniSporcu.vkeHesapla();
String durum = "";

if (sonuc < 18.5) {
    durum = "Zayıf";
} else if (sonuc >= 18.5 && sonuc < 25) {
    durum = "Normal / Sağlıklı";
} else if (sonuc >= 25 && sonuc < 30) {
    durum = "Fazla Kilolu";
} else {
    durum = "Obezite Sınırı";
}

tvSonuc.setText("VKE: " + sonuc + "\nDurum: " + durum);
```

### Adım 3: Kalori Cetveli (For Döngüsü)

"Kalori Cetveli" butonuna tıklandığında:

1.  Süre bilgisi alınır.
2.  **For Döngüsü** kurularak, sayaç 5'er 5'er artırılır (`i+=5`). Bu sayede her dakika yerine sadece 5. , 10. , 15. dakikalar hesaplanır.
3.  Döngü her döndüğünde sonuç, önceki metnin üzerine eklenir (String Concatenation `+=`).

**Kod Mantığı:**

```java
int toplamSure = Integer.parseInt(etSure.getText().toString());
String tablo = "--- Kalori Yakım Tablosu ---\n";

// Döngü 1'den başlar, süreye kadar 5'er artarak devam eder
for (int i = 5; i <= toplamSure; i += 5) {
    int yakilan = i * 10; // Dakika * 10 kalori
    tablo += i + ". Dakika: " + yakilan + " kalori yakıldı.\n";
}

tvSonuc.setText(tablo);
```

-----

## Değerlendirme Kriterleri ve İpuçları

Bu projeyi değerlendirirken aşağıdaki noktalara dikkat ediniz:

  * ✅ **Kapsülleme:** Değişkenlere doğrudan (`yeniSporcu.boy = 1.80`) erişilmemeli, `setBoy(1.80)` kullanılmalıdır.
  * ✅ **Kalıtım:** `Sporcu` sınıfında boy ve kilo değişkenleri tekrar tanımlanmamalı, `extends` ile `Birey` sınıfından alınmalıdır.
  * ✅ **Tip Dönüşümü:** `EditText`'ten gelen veri `String` olduğu için matematiksel işlem yapmadan önce `Double` veya `Integer`'a çevrilmelidir (Parsing).
  * ✅ **Döngü Mantığı:** `for` döngüsünün artış miktarı `i++` değil, `i+=5` olmalıdır.

-----

*Başarılar\! Bu doküman proje sürecinde rehberiniz olacaktır.*

```
```