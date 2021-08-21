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
                     String nomeProduto2 = reader.readLine();
 
             }
 
             break;
 
             case "2":
             System.out.println("Movimentacao");
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
