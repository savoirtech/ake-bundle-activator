/*
 * Copyright (c) 2012-2024 Savoir Technologies, Inc.
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
package com.savoir.apache.karaf.essentials.bundle.activator;

import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator {

    private static final String CONFIG_PID = "ConfigSC";
    private ServiceRegistration serviceReg;
    private SampleCode sc;

    public void start(BundleContext context) throws Exception {
        System.out.println("Starting...");
        Hashtable<String, Object> properties = new Hashtable<String, Object>();
        properties.put(Constants.SERVICE_PID, CONFIG_PID);
        serviceReg = context.registerService(ManagedService.class.getName(),
                new SampleCodeUpdater() , properties);
        System.out.println("Using " + Constants.SERVICE_PID + CONFIG_PID + " as config file.");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stopping...");
        if (serviceReg != null) {
            serviceReg.unregister();
        }
    }

    private class SampleCodeUpdater implements ManagedService {

        public void updated(Dictionary config) throws ConfigurationException {
            if (config == null) {
                System.out.println("No Configuration Found!");
                return;
            }
            if (sc == null) {
                sc = new SampleCode();
            }
            // Should check values sanity before attempting to set.
            sc.setPort((String) config.get("port"));
            sc.setUrl((String) config.get("url"));
            sc.refresh();
        }

    }

}
