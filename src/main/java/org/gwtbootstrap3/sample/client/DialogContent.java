package org.gwtbootstrap3.sample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DialogContent extends Composite {

	@UiTemplate("DialogContent.ui.xml")
	interface DialogContentUiBinder extends UiBinder<Widget, DialogContent> {}
	private static DialogContentUiBinder uiBinder = GWT.create(DialogContentUiBinder.class);
	
	public DialogContent() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
