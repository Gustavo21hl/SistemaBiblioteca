package br.com.sistemabiblioteca.view;
 
import javax.swing.JOptionPane;
 
import br.com.sistemabiblioteca.crud.CrudBiblioteca;
 
public class Main {
	//import all classes
	public static void main(String[] args) {
		CrudBiblioteca crudBiblioteca = new CrudBiblioteca();
		int opcao = 0;
		while(opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"BIBLIOTECA: Leiturinha \n" + 
					"1: Cadastrar \n" +
					"2: Listar Todos \n" +
					"3: Listar Específico \n" +
					"4: Atualizar \n" +
					"5: Deletar \n" +
					"9: Sair \n"
					));
			switch(opcao) {
			case 1:
				 crudBiblioteca.create();
			break;
			case 2:
				 crudBiblioteca.read();
			break;
			case 3:
				 crudBiblioteca.readone();
			break;
			case 4:
				crudBiblioteca.update();
			break;
			case 5:
				crudBiblioteca.delete();
			break;
			case 9:
				 System.exit(0);
			break;
			default:
				JOptionPane.showConfirmDialog(null, "Entre com uma opção válida!");

			}
		}
	}
 
}
