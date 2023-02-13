package nl.cannontm.webserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProcessTask {

    String taskType;
    String tag;
    String reason;
    int priority;


}
