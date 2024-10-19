package utiles;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Utiles {
	public static Random r = new Random();
	public static Scanner s = new Scanner(System.in);

	public static void esperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int ingresarEntero(int min,int max) {
		boolean error = false;
		int opc = 0;
		do {
			error = false;
			try {
			opc = s.nextInt();
			s.nextLine();
			if(opc<min || opc>max) {
				error = true;
				System.out.println("Debe ingresar un número entre " + min + " y " + max);
			}
			} catch(InputMismatchException e) {
				error = true;
				s.nextLine();
				System.out.println("Error. Debe ingreesar un número");
			} catch(Exception e) {
				error = true;
				System.out.println("Error desconocido");
			}
		}while(error);
		return opc;
	}
    
    public static float ingresarFloat(float min, float max) {
        float opc=0;
        boolean error = false;

        do {
            error = false;
            try {
                opc = s.nextFloat();
                if((opc<min)||(opc>max)) {
                    System.out.println("Error. Debe ingresar un numero del " + min + " al " + max);
                    error = true;
                }
                s.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error. Tipo de dato mal ingresado");
                error = true;
                s.nextLine();
            }
        }while(error);

        return opc;
    }

    public static String ingresarCadena() {
        return s.nextLine();
    }
	
}