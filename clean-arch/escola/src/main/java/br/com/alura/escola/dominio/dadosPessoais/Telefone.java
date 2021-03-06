package br.com.alura.escola.dominio.dadosPessoais;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null || numero == null){
            throw new IllegalArgumentException("DDD e numero sao obrigatorios");
        }
        if (!ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("DDD invalido");
        }
        if(!numero.matches("^\\d{5}-\\d{4}|\\d{4}-\\d{4}")){
            throw new IllegalArgumentException("Número inválido");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
