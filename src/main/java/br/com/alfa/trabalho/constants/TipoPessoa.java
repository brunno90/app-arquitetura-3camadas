package br.com.alfa.trabalho.constants;

/**
 * Created by pedro-dzs on 21/09/2015.
 */
public enum TipoPessoa {
    FISICA(1), JURIDICA(2);

    TipoPessoa(Integer cod) {
        this.cod = cod;
    }

    private Integer cod;

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
