public class AuthenticationManager {
    private static AuthenticationManager instance;
    private AuthenticationManager() {} // Construtor privado

    public static AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public void authenticate(String user, String password) {
        // Lógica de autenticação
    }

    public static void main(String[] args) {
        AuthenticationManager authManager = AuthenticationManager.getInstance();
        authManager.authenticate("user", "password");
    }
}
