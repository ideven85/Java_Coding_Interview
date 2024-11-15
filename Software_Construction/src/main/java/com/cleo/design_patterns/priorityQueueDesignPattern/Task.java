package com.cleo.design_patterns.priorityQueueDesignPattern;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Getter
@Setter
public class Task implements Comparable<Task> {

    private  String work;

    private int priority;


    public int compareTo(Task o) {
        return this.priority - o.priority;

    }


}
