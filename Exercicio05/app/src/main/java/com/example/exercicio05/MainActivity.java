package com.example.exercicio05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int contVitX = 0;
    int contVitO = 0;
    TextView vitX;
    TextView vitO;
    TextView jog;
    int vez=0;
    int velha = 0;
    ToggleButton m11;
    ToggleButton m12;
    ToggleButton m13;
    ToggleButton m21;
    ToggleButton m22;
    ToggleButton m23;
    ToggleButton m31;
    ToggleButton m32;
    ToggleButton m33;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vitX = (TextView) findViewById(R.id.vit_x);
        vitO = (TextView) findViewById(R.id.vit_o);
        jog = (TextView) findViewById(R.id.jogador);
        m11 = (ToggleButton) findViewById(R.id.m_11);
        m12 = (ToggleButton) findViewById(R.id.m_12);
        m13 = (ToggleButton) findViewById(R.id.m_13);
        m21 = (ToggleButton) findViewById(R.id.m_21);
        m22 = (ToggleButton) findViewById(R.id.m_22);
        m23 = (ToggleButton) findViewById(R.id.m_23);
        m31 = (ToggleButton) findViewById(R.id.m_31);
        m32 = (ToggleButton) findViewById(R.id.m_32);
        m33 = (ToggleButton) findViewById(R.id.m_33);

        resetaBotoes();


        m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m11);
            }
        });

        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m12);
            }
        });

        m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m13);
            }
        });

        m21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m21);
            }
        });

        m22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m22);
            }
        });

        m23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m23);
            }
        });

        m31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m31);
            }
        });

        m32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m32);
            }
        });

        m33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificaBotao(m33);
            }
        });
    }

    private void modificaBotao(ToggleButton botao){
        botao.setText(trocaVez());
        botao.setClickable(false);
        condVitoria();
    }



    private void resetaBotoes(){
        m11.setText(" ");
        m12.setText("  ");
        m13.setText("   ");
        m21.setText("    ");
        m22.setText("     ");
        m23.setText("    ");
        m31.setText("   ");
        m32.setText("  ");
        m33.setText(" ");
        
        m11.setClickable(true);
        m12.setClickable(true);
        m13.setClickable(true);
        m21.setClickable(true);
        m22.setClickable(true);
        m23.setClickable(true);
        m31.setClickable(true);
        m32.setClickable(true);
        m33.setClickable(true);
    }

    private String trocaVez(){

        velha++;
        if(vez==0){
            vez=1;
            jog.setText("O");
            return "X";
        } else {
            vez=0;
            jog.setText("X");
            return "O";
        }
    }

    private void condVitoria(){
        if(verificaVitoria()){
            int aux;

            velha=0;
            resetaBotoes();
            //vit X
            if(vez==1){
                contVitX ++;
                vitX.setText(String.valueOf(contVitX));
            } else {
                contVitO++;
                vitO.setText(String.valueOf(contVitO));
            }
        } else if( velha==9){
            velha=0;
            resetaBotoes();
        }
    }

    private boolean verificaVitoria(){
        if(m11.getText().equals(m12.getText()) && m12.getText().equals(m13.getText() )) {
            return true;
        } else if(m21.getText().equals(m22.getText()) && m22.getText().equals(m23.getText() )) {
            return true;
        } else if(m31.getText().equals(m32.getText()) && m32.getText().equals(m33.getText() )) {
            return true;
        } else if(m11.getText().equals(m21.getText()) && m21.getText().equals(m31.getText() )) {
            return true;
        } else if(m12.getText().equals(m22.getText()) && m22.getText().equals(m32.getText() )) {
            return true;
        } else if(m13.getText().equals(m23.getText()) && m23.getText().equals(m33.getText() )) {
            return true;
        } else if(m11.getText().equals(m22.getText()) && m22.getText().equals(m33.getText() )) {
            return true;
        } else if(m13.getText().equals(m22.getText()) && m22.getText().equals(m31.getText() )) {
            return true;
        } else {
            return false;
        }
    }
}
