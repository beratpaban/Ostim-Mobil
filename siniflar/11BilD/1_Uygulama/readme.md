## 🏃‍♂️ Performans Uygulaması: Sağlıklı Yaşam ve VKE Hesaplayıcı

**Sevgili Öğrenciler,**

Bu projede sizden, kullanıcıların vücut kitle endeksini (VKE) hesaplayan ve yaptıkları spora göre kalori yakım tablosu çıkaran bir **"Sağlık Asistanı"** uygulaması geliştirmeniz beklenmektedir.

Bu ödev ile **Nesne Tabanlı Programlama (OOP)**, **Karar Yapıları (If-Else)** ve **Algoritmik Düşünme** becerilerinizi sergileyeceksiniz.

---

### 📋 Proje Senaryosu

Kullanıcılar uygulamaya fiziksel özelliklerini (Boy, Kilo) gireceklerdir. Uygulama bu verilerle kişinin sağlık durumunu (Zayıf, Normal, Kilolu) belirleyecek ve koşu bandında geçirilen süreye göre yakılan kaloriyi bir liste halinde sunacaktır.

---

### 🏗️ Bölüm 1: Mimari Tasarım (Class & OOP Yapısı)

Kodun temelini oluşturan sınıfları aşağıdaki kurallara göre oluşturunuz.

#### 1. Ana Sınıf: `Birey` (Temel Sınıf)
Bu sınıf, uygulamayı kullanan standart bir kişiyi temsil eder.
* **Kapsülleme (Encapsulation):** Aşağıdaki değişkenleri `private` yapın ve Getter/Setter metotlarını oluşturun:
    * `adSoyad` (String)
    * `boy` (Double - Metre cinsinden, örn: 1.75)
    * `kilo` (Double - Kg cinsinden, örn: 70.5)
* **Metot:** `vkeHesapla()` isminde bir metot yazın.
    * *Formül:* Kilo / (Boy * Boy)
    * Bu metot hesaplanan VKE (Vücut Kitle Endeksi) değerini `double` olarak geri döndürmelidir.

#### 2. Alt Sınıf: `Sporcu` (Kalıtım - Inheritance)
Bu sınıf, `Birey` sınıfından miras (`extends`) almalıdır.
* **Ek Özellik:** Bu sınıfa özgü `koşuSuresi` (int - Dakika cinsinden) isminde bir değişken tanımlayın.
* **Metot:** `kaloriYakimiHesapla()` isminde bir metot yazın.
    * *Varsayım:* 1 dakikada ortalama 10 kalori yakıldığı varsayılacaktır.
    * Metot, toplam yakılan kaloriyi hesaplayıp geri döndürmelidir.

---

### 🎨 Bölüm 2: Ekran Tasarımı (XML)

Arayüzü **ConstraintLayout** kullanarak tasarlayınız. Ekran şu bileşenleri içermelidir:

* **Başlık:** "Sağlık Asistanım" yazan şık bir `TextView`.
* **Kişisel Bilgiler:** İsim, Boy (Metre) ve Kilo girişi için 3 adet `EditText`.
* **Spor Bilgisi:** Koşu süresini (Dakika) girmek için 1 adet `EditText` (Number).
* **Butonlar:**
    * **DURUM ANALİZİ:** VKE hesaplayıp sağlık durumunu göstermek için.
    * **KALORİ CETVELİ:** Koşu süresine göre yakılan kalorileri listelemek için.
* **Sonuç Paneli:** Hesaplama sonuçlarını ve listeleri göstermek için büyük bir `TextView`.

---

### 💻 Bölüm 3: Programlama Mantığı (MainActivity)

Tasarım ve sınıflar bittikten sonra `MainActivity.java` içinde şu mantıkları kurunuz:

#### 1. Tanımlama
* XML bileşenlerini `findViewById` ile Java tarafına bağlayın.
* `Sporcu` sınıfından `yeniSporcu` adında bir nesne üretin.

#### 2. Sağlık Durumu Analizi (If - Else If - Else)
* **Durum Analizi Butonu:**
    * Kullanıcının girdiği boy ve kiloyu `set` metotları ile nesneye aktarın.
    * Nesnenin `vkeHesapla()` metodunu çağırın.
    * Çıkan sonuca göre bir **Karar Yapısı (If-Else)** kurarak ekrana durumu yazdırın:
        * 0 - 18.4 arası: **"Zayıf"**
        * 18.5 - 24.9 arası: **"Normal / Sağlıklı"**
        * 25 - 29.9 arası: **"Fazla Kilolu"**
        * 30 ve üzeri: **"Obezite Sınırı"**

#### 3. Kalori Cetveli (For Döngüsü)
* **Kalori Cetveli Butonu:**
    * Kullanıcının girdiği toplam koşu süresini alın.
    * **Döngü (For Loop):** 1. dakikadan başlayıp girilen süreye kadar, her **5 dakikada bir** (i = i + 5) artan bir döngü kurun.
    * Döngünün her adımında: *"X. Dakika sonunda: [Yakılan Kalori] kalori yakıldı."* cümlesini oluşturun.
    * **Çıktı:** Bu cümleleri alt alta birleştirerek sonuç ekranına yazdırın.

    *(Örnek: Kullanıcı 20 dakika girdiyse)*
    * *5. Dakika sonunda: 50 kalori yakıldı.*
    * *10. Dakika sonunda: 100 kalori yakıldı.*
    * *15. Dakika sonunda: 150 kalori yakıldı.*
    * *20. Dakika sonunda: 200 kalori yakıldı.*

---

### ✅ Proje Teslim Kriterleri (Kontrol Listesi)

Projeyi tamamladığınızda kendinizi şu sorularla test edin:

* [ ] `Birey` sınıfında verileri gizleyip (private), erişimi metotlarla (Getter/Setter) açtım mı?
* [ ] `Sporcu` sınıfını `extends` kullanarak miras aldım mı?
* [ ] VKE hesaplamasını doğru formülle (Kilo / Boy²) yaptım mı?
* [ ] VKE sonucuna göre If-Else yapısı ile Zayıf/Normal/Kilolu ayrımını yapabildim mi?
* [ ] `for` döngüsünü 5'er 5'er artırarak (i+=5) kalori tablosu oluşturabildim mi?
* [ ] Uygulama hatasız çalışıyor mu?

**İyi çalışmalar! Sağlıklı kodlar yazmanız dileğiyle.** 🍏🏃‍♂️