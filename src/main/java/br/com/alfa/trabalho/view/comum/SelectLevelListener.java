package br.com.alfa.trabalho.view.comum;

import org.primefaces.extensions.component.masterdetail.SelectLevelEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class SelectLevelListener {

	private boolean errorOccured = false;

	public int handleNavigation(SelectLevelEvent selectLevelEvent) {
		if (errorOccured) {
			return selectLevelEvent.getCurrentLevel();
		} else {
			return selectLevelEvent.getNewLevel();
		}
	}

	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}
}