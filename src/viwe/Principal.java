package viwe;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {

	public static void main(String[] args) {
		ArquivosController arq = new ArquivosController();
		
		try {
			arq.imprimeCadastro("alunos.csv", 1);
			System.out.println("");
			arq.insereCadastro("alunos.csv", 1, "izabel", "izabel@fatec.com.br");
			System.out.println("");
			arq.insereCadastro("alunos.csv", 4, "izabel", "izabel@fatec.com.br");
			System.out.println("");
		arq.imprimeCadastro("alunos.csv", 4);
			arq.imprimeCadastro("alunos.csv", 5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
