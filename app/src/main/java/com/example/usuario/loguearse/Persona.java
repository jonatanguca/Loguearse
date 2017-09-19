package com.example.usuario.loguearse;

import android.os.Parcel;
import android.os.Parcelable;


public class Persona implements Parcelable {
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String direccion;

    public Persona(String nombre, String apellidos, Integer edad, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;

        Persona persona = (Persona) o;

        if (getNombre() != null ? !getNombre().equals(persona.getNombre()) : persona.getNombre() != null)
            return false;
        if (getApellidos() != null ? !getApellidos().equals(persona.getApellidos()) : persona.getApellidos() != null)
            return false;
        if (getEdad() != null ? !getEdad().equals(persona.getEdad()) : persona.getEdad() != null)
            return false;
        return getDireccion() != null ? getDireccion().equals(persona.getDireccion()) : persona.getDireccion() == null;

    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getApellidos() != null ? getApellidos().hashCode() : 0);
        result = 31 * result + (getEdad() != null ? getEdad().hashCode() : 0);
        result = 31 * result + (getDireccion() != null ? getDireccion().hashCode() : 0);
        return result;
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {

        @Override
        public Persona createFromParcel(Parcel parcel) {
            return new Persona(parcel);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public Persona() {

    }

    public Persona(Parcel parcel) {
        nombre = parcel.readString();
        apellidos = parcel.readString();
        edad = parcel.readInt();
        direccion = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeInt(edad);
        dest.writeString(direccion);
    }
}
