package com.example.mansueto_sweetnote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mansueto_sweetnote.database.NotebookDB;
import com.example.mansueto_sweetnote.models.Notebook;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 1;
    ListView lstNotebooks;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter arrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303F9F")));


        ArrayList<Notebook> notebooks = new NotebookDB(this).readNotebooks();
        for(Notebook nb : notebooks){
            arrayList.add(nb.getNotebookName());
        }
        lstNotebooks = (ListView) findViewById(R.id.lstNotebooks);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lstNotebooks.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.addNotebook:
                intent = new Intent(this, AddNotebookActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.aboutUs:
                intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Bundle result = data.getBundleExtra("result");
            arrayList.add(result.getString("notebookName"));
            arrayAdapter.notifyDataSetChanged();
        }
    }
}