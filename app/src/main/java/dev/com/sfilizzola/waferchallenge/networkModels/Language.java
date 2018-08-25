package dev.com.sfilizzola.waferchallenge.networkModels;

public class Language
{
    private String iso639_1;

    public String getIso6391() { return this.iso639_1; }

    public void setIso6391(String iso639_1) { this.iso639_1 = iso639_1; }

    private String iso639_2;

    public String getIso6392() { return this.iso639_2; }

    public void setIso6392(String iso639_2) { this.iso639_2 = iso639_2; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String nativeName;

    public String getNativeName() { return this.nativeName; }

    public void setNativeName(String nativeName) { this.nativeName = nativeName; }
}
