package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.BigInterfaceList;
import com.digitalgd.bigdata.business.repository.BigInterfaceListRepository;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceListDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceListMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BigInterfaceList}.
 */
@Service
@Transactional
public class BigInterfaceListService {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceListService.class);

    private final BigInterfaceListRepository bigInterfaceListRepository;

    private final BigInterfaceListMapper bigInterfaceListMapper;

    public BigInterfaceListService(BigInterfaceListRepository bigInterfaceListRepository, BigInterfaceListMapper bigInterfaceListMapper) {
        this.bigInterfaceListRepository = bigInterfaceListRepository;
        this.bigInterfaceListMapper = bigInterfaceListMapper;
    }

    /**
     * Save a bigInterfaceList.
     *
     * @param bigInterfaceListDTO the entity to save.
     * @return the persisted entity.
     */
    public BigInterfaceListDTO save(BigInterfaceListDTO bigInterfaceListDTO) {
        log.debug("Request to save BigInterfaceList : {}", bigInterfaceListDTO);
        BigInterfaceList bigInterfaceList = bigInterfaceListMapper.toEntity(bigInterfaceListDTO);
        bigInterfaceList = bigInterfaceListRepository.save(bigInterfaceList);
        return bigInterfaceListMapper.toDto(bigInterfaceList);
    }

    /**
     * Get all the bigInterfaceLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BigInterfaceListDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BigInterfaceLists");
        return bigInterfaceListRepository.findAll(pageable)
            .map(bigInterfaceListMapper::toDto);
    }


    /**
     * Get one bigInterfaceList by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BigInterfaceListDTO> findOne(Long id) {
        log.debug("Request to get BigInterfaceList : {}", id);
        return bigInterfaceListRepository.findById(id)
            .map(bigInterfaceListMapper::toDto);
    }

    /**
     * Delete the bigInterfaceList by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BigInterfaceList : {}", id);
        bigInterfaceListRepository.deleteById(id);
    }
}
