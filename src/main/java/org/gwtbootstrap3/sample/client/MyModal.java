package org.gwtbootstrap3.sample.client;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalFooter;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.ContextualBackground;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Widget;

public class MyModal extends Modal {

	private final Button saveButton = new Button("save");
	private final Paragraph errorDetails = new Paragraph();
	private final Widget bodyWidget;
	public MyModal(
			final Widget bodyWidget,
			final String title) {
		
		this.bodyWidget = bodyWidget;
		setClosable(true);
		setTitle(title);
		
		final ModalBody modalBody = new ModalBody();
		errorDetails.setContextualBackground(ContextualBackground.DANGER);
		errorDetails.setVisible(false);
		modalBody.add(errorDetails);
		modalBody.add(bodyWidget);
		
		final ModalFooter modalFooter = new ModalFooter();
		saveButton.setType(ButtonType.PRIMARY);
		saveButton.setIcon(IconType.SAVE);
		modalFooter.add(saveButton);
	
		Button cancelButton = new Button("cancel");
		cancelButton.setType(ButtonType.PRIMARY);
		cancelButton.setIcon(IconType.UNDO);
		modalFooter.add(cancelButton);
		cancelButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		
		add(modalBody);
		add(modalFooter);
	}

	public Button getSaveButton() {
		return saveButton;
	}
	
	public void setErrorText(String text) {
		
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		sb.appendEscaped(text);
		errorDetails.setHTML(sb.toSafeHtml().asString());
		errorDetails.setVisible(true);
	}
	
	public void clearError() {
		
		errorDetails.setHTML("");
		errorDetails.setVisible(true);
	}

	public Widget getBodyWidget() {
		return bodyWidget;
	}
}
