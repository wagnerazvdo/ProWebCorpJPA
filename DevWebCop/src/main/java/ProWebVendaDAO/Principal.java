package ProWebVendaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import ProWebVendaDAO.RepositoryCliente.RepositoryCliente;


public class Principal {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendas");

		EntityManager em = emf.createEntityManager();
		
		
		
	
		String descricaoOpcao = "1 - Cadastrar \n" + "2 - Editar\n" + "3 - Remover\n" +  "4 - Sair";
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(descricaoOpcao));

		switch (opcao) {
		case 1:

			String descricao = JOptionPane.showInputDialog("Informe a descrição");
			String valorCompra = JOptionPane.showInputDialog("Informe o valor de compra");
			String valor = JOptionPane.showInputDialog("Informe o valor para venda");
			
			try {

				Produto p = new Produto();
				p.setDescricao(descricao);
				p.setValor(Double.parseDouble(valor));
				p.setValorCompra(Double.parseDouble(valorCompra));

				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();

				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
				
				
				

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null,
						"Erro ao cadastrar o produto. Verifique os dados e tente novamente");
			}
			break;

		case 2:
			
			String descricaoOpcao2 = JOptionPane.showInputDialog(null,"Informe o id do produto");
			String descricaoOpcao3 = JOptionPane.showInputDialog(null,"Informe o novo nome do produto:");
			RepositoryCliente repositoryCliente = new RepositoryCliente();
			int idproduto = Integer.parseInt(descricaoOpcao2);
			Produto produto = repositoryCliente.obterId(idproduto);
			produto.setDescricao(descricaoOpcao3);
			repositoryCliente.salvar(produto);
			JOptionPane.showMessageDialog(null, "Produto Editado com sucesso");
			

			break;

		case 3:
			String descricaoOpcao5 = JOptionPane.showInputDialog(null,"Informe o id do produto a ser deletado");	
			int idproduto5 = Integer.parseInt(descricaoOpcao5);
			RepositoryCliente repositorioCliente4 = new RepositoryCliente();
			Produto produto9 = repositorioCliente4.obterId(idproduto5);
			repositorioCliente4.remover(produto9);
			JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");

			break;

		case 4:

			JOptionPane.showMessageDialog(null, "Obrigado e volte sempre.");
			break;
		default:

			JOptionPane.showMessageDialog(null, "Opção Invalida!");
			break;
		}

	}

}
