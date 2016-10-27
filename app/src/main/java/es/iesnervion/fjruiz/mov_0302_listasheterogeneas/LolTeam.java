package es.iesnervion.fjruiz.mov_0302_listasheterogeneas;

import android.os.Parcel;
import android.os.Parcelable;

/*************
 * Propiedades
 * ***********
 * Basicas:
 * ID: integer,searchable and modifible
 * Name: String,searchable and modifible
 * Icon: int, searchable and modifible
 * Info: String, searchable and modifible
 * Points: Integer,searchable and modifible
 *
 * Derivadas:
 *
 *
 * Compartidas:
 *
 *
 * Restricciones:
 *
 *
 */

public class LolTeam implements Parcelable {

    private Integer ID;
    private String name;
    private int icon;
    private String info;
    private Integer points;

    public LolTeam(){
        ID=0;
        name="Defecto";
        icon=R.drawable.defecto;
        info="Info por defecto";
        points=0;
    }

    public LolTeam(Integer ID, String name, String info, int icon, Integer points) {
        this.ID = ID;
        this.name = name;
        this.info = info;
        this.icon = icon;
        this.points = points;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                ", info='" + info + '\'' +
                ", points=" + points +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.ID);
        dest.writeString(this.name);
        dest.writeInt(this.icon);
        dest.writeString(this.info);
        dest.writeValue(this.points);
    }

    protected LolTeam(Parcel in) {
        this.ID = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.icon = in.readInt();
        this.info = in.readString();
        this.points = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<LolTeam> CREATOR = new Creator<LolTeam>() {
        @Override
        public LolTeam createFromParcel(Parcel source) {
            return new LolTeam(source);
        }

        @Override
        public LolTeam[] newArray(int size) {
            return new LolTeam[size];
        }
    };
}
