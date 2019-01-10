package br.com.seucaioo.testetechfit;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.seucaioo.testetechfit.api.Client;
import br.com.seucaioo.testetechfit.api.TheCatAPI;
import br.com.seucaioo.testetechfit.model.Image;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ID = BuildConfig.APPLICATION_ID + ".EXTRA_ID";
    public static final String EXTRA_URL = BuildConfig.APPLICATION_ID + ".EXTRA_URL";

    private static final String KEY_LIST_STATE = "list_state";
    private static final String KEY_RECYCLER_LAYOUT = "recycler_layout";

    private Parcelable savedRecyclerLayoutState;
    private ArrayList<Image> imagesInstance = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private ImagesAdapter mImagesAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressBar mProgressBar;
    private ImageView mImageNetwork;
    private TextView mTextNetwork;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImageNetwork = findViewById(R.id.imageNoNetwork);
        mTextNetwork = findViewById(R.id.textNoNetwork);
        mProgressBar = findViewById(R.id.progress);
        mProgressBar.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if (checkNetworkActive()) {
                            if (imagesInstance == null) {
                                setVisibility(View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                                imagesInstance = new ArrayList<>();
                                requestImages();
                            } else {
                                setVisibility(View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                                requestImages();
                            }
                        } else {
                            if (imagesInstance == null || imagesInstance.size() == 0) {
                                setVisibility(View.INVISIBLE, View.VISIBLE, View.VISIBLE);
                            } else {
                                setVisibility(View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                            }
                        }
                    }
                }
        );

        if (savedInstanceState != null) {
            imagesInstance = savedInstanceState.getParcelableArrayList(KEY_LIST_STATE);
            savedRecyclerLayoutState = savedInstanceState.getParcelable(KEY_RECYCLER_LAYOUT);
            if (imagesInstance == null) {
                setVisibility(View.INVISIBLE, View.VISIBLE, View.VISIBLE);
            } else {
                generateImageList();
                if (!checkNetworkActive()) {
                    setVisibility(View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                }
            }
        } else {
            if (checkNetworkActive()) {
                requestImages();
            } else {
                setVisibility(View.INVISIBLE, View.VISIBLE, View.VISIBLE);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (imagesInstance != null && imagesInstance.size() > 0) {
            savedInstanceState.putParcelableArrayList(KEY_LIST_STATE, imagesInstance);
            savedInstanceState.putParcelable(KEY_RECYCLER_LAYOUT,
                    mRecyclerView.getLayoutManager().onSaveInstanceState());
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        imagesInstance = savedInstanceState.getParcelableArrayList(KEY_LIST_STATE);
        savedRecyclerLayoutState = savedInstanceState.getParcelable(KEY_RECYCLER_LAYOUT);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private boolean checkNetworkActive() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm != null ? cm.getActiveNetworkInfo() : null;
        mSwipeRefreshLayout.setRefreshing(false);
        return networkInfo != null && networkInfo.isConnected();
    }

    private void requestImages() {
        TheCatAPI service = Client.getInstance().create(TheCatAPI.class);
        Call<List<Image>> callImages = service.getTenRandomImages();
        callImages.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                imagesInstance.clear();
                List<Image> images = response.body();
                imagesInstance.addAll(images);
                generateImageList();
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {

            }
        });

    }

    private void generateImageList() {
        mImagesAdapter = new ImagesAdapter(this, imagesInstance);
        mRecyclerView = findViewById(R.id.recyclerview);
        int columnCount = getResources().getInteger(R.integer.grid_column_count);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(columnCount, 1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setAdapter(mImagesAdapter);
        setVisibility(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    void setVisibility(int progress, int textNoNet, int imgNoNet) {
        mProgressBar.setVisibility(progress);
        mTextNetwork.setVisibility(textNoNet);
        mImageNetwork.setVisibility(imgNoNet);

    }

}
