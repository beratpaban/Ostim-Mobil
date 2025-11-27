# 📝 Ders Notu: Java'da İsimlendirme Kuralları ve Standartları

Nasıl ki Türkçede cümle kurarken uyulması gereken kurallar varsa (büyük harf, nokta vb.), Java ile konuşurken de uymamız gereken kurallar vardır.

Eğer bu kurallara uymazsak ne olur?

* **Derleyici Hatası:** Program hiç çalışmaz (kırmızı çizgiler çıkar).
* **Okunabilirlik Sorunu:** Kodunuz çalışsa bile, başka biri (veya 3 ay sonra siz) kodu anlamakta zorlanır.

Hadi başlayalım! 🚀

---

## 1. 🛑 Kırmızı Çizgiler: Kesin Kurallar (Rules)

Bu kurallar **zorunludur**. Uymazsanız Java hata verir (**Syntax Error**).

---

### 🔹 Kural 1: Boşluk Yasak!

Değişken veya sınıf isimlerinde boşluk kullanılamaz.

* ❌ Yanlış: `ogrenci numarasi`
* ✅ Doğru: `ogrenciNumarasi`

---

### 🔹 Kural 2: Sayı ile Başlanmaz!

Sayı kullanılabilir ama **en başta** olamaz.

* ❌ Yanlış: `1yazili`
* ✅ Doğru: `yazili1`

---

### 🔹 Kural 3: Özel Karakterler (Sadece `$` ve `_`)

`@, %, +, -, #` gibi karakterler kullanılamaz.

Sadece `_` ve `$` kullanılabilir (genelde `const` tanımlarında `_` tercih edilir).

* ❌ Yanlış: `not%`
* ✅ Doğru: `not_degeri`

---

### 🔹 Kural 4: Yasaklı Kelimeler (Reserved Keywords)

Java’nın anahtar kelimeleri isim olarak kullanılamaz.

* ❌ Yanlış: `int`, `class`, `if`, `else`, `public`
* ✅ Doğru: `intSayisi`, `sinifAdi`

---

### 🔹 Kural 5: Büyük/Küçük Harf Duyarlıdır (Case Sensitive)

Java için **Ali** ile **ali** tamamen farklıdır.

* `not` ve `Not` iki farklı değişkendir.

---

## 2. 🎩 Görgü Kuralları: Standartlar (Best Practices)

Bu kurallara uymazsanız program çalışır ama **profesyonel dünyada kötü kod** sayılır.

---

### 🐪 Camel Case (Deve Gösterimi)

* İlk kelime küçük, sonraki kelimelerin baş harfleri büyük.
* **Kullanım:** Değişkenler ve metodlar.

**Örnek:**
`kullaniciAdi`, `notOrtalamasiHesapla`, `okulNumarasi`

---

### 📐 Pascal Case (Paskal Gösterimi)

* Her kelime büyük harfle başlar.
* **Kullanım:** Sınıf, proje, paket isimleri.

**Örnek:**
`MainActivity`, `OgrenciListesi`, `ArabaSinifi`

---

### 🐍 Screaming Snake Case (Çığlık Atan Yılan)

* Tüm harfler büyük, kelimeler `_` ile ayrılır.
* **Kullanım:** Sabitler (constants)

**Örnek:**
`PI_SAYISI`, `GECME_NOTU`, `MAX_HIZ`

---

### ⚠️ Önemli Not: Türkçe Karakter Kullanmayın!

Farklı sistemlerde sorun çıkarabilir.

* ❌ `öğrenciYaşı`
* ✅ `ogrenciYasi`

---

## 💡 Özet Tablo: Neyin Adı Nasıl Olmalı?

| Tür           | Standart Tipi | Yazım Şekli   | Örnek                          |
| ------------- | ------------- | ------------- | ------------------------------ |
| Değişken      | Camel Case    | `kucukBuyuk`  | `adSoyad`, `sinifMevcudu`      |
| Metot         | Camel Case    | `kucukBuyuk`  | `verileriGetir()`, `hesapla()` |
| Sınıf (Class) | Pascal Case   | `BuyukBuyuk`  | `Ogrenci`, `MainActivity`      |
| Proje Adı     | Pascal Case   | `BuyukBuyuk`  | `MobilUygulamam`               |
| Sabit (Final) | Snake Case    | `BUYUK_BUYUK` | `PI_SAYISI`, `VERGI_ORANI`     |

---

## 💻 Java Kod Örneği

```java
public class OkulYonetimi { // ✅ Sınıf ismi: Pascal Case

    // Sabit tanımlama (Değeri değişmez)
    final int GECME_NOTU = 50; // ✅ Sabit: Büyük harf ve alt çizgi

    public void notHesapla() { // ✅ Metot ismi: Camel Case
        
        int yazili1 = 70;      // ✅ Değişken: Küçük harfle başlar, sayı sonda.
        
        // int 1yazili = 80;   // ❌ HATA! Sayı ile başlayamaz.
        // int yazılıNotu = 90;// ⚠️ UYARI! Türkçe karakter (ı) var.
        // int class = 10;     // ❌ HATA! 'class' yasaklı kelimedir.
        
        String ogrenciAdi = "Ahmet"; // ✅ Camel Case ve Türkçe karakter yok.
        
        // İsimlendirme standartlarına uymayan ama çalışan kötü örnek:
        int Sinifmevcudu = 20; // ⚠️ Çalışır ama değişken büyük harfle başlamamalı.
    }
}
```

---

## 🧠 Pratik Zamanı: Doğrusunu Sen Yaz! (Alıştırma)

| Hatalı / Eksik İsim | Türü     | Doğrusu               |
| ------------------- | -------- | --------------------- |
| Öğrenci Numarası    | Değişken | `[ ] ogrenciNumarasi` |
| araba               | Sınıf    | `[ ] Araba`           |
| 2.sınav             | Değişken | `[ ] sinav2`          |
| kdv oranı           | Sabit    | `[ ] KDV_ORANI`       |
| PuanHesapla         | Metot    | `[ ] puanHesapla`     |

---


