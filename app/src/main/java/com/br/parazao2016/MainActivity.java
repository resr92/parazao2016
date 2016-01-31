package com.br.parazao2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;


public class MainActivity extends AppCompatActivity {

    Button btclassificacao, bttabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MostrarTabela();
        String appKey = "a94d38f00df8f97224217d7612b2ae7c373a35c0bb0e65ae";
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
        Appodeal.setTesting(false);

        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
       ;
    }

    public void MostrarTabela(){
        setContentView(R.layout.activity_main);

        WebView wv3 = (WebView) findViewById(R.id.webView3);

        WebSettings ws3 = wv3.getSettings();
        ws3.setJavaScriptEnabled(true);
        ws3.setSupportZoom(false);

        wv3.loadUrl("http://resr92.esy.es/goltime1.html");

        WebView wv4 = (WebView) findViewById(R.id.webView4);

        WebSettings ws4 = wv4.getSettings();
        ws4.setJavaScriptEnabled(true);
        ws4.setSupportZoom(false);

        wv4.loadUrl("http://resr92.esy.es/goltime2.html");

        WebView wv5 = (WebView) findViewById(R.id.webView5);

        WebSettings ws5 = wv5.getSettings();
        ws5.setJavaScriptEnabled(true);
        ws5.setSupportZoom(false);

        wv5.loadUrl("http://resr92.esy.es/goltime3.html");

        WebView wv6 = (WebView) findViewById(R.id.webView6);

        WebSettings ws6 = wv6.getSettings();
        ws6.setJavaScriptEnabled(true);
        ws6.setSupportZoom(false);

        wv6.loadUrl("http://resr92.esy.es/goltime4.html");

        WebView wv7 = (WebView) findViewById(R.id.webView7);

        WebSettings ws7 = wv7.getSettings();
        ws7.setJavaScriptEnabled(true);
        ws7.setSupportZoom(false);

        wv7.loadUrl("http://resr92.esy.es/goltime5.html");

        WebView wv8 = (WebView) findViewById(R.id.webView8);

        WebSettings ws8 = wv8.getSettings();
        ws8.setJavaScriptEnabled(true);
        ws8.setSupportZoom(false);

        wv8.loadUrl("http://resr92.esy.es/goltime6.html");

        WebView wv9 = (WebView) findViewById(R.id.webView9);

        WebSettings ws9 = wv9.getSettings();
        ws9.setJavaScriptEnabled(true);
        ws9.setSupportZoom(false);

        wv9.loadUrl("http://resr92.esy.es/goltime7.html");

        WebView wv10 = (WebView) findViewById(R.id.webView10);

        WebSettings ws10 = wv10.getSettings();
        ws10.setJavaScriptEnabled(true);
        ws10.setSupportZoom(false);

        wv10.loadUrl("http://resr92.esy.es/goltime8.html");


        String appKey = "a94d38f00df8f97224217d7612b2ae7c373a35c0bb0e65ae";
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
        Appodeal.setTesting(false);
        Appodeal.show(this, Appodeal.BANNER_BOTTOM);

        btclassificacao = (Button) findViewById(R.id.btclassificacao);
        btclassificacao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MostrarClassificacao();
            }
        });
    }

    public void MostrarClassificacao(){
        setContentView(R.layout.classificacao);

        WebView wv = (WebView) findViewById(R.id.webView);

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        wv.loadUrl("http://resr92.esy.es/tablesorter/index.html");

        WebView wv2 = (WebView) findViewById(R.id.webView2);

        WebSettings ws2 = wv2.getSettings();
        ws2.setJavaScriptEnabled(true);
        ws2.setSupportZoom(false);

        wv2.loadUrl("http://resr92.esy.es/tablesorter2/index.html");



        String appKey = "a94d38f00df8f97224217d7612b2ae7c373a35c0bb0e65ae";
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
        Appodeal.setTesting(false);

        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
        bttabela = (Button) findViewById(R.id.bttabela);
        bttabela.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MostrarTabela();
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER);
    }

    private boolean gettingout = false;
    @Override
    public void onBackPressed(){
        if (gettingout){
            super.onBackPressed();
            finish();
        }
else {
            gettingout = true;
            Appodeal.show(this, Appodeal.INTERSTITIAL);

            Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
                @Override
                public void onInterstitialLoaded(boolean b) {

                }

                @Override
                public void onInterstitialFailedToLoad() {

                }

                @Override
                public void onInterstitialShown() {

                }

                @Override
                public void onInterstitialClicked() {

                }

                @Override
                public void onInterstitialClosed() {
                    onBackPressed();
                }
            });
        }

    }
}
