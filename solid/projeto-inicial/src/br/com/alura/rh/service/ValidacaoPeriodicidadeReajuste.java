package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste{

    public void validar(Funcionario funcionario, BigDecimal aumento){

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesUltimoReajuste > 6) {
            throw new ValidacaoException("Intervalo entre reajustes não pode ser menor do que 6 meses!");
        }
    }

}
