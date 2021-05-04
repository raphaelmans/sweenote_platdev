package com.example.mansueto_sweetnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayNotebookActivity extends AppCompatActivity {

    Button btnBack,btnConfirm;
    TextView txtNotebookName, txtCourseTitle,txtCourseCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notebook);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        txtNotebookName = (TextView) findViewById(R.id.txtNotebookName);
        txtCourseTitle = (TextView) findViewById(R.id.txtCourseTitle);
        txtCourseCode = (TextView) findViewById(R.id.txtCourseCode);

        Bundle bundle = getIntent().getExtras();
        txtNotebookName.setText(bundle.getString("notebookName"));
        txtCourseCode.setText(bundle.getString("courseCode"));
        txtCourseTitle.setText(bundle.getString("courseTitle"));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}