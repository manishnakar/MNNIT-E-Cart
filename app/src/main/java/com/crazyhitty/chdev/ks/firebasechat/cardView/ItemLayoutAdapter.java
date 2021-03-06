package com.crazyhitty.chdev.ks.firebasechat.cardView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.firebasechat.R;
import com.crazyhitty.chdev.ks.firebasechat.gridView.DetailsGridLayout;

import java.util.ArrayList;

/**
 * Created by sushant oberoi on 02-09-2017.
 */

public class ItemLayoutAdapter extends RecyclerView.Adapter<ItemLayoutAdapter.ItemLayoutViewHolder> {
    ArrayList<ItemLayout> itemLayouts = new ArrayList<ItemLayout>();
    public ItemLayoutAdapter(ArrayList<ItemLayout> itemLayouts){
        this.itemLayouts = itemLayouts;
    }
    @Override
    public ItemLayoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_view, parent, false);
        ItemLayoutViewHolder itemLayoutViewHolder = new ItemLayoutViewHolder(view);
        return itemLayoutViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemLayoutViewHolder holder, int position) {
        ItemLayoutViewHolder.itemPosition  = position;
        /*holder.item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), BookDescription.class));
            }
        });*/
        ItemLayout ITEM = itemLayouts.get(position);

        holder.description.setText(ITEM.getDescription());

    }

    @Override
    public int getItemCount() {
        return itemLayouts.size();
    }
    public static class ItemLayoutViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        static int itemPosition;
        public ItemLayoutViewHolder(final View itemView) {
            super(itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();
                    CardViewActivity.val=CardViewActivity.items.get(pos).getDescription();
                    for(int i=0;i<100;i++)
                        System.out.println(CardViewActivity.val);
                    Intent intent=new Intent(view.getContext(), DetailsGridLayout.class);
                    view.getContext().startActivity(intent);
                //    Intent i = new Intent(view.getContext(), SingleBookDisplayActivity.class);
                //    i.putExtra("itemPosition", pos);


                //    view.getContext().startActivity(i);
                }
            });

            description =(TextView)itemView.findViewById(R.id.home_description);
        }
    }
}
