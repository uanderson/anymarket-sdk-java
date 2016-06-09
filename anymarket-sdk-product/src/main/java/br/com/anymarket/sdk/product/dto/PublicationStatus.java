package br.com.anymarket.sdk.product.dto;

/**
 * Status da publicação no Market Place
 */
public enum PublicationStatus {

    UNPUBLISHED {
        public String getName() {
            return "Não publicado";
        }
    },
    CLOSED {
        public String getName() {
            return "Finalizado";
        }
    },
    CORRUPTED {
        public String getName() {
            return "Corrompido";
        }
    },
    PAUSED {
        public String getName() {
            return "Pausado";
        }
    },
    WITHOUT_STOCK {
        public String getName() {
            return "Sem estoque";
        }
    },
    ACTIVE {
        public String getName() {
            return "Ativo";
        }
    };

    public abstract String getName();
}
