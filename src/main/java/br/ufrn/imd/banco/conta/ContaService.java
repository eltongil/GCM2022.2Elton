package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

public class ContaService {

    private final ContaRepository repository;
    private static final ContaService singleton =  new ContaService();

    private ContaService() {
        this.repository = ContaRepository.getInstance();
    }

    public static ContaService getInstance() {
        return singleton;
    }

    public void addConta(String numero) throws BadArgumentException {
        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        long numeroConta = Long.parseLong(numero);

        if (this.verificarNumeroDisponivel(numeroConta))
            repository.addCliente(new ContaModel(numeroConta));
        else
            throw new BadArgumentException("Já existe conta com esse número");
    }

    private void verificarStringNumero(String numero) throws BadArgumentException {
        try {
            Long.valueOf(numero);
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O numero da conta não pode conter letras ou caracteres especiais");
        }
    }

    private void verificarStringVazia(String numero) throws BadArgumentException {
        if (numero.isBlank())
            throw new BadArgumentException("O numero de conta informado é vazio");
    }

    public Boolean verificarNumeroDisponivel(Long numero) {
        return !repository.verificarNumeroUtilizado(numero);
    }

    public String consultarSaldo(Long numero) throws BadArgumentException{
        this.verificarStringVazia(numero.toString());
        this.verificarStringNumero(numero.toString());
        ContaModel conta =  repository.getByNumero(numero);

        if(conta != null){
            return String.format("$ %.2L",conta.getSaldo());
        }else{
            throw new BadArgumentException("Conta inexistente.");
        }
    }
}
