package com.example.disasterapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView radarRecView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radarRecView = findViewById(R.id.radarRecView);

        ArrayList<Alert> alert = new ArrayList<>();

        alert.add(new Alert("Acil Kan İhtiyacı", "Balcalı Hastanesi Acil Servisi'nde ameliyat için acil 0 RH- (Negatif) kan aranmaktadır. İletişim: 05XX XXX XX XX", "Kritik"));
        alert.add(new Alert("Güvenli Toplanma Alanı", "Merkez Park çim alanı çadır kurulumu için güvenli ve kullanıma açıktır. Alanda aydınlatma mevcuttur.", "Bilgi"));
        alert.add(new Alert("Erzak ve Su Dağıtımı", "Seyhan Belediyesi önünde kurulan kriz masasında sıcak çorba, battaniye ve temiz su dağıtımı başlamıştır.", "Yardım"));
        alert.add(new Alert("Kritik Yol Durumu", "Turgut Özal Bulvarı girişinde kısmi çökme tehlikesi bulunmaktadır. Lütfen alternatif rotaları veya çevre yolunu kullanın.", "Uyarı"));

        AlertAdapter adapter = new AlertAdapter(this);
        adapter.setAlerts(alert);

        radarRecView.setAdapter(adapter);
        radarRecView.setLayoutManager(new LinearLayoutManager(this));

        // MainActivity içindeki onCreate metoduna eklenecek:
        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Yeni ihbar girişi Faz 2'de eklenecektir.", Toast.LENGTH_SHORT).show()
        );
    }
}