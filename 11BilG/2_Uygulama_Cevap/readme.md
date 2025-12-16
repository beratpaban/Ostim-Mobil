### 1\. Bölüm Çözümü: Veri Yapısı (Sınıflar)

Bu bölümde Nesne Yönelimli Programlamanın (OOP) temellerini uyguluyoruz.

#### **Adım 1: Temel Sınıf (`Kisi`) Çözümü**

Burada **Kapsülleme (Encapsulation)** yapıyoruz. Değişkenleri gizleyip, sadece izin verdiğimiz (getter metodu) yolla okunmasını sağlıyoruz.

```java
public class Kisi {
    
    // GÖREV 1 ÇÖZÜMÜ: Değişkenler private (özel) tanımlanır.
    private String adSoyad;
    private int yas;

    // --- BURASI HAZIRDI (CONSTRUCTOR) ---
    public Kisi(String adSoyad, int yas) {
        this.adSoyad = adSoyad;
        this.yas = yas;
    }
    // ----------------------------------

    // GÖREV 2 ÇÖZÜMÜ: Getter metodu.
    // Dışarıdan 'adSoyad'a doğrudan erişilemediği için bu metot köprü görevi görür.
    public String getAdSoyad() {
        return adSoyad;
    }
}
```

#### **Adım 2: Miras Alma (`Ogrenci`) Çözümü**

Burada **Kalıtım (Inheritance)** devreye giriyor. `Ogrenci` sınıfı `Kisi` sınıfının tüm özelliklerini (ad, yaş) devralıyor.

```java
public class Ogrenci extends Kisi { 
    
    // GÖREV 3 ÇÖZÜMÜ: Öğrenciye has özellik.
    private String kulupAdi;

    // --- BURASI HAZIRDI (CONSTRUCTOR) ---
    public Ogrenci(String ad, int yas, String kulupAdi) {
        super(ad, yas); 
        this.kulupAdi = kulupAdi; 
    }
    // ----------------------------------

    // GÖREV 4 ÇÖZÜMÜ: Return'lü metot.
    // 'getAdSoyad()' metodunu miras aldığımız için doğrudan kullanabildik.
    public String bilgiVer() {
        return "Öğrenci: " + getAdSoyad() + " - Kulüp: " + kulupAdi; 
    }
}
```

-----

### 2\. Bölüm Çözümü: Arayüz ve Mantık (MainActivity)

Bu kısımda Java kodlarını XML arayüzü ile konuşturuyoruz.

#### **Adım 3, 4 ve 5: MainActivity.java Çözümü**

Burada dikkat edilmesi gereken en kritik nokta **Tür Dönüşümü (Type Casting)** işlemidir. `EditText` her zaman `String` verir, ancak bizim `Kisi` sınıfımız yaş için `int` bekler. Bu yüzden `Integer.parseInt` kullanırız.

```java
public class MainActivity extends AppCompatActivity {
    
    // GÖREV 5 ÇÖZÜMÜ: Liste Tanımlama
    // 'Ogrenci' tipinde nesneleri tutacak dinamik bir liste oluşturuyoruz.
    ArrayList<Ogrenci> sinifListesi = new ArrayList<>(); 
    
    // GÖREV 6 ÇÖZÜMÜ: Arayüz Değişkenleri
    EditText etAd, etYas, etKulup;
    Button btnKaydet;
    TextView tvSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // Window Insets kodları... (Aynen kalıyor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // GÖREV 7 ÇÖZÜMÜ: Bağlama İşlemi (Binding)
        // XML'de verdiğimiz ID'ler (editAd, editYas vb.) burada eşleştirilir.
        etAd = findViewById(R.id.editAd);
        etYas = findViewById(R.id.editYas);
        etKulup = findViewById(R.id.editKulup);
        btnKaydet = findViewById(R.id.btnKaydet);
        tvSonuc = findViewById(R.id.textSonuc);

        // GÖREV 8 ÇÖZÜMÜ: Buton Tıklama Olayı
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Verileri Al
                String gelenAd = etAd.getText().toString();
                String gelenKulup = etKulup.getText().toString();
                
                // Dikkat: String gelen yaşı sayıya çeviriyoruz.
                // Eğer kutu boşsa uygulama çökmemesi için basit bir "0" varsayımı yapılabilir.
                // Ancak ders örneği olduğu için doğrudan çeviriyoruz:
                int gelenYas = Integer.parseInt(etYas.getText().toString());

                // 2. Nesne Üret (Constructor'ı çağırıyoruz)
                Ogrenci yeniOgrenci = new Ogrenci(gelenAd, gelenYas, gelenKulup);

                // 3. Listeye Ekle
                sinifListesi.add(yeniOgrenci);

                // 4. Ekrana Bas (Metodu çağır)
                ekraniGuncelle();
            }
        });
    }

    // GÖREV 9 ÇÖZÜMÜ: Void Metot (Ekrana Yazdırma)
    public void ekraniGuncelle() {
        String tumYazilar = ""; // Boş bir string kutusu
        
        // Foreach Döngüsü: Listenin başından sonuna kadar gider
        for (Ogrenci siradakiOgrenci : sinifListesi) {
            // bilgiVer() metodu bize "Öğrenci: Ali - Kulüp: Müzik" gibi bir string verir.
            // "\n" işareti her öğrenciyi alt satıra atar.
            tumYazilar += siradakiOgrenci.bilgiVer() + "\n";
        }
        
        // Döngü bitince oluşan büyük metni TextView'a yapıştırıyoruz.
        tvSonuc.setText(tumYazilar);
        
        // İsteğe bağlı: Ekleme yaptıktan sonra kutuları temizleyebiliriz
        etAd.setText("");
        etYas.setText("");
        etKulup.setText("");
    }
}
```
