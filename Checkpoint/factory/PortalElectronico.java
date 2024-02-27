import java.util.Scanner;

public class PortalElectronico {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Bienvenido al portal electrónico");
        System.out.println("Ingrese su usuario (correo electrónico):");
        String username = in.nextLine();
        System.out.println("Ingrese la contraseña:");
        String password = in.nextLine();

        Login myLogin = new Login();
        UserInstanceCreator factory = new UserInstanceCreator();

        if (myLogin.hasAccess(username, password)) {
            User loggedUser = factory.getInstance(username);
            loggedUser.setUsername(username);
            loggedUser.setPassword(password);
            loggedUser.printMenu();

            // Guardar información del usuario al salir del menú
            System.out.println("¿Desea guardar su información? (y/n)");
            String saveChoice = in.nextLine();

            if (saveChoice.equalsIgnoreCase("y")) {
                System.out.println("Ingrese el nombre del archivo:");
                String fileName = in.nextLine();
                loggedUser.guardarInformacion(fileName);
                System.out.println("¡Información guardada con éxito!");
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }

        in.close();
    }
}
