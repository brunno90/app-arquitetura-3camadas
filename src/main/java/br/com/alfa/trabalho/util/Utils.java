package br.com.alfa.trabalho.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    /**
     * Módulo 11 Conforme o esquema abaixo, para calcular o primeiro dígito
     * verificador, cada dígito do número, começando da direita para a esquerda
     * (do dígito menos significativo para o dígito mais significativo) é
     * multiplicado, na ordem, por 2, depois 3, depois 4 e assim sucessivamente,
     * até o primeiro dígito do número. O somatório dessas multiplicações
     * dividido por 11. O resto desta divisão (módulo 11) é subtraido da base
     * (11), o resultado é o dígito verificador. Para calcular o próximo dígito,
     * considera-se o dígito anterior como parte do número e efetua-se o mesmo
     * processo. No exemplo, foi considerado o número 261533:
     * +---+---+---+---+---+---+ +---+ | 2 | 6 | 1 | 5 | 3 | 3 | - | 9 |
     * +---+---+---+---+---+---+ +---+ | | | | | | x7 x6 x5 x4 x3 x2 | | | | | |
     * =14 =36 =5 =20 =9 =6 soma = 90 +---+---+---+---+---+-> = (90 / 11) =
     * 8,1818 , resto 2 => DV = (11 - 2) = 9
     */
    public static int calcularDVMod11(String num) {

        int soma = 0;
        int resto = 0;
        int dv = 0;
        String[] numeros = new String[num.length() + 1];
        int multiplicador = 2;

        for (int i = num.length(); i > 0; i--) {
            if (multiplicador > 9) {
                multiplicador = 2;
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            } else {
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            }
        }

        for (int i = numeros.length; i > 0; i--) {
            if (numeros[i - 1] != null) {
                soma += Integer.valueOf(numeros[i - 1]);
            }
        }
        resto = soma % 11;
        dv = 11 - resto;
        // TODO: corrigir Mod11, retornando DV com 2 digitos.
        if (dv == 10 || dv == 11)
            return 0;
        return dv;
    }

    public static String formatarDataDDMMYYYY(Date data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data);
    }

    public static String removerAcento(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }
}