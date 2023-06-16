package com.axel.lewebservice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShowRoot {

    @SerializedName("tv_shows")
    private List<TVShow> tvShowList;

    public TVShowRoot(List<TVShow> tvShowList) {
        this.tvShowList = tvShowList;
    }

    public List<TVShow> getTvShowList() {
        return tvShowList;
    }

    public void setTvShowList(List<TVShow> tvShowList) {
        this.tvShowList = tvShowList;
    }
}
