package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.AuthLetterRecord;
import com.digitalgd.bigdata.business.repository.AuthLetterRecordRepository;
import com.digitalgd.bigdata.business.service.dto.AuthLetterRecordDTO;
import com.digitalgd.bigdata.business.service.mapper.AuthLetterRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AuthLetterRecord}.
 */
@Service
@Transactional
public class AuthLetterRecordService {

    private final Logger log = LoggerFactory.getLogger(AuthLetterRecordService.class);

    private final AuthLetterRecordRepository authLetterRecordRepository;

    private final AuthLetterRecordMapper authLetterRecordMapper;

    public AuthLetterRecordService(AuthLetterRecordRepository authLetterRecordRepository, AuthLetterRecordMapper authLetterRecordMapper) {
        this.authLetterRecordRepository = authLetterRecordRepository;
        this.authLetterRecordMapper = authLetterRecordMapper;
    }

    /**
     * Save a authLetterRecord.
     *
     * @param authLetterRecordDTO the entity to save.
     * @return the persisted entity.
     */
    public AuthLetterRecordDTO save(AuthLetterRecordDTO authLetterRecordDTO) {
        log.debug("Request to save AuthLetterRecord : {}", authLetterRecordDTO);
        AuthLetterRecord authLetterRecord = authLetterRecordMapper.toEntity(authLetterRecordDTO);
        authLetterRecord = authLetterRecordRepository.save(authLetterRecord);
        return authLetterRecordMapper.toDto(authLetterRecord);
    }

    /**
     * Get all the authLetterRecords.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthLetterRecordDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AuthLetterRecords");
        return authLetterRecordRepository.findAll(pageable)
            .map(authLetterRecordMapper::toDto);
    }


    /**
     * Get one authLetterRecord by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AuthLetterRecordDTO> findOne(Long id) {
        log.debug("Request to get AuthLetterRecord : {}", id);
        return authLetterRecordRepository.findById(id)
            .map(authLetterRecordMapper::toDto);
    }

    /**
     * Delete the authLetterRecord by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AuthLetterRecord : {}", id);
        authLetterRecordRepository.deleteById(id);
    }
}
