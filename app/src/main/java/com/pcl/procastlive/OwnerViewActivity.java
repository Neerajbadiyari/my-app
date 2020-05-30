package com.pcl.procastlive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class OwnerViewActivity extends AppCompatActivity {

    ProgressBar progressBar;
    String webpageUrl = "https://pclacademy.procastlive.com";
    Button buttonGoLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_view);
        buttonGoLive = (Button)findViewById(R.id.btn_golive);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WebView webView = findViewById(R.id.webView_owner);
        progressBar = findViewById(R.id.progressbar_owner);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webView.loadUrl(webpageUrl);

        buttonGoLive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog(){
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                OwnerViewActivity.this);

        // Setting Dialog Title
        alertDialog2.setTitle("Go Live via...");

        // Setting Dialog Message
        //alertDialog2.setMessage("Are you sure you want go live");
        alertDialog2.setCancelable(true);

        // Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("MEETING ROOM",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        //startActivity(new Intent(OwnerViewActivity.this, LiveBroadCastActivity.class));
                        dialog.cancel();
                    }
                });
      // Setting Negative "NO" Btn
        alertDialog2.setNegativeButton("INDIVIDUAL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                       // startActivity(new Intent(OwnerViewActivity.this, LiveBroadCastActivity_Single_GoLIve.class));
                        dialog.cancel();
                    }
                });

       // Showing Alert Dialog
        alertDialog2.show();

    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
