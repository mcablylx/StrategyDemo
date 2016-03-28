package com.mckiera.strategy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mckiera.strategy.strategy.CashContext;
import com.mckiera.strategydemo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * author by Mckiera
 * time: 2016/3/25  09:48
 * description:
 * updateTime:
 * update description:
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    private static final String TAG = "FUCK";
    List<String> list;
    BaseAdapter adapter;
    Spinner sType;
    String curPromotion;
    EditText etPrice;
    EditText etCount;
    TextView tvAllPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        String[] array = getResources().getStringArray(R.array.promotion);
        List<String> list = new ArrayList<>();
        for (String str : array) {
            list.add(str);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        sType.setAdapter(adapter);
        sType.setOnItemSelectedListener(this);
    }

    private void initView() {
        etCount = (EditText) findViewById(R.id.etCount);
        etPrice = (EditText) findViewById(R.id.etPrice);
        tvAllPrice = (TextView) findViewById(R.id.tvAllPrice);
        sType = (Spinner) findViewById(R.id.sType);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, parent.getItemAtPosition(position).toString());
        curPromotion = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    /**
     * 点击确定按钮
     * @param view
     */
    public void btnOK(View view) {
        if(TextUtils.isEmpty(etCount.getText().toString()) || TextUtils.isEmpty(etPrice.getText().toString()) || TextUtils.isEmpty(curPromotion)){
            Toast.makeText(this, "请填全", Toast.LENGTH_LONG).show();
            return;
        }

        CashContext cash = new CashContext(curPromotion);
        double allPrice = getAllPrice(etCount.getText().toString(), etPrice.getText().toString());
        double curPrice = cash.cashAction(allPrice);
        tvAllPrice.setText(curPrice + " 元");
    }

    private double getAllPrice(String s, String s1) {
        return Double.valueOf(s) * Double.valueOf(s1);
    }

    /**
     * 重置按钮
     * @param view
     */
    public void btnReset(View view) {
        etCount.setText("");
        etPrice.setText("");
        curPromotion = "";
        tvAllPrice.setText("");
        sType.setSelection(0);
        //用Mac提交试试
    }
}
