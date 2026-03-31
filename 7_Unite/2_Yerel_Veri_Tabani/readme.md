

### Modül 1: SQLite Nedir? (Teorik Temel)
SQLite, Android'in içine gömülü gelen, dosya tabanlı bir veritabanıdır. Sunucu gerektirmez (Serverless). Telefonunuzdaki bir uygulama silinmediği sürece veriler o telefonun içinde güvenle saklanır.



**Neden SQLite Kullanıyoruz?**
* **Kalıcıdır:** Uygulama kapansa da veriler silinmez.
* **Düzenlidir:** Excel tablosu gibi satır ve sütunlardan oluşur.
* **Hızlıdır:** Cihazın kendi hafızasında olduğu için internet hızı gerekmez.

---

### Modül 2: Tablo Yapısını Kurmak (CREATE)
Bir veritabanında verileri saklamadan önce "kalıpları" yani tabloları oluşturmalıyız. 

> **Kritik Kural:** Her tablonun mutlaka benzersiz bir kimliği olmalıdır (**PRIMARY KEY**).

**Örnek Senaryo: Öğrenci Kayıt Sistemi**
| ID (PK) | AD (TEXT) | SOYAD (TEXT) | NOT (INT) |
| :--- | :--- | :--- | :--- |
| 1 | Ahmet | Yılmaz | 85 |
| 2 | Elif | Kaya | 90 |

**SQL Kodu:**
```sql
CREATE TABLE ogrenciler (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    ad TEXT NOT NULL,
    soyad TEXT,
    puan INTEGER DEFAULT 0
);
```

---

### Modül 3: Veri Ekleme ve Okuma (INSERT & SELECT)
Tabloyu oluşturduktan sonra içine veri koymamız ve o veriyi çekmemiz gerekir.

**Veri Ekleme:**
```sql
INSERT INTO ogrenciler (ad, soyad, puan) VALUES ('Ali', 'Can', 75);
```

**Veri Okuma (Sorgulama):**
* **Tüm tabloyu getir:** `SELECT * FROM ogrenciler;`
* **Sadece isimleri getir:** `SELECT ad FROM ogrenciler;`
* **Filtrele (80'den yüksek alanlar):** `SELECT * FROM ogrenciler WHERE puan > 80;`

`SELECT` komutu, bir veritabanındaki binlerce veri arasından tam olarak ihtiyacınız olanı çekip almanızı sağlayan bir "filtreleme" ve "çağırma" aracıdır. Öğrencilerinize anlatırken bunu bir kütüphanedeki devasa bir dolaptan sadece istediğiniz kitapları (veya o kitapların sadece isimlerini) seçmek gibi düşündürebilirsiniz.

SQLiteOnline üzerinde denetebileceğiniz, basitten karmaşığa doğru `SELECT` mantığı şöyledir:

---

#### 3.1. Her Şeyi Getirmek (`SELECT *`)
En temel komuttur. Tablodaki tüm sütunları ve tüm satırları olduğu gibi ekrana döker. Buradaki `*` (yıldız) sembolü **"Hepsi"** anlamına gelir.

```sql
-- "Ogrenciler" tablosundaki her şeyi göster
SELECT * FROM Ogrenciler;
```
**Mantık:** "Bana bütün listeyi, hiçbir ayrım yapmadan getir."

---

#### 3.2. Sütun Seçmek (Veri Ayıklama)
Bazen tablodaki tüm bilgilere (örneğin öğrencinin TC kimlik numarasına veya adresine) ihtiyacımız olmaz. Sadece belirli başlıkları görmek istersek sütun adlarını yazarız.

```sql
-- Sadece ad ve soyad sütunlarını getir
SELECT ad, soyad FROM Ogrenciler;
```
**Mantık:** "Bütün tabloyu değil, sadece ihtiyacım olan sütunları (başlıkları) göster."

---

#### 3.3. Şartlı Seçim (`WHERE` Kullanımı)
İşte gerçek güç buradadır. Binlerce veri arasından sadece belirli bir kurala uyanları ayıklarız.



**Örnekler:**
* **Sayısal Filtre:** Notu 50'den büyük olanlar.
    ```sql
    SELECT * FROM Ogrenciler WHERE not_ortalamasi > 50;
    ```
* **Metinsel Filtre:** Sadece 'Ankara'da yaşayanlar.
    ```sql
    SELECT * FROM Ogrenciler WHERE sehir = 'Ankara';
    ```
**Mantık:** "Bana sadece bu kurala uyan satırları getir."

---

#### 3.4. Veriyi Sıralamak (`ORDER BY`)
Verilerin hangi sırayla geleceğini belirler. Uygulamalarda "En yüksek puan" veya "A'dan Z'ye sırala" butonlarının arkasındaki mantıktır.

* **ASC (Ascending):** Küçükten büyüğe / A'dan Z'ye.
* **DESC (Descending):** Büyükten küçüğe / Z'den A'ya.

```sql
-- Puanı en yüksekten en düşüğe doğru sırala
SELECT * FROM Ogrenciler ORDER BY puan DESC;
```

---

#### 3.5. Benzerlik Arama (`LIKE` Operatörü)
Tam ismini bilmediğimiz veya belirli bir harfle başlayan verileri bulmak için kullanılır. `%` işareti "herhangi bir şey gelebilir" demektir.

```sql
-- Adı 'A' harfi ile başlayan tüm öğrencileri bul
SELECT * FROM Ogrenciler WHERE ad LIKE 'A%';
```
**Mantık:** "Başı A olsun, gerisi ne olursa olsun."

---

## Özet Tablo

| Komut Parçası | Ne Anlama Gelir? | Gerçek Hayat Karşılığı |
| :--- | :--- | :--- |
| **SELECT** | Neyi alayım? | "Kitabın adını ve yazarını getir." |
| **FROM** | Nereden alayım? | "Kütüphane dolabından bak." |
| **WHERE** | Hangi şartla alayım? | "Sadece 2024 basımı olanları getir." |
| **ORDER BY** | Nasıl dizeyim? | "Sayfa sayısına göre sırala." |

---

### Modül 4: Veri Güncelleme ve Silme (UPDATE & DELETE)
Hatalı bir veriyi düzeltmek veya silmek için **WHERE** komutu hayati önem taşır. Eğer `WHERE` kullanmazsanız, sınıftaki herkesin adı aynı olur!

**Güncelleme:**
```sql
-- ID'si 1 olan öğrencinin notunu 100 yap
UPDATE ogrenciler SET puan = 100 WHERE id = 1;
```

**Silme:**
```sql
-- Puanı 50'den düşük olanları listeden çıkar
DELETE FROM ogrenciler WHERE puan < 50;
```

---

### Modül 5: Android Studio & Java Entegrasyonu
SQLite'ı Java içinde yönetirken 2 ana yapı kullanılır:

1.  **SQLiteOpenHelper:** Veritabanını oluşturma ve güncelleme (onCreate, onUpgrade).
2.  **SQLiteDatabase:** Ekleme, silme, sorgulama gibi işlemleri yürütme.



**Ders İpucu (Öğrencilere Anlatırken):**
"Çocuklar, `getWritableDatabase()` metodunu, veritabanına bir şeyler yazmak için elinize kalem almak gibi düşünün. `getReadableDatabase()` ise sadece defteri okumaktır."

---
