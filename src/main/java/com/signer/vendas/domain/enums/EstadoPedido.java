package com.signer.vendas.domain.enums;



public enum EstadoPedido {

	EM_ABERTO(1,"Pedido em Aberto"),
	AGUARDANDO_DOCUMENTOS(2,"Pedido aguardando a documentacao do cliente"),
	FECHADO(3,"Pedido fechado");
	
	private int cod;
	private String descricao;
	
	private EstadoPedido(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPedido toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoPedido x : EstadoPedido.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido "+ cod);
	}
	
}
