package br.com.seucaioo.testetechfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView mIdImage, mUrlImage;
    private ImageView mImage;

    private String mUrl, mId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mIdImage = findViewById(R.id.textId);
        mUrlImage = findViewById(R.id.textUrl);
        mImage = findViewById(R.id.imageView);

        mId = getIntent().getStringExtra(MainActivity.EXTRA_ID);
        mUrl = getIntent().getStringExtra(MainActivity.EXTRA_URL);
        mIdImage.setText(mId);
        mUrlImage.setText(mUrl);
        Glide.with(this).load(mUrl).into(mImage);

        registerForContextMenu(mUrlImage);
    }

    public void openImage() {
        String url = getIntent().getStringExtra(MainActivity.EXTRA_URL);
        Uri imageUrl = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, imageUrl);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void shareImageUrl() {
        String url = getIntent().getStringExtra(MainActivity.EXTRA_URL);
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_image_url)
                .setText(url)
                .startChooser();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_open:
                openImage();
                return true;
            case R.id.context_share:
                shareImageUrl();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
