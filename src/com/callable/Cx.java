package com.callable;

import java.util.LinkedList;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-30 10:38
 * @describe:
 */
public class Cx {

    public LinkedList<ReMess> chuli(String code, String ms) {
        System.out.println("执行 Cx code" + code + " ms:" + ms);
        LinkedList<ReMess> reMesses = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            reMesses.add(new ReMess(code + ":" + i, ms + ":" + Thread.currentThread().getName()));
        }
        return reMesses;
    }

    public class ReMess {
        private String code;
        private String mes;

        public ReMess(String code, String mes) {
            this.code = code;
            this.mes = mes;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMes() {
            return mes;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }
    }
}
