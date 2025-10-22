## İçindekiler

1. Proje amacı
2. Gereksinimler
3. Dosya yapısı (kısa)
4. `MainActivity` kodunun adım adım açıklaması
5. Nasıl çalıştırılır
6. Sıkça sorulan hatalar ve çözümleri

---

## 1) Proje amacı

Küçük bir Android uygulaması. Kullanıcıdan iki tamsayı alır, "Kontrol Et" butonuna basıldığında sayıları karşılaştırır ve sonucu kısa bir `Toast` mesajı ile gösterir (ör. "1. Sayı 2. Sayıdan Büyük").

## 2) Gereksinimler

* Android Studio (tercihen en güncel sürüm)
* Java 8+
* AndroidX destek kütüphaneleri
* `activity_main.xml` içinde uygun `EditText` ve `Button` ID'lerinin tanımlanmış olması:

  * `@+id/main` (root view)
  * `@+id/EditTextSayi1`
  * `@+id/EditTextSayi2`
  * `@+id/kontrolButtonID`

## 3) Dosya yapısı (kısa)

```
app/
  src/main/java/com/example/a1_ornek/MainActivity.java
  src/main/res/layout/activity_main.xml
  AndroidManifest.xml
```

`MainActivity.java` uygulamanın giriş noktasıdır (launcher activity olarak manifest'te tanımlı olmalı).

---

## 4) `MainActivity` kodunun adım adım açıklaması

Aşağıda kodu mantıksal bloklara ayırıp her bloğu açıkladım.

### 4.1 Paket ve importlar

```java
package com.example.a1_ornek;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
```

* `package` satırı: Bu sınıfın proje içindeki yerini belirtir.
* `import` satırları: Kullanılan Android ve AndroidX sınıflarını projeye dahil eder. Örneğin `EditText`, `Button`, `Toast` gibi UI öğeleri.
* `EdgeToEdge`, `ViewCompat`, `WindowInsetsCompat` gibi sınıflar modern UI düzenlemeleri (durum çubuğu/gezinti çubuğu boşlukları) için kullanılır.

---

### 4.2 Sınıf tanımı ve üye değişkenler

```java
public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1;
    EditText editTextNumber2;
    Button kontrolEtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
    }
}
```

* `MainActivity` `AppCompatActivity`'yi genişletir — modern Android aktiviteleri için yaygın base sınıfıdır.
* `EditText` ve `Button` referansları sınıf seviyesinde tanımlanır ki `onCreate` içinde bağlanıp buton tıklama mantığında kullanılabilsin.

---

### 4.3 `onCreate` metodu — yaşam döngüsü başlangıcı

`onCreate` aktivite ilk oluşturulduğunda çalışır. UI kurulumu ve ilk atamalar burada yapılır.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });

    editTextNumber1 = findViewById(R.id.EditTextSayi1);
    editTextNumber2 = findViewById(R.id.EditTextSayi2);
    kontrolEtButton = findViewById(R.id.kontrolButtonID);

    kontrolEtButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s1 = editTextNumber1.getText().toString();
            String s2 = editTextNumber2.getText().toString();
            String toastMesaji;
            int sayi1 = Integer.parseInt(s1);
            int sayi2 = Integer.parseInt(s2);
            if (sayi1 > sayi2) {
                toastMesaji = "1. Sayı 2. Sayıdan Büyük";
            } else if (sayi1 < sayi2) {
                toastMesaji = "2. Sayı 1. Sayıdan Büyük";
            } else {
                toastMesaji = "Sayılar Eşit";
            }
            Toast.makeText(MainActivity.this, toastMesaji, Toast.LENGTH_SHORT).show();
        }
    });
}
```

Aşağıda bu bloğun içindeki önemli satırların açıklamaları:

* `super.onCreate(savedInstanceState);`

  * Üst sınıfın (AppCompatActivity) `onCreate` işlerini yapmasını sağlar. **Her zaman** çağrılmalıdır.

* `EdgeToEdge.enable(this);`

  * Uygulamayı kenardan kenara (sistem çubuklarına doğru) gösterim için hazırlar. Modern tam ekran düzenlemelerinde kullanışlıdır.

* `setContentView(R.layout.activity_main);`

  * `activity_main.xml` içeriğini bu aktiviteye bağlar. Buradan sonra `findViewById` ile XML içindeki bileşenlere erişebiliriz.

* `ViewCompat.setOnApplyWindowInsetsListener(...)`

  * Cihazın durum çubuğu/gezinti çubuğu gibi sistem öğelerinin kapladığı alanları alır ve root view (`R.id.main`) için uygun `padding` uygular. Böylece içerik sistem çubuklarının içine çakılmaz, güvenli alan korunur.

* `findViewById` çağrıları

  * XML içindeki `EditText` ve `Button` elementlerini Java nesnelerine bağlar.

* `kontrolEtButton.setOnClickListener(...)`

  * Butona tıklandığında çalışacak kodu belirler. Burada kullanıcı girdisi okunur, parse edilir, karşılaştırma yapılır ve `Toast` ile sonuç gösterilir.

* `Integer.parseInt(s1)`

  * `String` türündeki metni `int`'e çevirir. Eğer kullanıcı geçerli bir tam sayı girmezse `NumberFormatException` fırlatır (aşağıda hata yönetimi bölümünde çözümler var).

* `Toast.makeText(...).show()`

  * Kısa mesaj baloncuğu (popup) gösterir. `Toast.LENGTH_SHORT` mesajın kısa süreli gösterileceğini belirtir.

---


