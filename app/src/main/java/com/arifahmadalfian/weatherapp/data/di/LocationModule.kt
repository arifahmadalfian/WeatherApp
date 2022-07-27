package com.arifahmadalfian.weatherapp.data.di

import com.arifahmadalfian.weatherapp.data.location.DefaultLocationTracker
import com.arifahmadalfian.weatherapp.domain.location.ILocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): ILocationTracker
}