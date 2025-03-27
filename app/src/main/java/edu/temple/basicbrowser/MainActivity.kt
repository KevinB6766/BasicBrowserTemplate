package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        goButton.setOnClickListener {
            val url = urlEditText.text.toString().trim() // Remove leading/trailing spaces
            if (url.isNotEmpty()){ // check if url is not empty
                if (!url.startsWith("http://") && !url.startsWith("https://")){ // check if url starts with http or https
                    urlEditText.setText("https://$url") // add https:// to the url
                }
            }
            webView.loadUrl(url) // load the url in the webview
        }
        //use this in android manifest xml in outside application and activity tags
        //<uses-permission android:name="android.permission.INTERNET"/>
        //allows access to the internet


    }
}