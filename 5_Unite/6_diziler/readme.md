# 📦 5.6. Diziler (Arrays) - Detaylı Konu Anlatımı

Merhaba,
Bugün, verilerimizi dağınık halde bırakmak yerine onları düzenli raflara yerleştirmeyi öğreneceğiz. Değişkenler tek bir bilgiyi tutar, peki ya elimizde 100 tane not bilgisi varsa? 100 tane ayrı değişken mi tanımlayacağız? Tabii ki hayır! İşte **Diziler** burada devreye giriyor.

---

## 🧐 Dizi (Array) Nedir?

Diziler, **aynı türden** birden fazla veriyi tek bir isim altında saklamamızı sağlayan veri depolarıdır.

Bunu bir **Öğrenci Dolabı** gibi düşünebilirsiniz:
* Dolabın bir adı vardır (Örn: 9-A Sınıfı Dolapları).
* Dolabın gözleri numaralandırılmıştır (0, 1, 2...).
* Her göze sadece belirli türde eşya (Örn: Sadece Kitap) koyabilirsiniz.

---

## ⚠️ Dizilerin 3 Altın Kuralı

1.  **Türdeşlik:** Bir diziye `int` (tam sayı) dediyseniz, içine sadece tam sayı koyabilirsiniz. Arasına "Ahmet" yazamazsınız.
2.  **Sabit Boyut:** Dizi oluştururken "Bana 5 kişilik yer ayır" derseniz, bu boyut **asla değişmez**. Sonradan 6. kişiyi ekleyemezsiniz.
3.  **Sıfırdan Başlar:** Bilgisayar dünyasında sayma işlemi 1'den değil, **0'dan** başlar.

---

## 🛠️ Dizi Nasıl Oluşturulur?

Java'da dizi oluşturmak için `new` anahtar kelimesini ve köşeli parantezleri `[]` kullanırız.

### 1. Yöntem: Boş Yer Ayırtma (Rezervasyon)
Henüz verilerin ne olduğunu bilmiyoruz ama kaç tane olacağını biliyorsak bu yöntemi kullanırız.

```java
// VeriTipi[] DiziAdi = new VeriTipi[Boyut];

// 5 tane tam sayı saklayacak "notlar" isminde bir dizi
Integer[] notlar = new Integer[5]; 

// Şu an hafızada 5 tane boş kutu oluştu: [null, null, null, null, null]
````

### 2\. Yöntem: Dolu Dizi Oluşturma

Verilerin ne olduğu en başından belliyse, `new` demeden süslü parantez `{}` ile direkt oluşturabiliriz.

```java
// Boyutu otomatik olarak 3 olur.
String[] arabalar = {"Togg", "Tesla", "Ford"};
```

-----

## ✍️ Diziye Veri Ekleme ve Okuma

Dizinin içindeki kutulara (indekslere) ulaşmak için köşeli parantez `[]` içine sıra numarasını yazarız.

### Veri Ekleme (Atama)

```java
Integer[] sayilar = new Integer[3]; // 3 kişilik yer açtık (0, 1, 2)

sayilar[0] = 50;  // 0. kutuya (ilk sıraya) 50 koyduk 
sayilar[1] = 85;  // 1. kutuya 85 koyduk 
sayilar[2] = 100; // 2. kutuya 100 koyduk 

// sayilar[3] = 90; ❌ HATA! (ArrayIndexOutOfBoundsException)
// Çünkü dizimiz 3 kişilikti. Sadece 0, 1 ve 2. koltuklar var.
```

### Veri Okuma

```java
// 1. kutudaki (85) veriyi alıp ekrana yazdıralım
System.out.println("İkinci Sayı: " + sayilar[1]); 
```

-----

## 🔄 Döngülerle Dizi Kullanımı

Dizilerin en büyük gücü **döngülerle (for, while)** birlikte kullanıldığında ortaya çıkar. Tek tek `sayilar[0]`, `sayilar[1]` yazmak yerine döngüyle hepsini gezebiliriz.

**Örnek:** Bir dizideki sayıların toplamını bulalım (Sayfa 209'daki örneğe benzer).

```java
public class DiziToplama {
    public static void main(String[] args) {
        // Dizimizi tanımlayalım ve dolduralım
        Integer[] harcliklar = {10, 20, 50, 100, 200};
        
        int toplam = 0;

        // For döngüsü ile dizinin başından (0) sonuna (length) kadar geziyoruz
        for (int i = 0; i < harcliklar.length; i++) {
            toplam = toplam + harcliklar[i];
            // i=0 iken harcliklar[0] (10) toplanır
            // i=1 iken harcliklar[1] (20) toplanır...
        }

        System.out.println("Toplam Harçlık: " + toplam);
    }
}
```

> 💡 **İpucu:** `diziAdi.length` komutu, dizinin kaç elemanlı olduğunu (boyutunu) bize söyler.

-----

## 🧠 Karşılaştırma: Değişken vs Dizi

| Özellik | Normal Değişken (`int x`) | Dizi (`int[] x`) |
| :--- | :--- | :--- |
| **Kapasite** | Sadece 1 değer tutar. | Birden fazla değer tutar. |
| **Hafıza** | Tek bir adresi vardır. | Yan yana sıralı adresleri vardır. |
| **Erişim** | İsmiyle çağrılır (`x`). | İndeks numarasıyla çağrılır (`x[0]`). |

-----

## 🚀 Sıra Sizde\! (Sınıf İçi Etkinlik)

**Senaryo:** Öğretmenimiz 3 öğrencinin sözlü notunu sisteme girmek istiyor.

1.  `sozluNotlari` adında 3 elemanlı bir `Integer` dizisi oluşturun.
2.  Sırasıyla 90, 80 ve 100 notlarını bu diziye atayın.
3.  Ekrana **sadece ortadaki** (ikinci) notu yazdırın.

> **Cevabı kodlayarak deneyelim\!**

-----

## ✅ Özet (Hızlı Tekrar)

  * [ ] Dizi tanımlamak için `[]` işareti kullanılır.
  * [ ] Dizilerin boyutu **sabittir**, sonradan değiştirilemez.
  * [ ] İndeksler **0'dan başlar**. 5 elemanlı bir dizinin son indeksi 4'tür.
  * [ ] `dizi.length` özelliği dizinin uzunluğunu verir.

-----