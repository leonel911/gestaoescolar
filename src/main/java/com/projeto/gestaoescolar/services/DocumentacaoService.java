package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Documentacao;
import com.projeto.gestaoescolar.repositories.DocumentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentacaoService {

    @Autowired
    private DocumentacaoRepository documentacaoRepository;

    public Documentacao create(Documentacao documentacao) {
        return documentacaoRepository.save(documentacao);
    }


    public Documentacao findDocumentacaoById(Integer id) {
        return documentacaoRepository.findDocumentacaoById(id);
    }

    public List<Documentacao> findAll() {
        return documentacaoRepository.findAll();
    }

    public Documentacao update(Documentacao documentacao) {
        Documentacao newDocumentacao = findDocumentacaoById(documentacao.getId());

        if(documentacao.getCtps() == null) {
            documentacao.setCtps(newDocumentacao.getCtps());
        } else {
            newDocumentacao.setCtps(documentacao.getCtps());
        }

        if(documentacao.getDataEmissaoRg() == null) {
            documentacao.setDataEmissaoRg(newDocumentacao.getDataEmissaoRg());
        } else {
            newDocumentacao.setDataEmissaoRg(documentacao.getDataEmissaoRg());
        }

        if(documentacao.getNumeroCpf() == null) {
            documentacao.setNumeroCpf(newDocumentacao.getNumeroCpf());
        } else {
            newDocumentacao.setNumeroCpf(documentacao.getNumeroCpf());
        }

        if(documentacao.getNumeroRg() == null) {
            documentacao.setNumeroRg(newDocumentacao.getNumeroRg());
        } else {
            newDocumentacao.setNumeroRg(documentacao.getNumeroRg());
        }

        if(documentacao.getOrgaoExpeditorRg() == null) {
            documentacao.setOrgaoExpeditorRg(newDocumentacao.getOrgaoExpeditorRg());
        } else {
            newDocumentacao.setOrgaoExpeditorRg(documentacao.getOrgaoExpeditorRg());
        }

        if(documentacao.getResponsavel() == null) {
            documentacao.setResponsavel(newDocumentacao.getResponsavel());
        } else {
            newDocumentacao.setResponsavel(documentacao.getResponsavel());
        }

        return documentacao;

    }

    public void delete(Integer id) {
        documentacaoRepository.deleteById(id);
    }
}
