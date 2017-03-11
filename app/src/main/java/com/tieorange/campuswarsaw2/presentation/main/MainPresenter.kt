package com.tieorange.campuswarsaw2.presentation.main

import android.os.Bundle
import android.net.Uri
import com.infullmobile.android.infullmvp.Presenter
import org.jsoup.Jsoup
import android.R.id.message
import android.util.Log
import android.webkit.*

open class MainPresenter(private val model: MainModel,
                         view: MainView) : Presenter<MainView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        loadData()
    }

    private fun loadData() {
        val url = "https://www.campus.co/warsaw/en/events"

        val browser = WebView(context)

        /* JavaScript must be enabled if you want it to work, obviously */
        browser.settings.javaScriptEnabled = true

        /* *//* Register a new JavaScript interface called HTMLOUT *//*
        val myJavaScriptInterface = object : MyJavaScriptInterface() {
            override fun processHTML(html: String) {
                presentedView.showHtmlContent(html)
            }

        }*/
        val htmlContentRetrieved: (String) -> Unit = {
            presentedView.showHtmlContent(it)
        }
        browser.addJavascriptInterface(MyJavaScriptInterface(htmlContentRetrieved), "HTMLOUT")

        /* WebViewClient must be set BEFORE calling loadUrl! */
        browser.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                /* This call inject JavaScript into the page which just finished loading. */
                browser.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');")
            }
        })
        /* load a web page */
        browser.loadUrl(url)
    }

}


/* An instance of this class will be registered as a JavaScript interface */
class MyJavaScriptInterface(private val function: (String) -> Unit) {
    @JavascriptInterface
    @SuppressWarnings("unused")
    fun processHTML(html: String) {
        function.invoke(html)
    }
}
