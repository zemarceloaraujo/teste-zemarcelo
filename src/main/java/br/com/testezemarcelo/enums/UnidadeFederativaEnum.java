package br.com.testezemarcelo.enums;

public enum UnidadeFederativaEnum {
	
	ACRE("Acre", "AC"),
	ALAGOAS("Alagoas", "AL"),
	AMAPA("Amapá", "AP"),
	AMAZONAS("Amazonas", "AM"), 
	BAHIA("Bahia", "BA"), 
	CEARA("Ceará", "CE"), 
	DISTRITO_FEDERAL("Distrito Federal", "DF"),
	ESPIRITO_SANTO("Espírito Santo", "ES"),
	GOIAS("Goiás", "GO"),
	MARANHAO("Maranhão", "MA"), 
	MATO_GROSSO("Mato Grosso", "MT"),
	MINAS_GERAIS("Minas Gerais", "MG"),
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"), 
	PARAIBA("Paraíba", "PB"),
	PERNAMBUCO("Pernambuco", "PE"),
	PIAUI("Piauí", "PI"), 
	RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
	RONDONIA("Rondônia", "RO"), 
	RORAIMA("Roraima", "RR"),
	PARANA("Paraná", "PR"), 
	RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN"), 
	SAO_PAULO("São Paulo", "SP"),
	SANTA_CATARINA("Santa Catarina", "SC"), 
	SERGIPE("Sergipe", "SE"),
	TOCANTINS("Tocantins", "TO");
	
	private final String estado;
	private final String sigla;
		
	UnidadeFederativaEnum(final String estado, final String sigla) {
    this.estado = estado;
    this.sigla = sigla;
   
   }

	public String getEstado() {
		return estado;
	}

	public String getSigla() {
		return sigla;
	}

}
