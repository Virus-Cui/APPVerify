package cn.mrcsh.backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

public class BaseController {

    @Data
    @AllArgsConstructor
    public static class R {
        private Integer code;
        private String msg;
        private Object data;

        public static R ok() {
            return new R(200, "success", null);
        }

        public static R ok(Object data){
            return new R(200, "success", data);
        }

        public static R err() {
            return new R(500, "error", null);
        }

        public static R err(String message) {
            return new R(500, message, null);
        }

    }
}
