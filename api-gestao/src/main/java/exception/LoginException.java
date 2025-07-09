package exception;

public class LoginException extends RuntimeException {
    public LoginException() {
        super("Email ou senha inválidos");
    }
}
