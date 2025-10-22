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

Harika iş çıkardınız\! `if-else` mantığı, programlarımıza karar verme yeteneği kazandırmanın en temel yollarından biridir. Bir sonraki dersimizde `if-else-if` ile yol ayrımlarını daha da artıracağız. Kodlamaya devam\! 🚀