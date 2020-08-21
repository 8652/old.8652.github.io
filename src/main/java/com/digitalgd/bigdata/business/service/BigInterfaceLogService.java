package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.BigInterfaceLog;
import com.digitalgd.bigdata.business.repository.BigInterfaceLogRepository;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceLogDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BigInterfaceLog}.
 */
@Service
@Transactional
public class BigInterfaceLogService {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceLogService.class);

    private final BigInterfaceLogRepository bigInterfaceLogRepository;

    private final BigInterfaceLogMapper bigInterfaceLogMapper;

    public BigInterfaceLogService(BigInterfaceLogRepository bigInterfaceLogRepository, BigInterfaceLogMapper bigInterfaceLogMapper) {
        this.bigInterfaceLogRepository = bigInterfaceLogRepository;
        this.bigInterfaceLogMapper = bigInterfaceLogMapper;
    }

    /**
     * Save a bigInterfaceLog.
     *
     * @param bigInterfaceLogDTO the entity to save.
     * @return the persisted entity.
     */
    public BigInterfaceLogDTO save(BigInterfaceLogDTO bigInterfaceLogDTO) {
        log.debug("Request to save BigInterfaceLog : {}", bigInterfaceLogDTO);
        BigInterfaceLog bigInterfaceLog = bigInterfaceLogMapper.toEntity(bigInterfaceLogDTO);
        bigInterfaceLog = bigInterfaceLogRepository.save(bigInterfaceLog);
        return bigInterfaceLogMapper.toDto(bigInterfaceLog);
    }

    /**
     * Get all the bigInterfaceLogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BigInterfaceLogDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BigInterfaceLogs");
        return bigInterfaceLogRepository.findAll(pageable)
            .map(bigInterfaceLogMapper::toDto);
    }


    /**
     * Get one bigInterfaceLog by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BigInterfaceLogDTO> findOne(Long id) {
        log.debug("Request to get BigInterfaceLog : {}", id);
        return bigInterfaceLogRepository.findById(id)
            .map(bigInterfaceLogMapper::toDto);
    }

    /**
     * Delete the bigInterfaceLog by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BigInterfaceLog : {}", id);
        bigInterfaceLogRepository.deleteById(id);
    }
}
