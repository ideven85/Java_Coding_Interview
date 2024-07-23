package com.cleo.revision.old.learning_asyncProgramming;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileReaderProcessor {

    String process(BufferedReader reader) throws IOException;
}
