package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.async.FileDownloaderTask;
import com.example.myapplication.async.MyAsyncTask;
import com.example.myapplication.models.UploadFileInfo;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity implements FileDownloaderTask.OnFileDownloaderListener {
    private static final String TAG = "MainActivityTAG";
    Button btnStartTask, btnDemo, btnDownload, btnCancelDownload;
    TextView textView, tvDownloadProgress;
    EditText etDownloadPath;

    MyAsyncTask myAsyncTask = new MyAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartTask = findViewById(R.id.btnStartTask);
        textView = findViewById(R.id.textView);
        btnDemo = findViewById(R.id.btnDemo);
        btnDownload = findViewById(R.id.btnDownload);
        tvDownloadProgress = findViewById(R.id.tvDownloadProgress);
        etDownloadPath = findViewById(R.id.etDownloadPath);
        btnCancelDownload = findViewById(R.id.btnCancelDownload);

        btnStartTask.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: Start");
            if (!myAsyncTask.isCancelled()) {
                // запуск задачи
                myAsyncTask.execute();
            }
        });

        AtomicInteger counter = new AtomicInteger();
        btnDemo.setOnClickListener(v -> {
            textView.setText(String.valueOf(counter.incrementAndGet()));
        });

        FileDownloaderTask fileDownloader = new FileDownloaderTask(this);
        // клик по кнопке "Начать загрузку"
        btnDownload.setOnClickListener(v -> {
            etDownloadPath.setEnabled(false);
            btnDownload.setEnabled(false);
            btnCancelDownload.setEnabled(true);

            fileDownloader.execute(etDownloadPath.getText().toString());


//            if (fileDownloader.getStatus() == AsyncTask.Status.FINISHED) {
//                try {
//                    UploadFileInfo uploadFileInfo = fileDownloader.get();
//                } catch (ExecutionException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        });

        btnCancelDownload.setOnClickListener(v -> {
            if (fileDownloader.getStatus() == AsyncTask.Status.RUNNING) {
                fileDownloader.cancel(false);
            }
        });
    }

    @Override
    public void updateDownloadProgress(int percentage) {
        tvDownloadProgress.setText(percentage + "%");
    }

    @Override
    public void downloadComplete(UploadFileInfo uploadFileInfo) {
        Toast.makeText(this, uploadFileInfo.toString(), Toast.LENGTH_SHORT).show();
        etDownloadPath.setEnabled(true);
        btnDownload.setEnabled(true);
        btnCancelDownload.setEnabled(false);
    }
}