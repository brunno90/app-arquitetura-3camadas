package br.com.alfa.trabalho.converter;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;
import org.springframework.stereotype.Component;

import br.com.alfa.trabalho.model.comum.AbstractModel;

@Component
public class ModelPicklistConverter implements Converter {

	@SuppressWarnings({ "rawtypes" })
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object ret = null;
		if (component instanceof PickList) {
			Object dualList = ((PickList) component).getValue();
			DualListModel dl = (DualListModel) dualList;
			for (Iterator iterator = dl.getSource().iterator(); iterator.hasNext();) {
				Object o = iterator.next();
				String id = (new StringBuilder()).append(((AbstractModel) o).getId()).toString();
				if (value.equals(id)) {
					ret = o;
					break;
				}
			}
			if (ret == null) {
				for (Iterator iterator1 = dl.getTarget().iterator(); iterator1.hasNext();) {
					Object o = iterator1.next();
					String id = (new StringBuilder()).append(((AbstractModel) o).getId()).toString();
					if (value.equals(id)) {
						ret = o;
						break;
					}
				}
			}
		}
		return ret;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String str = "";
		if (value instanceof AbstractModel)
			str = ((AbstractModel) value).getId().toString();
		return str;
	}
}