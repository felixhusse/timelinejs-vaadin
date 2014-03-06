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

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractJavaScriptComponent;
import de.fatalix.vaadin.addon.timelinejs.json.TimelineData;
import org.json.JSONObject;

/**
 *
 * @author felix.husse
 */
@JavaScript({"vaadin://timelinejs/jquery-1.7.2.min.js","vaadin://timelinejs/storyjs-embed.js","timeline-connector.js"})
@StyleSheet({"vaadin://timelinecss/timeline.css"})
public class TimelineJS extends AbstractJavaScriptComponent{
    
    private static int resource_counter = 0;
    
    /**
     * 
     * @param data 
     */
    public TimelineJS(TimelineData data) {
        JSONObject json = new JSONObject(data);
        String jsonResult = json.toString();
        getState().data = jsonResult;
    }
    
    @Override
    protected TimelineJSState getState() {
        return (TimelineJSState) super.getState(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
