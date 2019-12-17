package com.example.spacemanhotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class order_item extends AppCompatActivity {
    private List<String> chooselist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

        chooselist = new ArrayList<>();

        chooselist.add("评价");
        chooselist.add("支付");
        chooselist.add("分享");
    }
}
