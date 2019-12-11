package com.example.spacemanhotel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;
import java.util.ArrayList;

public class LoginActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Toolbar toolbar = (Toolbar)findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.test);
        }

        List<String> phoneAreaCodes = new ArrayList<String>();
        phoneAreaCodes.add("+86");
        phoneAreaCodes.add("其他的不让住");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,phoneAreaCodes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner)findViewById(R.id.login_spinner_phoneAreaCode);
        spinner.setAdapter(adapter);


//        spannable.setSpan(new ForegroundColorSpan(Color.RED), 8, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableStringBuilder spannable = new SpannableStringBuilder("登录代表你已同意《卖身协议》");
        TextView text_userAgreement = (TextView)findViewById(R.id.text_userAgreement);
        text_userAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        spannable.setSpan(new TextClick(),8,14 , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text_userAgreement.setText(spannable);

        Button otherWay = (Button)findViewById(R.id.login_button_otherWay);
        otherWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheet = new BottomSheetDialog(LoginActivty.this);//实例化BottomSheetDialog
                bottomSheet.setCancelable(true);//设置点击外部是否可以取消
//                  View view = getLayoutInflater().inflate(R.layout.login_dialog, null);
//                Button cancel = (Button)view.findViewById(R.id.login_dialog_cancel);
//                cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(LoginActivty.this, "cancel", Toast.LENGTH_SHORT).show();
//                    }
//                });
                bottomSheet.setContentView(R.layout.login_dialog);//设置对框框中的布局
                bottomSheet.findViewById(R.id.login_dialog_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(LoginActivty.this, "cancel", Toast.LENGTH_SHORT).show();
                        bottomSheet.cancel();
                    }
                });
                bottomSheet.show();//显示弹窗this
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.register_item:
                break;
        }
        return true;
    }

    private class TextClick extends ClickableSpan {
        @Override
        public void onClick(View view) {
            Toast.makeText(LoginActivty.this, "卖身成功", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.RED);
            ds.setUnderlineText(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

}
