package com.ashu.searchmovies.di.module

import com.ashu.searchmovies.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindActivityMain(): MainActivity
}