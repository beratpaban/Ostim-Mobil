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

public class MainActivity extends AppCompatActivity {

    // XML dosyasındaki bileşenleri kod tarafında kullanmak için tanımlıyoruz.
    EditText editTextNumber1;   // Kullanıcının 1. sayıyı gireceği EditText.
    EditText editTextNumber2;   // Kullanıcının 2. sayıyı gireceği EditText.
    Button kontrolEtButton;     // Karşılaştırmayı başlatacak buton.

    // Activity ilk açıldığında çalışan metot (Android yaşam döngüsünde onCreate).
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

        // XML’deki bileşenleri Java tarafına bağlıyoruz (findViewById ile).
        editTextNumber1 = findViewById(R.id.EditTextSayi1);   // 1. sayının girişi
        editTextNumber2 = findViewById(R.id.EditTextSayi2);   // 2. sayının girişi
        kontrolEtButton = findViewById(R.id.kontrolButtonID); // "Kontrol Et" butonu

        // Butona tıklandığında çalışacak işlemi tanımlıyoruz.
        kontrolEtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // EditText içindeki metinleri String olarak alıyoruz.
                String s1 = editTextNumber1.getText().toString();
                String s2 = editTextNumber2.getText().toString();

                // Ekranda göstereceğimiz mesajı tutacak değişken.
                String toastMesaji;

                // String ifadeleri tamsayıya (int) çeviriyoruz.
                int sayi1 = Integer.parseInt(s1);
                int sayi2 = Integer.parseInt(s2);

                // Karşılaştırma yapıyoruz:
                if (sayi1 > sayi2) {
                    toastMesaji = "1. Sayı 2. Sayıdan Büyük"; // Eğer 1. sayı büyükse
                } else if (sayi1 < sayi2) {
                    toastMesaji = "2. Sayı 1. Sayıdan Büyük"; // Eğer 2. sayı büyükse
                } else {
                    toastMesaji = "Sayılar Eşit";             // Eğer eşitse
                }

                // Sonuç mesajını kısa süreli bir Toast ile ekranda gösteriyoruz.
                Toast.makeText(MainActivity.this, toastMesaji, Toast.LENGTH_SHORT).show();
            }
        });
    }
}