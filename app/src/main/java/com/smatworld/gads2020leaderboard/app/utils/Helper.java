package com.smatworld.gads2020leaderboard.app.utils;

import android.os.AsyncTask;

import androidx.fragment.app.FragmentActivity;

import com.smatworld.gads2020leaderboard.app.application.GADSApplication;
import com.smatworld.gads2020leaderboard.app.di.ApplicationComponent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutionException;

public class Helper {
    private static final Helper ourInstance = new Helper();

    static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {
    }

    public static ApplicationComponent getApplicationComponent(FragmentActivity fragmentActivity) {
        return ((GADSApplication) fragmentActivity.getApplication()).getApplicationComponent();
    }

    public static boolean isOnline() {
        try {
            return new InternetAccessAsyncTask().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class InternetAccessAsyncTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPostExecute(Boolean internet) {
            super.onPostExecute(internet);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                int timeoutMs = 1500;
                Socket sock = new Socket();
                SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);
                sock.connect(sockaddr, timeoutMs);
                sock.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }

}
