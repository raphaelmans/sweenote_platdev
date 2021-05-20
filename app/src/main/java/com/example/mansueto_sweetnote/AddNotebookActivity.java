package com.example.mansueto_sweetnote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddNotebookActivity extends AppCompatActivity {

    Button btnAddNotebook;
    EditText etNotebookName, etCourseTitle,etCourseCode;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notebook);

        btnAddNotebook = (Button) findViewById(R.id.btnAddNotebook);
        etNotebookName = (EditText) findViewById(R.id.etNotebookName);
        etCourseTitle = (EditText) findViewById(R.id.etCourseTitle);
        etCourseCode = (EditText) findViewById(R.id.etCourseCode);
        builder = new AlertDialog.Builder(this);
        btnAddNotebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("notebookName",etNotebookName.getText().toString());
                bundle.putString("courseTitle",etCourseTitle.getText().toString());
                bundle.putString("courseCode",etCourseCode.getText().toString());
                Intent intent = new Intent(view.getContext(), ConfirmNotebookActivity.class);
                intent.putExtras(bundle);
                //MESSAGE CODE = 1
                startActivityForResult(intent,MainActivity.REQUEST_CODE);

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

            builder.setMessage("Are you sure to discard this?");
            builder.setCancelable(true);
            builder.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            finish();
                        }
                    });

            builder.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == RESULT_OK){
            System.out.println("Went over here! - add note book");
            Bundle result = data.getBundleExtra("result");
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result",result);
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            setResult(RESULT_OK,resultIntent);
            finish();
        }
    }
}