package com.example.mansueto_sweetnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mansueto_sweetnote.database.DatabaseHelper;
import com.example.mansueto_sweetnote.database.NotebookDB;
import com.example.mansueto_sweetnote.models.Notebook;

import org.w3c.dom.Text;

public class ConfirmNotebookActivity extends AppCompatActivity {

    Button btnBack,btnConfirm;
    TextView txtNotebookName, txtCourseTitle,txtCourseCode;
    DatabaseHelper myDB;

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

        myDB = new DatabaseHelper(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                Bundle b = new Bundle();

                Notebook notebook = new Notebook();
                notebook.setNotebookName(txtNotebookName.getText().toString());
                notebook.setCourseCode(txtCourseCode.getText().toString());
                notebook.setCourseTitle(txtCourseTitle.getText().toString());

                b.putString("notebookName",txtNotebookName.getText().toString());
                b.putString("courseCode",txtCourseCode.getText().toString());
                b.putString("courseTitle",txtCourseTitle.getText().toString());

                addData(notebook);
                resultIntent.putExtra("result",b);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
    public void addData(Notebook nb){
        boolean insertData = new NotebookDB(this).createNotebook(nb);
        if(insertData){
            Toast.makeText(this,"Notebook created successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
        }
    }
}