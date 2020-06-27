package com.ashu.searchmovies.di.module

import com.ashu.searchmovies.fragments.HomeFragment
import com.ashu.searchmovies.fragments.MovieDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeMovieDetailsFragment(): MovieDetailsFragment
}