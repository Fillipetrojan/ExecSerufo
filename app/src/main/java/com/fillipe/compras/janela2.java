package com.fillipe.compras;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class janela2 extends AppCompatActivity {
    private EditText sal;
    private EditText emp;
    private EditText parcelas;
    private EditText juros;
    private EditText psal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela2);




    }

    public void emprestar(View view)
    {
        sal=findViewById(R.id.Isal);
        emp=findViewById(R.id.Iemp);
        parcelas=findViewById(R.id.Ipar);
        juros=findViewById(R.id.Ijuros);
        psal=findViewById(R.id.Ipsal);
        int numpar;
        float rsal;
        float remp;
        float calcular;
        float rjul;
        float rpsal;
        AlertDialog.Builder alerta= new AlertDialog.Builder(this);
        rsal= Float.parseFloat(String.valueOf(sal.getText()));
        remp=Float.parseFloat(String.valueOf(emp.getText()));
        numpar = Integer.parseInt(String.valueOf(parcelas.getText()));
        rjul=Float.parseFloat(String.valueOf(juros.getText()));
        rpsal=Float.parseFloat(String.valueOf(psal.getText()));
        rjul=1+(rjul/100);

        rpsal=(rpsal/100);
        rpsal*=rsal;


        String texto="Parcelas do emprestimo\n\n";


        if(rjul>rpsal || (rpsal<(remp*rjul-(remp))))
        {
            alerta.setMessage("\nCuidado, Juros crescem mais rapido\n" +
                    " do que você consegue pagar");
            alerta.show();
        }else
            {
                if(numpar>12)
                {
                    alerta.setMessage("numero maximo de parcelas ultrapassado");
                    alerta.show();
                }else
                {
                    if((rsal*1.5)>=remp)
                    {
                        for (int i=0;i<numpar;i++)
                        {
                            calcular= (float) ((float)remp- rpsal);
                            if((rpsal)>remp)
                            {
                                //alerta.setMessage("\n parcela "+ (i+1)+" "+ remp);
                                remp=0;


                                i=numpar;

                            }else
                            {
                                remp=calcular;
                                remp*=rjul;
                                //alerta.setMessage("\n parcela "+ (i+1)+" "+ remp);
                                texto+="\n\n Parcela "+(i+1)+": "+remp ;



                            }


                        }

                        if(remp!=0)
                        {
                            texto+="\n\nVocê ainda não pagou todo o emprestimo, faltam R$ "+remp;

                            for (int i =numpar;i<100;i++)
                            {

                                calcular= (float) ((float)remp- rpsal);
                                if((rpsal)>remp)
                                {
                                    //alerta.setMessage("\n parcela "+ (i+1)+" "+ remp);
                                    remp=0;


                                    i++;
                                    texto+="\n\nSeriam necessarios "+i+" parcelas para pagar o emprestimo.";
                                    i=100;

                                }else
                                {
                                    remp=calcular;
                                    remp*=rjul;
                                    //alerta.setMessage("\n parcela "+ (i+1)+" "+ remp);



                                }


                            }



                        }else
                        {
                            texto+="\n\nVocê pagou o emprestimo completamente";
                        }

                        alerta.setMessage(texto);
                        alerta.show();



                    }else
                    {
                        alerta.setMessage("Emprestimo não aceito");
                        alerta.show();
                    }




                }


            }












    }


    public void irpagina1(View view)
    {
        Intent muda2= new Intent(this,Janela.class);
        startActivity(muda2);
        finish();
    }




}
