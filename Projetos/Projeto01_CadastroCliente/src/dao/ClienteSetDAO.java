/**
 * @author Gabri
 */

package dao;


    import domain.Cliente;

    import java.util.Collection;
    import java.util.HashSet;
    import java.util.Set;

    public class ClienteSetDAO implements IClienteDAO {

        private Set<Cliente> set;

        public ClienteSetDAO() {
            this.set = new HashSet<>();
        }

        @Override
        public Boolean cadastrar(Cliente cliente) {
            return this.set.add(cliente); // O método add retorna false se o cliente já existir no set
        }

        @Override
        public boolean excluir(Long cpf) {
            Cliente clienteCadastrado = consultar(cpf);
            if (clienteCadastrado != null) {
                this.set.remove(clienteCadastrado); // Remover o cliente do set
            }
            return false;
        }

        @Override
        public boolean alterar(Cliente cliente) {
            excluir(cliente.getCpf()); // Remove o cliente antigo
            cadastrar(cliente);        // Adiciona o cliente com dados alterados
            return false;
        }

        @Override
        public Cliente consultar(Long cpf) {
            for (Cliente cliente : set) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
            return null; // Retorna null se não encontrar
        }

        @Override
        public Collection<Cliente> buscarTodos() {
            return this.set;
        }
    }

