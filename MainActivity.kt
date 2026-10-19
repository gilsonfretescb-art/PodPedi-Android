package com.podpedi.entregas

import android.app.Activity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.content.Intent
import android.net.Uri
import android.graphics.Color
import android.view.View
import android.view.WindowManager

class MainActivity : Activity() {
    private lateinit var webView: WebView
    private val homeUrl = "https://podpedientregas.netlify.app/"
    private val trustedHost = "podpedientregas.netlify.app"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(20, 20, 20)
        window.navigationBarColor = Color.rgb(20, 20, 20)
        window.decorView.systemUiVisibility = 0
        webView = WebView(this)
        webView.setBackgroundColor(Color.WHITE)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
        webView.settings.setSupportMultipleWindows(false)
        webView.settings.allowFileAccess = false
        webView.settings.allowContentAccess = false
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val uri = request?.url ?: return false
                val scheme = uri.scheme ?: ""
                if (scheme == "http" || scheme == "https") {
                    if (uri.host == trustedHost || uri.host?.endsWith(".supabase.co") == true) return false
                    return try { startActivity(Intent(Intent.ACTION_VIEW, uri)); true } catch (_: Exception) { true }
                }
                return try { startActivity(Intent(Intent.ACTION_VIEW, uri)); true } catch (_: Exception) { true }
            }
        }
        setContentView(webView)
        if (savedInstanceState == null) webView.loadUrl(homeUrl) else webView.restoreState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Deprecated in Android API")
    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }

    override fun onDestroy() {
        if (this::webView.isInitialized) webView.destroy()
        super.onDestroy()
    }
}
