package br.com.seucaioo.testetechfit.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface LikeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Like like);

    @Delete
    void delete(Like like);

    @Query("SELECT * FROM table_like WHERE id LIKE :idImage")
    Like getImageById(String idImage);


}
