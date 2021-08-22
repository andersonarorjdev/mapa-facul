import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class menu {
    
    public static void imprimeMenu() throws IOException {
        System.out.println("Empresa de importação de produtos LTDA.");
        System.out.println("Sistema de controle de estoque");
        System.out.println("Menu Principal");

        System.out.println("1 - Cadastro de Produtos");
        System.out.println("2 - Movimentacao");
        System.out.println("3 - Reajustes de Preços");
        System.out.println("4 - Relatorios");
        System.out.println("0 - Finalizar");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String options = reader.readLine();

        switch (options) {
            case "1":
             System.out.println("Cadastro de Produtos");
             System.out.println("1 - Inclusão");
             System.out.println("2 - Alteração");
             System.out.println("3 - Consulta");
             System.out.println("0 - Retornar");
 
             String opcaoMenu1 = reader.readLine();
 
            switch (opcaoMenu1) {

                 case "1":
                     System.out.println("Sistema de Controle de Estoque");
                     System.out.println("Inclusao de Produtos");
 
                     System.out.println("Nome do Produto:");
                     String nomeProduto = reader.readLine();
 
                     System.out.println("Preco Unitario:");
                     String precoUnitario = reader.readLine();
 
                     System.out.println("Quantidade em Estoque:");
                     String quantidadeEstoque = reader.readLine();
 
                     System.out.println("Confirma inclusao em estoque? S ou N");
                     String confirmacao = reader.readLine();
 
                         if (confirmacao.equals("S")) {
                             System.out.println("Produto Incluido com sucesso");
                         } else {
                             System.out.println("Produto não foi incluido");
                         }
 
                         System.out.println("Deseja repetir a operação? S ou N");

                         String  repetir = reader.readLine();
                         if (repetir.equals("S")) {
                             //Vai repetir a operacao
                         }else{
                             //vai voltar par o menu principal
                         }
 
                 break;
 
                 case "2":
                     System.out.println("Sistema de Controle de Estoque");
                     System.out.println("Alteracao de Produtos");
 
                     System.out.println("Nome do Produto:");
                     String NomeProduto = reader.readLine();
                     //Caso o produto nao exista, vai ser criado um novo produto, caso ele exista vai ser alterado, caso nao exista sera imprido que ele nao existe
                     //Primeiro vai exibir os dados do produto, para poder atualizar.

                     System.out.println("Nome do Produto:");
                     String nomeAtualizadoProduto = reader.readLine();
 
                     System.out.println("Preco Unitario:");
                     String precoAtualizadoUnitario = reader.readLine();
 
                     System.out.println("Quantidade em Estoque:");
                     String quantidadeAtualizadoEstoque = reader.readLine();
 
                     System.out.println("Confirma inclusao em estoque? S ou N");
                     String confirmacaoAtualizacao = reader.readLine();


                break;
                

                case "3":
                //Vai ler o nome do produto digitado e verificar se ele existe, caso exista vai mostrar os dados do produto, caso nao exista vai ser imprimido que ele nao existe
                    System.out.println("Sistema de Controle de Estoque");
                    System.out.println("Consulta de Produtos");

                    String NomeProdutoConsulta = reader.readLine();

                    boolean ProdutoExiste = false;

                    if(ProdutoExiste){
                        System.out.println("Produto encontrado");
                        //Imprime os dados do produto
                    }else{
                        System.out.println("Produto nao encontrado");
                    }

                break;

                case "4":
                    System.out.println("Retornar menu");
                break;
            }
             break;
            

             case "2":
                System.out.println("Movimentacao");
                System.out.println("1 - Entrada");
                System.out.println("2 - Saída");
                System.out.println("0 - Retornar");

                String opcaoMenu2 = reader.readLine();
                while(opcaoMenu2 != "0"){
                    switch (opcaoMenu2) {
                        case "1":
                            System.out.println("Digite o nome do produto á ser buscado");
                            String NomeProdutoSerBuscado = reader.readLine();

                            //Vai imprimir quantas vezes esse produto foi inserido na estoque(entrada),
                            //Vai imprimir a quantidade atual desse produto no estoque.
                            //vai imprimir a quantidade final atual + entrada.
                            System.out.println("Quantidade de produtos atualmente: ");
                            System.out.println("Quantidade de produtos na entrada: ");
                            System.out.println("Quantidade total de produtos:");

                        break;

                        case "2":
                            System.out.println("Digite o nome do produto á ser buscado");
                            
                    }
                }

             break;
            

             case "3":
             System.out.println("Reajustes de Preços");
             break;
            

             case "4":
             System.out.println("Relatorios");
             break;
             

             case "0":
             System.out.println("Finalizar");
             break;
        }
       
    }    
}
