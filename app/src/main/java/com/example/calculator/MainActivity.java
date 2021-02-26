package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    public Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnadd,btnsub,btnmul,btndiv,btndot,btnequal,btnclear,bbracket;
    public TextView ans;
    public TextView history;
    String calculation;
    boolean bracket=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history=(TextView)findViewById(R.id.history);
        btn0=(Button)findViewById(R.id.b0);
        btn1=(Button)findViewById(R.id.b1);
        btn2=(Button)findViewById(R.id.b2);
        btn3=(Button)findViewById(R.id.b3);
        btn4=(Button)findViewById(R.id.b4);
        btn5=(Button)findViewById(R.id.b5);
        btn6=(Button)findViewById(R.id.b6);
        btn7=(Button)findViewById(R.id.b7);
        btn8=(Button)findViewById(R.id.b8);
        btn9=(Button)findViewById(R.id.b9);
        btndot=(Button)findViewById(R.id.bdot);
        btnequal=(Button)findViewById(R.id.equal);
        btnadd=(Button)findViewById(R.id.badd);
        btnsub=(Button)findViewById(R.id.bsub);
        btnmul=(Button)findViewById(R.id.bmul);
        btndiv=(Button)findViewById(R.id.bdiv);
        btnclear=(Button)findViewById(R.id.clear);
        bbracket=(Button)findViewById(R.id.bracket);
        ans=(TextView)findViewById(R.id.answer);
        final MediaPlayer mp= MediaPlayer.create(this,R.raw.audio);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history.setText("");
                ans.setText("");
                bracket=false;
                mp.start();
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"0");
                mp.start();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"1");
                mp.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"2");
                mp.start();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"3");
                mp.start();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"4");
                mp.start();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"5");
                mp.start();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"6");
                mp.start();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"7");
                mp.start();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"8");
                mp.start();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"9");
                mp.start();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"+");
                mp.start();
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"-");
                mp.start();
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"x");
                mp.start();
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+"/");
                mp.start();
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                history.setText(calculation+".");
                mp.start();
            }
        });
        bbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bracket) {
                    calculation=history.getText().toString();
                    history.setText(calculation+")");
                    bracket=false;
                }else
                {
                    calculation=history.getText().toString();
                    history.setText(calculation+"(");
                    bracket=true;
                }
                mp.start();
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation=history.getText().toString();
                calculation=calculation.replaceAll("x","*");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result="";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    result = rhino.evaluateString(scriptable,calculation,"javascript", 1,null).toString();
                }catch (Exception e)
                {
                    result="Error";
                }
                ans.setText(result);
                mp.start();
            }
        });
    }
    public void Tap1(View view)
    {
        String str=history.getText().toString();
        int length=str.length();
        char[] ch=new char[90];
        int i;
        for (i=0;i<length-1;i++)
        {
            ch[i]=str.charAt(i);
        }
        history.setText("");
        for (i=0;i<length-1;i++)
        {
            history.setText(history.getText()+String.valueOf(ch[i]));
        }
        final MediaPlayer sp=MediaPlayer.create(this,R.raw.audio);
        sp.start();
    }
    public void Tap2(View view)
    {
        String str=history.getText().toString();
        int length=str.length(),l=0;
        char[] ch=new char[90];
        int i;
        for (i=0;i<length;i++)
        {
            ch[i]=str.charAt(i);
        }
        for (i=0;i<length;i++)
        {
            if (ch[i]=='+')
                l=1;
            if (ch[i]=='-')
                l=1;
            if (ch[i]=='x')
                l=1;
            if (ch[i]=='/')
                l=1;
            if (ch[i]=='(')
                l=1;
            if (ch[i]==')')
                l=1;
        }
        if (l==1) {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(str=="") {
                ans.setText("");
                Toast.makeText(getApplicationContext(),"Put a number ",Toast.LENGTH_SHORT).show();
            }
            else {
                double a = Double.parseDouble(str.toString());
                if (a >= 0) {
                    ans.setText(String.valueOf(Math.sqrt(a)));
                }
                else
                    Toast.makeText(getApplicationContext(),"No. should be positive ",Toast.LENGTH_SHORT).show();
            }
        }
        final MediaPlayer sp=MediaPlayer.create(this,R.raw.audio);
        sp.start();
    }
    public void Tap3(View view)
    {
        String str=history.getText().toString();
        int length=str.length(),l=0;
        char[] ch=new char[90];
        int i;
        for (i=0;i<length;i++)
        {
            ch[i]=str.charAt(i);
        }
        for (i=0;i<length;i++)
        {
            if (ch[i]=='+')
                l=1;
            if (ch[i]=='-')
                l=1;
            if (ch[i]=='x')
                l=1;
            if (ch[i]=='/')
                l=1;
            if (ch[i]=='(')
                l=1;
            if (ch[i]==')')
                l=1;
        }
        if (l==1) {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(str=="") {
                ans.setText("");
                Toast.makeText(getApplicationContext(),"Put a number ",Toast.LENGTH_SHORT).show();
            }
            else {
                double a = Double.parseDouble(str.toString());
                if (a >= 1) {
                    ans.setText(String.valueOf(Math.log(a)));
                }
                else
                    Toast.makeText(getApplicationContext(),"No. should be positive ",Toast.LENGTH_SHORT).show();
            }
        }
        final MediaPlayer sp=MediaPlayer.create(this,R.raw.audio);
        sp.start();
    }
    public void Tap4(View view)
    {
        String str=history.getText().toString();
        int length=str.length(),l=0;
        char[] ch=new char[90];
        int i;
        for (i=0;i<length;i++)
        {
            ch[i]=str.charAt(i);
        }
        for (i=0;i<length;i++)
        {
            if (ch[i]=='+')
                l=1;
            if (ch[i]=='-')
                l=1;
            if (ch[i]=='x')
                l=1;
            if (ch[i]=='/')
                l=1;
            if (ch[i]=='(')
                l=1;
            if (ch[i]==')')
                l=1;
        }
        if (l==1) {
            if (ch[0]=='-')
            {
                double a = Double.parseDouble(str.toString());
                ans.setText(String.valueOf(a*a*a));
            }
            else if (ch[0]=='+')
            {
                double a = Double.parseDouble(str.toString());
                ans.setText(String.valueOf(a*a*a));
            }else
                Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(str=="") {
                ans.setText("");
                Toast.makeText(getApplicationContext(),"Put a number ",Toast.LENGTH_SHORT).show();
            }
            else {
                double a = Double.parseDouble(str.toString());
                    ans.setText(String.valueOf(a*a*a));
            }
        }
        final MediaPlayer sp=MediaPlayer.create(this,R.raw.audio);
        sp.start();
    }
    public void Tap5(View view)
    {
        String str=history.getText().toString();
        int length=str.length(),l=0;
        char[] ch=new char[90];
        int i;
        for (i=0;i<length;i++)
        {
            ch[i]=str.charAt(i);
        }
        for (i=0;i<length;i++)
        {
            if (ch[i]=='+')
                l=1;
            if (ch[i]=='-')
                l=1;
            if (ch[i]=='x')
                l=1;
            if (ch[i]=='/')
                l=1;
            if (ch[i]=='(')
                l=1;
            if (ch[i]==')')
                l=1;
        }
        if (l==1) {
            if (ch[0]=='-')
            {
                double a = Double.parseDouble(str.toString());
                ans.setText(String.valueOf(a*a));
            }
            else if (ch[0]=='+')
            {
                double a = Double.parseDouble(str.toString());
                ans.setText(String.valueOf(a*a));
            }else
                Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(str=="") {
                ans.setText("");
                Toast.makeText(getApplicationContext(),"Put a number ",Toast.LENGTH_SHORT).show();
            }
            else {
                double a = Double.parseDouble(str.toString());
                ans.setText(String.valueOf(a*a));
            }
        }
        final MediaPlayer sp=MediaPlayer.create(this,R.raw.audio);
        sp.start();
    }
    public void Tap6(View view)
    {
        Intent intent=new Intent(this, creators.class);
        startActivity(intent);
    }
}
