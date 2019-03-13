package com.example.anketdemos

import android.app.Activity
import android.app.Application
import com.example.anketdemos.di.component.DaggerAppComponent
import com.google.firebase.messaging.FirebaseMessaging
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SurveyApp : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

}