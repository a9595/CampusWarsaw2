package com.tieorange.campuswarsaw2.presentation.main

import android.os.Bundle
import android.net.Uri
import com.infullmobile.android.infullmvp.Presenter
import org.jsoup.Jsoup
import android.R.id.message
import android.util.Log
import android.webkit.*
import android.webkit.ValueCallback
import com.google.android.gms.tasks.Tasks.await
import com.google.android.gms.tasks.Tasks.call
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jsoup.nodes.Document


open class MainPresenter(private val model: MainModel,
                         view: MainView) : Presenter<MainView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        loadData()
    }

    private fun loadData() {
        val url = "https://www.campus.co/warsaw/en/events"

        Single.fromCallable { Jsoup.connect(url).get() }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            parseHtmlContent(it)
                        },
                        { /*TODO handle errors*/ })
    }


    fun parseHtmlContent(htmlContent: Document) {
        val eventsList = ArrayList<Event>()

        //        val document = Jsoup.parse(htmlContent)
        val events = htmlContent.select("h4")
        events.mapTo(eventsList) { Event(it.text(), "14:00") }

        presentedView.showEvents(eventsList)
    }

}

data class Event(val name: String, val date: String)


/* An instance of this class will be registered as a JavaScript interface */
class MyJavaScriptInterface(private val callback: (String) -> Unit) {

    @JavascriptInterface
    @SuppressWarnings("unused")
    fun processHTML(html: String) {
        callback(html)
    }
}
