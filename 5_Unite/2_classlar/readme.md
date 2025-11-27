# 📱 5. Ünite: Sınıf ve Nesne Kavramları (Class & Object)

Artık kodlarımızı yukarıdan aşağıya dümdüz yazmak yerine, onları parçalara bölüp yöneteceğiz. Buna **Nesne Tabanlı Programlama (OOP)** diyoruz.

## 1\. Sınıf (Class) Nedir? 🏗️

Düşünün ki bir mimarsınız. Bir ev yapmadan önce neye ihtiyacınız var? Tabii ki bir **plana (blueprint)**.
İşte **Sınıf (Class)**, kodlamadaki bu plandır.

> **Tanım:** Sınıf, nesneleri oluşturmak için kullanılan şablonlar veya prototiplerdir.

### 🍪 En İyi Örnek: Kurabiye Kalıbı

  * **Sınıf (Class):** Kurabiye kalıbıdır. Tek başına yenmez, sadece şekli belirler.
  * **Nesne (Object):** O kalıptan çıkan kurabiyelerdir. Kimisi çikolatalı, kimisi üzümlü olabilir ama hepsinin şekli aynıdır.

### Sınıfın Yapısı Nasıldır?

Bir sınıf 4 temel bölümden oluşur:

1.  **Erişim Belirleyici:** (Public, Private vb.) Kimler görebilir?
2.  **Class Kelimesi:** Bilgisayara "Bu bir sınıftır" der.
3.  **Sınıf Adı:** Genellikle büyük harfle başlar (PascalCase). Örn: `Ogrenci`, `Araba`.
4.  **Gövde:** Özelliklerin ve metotların yazıldığı yer `{ ... }`.

<!-- end list -->

```java
// Örnek Sınıf Yapısı
public class Araba {
    // Özellikler (Variables)
    String renk;
    int model;

    // Davranışlar (Methods)
    void calistir() {
        System.out.println("Araba çalıştı!");
    }
}
```

-----

## 2\. Nesne (Object) Nedir? 🚗

Planı (Sınıfı) çizdik, şimdi bu plandan gerçek bir varlık üretme zamanı\! Sınıftan türetilen, hafızada yer kaplayan canlı örneğe **Nesne** denir.

### Nasıl Nesne Oluştururuz?

Sihirli kelimemiz: **`new`**.

```java
// Kalıp (Sınıf) Adı   Nesne Adı    =   new   Kalıp Adı();
   Araba               benimArabam  =   new   Araba();
```

  * **`Araba benimArabam;`** -\> Hafızada yer ayırdık ama içi boş (Tanımlama).
  * **`= new Araba();`** -\> Artık hafızada gerçekten bir araba var (Oluşturma).

-----

## 3\. Erişim Belirleyiciler (Kimler Girebilir?) 🔒

Sınıfımızın içindeki bilgilere kimlerin erişebileceğini biz belirleriz. Java'da 4 güvenlik seviyesi vardır:

| Erişim Belirleyici | Açıklama | Günlük Hayat Örneği |
| :--- | :--- | :--- |
| **`public`** | Her yerden erişilebilir. | **Halk Parkı:** Herkes girebilir. |
| **`protected`** | Sadece aynı pakettekiler ve miras alanlar (çocukları) erişebilir. | **Aile Yadigarı:** Sadece aile üyeleri kullanabilir. |
| **`default`** (Boş) | Sadece aynı pakettekiler (klasördekiler) erişebilir. | **Apartman Bahçesi:** Sadece komşular girebilir. |
| **`private`** | Sadece o sınıfın içinden erişilebilir. Dışarıya kapalıdır. | **Günlük Defteri:** Sadece sahibi okuyabilir. |

-----

## 4\. Kurucu Metotlar (Constructors) 🛠️

Bir nesneyi `new` ile oluşturduğumuz **anda** çalışan özel metotlardır. Genellikle başlangıç ayarlarını yapmak için kullanırız.

  * Geri dönüş tipi (void, int vb.) yoktur.
  * İsmi, sınıf ismiyle **aynı olmak zorundadır**.

### Örnek Senaryo:

Yeni bir telefon aldığınızda (nesne oluştuğunda), ilk açılışta dil ve wifi ayarlarını sorar. İşte bu `Constructor`'dır.

```java
public class Telefon {
    String marka;

    // Kurucu Metot (Constructor)
    public Telefon() {
        System.out.println("Telefon üretildi ve açılıyor...");
    }
}
```

**Parametreli Kurucu Metot:**
Nesneyi oluştururken özelliklerini de verebiliriz.

```java
public class Dortgen {
    int kisaKenar;
    int uzunKenar;

    // Özellikleri dışarıdan alan kurucu metot
    public Dortgen(int kisa, int uzun) {
        this.kisaKenar = kisa;
        this.uzunKenar = uzun;
    }
}

// Kullanımı:
Dortgen masa = new Dortgen(50, 100); // Masa oluşturulurken boyutları verildi.
```

-----

## 📝 Özet ve İpuçları

  * 📌 **Sınıf (Class):** Soyut bir plandır (Kalıp).
  * 📌 **Nesne (Object):** Somut bir varlıktır (Kurabiye).
  * 📌 **new:** Yeni bir nesne oluşturmak için kullanılan anahtar kelimedir.
  * 📌 **Private:** En gizli erişim seviyesidir, sadece sınıf içi erişim sağlar.
  * 📌 **Constructor:** Sınıf adıyla aynı isme sahip, nesne oluşurken çalışan ilk metottur.

-----

## 🧠 Alıştırma Zamanı (Sıra Sizde)

Aşağıdaki senaryoyu kodlamaya çalışın:

1.  **`Ogrenci`** adında bir sınıf oluşturun.
2.  Bu sınıfın `ad` (String) ve `numara` (int) diye iki özelliği olsun.
3.  Bir **Constructor (Yapıcı Metot)** yazın ve bu metot, öğrenci oluşturulurken adını ve numarasını alıp kaydetsin.
4.  `MainActivity` içinde bu sınıftan **kendi adınızla** bir nesne oluşturun.

**Kontrol Listesi:**

  - [ ] Class dosyasını oluşturdun mu?
  - [ ] Constructor parametre alıyor mu?
  - [ ] `new` anahtar kelimesini kullandın mı?

-----

### 💡 Öğretmenim, sizin için bir not:

Bu dersin sonunda öğrencilerinize *kitabınızdaki* **"Elektrikli Cihaz"** uygulamasını yaptırabilirsiniz. Bu uygulama, sınıf yapısını, özellik tanımlamayı ve metot kullanımını (aylık tüketim hesabı) pekiştirmek için harika bir pratiktir.

Sizin için başka bir konuda not hazırlamamı ister misiniz? (Örneğin: Kapsülleme veya Kalıtım konuları?)