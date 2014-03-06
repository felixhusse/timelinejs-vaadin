/*
 * Copyright 2014 fatalix.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.fatalix.vaadin.addon.timelinejs;

import de.fatalix.vaadin.addon.timelinejs.json.Timeline;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineData;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.joda.time.DateTime;
import org.json.JSONObject;

/**
 *
 * @author felix.husse
 */
public class JSONTest {
    
    public static void main(String[] args) {
        TimelineData data = generateSampleData();        
        JSONObject json = new JSONObject(data);
        System.out.println("RESULT JSON: " + json.toString());
    }
    
    private static TimelineData generateSampleData() {
        TimelineData data = new TimelineData();
        
        Timeline timeline = new Timeline();
        timeline.setHeadline("QA Releases")
                .setText("<li>Feature</li> <li>Feature</li>")
                .setType("default")
                .setStartDate(new DateTime().minusMonths(2))
                .setDate(generateEvents());
        
        data.setTimeline(timeline);
        
        return data;
    }
    
    private static Collection<TimelineEvent> generateEvents() {
        Collection<TimelineEvent> events = new ArrayList<>();
        TimelineEvent event1 = new TimelineEvent();
        event1.setHeadline("Test Data").setText("<p>THIS IS A TEST</p>").setStartDate(new DateTime().minusMonths(2).plusDays(3));
        
        TimelineEvent event2 = new TimelineEvent();
        event2.setHeadline("Test Data 2").setText("<p>THIS IS A TEST</p>").setStartDate(new DateTime().minusMonths(2).plusDays(1)).setEndDate(new DateTime().minusMonths(2).plusDays(6));
        events.add(event1);
        events.add(event2);
        return events;
    }
}
