package com.cleo.fileReaderAsync;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileReaderProcessor {

    String process(BufferedReader reader) throws IOException;
}
