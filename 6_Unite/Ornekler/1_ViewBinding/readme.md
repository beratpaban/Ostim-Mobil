

## 🏗️ Uygulama 1: View Binding ile Renk Değiştirici

Bu uygulamada bir `TextView`, bir `EditText` ve bir `Button` kullanarak, kullanıcının girdiği metni ekrana yazdırıp arka plan rengini değiştireceğiz.

### 1. Adım: View Binding'i Aktif Etme

Projenin sol tarafındaki dosya yapısından **Gradle Scripts > build.gradle.kts (Module: app)** dosyasını açın ve `android` bloğunun içine şu kodları ekleyip sağ üstteki **"Sync Now"** butonuna basın:

```kotlin
// build.gradle.kts (Module :app)
android {
    // ... diğer ayarlar
    viewBinding {
        enable = true
    }
}

```

### 2. Adım: Tasarım (activity_main.xml)

Tasarım tarafında nesnelere verdiğiniz **ID**'ler, kod tarafında değişken ismine dönüşeceği için çok önemlidir.

```xml
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/mainLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="20dp">

    <TextView
        android:id="@+id/textViewBaslik"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Merhaba!"
        android:textSize="24sp" />

    <EditText
        android:id="@+id/editTextIsim"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="İsminizi yazın" />

    <Button
        android:id="@+id/buttonGuncelle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="GÜNCELLE" />

</LinearLayout>

```

---

### 3. Adım: Kodlama (MainActivity.java)

İşte öğrencilerine dağıtacağın "Cevap Anahtarı" ve satır satır açıklamaları:

```java
package com.example.viewbindingcalismasi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
// View Binding etkinleştirildiğinde otomatik oluşturulan sınıf:
import com.example.viewbindingcalismasi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Tasarım sınıfına erişmek için binding nesnesini tanımlıyoruz
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Tasarım dosyasını (XML) koda bağlamak için "inflate" (şişirme) işlemi yapıyoruz
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        
        // 2. setContentView içine artık R.layout.activity_main değil, binding'in kök dizinini veriyoruz
        setContentView(binding.getRoot());

        // 3. ARTIK findViewById KULLANMIYORUZ! 
        // XML'deki tüm ID'lere "binding.idIsmi" şeklinde erişebiliriz.

        binding.buttonGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten veriyi alıyoruz
                String kullaniciIsmi = binding.editTextIsim.getText().toString();

                // TextView'a veriyi set ediyoruz
                binding.textViewBaslik.setText("Hoş geldin " + kullaniciIsmi);

                // Arka plan rengini programatik olarak değiştiriyoruz
                binding.mainLayout.setBackgroundColor(Color.LTGRAY);
            }
        });
    }
}

```

---

### 💡 Öğrenciler İçin Kritik Notlar

* **CamelCase Dönüşümü:** XML'de ID'si `button_guncelle` olan bir nesne, Java tarafında `binding.buttonGuncelle` olarak çağrılır (Alt tire kalkar, harf büyür).
* **Bellek Yönetimi:** `binding = null` kontrolü genellikle Fragment'larda kritiktir, ancak Activity'lerde yukarıdaki kullanım başlangıç için yeterlidir.
* **Neden View Binding?** `findViewById` kullandığımızda yanlış ID yazarsak uygulama çökerdi (Null Pointer Exception). View Binding ise daha kod yazarken hata yapmamızı engeller.

---

