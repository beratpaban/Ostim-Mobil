# 🏎️ Uygulama Görevi: Akıllı Garaj (ConstraintLayout & OOP)

Bu uygulamada, görsel bileşenleri birbirine "bağlayarak" (constraint) esnek bir arayüz oluşturacak ve Java'da nesne yönelimli programlamanın (OOP) temelleri olan **Kalıtım** ve **Yapıcı Metotları** kullanacağız.

### 📊 Kullanılacak Görsel Elemanlar (Toplam: 6 Adet)

Tasarım ekranında (XML) şu elemanları kullanacağız:

* **1 Adet Başlık (TextView):** "Garaj Yönetim Sistemi" yazacak.
* **3 Adet Giriş Alanı (EditText):** Marka, Model Yılı ve Maksimum Hız için.
* **1 Adet İşlem Butonu (Button):** Nesne oluşturup bilgileri yazdırmak için.
* **1 Adet Sonuç Alanı (TextView):** Oluşturulan arabanın bilgilerini sergilemek için.

---

### 🛠️ Adım Adım Uygulama Planı

#### 1. Aşama: Esnek Tasarım (ConstraintLayout)

Bu aşamada elemanları ekrana "çivilemeniz" gerekiyor. Her elemanın en az **bir yatay**, **bir de dikey** bağlantısı olmalıdır.

* [ ] Elemanları ekranın ortasına dizmeye başlayın.
* [ ] **Hizalama:** Her elemanı üstündeki elemanın altına bağlayın (`layout_constraintTop_toBottomOf`).
* [ ] **Kenar Boşlukları:** `layout_margin` değerleri vererek elemanların birbirine yapışmasını engelleyin.
* [ ] **ID Verme:** Her bileşene benzersiz isimler verin (Örn: `et_marka`, `btn_olustur`, `tv_sonuc`).

#### 2. Aşama: Temel Sınıfı Yazma (Araba Sınıfı)

Java kısmında, tüm arabaların ortak özelliklerini barındıran bir "kalıp" oluşturun.

* [ ] `Araba` adında bir sınıf açın.
* [ ] `marka` ve `modelYili` değişkenlerini tanımlayın.
* [ ] **Yapıcı Metot (Constructor):** Sınıf oluşturulduğu anda bu iki veriyi alan ve sınıf içindeki değişkenlere aktaran metodu yazın.

#### 3. Aşama: Miras Bırakma (Kalıtım)

* [ ] `SporAraba` adında bir sınıf oluşturun ve `Araba` sınıfından miras almasını sağlayın.
* [ ] Bu sınıfa sadece spor arabalarda olan `maxHiz` özelliğini ekleyin.
* [ ] **super() Kullanımı:** `SporAraba` sınıfının yapıcı metodunda, `marka` ve `modelYili` bilgilerini üst sınıfa (Araba) göndermek için `super()` komutunu kullanın.

#### 4. Aşama: Java ile XML'i Birleştirme

* [ ] `MainActivity` içinde XML'deki 6 bileşeni de tanımlayın.
* [ ] `findViewById` komutu ile tasarım ile kod arasındaki köprüyü kurun.

#### 5. Aşama: Nesne Üretimi ve Görüntüleme

* [ ] Butona tıklandığında:
* [ ] Kullanıcının girdiği bilgileri (`getText().toString()`) değişkenlere alın.
* [ ] Sayısal verileri (Model yılı ve hız) `Integer.parseInt()` ile dönüştürün.
* [ ] **Nesne Oluşturma:** `new SporAraba(...)` komutuyla yeni bir araba nesnesi üretin.
* [ ] Oluşturduğunuz bu nesnenin verilerini birleştirerek sonuç `TextView`'ine yazdırın.



---

### 💡 Öğrenciler İçin Kritik Notlar

| Terim | Ne Anlama Gelir? (Basitçe) |
| --- | --- |
| **Constraint** | Bir nesneyi başka bir nesneye veya ekranın kenarına bağlayan "lastik" gibidir. |
| **extends** | "Bu sınıf, diğer sınıfın tüm özelliklerine sahiptir" demektir. |
| **super()** | "Baba sınıfa (üst sınıf) git ve onun yapıcı metodunu çalıştır" demektir. |
| **Integer.parseInt()** | Metin kutusundan gelen "2024" kelimesini, hesaplanabilir 2024 sayısına dönüştürür. |

---

**🎯 Ders Sonu Meydan Okuması (Challenge):**
Uygulamanız çalıştığında, `SporAraba` nesnesini oluştururken model yılını `2024`'ten büyük girerseniz ne olur? Kodunuz hata verir mi yoksa kabul mü eder? (Hatalı girişleri engelleme konusuna bir sonraki derste değineceğiz!)