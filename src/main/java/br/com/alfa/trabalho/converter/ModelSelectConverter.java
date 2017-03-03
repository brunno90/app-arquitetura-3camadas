package br.com.alfa.trabalho.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import br.com.alfa.trabalho.model.comum.AbstractModel;
import br.com.alfa.trabalho.util.converter.SelectItemsBaseConverter;

@Component
public class ModelSelectConverter extends SelectItemsBaseConverter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || ((AbstractModel) value).getId() == null) {
			return "";
		}
		return ((AbstractModel) value).getId().toString();
	}
}