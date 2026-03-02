Harika gidiyoruz! Şimdi Activity'lerin içinde yaşayan, daha modüler ve esnek bir yapı olan **6.5. Fragment Yapısı** konusunu senin ders notu formatına dönüştürelim.

---

## 🧩 **6.5. Fragment Yapısı**

* **Fragment**, bir Activity (ekran) içerisinde bulunan **parçalı arayüz** yapılarıdır 🧩
* Bir Activity içinde birden fazla Fragment bulunabilir veya bir Fragment farklı Activity'ler tarafından tekrar kullanılabilir.
* **Neden kullanılır?**
* Özellikle tablet gibi büyük ekranlarda ekranı bölmek için.
* Alt menü (Bottom Navigation) veya sekmeli (Tab) yapılarda ekranın sadece bir kısmını değiştirmek için.
* Kodun daha modüler ve yönetilebilir olması için.



---

## 🔄 **6.5.1. Fragment Yaşam Döngüsü**

Fragment'lar bir Activity'ye bağlı oldukları için kendi yaşam döngüleri vardır ama Activity'nin döngüsünden etkilenirler. Activity ölürse içindeki Fragment da ölür.

### 🔹 **Önemli Metotlar:**

* **onAttach():** Fragment, Activity ile ilk bağlandığında çalışır.
* **onCreateView():** Fragment'ın tasarım (XML) dosyasının bağlandığı ve arayüzün oluşturulduğu yerdir. **En kritik metottur** ❗
* **onViewCreated():** Tasarım oluşturulduktan hemen sonra çalışır; View Binding işlemleri genellikle burada yapılır.
* **onDetach():** Fragment'ın Activity ile bağı kesildiğinde çalışır.

---

## 🛠️ **6.5.2. Fragment Oluşturma ve Kullanma**

### **1. Fragment Sınıfı Oluşturma**

Bir Fragment oluşturduğunuzda hem bir Java sınıfı hem de ona bağlı bir XML dosyası oluşur.

**Kod Yapısı (Java):**

```java
public class BlankFragment extends Fragment {
    // Fragment tasarımı burada "şişirilir" (inflate)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}

```

### **2. Activity İçinde Gösterme (Fragment Manager)**

Fragment'lar bir Activity'nin içine yerleştirilmek zorundadır. Bunun için genellikle tasarıma bir `FragmentContainerView` eklenir.

**Geçiş Kod Örneği:**

```java
// Fragment'lar arası geçişi yöneten araç
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

// Yeni fragment'ı belirlenen alana yerleştir
BlankFragment fragment = new BlankFragment();
fragmentTransaction.replace(R.id.fragmentContainerView, fragment);

// İşlemi onayla
fragmentTransaction.commit();

```

---

## ⚖️ **Activity vs Fragment Farkları**

| Özellik | Activity | Fragment |
| --- | --- | --- |
| **Bağımsızlık** | Tamamen bağımsızdır. | Bir Activity'ye muhtaçtır. |
| **Kullanım** | Tek bir ekranı temsil eder. | Ekranın bir parçasını temsil eder. |
| **Hafıza** | Daha fazla kaynak tüketir. | Daha hafiftir (Lightweight). |
| **Tekrar Kullanım** | Zordur. | Çok kolaydır (Reusable). |

---

## 📌 **Özet Notlar**

* Fragment'lar doğrudan **AndroidManifest.xml** dosyasına kaydedilmezler 🚫 (Çünkü bağımsız birer "ekran" değil, birer parçadırlar).
* Modern Android geliştirmede **"Single Activity - Multiple Fragments"** (Tek Activity - Çoklu Fragment) mimarisi çok popülerdir.
* Fragment'lar arasında veri taşımak için `Bundle` sınıfı veya modern bir yöntem olan `Navigation Graph` kullanılır.

---

# NOT: Kod örneği Örnekler klasörüne eklenecek....