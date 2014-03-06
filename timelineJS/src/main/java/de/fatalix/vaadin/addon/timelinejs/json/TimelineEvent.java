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



/**
 *
 * @author felix.husse
 */
public class TimelineEvent {
    private String startDate;
    private String endDate;
    private String headline;
    private String text;
    private TimelineAsset asset;

    public String getStartDate() {
        return startDate;
    }
    
    /**
     * 
     * @param startDate YYYY,MM,dd example: 2014,1,12
     * @return 
     */
    public TimelineEvent setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }
    
    /**
     * EndDate is optional. If not set, event is single point.
     * 
     * @param endDate YYYY,MM,dd example: 2014,1,12
     * @return 
     */
    public TimelineEvent setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getHeadline() {
        return headline;
    }

    public TimelineEvent setHeadline(String headline) {
        this.headline = headline;
        return this;
    }

    public String getText() {
        return text;
    }

    public TimelineEvent setText(String text) {
        this.text = text;
        return this;
    }

    public TimelineAsset getAsset() {
        return asset;
    }

    public TimelineEvent setAsset(TimelineAsset asset) {
        this.asset = asset;
        return this;
    }
    
}
