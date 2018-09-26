package com.example.george.myapplicationcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Integer sign;
    Double num1 = null;
    Double num2 = null;
    Double ansure = null;


    String value;
    String editValue;
    String newValue;

    Button btn0 ;
    Button btn1 ;
    Button btn2 ;
    Button btn3 ;
    Button btn4;
    Button btn5;
    Button btn6 ;
    Button btn7 ;
    Button btn8 ;
    Button btn9 ;
    Button btnPoint;
    Button btnPlus;
    Button btnDivide;
    Button btnMinus;
    Button btnTimes;
    Button btnDisplay;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GivingValuesToDefinedCharacters();

    }

    // THE METHOD THAT WILL BE ABLE TO DEFINE ALL OF THE BUTTONS INVOLVED.
    public void GivingValuesToDefinedCharacters(){
        btn0 =  findViewById(R.id.btn0);
     btn1 =     findViewById(R.id.btn1);
     btn2 =     findViewById(R.id.btn2);
     btn3 =     findViewById(R.id.btn3);
     btn4 =     findViewById(R.id.btn4);
     btn5 =     findViewById(R.id.btn5);
     btn6 =     findViewById(R.id.btn6);
     btn7 =     findViewById(R.id.btn7);
     btn8 =     findViewById(R.id.btn8);
     btn9 =     findViewById(R.id.btn9);
     btnPoint = findViewById(R.id.btnPoint);

    // DEFINING THE OPERATION BUTTONS
     btnPlus =    findViewById(R.id.btnPlus);
     btnDivide =  findViewById(R.id.btnDivide);
     btnMinus =   findViewById(R.id.btnMinus);
     btnTimes =   findViewById(R.id.btnTimes);

    //DEFINING THE EDITTEXT VIEW.
     edit = (EditText) findViewById(R.id.edit);

    //DEFINING THE DISPLAY BUTTON.
        btnDisplay = findViewById(R.id.display);
    }

    // THE METHOD THAT WILL HANDLE THE NUMERICAL BUTTONS THAT WILL BE CLICKED.

    public void getValue(Button btn){
      editValue = btnDisplay.getText().toString();
      value = btn.getText().toString();
      newValue = editValue+value;
      edit.setText(newValue);
      btnDisplay.setText(newValue);
  }

  // THE METHOD THAT WILL BE ABLE TO HANDLE THE SIGNS CLICKED.

    public void HandleSignsClicked(Button btn){
       if(num1 == null) {
           num1 = Double.parseDouble(edit.getText().toString());
           editValue = btnDisplay.getText().toString();
           value = btn.getText().toString();
           newValue = editValue + value;
           edit.setText(newValue);
           btnDisplay.setText(newValue);
       }
     else {
           //num1 += ;


           editValue = btnDisplay.getText().toString();
           int value21 = editValue.lastIndexOf('+');
           int value22 = editValue.lastIndexOf('-');
           int value23 = editValue.lastIndexOf('*');
           int value24 = editValue.lastIndexOf('/');
           if(value21 != -1){
               // USING +
               Double subset = Double.parseDouble(editValue.substring(value21+1));
               Double summing = num1 + subset;
               edit.setText(""+ summing);
               num1 = summing;
               num2 = null;
           }
           else if(value22 != -1){
// USING -
               Double subset = Double.parseDouble(editValue.substring(value22+1));
               Double summing = num1 - subset;
               edit.setText(""+ summing);
               num1 = summing;
               num2 = null;
           }
          else if(value23 != -1){
// USING *
               Double subset = Double.parseDouble(editValue.substring(value23+1));
               Double summing = num1 * subset;
               edit.setText(""+ summing);
               num1 = summing;
               num2 = null;
           }
           else if(value24 != -1){
// USING /
               Double subset = Double.parseDouble(editValue.substring(value24+1));
               Double summing = num1 / subset;
               edit.setText(""+ summing);
               num1 = summing;
               num2 = null;
           }
           value = btn.getText().toString();
           newValue = editValue + value;
           btnDisplay.setText(newValue);
           edit.setText(""+num1);
       }
    }
    public void getNum2(String operation){
    String data = btnDisplay.getText().toString();
    int index = data.lastIndexOf(operation)+1;
    String subString  = data.substring(index);
    num2 = Double.parseDouble(subString);
}
    public void Click0(View view){
       getValue(btn0);
    }
    public void Click1(View view){
        getValue(btn1);
    }
    public void Click2(View view){
        getValue(btn2);
    }
    public void Click3(View view){
        getValue(btn3);
    }
    public void Click4(View view){
        getValue(btn4);
    }
    public void Click5(View view){
        getValue(btn5);
    }
    public void Click6(View view){
        getValue(btn6);
    }
    public void Click7(View view){
        getValue(btn7);
    }
    public void Click8(View view){
        getValue(btn8);
    }
    public void Click9(View view){
        getValue(btn9);
    }
    public void ClickPoint(View view){
        getValue(btnPoint);
    }
    public  void  ClickPlus(View view){
        try{
        HandleSignsClicked(btnPlus);
        sign = 1;
        }
        catch (Exception ex){
            btnDisplay.setText("ERROR OCCURED.");

        }
    }

    public  void  ClickMinus(View view){
        try{
        HandleSignsClicked(btnMinus);
        sign = 2;
        }
        catch (Exception ex){
            btnDisplay.setText("ERROR OCCURED.");

        }
    }

    public  void  ClickTimes(View view){
        try{
        HandleSignsClicked(btnTimes);
        sign = 3;
        }
        catch (Exception ex){
            btnDisplay.setText("ERROR OCCURED.");

        }
    }

    public  void  ClickDivision(View view){
        try{
        HandleSignsClicked(btnDivide);
        sign = 4;
        }
        catch (Exception ex){
            btnDisplay.setText("ERROR OCCURED.");

        }
    }
public void HandleClear(View view){
        edit.setText("");
        num1 = null;
        num2 = null;
        btnDisplay.setText("");
   // setContentView(R.layout.next);
}
    public  void HandleEquals(View view){

        switch (sign){
            case 1:
                try{
                    getNum2("+");
                    ansure = num1 + num2;
                    btnDisplay.setText(String.format("%.2f",ansure));
                    edit.setText("");
                    num1 = ansure;

                }
                catch (Exception ex){
                    btnDisplay.setText("ERROR OCCURED.");

                }
              break;

            case 2:
                try{
                    getNum2("-");
                ansure = num1-num2;
                    btnDisplay.setText(String.format("%.2f",ansure));
                edit.setText("");
                    num1 = ansure;

                }
                catch (Exception ex){
                    btnDisplay.setText("ERROR OCCURED.");

                }
                break;
            case 3:
                try{
                    getNum2("*");
                ansure = num1*num2;
                    btnDisplay.setText(String.format("%.2f",ansure));
                edit.setText("");
                    num1 = ansure;

                }
                catch (Exception ex){
                    btnDisplay.setText("ERROR OCCURED.");
                }
                break;
            case 4:
                try{
                    getNum2("/");
                ansure = (num1/num2);
                btnDisplay.setText(String.format("%.2f",ansure));
                edit.setText("");
                    num1 = ansure;

                }
                catch (Exception ex){
                    btnDisplay.setText("ERROR OCCURED.");

                }
                break;

        }

    }

    public void HandleNewScreen(View view){
        setContentView(R.layout.activity_main);
    }
    public void handleExit(View view){
        System.exit(1);

    }

}
