# 👋🏻 Selam Arkadaşlar

## Üçüncü Öğrenme Birimi: Temel Komutlar

### 3.2 Değişkenler: Bilgileri Sakladığımız Kutular

  * **Nedir?** Değişkenler, program içinde verileri (sayı, metin vb.) geçici olarak saklamak için kullandığımız isimlendirilmiş hafıza alanlarıdır. 
  * **Benzetme:** Değişkenleri, üzerine etiket yapıştırdığımız kutulara benzetebiliriz. 
      * **Değişkenin Adı:** Kutunun üzerindeki etiket (`yas`, `kullaniciAdi` gibi). 
      * **Değişkenin Değeri:** Kutunun içindeki bilgi (`17`, `"ahmet"` gibi). 
      * **Veri Tipi:** Kutunun ne tür bir bilgi saklayabileceği (sadece sayı kutusu, sadece metin kutusu vb.). 

#### Değişken Tanımlama ve Değer Atama

Java'da bir değişken kullanmadan önce onu "tanımlamamız", yani sisteme bildirmemiz gerekir.

```java
// Değişken Tanımlama (Declaration)
// Sisteme diyoruz ki: "Bana tam sayı saklayabileceğim, adı 'puan' olan bir kutu ayır."
int puan; 

// Değer Atama (Assignment)
// "puan" etiketli kutunun içine 85 değerini koy.
puan = 85; 

// Tanımlama ve Atamayı Birlikte Yapma
// "Bana tam sayı saklayabilen, adı 'yas' olan bir kutu ayır ve içine 16 değerini koy."
int yas = 16; 
```

### 3.3 Veri Tipleri: Kutularımızın Çeşitleri

Java'da temelde iki tür veri tipi (kutu çeşidi) vardır: İlkel Tipler ve Referans Tipler.

#### 3.3.1 İlkel (Temel) Veri Tipleri

Bunlar en basit, temel veri tipleridir ve tek bir değer tutarlar. 

  * **Tam Sayılar:**
      * `int`: En çok kullanılan tam sayı tipidir (-2 milyar ile +2 milyar arası). Örnek: `int okulNumarasi = 123;`
      * `long`: Çok daha büyük tam sayılar için kullanılır.  Örnek: `long tcKimlikNo = 12345678901L;` (Sonuna 'L' harfi konur). 
      * `byte`, `short`: Daha küçük tam sayılar için kullanılır, hafızada daha az yer kaplarlar. 
  * **Ondalıklı Sayılar:**
      * `double`: Ondalıklı sayılar için genellikle bu kullanılır. Örnek: `double ortalama = 85.5;`
      * `float`: Daha az hassasiyetli ondalıklı sayılar için.  Örnek: `float pi = 3.14f;` (Sonuna 'f' harfi konur).
  * **Mantıksal Değer:**
      * `boolean`: Sadece iki değer alabilir: `true` (doğru) veya `false` (yanlış).  Tıpkı bir lamba anahtarı gibi: ya açık ya kapalı. Örnek: `boolean sinifiGectiMi = true;`
  * **Karakter:**
      * `char`: Sadece tek bir karakter (harf, rakam, sembol) tutar ve tek tırnak içinde yazılır.  Örnek: `char sube = 'A';`

#### 3.3.2 Referans Veri Tipleri

İlkel tiplerden daha karmaşık yapıları ve verileri tutarlar.

  * **String:** En çok kullanacağımız referans tipidir. Metinleri, yani karakter dizilerini saklamak için kullanılır ve çift tırnak içinde yazılır. 
      * **Örnek:** `String adSoyad = "Ali Veli";`

> **Pro-İpucu:** `char` tek bir harf için `'A'`, `String` ise bir metin için `"Merhaba"` kullanır. Tek tırnak ve çift tırnak farkına dikkat\!

### 3.6 Operatörler: Değişkenlerle İşlem Yapmak

Değişkenlerimizi kullanarak matematiksel ve mantıksal işlemler yaparız.

  * **Aritmetik Operatörler:** Bildiğimiz matematik işlemleri\! 
      * `+` (Toplama), `-` (Çıkarma), `*` (Çarpma), `/` (Bölme)
      * `%` (Mod Alma): Bir sayının diğerine bölümünden kalanı verir. Örnek: `10 % 3` işleminin sonucu `1`'dir.
      * `++` (Bir Artırma), `--` (Bir Eksiltme): Bir sayının değerini 1 artırır veya azaltır. `sayi++;`
  * **Atama Operatörleri:** Bir değişkene değer atamak veya mevcut değerini güncellemektir. 
      * `=`: Sağdaki değeri soldaki değişkene atar. `yas = 17;`
      * `+=`, `-=`: Değişkenin mevcut değerine ekleme veya çıkarma yapar. `puan += 5;` (puan = puan + 5; ile aynıdır).
  * **Karşılaştırma Operatörleri:** İki değeri karşılaştırır ve sonuç olarak `boolean` (`true` veya `false`) bir değer döndürür. 
      * `==`: Eşit mi?
      * `!=`: Eşit değil mi?
      * `>`: Büyük mü? `<`: Küçük mü?
      * `>=`: Büyük veya eşit mi? `<=`: Küçük veya eşit mi?
  * **Mantıksal Operatörler:** Birden fazla karşılaştırma ifadesini birleştirmek için kullanılır.
      * `&&` (VE - AND): Her iki şart da doğruysa `true` döner. Örnek: `(yas > 18 && ehliyetiVarMi == true)`
      * `||` (VEYA - OR): Şartlardan en az biri doğruysa `true` döner. Örnek: `(gun == "Cumartesi" || gun == "Pazar")`
      * `!` (DEĞİL - NOT): Bir ifadenin sonucunu tersine çevirir. `true` ise `false`, `false` ise `true` yapar.

### 3.7 Hata Ayıklama (Debugging): Dedektiflik Zamanı\!

  * **Nedir?** Yazdığımız kodda beklenmedik şekilde çalışan veya uygulamayı çökerten hataları bulma ve düzeltme işlemidir.
  * **Neden Gerekli?** En iyi programcılar bile hata yapar\! Önemli olan bu hataları bir dedektif gibi bulup çözebilmektir.
  * **Temel Araçlarımız:**
      * **Logcat:** Uygulamamızın "günlük defteri" gibidir.  Kodumuzun içine `Log.d("Etiket", "Mesajım burada");` gibi komutlar yazarak Logcat paneline mesajlar gönderebilir ve programın hangi adımlardan geçtiğini anlık olarak takip edebiliriz.
      * **Breakpoint (Durak Noktası):** Kodumuzda belirli bir satırın yanına kırmızı bir nokta koyarak programın tam o satırda durmasını sağlayabiliriz. Program durduğunda, o andaki tüm değişkenlerin değerlerini inceleyebilir ve hatanın nerede olduğunu tespit edebiliriz.

> **⭐ Ünite Özeti**
>
>   * **Değişkenler**, verileri sakladığımız etiketli kutulardır.
>   * **Veri tipleri**, bu kutuların ne tür bilgi (`int` tam sayı, `String` metin, `boolean` doğru/yanlış) saklayacağını belirler.
>   * **Operatörler** ile bu değişkenleri kullanarak matematiksel (`+`, `-`, `*`, `/`, `%`) ve mantıksal (`==`, `&&`, `||`) işlemler yaparız.
>   * Kodumuzda bir hata olduğunda, **Logcat**'e mesajlar yazdırarak veya **Breakpoint**'ler koyarak bir dedektif gibi hatayı buluruz.

> **🧠 Kontrol Noktası**
>
> 1.  Bir kullanıcının yaşını saklamak için hangi ilkel veri tipini kullanmak en mantıklısıdır?
> 2.  `sayi % 2 == 0` ifadesi neyi kontrol eder? (İpucu: Bir sayının 2'ye bölümünden kalan 0 ise o sayı...)
> 3.  İki şartın *aynı anda* doğru olmasını kontrol etmek için hangi mantıksal operatörü kullanırız?
> 4.  Kodunuzun belirli bir satırda durup beklemesini sağlayan hata ayıklama aracının adı nedir?

Umarım bu notlar dersi daha iyi anlamanıza yardımcı olur.

