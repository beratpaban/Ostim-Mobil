## 📂 **6.1. Proje Yapılandırma Ayarları**

* Yeni bir **mobil uygulama projesi** oluşturulduğunda, **Project alanında** çeşitli **dosya ve klasörler** ile karşılaşılır.
* Bu **dosya ve klasör yapısını tanımak**, projeyi doğru şekilde anlamanın ilk adımıdır.
* Projede yer alan **her dosya ve klasörün farklı bir işlevi vardır** 🧩
* Bu yapıyı bilmek:

  * **Projeye hâkimiyeti artırır**
  * Geliştirme sürecini **daha kontrollü ve verimli** hale getirir 🚀
* Görsel referans: **Görsel 6.1**


## 📄 **6.1.1. AndroidManifest.xml Dosya Yapısı**

* **AndroidManifest.xml**, `manifest` klasörü içinde yer alan ve **Android uygulamaları için vazgeçilmez** bir dosyadır ❗
* Uygulamanın:

  * **Activity**
  * **Service**
  * **Broadcast Receiver**
  * **Temel proje bilgileri**

  gibi **kritik bileşenleri** bu dosyada tanımlanır.
* Dosya **XML formatındadır**, bu sayede:

  * **Okunması kolaydır**
  * **Düzenlemesi pratiktir** 🛠️
* Kodlar **< > (tag / etiket)** yapısı ile yazılır:

  * `<etiket>` ile başlar
  * `</etiket>` ile kapanır

---

## 🧩 **Temel AndroidManifest Etiketleri**

### 🔹 **`<manifest>`**

* Uygulamanın:

  * **Versiyon numarası**
  * **Paket adı**
  * **İzinleri**
  * **Minimum & maksimum SDK sürümleri**

  gibi **en temel ayarları** burada yapılır.
* Projede kullanılan **kütüphaneler ve SDK yapılandırmaları** bu bölümde belirlenir.

---

### 🔹 **`package`**

* Uygulamanın **paket adını** tanımlar.
* Genellikle:

  * `com.atilimciftci.denemeuygulamasi`
    formatında yazılır 🌐
* Amaç:
  👉 **Paket adının benzersiz (unique) olması**

⚠️ **Önemli Not:**

* Paket adı **tamamen geliştiriciye aittir**
* Uygulama **marketlerde yayımlanırken de** bu ad kullanılır
* Bu nedenle **her uygulama için unique yani benzersiz bir paket adı seçilmelidir**

---

### 🔹 **`<application>`**

* Uygulamanın genel özellikleri burada tanımlanır:

  * **Uygulama ikonu** (`android:icon`)
  * **Uygulama adı** (`android:label`)
  * **Tema** (`android:theme`)
* Ayrıca:

  * **Donanım hızlandırma**
  * **Yedekleme ayarları**

  gibi özellikler de bu etiket altında eklenebilir ⚙️

---

### 🔹 **`<activity>`**

* Uygulamada yer alan **tüm ekranlar (activity’ler)** bu etiket ile tanımlanır.
* Her activity’ye ait **özellikler ve davranışlar** burada belirlenir.

---

### 🔹 **`<intent-filter>`**

* **Activity, Service ve Broadcast Receiver** bileşenlerinin:

  * Hangi intent’lere cevap vereceğini belirtir
* İçinde şu etiketler bulunur:

  * `<action>`
  * `<category>`
  * `<data>`
* ⚠️ **`<action>` etiketi mutlaka eklenmelidir**

---

### 🔹 **`<action>`**

* Uygulama çalıştığında **ilk açılacak sınıfı** belirtir 🚀
* Genellikle şu şekilde tanımlanır:

  * `android.intent.action.MAIN`
* Kendini kapatan tag yapısı kullanılabilir:

  * `<action ... />`
    → Ayrı bir kapanış etiketine gerek yoktur

---

## 📌 **Genel Not**

* AndroidManifest.xml yalnızca:

  * `manifest`
  * `package`
  * `application`
  * `activity`
  * `intent-filter`
  * `action`

  etiketleriyle **sınırlı değildir** ❗
* İhtiyaca göre:

  * **İzinler (permissions)** (İnternet izni, Kamera izni)
  * **Servisler**: (Ekranı olmayan, arka planda çalışan yapılardır. Örneğin arka planda müzik çalma)
  * **Broadcast Receiver** (Düşük pil, internet kesilmesi gibi olayların dinlenmesidir.)

  gibi ek yapılar da bu dosyaya eklenmelidir.

---

## 6.1.2. **MainActivity ve Activity Yapısı**

* **MainActivity**, uygulamanın **ana Java dosyasıdır** ve `java` klasörü altındaki **paket içinde** yer alır.
* Her **Activity** iki parçadan oluşur:

  * **Java dosyası** → işlem / mantık
  * **XML dosyası** → arayüz / tasarım 🎨
* **MainActivity**’nin tasarım dosyası:

  * `res/layout/activity_main.xml`

🔁 Java ve XML dosyaları **birbirine bağlıdır**:

* Java’daki kod → XML’i
* XML’deki tasarım → Java’yı etkiler

---

## ➕ **Yeni Activity Ekleme (Kısaca)**

* `java` klasöründe paket adına **sağ tık → New > Activity**
* Activity seçilir → **Next**
* Ayarlar:

  * **Activity Name**
  * **Generate Layout File** ✅
  * **Source Language:** Java
* **Finish** →
  👉 Yeni **Java Activity** + ona bağlı **XML layout** otomatik oluşur

---


## 📁 **6.1.3. res (Resources)**

* **res**, uygulamanın tüm **görsel ve kaynak dosyalarını** içerir.
* Alt klasörlerin **her biri farklı bir amaç** için kullanılır.
* Dışarıdan **dosya eklenebilir**.

---

## 🖼️ **6.1.3.1. drawable**

* Uygulamada kullanılan:

  * **Resimler** (`.png`, `.jpg`, `.gif`)
  * **XML drawable** dosyaları
    burada tutulur.
* Farklı ekran yoğunlukları için klasörlenir:

  * `drawable-ldpi` → düşük
  * `drawable-mdpi` → orta
  * `drawable-hdpi` → yüksek
  * `drawable-xhdpi / xxhdpi / xxxhdpi` → çok yüksek 📱

---

## 🧱 **6.1.3.2. layout**

* Uygulamanın **arayüz (UI)** dosyaları burada yer alır.
* Tüm dosyalar **XML formatındadır**.
* 3 farklı düzenleme modu vardır:

  * **Code** → sadece XML
  * **Split** → XML + tasarım eş zamanlı 🔁
  * **Design** → sürükle-bırak (kod yok)

---

## 🚀 **6.1.3.3. mipmap**

* Uygulamanın **ikonları (launcher icon)** burada bulunur.
* Farklı ekran yoğunlukları için **ayrı ayrı** tanımlanır.
* Varsayılan ikon: **`ic_launcher`** 🎯


