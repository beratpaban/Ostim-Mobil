### 1. Hazırlık: Hazır Tabloyu ve Verileri Yükleme
[SQLiteOnline](https://sqliteonline.com/) sitesini açın ve aşağıdaki kod bloğunu kopyalayıp "Run" (Çalıştır) butonuna basın. Bu sayede herkesin önünde aynı 40 kayıtlık liste olacak.

```sql
-- Tabloyu oluşturuyoruz
CREATE TABLE Market (
    id INTEGER PRIMARY KEY,
    urun_adi TEXT,
    kategori TEXT,
    fiyat REAL,
    stok_miktari INTEGER
);

-- Hazır verileri ekliyoruz
INSERT INTO Market (urun_adi, kategori, fiyat, stok_miktari) VALUES 
('Süt', 'Süt Ürünleri', 25.50, 40),
('Peynir', 'Süt Ürünleri', 120.00, 15),
('Ekmek', 'Unlu Mamul', 10.00, 100),
('Elma', 'Manav', 30.00, 0),
('Makarna', 'Bakliyat', 15.75, 60),
('Çikolata', 'Atıştırmalık', 20.00, 45),
('Yoğurt', 'Süt Ürünleri', 45.00, 25),
('Domates', 'Manav', 35.00, 50),
('Pirinç', 'Bakliyat', 55.00, 10),
('Bisküvi', 'Atıştırmalık', 12.50, 0),

('Tereyağı', 'Süt Ürünleri', 85.00, 20),
('Zeytin', 'Kahvaltılık', 60.00, 35),
('Yumurta', 'Kahvaltılık', 70.00, 80),
('Portakal', 'Manav', 25.00, 40),
('Muz', 'Manav', 32.00, 30),
('Patates', 'Manav', 18.00, 90),
('Soğan', 'Manav', 15.00, 100),
('Nohut', 'Bakliyat', 40.00, 25),
('Mercimek', 'Bakliyat', 38.00, 45),
('Fasulye', 'Bakliyat', 50.00, 20),

('Cips', 'Atıştırmalık', 22.00, 55),
('Gazoz', 'İçecek', 10.00, 70),
('Kola', 'İçecek', 18.00, 60),
('Su', 'İçecek', 5.00, 200),
('Meyve Suyu', 'İçecek', 15.00, 65),
('Kahve', 'İçecek', 95.00, 30),
('Çay', 'İçecek', 110.00, 25),
('Bal', 'Kahvaltılık', 150.00, 10),
('Reçel', 'Kahvaltılık', 45.00, 35),
('Salça', 'Temel Gıda', 30.00, 40),

('Un', 'Temel Gıda', 25.00, 50),
('Şeker', 'Temel Gıda', 28.00, 60),
('Tuz', 'Temel Gıda', 8.00, 100),
('Sıvı Yağ', 'Temel Gıda', 70.00, 20),
('Margarin', 'Temel Gıda', 40.00, 15),
('Dondurma', 'Atıştırmalık', 35.00, 25),
('Kek', 'Unlu Mamul', 20.00, 30),
('Poğaça', 'Unlu Mamul', 8.00, 120),
('Simit', 'Unlu Mamul', 7.00, 150),
('Kraker', 'Atıştırmalık', 14.00, 50);
```

---

### 2. Aşama: Öğrencilere Sorulacak Görevler (Step-by-Step)

Öğrenciler yukarıdaki tabloyu oluşturduktan sonra, tahtaya veya yansıtıcıya sırayla şu görevleri yazıp onların çözmesini bekleyin:

#### **Görev 1: Tüm Envanteri Görme**
* **Soru:** "Marketimizdeki her şeyi (tüm sütunları) listeleyin."


#### **Görev 2: Sadece Ürün ve Fiyat Odaklı Liste**
* **Soru:** "Müşterilere göstermek için sadece ürün isimlerini ve fiyatlarını listeleyin."


#### **Görev 3: Kategoriye Göre Filtreleme**
* **Soru:** "Sadece 'Süt Ürünleri' kategorisindeki ürünleri getirin."


#### **Görev 4: Stok Alarmı (Sayısal Filtreleme)**
* **Soru:** "Stoğu biten (yani stok miktarı 0 olan) ürünleri bulun."

#### **Görev 5: Ucuzdan Pahalıya Sıralama**
* **Soru:** "Ürünleri en ucuzdan en pahalıya doğru sıralayın."


#### **Görev 6: Karmaşık Sorgu (Final Sorusu)**
* **Soru:** "Fiyatı 20 TL'den pahalı olan ve 'Manav' kategorisinde olan ürünleri listeleyin."

---
