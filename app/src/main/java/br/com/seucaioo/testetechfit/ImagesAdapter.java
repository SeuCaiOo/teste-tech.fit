package br.com.seucaioo.testetechfit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import br.com.seucaioo.testetechfit.db.Like;
import br.com.seucaioo.testetechfit.db.LikeRepository;
import br.com.seucaioo.testetechfit.model.Image;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {

    private final ArrayList<Image> mImageList;
    private final Context mContext;

    public ImagesAdapter(Context context, ArrayList<Image> images) {
        this.mContext = context;
        this.mImageList = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = LayoutInflater.from(mContext)
                .inflate(R.layout.imagelist_item, viewGroup, false);
        return new ImageViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Image currentImage = mImageList.get(i);
        String url = currentImage.getUrl();
        Glide.with(mContext).load(url).into(imageViewHolder.imageItemView);
        LikeRepository repository = new LikeRepository(mContext);
        repository.getById(currentImage.getId());
        int iconLike = repository.liked ?
                R.drawable.ic_like_24dp : R.drawable.ic_like_border_24dp;
        imageViewHolder.iconLike.setImageResource(iconLike);
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageItemView, iconLike;
        ImagesAdapter adapter;

        ImageViewHolder(@NonNull View itemView, ImagesAdapter adapter) {
            super(itemView);
            imageItemView = itemView.findViewById(R.id.imageCat);
            iconLike = itemView.findViewById(R.id.imageLike);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
            iconLike.setOnClickListener(likeImage());
        }

        private View.OnClickListener likeImage() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Image currentImage = mImageList.get(getAdapterPosition());
                    Like imageDB = new Like(currentImage.getId());
                    checkLiked(imageDB.getId(), v, imageDB);
                }
            };
        }

        private void checkLiked(String idImage, View view, Like image) {
            LikeRepository repository = new LikeRepository(mContext);
            repository.getById(idImage);
            if (!repository.liked) {
                likeImage(view, repository, image);
            } else {
                dislikeImage(view, repository, image);
            }
        }

        private void likeImage(View v, LikeRepository repository, Like imageDB) {
            repository.insert(imageDB);
            iconLike.setImageResource(R.drawable.ic_like_24dp);
            messageLike(v, true);
        }

        private void dislikeImage(View v, LikeRepository repository, Like imageDB) {
            repository.delete(imageDB);
            iconLike.setImageResource(R.drawable.ic_like_border_24dp);
            messageLike(v, false);
        }

        @Override
        public void onClick(View v) {
            Image currentImage = mImageList.get(getAdapterPosition());
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(MainActivity.EXTRA_ID, currentImage.getId());
            intent.putExtra(MainActivity.EXTRA_URL, currentImage.getUrl());
            mContext.startActivity(intent);
        }
    }

    private void messageLike(View view, boolean like) {
        String message = like ? mContext.getString(R.string.message_liked_image) :
                mContext.getString(R.string.message_disliked_image);
        message = message.toUpperCase();
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
