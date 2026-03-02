
## 📱 **6.3. Activity Yapısı**

* **Activity**, bir mobil uygulamanın kullanıcıyla etkileşime girdiği **tek bir ekranı** temsil eder 🖼️
* Uygulamalar genellikle birden fazla Activity'den oluşur (Giriş ekranı, Profil ekranı, Ayarlar ekranı vb.).
* Bir Activity iki ana parçadan oluşur:
1. **Java/Kotlin Sınıfı:** Mantıksal işlemlerin yapıldığı yer.
2. **XML Layout:** Görsel tasarımın yapıldığı yer.


---

## 🔄 **6.3.1. Activity Yaşam Döngüsü (Life Cycle)**

Android sistemi, bir Activity'nin durumuna göre (açılma, kapanma, arka plana atılma) belirli metodları otomatik olarak çalıştırır. Buna **Yaşam Döngüsü** denir.

### 🔹 **1. onCreate()**

* Activity **ilk oluşturulduğunda** çalışan metottur.
* Uygulamanın kurulumu (View Binding, değişken tanımları) burada yapılır.
* **Önemli:** Sadece bir kez çalışır ❗

### 🔹 **2. onStart()**

* Activity kullanıcıya **görünür** hale geldiğinde çalışır.

### 🔹 **3. onResume()**

* Activity **ön plana** çıkar ve kullanıcıyla etkileşime hazır hale gelir.
* Uygulama aktif olarak kullanılırken bu durumdadır 🎮

### 🔹 **4. onPause()**

* Activity hala görünürdür ancak odağını kaybetmiştir.
* Örneğin ekrana bir uyarı penceresi (Dialog) geldiğinde çalışır.

### 🔹 **5. onStop()**

* Activity artık kullanıcıya **görünmez** durumdadır.
* Kullanıcı "Home" tuşuna bastığında veya başka bir ekran açıldığında çalışır 🏠

### 🔹 **6. onRestart()**

* Kullanıcı `onStop` durumundaki bir Activity'ye tekrar döndüğünde çalışır.

### 🔹 **7. onDestroy()**

* Activity **tamamen yok edilmeden** önce çalışan son metottur.
* Uygulama kapatıldığında veya sistem hafızayı boşaltmak istediğinde çalışır ⚰️

---

## 🚀 **6.3.2. Aktiviteler Arası Geçiş Yöntemleri**

Android'de bir ekrandan diğerine geçmek için **Intent** (Niyet) nesnesi kullanılır. Ancak bu geçişin yapılış amacına göre farklı yöntemler vardır.

---

### 🔹 **1. Basit Geçiş (Veri Göndermeden)**

Sadece bir butona basıldığında diğer ekrana gitmek için kullanılır. En temel yöntemdir.

**Kod Örneği:**

```java
// Mevcut ekrandan (MainActivity), hedef ekrana (IkinciActivity) geçiş niyetini belirtiyoruz.
Intent intent = new Intent(MainActivity.this, IkinciActivity.class);

// Geçişi başlatıyoruz.
startActivity(intent);

```

👉 **Mantık:** "Ben şu an buradayım (this), şuraya gitmek istiyorum (class)."

---

### 🔹 **2. Veri Göndererek Geçiş (PutExtra)**

Bir ekrandan diğerine bilgi (Kullanıcı adı, ID, puan vb.) taşımak istediğimizde kullanılır.

**Gönderen Ekran (MainActivity):**

```java
Intent intent = new Intent(MainActivity.this, ProfilActivity.class);

// putExtra metodu ile "anahtar-değer" şeklinde veri ekliyoruz.
intent.putExtra("kullanici_adi", "Ahmet123");
intent.putExtra("kullanici_yas", 25);

startActivity(intent);

```

**Alan Ekran (ProfilActivity):**

```java
// Gelen niyeti yakalıyoruz.
Intent gelenIntent = getIntent();

// Verileri anahtar kelimeleriyle geri alıyoruz.
String ad = gelenIntent.getStringExtra("kullanici_adi");
int yas = gelenIntent.getIntExtra("kullanici_yas", 0); // Sayısal verilerde varsayılan değer (0) verilir.

```

👉 **Mantık:** Veriyi bir koliye koyup üzerine bir etiket (Key) yapıştırıyoruz. Alıcı da o etiketle veriyi açıyor.

---

### 🔹 **3. Sonuç Bekleyerek Geçiş (Activity Result API)**

Bir ekrana gidip, oradan bir cevap almak istediğimizde kullanılır. Örneğin; profil resmi seçmek için galeriye gitmek ve seçilen resmi geri getirmek gibi.

**Yeni Yöntem (ActivityResultLauncher):**

```java
// 1. Sonucu bekleyen bir fırlatıcı tanımlıyoruz.
ActivityResultLauncher<Intent> firlatici = registerForActivityResult(
    new ActivityResultContracts.StartActivityForResult(),
    result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            // İkinci ekrandan başarıyla dönüldüyse burası çalışır.
            Intent data = result.getData();
            String cevap = data.getStringExtra("secilen_oge");
        }
    }
);

// 2. Butona basıldığında fırlatıcıyı çalıştırıyoruz.
Intent intent = new Intent(this, SecimActivity.class);
firlatici.launch(intent);

```

---

### 🔹 **4. Mevcut Ekranı Kapatarak Geçiş (Finish)**

Eğer geçiş yaptıktan sonra kullanıcının geri tuşuna bastığında eski ekrana dönmesini **istemiyorsak** (örneğin; Giriş Yapıldıktan sonra tekrar Giriş ekranına dönülmesin diye) kullanılır.

**Kod Örneği:**

```java
Intent intent = new Intent(MainActivity.this, AnasayfaActivity.class);
startActivity(intent);

// finish() komutu mevcut activity'yi hafızadan siler.
finish();

```

---

## 📌 **Yöntem Karşılaştırma Notu**

| Yöntem | Ne Zaman Kullanılır? | Kritik Komut |
| --- | --- | --- |
| **Basit Geçiş** | Düz ekran değişimlerinde. | `startActivity()` |
| **Verili Geçiş** | Bilgi taşımak gerektiğinde. | `putExtra()` / `getIntent()` |
| **Sonuç Bekleme** | Gidilen yerden veri dönecekse. | `launch()` |
| **Finish ile Geçiş** | Geri dönüşü engellemek için. | `finish()` |

---

**Not:** Bu yöntemlerin hepsi **View Binding** ile birleştirilebilir. Örneğin bir butona tıklama olayının içinde (`binding.btnGit.setOnClickListener`) bu Intent kodlarını yazabilirsin.


## 📦 **6.3.3. Activity'ler Arası Veri Taşıma Yöntemleri**

Android'de veriyi bir ekrandan diğerine aktarırken kullandığımız yöntemlerin her birinin kendine has "yükleme kapasitesi" ve "kullanım amacı" vardır.

---

### 🔹 **1. Intent Yöntemi (Küçük Veriler İçin)**

En yaygın kullanılan, Android'in standart yöntemidir. Veriler "anahtar-değer" (Key-Value) çifti olarak bir koliye konur.

* **Ne için kullanılır?** String, int, boolean gibi basit veriler için.
* **Kod Örneği:**
```java
intent.putExtra("kullanici_adi", "Ahmet"); // Veri ekleme
String ad = getIntent().getStringExtra("kullanici_adi"); // Veri alma

```


* **Avantajı:** Çok hızlı ve kolaydır.
* **Dezavantajı:** Büyük veriler (yüksek çözünürlüklü resimler, 10.000 satırlık listeler) taşınamaz. **1 MB** sınırı vardır, aşarsan uygulama çöker.

---

### 🔹 **2. Serializable Yöntemi (Nesneler İçin)**

Eğer sadece bir metin değil, bir **Nesne** (Örneğin; içinde isim, yaş ve maaş bilgisi olan bir `Personel` objesi) göndermek istiyorsan bu yöntemi kullanırsın.

* **Ne için kullanılır?** Kendi oluşturduğun sınıflardan türetilen objeleri taşımak için.
* **Nasıl Yapılır?** Sınıfın yanına `implements Serializable` yazman yeterlidir.
* **Kod Örneği:**
```java
// Model Sınıfı
public class Personel implements Serializable { ... }

// Gönderirken
intent.putExtra("personel_objesi", secilenPersonel);

```


* **Avantajı:** Nesneyi parçalamadan bütün halde göndermeni sağlar.
* **Dezavantajı:** Java'nın standart bir yöntemi olduğu için Android'de biraz yavaş çalışır (performans kaybı yaratabilir).

---

### 🔹 **3. Singleton Sınıfı Yöntemi (Her Yerden Erişilen Veriler İçin)**

Veriyi bir pakete koyup göndermek yerine, veriyi **ortak bir alana** (buluta/panoya gibi) bırakıp her ekrandan o alana bakmak gibidir.

* **Ne için kullanılır?** Uygulamanın her yerinde lazım olan, sürekli değişen veya Intent ile taşınamayacak kadar büyük veriler için.
* **Mantık:** Sınıftan sadece bir tane örnek (instance) oluşturulur ve her Activity aynı örneğe ulaşır.
* **Kod Örneği:**
```java
// Singleton Sınıfı
Singleton singleton = Singleton.getInstance();
singleton.setSecilenGorsel(gorsel); // Veriyi buraya bırak

// Diğer Activity'de
Gorsel g = singleton.getSecilenGorsel(); // Veriyi buradan al

```

* **Avantajı:** Veri kopyalanmaz, hafızada tek bir yerde durur. Çok büyük objeler için güvenlidir.
* **Dezavantajı:** Hafıza yönetimi zordur; eğer işin bitince temizlemezsen "Memory Leak" (Hafıza Sızıntısı) oluşabilir.

---

## ⚖️ **Farklar Tablosu: Hangisini Seçmeliyim?**

| Özellik | Intent (PutExtra) | Serializable | Singleton |
| --- | --- | --- | --- |
| **Veri Tipi** | İlkel tipler (int, String) | Kompleks Nesneler | Her türlü veri / Büyük Objeler |
| **Kapasite** | Çok düşük (Max 1MB) | Orta | Sınırsız (RAM kadar) |
| **Hız** | Çok Hızlı | Yavaş (İşlemciyi yorar) | Çok Hızlı |
| **Kullanım Kolaylığı** | En Kolayı | Kolay | Orta (Mimarî kurmak gerekir) |
| **Ne Zaman?** | İsim, ID gibi küçük verilerde. | Bir kullanıcı profil objesinde. | Galeri projesindeki gibi büyük resimlerde. |

---

## 📌 **Özet Not**

Kitabındaki "Görsel Değiştirici" örneğinde neden **Singleton** kullandık? Çünkü yüksek çözünürlüklü bir resmi (Bitmap) Intent ile göndermeye çalışırsak uygulama anında çöker. Singleton sayesinde resmi bir "emanet dolabına" koyuyoruz, ikinci Activity gidip oradan alıyor.

---

## 📌 **Özet Notlar**

* Her yeni oluşturulan Activity, mutlaka **AndroidManifest.xml** dosyasına kaydedilmelidir (Android Studio bunu otomatik yapar) 📝
* `onResume` ve `onPause` metodları, uygulamanın pil ve performans yönetimi için en kritik noktalardır.
* Bir Activity'yi kodla kapatmak isterseniz `finish()` komutunu kullanabilirsiniz.

---
