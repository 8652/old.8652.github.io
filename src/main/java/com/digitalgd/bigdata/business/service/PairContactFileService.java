package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.PairContactFile;
import com.digitalgd.bigdata.business.repository.PairContactFileRepository;
import com.digitalgd.bigdata.business.service.dto.PairContactFileDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContactFileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PairContactFile}.
 */
@Service
@Transactional
public class PairContactFileService {

    private final Logger log = LoggerFactory.getLogger(PairContactFileService.class);

    private final PairContactFileRepository pairContactFileRepository;

    private final PairContactFileMapper pairContactFileMapper;

    public PairContactFileService(PairContactFileRepository pairContactFileRepository, PairContactFileMapper pairContactFileMapper) {
        this.pairContactFileRepository = pairContactFileRepository;
        this.pairContactFileMapper = pairContactFileMapper;
    }

    /**
     * Save a pairContactFile.
     *
     * @param pairContactFileDTO the entity to save.
     * @return the persisted entity.
     */
    public PairContactFileDTO save(PairContactFileDTO pairContactFileDTO) {
        log.debug("Request to save PairContactFile : {}", pairContactFileDTO);
        PairContactFile pairContactFile = pairContactFileMapper.toEntity(pairContactFileDTO);
        pairContactFile = pairContactFileRepository.save(pairContactFile);
        return pairContactFileMapper.toDto(pairContactFile);
    }

    /**
     * Get all the pairContactFiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PairContactFileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PairContactFiles");
        return pairContactFileRepository.findAll(pageable)
            .map(pairContactFileMapper::toDto);
    }


    /**
     * Get one pairContactFile by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PairContactFileDTO> findOne(Long id) {
        log.debug("Request to get PairContactFile : {}", id);
        return pairContactFileRepository.findById(id)
            .map(pairContactFileMapper::toDto);
    }

    /**
     * Delete the pairContactFile by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PairContactFile : {}", id);
        pairContactFileRepository.deleteById(id);
    }
}
