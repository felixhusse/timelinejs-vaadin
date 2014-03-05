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

import com.vaadin.server.StreamResource;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;

/**
 *
 * @author felix.husse
 */
public class JSONStreamSource implements StreamResource.StreamSource{
    
    ByteArrayOutputStream imagebuffer = null;
    int reloads = 0;
    
    @Override
    public InputStream getStream() {
        String json = "{'timeline':{'headline':'QA Release','startDate':'2014,1,1','type':'default',"
                    + "'date':[{"
                    + "'startDate':'2014,02,16',"
                    + "'headline':'KVDT-Test'"
                    + "'text':'<p>KBV-Änderungen RIS 3.6</p><p>KVDT-Workflow Q2014/1</p><p>Quartalsdaten EBM</p><p>Resolved Tickets</p>'"
                    + "}"
                    + "]}}";
        return new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
    }
    
}
