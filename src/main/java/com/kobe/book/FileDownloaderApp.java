package com.kobe.book;

import java.util.Arrays;
import java.util.List;

public class FileDownloaderApp {

    private static final List<String> urlList = Arrays.asList("", "");

    public static void main(String[] args) {
        Thread downloaderThread = null;
        for (String url : urlList) {
            downloaderThread = new Thread(new FileDownloader(url));
            downloaderThread.start();
        }
    }

    static class FileDownloader implements Runnable {

        private final String fileURL;

        public FileDownloader(String fileURL) {
            this.fileURL = fileURL;
        }

        @Override
        public void run() {

        }
    }

}
