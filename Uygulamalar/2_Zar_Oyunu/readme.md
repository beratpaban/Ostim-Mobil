## 🏗️ Uygulama 2: Şanslı Savaşçı (Zar Oyunu)

**Senaryo:** Ekranda bir zar atma butonu olacak. Gelen sayıya göre ekrandaki görsel (ImageView) değişecek ve karakterin "Sınıfı" (Savaşçı, Büyücü, Okçu vb.) yazacak.

### 1. Aşama: Altyapı (Binding Kurulumu)

* Projenizin `build.gradle.kts` dosyasında `viewBinding` özelliğini `true` yaparak senkronize edin.
* Projenize (drawable klasörüne) internetten bulduğunuz veya hazırladığınız 3 farklı karakter resmi (veya 1-6 arası zar resimleri) ekleyin.

### 2. Aşama: Görsel Tasarım (XML Dosyası)

`activity_main.xml` içerisinde şu bileşenleri oluşturun:

* **ImageView:** Varsayılan bir resimle başlasın. ID: `imageViewKarakter`.
* **TextView (Başlık):** "Kaderini Belirle!" yazsın. ID: `textViewMesaj`.
* **Button:** Üzerinde "ZAR AT VE SEÇ" yazsın. ID: `buttonZarAt`.
* **TextView (Sonuç):** Zarın kaç geldiğini ve karakter ismini yazacak alan. ID: `textViewKarakterIsmi`.

### 3. Aşama: Kod Hazırlığı (MainActivity.java)

* Sınıf başında `ActivityMainBinding` nesnesini tanımlayın.
* `onCreate` içinde tasarımı bağlayın (`inflate` ve `setContentView`).
* Butona tıklandığında çalışacak olan `setOnClickListener` yapısını kurun.

### 4. Aşama: Mantık ve Rastgelelik (Java İşlemleri)

Butona basıldığında yapılacaklar:

* **Rastgele Sayı:** Java'nın `Random` sınıfını kullanarak 1 ile 3 (veya 6) arasında rastgele bir tam sayı üretin.
* **Kontrol (if-else veya switch-case):** * Eğer sayı **1** ise; `imageViewKarakter`'e "savasci" resmini set edin ve metin alanına "Savaşçı Seçildi!" yazdırın.
* Eğer sayı **2** ise; `imageViewKarakter`'e "buyucu" resmini set edin ve metin alanına "Büyücü Seçildi!" yazdırın.
* Eğer sayı **3** ise; `imageViewKarakter`'e "okcu" resmini set edin ve metin alanına "Okçu Seçildi!" yazdırın.



### 5. Aşama: Görsel Dokunuşlar (Bonus)

* Zar atıldığında `textViewMesaj` kısmının rengini `Color.RED` veya `Color.GREEN` yaparak kullanıcının dikkatini çekin.
* `View.GONE` ve `View.VISIBLE` özelliklerini kullanarak, zar atılmadan önce karakter resminin gizli kalmasını, atıldıktan sonra görünmesini sağlayın.

---