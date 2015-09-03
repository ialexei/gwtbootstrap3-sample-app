package org.gwtbootstrap3.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Joshua Godi
 */
public class SampleWebApp extends Composite implements EntryPoint {
    interface MyUiBinder extends UiBinder<Widget, SampleWebApp> {
    }

    private static MyUiBinder myUiBinder = GWT.create(MyUiBinder.class);
    
    public void onModuleLoad() {
        RootPanel.get().add(myUiBinder.createAndBindUi(this));
    }
    
    @UiHandler("showPopupButton")
    public void onShowPopupButtonClicked(ClickEvent clickEvent) {
    	
    	final MyModal myModal = new MyModal(new DialogContent(), "My buggy Popup");
    	myModal.getSaveButton().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				myModal.hide();
			}
		});
    	
    	myModal.show();
    }
}