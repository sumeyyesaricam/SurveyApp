package com.example.anketdemos.di.component

import android.app.Application
import com.example.anketdemos.SurveyApp
import com.example.anketdemos.di.builder.ActivityBuilder
import com.example.anketdemos.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ActivityBuilder::class), (AppModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: SurveyApp)

}