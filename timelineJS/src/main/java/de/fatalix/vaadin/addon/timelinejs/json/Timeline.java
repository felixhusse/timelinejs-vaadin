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

package de.fatalix.vaadin.addon.timelinejs.json;

import java.util.Collection;

/**
 *
 * @author felix.husse
 */
public class Timeline {
    private String headline;
    private String type;
    private String text;
    private String startDate;
    private Collection<TimelineEvent> date;

    public String getHeadline() {
        return headline;
    }

    public Timeline setHeadline(String headline) {
        this.headline = headline;
        return this;
    }

    public String getType() {
        return type;
    }

    public Timeline setType(String type) {
        this.type = type;
        return this;
    }

    public String getText() {
        return text;
    }

    public Timeline setText(String text) {
        this.text = text;
        return this;
    }

    public Collection<TimelineEvent> getDate() {
        return date;
    }

    public Timeline setDate(Collection<TimelineEvent> date) {
        this.date = date;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }
    
    /**
     * 
     * @param startDate YYYY,MM,dd example: 2014,1,12
     * @return 
     */
    public Timeline setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }
    
    
    
}
