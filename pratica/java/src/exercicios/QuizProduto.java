package exercicios;

public class QuizProduto {
    private final String pergunta;
    private final String resposta;

    public QuizProduto(String pergunta, String resposta){
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }
}
