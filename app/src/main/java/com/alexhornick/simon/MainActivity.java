package com.alexhornick.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.alexhornick.simon.R.id.spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    int itemSelected=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play_button).setOnClickListener(this);
        findViewById(R.id.about_button).setOnClickListener(this);

        Spinner sp = (Spinner) findViewById(spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.version, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.drop_down_spinner_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
    }


    @Override
    public void onClick(View v) {
        //start activity based on button clicked
        if(v.getId()==R.id.play_button){
            Intent intent=new Intent(this,PlayActivity.class);
            intent.putExtra("version",itemSelected);
            startActivity(intent);
        }
        else if(v.getId()==R.id.about_button){
            Intent intent=new Intent(this,AboutActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemSelected=position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
