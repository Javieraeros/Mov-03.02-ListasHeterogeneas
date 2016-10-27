package es.iesnervion.fjruiz.mov_0302_listasheterogeneas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Documentación TODO
 */

public class MyArrayAdapter extends ArrayAdapter {
    public MyArrayAdapter(Context context, int resource, int textViewResourceID, Object[] objects) {
        super(context, resource,textViewResourceID, objects);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        View v=convertView;
        ViewHolder holder;

        LolTeam equipo=(LolTeam) getItem(position);

        if(v==null) {

            v=super.getView(position,convertView,parent);
            TextView txt=(TextView) v.findViewById(R.id.texto);
            ImageView icon=(ImageView) v.findViewById(R.id.icon);

            holder=new ViewHolder(v,R.id.texto,R.id.icon);
            v.setTag(holder);
        }else {
            holder=(ViewHolder) v.getTag();
        }
        holder.getLab().setText(equipo.getName());
        holder.getImg().setImageResource(equipo.getIcon());
        return v;
    }

    /**
     * Método que devuelve que tipo de visibilidad va a tener una fila dependiendo
     * de su posición
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int resultado;
        if(position%3==0){
            resultado=0;
        }else if(position%3==1){
            resultado=1;
        }else{
            resultado=2;
        }

        resultado=position%3;

        return resultado;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

}
