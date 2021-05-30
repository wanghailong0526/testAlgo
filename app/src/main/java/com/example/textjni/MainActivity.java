package com.example.textjni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.textjni.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;
    private String name = "whl";
    protected static int age = 31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI() + age);
        callAddMethod();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeName();
                changeAge();
                tv.setText(name + age);
            }
        }, 3000);
    }

    private int add(int n1, int n2) {
        return n1 + n2;
    }
    private native void callAddMethod();

    public native void changeName();//native 修改java的name

    protected static native void changeAge();

    public native String stringFromJNI();
}