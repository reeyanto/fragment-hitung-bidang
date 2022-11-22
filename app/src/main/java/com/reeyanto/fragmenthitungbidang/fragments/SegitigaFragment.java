package com.reeyanto.fragmenthitungbidang.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reeyanto.fragmenthitungbidang.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SegitigaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SegitigaFragment extends Fragment {

    private static final String STATE_DATA = "";
    private EditText etAlas, etTinggi;
    private Button btnHitungSegitiga;
    private TextView tvHasilSegitiga;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SegitigaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SegitigaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SegitigaFragment newInstance(String param1, String param2) {
        SegitigaFragment fragment = new SegitigaFragment();
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_DATA, tvHasilSegitiga.getText().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segitiga, container, false);
        etAlas = view.findViewById(R.id.et_alas);
        etTinggi = view.findViewById(R.id.et_tinggi);
        tvHasilSegitiga = view.findViewById(R.id.tv_hasil_segitiga);
        btnHitungSegitiga = view.findViewById(R.id.btn_hitung_segitiga);

        btnHitungSegitiga.setOnClickListener(v -> hitungSegitiga());

        // apakah ada data di Bundle?
        if (savedInstanceState != null) {
            tvHasilSegitiga.setText(savedInstanceState.getString(STATE_DATA));
        }
        return view;
    }

    private void hitungSegitiga() {
        if (etAlas.getText().toString().isEmpty()) {
            etAlas.setError("Field tidak boleh kosong!");
            etAlas.requestFocus();
            return;
        }

        if (etTinggi.getText().toString().isEmpty()) {
            etTinggi.setError("Field tidak boleh kosong!");
            etTinggi.requestFocus();
            return;
        }

        int alas = Integer.parseInt(etAlas.getText().toString());
        int tinggi = Integer.parseInt(etTinggi.getText().toString());
        int hasil  = (alas * tinggi) / 2;

        tvHasilSegitiga.setText(String.valueOf(hasil));
    }
}