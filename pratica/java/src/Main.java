import exercicios.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args){

        System.out.println(ConsoleColors.WHITE + "\n----------------- Exercicio 8 -----------------\n");
        ex08();
        System.out.println("\n----------------- Exercicio 9 -----------------\n");
        ex09();
        System.out.println("\n----------------- Exercicio 10 ----------------\n");
        ex10();
        //Bônus de um Quiz de SOMA e SUBTRAÇÂO!
        System.out.println("\n----------------- Bonus 11 ----------------\n");
        ex11();

    }

    public static void ex08(){
        ArrayList<QuizProduto> quizProduto = new ArrayList<>();

        QuizProduto q = new QuizProduto("\n\nNossos produtos são todos originais de fábrica?","sim");
        quizProduto.add(q);
        QuizProduto p = new QuizProduto("\n\nNossos produtos possuem garantia?","sim");
        quizProduto.add(p);
        QuizProduto k = new QuizProduto("\n\nA garantia dos nossos produtos é de 180 dias após a entrega?","nao");
        quizProduto.add(k);
        QuizProduto g = new QuizProduto("\n\nNossos produtos possuem a melhor qualidade do mercado?","sim");
        quizProduto.add(g);
        QuizProduto l = new QuizProduto("\n\nÉ verdade que nossos produtos não são seguros?","nao");
        quizProduto.add(l);
        QuizProduto w = new QuizProduto("\n\nA linha de produtos HighQuality foi lançada em 2022?","nao");
        quizProduto.add(w);
        QuizProduto d = new QuizProduto("\n\nÉ verdade que a garantia é de 1 ano para qualquer produto?","sim");
        quizProduto.add(d);
        QuizProduto t = new QuizProduto("\n\nTemos frete gratuito para todo Brasil?","sim");
        quizProduto.add(t);
        QuizProduto m = new QuizProduto("\n\nÈ verdade que todo mês tem promoção de produtos diversos?","sim");
        quizProduto.add(m);
        QuizProduto f = new QuizProduto("\n\nO frete gratuito é acim de R$ 200,00 em produtos? ","nao");
        quizProduto.add(f);

        System.out.println("Jogue o nosso Quiz para ganhar um voucher da nossa loja !\n");
        System.out.println("Responda com "+ConsoleColors.GREEN+"'SIM'"+ConsoleColors.WHITE+" ou "+ConsoleColors.RED+"'NAO'"+ConsoleColors.WHITE+ " as perguntas, números não são aceitos como resposta !!");
        System.out.print("\nPara iniciar o Quiz, digite seu nome: ");
        String nome = inputString();
        String resposta;
        int acertos = 0;
        for (QuizProduto a: quizProduto) {
            do {
                System.out.println(a.getPergunta());
                System.out.print("Resposta: ");
                resposta = inputString().toLowerCase(Locale.ROOT);

                if(resposta.equals("não")){
                    resposta = "nao";
                }

                if(a.getResposta().equals(resposta)){
                    acertos++;
                }

                if(!resposta.equals("sim") && !resposta.equals("nao") ){
                    System.out.println(ConsoleColors.RED + "Resposta inválida, tente novamente !" + ConsoleColors.WHITE);
                }
            }while (!resposta.equals("sim") && !resposta.equals("nao"));
        }

        System.out.println("\n\nQuiz Finalizado, resultado:\n");
        System.out.println("Jogador: " + nome);
        System.out.println(ConsoleColors.GREEN + "Acertos: " + ConsoleColors.WHITE + acertos);
        System.out.println(ConsoleColors.RED + "Erros: " + ConsoleColors.WHITE+ ((quizProduto.size()) - acertos));

    }



    public static void ex09(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Map<Integer,String> mensagens = new HashMap<>();
        int m = 1;
        boolean login = false;

        //Adicionar os usuarios do sistema.
        Usuario q = new Usuario("johnny","123456");
        usuarios.add(q);
        Usuario r = new Usuario("reginaldo","123456");
        usuarios.add(r);
        Usuario p = new Usuario("paulo","123456");
        usuarios.add(p);

        //Adicionar as mensagens do sistema e pegar a hora atual.
        mensagens.put(1, ConsoleColors.BLUE + "\nBoa madrugada"+ ConsoleColors.WHITE +", você se logou ao nosso sistema." );
        mensagens.put(2, ConsoleColors.BLUE + "\nBom dia"+ ConsoleColors.WHITE +", você se logou ao nosso sistema.");
        mensagens.put(3, ConsoleColors.BLUE + "\nBoa tarde"+ ConsoleColors.WHITE +", você se logou ao nosso sistema.");
        mensagens.put(4, ConsoleColors.BLUE + "\nBoa noite"+ ConsoleColors.WHITE +", você se logou ao nosso sistema.");
        int horaAtual = LocalTime.now().getHour();

        //Pegar os input's do usuario
        System.out.print("Digite o usuario: ");
        String nome = inputString();
        System.out.print("Digite a senha: ");
        String senha = inputString();

        //verificar se o usuario e senha batem com algum dos usuarios que temos adicionados na nossa lista(banco)
        //se tiver,é exibida a mensagem conforme pedido pelo horario estabelecido
        for (Usuario b: usuarios) {
            if(b.getNome().equals(nome)){
                if(b.getSenha().equals(senha)){
                    login = true;
                    for(int i = 6; i <= 24 ; i+= 6){
                        if(horaAtual < i){
                            System.out.println(mensagens.get(m));
                            break;
                        }
                        m++;
                    }
                }
            }
        }
        //caso o usuario não seja encontrado, exibe a mensagem abaixo
        if(!login){
            System.out.println(ConsoleColors.RED + "\nUsuário e/ou senha incorretos." + ConsoleColors.WHITE);
        }
    }

    public  static void ex10(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        int totalFuncionario, i = 1;
        DecimalFormat realFormat = new DecimalFormat("'R$' 0.00");

        //Recebe a quantidade de funcionarios que serão cadastrados
        //Valor minimo é 1
        do {
            System.out.println("Quantos funcionários deseja cadastrar? ");
            totalFuncionario = inputNumberInt();
            if(totalFuncionario == 0){
                System.out.println("\nDigite um valor maior que zero(0) !\n");
            }
        }while (totalFuncionario < 1);

        //Faz a inserção na lista(banco) dos valores de cada funcionario
        //E dentro da classe Funcionario, ao inicializar um novo funcionario
        //Já é realizado o calculo do bonus ou desconto e o salario liquido
        BigDecimal salario;
        while( i <= totalFuncionario) {
            System.out.print("\nDigite o nome do funcionário["+i+"]: ");
            String nome = inputString();

            do {
            System.out.print("Digite o salário: ");
            salario = inputNumberBigDecimal();

                if (salario.doubleValue() < 0) {
                    System.out.println( ConsoleColors.RED +"\n\nNão foi possivel reconhecer o valor digitado." + ConsoleColors.WHITE);
                    System.out.println("Caso tenha utilizado ponto(.) para representar os centavos, altere para vírigula(,) e tente novamente !\n\n");
                }
            }while (salario.doubleValue() < 0);

            Funcionario f = new Funcionario(nome, salario);
            funcionarios.add(f);
            i++;
        }

        //Aqui percorremos a lista para cada funcionario dentro dela
        //E exibimos os dados conforme solicitados
        System.out.println("\nResultado do calculo do bônus:\n");
        for (Funcionario j: funcionarios) {
            System.out.println("Funcionário: " + j.getNome() );
            System.out.println("Salário: " + ConsoleColors.GREEN + realFormat.format(j.getSalario()) + ConsoleColors.WHITE );

            if(j.getBonus().doubleValue() > 0){
                System.out.println("Bônus: " + ConsoleColors.GREEN  + realFormat.format(j.getBonus()) + ConsoleColors.WHITE);
            }else{
                System.out.println("Desconto: " + ConsoleColors.RED + realFormat.format(j.getDesconto()) + ConsoleColors.WHITE);
            }
            System.out.println("Salário Liquido: " + ConsoleColors.GREEN + realFormat.format(j.getSalarioLiquido()) +"\n" + ConsoleColors.WHITE);
        }
    }

    //Bônus: esse código é um quiz de perguntas de Soma e Subtração
    //Gerado aleatoriamente pelo próprio codigo.
    public static void ex11(){
        ArrayList<Quiz> quiz = new ArrayList<>();
        Random random = new Random();
        int acertos = 0;

        //Recebe o nome do jogador
        System.out.print("Digite o nome do jogador: ");
        String nome = inputString();

        //Cria o jogo de forma aleatoria toda vez que o código é inicializado
        //O jogo pode ter de 1 a 11 perguntas
        //As  perguntas e respostas são geradas automaticamente
        int numero = random.nextInt(10) +1 ;
        if( numero == 1){
            System.out.println("\nO Quiz terá " + ConsoleColors.BLUE + numero +  ConsoleColors.WHITE + " pergunta.");
        }else{
            System.out.println("\nO Quiz terá " + ConsoleColors.BLUE + numero + ConsoleColors.WHITE + " perguntas.");
        }

        for(int i = 1; i <= numero; i++){
            int n1 = random.nextInt(100) +1;
            int n2 = random.nextInt(100) +1;
            String pergunta;
            int resultado ;
            if(i % 2 == 0){
                pergunta = "Qual o valor da soma entre " + n1 + " e " + n2 + " ?";
                resultado =  n1 + n2;
            }else{
                pergunta = "Qual o valor da subtração entre " + n1 + " e " + n2 + " ?";
                resultado = n1 - n2;
            }

            Quiz q = new Quiz(pergunta,resultado);
            quiz.add(q);
        }

        //Exibe a pergunta, pega a resposta e verifica se acertou ou errou
        int k = 1;
        for (Quiz p: quiz) {
            System.out.println("\n"+k + "° Pergunta: " + p.getPergunta());

            int resposta;
            do {
                System.out.print("Resposta: ");
                resposta = inputNumberInt();
                if(resposta == -999){
                    System.out.println(ConsoleColors.RED +"\nAs respostas devem ser números inteiros, positivos ou negativos !\n\n" + ConsoleColors.WHITE);
                    System.out.println("\nTente responder novamente.");
                }
            } while (resposta == -999 );

            if(resposta == p.getResposta()){
                System.out.print(ConsoleColors.GREEN + "\nMuito bem, você acertou!\n\n" + ConsoleColors.WHITE);
                acertos++;
            }else{
                System.out.print(ConsoleColors.RED + "\nQue pena, você errou.\n\n" + ConsoleColors.WHITE);
            }
            k++;
        }

        System.out.println("\n\nJogo Finalizado, resultado:\n");
        System.out.println("Jogador: " + nome);
        System.out.println(ConsoleColors.GREEN + "Acertos: " + ConsoleColors.WHITE + acertos);
        System.out.println(ConsoleColors.RED + "Erros: " + ConsoleColors.WHITE+ (numero - acertos));
        if(numero - acertos == 0){
            System.out.println( ConsoleColors.GREEN +"\nPARABÉNS, VOCÊ ACERTOU TODAS AS PERGUNTAS !! " + ConsoleColors.WHITE);
        }

        if(acertos == 0){
            System.out.println( ConsoleColors.RED +"\nVOCÊ ERROU TODAS AS PERGUNTAS, PROCURE SE ESFORÇAR MAIS." + ConsoleColors.WHITE);
        }

    }


    public static String inputString(){
        Scanner inputUsuario = new Scanner(System.in);
        return inputUsuario.nextLine();
    }

    public static Integer inputNumberInt(){
        Scanner inputUsuario = new Scanner(System.in);
        try {
            return inputUsuario.nextInt();
        } catch (Exception e){
            return -999;
        }

    }

    public static BigDecimal inputNumberBigDecimal(){
        Scanner inputUsuario = new Scanner(System.in);
            try {
                 return BigDecimal.valueOf(inputUsuario.nextDouble());
            } catch (Exception e) {
                return BigDecimal.valueOf(-1);
            }
    }

}
