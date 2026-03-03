Harika bir pedagojik yaklaşım! İlk uygulamayı çözümle birlikte sunduktan sonra, öğrencilerin elinden tutmadan ama yollarını aydınlatarak ilerlemelerini sağlamak kalıcılığı artıracaktır.

İkinci uygulama için konu önerim: **"Vücut Kitle İndeksi (VKİ) Hesaplayıcı"**. Bu uygulama hem `View Binding` kullanımını pekiştirir hem de temel matematiksel işlemleri ve `if-else` mantığını Android ortamına taşır.

İşte öğrencilere dağıtabileceğiniz, **kod içermeyen** adım adım uygulama talimatnamesi:

---

## 🏗️ Uygulama 2: Vücut Kitle İndeksi Hesaplayıcı (Görev Listesi)

**Senaryo:** Kullanıcıdan boy (cm) ve kilo (kg) bilgilerini alacağız. Bir butona basıldığında sonucu hesaplayıp ekrandaki bir etikette (TextView) göstereceğiz.

### 1. Aşama: Hazırlık (Gradle Ayarları)

* Yeni bir Android projesi başlatın.
* **build.gradle.kts (Module :app)** dosyasını açın.
* `android` bloğunun içinde `viewBinding` özelliğini aktif hale getirin ve projeyi **Sync Now** yaparak senkronize edin.

### 2. Aşama: Tasarım (XML Dosyası)

`activity_main.xml` dosyasına girerek aşağıdaki bileşenleri alt alta (LinearLayout veya ConstraintLayout kullanarak) yerleştirin:

* **EditText (Kilo):** Kullanıcının sayı girebilmesi için `inputType` özelliğini `numberDecimal` yapın. ID: `editTextKilo`.
* **EditText (Boy):** Kullanıcının sayı girebilmesi için `inputType` özelliğini `numberDecimal` yapın. ID: `editTextBoy`.
* **Button:** Üzerinde "HESAPLA" yazan bir buton. ID: `buttonHesapla`.
* **TextView:** Sonucun (örneğin: 24.5) görüneceği büyük bir metin alanı. ID: `textViewSonuc`.
* **TextView:** Durumun (örneğin: "Normal", "Kilolu") görüneceği bir metin alanı. ID: `textViewDurum`.

### 3. Aşama: Java Koduna Geçiş (Tanımlamalar)

* `MainActivity.java` dosyasına gidin.
* Sınıf (class) düzeyinde (onCreate'in dışında), otomatik oluşturulan **Binding** sınıfından bir nesne türetin.
* `onCreate` metodunun içerisinde `inflate` (şişirme) işlemini gerçekleştirin.
* `setContentView` satırını binding nesnenizin kök dizinini (`getRoot()`) alacak şekilde güncelleyin.

### 4. Aşama: Mantıksal İşlemler (Buton Tıklama)

* Hesapla butonuna bir tıklama dinleyicisi (`setOnClickListener`) ekleyin.
* **Veri Alma:** Butona tıklandığında, EditText'lerden gelen metinleri (String) alın ve bunları matematiksel işlem yapabilmek için `Double` tipine dönüştürün.
* **Hesaplama:** VKİ formülünü uygulayın: 
$$VKİ = \frac{Kilo}{(Boy/100)^2}$$


* **Sonucu Yazdırma:** Çıkan sonucu `textViewSonuc` bileşenine set edin.

### 5. Aşama: Kontrol Yapısı (Bonus Görev)

* Bir `if-else` bloğu oluşturun.
* Eğer VKİ 18.5'ten küçükse "Zayıf", 18.5 ile 24.9 arasındaysa "Normal", 25 ile 29.9 arasındaysa "Fazla Kilolu", 30'dan büyükse "Obez" yazısını `textViewDurum` bileşenine yazdırın.

---

### Öğretmen Notu (Öğrencilerin Takılabileceği Noktalar):

1. **Tip Dönüşümü:** `getText().toString()` yaptıktan sonra bunu `Double.parseDouble()` içine almayı unutmamaları gerekir.
2. **Boş Veri Hatası:** Eğer kullanıcı boş kutuya basıp butona tıklarsa uygulama çöker. İleri seviye öğrencilere "Boş mu?" kontrolü yapmalarını hatırlatabilirsiniz.
3. **Binding İsmi:** Eğer proje ismini farklı koydularsa binding sınıfı isminin (örn: `ActivityMainBinding`) değişebileceğini belirtin.

Bu aşamalı yönergeyi onlara verdikten sonra, sınıf içinde dolaşarak sadece **mantıksal ipuçları** vermeniz öğrenme sürecini tamamlayacaktır. Bir sonraki aşama için bu uygulamayı **renklendirmelerini** (duruma göre arka planın kırmızı veya yeşil olması gibi) ister misiniz?