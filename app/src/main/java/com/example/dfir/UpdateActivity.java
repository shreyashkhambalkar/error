package com.example.dfir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText names, description, documents;
    Button update_button;
    String id, name , descriptions , document;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        names = findViewById(R.id.names1);
        description = findViewById(R.id.description1);
        documents = findViewById(R.id.documents1);
        update_button = findViewById(R.id.button1);



        getAndSetIntentData();


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id,name,descriptions,document);
            }
        });
    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("names") &&
                getIntent().hasExtra("description") && getIntent().hasExtra("documents")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("names");
            descriptions = getIntent().getStringExtra("description");
            document = getIntent().getStringExtra("documents");

            //Setting Intent Data
            names.setText(name);
            description.setText(descriptions);
            documents.setText(document);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}
