package com.example.smtv;
import android.os.Bundle;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import static android.media.session.PlaybackState.ACTION_PLAY;
import static android.media.session.PlaybackState.ACTION_REWIND;

public class DetailsFragment extends DetailsSupportFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildUI();
    }

    private void buildUI(){
        ClassPresenterSelector selector = new ClassPresenterSelector();
        selector.addClassPresenter(DetailsOverviewRow.class,
                new FullWidthDetailsOverviewRowPresenter(
                        new DetailsDescriptionPresenter()
                )
        );
        ArrayObjectAdapter adapter =new ArrayObjectAdapter(selector);
        DetailsOverviewRow detailsOverview = new DetailsOverviewRow("Media Item Details");
        // Add images and action buttons to the details view


        //Add some Actions
        SparseArrayObjectAdapter actionAdapt = new SparseArrayObjectAdapter();
        actionAdapt.set((int)ACTION_PLAY,new Action(1, "Buy $9.99"));
        actionAdapt.set((int)ACTION_REWIND,new Action(2, "Rent $2.99"));
        detailsOverview.setActionsAdapter(actionAdapt);
        adapter.add(detailsOverview);
        setAdapter(adapter);


    }

}




