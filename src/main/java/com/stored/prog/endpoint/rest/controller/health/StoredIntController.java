package com.stored.prog.endpoint.rest.controller.health;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {

  @GetMapping("/stored-int")
  public String StoredInt() {
    File file = new File("stored-int.txt");
    Random random = new Random();

    if (file.exists()) {
      try {
        return Files.readString(file.toPath());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    int randomNumber = random.nextInt(100);
    String randomString = String.valueOf(randomNumber);

    try {
      Files.writeString(file.toPath(), randomString);
      return randomString;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
