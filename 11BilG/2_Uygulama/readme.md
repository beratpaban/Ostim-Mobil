# 🛠️ Uygulama Rehberi: Okul Kulüp Sistemi

Gençler, bugün Android'de çalışan bir **Kulüp Kayıt Sistemi** yapıyoruz. Amacımız; öğrenci bilgilerini (Ad, Yaş, Kulüp) girip bir listede biriktirmek.

İskeleti ben kurdum, **Yapıcı Metotları (Constructor)** hazır verdim. Geriye kalan mantığı ve boşlukları yönergeleri takip ederek siz dolduracaksınız.

Hadi başlayalım\!

-----

### 1\. Bölüm: Veri Yapısını Kurma (Sınıflar)

Veriyi taşımak için iki sınıfımız olacak: `Kisi` ve ondan türeyen `Ogrenci`.

**Adım 1: Temel Sınıf (`Kisi`)**

```java
public class Kisi {
    
    // GÖREV 1: Ad (String) ve Yas (int) değişkenlerini 'private' (gizli) olarak tanımla.
    // ... (Kod buraya) ...

    
    // --- BURASI HAZIR (CONSTRUCTOR) ---
    // Bu metot, nesne ilk oluşturulduğunda çalışır ve verileri yerleştirir.
    public Kisi(String adSoyad, int yas) {
        this.adSoyad = adSoyad;
        this.yas = yas;
    }
    // ----------------------------------


    // GÖREV 2: İsim değişkeni private olduğu için, dışarıdan okunabilsin diye 
    // public bir Getter metodu yaz (getAdSoyad).
    // ... (Kod buraya) ...
}
```

**Adım 2: Miras Alma (`Ogrenci`)**

```java
public class Ogrenci extends Kisi { // Kisi sınıfının özelliklerini miras aldık
    
    // GÖREV 3: Sadece öğrenciye özel olan 'kulupAdi' değişkenini tanımla.
    // ... (Kod buraya) ...


    // --- BURASI HAZIR (CONSTRUCTOR) ---
    // Hem Kişi özelliklerini (super) hem de Kulüp özelliğini ayarlar.
    public Ogrenci(String ad, int yas, String kulupAdi) {
        super(ad, yas); // Ad ve Yaşı üst sınıfa (Kisi) yolluyoruz
        this.kulupAdi = kulupAdi; // Kulübü kendimiz tutuyoruz
    }
    // ----------------------------------


    // GÖREV 4: Tüm bilgileri (Ad + Kulüp) tek bir cümle (String) olarak 
    // döndüren 'bilgiVer' isimli metodu yaz.
    // İpucu: return "Öğrenci: " + ... ;
}
```

-----

### 2\. Bölüm: Arayüz ve Mantık (MainActivity)

Şimdi `MainActivity.java` dosyasına geçelim ve parçaları birleştirelim.

**Adım 3: Değişkenler ve Tanımlamalar**

```java
public class MainActivity extends AppCompatActivity {
    
    // GÖREV 5: Öğrenci nesnelerini içinde tutacak boş bir ArrayList tanımla.
    // ... (Kod buraya) ...
    
    // GÖREV 6: Arayüz elemanlarını (EditText, Button, TextView) değişken olarak tanımla.
    // ... (Kod buraya) ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // Window Insets ayarları (Standart kod)...
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // GÖREV 7: findViewById ile XML'deki id'leri yukarıdaki değişkenlere bağla.
        // ... (Kod buraya) ...

        // GÖREV 8: Butona tıklandığında çalışacak kodu (setOnClickListener) yaz.
        // Bu bloğun içinde sırasıyla:
        // 1. Verileri EditText'ten al (String ve int çevrimi yap).
        // 2. 'new Ogrenci(...)' diyerek yeni nesne üret.
        // 3. Nesneyi listeye ekle (.add).
        // 4. Aşağıdaki ekraniGuncelle() metodunu çağır.
    }

    // GÖREV 9: Listeyi ekrana basan 'void' metodu tamamla.
    public void ekraniGuncelle() {
        // 1. Boş bir String değişken oluştur.
        // 2. Foreach döngüsü ile listeyi gez.
        // 3. Her öğrencinin bilgisini String değişkene ekle (\n ile alt satıra geç).
        // 4. Sonucu TextView'a yazdır (setText).
    }
}
```