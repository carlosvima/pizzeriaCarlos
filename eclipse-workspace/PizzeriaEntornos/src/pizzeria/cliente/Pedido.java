package pizzeria.cliente;

import pizzeria.pizza.Ingrediente;
import pizzeria.pizza.Pizza;

import java.util.ArrayList;

public class Pedido {
    Integer id;
    Cliente cliente;
    ArrayList<Pizza> pizzas;
    double precio = 0;

    double PRECIO_PIZZA_PEQUEÑA = 6;
    double PRECIO_PIZZA_MEDIANA = 8;
    double PRECIO_PIZZA_GRANDE = 10;

    public Pedido(){

    }

    public Pedido(Integer id, Cliente cliente, ArrayList<Pizza> pizzas) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void calcularPrecio() {
        //TODO incluir en los cálculos de precio una variación según el tipo de masa
        for (Pizza pizza : getPizzas()) {
            precio+= pizza.getTamaño() == Pizza.Tamaño.PEQUEÑA ? PRECIO_PIZZA_PEQUEÑA : pizza.getTamaño() == Pizza.Tamaño.MEDIANA ? PRECIO_PIZZA_MEDIANA : PRECIO_PIZZA_GRANDE;
            for (Ingrediente ingrediente : pizza.getIngredientes()) {
                precio += ingrediente.getPrecio();
            }
        }
    }

    public double getPrecio() {
        calcularPrecio();
        return precio;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", pizzas=" + pizzas +
                ", precio=" + precio +
                '}';
    }

	
}
