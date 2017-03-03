package br.com.alfa.trabalho.converter;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * @author Iagho Fernandes
 */
@Component
public class CgcCpfConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String cgcCpf) {
        try {
            if (cgcCpf != null && !cgcCpf.trim().isEmpty()) {

                cgcCpf = cgcCpf.toString().replaceAll("[- /.]", "");
                cgcCpf = cgcCpf.toString().replaceAll("[-()]", "");

                if (cgcCpf.length() == 11) {
                    // TODO:Comentado para apresentação
                    // if (!Utils.isValidCPF(cgcCpf)) {
                    // throw new
                    // Exception("Por favor, informe um CPF/CNPJ valido!");
                    // }
                } else if (cgcCpf.length() == 14) {
                    // if (!Utils.isValidCNPJ(cgcCpf)) {
                    // throw new
                    // Exception("Por favor, informe um CPF/CNPJ valido!");
                    // }
                } else {
                    throw new Exception("Por favor, informe um CPF/CNPJ valido!");
                }
                return cgcCpf;
            }
            return null;
        } catch (Exception e) {
            RequestContext.getCurrentInstance().execute("PF('statusBioDialog').hide(); PF('statusDialog').hide();");
            throw new ConverterException(
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "CGC/CPF invalido!", e.getMessage()));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String cgcCpf = (String) value;
        if (cgcCpf != null) {
            if (cgcCpf.length() == 11) {
                cgcCpf = cgcCpf.substring(0, 3) + "." + cgcCpf.substring(3, 6) + "." + cgcCpf.substring(6, 9) + "-"
                        + cgcCpf.substring(9, 11);
            } else if (cgcCpf.length() == 14) {
                cgcCpf = cgcCpf.substring(0, 2) + "." + cgcCpf.substring(2, 5) + "." + cgcCpf.substring(5, 8) + "/"
                        + cgcCpf.substring(8, 12) + "-" + cgcCpf.substring(12, 14);
            }
        }
        return cgcCpf;
    }
}