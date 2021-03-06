package dev.com.sfilizzola.waferchallenge;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import dev.com.sfilizzola.waferchallenge.adapters.CountryAdapter;
import dev.com.sfilizzola.waferchallenge.adapters.CountryViewHolder;
import dev.com.sfilizzola.waferchallenge.network.NetworkTask;
import dev.com.sfilizzola.waferchallenge.networkModels.CountryResponse;
import dev.com.sfilizzola.waferchallenge.utils.RecyclerItemTouchHelper;

public class MainActivity extends AppCompatActivity implements NetworkTask.CharacterTaskCallback, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private ProgressBar listProgress;
    private RecyclerView listRecycler;
    private List<CountryResponse> currentList;
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startLayoutElements();


        startAsync();
    }

    private void startAsync() {
        showLoading(true);
        NetworkTask task = new NetworkTask(this);
        task.execute();
    }

    private void startLayoutElements() {
        listProgress = findViewById(R.id.progress_countries);
        listRecycler = findViewById(R.id.list_countries);
    }

    @Override
    public void onFinishWithSuccess(List<CountryResponse> content) {
        showLoading(false);
        initList(content);
    }

    @Override
    public void onFinishWithError() {
        showLoading(false);
        Snackbar alert = Snackbar.make(findViewById(R.id.main_list), "Error from Network", Snackbar.LENGTH_INDEFINITE);

        alert.setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsync();
            }
        });

        alert.setActionTextColor(getResources().getColor(R.color.colorAccent));
        alert.show();
    }

    private void initList(List<CountryResponse> result) {
        currentList = result;
        listRecycler.setLayoutManager(new LinearLayoutManager(this));

        if (result != null){
            List<CountryResponse> currentCountries = result;

            adapter = new CountryAdapter(currentCountries);
            listRecycler.setItemAnimator(new DefaultItemAnimator());
            listRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            listRecycler.setAdapter(adapter);

            ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
            new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(listRecycler);

        }
    }

    private void showLoading(boolean show) {
        listProgress.setVisibility(show ? View.VISIBLE : View.GONE);
        listRecycler.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CountryViewHolder) {

            String name = currentList.get(viewHolder.getAdapterPosition()).getName();
            final CountryResponse deletedItem = currentList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();
            adapter.removeItem(viewHolder.getAdapterPosition());
            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.main_list), name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
            snackbar.show();
        }
    }
}
