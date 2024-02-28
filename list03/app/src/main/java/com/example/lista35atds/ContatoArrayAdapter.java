package com.example.lista35atds;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContatoArrayAdapter extends ArrayAdapter<Contato> {

    private int layout;
    private LayoutInflater layoutInflater;

    public ContatoArrayAdapter(Activity activity, int layout, Contato[] dados) {
        super(activity, layout, dados);
        layoutInflater =
                (LayoutInflater)
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        ViewHolder viewHolder;

        if (row == null) {
            // criar item novo
            row = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txvNome = row.findViewById(R.id.txvNome);
            viewHolder.txvTelefone = row.findViewById(R.id.txvTelefone);
            row.setTag(viewHolder);
        } else {
            // reciclar item
            viewHolder = (ViewHolder) row.getTag();
        }

        Contato contato = getItem(position);
        viewHolder.txvNome.setText(contato.getNome());
        viewHolder.txvTelefone.setText(contato.getTelefone());

        return row;
    }

    class ViewHolder {
        TextView txvNome;
        TextView txvTelefone;
    }
}
