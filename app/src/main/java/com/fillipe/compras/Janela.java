package com.fillipe.compras;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Janela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela);
    }
    private float limite=35;
    private float valor=0;
    private float total=0;
    private float pao=10;
    private float truta=20;
    private float picanha=30;
    public void validar(View view)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        EditText etexto= (EditText) findViewById(R.id.editText);
        try
        {

            this.limite=Float.parseFloat(String.valueOf(etexto.getText()));

        }catch (Exception NumberFormatException )
        {
            alerta.setMessage("use um valor inteiro");
            alerta.show();
        }

    }
    public void calcular(View view)
    {

        CheckBox caixaPao= (CheckBox) findViewById(R.id.checkBox);
        CheckBox caixaTruta= (CheckBox) findViewById(R.id.checkBox2);
        CheckBox caixaPicanha= (CheckBox) findViewById(R.id.checkBox3);
        ProgressBar barra= (ProgressBar) findViewById(R.id.progressBar);
        TextView texto=(TextView) findViewById(R.id.textView2);
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        EditText etexto= (EditText) findViewById(R.id.editText);

        try
        {

            this.limite=Float.parseFloat(String.valueOf(etexto.getText()));

        }catch (Exception NumberFormatException )
        {
            alerta.setMessage("use um valor inteiro");
            alerta.show();
        }
        if(caixaPao.isChecked())
        {
            valor=valor+this.pao;
        }
        if(caixaTruta.isChecked())
        {
            valor=valor+this.truta;
        }
        if(caixaPicanha.isChecked())
        {
            valor=valor+this.picanha;
        }
        if(valor>this.limite)
        {
            alerta.setMessage("Limite estourado");
            alerta.show();
        }
        this.total=valor/this.limite*100;
        barra.setProgress((int) this.total);
        Log.d("total", String.valueOf(total));

        texto.setText((float) valor + " / "+ (float) this.limite);
        this.total=0;
        valor=0;
    }

    public void irpagina2(View view)
    {
        Intent muda1=new Intent(this, janela2.class);
        startActivity(muda1);
        finish();
    }
}
