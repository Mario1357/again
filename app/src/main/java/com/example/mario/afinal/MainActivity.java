package com.example.mario.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ln2 = (ImageView)findViewById(R.id.linea2);
        final TextView avo= (TextView) findViewById(R.id.avanzo);
        ln2.animate().translationX(-175f).setDuration(1);
        avo.animate().translationX(-275f).setDuration(1);
    }

    String A,T,Vo,V,D,r,re;

    Double AA,TT,VO,VV,DD,rr,rrr;




    public void calcular (View view){
        ImageView aAvion = (ImageView)findViewById(R.id.imageView);
        ImageView ln1 = (ImageView)findViewById(R.id.linea1);
        ImageView ln2 = (ImageView)findViewById(R.id.linea2);
        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv= (TextView) findViewById(R.id.v);
        final TextView dd= (TextView) findViewById(R.id.di);
        final TextView avo= (TextView) findViewById(R.id.avanzo);

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
            avo.setText("D= " + D);
            voo.setEnabled(false);
            aa.setEnabled(false);
            dd.setEnabled(false);
            aAvion.animate().translationX(Float.valueOf(re)).setDuration(300);
            ln1.animate().translationX(1f).setDuration(1);
            ln2.animate().translationX((Float.valueOf(re))-175f).setDuration(300);
            avo.animate().translationX((Float.valueOf(re)/2)-300f).setDuration(300);

        }
        //fornula para saber desplazamiento SIN aceleracion
        if (VO!=0 && TT!=0 && VV !=0){
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
        final TextView avo= (TextView) findViewById(R.id.avanzo);
        ImageView ln1 = (ImageView)findViewById(R.id.linea1);
        ImageView ln2 = (ImageView)findViewById(R.id.linea2);
        ImageView aAvion = (ImageView)findViewById(R.id.imageView);
        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv= (TextView) findViewById(R.id.v);
        final TextView dd= (TextView) findViewById(R.id.di);

        aa.setText("");
        tt.setText("");
        voo.setText("");
        vv.setText("");
        dd.setText("");
        avo.setText("");
        aa.setEnabled(true);
        dd.setEnabled(true);
        voo.setEnabled(true);
        vv.setEnabled(true);
        tt.setEnabled(true);

        aAvion.animate().translationX(1f).setDuration(1);
        ln1.animate().translationX(1f).setDuration(1);
        ln2.animate().translationX(-175f).setDuration(300);
        avo.animate().translationX(-275f).setDuration(300);

    }



}
