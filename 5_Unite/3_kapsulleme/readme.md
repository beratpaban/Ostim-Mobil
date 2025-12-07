# 🛡️ 5.3.2. Getter ve Setter Metotları - Ders Notları

Merhaba,
Bugün, sınıfımızın içindeki "özel" (private) bilgilere kimlerin, nasıl ulaşacağını yöneten **Kapı Görevlilerini** (Getter ve Setter) tanıyacağız.

---

## 🚪 Neden İhtiyacımız Var?

Düşünün ki bir `Personel` sınıfımız var ve içinde `yas` diye bir değişkenimiz var. Eğer bu değişkeni herkese açık (`public`) yaparsak, birisi yanlışlıkla yaşı **-50** yapabilir. İnsan yaşı eksi olamaz, değil mi?

İşte bu yüzden değişkenleri **gizli (private)** yaparız, onlara ulaşmak isteyenler için de **kontrollü kapılar (metotlar)** açarız.

* **Getter (Alıcı/Okuyucu):** Değeri okumak isteyenler için. ("Yaş kaç?" diye sorar.)
* **Setter (Atayıcı/Yazıcı):** Değeri değiştirmek isteyenler için. ("Yaşı 25 yap" der.)

---

## 🔍 1. Getter Metodu (Değer Okuma)

Gizli (`private`) olan bir değişkenin değerini dışarıya göstermek için kullanılır.

* **Görevi:** Sadece değeri döndürmektir (`return`).
* **Özelliği:** Bazen değeri olduğu gibi değil, değiştirerek verebiliriz (Mesela ismin hepsini BÜYÜK HARF yaparak).

**Kitap Örneği (Sayfa 190-191):**
```java
public class Personel {
    private String ad; // Dışarıya kapalı değişken

    // Getter Metodu
    public String getAd() {
        // İsim istendiğinde hepsini büyük harf yapıp gönderiyoruz!
        return ad.toUpperCase(); 
    }
}
````

-----

## ✏️ 2. Setter Metodu (Değer Atama)

Gizli (`private`) olan bir değişkene yeni bir değer atamak için kullanılır. **En önemli özelliği, hatalı veri girişini engelleyebilmesidir.**

  * **Görevi:** Dışarıdan gelen veriyi alıp, sınıfın içindeki değişkene atar (`this.ad = ad`).
  * **Özelliği:** "If-Else" kullanarak kontrol yapabiliriz.

**Kitap Örneği (Sayfa 192):** Yaş Kontrolü

```java
public class Personel {
    private int yas; // Dışarıya kapalı

    // Setter Metodu
    public void setYas(int yas) {
        // Kural: Yaş 18'den küçük veya 55'ten büyük olamaz!
        if (yas < 18 || yas > 55) {
            System.out.println("Hatalı yaş girişi! Otomatik olarak 18 yapıldı.");
            this.yas = 18; // Hata varsa varsayılan değer ata
        } else {
            this.yas = yas; // Her şey yolundaysa kaydet
        }
    }
    
    // Getter Metodu
    public int getYas() {
        return yas;
    }
}
```

-----

## ⚡ İpucu: Otomatik Oluşturma (Sayfa 190)

Bu metotları tek tek elle yazmanıza gerek yok\! Android Studio sizin için yazabilir.

1.  Sınıf dosyanız açıkken **`Code > Generate`** menüsüne gidin (veya **`Alt + Insert`** tuşlarına basın).
2.  Açılan listeden **"Getter and Setter"** seçeneğini tıklayın.
3.  Hangi değişkenler için istiyorsanız seçip **OK** deyin.
4.  Bum\! Kodlar hazır. 🎉

-----

## 🎮 Sıra Sizde\! (Sınıf İçi Etkinlik)

Haydi bir **"Banka Hesabı"** sistemi kuralım.

**Senaryo:** `BankaHesabi` diye bir sınıfımız var. İçinde `private double bakiye` (para miktarı) var.

1.  **Getter:** Bakiyeyi öğrenmek isteyen biri `getBakiye()` çağırdığında, parayı görebilsin.
2.  **Setter:** Hesaba para yatırmak/çekmek için `setBakiye()` kullanılsın.
      * **Kural:** Bakiye asla **0'ın altına düşmemeli\!** Eğer biri eksi bakiye yapmaya çalışırsa (örneğin -100), işlem reddedilsin ve bakiye 0 olsun.

> **Görev:** Bu senaryonun Java kodunu yazabilir misiniz? `if-else` yapısını `setBakiye` içinde kullanmayı unutmayın\!

-----

## ✅ Özet (Hızlı Tekrar)

  * [ ] Değişkenler **private** (gizli), Metotlar **public** (açık) olmalıdır.
  * [ ] **Getter:** `getDegiskenAdi()` şeklinde yazılır, `return` ile değer döndürür.
  * [ ] **Setter:** `setDegiskenAdi()` şeklinde yazılır, `void`'dir (değer döndürmez), parametre alır.
  * [ ] **this:** Sınıfın kendi değişkenini belirtmek için kullanılır (Karışıklığı önler).

-----

