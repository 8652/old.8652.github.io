package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.BizItemInfoRes;
import com.digitalgd.bigdata.business.repository.BizItemInfoResRepository;
import com.digitalgd.bigdata.business.service.dto.BizItemInfoResDTO;
import com.digitalgd.bigdata.business.service.mapper.BizItemInfoResMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BizItemInfoRes}.
 */
@Service
@Transactional
public class BizItemInfoResService {

    private final Logger log = LoggerFactory.getLogger(BizItemInfoResService.class);

    private final BizItemInfoResRepository bizItemInfoResRepository;

    private final BizItemInfoResMapper bizItemInfoResMapper;

    public BizItemInfoResService(BizItemInfoResRepository bizItemInfoResRepository, BizItemInfoResMapper bizItemInfoResMapper) {
        this.bizItemInfoResRepository = bizItemInfoResRepository;
        this.bizItemInfoResMapper = bizItemInfoResMapper;
    }

    /**
     * Save a bizItemInfoRes.
     *
     * @param bizItemInfoResDTO the entity to save.
     * @return the persisted entity.
     */
    public BizItemInfoResDTO save(BizItemInfoResDTO bizItemInfoResDTO) {
        log.debug("Request to save BizItemInfoRes : {}", bizItemInfoResDTO);
        BizItemInfoRes bizItemInfoRes = bizItemInfoResMapper.toEntity(bizItemInfoResDTO);
        bizItemInfoRes = bizItemInfoResRepository.save(bizItemInfoRes);
        return bizItemInfoResMapper.toDto(bizItemInfoRes);
    }

    /**
     * Get all the bizItemInfoRes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BizItemInfoResDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BizItemInfoRes");
        return bizItemInfoResRepository.findAll(pageable)
            .map(bizItemInfoResMapper::toDto);
    }


    /**
     * Get one bizItemInfoRes by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BizItemInfoResDTO> findOne(Long id) {
        log.debug("Request to get BizItemInfoRes : {}", id);
        return bizItemInfoResRepository.findById(id)
            .map(bizItemInfoResMapper::toDto);
    }

    /**
     * Delete the bizItemInfoRes by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BizItemInfoRes : {}", id);
        bizItemInfoResRepository.deleteById(id);
    }
}
