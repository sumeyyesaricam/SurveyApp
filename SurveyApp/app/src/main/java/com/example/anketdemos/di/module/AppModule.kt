package com.example.anketdemos.di.module

import android.app.Application
import android.content.Context
import com.example.anketdemos.data.api.ApiHelper
import com.example.anketdemos.data.api.AppApiHelper
import com.example.anketdemos.util.AppConstants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.sumeyye.projetakip.data.preferences.AppPreferenceHelper
import com.sumeyye.projetakip.data.preferences.PreferenceHelper
import com.sumeyye.projetakip.di.scope.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    internal fun provideFirebaseFirestore(): FirebaseFirestore =  FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @PreferenceInfo
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME
}