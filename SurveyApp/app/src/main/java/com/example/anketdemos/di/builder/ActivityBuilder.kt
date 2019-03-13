package com.example.anketdemos.di.builder

import com.example.anketdemos.ui.login.LoginActivityModule
import com.example.anketdemos.ui.login.view.LoginActivity
import com.example.anketdemos.ui.main.MainActivityModule
import com.example.anketdemos.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

}