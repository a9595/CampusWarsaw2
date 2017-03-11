package com.tieorange.campuswarsaw2.presentation.common

import android.content.SharedPreferences

import java.util.concurrent.Callable

import io.reactivex.Observable

/**
 * Created by andrii.kovalchuk on 3/11/17.
 */

class HtmlParser {
    internal fun wipeContents(sharedPreferences: SharedPreferences): Observable<Boolean> {
        return Observable.fromCallable { sharedPreferences.edit().clear().commit() }
    }
}
