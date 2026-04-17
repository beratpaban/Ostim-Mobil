#Uygulama 2

activity_main.xml:
```xml
 
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/main"
    android:padding="20dp">

    <EditText
        android:id="@+id/editUrunAd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Ürün Adı Giriniz" />

    <EditText
        android:id="@+id/editStokAdet"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Stok Adedi"
        android:inputType="number" />

    <Button
        android:id="@+id/btnKaydet"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="KAYDET" />

    <Button
        android:id="@+id/btnListeyeGit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="STOKLARI GÖR"
        android:backgroundTint="#FF9800" />

</LinearLayout>

```

ListeActivity.xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ListeActivity">

    <ListView
        android:id="@+id/list"
        android:layout_width="409dp"
        android:layout_height="729dp"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
```