package com.example.codingboy.caculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btn_point;// 小数点
    private Button btn_divide;// 除以
    private Button btn_multiply;// 乘以
    private Button btn_minus;// 减去
    private Button btn_pluse;// 加
    private Button btn_equal;// 等于

    private Button btn_clear;  //清空
    private Button btn_del;  //取消

    private EditText et_showview;  //输入框
    private double dou = 0;  //接收结果



    private boolean flag;//标志服，判断是否清空编辑框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    private void initView()
    {
        flag=true;


        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);// 小数点
        btn_divide = (Button) findViewById(R.id.btn_divide);// 除以
        btn_multiply = (Button) findViewById(R.id.btn_multiply);// 乘以
        btn_minus = (Button) findViewById(R.id.btn_minus);// 减去
        btn_pluse = (Button) findViewById(R.id.btn_pluse);// 加
        btn_equal = (Button) findViewById(R.id.btn_equal);// 等于

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        et_showview = (EditText) findViewById(R.id.et_showview);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_pluse.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = et_showview.getText().toString();
            switch (v.getId()) {
                case R.id.btn_0:
                case R.id.btn_1:
                case R.id.btn_2:
                case R.id.btn_3:
                case R.id.btn_4:
                case R.id.btn_5:
                case R.id.btn_6:
                case R.id.btn_7:
                case R.id.btn_8:
                case R.id.btn_9:
                    if (str.charAt(0) == ' ') {
                        et_showview.setText(((Button) v).getText());
                    }
                    if (str.charAt(0) == '0' && !str.contains(" ") && !str.contains(".")) {
                        et_showview.setText(((Button) v).getText());
                    } else {
                        et_showview.setText(str + ((Button) v).getText());
                    }

                    break;
                case R.id.btn_point:
                    if (str == "0") {
                        et_showview.setText("0" + ".");
                    } else if (str.contains(".") || str.charAt(str.length() - 1) == ' ') {
                        et_showview.setText(str);
                    } else {
                        et_showview.setText(str + ".");
                    }
                    break;
                case R.id.btn_pluse:
                case R.id.btn_minus:
                case R.id.btn_multiply:
                case R.id.btn_divide:
                    if (str.charAt((str.length() - 1)) == ' ') {
                        et_showview.setText(str.substring(0, str.length() - 3) + " " + ((Button) v).getText() + " ");
                    } else {
                        et_showview.setText(str + " " + ((Button) v).getText() + " ");
                    }
                    break;
                case R.id.btn_del:
                    if (str.length() == 1) {
                        et_showview.setText("0");
                    } else {
                        et_showview.setText(str.substring(0, str.length() - 1));
                    }
                    break;
                case R.id.btn_clear:
                    et_showview.setText("0");
                    break;
                case R.id.btn_equal:
                    getResult();

                    break;
                default:
                    break;
            }

    }
    private void getResult()
    {
        flag=false;
        String result=et_showview.getText().toString();
        if(!result.contains(" "))
        {
            if(result.equals("520"))
            {
                et_showview.setText("光光我爱你");
            }else if(result.equals("250"))
            {
                et_showview.setText("光光你是个250");
            }else {
                return;
            }
        }
        else {
            String str1 = result.substring(0, result.indexOf(" "));
            String op = result.substring(result.indexOf(" ") + 1, result.indexOf(" ") + 2);
            String str2 = result.substring(result.indexOf(" ") + 3);
            if (!str2.equals("")) {
                Double d1 = Double.parseDouble(str1);
                Double d2 = Double.parseDouble(str2);
                if (op.equals("+")) {
                    dou = d1 + d2;

                } else if (op.equals("-")) {
                    dou = d1 - d2;
                } else if (op.equals("*")) {
                    dou = d1 * d2;
                } else if (op.equals("/")) {
                    if (d1 == 0 && d2 != 0) {
                        dou = 0;
                    } else if (d2 == 0) {
                        dou = 0;
                        Toast.makeText(MainActivity.this, "There is a error", Toast.LENGTH_SHORT).show();
                    } else {
                        dou = d1 / d2;
                    }
                }

                double media = dou - (int) dou;
                if (media > 0) {
                    String last = String.valueOf(dou);
                    et_showview.setText(last);
                } else {
                    if(dou==520)
                    {
                        et_showview.setText("光光我爱你");
                    }else if(dou==250)
                    {
                        et_showview.setText("光光你是个250");
                    }else {
                        if(dou>999999999999999d){
                            et_showview.setText("999999999999999d");
                            Toast.makeText(MainActivity.this,"Over the field",Toast.LENGTH_SHORT).show();
                        }else {
                            int inter = (int) dou;
                            String last = String.valueOf(inter);
                            et_showview.setText(last);
                        }
                    }
                }

            } else {
                et_showview.setText(result);
                Toast.makeText(MainActivity.this, "There isn't finished", Toast.LENGTH_SHORT).show();
            }
        }

    }


}
