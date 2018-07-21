package memento;

import kommando.BooleanVector;

public class Main {

	public static void main(String[] args) 
	{
		boolean[] inputValues = { false, true, false };
		BooleanVector vector = new BooleanVector(inputValues);
		vector.shiftLeft();
		

		boolean[] expectedValues = new boolean[] { true, false, false };
		BooleanVector expectedVector = new BooleanVector(expectedValues);

		if (!vector.equals(expectedVector)) {
			throw new IllegalStateException(vector.toString());
		} else {
			System.out.println("shiftleft läuft");
		}
        
		vector.undo();
		
		expectedValues = new boolean[] { false, true, false };
		expectedVector = new BooleanVector(expectedValues);

		if (!vector.equals(expectedVector)) {
			throw new IllegalStateException(vector.toString());
		} else {
			System.out.println("undo von shiftleft läuft");
		}
		
		
        vector.redo();
        		
		expectedValues = new boolean[] { true, false, false };
		expectedVector = new BooleanVector(expectedValues);

		if (!vector.equals(expectedVector)) {
			throw new IllegalStateException(vector.toString());
		} else {
			System.out.println("redo von shiftleft läuft");
		}

		// Test for shift right and the undo/redo functions
		boolean []inputValuesR = {false, true, false };
		BooleanVector vectorR = new BooleanVector(inputValuesR);
		
		vectorR.shiftRight();
		

		expectedValues = new boolean[] {false, false, true };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorR.equals(expectedVector)) {
			throw new IllegalStateException(vectorR.toString());
		} else {
			System.out.println("shifRight läuft");
		}
				
        vectorR.undo();        		

		expectedValues = new boolean[] {false, true, false };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorR.equals(expectedVector)) {
			throw new IllegalStateException(vectorR.toString());
		} else {
			System.out.println("undo von shiftright läuft");
		}
		
		vectorR.redo();
		
		
		expectedValues = new boolean[] { false, false, true };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorR.equals(expectedVector)) {
			throw new IllegalStateException(vectorR.toString());
		} else {
			System.out.println("redo von shifright läuft");
		}

		
		// Test for invert and the undo/redo functions
		boolean []inputValuesI = {false, true, false };
		BooleanVector vectorI = new BooleanVector(inputValuesI);
		
		vectorI.invert();
		

		expectedValues = new boolean[] {true, false, true };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorI.equals(expectedVector)) {
			throw new IllegalStateException(vectorI.toString());
		} else {
			System.out.println("inverter läuft");
		}
		
		
		vectorI.undo();
		

		expectedValues = new boolean[] {false, true, false };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorI.equals(expectedVector)) {
			throw new IllegalStateException(vectorI.toString());
		} else {
			System.out.println("undo von inverter läuft");
		}
		
		vectorI.redo();
		
		
		expectedValues = new boolean[] { true, false, true };
		expectedVector = new BooleanVector(expectedValues);

		if (!vectorI.equals(expectedVector)) {
			throw new IllegalStateException(vectorI.toString());
		} else {
			System.out.println("redo von shifright läuft");
		}
		

		BooleanVector a = new BooleanVector(new boolean[] {false, true, false});

		a.invert();
		System.out.println("invert: [true, false, true]  == " + a.toString() + "  -> " + a.equals(new BooleanVector(new boolean[]{true, false, true})));
		a.shiftLeft();
		System.out.println("lshift: [false, true, true]  == " + a.toString() + "  -> " + a.equals(new BooleanVector(new boolean[]{false, true, true})));
		a.invert();
		System.out.println("invert: [true, false, false] == " + a.toString() + " -> " + a.equals(new BooleanVector(new boolean[]{true, false, false})));
		a.shiftRight();
		System.out.println("rshift: [false, true, false] == " + a.toString() + " -> " + a.equals(new BooleanVector(new boolean[]{false, true, false})));
		a.undo();
		System.out.println("un rsh: [true, false, false] == " + a.toString() + " -> " + a.equals(new BooleanVector(new boolean[]{true, false, false})));
		a.undo();
		System.out.println("un inv: [false, true, true]  == " + a.toString() + "  -> " + a.equals(new BooleanVector(new boolean[]{false, true, true})));
		a.undo();
		System.out.println("un lsh: [true, false, true]  == " + a.toString() + "  -> " + a.equals(new BooleanVector(new boolean[]{true, false, true})));
		a.redo();
		System.out.println("re lsh: [false, true, true]  == " + a.toString() + "  -> " + a.equals(new BooleanVector(new boolean[]{false, true, true})));
		a.redo();
		System.out.println("re inv: [true, false, false] == " + a.toString() + " -> " + a.equals(new BooleanVector(new boolean[]{true, false, false})));
		a.redo();
		System.out.println("re rsh: [false, true, false] == " + a.toString() + " -> " + a.equals(new BooleanVector(new boolean[]{false, true, false})));


		try {
			a.undo(); a.invert(); a.redo();
		} catch (IllegalStateException e) {
			System.out.println("redo queue wird erfolgreich geleert, wenn eine neue Methode ausgeführt wurde");
		}

		for (int i = 0; i < 7; i++) a.invert();
		try{
			for (int i = 0; i < 11; i++) a.undo();
		}catch (IllegalStateException e){
			System.out.println("undo queue enthält maximal 10 elemente");

		}

	}
}
