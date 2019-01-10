package br.com.seucaioo.testetechfit.db;

import android.content.Context;
import android.os.AsyncTask;

public class LikeRepository {

    private LikeDao mLikeDao;
    public boolean liked;

    public LikeRepository(Context context) {
        LikeDatabase db = LikeDatabase.getDatabase(context);
        this.mLikeDao = db.likeDao();
    }

    public void getById(String idImage) {
        AsyncTask AsyncTask = new getAsyncTask(mLikeDao).execute(idImage);

        try {
            boolean result = (boolean) AsyncTask.get();
            liked = result;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class getAsyncTask extends AsyncTask<String, Void, Boolean> {

        private LikeDao mAsyncTaskDao;

        public getAsyncTask(LikeDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            Like likeById = mAsyncTaskDao.getImageById(strings[0]);
            if (likeById != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void insert(Like like) {
        new insertAsyncTask(mLikeDao).execute(like);
    }

    private static class insertAsyncTask extends AsyncTask<Like, Void, Void> {
        private LikeDao mAsyncTaskDao;

        insertAsyncTask(LikeDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Like... likes) {
            mAsyncTaskDao.insert(likes[0]);
            return null;
        }
    }

    public void delete(Like like) {
        new deleteAsyncTask(mLikeDao).execute(like);
    }

    private static class deleteAsyncTask extends AsyncTask<Like, Void, Void> {
        private LikeDao mAsyncTaskDao;

        deleteAsyncTask(LikeDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Like... likes) {
            mAsyncTaskDao.delete(likes[0]);
            return null;
        }
    }
}
