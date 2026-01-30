## 🛒 Performans Uygulaması: TeknoMarket Fiyat ve Taksit Simülasyonu

**Sevgili Öğrenciler,**

Bu projede sizden, bir teknoloji mağazasının mobil uygulamasının "Fiyat Hesaplama ve Ödeme Planı" modülünü geliştirmeniz beklenmektedir. Bu proje ile **Kalıtım (Inheritance)**, **Kapsülleme (Encapsulation)** ve **Döngüler (Loops)** konusundaki yetkinliğinizi sergileyeceksiniz.

Aşağıdaki yönergeleri takip ederek uygulamanızı adım adım inşa ediniz.

---

### 📋 Proje Senaryosu

Müşteriler, satın almak istedikleri ürünün **ham fiyatını** gireceklerdir. Uygulama, bu fiyata **KDV (Vergi)** ekleyerek son fiyatı bulacak ve müşterinin istediği taksit sayısına göre aylık ödeme planını listeleyecektir.

---

### 🏗️ Bölüm 1: Mimari Tasarım (Class & OOP Yapısı)

Bu bölümde kodun temelini oluşturan sınıfları yazacaksınız. 

#### 1. Ana Sınıf: `Urun` (Temel Sınıf)
Bu sınıf, mağazadaki standart bir ürünü temsil eder.
* **Kapsülleme (Encapsulation):** Aşağıdaki değişkenleri `private` olarak tanımlayın ve Getter/Setter metotlarını oluşturun:
    * `urunAdi` (String - Metin)
    * `hamFiyat` (Double - Ondalıklı Sayı)
* **Metot:** `kdvliFiyatHesapla()` isminde bir metot yazın. Bu metot, ham fiyatın üzerine %18 (veya %20) KDV ekleyerek **satış fiyatını** geri döndürmelidir (return).

#### 2. Alt Sınıf: `TaksitliUrun` (Kalıtım - Inheritance)
Bu sınıf, `Urun` sınıfından miras (`extends`) almalıdır.
* **Ek Özellik:** Bu sınıfa özgü `taksitSayisi` (int) isminde bir değişken tanımlayın.
* **Metot:** `odemePlaniOlustur()` isminde bir metot yazın. Bu metot; KDV'li satış fiyatını taksit sayısına bölmeli ve her ay ödenecek tutarı hesaplamalıdır.

---

### 🎨 Bölüm 2: Ekran Tasarımı (XML)

Kullanıcı arayüzünü **ConstraintLayout** kullanarak tasarlayınız. Ekran şu bileşenleri içermelidir:

* **Başlık:** "TeknoMarket Hesaplayıcı" yazan bir `TextView`.
* **Ürün Bilgisi:** Ürün adını girmek için `EditText`.
* **Fiyat Girişi:** Ürünün ham fiyatını (Vergisiz) girmek için `EditText` (NumberDecimal).
* **Taksit Seçimi:** Kaç taksit yapılacağını girmek için `EditText` (Number).
* **Butonlar:**
    * **KDV EKLE:** Vergili fiyatı hesaplayıp göstermek için.
    * **PLAN OLUŞTUR:** Taksit tablosunu yazdırmak için.
    * **TEMİZLE:** Ekranı sıfırlamak için.
* **Sonuç Ekranı:** Hesaplama sonuçlarını ve taksit listesini göstermek için büyük bir `TextView` (veya `MultilineText`).

---

### 💻 Bölüm 3: Programlama Mantığı (MainActivity)

Tasarım ve sınıflar bittikten sonra `MainActivity.java` dosyasında şu mantıkları kurunuz:

#### 1. Tanımlama ve Nesne Üretimi
* XML'deki bileşenleri `findViewById` ile tanımlayın.
* `TaksitliUrun` sınıfından `yeniTelefon` (veya benzeri) adında bir nesne üretin.

#### 2. KDV Hesaplama (Setter ve Metot Çağırma)
* **KDV Ekle Butonu:**
    * Kullanıcının girdiği ham fiyatı `setHamFiyat` metodu ile nesneye aktarın.
    * Nesnenin `kdvliFiyatHesapla()` metodunu çağırarak sonucu ekrana yazdırın.
    * *Örnek:* "KDV Dahil Tutar: 11.800 TL"

#### 3. Ödeme Planı ve Validasyon (Karar ve Döngü Yapıları)
* **Plan Oluştur Butonu:**
    * **Kontrol (If-Else):** Kullanıcı taksit sayısını **12'den fazla** girerse işlem yapmayın ve ekrana *"Maksimum 12 Taksit Yapılabilir!"* uyarısı verin.
    * **Döngü (For Loop):** Eğer taksit sayısı uygunsa, 1'den başlayıp taksit sayısına kadar dönen bir `for` döngüsü kurun.
    * Döngünün her adımında: *"X. Ay Ödemesi: [Aylık Tutar] TL"* şeklinde bir metin oluşturun.
    * **Çıktı:** Tüm ayları alt alta birleştirerek (String birleştirme `+=` operatörü ile) sonuç `TextView`'inde gösterin.

---

### ✅ Proje Teslim Kriterleri (Kontrol Listesi)

Projeyi bitirince kendinizi şu sorularla değerlendirin:

* [ ] `Urun` sınıfında değişkenleri `private` yapıp kapsülledim mi?
* [ ] `TaksitliUrun` sınıfını `Urun` sınıfından `extends` (miras) aldım mı?
* [ ] KDV hesabını doğru yapan metodu yazdım mı?
* [ ] Taksit sayısı 12'yi geçerse `if-else` ile uyarı veriyor mu?
* [ ] `for` döngüsü kullanarak aylık ödeme listesini (Örn: 1. Taksit, 2. Taksit...) alt alta yazdırabildim mi?
* [ ] Uygulama çökmeden (Crash olmadan) çalışıyor mu?

**Başarılar dilerim! Kodlarınız temiz, algoritmanız güçlü olsun.** 🚀