package es.iesnervion.fjruiz.mov_0302_listasheterogeneas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Documentación TODO
 */

public class MyArrayAdapter extends ArrayAdapter {

    public MyArrayAdapter(Context context, int resource, int textViewResourceID, Object[] objects) {
        super(context, resource, textViewResourceID, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        int type = getItemViewType(position);
        LolTeam equipo = (LolTeam) getItem(position);

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            switch (type) {
                case 0:
                    v = inflater.inflate(R.layout.fila, parent, false);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.fila2, parent, false);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.fila3, parent, false);
                    break;
            }

            holder = new ViewHolder(v, R.id.texto, R.id.icon);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.getLab().setText(equipo.getName());
        holder.getImg().setImageResource(equipo.getIcon());
        return v;
    }

    /**
     * Método que devuelve que tipo de visibilidad va a tener una fila dependiendo
     * de su posición
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int resultado;
        /*if(position%3==0){
            resultado=0;
        }else if(position%3==1){
            resultado=1;
        }else{
            resultado=2;
        }*/

        resultado = position % 3;

        return resultado;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

}
