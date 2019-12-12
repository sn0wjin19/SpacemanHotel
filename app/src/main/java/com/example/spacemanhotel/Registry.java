package com.example.spacemanhotel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registry extends AppCompatActivity {

    private TextView registry_notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        Toolbar toolbar = (Toolbar)findViewById(R.id.registry_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.test);
        }

        final SpannableStringBuilder spannable = new SpannableStringBuilder("1.输入手机号 > 2.输入验证码 > 3.设置密码");
        final TextView registry_info = (TextView)findViewById(R.id.registry_info);
        registry_info.setMovementMethod(LinkMovementMethod.getInstance());
        spannable.setSpan(new ForegroundColorSpan(Color.RED),0,7 , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        registry_info.setText(spannable);
        final EditText input = (EditText)findViewById(R.id.registry_phone);

        registry_notice = (TextView)findViewById(R.id.registry_notice);
        final Button registry_button = (Button)findViewById(R.id.registry_button);
        registry_button.setOnClickListener(new View.OnClickListener() {
            int click = 0;
            @Override
            public void onClick(View v) {
                registry_notice.setText("验证码已发送 173****0490");
                registry_notice.setTextColor(Color.BLACK);
                registry_notice.setVisibility(View.VISIBLE);
                registry_button.setText("提交验证码");
                spannable.clearSpans();  // clear, or overlay
                spannable.setSpan(new ForegroundColorSpan(Color.RED),10,18 , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                registry_info.setText(spannable);  // make final can access inter
                input.setHint("请输入短信中的验证码");
                click++;
                if(click >= 2){
                    Intent intent = new Intent(Registry.this, Password.class);
                    startActivity(intent);
                }
            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
