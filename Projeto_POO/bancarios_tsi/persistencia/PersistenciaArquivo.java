package bancarios_tsi.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bancarios_tsi.Cliente;


public class PersistenciaArquivo {

    ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    
    public PersistenciaArquivo() {
        carregarArquvo();
    }

    public void cadastrarCliente(Cliente c) {
        if (clientesCadastrados.contains(c)) {
            System.out.println("Cliente já cadastrado!");
        } else {
            clientesCadastrados.add(c);
        }
    }

    public Cliente buscarClienteCPF(String cpf) {
        Cliente temp = new Cliente(cpf);
        if (clientesCadastrados.contains(temp)) {
            int index = clientesCadastrados.indexOf(temp);
            temp = clientesCadastrados.get(index);
            return temp;
        } else {
            return null;
        }
    }

    public void salvarArquivo() {
        try {
            FileOutputStream fos = new FileOutputStream("dados");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientesCadastrados);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }  

    public void carregarArquvo() {
        try {
            FileInputStream fis = new FileInputStream("dados");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientesCadastrados = (ArrayList<Cliente>)ois.readObject();
         } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void atualizarCliente(Cliente c) {
        if (clientesCadastrados.contains(c)) {
            int index = clientesCadastrados.indexOf(c);
            clientesCadastrados.set(index, c);
            salvarArquivo();
        } else {
            System.out.println("Cliente não cadastrado.");
        }
    }
}
