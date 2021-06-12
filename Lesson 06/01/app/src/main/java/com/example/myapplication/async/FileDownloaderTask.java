package com.example.myapplication.async;

import android.content.Context;
import android.os.AsyncTask;

import com.example.myapplication.models.UploadFileInfo;

import java.util.concurrent.TimeUnit;

public class FileDownloaderTask extends AsyncTask<String, Integer, UploadFileInfo> {
    public interface OnFileDownloaderListener {
        void updateDownloadProgress(int percentage);
        void downloadComplete(UploadFileInfo uploadFileInfo);
    }

    OnFileDownloaderListener listener;
    Context context;


    public FileDownloaderTask(Context context) {
        this.context = context;

        if (context instanceof OnFileDownloaderListener) {
            listener = (OnFileDownloaderListener) context;
        }
    }

    @Override
    protected UploadFileInfo doInBackground(String... strings) {
        // String downloadPath = strings[0];
        boolean completeDownload = false;

        int counter = 100;
        int percentage = 0;
        while (!completeDownload) {

            //TODO: download
            if (isCancelled()) {
                return null;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter--;
            percentage++;
            // уведомление об изменении прогреса
            publishProgress(percentage);

            if (counter <= 0) {
                completeDownload = true;
            }
        }

        return new UploadFileInfo("picture.jpeg", "jpeg", 120000l);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(UploadFileInfo uploadFileInfo) {
        super.onPostExecute(uploadFileInfo);
        // Уведомление о завершении работы
        listener.downloadComplete(uploadFileInfo);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (listener != null) {
            listener.updateDownloadProgress(values[0]);
        }
    }
}
