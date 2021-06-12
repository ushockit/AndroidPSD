package com.example.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/*
* AsyncTask<Входные, Промежуточный, Выходной>
* */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    final String TAG = "MyAsyncTaskTAG";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                Log.d(TAG, "doInBackground: work");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // вызывается по мере завершения выполнения задачи
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG, "onPostExecute: End");
    }

    // вызывается перед началом работы
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: Start");
    }

    // вызыается во время работы
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
