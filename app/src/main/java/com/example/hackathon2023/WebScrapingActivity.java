package com.example.hackathon2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapingActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_scraping);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new scrapeWeb().execute();
            }
        });
    }
    public class scrapeWeb extends AsyncTask<Void, Void, Void> {
        String textToImport;


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect
                        ("https://www.homedepot.com/s/plants?NCNI-5").userAgent("Mozilla/5.0").get();

                // #1.
                Elements temp = document.select
                        ("div.product-header__title--clamp--4y7oa product-header__title--fourline--4y7oa");
                int i = 0;
                // this isn't printing. probably something to do with #1.
                for (Element plantList : temp) {
                    i++;
                    System.out.println(i + " " +
                            plantList.getElementsByTag("h3").first().text());
                }
                textToImport = document.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            textView.setText(textToImport);

        }
    }
}