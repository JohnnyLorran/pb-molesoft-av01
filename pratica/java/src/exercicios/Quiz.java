package exercicios;

public class Quiz {
    private final String pergunta;
    private final int resposta;

    public Quiz(String pergunta, int resposta){
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public int getResposta() {
        return resposta;
    }
}
