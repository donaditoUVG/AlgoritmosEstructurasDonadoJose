import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Representa al usuario a través de su correo y contrasenia.
 * Esta clase es la base para otras que representan usuarios.
 */
public abstract class User {

    private String username; // Email 
    private String password; // contrasenia
    
     

    /**
     * Gets the username (email address) of the user.
     *
     * @return The username (email address).
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username (email address) for the user.
     *
     * @param username The new username (email address) to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Displays the user menu.
     * Subclasses can override this method to provide specific menu options.
     */
    public void printMenu() {
        // Default implementation (empty)
    }

    public abstract void guardarInformacion(String nombreArchivo);
        
      }
