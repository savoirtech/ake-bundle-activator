# Apache Karaf Essentials: Bundle Activator

Source code to our AKE Bundle Activator video.

Build:
```text
cd activator
mvn clean install
```

Deploy in Apache Karaf 4.4.6:
```text
karaf@root()> install -s mvn:com.savoir.apache.karaf.essentials.bundle/activator
```

Configure: 
Create file in Apache Karaf etc folder called "ConfigSC.cfg", include the following properties:
```text
port=1234
url=255.0.0.1
```
