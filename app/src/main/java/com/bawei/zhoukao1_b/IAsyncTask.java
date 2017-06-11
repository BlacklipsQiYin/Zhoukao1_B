package com.bawei.zhoukao1_b;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/6/11/0011.
 */

public class IAsyncTask extends AsyncTask<String, Void, String> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            String path = "http://result.eolinker.com/Ikx4fDc398b93bfd0c8a146468e1f8cddfe9166719cba13?uri=zhoukao";

            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(20000);
            urlConnection.setConnectTimeout(20000);
//            urlConnection.setDoOutput(true);
//            urlConnection.setDoInput(true);

            if (urlConnection.getResponseCode()==200){

                InputStream is = urlConnection.getInputStream();
                String string =  ReadFile.readFromFile(is);

                return string;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
