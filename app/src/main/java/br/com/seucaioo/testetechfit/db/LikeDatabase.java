package br.com.seucaioo.testetechfit.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Like.class}, version = 1, exportSchema = false)
public abstract class LikeDatabase extends RoomDatabase {

    public abstract LikeDao likeDao();

    private static LikeDatabase INSTANCE;

    public static LikeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LikeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LikeDatabase.class, "like_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
