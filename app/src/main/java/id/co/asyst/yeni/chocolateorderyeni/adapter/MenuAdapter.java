package id.co.asyst.yeni.chocolateorderyeni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.asyst.yeni.chocolateorderyeni.R;
import id.co.asyst.yeni.chocolateorderyeni.model.Menu;

public class MenuAdapter extends ArrayAdapter<Menu> {
    ArrayList<Menu> listCoklat;

    public MenuAdapter(Context context, ArrayList<Menu> listCoklat) {
        super(context, R.layout.item_menu, listCoklat);

        this.listCoklat = listCoklat;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, null);

        TextView nameTV = rootView.findViewById(R.id.nama_tv);
        TextView menuTV = rootView.findViewById(R.id.menu_tv);
        TextView addressTV = rootView.findViewById(R.id.topping_tv);
        TextView hargaTV = rootView.findViewById(R.id.harga_tv);

        nameTV.setText(listCoklat.get(position).getName());
        menuTV.setText(listCoklat.get(position).getCoklat());
        addressTV.setText(listCoklat.get(position).getTopping());
        hargaTV.setText("" + listCoklat.get(position).getTotalHarga());

        return rootView;
    }
}
