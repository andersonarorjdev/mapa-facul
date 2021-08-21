import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class app {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Empresa de importação de produtos LTDA.");
        System.out.println("Sistema de controle de estoque");
        System.out.println("Menu Principal");

        System.out.println("1 - Cadastro de Produtos");
        System.out.println("2 - Movimentacao");
        System.out.println("3 - Reajustes de Preços");
        System.out.println("4 - Relatorios");
        System.out.println("0 - Finalizar");

        String name = reader.readLine();
       
       switch (name) {
           case "1":
            System.out.println("Cadastro de Produtos");
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
