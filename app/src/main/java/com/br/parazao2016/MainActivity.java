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
    final String appodealKey = getString(R.string.appodeal_key);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MostrarTabela();
        Appodeal.initialize(this, appodealKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
        Appodeal.setTesting(false);

        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
       ;
    }

    public void MostrarTabela(){
        setContentView(R.layout.activity_main);

        WebView golTapajosSR = (WebView) findViewById(R.id.golTapajosSR);

        WebSettings wsgolTapajosSR = golTapajosSR.getSettings();
        wsgolTapajosSR.setJavaScriptEnabled(true);
        wsgolTapajosSR.setSupportZoom(false);

        golTapajosSR.loadUrl("http://resr92.esy.es/1.jpg");


        WebView golSRTapajos = (WebView) findViewById(R.id.golSRTapajos);

        WebSettings wsgolSRTapajos = golSRTapajos.getSettings();
        wsgolSRTapajos.setJavaScriptEnabled(true);
        wsgolSRTapajos.setSupportZoom(false);

        golSRTapajos.loadUrl("http://resr92.esy.es/3-1.jpg");


        Appodeal.initialize(this, appodealKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
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

        wv.loadUrl("http://resr92.esy.es/tabela%20gp1mod-.png");

        WebView wv2 = (WebView) findViewById(R.id.webView2);

        WebSettings ws2 = wv2.getSettings();
        ws2.setJavaScriptEnabled(true);
        ws2.setSupportZoom(false);

        wv2.loadUrl("http://resr92.esy.es/Tabela%20gp2mod.png");



        Appodeal.initialize(this, appodealKey, Appodeal.INTERSTITIAL | Appodeal.BANNER);
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
