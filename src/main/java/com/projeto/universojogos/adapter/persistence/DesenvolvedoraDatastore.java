package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.DesenvolvedoraMapper;
import com.projeto.universojogos.adapter.outbound.DesenvolvedoraRepository;
import com.projeto.universojogos.application.port.outbound.DesenvolvedoraOutbound;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import com.projeto.universojogos.core.exception.NotFoundException;
import com.projeto.universojogos.core.util.LoggingBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DesenvolvedoraDatastore implements DesenvolvedoraOutbound {
    private final LoggingBase LOGGER = new LoggingBase(DesenvolvedoraDatastore.class);
    private final DesenvolvedoraRepository desenvolvedoraRepository;

    @Override
    public Desenvolvedora salvar(Desenvolvedora desenvolvedora) throws Exception {
        var entity = DesenvolvedoraMapper.INSTANCE.toEntity(desenvolvedora);
        try{
            var resultado = desenvolvedoraRepository.save(entity);
            return DesenvolvedoraMapper.INSTANCE.toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public Desenvolvedora consultarPorId(Desenvolvedora desenvolvedora) throws Exception {
        var desenvolvedoraId = desenvolvedora.getId();
        var resultado = desenvolvedoraRepository.findById(desenvolvedoraId);

        if(resultado.isEmpty()) throw new NotFoundException("Desenvolvedora não encontrada. Código solicitado: "+
                desenvolvedoraId);

        return DesenvolvedoraMapper.INSTANCE.toDomain(resultado.get());
    }

    @Override
    public Desenvolvedora atualizar(Desenvolvedora desenvolvedora) throws Exception{
        var entity = DesenvolvedoraMapper.INSTANCE.toEntity(desenvolvedora);
        var desenvolvedoraId = entity.getId();
        var desenvolvedoraEncontrada = desenvolvedoraRepository.findById(desenvolvedoraId);

        if(desenvolvedoraEncontrada.isEmpty())
            throw new NotFoundException("Desenvolvedora não encontrada. Código solicitada: "+desenvolvedoraId);

        desenvolvedoraEncontrada.get().setNome(entity.getNome());
        try{
           var resultado = desenvolvedoraRepository.save(desenvolvedoraEncontrada.get());
           return DesenvolvedoraMapper.INSTANCE.toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public void deletar(Desenvolvedora desenvolvedora) {

    }
}
