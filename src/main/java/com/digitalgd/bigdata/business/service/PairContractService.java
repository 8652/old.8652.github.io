package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.PairContract;
import com.digitalgd.bigdata.business.repository.PairContractRepository;
import com.digitalgd.bigdata.business.service.dto.PairContractDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PairContract}.
 */
@Service
@Transactional
public class PairContractService {

    private final Logger log = LoggerFactory.getLogger(PairContractService.class);

    private final PairContractRepository pairContractRepository;

    private final PairContractMapper pairContractMapper;

    public PairContractService(PairContractRepository pairContractRepository, PairContractMapper pairContractMapper) {
        this.pairContractRepository = pairContractRepository;
        this.pairContractMapper = pairContractMapper;
    }

    /**
     * Save a pairContract.
     *
     * @param pairContractDTO the entity to save.
     * @return the persisted entity.
     */
    public PairContractDTO save(PairContractDTO pairContractDTO) {
        log.debug("Request to save PairContract : {}", pairContractDTO);
        PairContract pairContract = pairContractMapper.toEntity(pairContractDTO);
        pairContract = pairContractRepository.save(pairContract);
        return pairContractMapper.toDto(pairContract);
    }

    /**
     * Get all the pairContracts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PairContractDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PairContracts");
        return pairContractRepository.findAll(pageable)
            .map(pairContractMapper::toDto);
    }


    /**
     * Get one pairContract by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PairContractDTO> findOne(Long id) {
        log.debug("Request to get PairContract : {}", id);
        return pairContractRepository.findById(id)
            .map(pairContractMapper::toDto);
    }

    /**
     * Delete the pairContract by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PairContract : {}", id);
        pairContractRepository.deleteById(id);
    }
}
