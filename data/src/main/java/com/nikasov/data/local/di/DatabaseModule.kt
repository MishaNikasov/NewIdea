package com.nikasov.data.local.di

import android.content.Context
import androidx.room.Room
import com.nikasov.data.local.dao.*
import com.nikasov.data.local.database.IdeaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room
            .databaseBuilder(context, IdeaDatabase::class.java, "idea_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideSessionDao(db: IdeaDatabase): SessionDao = db.sessionDao

    @Singleton
    @Provides
    fun provideAdviceDao(db: IdeaDatabase): AdviceDao = db.adviceDao

    @Singleton
    @Provides
    fun provideSessionAndAdviceDao(db: IdeaDatabase): SessionAndAdviceDao = db.sessionAndAdviceDao

    @Singleton
    @Provides
    fun provideFavoriteDao(db: IdeaDatabase): FavoriteDao = db.favoriteDao

    @Singleton
    @Provides
    fun provideFavoriteAndAdviceDao(db: IdeaDatabase): FavoriteAndAdviceDao = db.favoriteAndAdviceDao

}