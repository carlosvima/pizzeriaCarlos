package pizzeria.cliente;

import pizzeria.pizza.Ingrediente;
import pizzeria.pizza.Pizza;
import pizzeria.pizza.Pizza.Masa;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Pizzeria {

    static Integer NUM_PEDIDO = 0;
    static HashSet<Cliente> clientes;
    static ArrayList<Ingrediente> ingredientes;
    public static void main(String[] args){
        inicializarClientes();
        inicializarIngredientes();

        System.out.println("------BIENVENIDO A LA PIZZERIA LA PIZZA LOCA---------");
        Scanner scanner = new Scanner(System.in);

        //TODO pedir datos para identificar al cliente, buscar entre los existentes y si no,
        // crear uno nuevo pidiéndole los datos
        System.out.println("Indiquenos su nombre: ");
        String nameCliente=scanner.nextLine();
        Cliente c1 =buscarCliente(nameCliente);
        
        Cliente cliente = clientes.stream().filter(c-> c.getNombre() == "Homer").findFirst().orElse(null);
        if (c1==null){
        	System.out.println("Cliente nuevo!! Bienvenido a nuestra base de datos!!");
        	c1=crearCliente(scanner, nameCliente);
        	clientes.add(c1);
        	
        }

        ArrayList<Pizza> pizzas = new ArrayList<>();

        System.out.println("Indique cuantas pizzas desea pedir: ");
        int numPizzas = scanner.nextInt();
        for (int i=0; i<numPizzas; i++) {
            Pizza pizza = new Pizza();
            //TODO pedir tantas veces como sea necesario el tamaño de la pizza hasta que sea correcto
            System.out.println("Indique el tamaño de la pizza: PEQUEÑA, MEDIANA o GRANDE: ");
            String tamañoPizza = scanner.next();
            Pizza.Tamaño tamaño = convierteTamaño(tamañoPizza);
            pizza.setTamaño(tamaño);

            //TODO pedir el tipo de masa y asociarlo a la pizza
            System.out.println("Que tipo de masa quiere? ");
            String tipoMasa=scanner.next();
            pizza.setMasa(tipoMasa);

            int numIngredientes;
            System.out.println("Indique el número total de ingredientes de la pizza: ");
            numIngredientes = scanner.nextInt();

            for (int j=0; j<numIngredientes; j++) {
                try {
                    System.out.println(MessageFormat.format("Introduzca el nombre del ingrediente {0} entre QUESO JAMON PIÑA TOMATE BACON: ", j));
                    String ingrediente = scanner.next();
                    pizza.getIngredientes().add(buscaIngrediente(ingrediente));
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("El ingrediente introducido no es válido");
                    j--;
                }
            }

           pizzas.add(pizza);
        }
        //Creamos el pedido
        Pedido pedido = new Pedido(NUM_PEDIDO++, cliente, pizzas );
        pedido.calcularPrecio();
        //TODO mejorar el resumen del pedido (Pedido.toString())
        
        System.out.println(pedido.toString());
        // Cleanup
        scanner.close();
    }

   

	/**
	 * @param nameCliente
	 * @return
	 */
	private static String buscarCliente(String nameCliente) {
		for (Cliente cliente : clientes) {
			if (cliente.getNombre().equalsIgnoreCase(nameCliente)) {
				return nameCliente;
			}
		}
		return null;
	}

	private static Ingrediente buscaIngrediente(String ingrediente){
		for (Ingrediente ingrediente2 : ingredientes) {
			String nameIngrediente;
			if (ingrediente.getNombre().equalsIgnoreCase(nameIngrediente)) {
				return ingrediente;
			}
		}
    	for(int i=0;i<ingrediente.length();i++) {
    		
    	}
    	
        return ingredientes.get(0);
    }
    private static Pizza.Tamaño convierteTamaño(String tamañoPizza){
        try{
            String tamañoPizzaUpper = tamañoPizza.toUpperCase();
            return Pizza.Tamaño.valueOf(tamañoPizzaUpper);
        } catch(Exception e){
            e.printStackTrace();
            return Pizza.Tamaño.PEQUEÑA;
        }
    }
    private static void inicializarClientes(){
        clientes = new HashSet<>();
        clientes.add(new Cliente("Maggie", "Simpson", "+7888888888", "Springfield 1"));
        clientes.add(new Cliente("Homer", "Simpson", "+7888888889", "Springfield 2"));
    }
    private static void inicializarIngredientes(){
        ingredientes = new ArrayList<>();
        ingredientes.add(new Ingrediente("QUESO", 0.3));
        ingredientes.add(new Ingrediente("TOMATE", 0.2));
        ingredientes.add(new Ingrediente("JAMON", 0.2));
        ingredientes.add(new Ingrediente("PIÑA", 0.2));
        ingredientes.add(new Ingrediente("BACON", 0.2));
    }
}
