
package com.fahrul.movie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchList implements Serializable, Parcelable
{

    @SerializedName("Search")
    @Expose
    private List<Search> search = new ArrayList<Search>();
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("Response")
    @Expose
    private String response;
    public final static Creator<SearchList> CREATOR = new Creator<SearchList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchList createFromParcel(Parcel in) {
            return new SearchList(in);
        }

        public SearchList[] newArray(int size) {
            return (new SearchList[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5771221876862645056L;

    protected SearchList(Parcel in) {
        in.readList(this.search, (Search.class.getClassLoader()));
        this.totalResults = ((String) in.readValue((String.class.getClassLoader())));
        this.response = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SearchList() {
    }

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public SearchList withSearch(List<Search> search) {
        this.search = search;
        return this;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public SearchList withTotalResults(String totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public SearchList withResponse(String response) {
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
