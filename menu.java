import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.function.Consumer;


public class menu {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Vector<Produto> memory = new Vector<>();

   static Consumer<Produto> relatorios = produto -> {
        System.out.println(produto.toString());
    };

    public static void ImprimePrincipal() throws IOException {
        System.out.println("Empresa de importação de produtos LTDA.");
        System.out.println("Sistema de controle de estoque");
        System.out.println("Menu Principal");
        System.out.println("1 - Cadastro de Produtos");
        System.out.println("2 - Movimentacao");
        System.out.println("3 - Reajustes de Preços");
        System.out.println("4 - Relatorios");
        System.out.println("0 - Finalizar");
    }

    public static void ImprimeMenuCadastrodeProdutos() throws IOException {
        System.out.println("Cadastro de Produtos");
        System.out.println("1 - Inclusão");
        System.out.println("2 - Alteração");
        System.out.println("3 - Consulta");
        System.out.println("0 - Retornar");
    }

    public static void ImprimeMenuMovimentacao() throws IOException {
        System.out.println("Movimentacao");
        System.out.println("1 - Entrada");
        System.out.println("2 - Saída");
        System.out.println("0 - Retornar");
    }

    public static void Fluxo() throws Exception{

        // Instanciando BufferedReader

        ImprimePrincipal();
        String options = reader.readLine();
        int OpcaoPrincipal = Integer.parseInt(options);

        while (OpcaoPrincipal != 0) {
            if (OpcaoPrincipal == 0) {
                System.exit(0);
            }

            switch (OpcaoPrincipal) {
                case 1:

                    try {
                        switchsecondmenu();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }

                    break;

                case 2:
                    try {
                        switchmovimentacao();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        reajustarProduct();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("Relatorios");
                    memory.forEach(relatorios);
                    System.out.println("");

                    break;

                default:
                    System.out.println("Opção não encontrada");
                    System.out.println("Pof favor selecione uma opcao valida!");
                    break;

            }
            ImprimePrincipal();
            options = reader.readLine();
            OpcaoPrincipal = Integer.parseInt(options);
        }

    }

    public static void reajustarProduct() throws Exception {
        System.out.println("Reajustes de Preços");
        System.out.println("Digite o nome do produto que deseja alterar o preço");

        String NomeProdutoAlterarPreco = reader.readLine();

        NomeProdutoAlterarPreco = NomeProdutoAlterarPreco.toLowerCase();

        int index = indexOfProduct(NomeProdutoAlterarPreco);

        if(index != -1) {
            System.out.println("Digite um novo Preco: ");
            String novopreco = reader.readLine();
            memory.get(index).setPrice(Double.parseDouble(novopreco));
            System.out.println("Preco alterado com sucesso!");
            System.out.println(memory.get(index).toString());
        }else {
             System.out.println("Nao foi possivel alterar o Preco");
        }
    }

    // segundo menu
    public static void switchsecondmenu() throws Exception {

        boolean iscontinuos;

        do {

            iscontinuos = false;
            ImprimeMenuCadastrodeProdutos();
            String options = reader.readLine();

            switch (options) {
                case "1":
                    // Cadastro de Produto
                    String RepetirOperacaoInclusao = "S";
                    while (RepetirOperacaoInclusao != "N") {
                        System.out.println("Sistema de Controle de Estoque");
                        System.out.println("Inclusao de Produtos");

                        System.out.println("Nome do Produto:");
                        String nomeProduto = reader.readLine();
                        nomeProduto = nomeProduto.toLowerCase();

                        System.out.println("Preco Unitario:");
                        String precoUnitario = reader.readLine();

                        System.out.println("Unidade de Medida: ");
                        String unidademedidad = reader.readLine();

                        System.out.println("Quantidade em Estoque:");
                        String quantidadeEstoque = reader.readLine();

                        System.out.println("Confirma inclusao em estoque? S ou N");
                        String confirmacao = reader.readLine();

                        if (confirmacao.equals("S")) {
                            System.out.println("Produto Incluido com sucesso");

                            // instanciar o product (CREATE)
                            memory.add(new Produto(nomeProduto, Double.parseDouble(precoUnitario), unidademedidad,
                                    Integer.parseInt(quantidadeEstoque)));
                        } else {
                            System.out.println("Produto não foi incluido");
                        }

                        System.out.println("Deseja repetir a operação? S ou N");

                        String repetir = reader.readLine();
                        if (repetir.equals("S")) {
                            RepetirOperacaoInclusao = "S";
                        } else {
                            RepetirOperacaoInclusao = "N";
                            iscontinuos = true;
                        }
                    }
                    break;

                case "2":
                    // Alteracao de produto
                    String RepetirOperacaoAlteracao = "S";
                    while (RepetirOperacaoAlteracao != "N") {
                        System.out.println("Sistema de Controle de Estoque");
                        System.out.println("Alteracao de Produtos");

                        System.out.println("Nome do Produto:");
                        String NomeProduto = reader.readLine();
                        // Caso o produto nao exista, vai ser criado um novo produto, caso ele exista
                        // vai ser alterado, caso nao exista sera imprido que ele nao existe
                        // Primeiro vai exibir os dados do produto, para poder atualizar.

                        System.out.println("Nome do Produto:");
                        String nomeAtualizadoProduto = reader.readLine();
                        nomeAtualizadoProduto = nomeAtualizadoProduto.toLowerCase();

                        System.out.println("Preco Unitario:");
                        String precoAtualizadoUnitario = reader.readLine();

                        System.out.print("Unidade de Medida");
                        String unidademediaAtualizado = reader.readLine();

                        System.out.println("Quantidade em Estoque:");
                        String quantidadeAtualizadoEstoque = reader.readLine();

                        System.out.println("Confirma inclusao em estoque? S ou N");
                        String confirmacaoAtualizacao = reader.readLine();

                        if (confirmacaoAtualizacao.equals("S")) {
                            System.out.println("Produto Alterado com sucesso");
                            // busca pelo nome velho (NomeProduto) e sobrescrever o espaco na memoria com o
                            // novo produto atualizado
                            int index = indexOfProduct(NomeProduto);
                            // "update"
                            memory.add(index,
                                    new Produto(nomeAtualizadoProduto, Double.parseDouble(precoAtualizadoUnitario),
                                        unidademediaAtualizado, Integer.parseInt(quantidadeAtualizadoEstoque)));
                        } else {
                            System.out.println("Produto não foi alterado");
                        }

                        System.out.println("Deseja repetir a operação? S ou N");

                        String repetir = reader.readLine();
                        if (repetir.equals("S")) {
                            RepetirOperacaoAlteracao = "S";
                        } else {
                            RepetirOperacaoAlteracao = "N";
                            iscontinuos = true;
                        }
                    }

                    break;

                case "3":
                    // Vai ler o nome do produto digitado e verificar se ele existe, caso exista vai
                    // mostrar os dados do produto, caso nao exista vai ser imprimido que ele nao
                    // existe
                    System.out.println("Sistema de Controle de Estoque");
                    System.out.println("Consulta de Produtos");

                    String NomeProdutoConsulta = reader.readLine();
                    NomeProdutoConsulta = NomeProdutoConsulta.toLowerCase();

                    int ProdutoExiste = indexOfProduct(NomeProdutoConsulta);

                    if (ProdutoExiste != -1) {
                        System.out.println("Produto encontrado");
                        // Imprime os dados do produto
                        System.out.println(memory.get(ProdutoExiste).toString());
                        iscontinuos = true;
                    } else {
                        System.out.println("Produto nao encontrado");
                        
                    }

                    break;

                case "4":
                    System.out.println("Exclusao");

                    NomeProdutoConsulta = reader.readLine();
                    NomeProdutoConsulta = NomeProdutoConsulta.toLowerCase();

                    ProdutoExiste = indexOfProduct(NomeProdutoConsulta);

                    if (ProdutoExiste != -1) {
                        memory.remove(ProdutoExiste);
                        System.out.println("Produto excluido com sucesso");
                    } else {
                        System.out.println("nao foi possivel excluir");
                    }

                    // jogar error na tela caso o produto nao foi encontrado "nao foi possivel
                    // excluir"

                    break;

                default: // 0
                    // retorna ao menu
                    // prencher a variavel de controle com uma nova repeticao
                    // quebrar a condicional do while
                    System.out.println("Retorna Menu Principal");

                    break;
            }

        } while (iscontinuos);

    }

    public static void switchmovimentacao() throws Exception {

        String opcaoMenu2 = reader.readLine();
        System.out.println("1 - Definir Entrada");
        System.out.println("2 - Definir Saida");

        switch (opcaoMenu2) {
            case "1":
                System.out.println("Digite o nome do produto á ser buscado");
                String NomeProdutoSerBuscado = reader.readLine();
                // validar produto
                NomeProdutoSerBuscado = NomeProdutoSerBuscado.toLowerCase();
                int index = indexOfProduct(NomeProdutoSerBuscado);

                if (index != -1) {
                    System.out.println("Quantidade de produtos atualmente: " + memory.get(index).getQuantityStorage());
                    System.out.println("Quantidade de produtos na entrada: ");
                    //pedir entrada nova quantidade
                    String incremento = reader.readLine(); //validar se esse elemento e negativo
                    memory.get(index).addEstoque(Integer.parseInt(incremento));
                    System.out.println("Quantidade total de produtos: " + memory.get(index).getQuantityStorage());

                }else {
                    System.out.println("Produto nao encontrado");
                }
                // buscar na memory

                // Informacoes do Produto

                break;

            case "2":
                System.out.println("Digite o nome do produto á ser buscado");
                String searchproduct = reader.readLine();
                searchproduct = searchproduct.toLowerCase();
                int indexofproduct = indexOfProduct(searchproduct);
                System.out.println("Index:" + indexofproduct);

                System.out.println("Quantidade de produtos atualmente: ");
                System.out.println("Quantidade de produtos na saida: ");

                String decremento = reader.readLine();
                memory.get(indexofproduct).removerEstoque(Integer.parseInt(decremento));

                System.out.println("Quantidade total de produtos: " + memory.get(indexofproduct).getQuantityStorage());
                
                break;

            default:
                System.out.println("Retornando ao Menu Principal");
                break;
        }

    }

    public static int indexOfProduct(String nameProduct) {

        int index = -1;

        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getName().compareTo(nameProduct) == 0) {
                index = i;
            }
        }
        return index;
    }

}
