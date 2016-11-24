package com.example.mario.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mu;
    String A, T, Vo, V, D, r, re;
    Double AA, TT, VO, VV, DD, rr, rrr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mu = (Button) findViewById(R.id.regresar);

        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mu = new Intent(MainActivity.this, inicio.class);
                startActivity(mu);
            }
        });
    }

    public void calcular (View view){

        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv = (TextView) findViewById(R.id.grados);
        final TextView dd= (TextView) findViewById(R.id.di);


        A = aa.getText().toString();
        T = tt.getText().toString();
        Vo= voo.getText().toString();
        V = vv.getText().toString();
        D= dd.getText().toString();

        if (A.equals("")){
            aa.setText("0");
            A = aa.getText().toString();
        }
        if(T.equals("")) {
            tt.setText("0");
            T = tt.getText().toString();
        }
        if(Vo.equals("")) {
            voo.setText("0");
            Vo= voo.getText().toString();
        }
        if(V.equals("")) {
            vv.setText("0");
            V = vv.getText().toString();
        }
        if(D.equals("")) {
            dd.setText("0");
            D= dd.getText().toString();
        }

        AA = Double.valueOf(A);
        TT = Double.valueOf(T);
        VO = Double.valueOf(Vo);
        VV = Double.valueOf(V);
        DD = Double.valueOf(D);

        //formula para obtener aceleracion y movimiento
        if (VV!=0 && TT !=0 && VO !=0) {
            rr = (VV - VO) / TT;
            re = String.valueOf(rr);
            rrr= ((VV-VO)/2)*TT;
            r = String.valueOf(rrr);
            dd.setText(r);
            aa.setText(re);
            voo.setEnabled(false);
            vv.setEnabled(false);
            tt.setEnabled(false);

        }
        // formula para saber velocidad final y tiempo
        if (VO!=0 && AA !=0 && DD!=0){
            rr =Math.sqrt((VO*VO)+(2*AA*DD));
            re =String.valueOf(rr);
            rrr = (rr-VO)/AA;
            r = String.valueOf(rrr);

            tt.setText(r);
            vv.setText(re);
            voo.setEnabled(false);
            aa.setEnabled(false);
            dd.setEnabled(false);

        }
        //fornula para saber desplazamiento SIN aceleracion
        if (VO!=0 && TT!=0 && VV !=0){
            //FALTA UNA PARTE DE CODIGOOOOOoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
            rr =(((VO+VV)/2)*TT);
            re = String.valueOf(rr);

            dd.setText(re);
            aa.setText("0");

            voo.setEnabled(false);
            tt.setEnabled(false);
            vv.setEnabled(false);
        }
        // formula para saber desplazamiento CON aceleracion
        if (VO != 0 && AA != 0 && TT != 0) {
            rr = ((VO*TT)+(0.5*AA*(TT*TT)));
            re = String.valueOf(rr);
            rrr =Math.sqrt((VO*VO)+(2*AA*rr));
            r = String.valueOf(rrr);

            dd.setText(re);
            vv.setText(r);

            voo.setEnabled(false);
            aa.setEnabled(false);
            tt.setEnabled(false);
        }

    }
    public void reset (View view){
        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv = (TextView) findViewById(R.id.grados);
        final TextView dd= (TextView) findViewById(R.id.di);

        aa.setText("");
        tt.setText("");
        voo.setText("");
        vv.setText("");
        dd.setText("");

        aa.setEnabled(true);
        dd.setEnabled(true);
        voo.setEnabled(true);
        vv.setEnabled(true);
        tt.setEnabled(true);


    }

}
