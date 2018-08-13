package id.co.asyst.yeni.chocolateorderyeni.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
    String name;
    String coklat;
    String topping;
    int totalHarga;

    public Menu(String name, String coklat, String topping, int totalHarga) {
        this.name = name;
        this.coklat = coklat;
        this.topping = topping;
        this.totalHarga = totalHarga;
    }

    protected Menu(Parcel in) {
        name = in.readString();
        coklat = in.readString();
        topping = in.readString();
        totalHarga = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoklat() {
        return coklat;
    }

    public void setCoklat(String coklat) {
        this.coklat = coklat;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(coklat);
        dest.writeString(topping);
        dest.writeInt(totalHarga);
    }
}
