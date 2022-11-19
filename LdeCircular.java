


public class LdeCircular<T extends Comparable<T>> {

    private Node<T> primeiro;
    private Node<T> ultimo;
    private int qtd;


    public boolean isEmpty() {
        if (this.qtd == 0) {
            return true;
        }
        else {
            return false;
        }
    }



    public void inserir (T valor) {
        Node<T> novo = new Node(valor);
        Node<T> aux, anterior;
        if (this.isEmpty() == true) { // inserir na lista vazia
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
            this.primeiro.setAntes(novo);
            this.ultimo.setProx(novo);
        }
        else if (valor.compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro
            novo.setProx(this.primeiro);
            this.primeiro.setAntes(novo);
            this.primeiro= novo;
            this.qtd++;
            this.primeiro.setAntes(this.ultimo);
            this.ultimo.setProx(this.primeiro);
        }
        else if (valor.compareTo(this.primeiro.getInfo()) == 0) {
            System.out.println("Valor repetido. Inserção não efetuada!");
        }
        else if (valor.compareTo(this.ultimo.getInfo()) > 0) { // inserir depois do último
            this.ultimo.setProx(novo);
            novo.setAntes(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
            this.primeiro.setAntes(this.ultimo);
            this.ultimo.setProx(this.primeiro);
        }
        else if (valor.compareTo(this.ultimo.getInfo()) == 0) {
            System.out.println("Valor repetido. Inserção não efetuada!");
        }
        else {
            aux = this.primeiro.getProx();
            while (true){
                if (valor.compareTo(aux.getInfo()) == 0) {
                    System.out.println("Valor repetido. Inserção não efetuada!");
                    break;
                }
                else if (valor.compareTo(aux.getInfo()) < 0) { // achei local de inserção
                    anterior = aux.getAntes();
                    anterior.setProx(novo);
                    aux.setAntes(novo);
                    novo.setProx(aux);
                    novo.setAntes(anterior);
                    this.qtd++;
                    break;
                }
                else {
                    aux = aux.getProx();
                }
            }
        }
    }


    public void  removerComMatricula (T valor){
        Node <T> resultado = this.buscar(valor);
        Node<T> proximo, anterior;

        if (resultado == null) {
            System.out.println("matricula não encontrado");

        }
        else if (this.qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.qtd--;

        }
        else if (this.primeiro == resultado) {
            this.primeiro = this.primeiro.getProx();
            this.primeiro.setAntes(null);
            this.qtd--;
            this.primeiro.setAntes(this.ultimo);
            this.ultimo.setProx(this.primeiro);

        }else if (this.ultimo == resultado) {
            this.ultimo = this.primeiro.getAntes();
            this.ultimo.setProx(null);
            this.qtd--;
            this.primeiro.setAntes(this.ultimo);
            this.ultimo.setProx(this.primeiro);

        }
        else{
            proximo = resultado.getProx();
            anterior = resultado.getAntes();
            anterior.setProx(proximo);
            proximo.setAntes(anterior);
            this.qtd--;

        }
    }







    public Node<T> buscar (T valor) { // busca sequencial melhorada
        Node<T> aux;
        if (this.isEmpty() == true) {
            return null;
        }
        else if (valor.compareTo(this.ultimo.getInfo()) == 0) {
            return this.ultimo;
        }
        else if (valor.compareTo(this.ultimo.getInfo()) > 0) {
            return null;
        }
        else {
            aux = this.primeiro;
            while (aux.getProx() != null) {
                if (aux.getInfo().compareTo(valor) == 0) { // achei
                    return aux;
                }
                else if (valor.compareTo(aux.getInfo()) > 0) {
                    aux = aux.getProx();
                }
                else {
                    return null;
                }
            }
        }
        return null;
    }





    public T buscarCliente(T valor) {
        Node<T> retorno;
        if (qtd == 0) {
            return null;
        } else {
            retorno = buscar(valor);
            if (retorno == null) {
                return null;
            } else {
                return retorno.getInfo();
            }
        }
    }




    public void exibir() {
        Node<T> aux;

        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");

        } else {
            aux = this.primeiro;
            do {
                System.out.println(aux.getInfo() + " ");
                aux = aux.getProx();

            } while (aux != this.ultimo.getProx()); // ou while (aux != this.prim)
        }
        System.out.println(" ");
    }







}
