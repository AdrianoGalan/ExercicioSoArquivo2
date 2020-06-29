package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();

	}

	@Override
	public void verificaDirTemp() throws IOException {

		String path = "c:\\temp";

		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {

		} else {
			if (dir.mkdir()) {
				System.out.println("Diretorio criado");
			} else {
				throw new IOException("Erro ao criar diretório");
			}

		}

	}

	@Override
	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {

		String path = "c:\\temp";
		File arq = new File(path, arquivo);

		if (arq.exists() && arq.isFile()) {

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String[] linha = buffer.readLine().split(";");
			while (linha != null) {

				if (linha[0].equalsIgnoreCase(String.valueOf(codigo))) {
					return true;
				}

				try {
					linha = buffer.readLine().split(";");
				} catch (Exception e) {
					linha = null;
				}

			}
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Aqruivo não existe");
		}

		return false;

	}

	@Override
	public void imprimeCadastro(String arquivo, int codigo) throws IOException {

		if (verificaRegistro(arquivo, codigo)) {

			String path = "c:\\temp";
			File arq = new File(path, arquivo);

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String[] linha = buffer.readLine().split(";");
			while (linha != null) {

				if (linha[0].equalsIgnoreCase(String.valueOf(codigo))) {
					System.out.println("Código: " + linha[0]);
					System.out.println("Nome: " + linha[1]);
					System.out.println("Email: " + linha[2]);
					
					buffer.close();
					leitor.close();
					fluxo.close();
					
					return;
					
				}

				try {
					linha = buffer.readLine().split(";");
				} catch (Exception e) {
					linha = null;
				}

			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
			

		}
		System.out.println("Cadastro codigo " + codigo + " não existe");

	}

	@Override
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {

		File arq = new File("c:\\temp", arquivo);
		
		if (!verificaRegistro(arquivo, codigo)) {

			FileWriter file = new FileWriter(arq, true);
			PrintWriter print = new PrintWriter(file);
			print.write(codigo + ";" + nome + ";" + email);
			print.flush();
			print.close();
			file.close();
			System.out.println("Cadastro da " + nome + " realizado");

		} else {
			System.out.println("Cadastro ja existe");
		}

	}

}
