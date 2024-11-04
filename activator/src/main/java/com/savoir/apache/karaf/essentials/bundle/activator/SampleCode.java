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

public class SampleCode {

    private String port = "1111";
    private String url = "http://127.0.0.1";

    public SampleCode() {
        // Simple Constructor
        System.out.println("Simple Constructor SampleCode Object: Port: " + port + " URL: " + url);
    }

    public SampleCode(String port, String url) {
        this.port = port;
        this.url = url;
        System.out.println("Two Argument Constructor SampleCode Object: Port: " + port + " URL: " + url);
    }

    public void refresh() {
        System.out.println("Config Admin Refresh SampleCode Object: Port: " + port + " URL: " + url);
    }

    public void setPort(String port) {
        System.out.println("Set port to: " + port);
        this.port = port;
    }

    public void setUrl(String url) {
        System.out.println("Set url to: " + url);
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }
}
