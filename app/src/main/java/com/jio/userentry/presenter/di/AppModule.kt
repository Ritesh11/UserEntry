package com.jio.userentry.presenter.di

import android.app.Application
import androidx.room.Room
import com.jio.userentry.data.UserRepository
import com.jio.userentry.data.UserRepositoryImpl
import com.jio.userentry.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app, UserDatabase::class.java,
            "user_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUserRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }
}