package com.example.ekanomikkalendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public FrameLayout frameLayout;
    public static String[][] ddata1 = null;
    public static String[][] ddata2 = null;
    public static String[][] ddata3 = null;
    public static String[][] ddata4 = null;
    public static String[][] module_ddata1 = null;
    public static String[][] module_ddata2 = null;
    public static String[][] module_ddata3 = null;
    public static String[][] module_ddata4 = null;

    public int identificator_prev = 0;
    public int identificator_current = 0;
    public int identificator_next = 0;
    public int identificator_week = 0;
    public static final int UPDATE_FRAME = 5;
    public static int global_layout = 2;
    public static int window_width,window_height;
    private static boolean brk = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragment_layout);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        window_width = metrics.widthPixels;
        window_height = metrics.heightPixels;

        internet_connection();
        scanning_data();
        update_adapter();
        scanning_update_data();

    }

    private void internet_connection(){
        new Thread(() -> {
            try {
                loading_view();
                Jsoup.connect("https://www.google.com").get();
                try{
                    prev_connection();
                }catch (Exception ignored){

                }try{
                    current_connection();
                }catch (Exception ignored){

                }try{
                    next_connection();
                }catch (Exception ignored){

                }try{
                    week_connection();
                }catch (Exception ignored){

                }

            } catch (IOException e) {
                no_connect_view();

            }
        }).start();
    }
    private void prev_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","prev");
                ddata1 = eCall1.getFilter_data().clone();
                module_ddata1 = ddata1.clone();
            }catch (Exception ignored){

            }
            try{
                identificator_prev = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void current_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","current");
                ddata2 = eCall1.getFilter_data().clone();
                module_ddata2 = ddata2.clone();

            }catch (Exception ignored){

            }
            try{
                identificator_current = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void next_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","next");
                ddata3 = eCall1.getFilter_data().clone();
                module_ddata3 = ddata3.clone();

            }catch (Exception ignored){
                no_connect_view();
            }
            try{
                identificator_next = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void week_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","week");
                ddata4 = eCall1.getFilter_data().clone();
                module_ddata4.clone();
            }catch (Exception ignored){

            }
            try{
                identificator_week = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void loading_view(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),new Loading_fragment());
        fragmentTransaction.commit();
    }
    private void main_view(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),new Main_fragment());
        fragmentTransaction.commit();
    }
    private void no_connect_view(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),new No_connect_fragment());
        fragmentTransaction.commit();
    }
    private void helper_view(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),new helper());
        fragmentTransaction.commit();
    }

    private void scanning_data() {
        Handler handler = new Handler();
        handler.post(() -> new Thread(() -> {
            while (brk){
                if(((identificator_prev == 1) && (identificator_current == 1)) && ((identificator_next == 1) && (identificator_week == 1))){
                    main_view();

                    brk = false;
                }
                try{
                    Thread.sleep(100*UPDATE_FRAME);
                }catch (Exception ignored){
                    finish();
                }
            }
        }).start());
    }

    private void prev_module_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","prev");
                ddata1 = eCall1.getFilter_data().clone();
                identificator_prev = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void current_module_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","current");
                ddata2 = eCall1.getFilter_data().clone();
                identificator_current = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void next_module_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","next");
                ddata3 = eCall1.getFilter_data().clone();
                identificator_next = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void week_module_connection(){
        new Thread(() -> {
            try{
                ECall eCall1 = new ECall("5","week");
                ddata4 = eCall1.getFilter_data().clone();
                identificator_week = 1;
            }catch (Exception ignored){

            }
        }).start();
    }
    private void update_adapter(){
        Handler handler = new Handler();
        handler.postDelayed(() ->{
            new Thread(() -> {
                while (true){
                    if(!brk){
                        prev_module_connection();
                        current_module_connection();
                        next_module_connection();
                        week_module_connection();
                    }else {

                    }
                    try{
                        Thread.sleep(1000*UPDATE_FRAME);
                    }catch (Exception ignored){

                    }
                }
            }).start();
        },1000L*UPDATE_FRAME);
    }
    private void scanning_update_data(){
        Handler handler = new Handler();
        handler.postDelayed(() ->{
            new Thread(() -> {
                while (true){
                    if(!brk){
                        if(((Arrays.deepToString(module_ddata1).hashCode() != Arrays.deepToString(ddata1).hashCode()) || (Arrays.deepToString(module_ddata2).hashCode() != Arrays.deepToString(ddata2).hashCode())) || ((Arrays.deepToString(module_ddata3).hashCode() != Arrays.deepToString(ddata3).hashCode()) || (Arrays.deepToString(module_ddata4).hashCode() != Arrays.deepToString(ddata4).hashCode()))){
                            helper_view();
                            main_view();
                            module_ddata1 = ddata1.clone();
                            module_ddata2 = ddata2.clone();
                            module_ddata3 = ddata3.clone();
                            module_ddata4 = ddata4.clone();
                        }else {

                        }
                    }else {

                    }
                    try{
                        Thread.sleep(1000*UPDATE_FRAME);
                    }catch (Exception ignored){

                    }
                }
            }).start();
        },1000L*UPDATE_FRAME);
    }
}
