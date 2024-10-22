package br.com.grupo1.gp1_api.security.enums;

public enum RoleEnum {
    
	ROLE_CLIENTE("Role Cliente", 1),
	ROLE_FUNCIONARIO("Role Funcionário", 2);
	
	private String tipo;
    private int codigo;

    private RoleEnum(String tipo, int codigo) {
        this.tipo = tipo;
        this.codigo = codigo;
    }
    
    private RoleEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo () {
        return codigo;
    }
    
    public String getTipo () {
        return tipo;
    } 
}