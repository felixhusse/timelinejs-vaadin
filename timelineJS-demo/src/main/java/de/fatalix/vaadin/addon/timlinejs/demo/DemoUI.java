package de.fatalix.vaadin.addon.timlinejs.demo;


import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.fatalix.vaadin.addon.timelinejs.TimelineJS;


@Theme("demo")
@Title("NetworkGraph Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    private int id = 1;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(final VaadinRequest request) {
        try {
            
            
            TimelineJS timelineJS = new TimelineJS();
            timelineJS.setHeight("500px");
            timelineJS.setWidth("100%");
            // Show it in the middle of the screen
            final VerticalLayout layout = new VerticalLayout();
            layout.setStyleName("demoContentLayout");
            layout.setSizeFull();
            Label helloLabel = new Label("Hello Vaadin");
            helloLabel.setSizeUndefined();
            layout.addComponent(helloLabel);
            layout.addComponent(timelineJS);
            layout.setExpandRatio(timelineJS, 1.0f);
            setContent(layout);
            timelineJS.init();
        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
 

}
