package org.gwtbootstrap3.sample.client;

import org.gwtbootstrap3.extras.fullcalendar.client.ui.CalendarConfig;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.Event;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.FullCalendar;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewOption;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Joshua Godi
 */
public class SampleWebApp extends Composite implements EntryPoint {
    interface MyUiBinder extends UiBinder<Widget, SampleWebApp> {
    }

    private static MyUiBinder myUiBinder = GWT.create(MyUiBinder.class);
    
    @UiField
    SimplePanel tableContainer;
    
    public void onModuleLoad() {
        RootPanel.get().add(myUiBinder.createAndBindUi(this));
        
        FullCalendar calendar = new FullCalendar(
				"test", 
				ViewOption.month, 
				new CalendarConfig(),
				true);
		
		calendar.setWidth("400px");
		calendar.addEvent(new Event(getEventProvider()));
		tableContainer.add(calendar);
    }
    
    public static void instanceFoo(String test) {
    	Window.alert(test);
    }
    
    public native final JavaScriptObject getEventProvider() /*-{
		return function(start, end, timezone, callback) {
			@org.gwtbootstrap3.sample.client.SampleWebApp::instanceFoo(Ljava/lang/String;)('hello');
		};
	}-*/;
}