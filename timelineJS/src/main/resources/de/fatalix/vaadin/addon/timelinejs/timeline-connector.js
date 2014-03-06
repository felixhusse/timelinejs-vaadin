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
window.de_fatalix_vaadin_addon_timelinejs_TimelineJS = function() {
    var e = this.getElement();
    
    this.onStateChange = function() {
        var timelineData = JSON.parse(this.getState().data);
        e.innerHTML = "<div id='my-timeline'></div>";
        
        var timeline_config = {
            type: "timeline",
            width: "100%",
            height: "100%",
            source: timelineData,
            embed_id: "my-timeline"
        };
        createStoryJS(timeline_config);
    };
    
};

