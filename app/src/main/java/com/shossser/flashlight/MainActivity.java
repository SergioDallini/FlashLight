package com.shossser.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bFlash;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickFlash(View view){
        if(flashClass.isFlash_status()){
            flashClass.flashOff();
            bFlash.setText("ON");
            bFlash.setBackgroundResource(R.drawable.circle_green);
        } else {
            flashClass.flashOn();
            bFlash.setText("OFF");
            bFlash.setBackgroundResource(R.drawable.circle_red);
        }
    }

    private void init(){
        bFlash = findViewById(R.id.b1);
        flashClass = new FlashClass(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_status()){
            flashClass.flashOff();
        }

    }
}