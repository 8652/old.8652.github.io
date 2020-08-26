package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.BigInterfaceBiz;
import com.digitalgd.bigdata.business.repository.BigInterfaceBizRepository;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceBizDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceBizMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BigInterfaceBiz}.
 */
@Service
@Transactional
public class BigInterfaceBizService {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceBizService.class);

    private final BigInterfaceBizRepository bigInterfaceBizRepository;

    private final BigInterfaceBizMapper bigInterfaceBizMapper;

    public BigInterfaceBizService(BigInterfaceBizRepository bigInterfaceBizRepository, BigInterfaceBizMapper bigInterfaceBizMapper) {
        this.bigInterfaceBizRepository = bigInterfaceBizRepository;
        this.bigInterfaceBizMapper = bigInterfaceBizMapper;
    }

    /**
     * Save a bigInterfaceBiz.
     *
     * @param bigInterfaceBizDTO the entity to save.
     * @return the persisted entity.
     */
    public BigInterfaceBizDTO save(BigInterfaceBizDTO bigInterfaceBizDTO) {
        log.debug("Request to save BigInterfaceBiz : {}", bigInterfaceBizDTO);
        BigInterfaceBiz bigInterfaceBiz = bigInterfaceBizMapper.toEntity(bigInterfaceBizDTO);
        bigInterfaceBiz = bigInterfaceBizRepository.save(bigInterfaceBiz);
        return bigInterfaceBizMapper.toDto(bigInterfaceBiz);
    }

    /**
     * Get all the bigInterfaceBizs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BigInterfaceBizDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BigInterfaceBizs");
        return bigInterfaceBizRepository.findAll(pageable)
            .map(bigInterfaceBizMapper::toDto);
    }


    /**
     * Get one bigInterfaceBiz by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BigInterfaceBizDTO> findOne(Long id) {
        log.debug("Request to get BigInterfaceBiz : {}", id);
        return bigInterfaceBizRepository.findById(id)
            .map(bigInterfaceBizMapper::toDto);
    }

    /**
     * Delete the bigInterfaceBiz by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BigInterfaceBiz : {}", id);
        bigInterfaceBizRepository.deleteById(id);
    }
}
