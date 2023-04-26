package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	private Node raiz;
	
	public TreeNode() {
		this.raiz = null;
	}
	
	public TreeNode(Node raiz) {
		this.raiz = raiz;
	}
	
	 public int getRoot() {
		 if(this.raiz != null) {
			 return this.raiz.getValor();
		 }else {
			 return -1;
		 }
	 }
	 
	 public void add(int valor) {
		 if(this.raiz == null) {
			 this.raiz = new Node(valor);
		 }else {
			 this.add(this.raiz, valor);
		 }
	 }
	 
	 private void add(Node nodo, int valor) { //private para no ROMPER ENCAPSULAMIENTO
		 if(this.raiz == null) {
			 this.raiz = nodo;
		 }
		 else {
			 if (nodo.getValor() > valor) {
				 if (nodo.getIzquierda() == null) {
					 Node temp = new Node(valor);
					 nodo.setIzquierda(temp);
				 } else {
					 add(nodo.getIzquierda(), valor);
				 }
			 } 
			 else if (nodo.getValor() < valor) {
				 if (nodo.getDerecha() == null) {
					 Node temp = new Node(valor);
					 nodo.setDerecha(temp);
				 } else {
					 add(nodo.getDerecha(), valor);
				 }
			 }
		 }
	 }
	 
	 public void delete(int valor) {
		 this.delete(this.raiz, valor);
	 }
	 
	 private Node delete(Node nodo, int valor) {
		 if(nodo == null) {
			 return null;
		 }
		 if(valor == nodo.getValor()) {
			 if(nodo.getIzquierda() == null && nodo.getDerecha() == null) {
				 return null;
			 }
			 if(nodo.getIzquierda() == null) {
				 return nodo.getDerecha();
			 }
			 if(nodo.getDerecha() == null) {
				 return nodo.getIzquierda();
			 }
			 int menorValor = findSmallValue(nodo.getIzquierda());
			 nodo.setValor(menorValor);
			 nodo.setDerecha(delete(nodo.getDerecha(), menorValor));
			 nodo.setIzquierda(null);
			 return nodo;
		 }
		 else {
			 if(nodo.getValor() > valor) {
				 nodo.setIzquierda(delete(nodo.getIzquierda(), valor));
			 }
			 if(nodo.getValor() < valor) {
				 nodo.setDerecha(delete(nodo.getDerecha(), valor));
			 }
			 return nodo;
		 }
	 }
	 
	 private int findSmallValue(Node nodo) { //Encontrar el valor mas pequeño en el arbol
		 if(nodo.getIzquierda() == null) { //SI el nodo izquierda es nulo
			 return nodo.getValor(); //retorno el valor
		 }else { //SINO
			 return findSmallValue(nodo.getIzquierda()); //recursion hasta encontrarlo.
		 }
	 }
	 
	 public int getHeight() {
		 if(this.raiz.getIzquierda() == null && this.raiz.getDerecha() == null) {
			 return -1;
		 }else {
			 return this.getHeight(this.raiz);
		 }
	 }
	 
	 private int getHeight(Node nodo) {
		 int height = 0;
		 if(nodo == null) {
			 return -1;
		 }
		 else {
			 height = Math.max(getHeight(nodo.getIzquierda()), getHeight(nodo.getDerecha()));
			 height++;
		 }
		 return height;
	 }
	 
	 public List<Integer> getLongestBranch() {
		 List<Integer> listActual = new ArrayList<>();
		 List<Integer> listLong = new ArrayList<>();
		 if(this.raiz != null) {
			 this.getLongestBranch(this.raiz, listActual, listLong);
		 }
		 return listLong;
	 }
	 
	 private void getLongestBranch(Node nodo, List<Integer> listActual, List<Integer> listLong){
		 listActual.add(nodo.getValor());
		 
		 if(nodo.getIzquierda() == null && nodo.getDerecha() == null) { //si es hoja...
			 if(listActual.size() > listLong.size()) {
				 //Vaciamos el camino mas que teniamos hallado.
				 for(int i = 0; i < listLong.size(); i++) {
					 listLong.clear();
				 }
				 //Guardar el camino actual en el camino mas largo
				 for(int i = 0; i < listActual.size(); i++) {
					 listLong.addAll(listActual);
				 }
			 }
		 }
		 else {
			 getLongestBranch(nodo.getIzquierda(), listActual, listLong); //DEVUELVE EL CAMINO MAS A LA IZQUIERDA
			 listActual.clear();
		 }
	 }
	 
	 public List<Integer> getFrontera(){
		 List<Integer> list = new ArrayList<>();
		 this.getFrontera(this.raiz, list);
		 return list;
	 }
	 
	 private List<Integer> getFrontera(Node nodo, List<Integer> lista){
		 if(nodo == null) {
			 return null;
		 }
		 if(nodo.getIzquierda() == null && nodo.getDerecha() == null) {
			 lista.add(nodo.getValor());
		 }
		 else {			 
			 getFrontera(nodo.getIzquierda(), lista);
			 getFrontera(nodo.getDerecha(), lista);
		 }
		 return lista;
	 }
	 
	 public int getMaxElem() {
		 return getMaxElem(this.raiz).getValor();
	 }
	 
	 private Node getMaxElem(Node nodo) {
		 if(nodo.getDerecha() != null) {
			 return getMaxElem(nodo.getDerecha());
		 }
		 return nodo;
	 }
	 
	public List<Integer> getElemAtLevel(int level){
		List<Integer> result = new ArrayList<>();
		this.getElemAtLevel(this.raiz, result, level);
		return result;
	}
	
	public void getElemAtLevel(Node nodo, List<Integer> result, int level){
		if(level == 0) {
			result.add(nodo.getValor());
		}
		else {
			if(nodo.getIzquierda() != null) {
				getElemAtLevel(nodo.getIzquierda(), result, level-1);
			}
			if(nodo.getDerecha() != null) {
				getElemAtLevel(nodo.getDerecha(), result, level-1);
			}
		}
	}
	 
	 private void printPosOrder(Node nodo) {
		 if(nodo == null) {
			 return ;
		 }
		 printPosOrder(nodo.getIzquierda());
		 printPosOrder(nodo.getDerecha());
		 System.out.println(nodo.getValor() + " ");
	 }
	 
	 public void printPosOrder() {
		 if(this.raiz == null) {
			 return ;
		 }
		 printPosOrder(this.raiz.getIzquierda());
		 printPosOrder(this.raiz.getDerecha());
		 System.out.println(this.raiz.getValor());
	 }
	 
	 private void printPreOrder(Node nodo) {
		 if(nodo != null) {
			 System.out.println(nodo.getValor() + "");
			 printPreOrder(nodo.getIzquierda());
			 printPreOrder(nodo.getDerecha());
		 }
	 }
	 
	 public void printPreOrder() {
		 if(this.raiz != null) {
			 System.out.println(this.raiz.getValor());
			 printPreOrder(this.raiz.getIzquierda());
			 printPreOrder(this.raiz.getDerecha());
		 }
	 }
	 
	 private void printInOrder(Node nodo) {
		 if(nodo != null) {
			 printInOrder(nodo.getIzquierda());
			 System.out.println(nodo.getValor() + "");
			 printInOrder(nodo.getDerecha());
		 }
	 }
	 
	 public void printInOrder() {
		 if(this.raiz != null) {
			 printInOrder(this.raiz.getIzquierda());
			 System.out.println(this.raiz.getValor());
			 printInOrder(this.raiz.getDerecha());
		 }
	 }
		 
	/* public boolean hasElem() {
		 return this.raiz != null;
	 } */
	 
	 public boolean isEmpty() {
		 return this.raiz == null;
	 }
	 
	 @Override
	 public String toString() {
		 if(this.raiz == null) {
			 return "";
		 }else {
			 return this.toString(this.raiz);
		 }
	 }
	 
	 private String toString(Node node) {
		    String result = "";
		    if (node != null) {
		        result += node.getValor();
		        if (node.getIzquierda() != null || node.getDerecha() != null) {
		            result += "(";
		            result += toString(node.getIzquierda());
		            result += ",";
		            result += toString(node.getDerecha());
		            result += ")";
		        }
		    }
		    return result;
		}
	
}