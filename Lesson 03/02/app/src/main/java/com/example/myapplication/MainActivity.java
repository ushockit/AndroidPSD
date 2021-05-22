package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    private static final int FILE_SELECT_CODE = 0;
    private static final String TAG = "FILE_CHOOSE";

    Button btnChooseFile, btnSaveText, btnRead;
    EditText editText;
    ImageView imageView;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChooseFile = findViewById(R.id.btnChooseFile);
        btnRead = findViewById(R.id.btnRead);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        btnSaveText = findViewById(R.id.btnSaveText);
        tvText = findViewById(R.id.tvText);


        btnChooseFile.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);

            try {
                startActivityForResult(
                        Intent.createChooser(intent, "Select a File to Upload"),
                        FILE_SELECT_CODE);
            } catch (android.content.ActivityNotFoundException ex) {
                // Potentially direct the user to the Market with a Dialog
                Toast.makeText(this, "Please install a File Manager.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnSaveText.setOnClickListener(v -> {
            // текст для сохранения
            String text = editText.getText().toString();

            //try(PrintWriter pw = new PrintWriter(openFileOutput("saved data.txt", MODE_PRIVATE))) {
            File file = new File(getExternalFilesDir(null), "saved data.txt");
            try(PrintWriter pw = new PrintWriter(file)) {
                pw.write(text);
                Toast.makeText(MainActivity.this, "Success saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRead.setOnClickListener(v -> {
//            try(FileInputStream fis = openFileInput("saved data.txt")) {
//                byte[] buff = new byte[fis.available()];
//                fis.read(buff);
//                String text = new String(buff);
//                tvText.setText(text);
//                Toast.makeText(this, "Success read", Toast.LENGTH_SHORT).show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.d(TAG, "File Uri: " + uri.toString());
                    // Get the path
//                    String path = FileUtils.getPath(this, uri);
//                    Log.d(TAG, "File Path: " + path);
                    // Get the file instance
                    Picasso.get().load(uri).into(imageView);
                    // Initiate the upload
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}