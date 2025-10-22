# 👋🏻 Selam Arkadaşlar

# Ünite 4.1.2: Karar Yapıları - if-else\! 🚦

`if-else` yapısı, hayatımızdaki seçimler gibidir. Bir yol ayrımına geldiğinizde iki seçeneğiniz olur: sağa dönmek ya da sola dönmek. `if-else` de programımıza tam olarak böyle bir yol ayrımı sunar.

> **Günlük Hayattan Bir Örnek:**
> Hava durumunu kontrol ettiğimizi düşünelim.
>
>   * **Eğer (if)** hava yağmurluysa, **şemsiye alırım.**
>   * **Değilse (else)**, **güneş gözlüğü takarım.**
>
> Gördüğünüz gibi, her iki durum için de bir eylem planımız var. Programımız artık kararsız kalmıyor\!

## `if-else` Nedir ve Neden Gerekli?

`if` yapısı, bir şartın sadece doğru (`true`) olması durumuyla ilgilenir. Şart yanlışsa (`false`) `if` bloğunu atlar ve yoluna devam eder. 

Ancak bazen şart yanlış olduğunda da özel bir işlem yapmak isteriz. İşte `else` ifadesi burada devreye girer. `else`, kelime anlamı olarak "**aksi halde**" demektir. 

`if-else` yapısı sayesinde programımızdaki `true` (doğru) ve `false` (yanlış) durumlarını birbirinden tamamen ayırırız ve her iki durum için de farklı kod blokları çalıştırabiliriz. 

### 📝 Söz Dizimi (Syntax)

Java'da `if-else` yapısını aşağıdaki gibi yazarız:

```java
if (şart ifadesi) {
  // Bu blok, şartın sonucu 'true' (doğru) ise çalışır.
} else {
  // Bu blok ise, şartın sonucu 'false' (yanlış) ise çalışır.
}
```


## 💻 Uygulama Zamanı: Kullanıcı Giriş Ekranı

Şimdi ders kitabımızdaki 3. Uygulamayı inceleyerek `if-else` yapısını daha iyi anlayalım. 

**Senaryomuz:** Bir kullanıcı adı ve şifre belirleyeceğiz. Kullanıcı, `EditText` kutularına bu bilgileri girdiğinde, doğru olup olmadığını kontrol edip "Giriş Başarılı" veya "Giriş Başarısız" mesajı vereceğiz.

### Kod İncelemesi

Kullanıcı "Onayla" butonuna tıkladığında çalışan `onayla` metodumuzun içindeki en önemli kısım burası:

```java
// EditText'lerden girilen kullanıcı adı ve şifreyi alıyoruz.
String kullaniciAdiGiris = editText_KullaniciAdi.getText().toString();
String sifreGiris = editText_Sifresi.getText().toString();

// Sabit olarak belirlediğimiz doğru bilgilerle karşılaştırıyoruz.
if (kullaniciAdi.equals(kullaniciAdiGiris) && sifre.equals(sifreGiris)) {
    // Koşul DOĞRU ise bu blok çalışır.
    Toast.makeText(this, "Kullanıcı Girişi Başarılı", Toast.LENGTH_LONG).show();
} else {
    // Koşul YANLIŞ ise bu blok çalışır.
    Toast.makeText(this, "Kullanıcı Adı veya Şifresi Hatalı", Toast.LENGTH_LONG).show();
}
```

Bu kodda iki önemli yeni kavram var. Gelin, onlara yakından bakalım\!

### ⚠️ Önemli Not: String Karşılaştırması (`.equals()` vs `==`)

Arkadaşlar, bu çok önemli bir konu\! Java'da `String` yani metinsel ifadeleri karşılaştırırken aklımıza ilk olarak `==` operatörü gelebilir. Ancak bu bizi yanıltır\!

  * `==` operatörü, iki değişkenin hafızadaki *referanslarının* yani adreslerinin aynı olup olmadığını kontrol eder. 
  * `.equals()` metodu ise iki `String` değişkenin *içeriklerinin*, yani değerlerinin aynı olup olmadığına bakar. 

> **Basit Bir Örnek:** İki farklı kağıda "Merhaba" yazdığımızı düşünelim.
>
>   * `==` ile sorduğumuz soru: "Bu iki kağıt, aynı kağıt mı?" (Cevap: Hayır)
>   * `.equals()` ile sorduğumuz soru: "İki kağıdın üzerinde de 'Merhaba' mı yazıyor?" (Cevap: Evet)
>
> İşte bu yüzden, metinlerin içeriğini kontrol etmek istediğimizde **her zaman `.equals()` kullanmalıyız\!**

### Mantıksal Operatörler: `&&` (Ve) Operatörü

Kodumuzdaki `if` koşulunda `&&` işaretini gördünüz mü? Bu, "VE" anlamına gelen mantıksal bir operatördür.

`&&` operatörü, kendisine bağlanan iki koşulun da **aynı anda doğru** olmasını zorunlu kılar.

Kullanıcı giriş örneğimizde, girişin başarılı sayılması için:

1.  Kullanıcı adının doğru olması **VE**
2.  Şifrenin de doğru olması gerekir.

İkisinden biri bile yanlışsa, `if` koşulu `false` olur ve program `else` bloğunu çalıştırır.

-----

> ### 🎯 Özet Kutucuğu
>
>   * **`if-else`**, bir koşulun hem doğru (`true`) hem de yanlış (`false`) olma durumları için ayrı yollar sunar.
>   * `if` bloğu koşul doğruysa, `else` bloğu ise koşul yanlışsa çalışır.
>   * Java'da metinsel ifadelerin (`String`) içeriğini karşılaştırmak için `==` yerine her zaman **`.equals()`** metodunu kullanırız.
>   * **`&&` (VE)** operatörü, bağladığı tüm koşulların aynı anda `true` olmasını gerektirir.

-----

### ✅ Alıştırma Zamanı\!

Şimdi öğrendiklerimizi pekiştirelim.

  * [ ] **Soru 1:** Bir öğrencinin notu 50'den büyük veya eşitse ekrana "Geçtiniz", değilse "Kaldınız" yazan bir `if-else` kod bloğu yazar mısınız?

    ```java
    int ogrenciNotu = 65;

    if (ogrenciNotu >= 50) {
        System.out.println("Geçtiniz");
    } else {
        System.out.println("Kaldınız");
    }
    ```

<br>

  * [ ] **Soru 2:** Bir mağazada 18 yaşından büyük **ve** parası 100 TL'den fazla olan bir kişinin alışveriş yapabildiği bir senaryo düşünün. Bu iki şartı `if` içinde `&&` operatörüyle nasıl birleştirirsiniz?




    ```java
    int yas = 20;
    double para = 150.0;

    if (yas > 18 && para > 100.0) {
        System.out.println("Alışveriş yapabilirsiniz.");
    } else {
        System.out.println("Maalesef, alışveriş için şartları sağlamıyorsunuz.");
    }
    ```




<br>

  * [ ] **Soru 3:** `if-else` yapısında `else` bloğu ne zaman çalışır?
      * [ ] Koşul `true` olduğunda
      * [x] Koşul `false` olduğunda
      * [ ] Her zaman


# Ünite 4.1.3: Karar Yapıları - if-else-if ile Çoklu Seçenekler Dünyası\! 🗺️


`if-else-if` yapısı, programa adeta bir kontrol listesi sunar. Program, listedeki şartları yukarıdan aşağıya doğru tek tek kontrol eder. Hangi şart ilk olarak sağlanırsa, o şartın kod bloğunu çalıştırır ve zincirin geri kalanını tamamen atlayarak yoluna devam eder.

> **Günlük Hayattan Bir Örnek:**
> Bir restoranda menüye baktığınızı düşünün.
>
>   * **Eğer (if)** canım çorba istiyorsa, **mercimek çorbası sipariş ederim.**
>   * **Değilse eğer (else if)** canım et yemeği istiyorsa, **köfte sipariş ederim.**
>   * **Değilse eğer (else if)** canım sebze yemeği istiyorsa, **taze fasulye sipariş ederim.**
>   * **Değilse (else)** (hiçbiri değilse), **sadece salata yerim.**
>
> Köfte siparişi verdiğiniz an, menünün geri kalanına bakmayı bırakırsınız. `if-else-if` de tam olarak böyle çalışır\!

## `if-else-if` Nedir?

Bu yapı, birbirini takip eden `if` koşullarından oluşur.

1.  Program ilk `if` koşuluna bakar. Sonuç `true` ise o bloğu çalıştırır ve zincirden çıkar.
2.  Eğer ilk `if` koşulu `false` ise, bir sonraki `else if` koşulunu kontrol eder. `true` ise o bloğu çalıştırır ve zincirden çıkar.
3.  Bu süreç, `true` olan bir koşul bulunana veya zincir bitene kadar devam eder.
4.  Eğer hiçbir `if` veya `else if` koşulu sağlanmazsa, en sonda bulunan (isteğe bağlı) `else` bloğu çalışır. Bu `else` bloğu, "yukarıdakilerden hiçbiri değilse" anlamına gelen bir varsayılan durumdur.

### 📝 Söz Dizimi (Syntax)

```java
if (şart 1) {
  // Şart 1 doğru ise bu blok çalışır.
} else if (şart 2) {
  // Şart 1 yanlış AMA Şart 2 doğru ise bu blok çalışır.
} else if (şart 3) {
  // İlk iki şart yanlış AMA Şart 3 doğru ise bu blok çalışır.
} else {
  // Yukarıdaki şartların HİÇBİRİ doğru değilse bu blok çalışır.
}
```



## 💻 Uygulama Zamanı: Not Ortalaması Hesaplama

Ders kitabımızdaki 5. Uygulama, `if-else-if` yapısını anlamak için mükemmel bir örnek. 

**Senaryomuz:** Öğrencinin girdiği üç notun ortalamasını hesaplayacağız. Bu ortalamaya göre, 5'lik not sistemindeki karşılığını (0, 1, 2, 3, 4 veya 5) bir `Toast` mesajı ile ekranda göstereceğiz. 

### Kod İncelemesi

Önce notları alıp ortalamayı hesaplıyoruz:

```java
int not1 = Integer.parseInt(editTextNot1.getText().toString());
int not2 = Integer.parseInt(editTextNot2.getText().toString());
int not3 = Integer.parseInt(editTextNot3.getText().toString());

float ort = (not1 + not2 + not3) / 3;
```



Şimdi de bu `ort` (ortalama) değişkenini kullanarak `if-else-if` zincirimizi kuruyoruz:

```java
if (ort >= 0 && ort < 25) {
    Toast.makeText(this, "0 ile kaldınız.", Toast.LENGTH_LONG).show();
} else if (ort >= 25 && ort < 50) {
    Toast.makeText(this, "1 ile kaldınız.", Toast.LENGTH_LONG).show();
} else if (ort >= 50 && ort < 60) {
    Toast.makeText(this, "2 ile geçtiniz.", Toast.LENGTH_LONG).show();
} else if (ort >= 60 && ort < 70) {
    Toast.makeText(this, "3 ile geçtiniz.", Toast.LENGTH_LONG).show();
} else if (ort >= 70 && ort < 85) {
    Toast.makeText(this, "4 ile geçtiniz.", Toast.LENGTH_LONG).show();
} else if (ort >= 85 && ort <= 100) {
    Toast.makeText(this, "5 ile geçtiniz. Tebrikler", Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(this, "Girilen Not Bilgileri Hatalıdır.", Toast.LENGTH_LONG).show();
}
```


**Nasıl Çalışıyor?**
Diyelim ki öğrencinin ortalaması `75`.

1.  Program ilk `if`'e bakar: `ort` (75), 0 ile 25 arasında mı? **Hayır.**
2.  Bir sonraki `else if`'e geçer: `ort` (75), 25 ile 50 arasında mı? **Hayır.**
3.  Bir sonrakine geçer...
4.  `else if (ort >= 70 && ort < 85)` koşuluna gelir: `ort` (75), 70 ile 85 arasında mı? **Evet\!**
5.  Program bu bloğun içindeki `Toast` mesajını ("4 ile geçtiniz.") çalıştırır ve **zincirin geri kalanına hiç bakmadan** yapıdan çıkar.

-----

> ### 🎯 Özet Kutucuğu
>
> \* `if-else-if` yapısı, ikiden fazla koşul veya seçenek olduğunda kullanılır.
>
>   * Koşullar, yazıldığı sırayla (yukarıdan aşağıya) kontrol edilir.
>   * Program, doğru (`true`) olan **ilk** koşulu bulduğu an, o bloğu çalıştırır ve zincirin geri kalanını atlar.
>   * En sondaki `else` bloğu, yukarıdaki koşullardan hiçbiri sağlanmazsa çalışacak olan "joker" veya "varsayılan" bloktur.

-----

### ✅ Alıştırma Zamanı\!

  * [ ] **Soru 1:** Bir trafik ışığı programı yazdığımızı düşünelim. `String renk = "sarı";` değişkenine göre `if-else-if` yapısını kullanarak:

      * Eğer renk "kırmızı" ise "Dur\!"
      * Eğer renk "sarı" ise "Hazırlan\!"
      * Eğer renk "yeşil" ise "Geç\!"
      * Hiçbiri değilse "Hatalı Renk\!" yazdıran kodu oluşturun.

 


    ```java
    String renk = "sarı";

    if (renk.equals("kırmızı")) {
        System.out.println("Dur!");
    } else if (renk.equals("sarı")) {
        System.out.println("Hazırlan!");
    } else if (renk.equals("yeşil")) {
        System.out.println("Geç!");
    } else {
        System.out.println("Hatalı Renk!");
    }
    ```

<br>

  * [ ] **Soru 2:** `if-else-if` yapısında, doğru olan bir `else if` koşulu bulunduktan sonra ne olur?
      * [ ] Program diğer `else if` bloklarını da kontrol etmeye devam eder.
      * [x] Program o bloğu çalıştırır ve `if-else-if` zincirinin geri kalanını atlar.
      * [ ] Program en sondaki `else` bloğunu da çalıştırır.
