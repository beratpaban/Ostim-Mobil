# 🛠️ 6.1. PROJE YAPILANDIRMA AYARLARI

Android Studio'da "File > New Project" dediğimizde karşımıza çıkan o kalabalık dosya yapısı aslında çok düzenli bir sistemdir. Bir mobil uygulamanın anatomisini, **kod örnekleri** üzerinden inceleyelim.

---

## 1. 🆔 AndroidManifest.xml (Uygulamanın Kimliği)

Bu dosya, uygulamanın **pasaportudur**. Uygulama çalışmadan önce Android sistemi bu dosyayı okur ve "Sen kimsin?", "Hangi yetkilere sahipsin?" diye sorar.

> **Konum:** `app > manifests > AndroidManifest.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Test1">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

```

---

## 2. 🧠 MainActivity.java (Uygulamanın Beyni)

Tasarımın arkasındaki mantıksal işlemlerin döndüğü yerdir. Butona basılınca ne olacağını burada yazarız.

> **Konum:** `app > java > com.okul.proje > MainActivity`

```java
package com.okul.projeniz; // Uygulamanın paket adresi

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

// 'extends AppCompatActivity': Bu sınıfın bir Android ekranı olduğunu belirtir.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // ⭐ EN ÖNEMLİ SATIR:
        // Bu Java kodunu, 'activity_main.xml' tasarım dosyasıyla birleştirir.
        // Bu satır olmazsa ekran bembeyaz görünür!
        setContentView(R.layout.activity_main);
    }
}

```

---

## 3. 🎨 res (Resources) Klasörü

Kod (Java) ile Tasarım (XML/Resim) dosyalarının birbirinden ayrıldığı yerdir. Kodlar `java` klasöründe, geri kalan her şey buradadır.

### 📂 Klasör Yapısı ve Görevleri:

* **`drawable`**: 🖼️ Resimlerin (jpg, png) ve arka plan çizimlerinin konulduğu yer.
* **`layout`**: 📐 Ekran tasarımları. (Örn: `activity_main.xml`). Butonu, yazıyı sürükleyip bıraktığımız yer burasıdır.
* **`mipmap`**: 📱 Uygulama ikonları.
* **`values`**: 📝 Sabit değerler.

#### 👇 Örnek: `values/strings.xml` Dosyası

Uygulamadaki yazıları kodun içine gömmek yerine burada tutarız.

```xml
<resources>
    <string name="app_name">Ders Uygulaması</string>
    
    <string name="btn_giris">Giriş Yap</string>
    <string name="text_hosgeldin">Merhaba Öğrenci!</string>
</resources>

```

---

## 4. 🐘 Gradle Scripts (İnşaat Mühendisi)

Kodları, resimleri ve kütüphaneleri birleştirip `.apk` (yüklenebilir uygulama) haline getiren araçtır.

> **Dosya:** `build.gradle (Module: app)`

```groovy
plugins {
    id 'com.android.application' // Bu modülün bir uygulama olduğunu belirtir
}

android {
    namespace 'com.okul.projeniz'
    compileSdk 34 // Uygulamanın derlendiği SDK sürümü

    defaultConfig {
        applicationId "com.okul.projeniz" // 🆔 Market'teki benzersiz kimlik
        minSdk 24 // 📉 Bu uygulama en düşük Android 7.0 (API 24) da çalışır.
        targetSdk 34 // Hedeflenen en güncel sürüm.
        versionCode 1 // Güncelleme sayısı (1, 2, 3...)
        versionName "1.0" // Kullanıcının gördüğü sürüm adı
    }
}

dependencies {
    // 📦 KÜTÜPHANELER
    // Uygulamaya dışarıdan özellik eklediğimiz yer.
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
}

```

---

### 🚀 Haftanın Görevi

1. Boş bir Android projesi oluşturun.
2. `AndroidManifest.xml` dosyasına gidip `<application>` etiketindeki `android:label` kısmını bulun.
3. `Ctrl` (veya Mac için `Cmd`) tuşuna basılı tutarak `label`'ın üzerine tıklayın. Sizi `strings.xml` dosyasına götürecek mi? Deneyin!

---