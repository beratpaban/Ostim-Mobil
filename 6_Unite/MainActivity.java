package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
// Importlar hariç tutulmuştur.

public class MainActivity extends AppCompatActivity {

    // Galeriden sonuç almak (seçilen resmi getirmek) için kullanılacak fırlatıcı
    // nesne
    ActivityResultLauncher<Intent> galeryResultLauncher;
    // İzin isteme işleminin sonucunu takip etmek için kullanılacak fırlatıcı nesne
    ActivityResultLauncher<String> izinlerResultLauncher;
    // Arayüzdeki resim bileşeni
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Uygulamanın ekranın en üst ve en alt (çentik/navigasyon) kısımlarına kadar
        // yayılmasını sağlar
        EdgeToEdge.enable(this);
        // Aktiviteye bağlanacak XML tasarım dosyasını belirler
        setContentView(R.layout.activity_main);

        // Sistem çubuklarının (durum çubuğu, navigasyon) görünüm alanını (padding)
        // otomatik ayarlar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Galeri sonucunu yakalayacak olan fırlatıcıyı ilklendirir (initialize)
        metotGaleryResultLauncher();
        // İzin isteği sonucunu yakalayacak olan fırlatıcıyı ilklendirir (initialize)
        metotIzinlerResultLauncher();

        // Tasarımdaki ImageView bileşenini ID'si ile koda bağlar
        imageView = findViewById(R.id.imageViewSecim);
        // Başlangıçta ImageView içine varsayılan bir logo resmi atar
        imageView.setImageResource(R.drawable.logo);
    }

    // Butona tıklandığında (XML tarafında tanımlı) çalışacak metod
    public void galeriyeGit(View view) {
        // Medya okuma izninin daha önce verilip verilmediğini kontrol eder
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_DENIED) {
            // Android sistemi, kullanıcıya neden izne ihtiyaç duyduğumuzu açıklayan bir
            // mantık gösterilip gösterilmeyeceğine karar verir
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_MEDIA_IMAGES)) {
                // Kullanıcıya bir Snackbar göstererek iznin neden gerektiğini açıklar
                Snackbar.make(view, "İzni vermeniz gerekmektedir.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("İzin ver", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Snackbar üzerindeki butona basıldığında izin isteme sürecini başlatır
                                izinlerResultLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
                            }
                        }).show();
            } else {
                // Mantık göstermeye gerek yoksa (ilk kez soruluyorsa) doğrudan izin ister
                izinlerResultLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
            }
        } else {
            // İzin zaten daha önce verilmiş, doğrudan galeriyi açar
            Intent galeri = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galeryResultLauncher.launch(galeri);
        }
    }

    // Galeriye gidip geri gelindiğinde ne yapılacağını tanımlayan metod
    public void metotGaleryResultLauncher() {
        // Bir aktiviteden sonuç bekleyerek kayıt (register) işlemi yapar
        galeryResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Eğer kullanıcı bir şey seçip geri geldiyse (OK)
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intentSonuc = result.getData();
                            if (intentSonuc != null) {
                                // Seçilen resmin cihazdaki adresini (URI) alır
                                Uri fotoVeri = intentSonuc.getData();
                                // Alınan bu URI bilgisini ImageView içine yerleştirerek resmi gösterir
                                imageView.setImageURI(fotoVeri);
                            }
                        }
                    }
                });
    }

    // İzin isteme penceresi kapandığında ne yapılacağını tanımlayan metod
    public void metotIzinlerResultLauncher() {
        // Tekli izin isteme sözleşmesiyle kayıt işlemi yapar
        izinlerResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean result) {
                        // Eğer kullanıcı izin verdiyse (true)
                        if (result == true) {
                            // İzin alındığı için galeri açma niyetini (Intent) oluşturur ve başlatır
                            Intent galeri = new Intent(Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            galeryResultLauncher.launch(galeri);
                        } else {
                            // Kullanıcı izni reddettiyse kısa bir uyarı mesajı gösterir
                            Toast.makeText(MainActivity.this, "İzin vermeniz gerekmektedir.", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
    }
}