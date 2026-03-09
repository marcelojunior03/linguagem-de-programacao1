package exercicio3;

public class Cliente {
	private int codigo;
	private String endereco, telefone;
	
	protected String getEndereco() {
		return endereco;
	}
	protected String getTelefone() {
		return telefone;
	}
	protected int getCodigo() {
		return codigo;
	}
	
	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
