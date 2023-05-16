package pizzeria.pizza;

import java.util.ArrayList;

public class Pizza {
    public enum Masa {FINA, ROLLING, GORDA}
    public enum Tamaño {PEQUEÑA, MEDIANA, GRANDE}
    private String nombre;
    private Masa masa;
    private ArrayList<Ingrediente> ingredientes;
    private Tamaño tamaño;

    public Pizza() {
        this.ingredientes = new ArrayList<>();
    }

    public Pizza(String nombre, Masa masa, Tamaño tamaño) {
        this.nombre = nombre;
        this.masa = masa;
        this.tamaño = tamaño;
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (!nombre.equals(pizza.nombre)) return false;
        if (masa != pizza.masa) return false;
        if (!ingredientes.equals(pizza.ingredientes)) return false;
        return tamaño == pizza.tamaño;
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + masa.hashCode();
        result = 31 * result + ingredientes.hashCode();
        result = 31 * result + tamaño.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nombre='" + nombre + '\'' +
                ", masa=" + masa +
                ", ingredientes=" + ingredientes +
                ", tamaño=" + tamaño +
                '}';
    }

	/**
	 * @param tipoMasa
	 */
	public void setMasa(String tipoMasa) {
		// TODO Auto-generated method stub
		
	}
}
