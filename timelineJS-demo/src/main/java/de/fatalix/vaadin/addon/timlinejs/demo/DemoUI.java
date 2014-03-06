package de.fatalix.vaadin.addon.timlinejs.demo;


import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.fatalix.vaadin.addon.timelinejs.TimelineJS;
import de.fatalix.vaadin.addon.timelinejs.json.Timeline;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineAsset;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineData;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


@Theme("demo")
@Title("Timelinejs Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {
     private static final DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY,MM,dd");
    private static int resource_counter = 0;


    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(final VaadinRequest request) {
        try {
            
            // Show it in the middle of the screen
            final VerticalLayout layout = new VerticalLayout();
            layout.setStyleName("demoContentLayout");
            layout.setSizeFull();
            
            final RichTextArea textArea = new RichTextArea("Event Text");
            Button generateTimeLine = new Button("Generate",new Button.ClickListener() {

                @Override
                public void buttonClick(Button.ClickEvent event) {
                    if (layout.getComponentCount()==3) {
                        layout.removeComponent(layout.getComponent(2));
                    }
                    String eventText = textArea.getValue();
                    eventText = eventText.replaceAll("<ul>", "").replaceAll("</ul>", "");
                    eventText = eventText.replaceAll("<ol>", "").replaceAll("</ol>", "");
                    TimelineJS timelineJS = generateTimeline(eventText);
                    layout.addComponent(timelineJS);
                    layout.setExpandRatio(timelineJS, 1.0f);
                }
            });
            layout.addComponents(textArea,generateTimeLine);
            
            setContent(layout);

        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    private TimelineJS generateTimeline(String eventText) {
        TimelineJS timelineJS = new TimelineJS(generateSampleData(eventText));
        timelineJS.setHeight("500px");
        timelineJS.setWidth("100%");
        return timelineJS;
    }
    
    private TimelineData generateSampleData(String eventText) {
        TimelineData data = new TimelineData();
        
        
        Timeline timeline = new Timeline();
        timeline.setHeadline("QA Releases")
                .setText(eventText)
                .setType("default")
                .setStartDate(new DateTime().minusMonths(2).toString(fmt))
                .setDate(generateEvents(eventText));
        
        data.setTimeline(timeline);
        
        return data;
    }
    
    private Collection<TimelineEvent> generateEvents(String eventText) {
        Collection<TimelineEvent> events = new ArrayList<>();
        TimelineEvent event1 = new TimelineEvent();
        event1.setHeadline("Test Data").setText(eventText).setStartDate(new DateTime().minusMonths(2).plusDays(3).toString(fmt));
        
        TimelineAsset asset = new TimelineAsset()
                .setCaption("")
                .setCredit("Felix")
                .setMedia(generateResourceURL(new FileResource(new File("c:\\dev-server.gif"))));
        
        
        TimelineEvent event2 = new TimelineEvent()
                .setHeadline("Test Data 2")
                .setText("<p>THIS IS A TEST</p>")
                .setStartDate(new DateTime().minusMonths(2).plusDays(1).toString(fmt))
                .setEndDate(new DateTime().minusMonths(2).plusDays(8).toString(fmt))
                .setAsset(asset);
        
        events.add(event1);
        events.add(event2);
        return events;
    }
    
    private String generateResourceURL(Resource resource) {
        setResource("timelinejs"+resource_counter, resource);
        String url = getState().resources.get("timelinejs"+resource_counter).getURL().split("p://")[1];
        resource_counter++;
        return url;
    }

}
