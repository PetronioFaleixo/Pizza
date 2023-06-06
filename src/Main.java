import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzariaOnline pizzaria = new PizzariaOnline();

        // Adicionar sabores ao cardápio
        pizzaria.adicionarPizzaAoCardapio(new Pizza("Calabresa", 30.0));
        pizzaria.adicionarPizzaAoCardapio(new Pizza("Mussarela", 25.0));
        pizzaria.adicionarPizzaAoCardapio(new Pizza("Frango com Catupiry", 35.0));
        // Adicione outros sabores ao cardápio aqui

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo à Pizzaria Faleixo!");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Ver carrinho de compras");
            System.out.println("3. Finalizar pedido");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    pizzaria.mostrarCardapio();
                    System.out.print("Escolha o número do sabor de pizza: ");
                    int saborIndex = scanner.nextInt();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    pizzaria.fazerPedido(saborIndex, quantidade);
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    break;
                case 2:
                    pizzaria.mostrarCarrinho();
                    System.out.print("Deseja remover algum item do carrinho? (S/N): ");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        System.out.print("Digite o número do item: ");
                        int itemIndex = scanner.nextInt();
                        pizzaria.removerItemDoCarrinho(itemIndex);
                        scanner.nextLine(); // Consumir a quebra de linha pendente
                    }
                    break;
                case 3:
                    System.out.print("Digite o endereço de entrega: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o número de telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Selecione o método de pagamento (Dinheiro/Cartão): ");
                    String metodoPagamento = scanner.nextLine();
                    pizzaria.realizarCheckout(endereco, telefone, metodoPagamento);
                    break;
                case 4:
                    System.out.println("Obrigado por usar a Pizzaria Faleixo. Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}