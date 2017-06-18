package com.example.problem2_airline_reservation_system;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    private Button btnFirstClass, btnEconomy, btnReset, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    private final int SIZE = 5;
    private Button[] btnArray;
    private ArrayList<Button> btnFirst, btnFirstRed, btnEconom, btnEconomRed;
    private TextView txtMessage;
    private ColorDrawable free, selected;
    private Random rnd;
    private String errFirst, errEconom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons(); //Set all buttons
        txtMessage = (TextView) findViewById(R.id.txtMessage); //Text view with messages

        setArrays(); //Create all arrays

        rnd = new Random(); //Random object

        errFirst = "ERROR: first class is full!";
        errEconom = "ERROR: economy class is full!";

        free = (ColorDrawable) btn1.getBackground();;
        selected = new ColorDrawable();
        selected.setColor(Color.RED);

        //First class event handler
        btnFirstClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnFirst.size() < 1){

                    txtMessage.setText(errFirst);
                }
                else{

                    int fRnd = rnd.nextInt(btnFirst.size());
                    btnFirst.get(fRnd).setBackground(selected);
                    btnFirstRed.add(btnFirst.get(fRnd));
                    btnFirst.remove(fRnd);
                    //Toast.makeText(MainActivity.this, String.format("%d", btnFirstRed.size()), Toast.LENGTH_LONG).show();
                }
            }
        });

        //Economy class event handler
        btnEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnEconom.size() < 1){

                    txtMessage.setText(errEconom);
                }
                else{

                    int fRnd = rnd.nextInt(btnEconom.size());
                    btnEconom.get(fRnd).setBackground(selected);
                    btnEconomRed.add(btnEconom.get(fRnd));
                    btnEconom.remove(fRnd);
                    //Toast.makeText(MainActivity.this, String.format("%d", btnEconomRed.size()), Toast.LENGTH_LONG).show();
                }
            }
        });

        //Reset event handler
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnFirstRed.clear();
                btnEconomRed.clear();

                for(Button btn:btnArray){
                    //Reset button background color
                    btn.setBackground(free);
                }

                txtMessage.setText("");
                setBtnFirst();
                setBtnEconom();

                Toast.makeText(MainActivity.this, "Please select class and reserve your seat.", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Set ArrayList
    private void setBtnEconom() {

        btnEconom.add(btn6);
        btnEconom.add(btn7);
        btnEconom.add(btn8);
        btnEconom.add(btn9);
        btnEconom.add(btn10);
    }

    //Set ArrayList
    private void setBtnFirst(){

        btnFirst.add(btn1);
        btnFirst.add(btn2);
        btnFirst.add(btn3);
        btnFirst.add(btn4);
        btnFirst.add(btn5);
    }

    //Set all button objects
    private void setButtons(){

        btnFirstClass = (Button) findViewById(R.id.btnFirstClass);
        btnEconomy = (Button) findViewById(R.id.btnEconomy);
        btnReset = (Button) findViewById(R.id.btnReset);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
    }

    private void setArrays(){

        btnArray = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10};

        btnFirst = new ArrayList<Button>();
        setBtnFirst();
        btnFirstRed = new ArrayList<Button>();

        btnEconom = new ArrayList<Button>();
        setBtnEconom();
        btnEconomRed = new ArrayList<Button>();
    }

    //End of class
}
