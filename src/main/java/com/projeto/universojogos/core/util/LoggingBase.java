package com.projeto.universojogos.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.universojogos.core.domain.TipoLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoggingBase {
    private final Logger logger;

    public LoggingBase(final Class<?> classe) {
        this.logger = LoggerFactory.getLogger(classe.getName());
    }

    public LoggingBase(final String classe) {
        this.logger = LoggerFactory.getLogger(classe);
    }

    private String fromMapToString(Map<String, Object> mapLogger){
        try{
            return (new ObjectMapper()).writeValueAsString(mapLogger);
        }catch(JsonProcessingException ex){
            return mapLogger.toString();
        }
    }

    private String toMapToString(String mensagem){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("mensagem", mensagem);
        return this.fromMapToString(map);
    }

    private String encode(String mensagem){
        mensagem = mensagem.replace('\n','_')
                           .replace('\r', '_')
                           .replace('\t','_');
        return mensagem;
    }

    private void addInfo(String mensagem){
        this.logger.info("{}", mensagem);
    }

    private void addError(String mensagem, Throwable throwable){
        if(throwable == null){
            this.logger.error(mensagem);
        }else{
            this.logger.error(mensagem, throwable);
        }
    }

    public void info(String mensagem){
        String msg = this.toMapToString(mensagem);
        this.addInfo(this.encode(msg));
    }

    public void info(Map<String,Object> mensagem){
        String msg = this.fromMapToString(mensagem);
        this.addInfo(this.encode(msg));
    }

    public void error(Throwable throwable, Map<String, Object> mensagem){
        String msg = this.fromMapToString(mensagem);
        this.addError(this.encode(msg), throwable);
    }

    public void debug(String mensagem){
        this.logger.debug(mensagem);
    }

    public void createInfoLog(HttpHeaders headers, Object objeto, TipoLog tipoLog, String mensagem){
        Map<String, Object> log = new LinkedHashMap<>();
        log.put("headerEntrada", headers);
        log.put("body", new HttpEntity<>(objeto));
        log.put("tipo", tipoLog);
        log.put("mensagem", mensagem);
        this.info(log);
    }

    public void createErroLog(HttpHeaders headers, Object objeto, TipoLog tipoLog, String mensagem){
        Map<String, Object> log = new LinkedHashMap<>();
        log.put("headerEntrada", headers);
        log.put("body", new HttpEntity<>(objeto));
        log.put("tipo", tipoLog);
        log.put("mensagem", mensagem);
        this.info(log);
    }
}
