
# 🧬 5.4. Kalıtım (Inheritance) - Ders Notları

Merhaba Genç Yazılımcılar! 👋
Bugün, kod yazarken "tembellik yapmanın" (yani daha az kod yazıp daha çok iş yapmanın) en havalı yolunu öğreneceğiz: **Kalıtım!**

---

## 🎯 Nedir Bu Kalıtım?

Biyolojiden hatırlayın: Göz renginizi, boyunuzu veya saç tipinizi kime borçlusunuz? Anne ve babanıza, değil mi? İşte yazılımda da sınıflar (Class) birbirlerinden özellik miras alabilirler.

**Tanım:** Bir sınıfın özelliklerinin (değişkenler) ve yeteneklerinin (metotlar), başka bir sınıfa aktarılmasına **Kalıtım (Inheritance)** denir.

> 💡 **İpucu:** Kalıtım sayesinde, "tekerleği yeniden icat etmeyiz". Var olan kodları tekrar tekrar kullanırız.

---

## 🚗 Gerçek Hayat Örneği: Trafik (Sayfa 194)

Düşünün ki bir trafik oyunu yapıyoruz. Elimizde **Araba**, **Minibüs** ve **Kamyon** var.

Hepsinde ortak olan neler var?
* ✅ Marka
* ✅ Model
* ✅ Motor Hacmi
* ✅ Hızlanma (Metot)
* ✅ Durma (Metot)

Eğer kalıtım kullanmazsak, bu özellikleri her üçü için de tek tek yazmamız gerekir. Ama **Kalıtım** kullanırsak:

1.  **Üst Sınıf (Anne/Baba):** `Arac` diye bir sınıf oluştururuz. Ortak özellikleri buraya yazarız.
2.  **Alt Sınıf (Çocuk):** `Araba`, `Minibus`, `Kamyon` sınıflarını `Arac` sınıfından türetiriz.

Böylece `Araba` sınıfı, `Arac` sınıfındaki her şeye **otomatik olarak** sahip olur!

---

## 💻 Java Kod Örneği

Java'da bir sınıfın diğerinden miras alması için **`extends`** (uzanır/genişletir) sihirli kelimesini kullanırız.

### 1. Adım: Üst Sınıfı (Parent) Yazalım
Önce genel özelliklerin olduğu sınıfı yazıyoruz.

```java
// Üst Sınıf (Super Class)
public class Arac {
    public String marka;
    public int modelYili;

    public void calistir() {
        System.out.println("Araç çalıştırıldı... Vrooom!");
    }
}


### 2\. Adım: Alt Sınıfı (Child) Yazalım

Şimdi `extends` kullanarak mirası alalım.

```java
// Alt Sınıf (Sub Class) -> Araba, Arac'ın tüm özelliklerini alır!
public class Araba extends Arac {
    public int kapiSayisi; // Bu özellik sadece Arabaya özel
}
```

### 3\. Adım: Ana Programda Kullanalım (MainActivity)

```java
// Uygulama Çalıştığında
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Yeni bir Araba nesnesi oluşturalım
        Araba benimArabam = new Araba();

        // Dikkat! 'marka' ve 'calistir' Araba sınıfında yazılı değil ama Arac'tan geldi!
        benimArabam.marka = "TOGG"; 
        benimArabam.calistir(); 
        
        // Bu özellik Arabaya ait
        benimArabam.kapiSayisi = 4; 
    }
}
```

-----

## 📊 Kavram Haritası

| Terim | Açıklama | Örnek |
| :--- | :--- | :--- |
| **Üst Sınıf (Super Class)** | Özellikleri veren, ana sınıf. | `Arac` |
| **Alt Sınıf (Sub Class)** | Özellikleri alan, mirasçı sınıf. | `Araba`, `Kamyon` |
| **extends** | Kalıtımı sağlayan Java komutu. | `class Araba extends Arac` |

-----

## 🧠 Neden Kalıtım Kullanıyoruz? (DRY Prensibi)

Yazılımda **DRY (Don't Repeat Yourself - Kendini Tekrar Etme)** diye bir kural vardır.

  * **Daha Az Kod:** Aynı kodları 10 kere yazmak yerine 1 kere yazıp miras alırız.
  * **Kolay Bakım:** "Araçlar artık uçabiliyor" güncellemesi gelirse, sadece `Arac` sınıfını değiştirmemiz yeterli. Tüm alt sınıflar (Araba, Kamyon) otomatik olarak güncellenir.
  * **Düzen:** Kodlarımız daha organize ve anlaşılır olur.

-----

## 🚀 Sıra Sizde\! (Sınıf İçi Etkinlik)

Haydi biraz beyin fırtınası yapalım\! Aşağıdaki senaryoda Üst Sınıf ve Alt Sınıfları bulun.

**Senaryo:** Bir okul yönetim sistemi yapıyoruz. Sistemde Öğretmen, Öğrenci ve Müdür var. Hepsinde "Ad, Soyad, TC Kimlik No" var. Ama sadece Öğretmende "Maaş", sadece Öğrencide "Okul Numarası" var.

  * **Üst Sınıf ne olabilir?** (İpucu: İnsan? Kişi?)
  * **Alt Sınıflar nelerdir?**
  * **Ortak özellikler hangileridir?**

> **Cevapları düşünün ve kodlamaya çalışın\!**

-----

## ✅ Özet (Sınav Notu)

  * [ ] Kalıtım, bir sınıfın başka bir sınıftan özellik almasıdır.
  * [ ] Java'da kalıtım için **`extends`** anahtar kelimesi kullanılır.
  * [ ] Bir sınıf **sadece bir** sınıftan kalıtım alabilir (Bir çocuğun biyolojik olarak iki babası olamaz mantığı).
  * [ ] Üst sınıfa **Super Class**, alt sınıfa **Sub Class** denir.

-----
