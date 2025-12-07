# 🎭 5.5. Çokbiçimlilik (Polymorphism) - Ders Notları


## 🤔 Nedir Bu Çokbiçimlilik?

İsminden de anlaşılacağı gibi: **Çok - Biçim - lilik.**
Yani, bir eylemin (metodun) farklı nesneler tarafından **farklı şekillerde** yapılmasıdır.

> 💡 **Basitçe:** Herkes "Konuş" emrini anlar ama Kedi "Miyav" der, Köpek "Hav" der, İnsan "Merhaba" der. Emir aynı, tepki farklı!

---

## 🪖 Kitap Örneği: Askeriye (Sayfa 202)

Kitabımızdaki harika örneği inceleyelim. Orduda farklı asker sınıfları vardır: **Asker**, **Topçu** ve **Tankçı**.

Komutan "Ateş Et!" dediğinde ne olur?
1.  **Asker (Piyade):** Tüfeğiyle ateş eder. 🔫
2.  **Topçu:** Top atışı yapar. 💣
3.  **Tankçı:** Tankın namlusuyla ateş eder. 🚜

Hepsine verilen emir aynıdır (**`atesEt()`**), ama uygulama biçimleri farklıdır. İşte buna **Çokbiçimlilik** diyoruz!

---

## 💻 Java Kodları ile Yapalım

Çokbiçimliliği uygulamak için **`@Override`** (Geçersiz Kılma / Ezme) dediğimiz özel bir etiket kullanırız. Bu, *"Baba sınıfındaki kuralı biliyorum ama ben bunu kendi yöntemimle yapacağım"* demektir.

### 1. Adım: Ana Sınıfı (Parent) Yazalım

```java
// Üst Sınıf: Asker
public class Asker {
    public String atesEt() {
        return "Asker tüfekle ateş etti! bam bam!";
    }
}
````

### 2\. Adım: Alt Sınıfları (Child) Yazalım ve Metodu Değiştirelim

Burada `extends` ile miras alıyoruz, ama babamızın metodunu **`@Override`** ile değiştiriyoruz.

```java
// Alt Sınıf: Tankçı
public class Tankci extends Asker {
    
    @Override // Dikkat: Bu etiket "Ben bu metodu değiştiriyorum" demek!
    public String atesEt() {
        return "Tankçı tankla ateş etti!";
    }
}

// Alt Sınıf: Topçu
public class Topcu extends Asker {
    
    @Override
    public String atesEt() {
        return "Topçu top atışı yaptı!";
    }
}
```

-----

## 🛡️ "Değiştiremezsin\!" Demek: `final` Komutu

Bazen bir kuralın asla değiştirilmesini istemeyiz. Mesela askerlerin "Selam Ver" komutu her yerde aynı olmalıdır. [cite_start]Değiştirilmesini (Override edilmesini) engellemek için **`final`** komutunu kullanırız[cite: 1139].

```java
public class Asker {
    // Bu metot 'final' olduğu için alt sınıflar bunu DEĞİŞTİREMEZ!
    public final String selamVer() {
        return "Asker selam verdi!";
    }
}
```

-----

## 🚀 Sıra Sizde\! (Beyin Fırtınası)

Kitaptaki Asker örneğini anladıysak, şimdi kendi örneğimizi yapalım.

**Senaryo:** Bir "Hayvanat Bahçesi" uygulaması yapıyoruz.

  * **Üst Sınıf:** `Hayvan` (Metot: `sesCikar()`)
  * **Alt Sınıflar:** `Kedi`, `Kopek`, `Kus`

<!-- end list -->

1.  `Hayvan` sınıfındaki `sesCikar()` ne yapabilir? (Belki sadece "Ses yok" der?)
2.  `Kedi` sınıfında bu metodu nasıl **Override** edersiniz?
3.  `Kus` sınıfında bu metodu nasıl değiştirirsiniz?


-----

## ✅ Özet (Not Defterine Yazılacaklar)

  * [ ] **Çokbiçimlilik (Polymorphism):** Bir nesnenin, birden fazla farklı nesne gibi davranabilmesidir.
  * [ ] **@Override:** Üst sınıftan gelen bir metodun, alt sınıfta içeriğinin değiştirilmesidir (Metot Ezme).
  * [ ] **final:** Bir metodun başına gelirse, o metot alt sınıflarda **değiştirilemez (Override edilemez)**.
  * [ ] **Amaç:** Kodun esnekliğini artırmak ve yönetilebilir hale getirmek.

-----
