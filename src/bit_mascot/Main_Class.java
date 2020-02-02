package bit_mascot;

public class Main_Class {

	public static void main(String[] args) {
		
		(new Thread(new URLRead_FileWrite())).start();
		
		(new Thread(new FileRead_ListPrint())).start();
	}
}