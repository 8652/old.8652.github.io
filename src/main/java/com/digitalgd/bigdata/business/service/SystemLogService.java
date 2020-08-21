package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.SystemLog;
import com.digitalgd.bigdata.business.repository.SystemLogRepository;
import com.digitalgd.bigdata.business.service.dto.SystemLogDTO;
import com.digitalgd.bigdata.business.service.mapper.SystemLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SystemLog}.
 */
@Service
@Transactional
public class SystemLogService {

    private final Logger log = LoggerFactory.getLogger(SystemLogService.class);

    private final SystemLogRepository systemLogRepository;

    private final SystemLogMapper systemLogMapper;

    public SystemLogService(SystemLogRepository systemLogRepository, SystemLogMapper systemLogMapper) {
        this.systemLogRepository = systemLogRepository;
        this.systemLogMapper = systemLogMapper;
    }

    /**
     * Save a systemLog.
     *
     * @param systemLogDTO the entity to save.
     * @return the persisted entity.
     */
    public SystemLogDTO save(SystemLogDTO systemLogDTO) {
        log.debug("Request to save SystemLog : {}", systemLogDTO);
        SystemLog systemLog = systemLogMapper.toEntity(systemLogDTO);
        systemLog = systemLogRepository.save(systemLog);
        return systemLogMapper.toDto(systemLog);
    }

    /**
     * Get all the systemLogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SystemLogDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SystemLogs");
        return systemLogRepository.findAll(pageable)
            .map(systemLogMapper::toDto);
    }


    /**
     * Get one systemLog by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SystemLogDTO> findOne(Long id) {
        log.debug("Request to get SystemLog : {}", id);
        return systemLogRepository.findById(id)
            .map(systemLogMapper::toDto);
    }

    /**
     * Delete the systemLog by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SystemLog : {}", id);
        systemLogRepository.deleteById(id);
    }
}
