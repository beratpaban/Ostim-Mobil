# 🚀 5.6.2. ArrayList (Dinamik Diziler) - Konu Anlatımı

Merhaba,
Daha önce standart dizileri (Arrays) öğrenmiştik. Hani şu "Bana 5 kişilik yer ayır" dediğimiz ve sonradan 6. kişiyi asla kabul etmeyen yapılar.

Bugün, o sınırları kaldırıyoruz! Karşınızda lastik gibi uzayıp kısalabilen, içine istediğimiz kadar veri atabileceğimiz yapı: **ArrayList!**

---

## 🤔 ArrayList Nedir?

ArrayList, standart dizilerin aksine **boyutu önceden belirlenmek zorunda olmayan**, eleman ekledikçe büyüyen, sildikçe küçülen dinamik bir liste yapısıdır.

### 🆚 Standart Dizi vs ArrayList

| Özellik | Standart Dizi (`String[]`) | ArrayList (`ArrayList<String>`) |
| :--- | :--- | :--- |
| **Boyut** | Sabittir (Değiştirilemez) 🔒 | Dinamiktir (Değişir) 📏 |
| **Hız** | Çok hızlıdır ⚡ | Biraz daha yavaştır 🐢 |
| **Veri Tipi** | Hem ilkel (`int`) hem nesne tutar | **Sadece nesne (`Integer`) tutar** |
| **Kütüphane** | Ekstra kütüphane gerekmez | `import java.util.ArrayList;` gerekir |

> ⚠️ **Önemli Kural:** ArrayList içine `int`, `double`, `boolean` gibi ilkel veri tiplerini **doğrudan yazamayız**. Onların "Kibar" halleri olan (Kapsayıcı Sınıf / Wrapper Class) hallerini kullanmalıyız.
> * `int` ➡️ `Integer`
> * `double` ➡️ `Double`

---

## 🛠️ Nasıl Tanımlanır?

ArrayList kullanmak için kodun en tepesine şu kütüphaneyi eklemeliyiz:
`import java.util.ArrayList;`

**Tanımlama Şablonu:**
`ArrayList<VeriTipi> listeAdi = new ArrayList<>();`

```java
// Örnek: İsimleri tutacak bir liste
ArrayList<String> isimler = new ArrayList<>();

// Örnek: Sayıları tutacak bir liste (Dikkat: int değil Integer!)
ArrayList<Integer> sayilar = new ArrayList<>();
````

-----

## ⚡ ArrayList Metotları (Yetenekleri)

ArrayList'i yönetmek için hazır komutlar (metotlar) kullanırız. İşte en sık kullanılanlar:

### 1\. Ekleme: `.add()`

Listeye yeni bir eleman ekler. İster sona ekler, ister araya kaynak yapar.

```java
isimler.add("Ali");      // Sona ekler
isimler.add("Zeynep");   // Ali'den sonra ekler
isimler.add(1, "Can");   // 1. sıraya (Ali ile Zeynep arasına) Can'ı ekler
```

### 2\. Silme: `.remove()`

Listeden eleman siler. İster sıra numarasıyla (indeks), ister elemanın kendisiyle silebilirsiniz.

```java
isimler.remove(0);       // 0. sıradaki (İlk eleman) silinir.
isimler.remove("Zeynep"); // "Zeynep" ismi bulunup silinir.
```

### 3\. Temizleme: `.clear()`

Listenin içindeki **her şeyi** siler, bomboş yapar.

```java
isimler.clear(); // Liste tertemiz oldu!
```

### 4\. Arama: `.contains()`

Aradığınız şey listede var mı yok mu? Sonuç `true` (var) veya `false` (yok) döner.

```java
if (isimler.contains("Ahmet")) {
    System.out.println("Ahmet listede var!");
}
```

### 5\. Boyut Öğrenme: `.size()`

Listede kaç eleman olduğunu söyler (Standart dizilerdeki `.length` gibidir).

### 6\. Kopyalama: `.clone()`

Listenin birebir kopyasını oluşturur.

```java
// Listenin yedeğini almak için:
ArrayList<String> yedekListe = (ArrayList<String>) isimler.clone();
```

-----

## 💻 Örnek Uygulama: Alışveriş Sepeti

Haydi öğrendiklerimizi birleştirelim\!

```java
import java.util.ArrayList;

public class MarketSepeti {
    public static void main(String[] args) {
        // 1. Sepetimizi oluşturalım
        ArrayList<String> sepet = new ArrayList<>();

        // 2. Ürünleri ekleyelim
        sepet.add("Ekmek");
        sepet.add("Süt");
        sepet.add("Yumurta");
        System.out.println("Sepet: " + sepet); 
        // Çıktı: [Ekmek, Süt, Yumurta]

        // 3. Araya çikolata sıkıştıralım (0. sıraya)
        sepet.add(0, "Çikolata");
        
        // 4. Süt'ü listeden çıkaralım
        sepet.remove("Süt");

        // 5. Kontrol edelim
        System.out.println("Sepette " + sepet.size() + " ürün var.");
        
        if(sepet.contains("Ekmek")) {
            System.out.println("Ekmek almayı unutmadık!");
        }
    }
}
```

-----

## ✅ Özet (Hızlı Tekrar)

  * [ ] ArrayList dinamik boyutludur, eleman ekledikçe büyür.
  * [ ] Sadece nesne türlerini (Integer, String, Boolean) saklar.
  * [ ] **add**: Ekle, **remove**: Sil, **clear**: Temizle, **contains**: Var mı?, **size**: Boyut.
  * [ ] Veritabanından veri çekerken (örneğin Firebase) genellikle ArrayList kullanılır.

-----
