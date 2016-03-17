package io.kazuyoshi.weatherappjapan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseRegion extends Activity implements View.OnClickListener{

    private Button button_kyushu;
    private Button button_kanto;
    private Button button_hokkaido;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_region);

        button_kyushu=(Button)findViewById(R.id.button_kyushu);
        button_kyushu.setOnClickListener(this);

        button_kanto=(Button)findViewById(R.id.button_kanto);
        button_kanto.setOnClickListener(this);

        button_hokkaido=(Button)findViewById(R.id.button_hokkaido);
        button_hokkaido.setOnClickListener(this);
    }

    public void onClick(View v){

        if(v==button_kyushu){
            Intent intent = new Intent(this, KyushuActivity.class);
            startActivityForResult(intent,0);
        }else if (v==button_kanto){
            Intent intent = new Intent(this, KantoActivity.class);
            startActivityForResult(intent,0);
        }else {
            Intent intent = new Intent(this, HokkaidoActivity.class);
            startActivityForResult(intent, 0);
        }
    }

}