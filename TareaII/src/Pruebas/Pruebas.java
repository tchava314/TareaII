package Pruebas;

import Logic.ArbolBB;
import Logic.Int;

public class Pruebas {

	public static void main(String[] ar) {
		ArbolBB abo = new ArbolBB();
		abo.insertar(new Int(12));
		abo.insertar(new Int(50));
		abo.insertar(new Int(25));
		abo.insertar(new Int(75));
		abo.insertar(new Int(150));
		System.out.println("Impresion preorden: ");
		abo.preOrder();
		System.out.println("Impresion entreorden: ");
		abo.inOrder();
		System.out.println("Impresion postorden: ");
		abo.posOrder();
	}
}
