package br.edu.fanor.estruturadedados.cap2;

import br.edu.fanor.estruturadedados.cap1.BuscaLinear;

/**
 * Algoritmo que implementa Lista Simples - Lista Linear em Alocação Sequencial
 * Caracteristicas: - Não Permite repetidos - Tamanho Variável - Nao Thread-Safe
 * 
 * @author patrick.cunha
 * @since 19/02/2016
 */
public class ListaSNRD<E> extends ListaSRF<E> implements Lista<E> {

	@Override
	public void add(E e) {
		Integer indice = BuscaLinear.buscar(this.getElementos(), e);
		if (indice == null) {
			this.garanteEspaco();
			super.add(e);
		}
	}

	@Override
	public void add(int i, E e) {
		Integer indice = BuscaLinear.buscar(this.getElementos(), e);
		if (indice == null) {
			garanteEspaco();
			super.add(i, e);
		}
	}

	private void garanteEspaco() {
		if (this.getIndex() == this.getElementos().length) {
			Object[] itens = new Object[this.getElementos().length * 2];
			for (int i = 0; i < this.size(); i++) {
				itens[i] = this.get(i);
			}
			this.setElementos(itens);
		}
	}

}
