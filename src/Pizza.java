import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pizza {
    private String sabor;
    private double preco;

    public Pizza(String sabor, double preco) {
        this.sabor = sabor;
        this.preco = preco;
    }

    public String getSabor() {
        return sabor;
    }

    public double getPreco() {
        return preco;
    }
}

class CarrinhoDeCompras {
    private List<Pizza> itens;

    public CarrinhoDeCompras() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Pizza pizza) {
        itens.add(pizza);
    }

    public void removerItem(int index) {
        itens.remove(index);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Pizza pizza : itens) {
            total += pizza.getPreco();
        }
        return total;
    }

    public List<Pizza> getItens() {
        return itens;
    }
}

class PizzariaOnline {
    private List<Pizza> cardapio;
    private CarrinhoDeCompras carrinho;

    public PizzariaOnline() {
        cardapio = new ArrayList<>();
        carrinho = new CarrinhoDeCompras();
    }

    public void adicionarPizzaAoCardapio(Pizza pizza) {
        cardapio.add(pizza);
    }

    public void mostrarCardapio() {
        System.out.println("Cardápio:");
        for (int i = 0; i < cardapio.size(); i++) {
            Pizza pizza = cardapio.get(i);
            System.out.println((i + 1) + ". " + pizza.getSabor() + " - R$" + pizza.getPreco());
        }
    }

    public void fazerPedido(int saborIndex, int quantidade) {
        if (saborIndex < 1 || saborIndex > cardapio.size()) {
            System.out.println("Sabor de pizza inválido.");
            return;
        }

        Pizza pizza = cardapio.get(saborIndex - 1);
        for (int i = 0; i < quantidade; i++) {
            carrinho.adicionarItem(pizza);
        }

        System.out.println("Pedido adicionado ao carrinho.");
    }

    public void mostrarCarrinho() {
        System.out.println("Carrinho de Compras:");
        List<Pizza> itens = carrinho.getItens();
        for (int i = 0; i < itens.size(); i++) {
            Pizza pizza = itens.get(i);
            System.out.println((i + 1) + ". " + pizza.getSabor() + " - R$" + pizza.getPreco());
        }
        System.out.println("Total: R$" + carrinho.calcularTotal());
    }

    public void removerItemDoCarrinho(int index) {
        List<Pizza> itens = carrinho.getItens();
        if (index < 1 || index > itens.size()) {
            System.out.println("Item inválido.");
            return;
        }

        carrinho.removerItem(index - 1);
        System.out.println("Item removido do carrinho.");
    }

    public void realizarCheckout(String endereco, String telefone, String metodoPagamento) {
        double total = carrinho.calcularTotal();
        Random random = new Random();
        int prazoEntrega = random.nextInt(36) + 5; // Gera um número aleatório entre 5 e 40

        System.out.println("Detalhes do pedido:");
        System.out.println("Endereço de entrega: " + endereco);
        System.out.println("Valor total do pedido: R$" + total);
        System.out.println("Prazo de entrega: " + prazoEntrega + " minutos");

        // Lógica para realizar o checkout
        System.out.println("Pedido finalizado. Obrigado pela compra!");
    }
}