public interface ValidatorInterface {
    boolean validate(Object data);
    String getErrorMessage();
    void reset();
}
