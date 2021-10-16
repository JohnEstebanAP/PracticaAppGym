package com.example.appgym.fragments;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.appgym.PreviewActivity;
import com.example.primerproyecto.R;

public class HomeFragment extends Fragment {

    private MediaPlayer pop;
    private ImageButton btnPower, btnStrong, btnYoga, btnCardio, btnFitness;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Context context = requireContext();
        btnPower = view.findViewById(R.id.btn_power);
        btnStrong = view.findViewById(R.id.btn_strong);
        btnYoga = view.findViewById(R.id.btn_yoga);
        btnCardio = view.findViewById(R.id.btn_cardio);
        btnFitness = view.findViewById(R.id.btn_fitness);

        pop = MediaPlayer.create(context, R.raw.pop);

        btnPower.setOnClickListener(v -> {
            pop.start();
            startActivity(new Intent(context, PreviewActivity.class));
        });

        btnStrong.setOnClickListener(v -> {
            pop.start();
            startActivity(new Intent(context, PreviewActivity.class));
        });

        btnYoga.setOnClickListener(v -> {
            pop.start();
            startActivity(new Intent(context, PreviewActivity.class));
        });

        btnCardio.setOnClickListener(v -> {
            pop.start();
            startActivity(new Intent(context, PreviewActivity.class));
        });

        btnFitness.setOnClickListener(v -> {
            pop.start();
            startActivity(new Intent(context, PreviewActivity.class));
        });
        return view;
    }
}