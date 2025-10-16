import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

/**
 * @author Gabri
 */

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida. Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF para consulta",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente para exclusão",
                        "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isAlteracao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente para alteração",
                        "Alteração", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        // Validação básica do CPF
        if (!isCpfValido(dados)) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        // Verificar se todos os campos foram preenchidos
        if (dadosSeparados.length < 7) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar CPF
        if (!isCpfValido(dadosSeparados[1])) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criar cliente com os dados
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isExclusao(String opcao) {
        return "3".equals(opcao);
    }

    private static void excluir(String dados) {
        // Validar CPF
        if (!isCpfValido(dados)) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean excluido = iClienteDAO.excluir(Long.parseLong(dados));
        if (excluido) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para exclusão.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isAlteracao(String opcao) {
        return "4".equals(opcao);
    }

    private static void alterar(String dados) {
        // Validar CPF
        if (!isCpfValido(dados)) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteExistente = iClienteDAO.consultar(Long.parseLong(dados));
        if (clienteExistente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para alteração.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Solicitar novos dados para alteração
        String novosDados = JOptionPane.showInputDialog(null,
                "Digite os novos dados do cliente separados por vírgula: Nome, Telefone, Endereço, Número, Cidade, Estado",
                "Alteração", JOptionPane.INFORMATION_MESSAGE);

        String[] novosDadosSeparados = novosDados.split(",");
        if (novosDadosSeparados.length < 6) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios para alteração", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualizar cliente com os novos dados
        clienteExistente.setNome(novosDadosSeparados[0]);
        clienteExistente.setTel(Long.valueOf(novosDadosSeparados[1]));
        clienteExistente.setEnd(novosDadosSeparados[2]);
        clienteExistente.setNumero(Integer.valueOf(novosDadosSeparados[3]));
        clienteExistente.setCidade(novosDadosSeparados[4]);
        clienteExistente.setEstado(novosDadosSeparados[5]);

        boolean alterado = iClienteDAO.alterar(clienteExistente);
        if (alterado) {
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static boolean isCpfValido(String cpf) {
        // Implementação simples de validação de CPF (tamanho e formato)
        return cpf != null && cpf.matches("\\d{11}");
    }
}

