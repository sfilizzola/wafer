package dev.com.sfilizzola.waferchallenge.networkModels;

import java.io.Serializable;
import java.util.ArrayList;

public class CountryResponse implements Serializable{
    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private ArrayList<Currency> currencies;

    public ArrayList<Currency> getCurrencies() { return this.currencies; }

    public void setCurrencies(ArrayList<Currency> currencies) { this.currencies = currencies; }

    private ArrayList<Language> languages;

    public ArrayList<Language> getLanguages() { return this.languages; }

    public void setLanguages(ArrayList<Language> languages) { this.languages = languages; }

}

