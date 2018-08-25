package dev.com.sfilizzola.waferchallenge.network;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import dev.com.sfilizzola.waferchallenge.networkModels.CountryResponse;
import timber.log.Timber;

public class NetworkTask extends AsyncTask<Void, Void, List<CountryResponse>> {

    private static final String ENDPOINT_ADDRESS = "https://restcountries.eu/rest/v2/all";
    private CharacterTaskCallback mCallback = null;

    public interface CharacterTaskCallback {
        void onFinishWithSuccess(List<CountryResponse> content);
        void onFinishWithError();
    }

    public NetworkTask(CharacterTaskCallback callback) {
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<CountryResponse> doInBackground(Void... args) {

        List<CountryResponse> result;
        URL url = null;
        HttpURLConnection connection = null;

        try{
            url = new URL(ENDPOINT_ADDRESS);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(60000); //about one min.
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(connection.getInputStream());
            Type collectionType = new TypeToken<Collection<CountryResponse>>(){}.getType();
            result = gson.fromJson(reader, collectionType);

        } catch (Exception e){
            Timber.e(e);
            result = null;
        }

        return result;
    }

    @Override
    protected void onPostExecute(List<CountryResponse> result) {
        super.onPostExecute(result);

        if(result != null) {
            mCallback.onFinishWithSuccess(result);
        } else {
            mCallback.onFinishWithError();
        }
    }
}
