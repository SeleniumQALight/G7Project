package api.dto.responsDto;


    public class ResponsDtoPB {
        private String ccy;
        private String base_ccy;
        private String buy;
        private String sale;

        public ResponsDtoPB() { // пустий конструктор
        }

        public ResponsDtoPB(String ccy, String base_ccy, String buy, String sale) {// конструктор
            this.ccy = ccy;
            this.base_ccy = base_ccy;
            this.buy = buy;
            this.sale = sale;
        }

        // Геттери та сеттери для полів

        public String getCcy() {
            return ccy;
        }

        public void setCcy(String ccy) {
            this.ccy = ccy;
        }

        public String getBase_ccy() {
            return base_ccy;
        }

        public void setBase_ccy(String base_ccy) {
            this.base_ccy = base_ccy;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }

        @Override
        public String toString() {
            return "ResponsDtoPB{" +
                    "ccy='" + ccy + '\'' +
                    ", base_ccy='" + base_ccy + '\'' +
                    ", buy='" + buy + '\'' +
                    ", sale='" + sale + '\'' +
                    '}';
        }
    }



