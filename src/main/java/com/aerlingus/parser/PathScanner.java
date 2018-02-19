package com.aerlingus.parser;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class PathScanner {

  public List<String> scannerPackage(final String packagePath) {
    final List<String> paths = new ArrayList<>();
    final File[] files = new File(packagePath).listFiles((dir, name) -> name.endsWith(".csv"));

    if (files == null || files.length == 0) {
      return null;
    }

    for (File file : files) {
      if (file.isFile()) {
        paths.add(file.getName());
      }
    }

    return paths;
  }

}
