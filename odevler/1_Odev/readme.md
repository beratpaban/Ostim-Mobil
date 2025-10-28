# Mobil Uygulamalar 1. Ödev Çözümleri (Java)

Bu belge, "Mobil Uygulamalar 1. Ödev" kapsamında yer alan soruların Java programlama diline göre çözümlerini ve bu çözümlere dair açıklamaları içermektedir.

## 1) Değişken Tanımlama

Bu bölümde, Java'daki temel (ilkel) veri tipleri ve `String` sınıfı için değişkenlerin nasıl tanımlanacağı ve onlara nasıl değer atanacağı gösterilmektedir.

```java
/* 1) Değişken Tanımlama */

// Short değişken tanımla ve değer ata
short kisaSayi = 32000;

// Byte değişken tanımla ve değer ata
byte kucukSayi = 120;

// Long değişken tanımla ve değer ata
long uzunSayi = 9000000000L; // long değerlerin sonuna 'L' konulması zorunludur.

// Integer değişken tanımla ve değer ata
int tamSayi = 1500;

// Boolean değişken tanımla ve değer ata
boolean dogruMu = true; // veya false

// String değişken tanımla ve değer ata
String metin = "Merhaba Dünya"; // String bir sınıftır, ilkel tip değildir.

// Sabit tanımla ve değer ata
final double PI_SAYISI = 3.14; // 'final' anahtar kelimesi ile bir sabit (değeri değiştirilemez) tanımlanır.
```

**Açıklamalar:**
* **`byte`, `short`, `int`, `long`**: Tamsayı verilerini tutmak için kullanılırlar. Aralarındaki fark, tuttukları değer aralığıdır (bellek boyutu).
* **`boolean`**: Sadece `true` (doğru) veya `false` (yanlış) mantıksal değerlerini tutar.
* **`String`**: Metin verilerini (karakter dizilerini) tutar. Java'da `S` harfi büyük yazılır.
* **`final`**: Bir değişkenin önüne geldiğinde, o değişkenin değerinin program içinde bir daha değiştirilemeyeceğini belirtir. Bu tür değişkenlere "sabit" (constant) denir.

---

## 2) Aritmetik İşlemler

Bu bölümde, verilen değişkenler kullanılarak Java'daki temel aritmetik işlemlerin sonuçları hesaplanmıştır.

**Verilen Değişkenler:**
* `int s1 = 3;`
* `int s2 = 11;`
* `float s3 = 12.0f;`
* `float s4 = 0.5f;`

**Çözümler:**

| Soru | Cevap | Açıklama |
| :--- | :--- | :--- |
| `s1 + s2` | `14` | 3 + 11 |
| `s1 - s2` | `-8` | 3 - 11 |
| `s1 * s2` | `33` | 3 * 11 |
| `s1 / s2` | `0` | **ÖNEMLİ:** Java'da iki tamsayı (`int`) bölündüğünde, sonuç ondalıklı kısmı atılarak yine tamsayı olur. (3 / 11 = 0.27... -> 0) |
| `s3 + s4` | `12.5` | 12.0f + 0.5f (İşlemde `float` var) |
| `s3 - s4` | `11.5` | 12.0f - 0.5f |
| `s3 * s4` | `6.0` | 12.0f * 0.5f |
| `s3 / s4` | `24.0` | 12.0f / 0.5f (İşlemde `float` olduğu için sonuç `float` tipindedir) |
| `(s1 + s2) / s1` | `4` | (3 + 11) / 3 = 14 / 3. Tamsayı bölmesi olduğu için sonuç 4'tür (4.66... -> 4). |
| `s2 % s1` | `2` | `%` (Mod alma) operatörü, bölme işleminden kalanı verir. 11'in 3'e bölümünden kalan 2'dir. |
| `(s1 * s4) % s1` | `1.5` | (3 * 0.5f) % 3 = 1.5f % 3. 1.5'in 3'e bölümünden kalan 1.5'tir. |
| `(s1 / 2) % s2` | `1` | Önce parantez içi: `s1 / 2` (3 / 2) tamsayı bölmesi olduğundan sonuç `1` olur. Sonra `1 % s2` (1 % 11) işleminin sonucu `1`'dir. |

---

## 3) Karşılaştırma ve Mantıksal İşlemler

Bu bölümde, verilen değişkenler kullanılarak karşılaştırma (`>`, `<`, `==`, `!=`) ve mantıksal (`&&`, `||`, `!`) işlemlerin sonuçları (her zaman `boolean` - `true` veya `false`) hesaplanmıştır.

**Verilen Değişkenler:**
* `int s1 = 5;`
* `int s2 = 12;`
* `int s3 = 45;`
* `int s4 = 34;`

**Çözümler:**
*(Not: PDF'teki `s4=s1` ve `s2=s3` gibi ifadelerin karşılaştırma (`==`) olması gerektiği varsayılmış, `s2s3` ifadesinin `s2 < s3` olduğu varsayılmıştır.)*

| Soru | Cevap | Açıklama |
| :--- | :--- | :--- |
| `s1 > s2` | `false` | 5 > 12 (Yanlış) |
| `s3 > 45` | `false` | 45 > 45 (Yanlış, eşit) |
| `s3 > s1` | `true` | 45 > 5 (Doğru) |
| `s1 >= 5` | `true` | 5 >= 5 (Doğru, "büyük veya eşit") |
| `s3 <= s1` | `false` | 45 <= 5 (Yanlış) |
| `s1 <= 5` | `true` | 5 <= 5 (Doğru, "küçük veya eşit") |
| `s3 == 45` | `true` | 45 == 45 (Doğru, "eşittir") |
| `s3 != 45` | `false` | 45 != 45 (Yanlış, "eşit değildir") |
| `(s3 > s1) && (s2 > s1)` | `true` | (45 > 5) `&&` (12 > 5) -> `true && true` -> **`true`** (`&&` - VE: Her iki taraf da doğru olmalı) |
| `(s2 < s3) &#124; (s1 > s4)` | `true` | (12 < 45) `&#124;&#124;` (5 > 34) -> `true || false` -> **`true`** (`||` - VEYA: Taraflardan en az biri doğru olmalı) |
| `!(s3 <= s4)` | `true` | !(45 <= 34) -> !(false) -> **`true`** (`!` - DEĞİL: Sonucun tersini alır) |
| `( (s1 > s2) && (s2 > s3) ) || (s4 == s1)` | `false` | ( (5 > 12) `&&` (12 > 45) ) `||` (34 == 5) -> (`false && false`) `||` `false` -> `false || false` -> **`false`** |
| `(s4 != s1) &#124; (s2 == s3)` | `true` | (34 != 5) `&#124;` (12 == 45) -> `true &#124; false` -> **`true`** |
| `((s2 < s3) || (s4 < s1)) && (s3 != s2)` | `true` | ( (12 < 45) `||` (34 < 5) ) `&&` (45 != 12) -> (`true || false`) `&&` `true` -> `true && true` -> **`true`** |

---

## 4) Koşullu Durum Problemi

Bu bölümde, bir öğrencinin notlarına göre "Geçti", "Bütünlemeye Kaldı" veya "Kaldı" durumunu belirleyen Java kodu istenmektedir.

**Koşullar:**
1.  **Geçer:** Ortalama $((s1+s2)/2)$ >= 60 **VE** devam notu (s3) >= 70 ise.
2.  **Bütünlemeye Kalır:** Ortalama >= 50 **VEYA** proje notu (s4) >= 80 ise (ve 1. koşul sağlanmıyorsa).
3.  **Kalır:** Diğer tüm durumlarda (Aksi durumda).

**Çözüm Kodu (Java):**

```java
/*
    4) Koşullu Durum Problemi
    
    Aşağıdaki kod parçası, bir Java metodu veya main bloğu içinde çalışabilir.
    s1, s2, s3, s4 değişkenlerinin daha önce 'int' olarak tanımlandığı varsayılmaktadır.
*/

// Örnek Değerler (Test için):
// int s1 = 70; // 1. Sınav
// int s2 = 80; // 2. Sınav
// int s3 = 75; // Devam Notu
// int s4 = 60; // Proje Notu

/* Ortalamayı (s1+s2)/2 olarak hesaplarsak, tamsayı bölmesi (integer division)
    olur ve 75.5 gibi bir sonuç 75'e yuvarlanır.
    Doğru ondalıklı sonucu almak için (s1+s2) / 2.0f (veya 2.0) yazmalıyız.
*/
float ortalama = (s1 + s2) / 2.0f;

// Koşullar sırayla 'if', 'else if', 'else' ile kontrol edilir.

// 1. Geçme Koşulu
if (ortalama >= 60 && s3 >= 70) {
    System.out.println("Öğrenci Geçti");
}
// 2. Bütünleme Koşulu (Eğer 1. koşul sağlanmazsa burası kontrol edilir)
else if (ortalama >= 50 || s4 >= 80) {
    System.out.println("Öğrenci Bütünleme Sınavına Kaldı");
}
// 3. Kalma Koşulu (Eğer ilk iki koşul da sağlanmazsa burası çalışır)
else {
    System.out.println("Öğrenci Kaldı");
}
```

**Açıklama:**
* Kod, bir `if - else if - else` bloğu kullanır. Bu yapı, koşulları yukarıdan aşağıya doğru sırayla kontrol eder.
* Bir koşul (`if` veya `else if`) `true` (doğru) olarak değerlendirildiği anda, o bloğun içindeki kod çalışır ve diğer bloklar (kalan `else if` veya `else`) atlanır.
* Önce "Geçme" durumu kontrol edilir. Eğer öğrenci geçtiyse, "Bütünleme" koşuluna hiç bakılmaz.
* Eğer "Geçme" koşulu sağlanmazsa, program "Bütünleme" koşulunu kontrol eder.
* Eğer "Geçme" ve "Bütünleme" koşullarının ikisi de sağlanmazsa, son olarak `else` bloğu çalışır ve öğrencinin "Kaldı" olduğu `System.out.println` ile konsola yazdırılır.