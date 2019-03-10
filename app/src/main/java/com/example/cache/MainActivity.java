package com.example.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.username);
    }

    public void saveInternal(View view){
        String name = editText.getText().toString();

        File file = getCacheDir();
        File file1 = new File(file,"DataInternal.txt");
        dataStore(name, file1);

    }

    private void dataStore(String name, File file1) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(name.getBytes());
            Toast.makeText(this,"Data stored successfully", Toast.LENGTH_LONG).show();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
           try {
               fileOutputStream.close();
           }catch (IOException e ){
               e.printStackTrace();
           }
        }
    }

    public void saveExternal(View view){
        String name = editText.getText().toString();
        File file = getExternalCacheDir();
        File file1 = new File(file,"DataExternal.txt");

        dataStore(name, file1);
    }

}
