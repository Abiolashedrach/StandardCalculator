package com.example.standardcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import com.faendir.rhino_android.RhinoAndroidHelper;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
   Button num1, num2,num3,num4,num5,num6,num7,num8,num9,num0, div, Openbrac,percent, dot, clear, mul,backspace, minus, add, equals;
    TextView equation, result;
   // private String inputText, outputText;
    private String process;
    boolean checkBrackets = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getResult();

    }

    private void getResult() {
        num0 = findViewById(R.id.zero);
        num1 = findViewById(R.id.one);
        num2 = findViewById(R.id.two);
        num3 = findViewById(R.id.three);
        num4 = findViewById(R.id.button33);
        num5 = findViewById(R.id.five);
        num6 = findViewById(R.id.six);
        num7 = findViewById(R.id.seven);
        num8 = findViewById(R.id.eight);
        num9 = findViewById(R.id.nine);
        div = findViewById(R.id.divide);
        Openbrac = findViewById(R.id.openBracket);
        percent = findViewById(R.id.closeBracket);
        dot = findViewById(R.id.dot);
        clear = findViewById(R.id.clear);
        backspace = findViewById(R.id.backspace);
        mul = findViewById(R.id.multiply);
        minus = findViewById(R.id.subtraction);
        add = findViewById(R.id.addition);
        equals = findViewById(R.id.equals);
        result = findViewById(R.id.result);
        equation = findViewById(R.id.calcu);

        Openbrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "%");
            }
        });


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "1");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process = equation.getText().toString();
                if (process.length() > 1) {
                    process = process.substring(0, process.length() - 1);
                    equation.setText(process);
                } else if (process.length() <= 1) {
                    equation.setText("");
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "/"); }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "*"); }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "-");
               }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "+");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + "9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                equation.setText(process + ".");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBrackets == true){
                    process = equation.getText().toString();
                    equation.setText(process + ")");
                    checkBrackets = false;
                }else{
                    process = equation.getText().toString();
                    equation.setText(process + "(");
                    checkBrackets = true;
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = equation.getText().toString();
                process = process.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult = "0";
                }
                result.setText(finalResult);
            }
        });
    }}
