package br.com.seucaioo.testetechfit.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "table_like")
public class Like {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    public Like(String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }

}

