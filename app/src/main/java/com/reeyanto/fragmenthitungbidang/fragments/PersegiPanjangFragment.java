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
 * Use the {@link PersegiPanjangFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersegiPanjangFragment extends Fragment {

    private static final String STATE_DATA = "";

    private EditText etPanjang, etLebar;
    private Button btnHitungPersegiPanjang;
    private TextView tvHasilPersegiPanjang;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersegiPanjangFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersegiPanjangFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersegiPanjangFragment newInstance(String param1, String param2) {
        PersegiPanjangFragment fragment = new PersegiPanjangFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_persegi_panjang, container, false);
        etPanjang = view.findViewById(R.id.et_panjang);
        etLebar   = view.findViewById(R.id.et_lebar);
        btnHitungPersegiPanjang = view.findViewById(R.id.btn_hitung_persegi_panjang);
        tvHasilPersegiPanjang = view.findViewById(R.id.tv_hasil_persegi_panjang);

        btnHitungPersegiPanjang.setOnClickListener(v -> hitungLuasPersegiPanjang());

        // apakah ada data di Bundle?
        if (savedInstanceState != null) {
            tvHasilPersegiPanjang.setText(savedInstanceState.getString(STATE_DATA));
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_DATA, tvHasilPersegiPanjang.getText().toString());
    }

    private void hitungLuasPersegiPanjang() {
        if (etPanjang.getText().toString().trim().isEmpty()) {
            etPanjang.setError("Field tidak boleh kosong!");
            etPanjang.requestFocus();
            return;
        }

        if (etLebar.getText().toString().isEmpty()) {
            etLebar.setError("Field tidak boleh kosong!");
            etLebar.requestFocus();
            return;
        }

        int panjang = Integer.parseInt(etPanjang.getText().toString());
        int lebar   = Integer.parseInt(etLebar.getText().toString());

        tvHasilPersegiPanjang.setText(String.valueOf(panjang * lebar));
    }
}