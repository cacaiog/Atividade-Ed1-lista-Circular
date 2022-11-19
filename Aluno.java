


public class Aluno implements Comparable <Aluno> {

    private String matricula;
    private String nome;
    private double media;
    private int faltas;


    public Aluno(String m, String n, double med, int f) {
        this.matricula = m;
        this.nome = n;
        this.media = med;
        this.faltas = f;
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }


    @Override
    public int compareTo(Aluno a) {
        int result;
        result = this.getMatricula().compareTo(a.getMatricula());
        return result;

    }


    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", media=" + media +
                ", faltas=" + faltas +
                '}';
    }
}
