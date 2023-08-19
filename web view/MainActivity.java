package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    ProgressBar myProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.myWebView);
        myProgressBar = findViewById(R.id.myProgressBar);

        myWebView.loadUrl("https://www.google.com");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);

                setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                myProgressBar.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                myProgressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                myProgressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuBack){
            if(myWebView.canGoBack()){
                myWebView.goBack();}
            
        } else if (item.getItemId() == R.id.menuForward) {
            if(myWebView.canGoForward()){
                myWebView.goForward();
            }else{
                Toast.makeText(this, "can't go forward", Toast.LENGTH_SHORT).show();
            }
        }
        else if(item.getItemId() == R.id.menuHome){
            myWebView.loadUrl("https://www.google.com");
        }
        else if (item.getItemId() == R.id.menuRefresh){
            myWebView.reload();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else {

            AlertDialog.Builder myExitDialogue = new AlertDialog.Builder(MainActivity.this);
            myExitDialogue.setTitle("Exiting App");
            myExitDialogue.setMessage("Do you want to exit the app");
            myExitDialogue.setPositiveButton("Exit app", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            myExitDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            myExitDialogue.create();
            myExitDialogue.show();

        }
    }
}
