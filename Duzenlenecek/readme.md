### Ekran 1: Açılış (Splash) Ekranı
Kullanıcı uygulamaya tıkladığında onu karşılayan, arka planda kontrollerin yapıldığı kısa süreli ekrandır.
* **Görsel Öğeler:** Ortada büyük ve şık bir Market/Stok ikonu ve altında uygulamanın adı (Örn: "StokTakip Pro").
* **Arka Plan İşlevi:** Bu ekranda 2-3 saniyelik bir bekleme süresi olur. Bu sırada arka planda `SharedPreferences` kontrol edilir. Eğer kullanıcı daha önce "Beni Hatırla" diyerek giriş yapmışsa doğrudan **Ana Menü'ye (Ekran 4)** yönlendirilir. Giriş yapmamışsa **Giriş Yap Ekranına (Ekran 3)** atılır.

### Ekran 2: Kayıt Ol (Register) Ekranı
Sistemi ilk kez kullanacak market sahiplerinin bilgilerini alacağımız ekran.
* **Girdi Alanları (EditText):**
    * Market Adı (Örn: Ostim Market)
    * Kullanıcı Adı
    * Şifre
* **Butonlar:**
    * **Kayıt Ol Butonu:** Bilgileri `SharedPreferences`'a yazar ve Giriş ekranına yönlendirir.
    * **"Zaten hesabım var, Giriş Yap" Metni (Tıklanabilir):** Kullanıcıyı Giriş ekranına döndürür.

### Ekran 3: Giriş Yap (Login) Ekranı
Kayıtlı kullanıcının sisteme eriştiği ekran.
* **Görsel Öğeler:** Üst kısımda sade bir hoş geldin mesajı veya logo.
* **Girdi Alanları (EditText):**
    * Kullanıcı Adı
    * Şifre
* **Kontrol Öğesi (CheckBox/Switch):**
    * **"Beni Hatırla" Kutucuğu:** İşaretlenirse oturum bilgisi kaydedilir, bir sonraki açılışta şifre sorulmaz.
* **Butonlar:**
    * **Giriş Yap Butonu:** Bilgileri kontrol eder, doğruysa Ana Menü'ye geçirir.
    * **"Hesabın yok mu? Kayıt Ol" Metni (Tıklanabilir):** Kullanıcıyı Kayıt ekranına yönlendirir.

### Ekran 4: Ana Menü (Dashboard)
Uygulamanın kalbi. Kullanıcının tüm işlemlere ulaştığı kontrol paneli.
* **Üst Bilgi (Header):** `SharedPreferences`'tan çekilen bilgi ile "Hoş Geldiniz, [Market Adı]" yazısı.
* **Tema Kontrolü:** Sağ üst köşede "Açık/Koyu Tema" geçişini sağlayan bir **Switch** veya **Gündüz/Gece ikonu**.
* **İşlem Butonları (Geniş, Tıklanabilir Kartlar):**
    * **Ürün Ekle:** Yeni stok girmek için Ekran 5'e yönlendirir.
    * **Stok Listesi:** Mevcut ürünleri görmek için Ekran 6'ya yönlendirir.
    * **Çıkış Yap:** "Beni Hatırla" tercihini sıfırlayıp Giriş ekranına döndürür.

### Ekran 5: Ürün Ekleme Ekranı
SQLite veri tabanına yazılacak bilgilerin kullanıcıdan alındığı form ekranı.
* **Üst Bilgi:** Geri dönüş oku ve "Yeni Ürün Ekle" başlığı.
* **Girdi Alanları (EditText):**
    * Ürün Adı (Metin)
    * Kategori (Metin - Örn: Atıştırmalık, İçecek)
    * Stok Adedi (Sadece Rakam)
    * Birim Fiyatı (Ondalıklı Rakam)
* **Buton:**
    * **Kaydet Butonu:** Tıklandığında verileri SQLite'a (`INSERT` ile) yazar ve ekrana "Ürün Başarıyla Eklendi" uyarısı (Toast mesajı) verir. Girdi alanlarını temizler.

### Ekran 6: Stok Listesi Ekranı
Tüm ürünlerin alt alta, düzenli bir şekilde listelendiği ekran.
* **Üst Bilgi:** Geri dönüş oku ve "Stoktaki Ürünler" başlığı.
* **Liste Yapısı (RecyclerView):** Veri tabanından çekilen ürünlerin sergilendiği kaydırılabilir liste.
* **Tekil Liste Öğesi (Item Tasarımı):** Listedeki her bir satırda şunlar görünür:
    * Sol tarafta büyük puntolarla **Ürün Adı** ve altında ufak puntolarla **Kategori**.
    * Sağ tarafta **Stok Adedi** ve **Fiyat**.


---
