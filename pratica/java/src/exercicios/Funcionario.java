package exercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {

    private String nome;
    private BigDecimal salario;
    private BigDecimal bonus;
    private BigDecimal desconto;
    private BigDecimal salarioLiquido;

    public Funcionario(String nome, BigDecimal salario){
        this.nome = nome;
        this.salario = salario;
        
        if(salario.doubleValue() > 2000){
            this.desconto = formataBig(BigDecimal.valueOf(salario.doubleValue() * 0.1));
            this.bonus = BigDecimal.valueOf(0);
        }else if(salario.doubleValue() > 1000){
            this.desconto = BigDecimal.valueOf(0);
            this.bonus = formataBig(BigDecimal.valueOf(salario.doubleValue() * 0.1));
        }else{
            this.desconto = BigDecimal.valueOf(0);
            this.bonus = formataBig(BigDecimal.valueOf(salario.doubleValue() * 0.2));
        }

        this.salarioLiquido = BigDecimal.valueOf(salario.doubleValue() + this.bonus.doubleValue() - this.desconto.doubleValue()).setScale(2, RoundingMode.HALF_EVEN);;
    }

    public BigDecimal formataBig(BigDecimal valor){
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getNome(){
        return this.nome;
    }

    public BigDecimal getSalario(){
        return this.salario;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }
}
