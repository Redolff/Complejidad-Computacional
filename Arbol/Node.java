package Ejercicio1;

public class Node {
	
	private int valor;
	private Node derecha;
	private Node izquierda;
	
	public Node(int valor) {
		this.valor = valor;
		this.derecha = null;
		this.izquierda = null;
	}
	
	public Node(int valor, Node izquierda, Node derecha) {
		this.valor = valor;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getDerecha() {
		return derecha;
	}

	public void setDerecha(Node derecha) {
		this.derecha = derecha;
	}

	public Node getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Node izquierda) {
		this.izquierda = izquierda;
	}
	

}
