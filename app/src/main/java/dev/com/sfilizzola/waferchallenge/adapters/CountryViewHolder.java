package dev.com.sfilizzola.waferchallenge.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dev.com.sfilizzola.waferchallenge.R;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    public TextView name, currency, language;
    public ConstraintLayout viewBackground, viewForeground;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.country_name);
        currency = itemView.findViewById(R.id.country_currency);
        language = itemView.findViewById(R.id.country_language);
        viewBackground = itemView.findViewById(R.id.view_background);
        viewForeground = itemView.findViewById(R.id.view_foreground);
    }
}
