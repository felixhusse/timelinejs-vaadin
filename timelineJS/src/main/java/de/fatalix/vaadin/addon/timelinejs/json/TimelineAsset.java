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
public class TimelineAsset {
    private String media;
    private String caption;
    private String credit;

    public String getMedia() {
        return media;
    }

    public TimelineAsset setMedia(String media) {
        this.media = media;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public TimelineAsset setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getCredit() {
        return credit;
    }

    public TimelineAsset setCredit(String credit) {
        this.credit = credit;
        return this;
    }
    
    
    
}
