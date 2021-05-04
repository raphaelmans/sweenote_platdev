package com.example.mansueto_sweetnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNotebookActivity extends AppCompatActivity {

    Button btnAddNotebook;
    EditText etNotebookName, etCourseTitle,etCourseCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notebook);

        btnAddNotebook = (Button) findViewById(R.id.btnAddNotebook);
        etNotebookName = (EditText) findViewById(R.id.etNotebookName);
        etCourseTitle = (EditText) findViewById(R.id.etCourseTitle);
        etCourseCode = (EditText) findViewById(R.id.etCourseCode);

        btnAddNotebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("notebookName",etNotebookName.getText().toString());
                bundle.putString("courseTitle",etCourseTitle.getText().toString());
                bundle.putString("courseCode",etCourseCode.getText().toString());
                Intent intent = new Intent(view.getContext(),DisplayNotebookActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}