package id.generator;

import java.util.UUID;

public class UniqueIDTest {
  public static void main(String[] args) {
    UUID uniqueKey = UUID.randomUUID();
    System.out.println (uniqueKey);
    String id=GenerateShortUUID.next();
    System.out.println("id= "+id);
  }
}