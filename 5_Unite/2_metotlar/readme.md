Aşağıdaki metni tamamen **Markdown formatına uygun**, düzenli, okunabilir ve eğitim materyali formatında yeniden yazdım:

---

# 📚 Ders: Gelişmiş Komutlar - Metotlar (Methods)

**Hedef Kitle:** 11. Sınıf / Mobil Uygulamalar Dersi
**Konu:** 5.1 — Metot
**Amaç:** Kod tekrarını önlemek ve programları yönetilebilir parçalara bölmek.

---

## 1. Metot Nedir? Neden Kullanırız? 🤔

Bir program yazarken aynı kodu tekrar tekrar yazdığını fark ettin mi? Bu hem yorucu hem de hata yapmaya açık bir yöntemdir. İşte burada **Metotlar** devreye girer!

### 💡 Günlük Hayattan Örnek

Bir yemek tarifi düşün:
Her seferinde “2 yumurta kır, çırp, un ekle, karıştır…” demek yerine bu işlemlerin hepsine **“Kek Çırp”** adını veriyoruz.
Ne zaman kek yapacaksak sadece **“Kek Çırp”** diyoruz.

**Metotlar da kodların paketlenmiş hâlidir.**

---

### 🎯 Temel Prensip: DRY (Don't Repeat Yourself – Kendini Tekrar Etme)

> Aynı işi yapan kodları bir blok içinde toplarsak, kodumuz daha düzenli olur.

---

## 2. Bir Metodun Anatomisi (Yapısı) 🦴

Java'da bir metot belirli bölümlerden oluşur:

```java
// Erişim Belirleyici - Dönüş Tipi - Metot Adı - (Parametreler)
public             void          selamVer    () {
    // Metot Gövdesi (Yapılacak İşler)
    System.out.println("Merhaba!");
}
```

### 🧩 Metot Bölümleri

* **Erişim Belirleyici (public/private):**
  Metoda kimlerin erişebileceğini belirler.

* **Geri Dönüş Tipi (void/int/String...):**
  Metot işini bitirdikten sonra geri bir değer döndürüyor mu?
  Döndürmüyorsa → `void`

* **Metot Adı:**
  Metoda verdiğimiz isimdir.
  → **Camel Case** kullanılır: `hesapla`, `veriGetir`

* **Parametre Listesi:**
  Metodun çalışması için dışarıdan veri gerekiyor mu?
  Varsa parantez içine yazılır.

---

## 3. Metot Çeşitleri

---

### A. Değer Döndürmeyen Metotlar (void) 🛑

Bu metotlar bir işi yapar ve biter. Geriye değer göndermezler.

**Örnek:**
Birine “Kapıyı kapat” dersin → gider kapatır → geri gelip “kapattım” demesine gerek yoktur.

#### Java Kodu Örneği

```java
// Metodun Tanımlanması
private void selamVer() {
    // Sadece mesaj gösterir, geriye veri göndermez
    Toast.makeText(getApplicationContext(), "Merhaba", Toast.LENGTH_LONG).show();
}

// Metodun Çağrılması
selamVer();
```

---

### B. Değer Döndüren Metotlar (return) ↩️

Bu metotlar bir işlem yapar ve sonucunu bize **geri döndürür**.

**Örnek:**
“5 ile 10'u toplayınca kaç eder?” → Arkadaşın: “15” der.
Bu **return edilen** değerdir.

#### Java Kodu Örneği

```java
// int: Metot geriye bir tam sayı döndürür
private int topla() {
    return 5 + 10;
}

// Kullanım
int sonuc = topla(); // sonuc = 15
```

---

### C. Parametre Alan Metotlar 📥

Metodun daha dinamik olmasını istiyorsak ona dışarıdan veri gönderebiliriz.

**Örnek:**
Blender'a muz koyarsan muzlu süt, çilek koyarsan çilekli süt yapar.
Blender = metot
Meyve = parametre

#### Java Kodu Örneği

```java
// Parantez içindeki değişkenler parametrelerdir
private int topla(int sayi1, int sayi2) {
    return sayi1 + sayi2;
}

// Kullanım
int sonuc1 = topla(10, 20); // 30
int sonuc2 = topla(5, 3);   // 8
```

---

## 4. Metotlarda Aşırı Yükleme (Method Overloading) 🏋️

Aynı isimde birden fazla metot yazabiliriz.
**Koşul:** Parametre sayıları veya türleri farklı olmalı.

Bu duruma **Method Overloading** denir.

### Neden Kullanılır?

Bazen kullanıcı 2 sayıyı toplamak ister, bazen 3 sayıyı.
Her biri için ayrı isim yazmak yerine aynı ismi kullanmak daha düzenlidir.

#### Java Kodu Örneği

```java
// 1. Durum: İki sayıyı toplar
private int topla(int sayi1, int sayi2) {
    return sayi1 + sayi2;
}

// 2. Durum: Üç sayıyı toplar
private int topla(int sayi1, int sayi2, int sayi3) {
    return sayi1 + sayi2 + sayi3;
}

// Kullanım
topla(5, 10);      // İlk metot
topla(5, 10, 20);  // İkinci metot
```

---

## 📝 Özet ve İpuçları (Cheat Sheet)

* [ ] **DRY Prensibi:** Kendini tekrar etme, metot kullan.
* [ ] **void:** Geri dönüş yoksa kullanılır.
* [ ] **return:** Sonucu geri göndermek için zorunludur (void hariç).
* [ ] **Parametre:** Metoda dışarıdan gönderilen veridir.
* [ ] **Overloading:** Aynı isimli metodun farklı parametrelerle tanımlanmasıdır.

---

## 🧠 Alıştırma Sorusu

**Soru:**
Aşağıdaki özelliklere sahip bir metot yazın:

* Adı: `alanHesapla`
* Parametre: 2 adet tam sayı (`kisaKenar`, `uzunKenar`)
* Bu iki sayıyı çarpıp sonucu geri döndürsün (`return`)

**Cevap:**

<details>
<summary>📌 Cevabı Görmek İçin Tıkla</summary>

```java
private int alanHesapla(int kisaKenar, int uzunKenar) {
    int alan = kisaKenar * uzunKenar;
    return alan;
}
```

</details>

---

Öğretmenim, bu notları Notion’da paylaşabilir veya sınıfta tahtaya yansıtabilirsiniz.
Bir sonraki konuya geçelim mi?
📌 **Sıradaki konu: Sınıf ve Nesne (Class & Object)**
