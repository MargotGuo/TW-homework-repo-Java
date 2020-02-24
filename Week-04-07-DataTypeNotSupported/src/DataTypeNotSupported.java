public class DataTypeNotSupported extends RuntimeException {
  public DataTypeNotSupported() {
  }

  public DataTypeNotSupported(String message) {
    super(message);
  }

  public DataTypeNotSupported(String message, Throwable cause) {
    super(message, cause);
  }

  public DataTypeNotSupported(Throwable cause) {
    super(cause);
  }

  public DataTypeNotSupported(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
