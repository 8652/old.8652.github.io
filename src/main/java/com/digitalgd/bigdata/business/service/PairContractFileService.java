package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.PairContractFile;
import com.digitalgd.bigdata.business.repository.PairContractFileRepository;
import com.digitalgd.bigdata.business.service.dto.PairContractFileDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContractFileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PairContractFile}.
 */
@Service
@Transactional
public class PairContractFileService {

    private final Logger log = LoggerFactory.getLogger(PairContractFileService.class);

    private final PairContractFileRepository pairContractFileRepository;

    private final PairContractFileMapper pairContractFileMapper;

    public PairContractFileService(PairContractFileRepository pairContractFileRepository, PairContractFileMapper pairContractFileMapper) {
        this.pairContractFileRepository = pairContractFileRepository;
        this.pairContractFileMapper = pairContractFileMapper;
    }

    /**
     * Save a pairContractFile.
     *
     * @param pairContractFileDTO the entity to save.
     * @return the persisted entity.
     */
    public PairContractFileDTO save(PairContractFileDTO pairContractFileDTO) {
        log.debug("Request to save PairContractFile : {}", pairContractFileDTO);
        PairContractFile pairContractFile = pairContractFileMapper.toEntity(pairContractFileDTO);
        pairContractFile = pairContractFileRepository.save(pairContractFile);
        return pairContractFileMapper.toDto(pairContractFile);
    }

    /**
     * Get all the pairContractFiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PairContractFileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PairContractFiles");
        return pairContractFileRepository.findAll(pageable)
            .map(pairContractFileMapper::toDto);
    }


    /**
     * Get one pairContractFile by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PairContractFileDTO> findOne(Long id) {
        log.debug("Request to get PairContractFile : {}", id);
        return pairContractFileRepository.findById(id)
            .map(pairContractFileMapper::toDto);
    }

    /**
     * Delete the pairContractFile by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PairContractFile : {}", id);
        pairContractFileRepository.deleteById(id);
    }
}
