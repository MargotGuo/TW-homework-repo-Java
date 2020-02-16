public enum Student {
  LINDA("Linda", "Female"),
  BOB("Bob","Male"),
  SOLIDER("Solider", "Male"),
  CINDY("Cindy", "Female");

  private final String name;
  private final String gender;

  Student(String name, String gender) {
    this.name = name;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }
}
