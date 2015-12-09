package org.gwtbootstrap3.sample.client;

import org.gwtbootstrap3.extras.fullcalendar.client.ui.CalendarConfig;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.Event;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.FullCalendar;
import org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewOption;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DialogContent extends Composite {

	@UiTemplate("DialogContent.ui.xml")
	interface DialogContentUiBinder extends UiBinder<Widget, DialogContent> {}
	private static DialogContentUiBinder uiBinder = GWT.create(DialogContentUiBinder.class);
	
	@UiField
	VerticalPanel calendarContainer;
	
	private final FullCalendar calendar;
	
	public DialogContent() {
		initWidget(uiBinder.createAndBindUi(this));
		
		calendar = new FullCalendar(
				"test", 
				ViewOption.month, 
				new CalendarConfig(),
				true);
		
		calendar.setWidth("400px");
		calendar.addEvent(new Event(getEventProvider()));
		calendarContainer.add(calendar);
	}
	
	public static void instanceFoo(String s) {
		Window.alert(s);
	}
	
	public native final JavaScriptObject getEventProvider() /*-{
	return function(start, end, timezone, callback) {
		@org.gwtbootstrap3.sample.client.DialogContent::instanceFoo(Ljava/lang/String;)('hello');
	};
	}-*/;
}
