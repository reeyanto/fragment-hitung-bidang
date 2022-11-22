package com.reeyanto.fragmenthitungbidang.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reeyanto.fragmenthitungbidang.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LingkaranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LingkaranFragment extends Fragment {

    private EditText etJariJari;
    private Button btnHitungLingkaran;
    private TextView tvHasilLingkaran;
    private final String STATE_DATA = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LingkaranFragment() {
        // Required empty public constructor
    }

    public static LingkaranFragment newInstance(String param1, String param2) {
        LingkaranFragment fragment = new LingkaranFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void hitungLuasLingkaran() {
        if (etJariJari.getText().toString().trim().isEmpty()) {
            etJariJari.setError("Field tidak boleh kosong!");
        }
        else {
            Double jariJari = Double.parseDouble(etJariJari.getText().toString());
            Double luas     = Math.PI * jariJari * jariJari;
            tvHasilLingkaran.setText(new DecimalFormat("#.##").format(luas));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_lingkaran, container, false);

        etJariJari = view.findViewById(R.id.et_jari_jari);
        btnHitungLingkaran = view.findViewById(R.id.btn_hitung_lingkaran);
        tvHasilLingkaran = view.findViewById(R.id.tv_hasil_lingkaran);

        btnHitungLingkaran.setOnClickListener(v -> hitungLuasLingkaran());

        // apakah ada data di Bundle?
        if (savedInstanceState != null) {
            tvHasilLingkaran.setText(savedInstanceState.getString(STATE_DATA));
        }

        return view;
    }
}