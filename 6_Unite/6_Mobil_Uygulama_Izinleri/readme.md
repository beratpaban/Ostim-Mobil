
## 🔐 **6.6. Mobil Uygulamada İzinler ve İzin Yapısı**

* **İzinler**, kullanıcıların gizliliğini ve veri güvenliğini korumak için geliştirilmiş bir güvenlik mekanizmasıdır 🛡️
* Uygulamanızın, telefonun kamerasını kullanması, rehbere erişmesi veya internete bağlanması gibi durumlar "kısıtlı işlemler"dir.
* Android sistemi, bu işlemlerin yapılabilmesi için geliştiricinin bu niyetini beyan etmesini ve bazen de kullanıcının onay vermesini şart koşar.

---

## 📁 **6.6.1. İzinlerin Tanımlandığı Yer: AndroidManifest.xml**

Tüm izinler, projenin en başında **AndroidManifest.xml** dosyası içerisinde, `<application>` etiketinin **üstünde** tanımlanır.

* **Kod Yapısı:**

```xml
<manifest ...>
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CAMERA" />

    <application ...>
        ...
    </application>
</manifest>

```

---

## 📊 **6.6.2. İzin Türleri**

Android dünyasında izinler, risk durumuna göre iki ana gruba ayrılır:

### **1. Normal İzinler (Normal Permissions)**

* Kullanıcının gizliliği için çok büyük bir risk oluşturmayan izinlerdir.
* **Önemli:** Sadece Manifest dosyasına yazılması yeterlidir. Kullanıcıya uygulama içinde bir onay penceresi açılmaz.
* **Örnekler:** İnternete erişim (`INTERNET`), Titreşim (`VIBRATE`), Bluetooth erişimi.

### **2. Tehlikeli İzinler (Dangerous Permissions)**

* Kullanıcının özel verilerine (konum, rehber, fotoğraflar) veya donanıma (kamera, mikrofon) erişim sağlayan izinlerdir.
* **Önemli:** Hem Manifest dosyasına yazılmalı hem de uygulama çalışma esnasında (Runtime) kullanıcıdan **onay istenmelidir** ❗
* **Örnekler:** Kamera (`CAMERA`), Konum (`ACCESS_FINE_LOCATION`), Rehber Okuma (`READ_CONTACTS`).

---

## 🛠️ **6.6.3. Çalışma Zamanı İzni (Runtime Permission) Nasıl Alınır?**

Tehlikeli bir izin (örneğin Kamera) almak için modern Android'de **ActivityResultLauncher** yapısı kullanılır. İşte adım adım uygulama:

### **1. Adım: Manifest'e Ekle**

```xml
<uses-permission android:name="android.permission.CAMERA" />

```

### **2. Adım: Kod Tarafında İzin İsteme (Java)**

```java
// 1. İzin fırlatıcısını tanımla (onCreate üzerinde)
ActivityResultLauncher<String> requestPermissionLauncher =
    registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        if (isGranted) {
            // İzin kullanıcı tarafından verildi! Kamerayı açabiliriz.
            Toast.makeText(this, "İzin Kabul Edildi", Toast.LENGTH_SHORT).show();
        } else {
            // İzin reddedildi. Kullanıcıya açıklama yapılabilir.
            Toast.makeText(this, "İzin Reddedildi!", Toast.LENGTH_SHORT).show();
        }
    });

// 2. Butona basıldığında kontrol et ve fırlat
binding.btnKamerayiAc.setOnClickListener(v -> {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
        // İzin zaten daha önce verilmiş
        kamerayiBaslat();
    } else {
        // İzin verilmemiş, fırlatıcıyı çalıştır ve kullanıcıya sor
        requestPermissionLauncher.launch(Manifest.permission.CAMERA);
    }
});

```

---

## ⚠️ **6.6.4. İzin İsterken Dikkat Edilmesi Gerekenler (Rationale)**

* **Açıklama Yapın:** Kullanıcı bir izni reddederse, neden bu izne ihtiyacınız olduğunu açıklayan bir mesaj (Snackbar veya Alert) göstermelisiniz.
* **Gereksiz İzinlerden Kaçının:** Uygulamanızın çalışması için şart olmayan hiçbir izni istemeyin. Bu, kullanıcının güvenini kırar 🚫
* **Reddedilme Durumu:** Kullanıcı izni reddetse bile uygulamanın tamamen çökmemesini, o özelliğin sadece devre dışı kalmasını sağlayın.

---

## 📌 **Bölüm Sonu Özet Notlar**

1. **İnternet izni** normal bir izindir, Manifest'e yazılması yeterlidir.
2. **Kamera ve Konum** tehlikeli izinlerdir, çalışma anında onay gerektirir.
3. Kullanıcı "Bir daha sorma" derse, izni sadece telefonun **Ayarlar** kısmından manuel olarak açabilir.
4. Modern uygulamalarda izin mantığı kullanıcıyı rahatsız etmeyecek şekilde, tam ihtiyaç duyulduğu anda sorulmalıdır.

---