import br.ufrn.imd.banco.conta.ContaController;
import br.ufrn.imd.banco.conta.ContaModel;
import br.ufrn.imd.banco.conta.ContaRepository;
import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TesteCriarConta {

    @Test
    public void testAdicionarContaPadrao() throws BadArgumentException {
        ContaController.adicionarConta("1", "padrao", "0");
        assertDoesNotThrow(() -> ContaRepository.getInstance().getByNumero(1L));
    }

    @Test
    public void testDeposito() throws BadArgumentException {
        ContaController.adicionarConta("2", "padrao", "0");
        ContaController.deposito(2L, new BigDecimal(300));
        assertEquals(new BigDecimal(300), ContaRepository.getInstance().getByNumero(2L).getSaldo());
    }

    @Test
    public void testSaque() throws BadArgumentException {
        ContaController.adicionarConta("3", "padrao", "0");
        ContaController.deposito(3L, new BigDecimal(300));
        ContaController.saque(3L, new BigDecimal(300));
        assertEquals(BigDecimal.ZERO, ContaRepository.getInstance().getByNumero(3L).getSaldo());
    }

    @Test
    public void testTransferenciaOrigem() throws BadArgumentException {
        ContaController.adicionarConta("4", "padrao", "0");
        ContaController.deposito(4L, new BigDecimal(300));
        ContaController.adicionarConta("5", "padrao", "0");
        ContaController.transferencia(4L, 5L, new BigDecimal(300));
        assertEquals(BigDecimal.ZERO, ContaRepository.getInstance().getByNumero(4L).getSaldo());
    }

    @Test
    public void testTransferenciaDestino() throws BadArgumentException {
        ContaController.adicionarConta("7", "padrao", "0");
        ContaController.deposito(7L, new BigDecimal(300));
        ContaController.adicionarConta("8", "padrao", "0");
        ContaController.transferencia(7L, 8L, new BigDecimal(300));
        assertEquals(new BigDecimal(300), ContaRepository.getInstance().getByNumero(8L).getSaldo());
    }

    @Test
    public void testSaldo() throws BadArgumentException {
        ContaController.adicionarConta("6", "padrao", "0");
        String test = ContaService.getInstance().consultarSaldo(6L);
        assertEquals("$ 0", test);
    }

}
