package io.kazuyoshi.weatherappjapan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button button_enter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_enter=(Button)findViewById(R.id.button_enter);
        button_enter.setOnClickListener(this);
    }

    public void onClick(View v){

        if(v==button_enter){
            Intent intent = new Intent(this, ChooseRegion.class);
            startActivityForResult(intent,0);
        }
    }

}