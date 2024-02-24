public class Auditor extends User{
    @Override
    public void printMenu() {
        System.out.println("Bienvenido, Auditor. Escriba su nombre:");
        System.out.println("Seleccione una opción");
		System.out.println("1. Revisar notas de estudiantes");
		System.out.println("2. Revisar coutas pagadas de los estudiantes");
        System.out.println("3. Revisar los pagos para docentes");
    }
    
}
