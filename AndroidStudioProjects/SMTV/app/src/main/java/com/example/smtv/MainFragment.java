package com.example.smtv;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

public class MainFragment extends BrowseSupportFragment implements OnItemViewClickedListener {
    private Object SingleRowView;

    @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);

            setUI();
        }
        private void setUI(){
            setTitle("Supreme Master TV");
            setBrandColor(Color.BLUE);
            loadRows();
            setOnItemViewClickedListener(this::onItemClicked);
        }
        private void loadRows(){
            HeaderItem category1 = new HeaderItem("Live shows");
            HeaderItem category2 = new HeaderItem("Shows");
            ArrayObjectAdapter adapterForRow1 = new ArrayObjectAdapter(new MyPresenter());
            String name;

            adapterForRow1.add(new SingleRowView("Noteworthy News",ResourcesCompat.getDrawable(getResources(), R.drawable.nwn, null)));
            adapterForRow1.add(new SingleRowView("Veggie Elite", ResourcesCompat.getDrawable(getResources(), R.drawable.veg_elite, null)));
            ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
            windowAdapter.add(new ListRow(category1, adapterForRow1));
            setAdapter(windowAdapter);

    }

    @Override
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder1, Row row) {

        Intent intent = new Intent(getActivity(),DetailsActivity.class);

        startActivity(intent);


    }
        private class MyPresenter extends Presenter{
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup viewGroup){
                ImageCardView icv = new ImageCardView(viewGroup.getContext());
                icv.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA);
                icv.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ACTIVATED);
                icv.setScrollBarSize(3);
                return new ViewHolder(icv);
            }
            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object object){
                SingleRowView srv = (SingleRowView) object;
                ImageCardView icv = ((ImageCardView)viewHolder.view);
                icv.setMainImage(srv.getImage());
                icv.setTitleText(srv.getName());

                icv.setScrollBarSize(3);
                icv.setContentText("Movie description..");
            }
            @Override
            public void onUnbindViewHolder(ViewHolder viewHolder) {
            }
        }
}
