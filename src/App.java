import java.util.Scanner;
import model.Hospede;

public class App {
    public static void main(String[] args) throws Exception {
        Hospede[] hospedes = new Hospede[100];
        Scanner scanner = new Scanner(System.in);
        String nome;
        String email;
        int numQuarto;
        byte opt = 0;


        while(opt != 6){
            System.out.println("|\tSISTEMA\t|\n1 - Adicionar Reserva\n2 - Lista de Reservas\n3 - Consultar Hóspede\n4 - Editar Hóspede\n5 - Cancelar Reserva\n6 - Sair do Sistema\n\n");
            opt = scanner.nextByte();
            scanner.nextLine(); // Clear Buffer
            switch(opt){
                case 1:
                    System.out.println("Digite o nome do hóspede: ");
                    nome = scanner.nextLine();
                    System.out.println("Digite o email do hóspede: ");
                    email = scanner.nextLine();

                    System.out.println("Digite o número do quarto: ");
                    numQuarto = scanner.nextInt() - 1;
                    
                    // Verificador de Entrada | Integridade dos dados
                    while(numQuarto < 0 || numQuarto >= 100 ){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 100!\n");
                        numQuarto = scanner.nextInt() - 1;
                    }

                    if(hospedes[numQuarto] == null){
                        hospedes[numQuarto] = new Hospede(nome, email);

                        System.out.println("Reserva realizada com sucesso!");
                    } else
                        System.out.println("O quarto número " + (numQuarto+1) + " está ocupado!");
                    break;

                case 2:

                    System.out.println("|\tNome\t|\tQuarto\t|\tReservado\t");
                    System.out.println("--------------------------------------------------------------");
                    for(int i = 0; i < 100; i++)
                        System.out.println("|\t"+(hospedes[i] == null ? "" : hospedes[i].getNome())+"\t|\t"+(i+1)+"\t|\t"+(hospedes[i] != null ? "Ocupado" : "Disponível")+"\t");
                    break;

                case 3:

                    System.out.println("Digite o número do quarto: ");
                    numQuarto = scanner.nextInt() - 1;

                    while(numQuarto < 0 || numQuarto >= 100 ){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 100!\n");
                        numQuarto = scanner.nextInt() - 1;
                    }

                    System.out.println("Hóspede: " + (hospedes[numQuarto] == null ? "" : hospedes[numQuarto].getNome())+"\nEmail: " + (hospedes[numQuarto] == null ? "" : hospedes[numQuarto].getEmail())+ "\nStatus: " + (hospedes[numQuarto] != null ? "Ocupado" : "Disponível"));
                    break;
                case 4:
                    System.out.println("Digite o número do quarto: ");
                    numQuarto = scanner.nextInt() - 1;

                    while(numQuarto < 0 || numQuarto >= 100 ){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 100!\n");
                        numQuarto = scanner.nextInt() - 1;
                    }

                    if(hospedes[numQuarto] != null){
                        System.out.println("O que deseja fazer?\n1 - Mudar Quarto do Hóspede\n2 - Mudar Nome do Hóspede\n3 - Mudar email do Hóspede\nQualquer outro número - Sair\n");
                        opt = scanner.nextByte();
                        scanner.nextLine(); // Clear Buffer

                        if(opt == 1){
                            int OldnumQuarto = numQuarto;
                            System.out.println("Digite o novo número do quarto: ");
                            numQuarto = scanner.nextInt() - 1;
                            if(hospedes[numQuarto] == null){
                                hospedes[numQuarto] = hospedes[OldnumQuarto];
                                hospedes[OldnumQuarto] = null;
                                System.out.println("Mudança realizada com sucesso!");
                            } else
                                System.out.println("O quarto número " + (numQuarto+1) + " está ocupado!");
                        } else if (opt == 2){
                            System.out.println("Digite o novo nome do hóspede: ");
                            nome = scanner.nextLine();
                            hospedes[numQuarto].setNome(nome);
                        } else if (opt == 3){
                            System.out.println("Digite o novo email do hóspede: ");
                            email = scanner.nextLine();
                            hospedes[numQuarto].setEmail(email);
                        }
                    } else 
                        System.out.println("O quarto está disponível! Não há nada para ser alterado!");
                    break;
                case 5:
                    System.out.println("Digite o número do quarto: ");
                    numQuarto = scanner.nextInt() - 1;
                    while(numQuarto < 0 || numQuarto >= 100 ){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 100!\n");
                        numQuarto = scanner.nextInt() - 1;
                    }
                    hospedes[numQuarto] = null;
                    break;
                case 6:
                    System.out.println("SISTEMA FECHADO");
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
            }
        }
    }
}