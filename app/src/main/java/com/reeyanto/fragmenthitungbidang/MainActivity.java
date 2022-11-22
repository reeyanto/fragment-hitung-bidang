package com.reeyanto.fragmenthitungbidang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.reeyanto.fragmenthitungbidang.fragments.LingkaranFragment;
import com.reeyanto.fragmenthitungbidang.fragments.PersegiPanjangFragment;
import com.reeyanto.fragmenthitungbidang.fragments.SegitigaFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lingkaran        = findViewById(R.id.btn_circle);
        Button persegiPanjang   = findViewById(R.id.btn_square);
        Button segitiga         = findViewById(R.id.btn_triangle);

        lingkaran.setOnClickListener(this::buttonClicked);
        persegiPanjang.setOnClickListener(this::buttonClicked);
        segitiga.setOnClickListener(this::buttonClicked);

        openSelectedFragment(new LingkaranFragment());
    }

    private void buttonClicked(View view) {
        if (view.getId() == R.id.btn_circle) openSelectedFragment(new LingkaranFragment());
        else if (view.getId() == R.id.btn_square) openSelectedFragment(new PersegiPanjangFragment());
        else openSelectedFragment(new SegitigaFragment());
    }

    public void openSelectedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setReorderingAllowed(true)
                .commit();

    }
}