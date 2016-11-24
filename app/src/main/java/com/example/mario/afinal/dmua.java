package com.example.mario.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class dmua extends AppCompatActivity {

    Button opc1, opc2, opc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmua);

        opc1 = (Button) findViewById(R.id.uno);

        opc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opc1 = new Intent(dmua.this, opc1.class);
                startActivity(opc1);
            }
        });

        opc2 = (Button) findViewById(R.id.dos);

        opc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opc2 = new Intent(dmua.this, pc2.class);
                startActivity(opc2);
            }
        });
        opc3 = (Button) findViewById(R.id.tres);

        opc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opc3 = new Intent(dmua.this, MainActivity.class);
                startActivity(opc3);
            }
        });

    }


}
