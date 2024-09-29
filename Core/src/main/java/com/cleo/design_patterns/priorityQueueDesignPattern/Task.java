package com.cleo.design_patterns.priorityQueueDesignPattern;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Getter
@Setter
public class Task {

    private  String work;

    private int priority;


    public int compareTo(Task o) {
        if(o!=null)
            return this.priority - o.priority;
        return -1;
    }


}
