package exercicio1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.List;

public class ControleTest {

    @Test
    void deveRetornarProdutosComEstoqueInsuficiente() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        Produto p1 = new Produto("Produto 1", 5, 10, 20);
        estoque.armazena(p1);

        controle.controlaEstoques(estoque);

        List<Produto> lista = controle.getProdutosComEstoqueInsuficiente();
        assertEquals(1, lista.size());
        assertEquals(p1, lista.get(0));
    }

    @Test
    void deveRetornarProdutosComEstoqueExcedente() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        Produto p1 = new Produto("Produto 1", 30, 10, 20);
        estoque.armazena(p1);

        controle.controlaEstoques(estoque);

        List<Produto> lista = controle.getProdutosComEstoqueExcedente();
        assertEquals(1, lista.size());
        assertEquals(p1, lista.get(0));
    }

    @Test
    void deveRetornarProdutosComEstoqueZerado() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        Produto p1 = new Produto("Produto 1", 0, 10, 20);
        estoque.armazena(p1);

        controle.controlaEstoques(estoque);

        List<Produto> lista = controle.getProdutosComEstoqueZerado();
        assertEquals(1, lista.size());
        assertEquals(p1, lista.get(0));
    }

    @Test
    void deveRetornarProdutosComEstoqueAdequado() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        Produto p1 = new Produto("Produto 1", 15, 10, 20);
        estoque.armazena(p1);

        controle.controlaEstoques(estoque);

        List<Produto> lista = controle.getProdutosComEstoqueAdequado();
        assertEquals(1, lista.size());
        assertEquals(p1, lista.get(0));
    }

    @Test
    void deveRetornarTodasListasVaziasParaEstoqueSemProdutos() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        controle.controlaEstoques(estoque);

        assertEquals(0, controle.getProdutosComEstoqueInsuficiente().size());
        assertEquals(0, controle.getProdutosComEstoqueExcedente().size());
        assertEquals(0, controle.getProdutosComEstoqueZerado().size());
        assertEquals(0, controle.getProdutosComEstoqueAdequado().size());
    }

    @Test
    void deveRetornarListaVaziaParaEstoqueQueNaoContemProdutosComEstoqueZerado() {
        Estoque estoque = new Estoque("Loja Teste");
        Controle controle = new Controle();

        Produto p1 = new Produto("Produto 1", 15, 10, 20);
        estoque.armazena(p1);

        controle.controlaEstoques(estoque);

        assertEquals(0, controle.getProdutosComEstoqueZerado().size());
    }
}
