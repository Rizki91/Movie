
package com.fahrul.movie.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieModel implements Serializable, Parcelable
{

    @SerializedName("Search")
    @Expose
    private List<Search> search = null;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("Response")
    @Expose
    private String response;
    public final static Creator<MovieModel> CREATOR = new Creator<MovieModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        public MovieModel[] newArray(int size) {
            return (new MovieModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8635181022082795981L;

    protected MovieModel(Parcel in) {
        in.readList(this.search, (com.fahrul.movie.model.Search.class.getClassLoader()));
        this.totalResults = ((String) in.readValue((String.class.getClassLoader())));
        this.response = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MovieModel() {
    }

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public MovieModel withSearch(List<Search> search) {
        this.search = search;
        return this;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public MovieModel withTotalResults(String totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public MovieModel withResponse(String response) {
        this.response = response;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(search);
        dest.writeValue(totalResults);
        dest.writeValue(response);
    }

    public int describeContents() {
        return  0;
    }

}
