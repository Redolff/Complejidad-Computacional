package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		TreeNode arbol = new TreeNode();
		
		arbol.add(15);
		arbol.add(6);
		arbol.add(18);
		arbol.add(3);
		arbol.add(17);
		arbol.add(7);
		arbol.add(20);
		
		System.out.println(arbol.toString());
		
		//arbol.delete(6); Elimina perfecto!
		
		System.out.println(arbol.toString());
		
		System.out.println("Get root: " + arbol.getRoot());
		
		System.out.println("Height: " + arbol.getHeight());
		
		//System.out.println("Longest branch: " + arbol.getLongestBranch());
		
		System.out.println("Get frontera: " + arbol.getFrontera());
		
		System.out.println("Get max elem: " + arbol.getMaxElem());
		
		System.out.println("Get elem at level: " + arbol.getElemAtLevel(2));
	}

}