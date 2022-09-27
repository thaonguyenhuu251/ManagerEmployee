package com.example.manageremployee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtID, edtInputName;
    Button btnAdd;
    RadioGroup radGroup;
    ListView lvEmployee;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter = null;

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        btnAdd.setOnClickListener(this);
        lvEmployee.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getWidget() {
        edtID = findViewById(R.id.edtID);
        edtInputName = findViewById(R.id.edtInputName);
        btnAdd = findViewById(R.id.button);
        radGroup = findViewById(R.id.radioGroup);
        lvEmployee = findViewById(R.id.lvEmployee);
        lvEmployee.setOnItemClickListener(new MyListViewEvent());
        lvEmployee.setOnItemLongClickListener(new MyListViewEvent());
    }

    private void setDataEmployee() {
        int id = radGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.rbSecond:
                EmployeeFullTime nvFullTime = new EmployeeFullTime();
                nvFullTime.setId(edtID.getText().toString());
                nvFullTime.setName(edtInputName.getText().toString());
                arrEmployee.add(nvFullTime);
                break;
            case R.id.rbThree:
                EmployeePartTime nvPartTime = new EmployeePartTime();
                nvPartTime.setId(edtID.getText().toString());
                nvPartTime.setName(edtInputName.getText().toString());
                arrEmployee.add(nvPartTime);
                break;
        }
        edtID.setText("");
        edtInputName.setText("");
        edtID.requestFocus();
    }

    @Override
    public void onClick(View v) {
        setDataEmployee();
        hideKeyboard(this);
    }

    private class MyListViewEvent implements
            AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, arrEmployee.get(i).toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            arrEmployee.remove(i);
            adapter.notifyDataSetChanged();
            return false;
        }
    }
}