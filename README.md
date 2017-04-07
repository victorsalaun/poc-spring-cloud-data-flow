# POC Spring Cloud Data Flow

### Prerequisites

* RabbitMQ
* Redis

### Installing

Build project:
```
mvn clean install
```

## Running

Launch Data Flow Server:

```
cd data-flow-server
mvn spring-boot-run
```

Server is available at [http://localhost:9393/dashboard](http://localhost:9393/dashboard)

On [APPS](http://localhost:9393/dashboard/index.html#/apps/apps) tab, click on 'Bulk Import Applications' button and enter at 'Apps as Properties' :
```
source.http-source=maven://com.victorsalaun:http-source:jar:0.0.1-SNAPSHOT
processor.string-processor=maven://com.victorsalaun:string-processor:jar:0.0.1-SNAPSHOT
sink.log-sink=maven://com.victorsalaun:log-sink:jar:0.0.1-SNAPSHOT
```

Click on [STREAMS | Create Stream](http://localhost:9393/dashboard/index.html#/streams/create) tab. Enter these stream definition :
```
http-source | string-processor | log-sink
```

Check on [RUNTIME](http://localhost:9393/dashboard/index.html#/runtime/runtime) tab to see the stream running. 

## Authors

* **Victor SALAUN**

## License

This project is licensed under the MIT License
