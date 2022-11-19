import java.util.Scanner;

public class Cadastro {

    private LdeCircular<Aluno> alLista;


    public Cadastro() {
        this.alLista = new LdeCircular();
    }


    Aluno al;
    Scanner sc = new Scanner(System.in);

    public void adicionarAlunos(String matricula){
        al = new Aluno(matricula, "", 0.0, 0);
        Node<Aluno> result = alLista.buscar(al);
        if(result == null){
            String nome;
            System.out.print("Informe o nome: ");
            nome = sc.nextLine();
            al = new Aluno(matricula, nome, 0, 0);
            alLista.inserir(al);

            System.out.println("Aluno cadastrado com sucesso!");
        }else {

            System.err.println("Essa matricula já se encontra cadastrado!");

        }

    }




    public void alterarDados(String matricula){
        Aluno aluno = new Aluno(matricula);
        Node<Aluno> result = alLista.buscar(aluno);
        Aluno aux;

        if (result != null){
            int op;
            double m;
            int f;
            do {
                menu();
                op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        System.out.print("Informe o nova media: ");
                        m = sc.nextDouble();
                        aux = result.getInfo();
                        aux.setMedia(m);

                        break;
                    case 2:
                        System.out.print("Informe o nova falta ");
                        f = sc.nextInt();
                        aux = result.getInfo();
                        aux.setFaltas(f);
                        break;

                    case 0:

                        System.out.println("Operação Encerrada!!");

                        break;
                    default:

                        System.err.println("Opção inválida!");

                }
            } while (op != 1 && op!= 2 && op!= 0);

        } else {
            System.out.println("Aluno não encontrado");
        }

    }

    public void removerAluno(String matricula){
        al = new Aluno(matricula, "", 0.0, 0);
        Node<Aluno> result = alLista.buscar(al);

        if(result != null){
            alLista.removerComMatricula(al);
        } else {
            System.err.println("Aluno não encontrado");
        }
        


    }





    private void menu() {
        System.out.println("Escolha uma opção de alteração\n1 - Média "
                + "\n2 - faltas \nInforme a opção: ");
    }






    public void listarAluno(){
        alLista.exibir();
    }


    public void consultarAluno(String matricula) {
        Aluno achou;
        al = new Aluno(matricula, "", 0.0, 0);
        achou = alLista.buscarCliente(al);
        if (achou == null) {
            System.out.println("=======================================");
            System.err.println("Cliente não encontrado!");
            System.out.println("=======================================");
        } else {
            System.out.println(achou.toString());
        }
    }


    public void exibirAlunos(){
        alLista.exibir();
    }














}
