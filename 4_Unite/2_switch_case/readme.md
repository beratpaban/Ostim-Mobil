# Ünite 4.1.4: Karar Yapıları - `switch-case` ile Tanışın\! 🎛️

Bir önceki dersimizde, `if-else-if` yapısıyla birden fazla koşulu nasıl kontrol edeceğimizi öğrendik. Bu yapı çok güçlü olsa da, bazen elimizdeki tek bir değişkenin alabileceği çok sayıda farklı değere göre işlem yapmak istediğimizde kodumuz uzayabilir ve karmaşıklaşabilir.

İşte bu gibi durumlar için Java bize daha temiz ve okunabilir bir alternatif sunar: `switch-case` yapısı\!

> **Günlük Hayattan Bir Örnek:**
> Bir otomat makinesi düşünün. Bir düğmeye bastığınızda (örneğin "B3"), makine sadece o düğmeye atanmış olan ürünü verir. Diğer ürünleri kontrol etmez.
>
>   * **Eğer (switch)** seçilen düğme **"B3" ise (case)**, **sana çikolata verir.**
>   * **Eğer (switch)** seçilen düğme **"A1" ise (case)**, **sana su verir.**
>   * **Eğer (switch)** seçilen düğme **"C5" ise (case)**, **sana bisküvi verir.**
>
> `switch-case` de tam olarak böyle çalışır. Tek bir değeri kontrol eder ve o değere uyan durumu (case) bularak ilgili işlemi yapar.

## `switch-case` Nedir ve Nasıl Çalışır?

`switch-case`, bir değişkenin değerini, önceden tanımlanmış bir dizi "durum" (`case`) ile karşılaştırır. Değişkenin değeri hangi `case` ifadesiyle eşleşirse, o `case` bloğunun içindeki kod çalıştırılır.

Bu yapı, özellikle tek bir değişkenin alabileceği çok sayıda net ve sabit değere (örneğin bir ayın numarası, haftanın bir günü, bir menü seçeneği vb.) göre farklı işlemler yapmak istediğimizde `if-else-if` zincirlerine göre çok daha temiz bir alternatiftir.

### 📝 Söz Dizimi (Syntax)

Java'da `switch-case` yapısının temel iskeleti şöyledir:

```java
switch (kontrol edilecek değişken) {
    case değer1:
        // Değişkenin değeri 'değer1' ile eşleşirse bu kodlar çalışır.
        break; // Durumdan çık.
    case değer2:
        // Değişkenin değeri 'değer2' ile eşleşirse bu kodlar çalışır.
        break; // Durumdan çık.
    case değer3:
        // Değişkenin değeri 'değer3' ile eşleşirse bu kodlar çalışır.
        break; // Durumdan çık.
    default:
        // Yukarıdaki 'case'lerden hiçbiri eşleşmezse bu kodlar çalışır.
}
```

*Kaynak: mobil.pdf (4.bolum.pdf, Sayfa 136)*

#### Anahtar Kelimeler:

  * `switch`: Kontrol edilecek değişkeni parantez içine alır ve yapıyı başlatır.
  * `case`: Değişkenin alabileceği olası bir değeri belirtir.
  * `break`: Çok önemlidir\! Eşleşen `case` bloğundaki kod çalıştıktan sonra `switch` yapısından tamamen çıkılmasını sağlar. Eğer unutulursa, program alttaki `case`'leri de çalıştırmaya devam eder\!
  * `default`: İsteğe bağlıdır. Eğer değişkenin değeri yukarıdaki `case`'lerden hiçbirine uymuyorsa çalışacak olan "joker" bloktur. `if-else-if` yapısındaki en son `else` bloğuna benzer.

## 💻 Uygulama Zamanı: Hangi Aydayız?

Ders kitabımızdaki 6. Uygulama, `switch-case` yapısını anlamak için harika bir örnek.

**Senaryomuz:** Kullanıcı `EditText` kutusuna bir ayın numarasını (1-12 arası) girecek. "Onayla" butonuna bastığında, program bu sayının hangi aya ait olduğunu bularak `TextView` içinde gösterecek.

### Kod İncelemesi

Kullanıcı "Onayla" butonuna tıkladığında çalışan `onayla` metodumuzun içindeki `switch-case` bloğuna odaklanalım:

```java
public void onayla(View view) {
    int sayiAy = Integer.parseInt(number.getText().toString());
    String ay = ""; // Sonucu tutacağımız boş bir metin değişkeni.
    
    switch (sayiAy) {
        case 1:
            ay = "OCAK";
            break;
        case 2:
            ay = "ŞUBAT";
            break;
        case 3:
            ay = "MART";
            break;
        // ... (diğer aylar) ...
        case 12:
            ay = "ARALIK";
            break;
        default:
            ay = "YANLIŞ BİLGİ";
            break; // default'tan sonra break zorunlu olmasa da iyi bir alışkanlıktır.
    }
    
    textView.setText(ay); // Sonucu TextView'e yazdır.
}
```

*Kaynak: mobil.pdf (4.bolum.pdf, Sayfa 138)*

**Nasıl Çalışıyor?**
Diyelim ki kullanıcı `3` sayısını girdi.

1.  Program `switch (sayiAy)` satırına gelir. `sayiAy` değişkeninin değeri `3`'tür.
2.  `case 1:` ile kontrol eder. Eşleşiyor mu? **Hayır.**
3.  `case 2:` ile kontrol eder. Eşleşiyor mu? **Hayır.**
4.  `case 3:` ile kontrol eder. Eşleşiyor mu? **Evet\!**
5.  Program bu bloğa girer ve `ay` değişkenine `"MART"` değerini atar.
6.  `break;` komutunu görür ve `switch` yapısından **tamamen çıkar**.
7.  `textView.setText(ay);` satırına gelir ve ekrana "MART" yazar.

-----

> ### 🎯 Özet Kutucuğu
>
>   * `switch-case`, tek bir değişkenin değerini birden fazla olası durumla (`case`) karşılaştırmak için kullanılır.
>   * `if-else-if` zincirlerine göre daha temiz ve okunabilir bir alternatiftir.
>   * **`break;` komutu hayatidir\!** Bir `case` bloğunun sonuna `break` koymazsanız, program alttaki `case`'leri de kontrol etmeden çalıştırmaya devam eder. Buna "fall-through" hatası denir.
>   * `default` bloğu, hiçbir `case` eşleşmediğinde çalışacak olan yedek plandır.

-----

### ✅ Alıştırma Zamanı\!

  * [ ] **Soru 1:** Bir öğrencinin 1'den 5'e kadar olan notunu harf sistemine (`1=Zayıf`, `2=Geçer`, `3=Orta`, `4=İyi`, `5=Peki`) çeviren bir `switch-case` yapısı yazar mısınız? `default` durumu olarak "Geçersiz Not" yazdırın.


    ```java
    int not = 4;
    String harfNotu = "";

    switch (not) {
        case 1:
            harfNotu = "Zayıf";
            break;
        case 2:
            harfNotu = "Geçer";
            break;
        case 3:
            harfNotu = "Orta";
            break;
        case 4:
            harfNotu = "İyi";
            break;
        case 5:
            harfNotu = "Peki";
            break;
        default:
            harfNotu = "Geçersiz Not";
            break;
    }
    System.out.println(harfNotu);
    ```


<br>

  * [ ] **Soru 2:** Bir `case` bloğunun sonuna `break;` koymayı unutursak ne olur?
      * [ ] Program hata verir ve çalışmaz.
      * [x] Program o `case` bloğunu çalıştırdıktan sonra alttaki `case` bloğunu da (koşuluna bakmadan) çalıştırmaya devam eder.
      * [ ] Program `default` bloğunu çalıştırır.

`switch-case` yapısını da öğrendiğimize göre, programlarımıza karar aldırma konusunda artık çok daha güçlüyüz\! Bir sonraki dersimizde döngüler dünyasına heyecan verici bir giriş yapacağız. Harika işti, devam edin\! 💪