package bancarios_tsi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Cliente implements Serializable{

    /*
     *
     */
    private static final long serialVersionUID = 1l;
    String cpf;
    String nome;

    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String cpf) {
        this.cpf = cpf;
    }
    
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void adicionarConta(Conta c) {
        if (Conta.contains(c)) {
            System.out.println("Conta já cadastrada");
        } else { 
            contas.add(c);
        }
    }

    public void removerConta(Conta c, Conta conta) {
        if (Conta.contains(c)) {
            contas.remove(c);
        } else { 
            System.out.println("Conta não cadastrada para este cliente");
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas +"]";
    }

    public ArrayList<Conta> getConta() {
        return contas;
    }
}
