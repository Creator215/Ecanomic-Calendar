package com.example.ekanomikkalendar;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_fragment extends Fragment {
    View view;
    AppCompatButton kecha_btn,bugun_btn,ertaga_btn,haftalik_btn;
    RelativeLayout kecha_layout,bugun_layout,ertaga_layout,haftalik_layout;
    LinearLayout kecha_linear,bugun_linear,ertaga_linear,haftalik_linear;
    TextView clock_;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_fragment,container,false);

        clock_ = view.findViewById(R.id.soat);
        clock();

        kecha_linear = view.findViewById(R.id.linear_kecha);
        bugun_linear = view.findViewById(R.id.linear_bugun);
        ertaga_linear = view.findViewById(R.id.linear_ertaga);
        haftalik_linear = view.findViewById(R.id.linear_haftalik);

        kecha_btn = view.findViewById(R.id.kecha_btn);
        bugun_btn = view.findViewById(R.id.bugun_btn);
        ertaga_btn = view.findViewById(R.id.ertaga_btn);
        haftalik_btn = view.findViewById(R.id.hafta_btn);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(MainActivity.window_width/4, ViewGroup.LayoutParams.WRAP_CONTENT);
        kecha_btn.setLayoutParams(layoutParams);
        bugun_btn.setLayoutParams(layoutParams);
        ertaga_btn.setLayoutParams(layoutParams);
        haftalik_btn.setLayoutParams(layoutParams);

        kecha_layout = view.findViewById(R.id.kecha_l);
        bugun_layout = view.findViewById(R.id.bugun_l);
        ertaga_layout = view.findViewById(R.id.ertaga_l);
        haftalik_layout = view.findViewById(R.id.haftalik_l);

        if (MainActivity.global_layout == 1){
            kecha_btn.setTextColor(Color.rgb(255,255,255));
            bugun_btn.setTextColor(Color.rgb(147,149,148));
            ertaga_btn.setTextColor(Color.rgb(147,149,148));
            haftalik_btn.setTextColor(Color.rgb(147,149,148));

            kecha_layout.setVisibility(View.VISIBLE);
            bugun_layout.setVisibility(View.INVISIBLE);
            ertaga_layout.setVisibility(View.INVISIBLE);
            haftalik_layout.setVisibility(View.INVISIBLE);
        } else if(MainActivity.global_layout == 2){
            kecha_btn.setTextColor(Color.rgb(147,149,148));
            bugun_btn.setTextColor(Color.rgb(255,255,255));
            ertaga_btn.setTextColor(Color.rgb(147,149,148));
            haftalik_btn.setTextColor(Color.rgb(147,149,148));

            kecha_layout.setVisibility(View.INVISIBLE);
            bugun_layout.setVisibility(View.VISIBLE);
            ertaga_layout.setVisibility(View.INVISIBLE);
            haftalik_layout.setVisibility(View.INVISIBLE);
        } else if (MainActivity.global_layout == 3) {
            kecha_btn.setTextColor(Color.rgb(147,149,148));
            bugun_btn.setTextColor(Color.rgb(147,149,148));
            ertaga_btn.setTextColor(Color.rgb(255,255,255));
            haftalik_btn.setTextColor(Color.rgb(147,149,148));

            kecha_layout.setVisibility(View.INVISIBLE);
            bugun_layout.setVisibility(View.INVISIBLE);
            ertaga_layout.setVisibility(View.VISIBLE);
            haftalik_layout.setVisibility(View.INVISIBLE);
        } else if (MainActivity.global_layout == 4) {
            kecha_btn.setTextColor(Color.rgb(147,149,148));
            bugun_btn.setTextColor(Color.rgb(147,149,148));
            ertaga_btn.setTextColor(Color.rgb(147,149,148));
            haftalik_btn.setTextColor(Color.rgb(255,255,255));

            kecha_layout.setVisibility(View.INVISIBLE);
            bugun_layout.setVisibility(View.INVISIBLE);
            ertaga_layout.setVisibility(View.INVISIBLE);
            haftalik_layout.setVisibility(View.VISIBLE);
        }

        kecha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kecha_btn.setTextColor(Color.rgb(255,255,255));
                bugun_btn.setTextColor(Color.rgb(147,149,148));
                ertaga_btn.setTextColor(Color.rgb(147,149,148));
                haftalik_btn.setTextColor(Color.rgb(147,149,148));

                kecha_layout.setVisibility(View.VISIBLE);
                bugun_layout.setVisibility(View.INVISIBLE);
                ertaga_layout.setVisibility(View.INVISIBLE);
                haftalik_layout.setVisibility(View.INVISIBLE);
                MainActivity.global_layout = 1;
            }
        });
        bugun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kecha_btn.setTextColor(Color.rgb(147,149,148));
                bugun_btn.setTextColor(Color.rgb(255,255,255));
                ertaga_btn.setTextColor(Color.rgb(147,149,148));
                haftalik_btn.setTextColor(Color.rgb(147,149,148));

                kecha_layout.setVisibility(View.INVISIBLE);
                bugun_layout.setVisibility(View.VISIBLE);
                ertaga_layout.setVisibility(View.INVISIBLE);
                haftalik_layout.setVisibility(View.INVISIBLE);
                MainActivity.global_layout = 2;
            }
        });
        ertaga_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kecha_btn.setTextColor(Color.rgb(147,149,148));
                bugun_btn.setTextColor(Color.rgb(147,149,148));
                ertaga_btn.setTextColor(Color.rgb(255,255,255));
                haftalik_btn.setTextColor(Color.rgb(147,149,148));

                kecha_layout.setVisibility(View.INVISIBLE);
                bugun_layout.setVisibility(View.INVISIBLE);
                ertaga_layout.setVisibility(View.VISIBLE);
                haftalik_layout.setVisibility(View.INVISIBLE);
                MainActivity.global_layout = 3;
            }
        });
        haftalik_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kecha_btn.setTextColor(Color.rgb(147,149,148));
                bugun_btn.setTextColor(Color.rgb(147,149,148));
                ertaga_btn.setTextColor(Color.rgb(147,149,148));
                haftalik_btn.setTextColor(Color.rgb(255,255,255));

                kecha_layout.setVisibility(View.INVISIBLE);
                bugun_layout.setVisibility(View.INVISIBLE);
                ertaga_layout.setVisibility(View.INVISIBLE);
                haftalik_layout.setVisibility(View.VISIBLE);
                MainActivity.global_layout = 4;
            }
        });
        set_data_prev();
        set_data_current();
        set_data_next();
        set_data_week();

        return view;
    }
    private void set_data_prev(){
        try{
            for(int i = 0;i < MainActivity.ddata1.length;i ++){
                Object object = new Object(MainActivity.ddata1[i][0],MainActivity.ddata1[i][1],MainActivity.ddata1[i][2],MainActivity.ddata1[i][3],MainActivity.ddata1[i][4],MainActivity.ddata1[i][5],MainActivity.ddata1[i][6],MainActivity.ddata1[i][7]);
                object.set_object(kecha_linear,MainActivity.window_width,MainActivity.window_height);
            }
        }catch (Exception ignored){

        }
    }
    private void set_data_current(){
        try{
            for(int i = 0;i < MainActivity.ddata2.length;i ++){
                Object object = new Object(MainActivity.ddata2[i][0],MainActivity.ddata2[i][1],MainActivity.ddata2[i][2],MainActivity.ddata2[i][3],MainActivity.ddata2[i][4],MainActivity.ddata2[i][5],MainActivity.ddata2[i][6],MainActivity.ddata2[i][7]);
                object.set_object(bugun_linear,MainActivity.window_width,MainActivity.window_height);
            }
        }catch (Exception ignored){

        }
    }
    private void set_data_next(){
        try{
            for(int i = 0;i < MainActivity.ddata3.length;i ++){
                Object object = new Object(MainActivity.ddata3[i][0],MainActivity.ddata3[i][1],MainActivity.ddata3[i][2],MainActivity.ddata3[i][3],MainActivity.ddata3[i][4],MainActivity.ddata3[i][5],MainActivity.ddata3[i][6],MainActivity.ddata3[i][7]);
                object.set_object(ertaga_linear,MainActivity.window_width,MainActivity.window_height);
            }
        }catch (Exception ignored){

        }
    }
    private void set_data_week(){
        try{
            for(int i = 0;i < MainActivity.ddata4.length;i ++){
                Object object = new Object(MainActivity.ddata4[i][0],MainActivity.ddata4[i][1],MainActivity.ddata4[i][2],MainActivity.ddata4[i][3],MainActivity.ddata4[i][4],MainActivity.ddata4[i][5],MainActivity.ddata4[i][6],MainActivity.ddata4[i][7]);
                object.set_object(haftalik_linear,MainActivity.window_width,MainActivity.window_height);
            }
        }catch (Exception ignored){

        }
    }
    private void clock(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            try{
                clock_.setText(String.valueOf(formatter.format(date)));
                clock2();
            }catch (Exception ignored){

            }
        },300);
    }
    private void clock2(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            try{
                clock_.setText(String.valueOf(formatter.format(date)));
                clock();
            }catch (Exception ignored){

            }
        },300);
    }
}