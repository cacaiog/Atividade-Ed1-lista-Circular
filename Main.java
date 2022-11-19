
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cadastro turma1 = new Cadastro();
        Cadastro turma2 = new Cadastro();
        Cadastro turma3 = new Cadastro();
        Cadastro turma4 = new Cadastro();

        int op2;
        Cadastro turma = new Cadastro();
        do {
            System.out.print("Qual turma voce deseja manipular?  1 - 2 - 3 - 4 / ou digite 0 para sair: ");

            op2 = sc.nextInt();

            sc.nextLine();

            switch (op2) {

                case 1:
                    manipular(sc, op2, turma1);
                    break;
                case 2:
                    manipular(sc, op2, turma2);
                    break;
                case 3:
                    manipular(sc, op2, turma3);
                    break;

                case 4:
                    manipular(sc, op2, turma4);
                    break;

                case 0:
                    System.out.println("FIM");

                default:

            }

        } while (op2 != 0);

    }

    private static void menu(int op2) {

        System.out.println("1- Cadastrar um novo Aluno na turma " + op2 + "\n2 - Remover um Aluno da turma " + op2
                + "\n3 - Alterar os dados de um Aluno da turma " + op2 + "\n4- Consultar os dados"
                + "de um Aluno da turma " + op2 + "\n5 - Exibir os dados de todos os Alunos da turma " + op2 + "\n"
                + "0 - Sair do Programa\nInforme a opção desejada: ");

    }

    public static void manipular(Scanner sc, int op2, Cadastro turma) {
        int op;
        String matricula;
        do {
            menu(op2);

            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:

                    System.out.print("Informe a matricula do novo aluno da turma " + op2 + ": ");
                    matricula = sc.nextLine();

                    turma.adicionarAlunos(matricula);
                    break;
                case 2:
                     System.out.print("Informe a matricula do aluno a ser removido: ");
                     matricula = sc.nextLine();
                    turma.removerAluno(matricula);
                    break;
                case 3:
                    System.out.print("Informe a matricula do aluno para a alteração " + op2 + ": ");
                    matricula = sc.nextLine();
                    turma.alterarDados(matricula);
                    break;
                case 4:
                    System.out.print("Informe a matricula do cliente a ser consultado " + op2 + ": ");
                    matricula = sc.nextLine();
                    turma.consultarAluno(matricula);
                    break;
                case 5:
                    turma.exibirAlunos();
                    break;
                case 0:
                    System.out.println("Fim");

                    break;
                default:
                    System.err.println("Opção inválida!!");

            }
        } while (false);
    }

}