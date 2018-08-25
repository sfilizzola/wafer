package dev.com.sfilizzola.waferchallenge.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.com.sfilizzola.waferchallenge.R;
import dev.com.sfilizzola.waferchallenge.networkModels.CountryResponse;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder>{

    List<CountryResponse> countryList;

    public CountryAdapter(List<CountryResponse> countryList) {
        this.countryList = countryList;
    }


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_list_item, viewGroup, false);

        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
            CountryResponse currentItem = countryList.get(position);
            holder.name.setText(currentItem.getName());
            holder.currency.setText(currentItem.getCurrencies().get(0).getName());
            holder.language.setText(currentItem.getLanguages().get(0).getName());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    public void removeItem(int position) {
        countryList.remove(position);
        notifyItemRemoved(position);
    }
}
