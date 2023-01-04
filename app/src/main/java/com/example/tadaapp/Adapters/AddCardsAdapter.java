package com.example.tadaapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.R;

import java.util.ArrayList;
import java.util.List;

public class AddCardsAdapter extends RecyclerView.Adapter<AddCardsAdapter.AddCardsViewHolder>
{
    private List<CreditCards> creditCards=new ArrayList<>();

    public void setCreditCards(List<CreditCards> creditCards) {
        this.creditCards = creditCards;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddCardsAdapter.AddCardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.add_new_card_layout,parent,false);
        return new AddCardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddCardsAdapter.AddCardsViewHolder holder, int position) {
        CreditCards currentCard=creditCards.get(position);

        String num=String.valueOf(currentCard.getCard_number());
        holder.dynamictv.setText(num);
    }

    @Override
    public int getItemCount() {
        return creditCards.size();
    }

    public class AddCardsViewHolder extends RecyclerView.ViewHolder {

        TextView dynamictv;
        public AddCardsViewHolder(@NonNull View itemView) {
            super(itemView);
            dynamictv=itemView.findViewById(R.id.dynamictv);
        }
    }
}
