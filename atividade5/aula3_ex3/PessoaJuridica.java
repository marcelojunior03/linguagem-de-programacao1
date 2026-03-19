package aula3_ex3;

public class PessoaJuridica extends Cliente {
	private String razaoSocial, cnpj;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
