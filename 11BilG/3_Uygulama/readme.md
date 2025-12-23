# 🎬 Uygulama Rehberi: Kişisel Film Arşivim

Gençler, bugün Android cihazımızda kendi **Film Arşivimizi** oluşturuyoruz. Sevdiğimiz filmlerin adını, çıkış yılını ve yönetmenini kaydedip ekranda listeleyeceğimiz bir uygulama tasarlayacağız.

Sınıflar arasındaki **Kalıtım (Inheritance)** bağını kullanarak kodumuzu daha profesyonel hale getireceğiz. Hazırsanız başlayalım!

---

### 1. Bölüm: Veri Yapısını Kurma (Sınıflar)

Uygulamamızda verileri düzenli tutmak için iki sınıf kullanacağız: Genel bir `Medya` sınıfı ve ondan türeyen `Film` sınıfı.

**Adım 1: Temel Sınıf (`Medya`)**

```java
public class Medya {
    
    // GÖREV 1: Film adı (String) ve Yayın Yılı (int) değişkenlerini 'private' olarak tanımla.
    // ... (Kod buraya) ...

    
    // --- BURASI HAZIR (CONSTRUCTOR) ---
    public Medya(String ad, int yil) {
        this.ad = ad;
        this.yil = yil;
    }
    // ----------------------------------


    // GÖREV 2: 'ad' değişkeni private olduğu için, dışarıdan okunabilsin diye 
    // public bir Getter metodu yaz (getAd).
    // ... (Kod buraya) ...
}

```

**Adım 2: Miras Alma (`Film`)**

```java
public class Film extends Medya { // Medya sınıfından özellikleri miras alıyoruz
    
    // GÖREV 3: Filme özel olan 'yonetmen' (String) değişkenini tanımla.
    // ... (Kod buraya) ...


    // --- BURASI HAZIR (CONSTRUCTOR) ---
    public Film(String ad, int yil, String yonetmen) {
        super(ad, yil); // Ad ve Yılı üst sınıfa (Medya) gönderiyoruz
        this.yonetmen = yonetmen; 
    }
    // ----------------------------------


    // GÖREV 4: Film bilgilerini (Ad + Yönetmen) tek bir satırda 
    // döndüren 'filmBilgisi' isimli metodu tamamla.
    // İpucu: return "🎬 " + ... ;
}

```

---

### 2. Bölüm: Arayüz ve Mantık (MainActivity)

Parçaları birleştirip ekranı canlandırma zamanı! `MainActivity.java` dosyasında listemizi yöneteceğiz.

**Adım 3: Değişkenler ve Tanımlamalar**

```java
public class MainActivity extends AppCompatActivity {
    
    // GÖREV 5: Film nesnelerini saklayacağımız 'ArrayList' listesini tanımla.
    // ... (Kod buraya) ...
    
    // GÖREV 6: Görsel bileşenleri (EditText, Button, TextView) değişken olarak tanımla.
    // ... (Kod buraya) ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // GÖREV 7: findViewById ile XML'deki id'leri (editFilmAd, editYil, editYonetmen, btnEkle, textListe) 
        // yukarıdaki değişkenlere bağla.
        // ... (Kod buraya) ...


        // GÖREV 8: 'Ekle' butonuna tıklandığında (setOnClickListener) yapılacakları yaz:
        // 1. EditText'lerden verileri al.
        // 2. Yeni bir 'Film' nesnesi oluştur (new Film).
        // 3. Bu nesneyi film listesine ekle (.add).
        // 4. Arşivi güncellemek için listeyiYenile() metodunu çağır.
        // 5. Giriş kutularını temizle (.setText("")).
    }

    // GÖREV 9: Arşivi ekrana yazdıran 'listeyiYenile' metodunu tamamla.
    public void listeyiYenile() {
        // 1. Boş bir metin (String) oluştur.
        // 2. Gelişmiş For (Foreach) döngüsü ile film listesini tara.
        // 3. Her filmin bilgisini metne ekle (Her filmden sonra \n ile alt satıra geç).
        // 4. Hazırladığın metni TextView'a bas (setText).
    }
}

```

---

### 💡 Öğretmen Notu ve İpuçları

* 
Kalıtım (Inheritance): `Film extends Medya` diyerek, filmin aslında bir medya türü olduğunu belirttik. Bu sayede `Medya` sınıfındaki kodları tekrar yazmak zorunda kalmadık.


* 
ArrayList: Dizilerin aksine `ArrayList` boyutu dinamiktir. Yeni film ekledikçe liste kendiliğinden büyür.


* 
**Veri Dönüşümü:** `EditText`'ten gelen yıl bilgisini sayıya çevirmek için `Integer.parseInt()` kullanmayı unutmayın! 



