package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.BizItem;
import com.digitalgd.bigdata.business.repository.BizItemRepository;
import com.digitalgd.bigdata.business.service.dto.BizItemDTO;
import com.digitalgd.bigdata.business.service.mapper.BizItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BizItem}.
 */
@Service
@Transactional
public class BizItemService {

    private final Logger log = LoggerFactory.getLogger(BizItemService.class);

    private final BizItemRepository bizItemRepository;

    private final BizItemMapper bizItemMapper;

    public BizItemService(BizItemRepository bizItemRepository, BizItemMapper bizItemMapper) {
        this.bizItemRepository = bizItemRepository;
        this.bizItemMapper = bizItemMapper;
    }

    /**
     * Save a bizItem.
     *
     * @param bizItemDTO the entity to save.
     * @return the persisted entity.
     */
    public BizItemDTO save(BizItemDTO bizItemDTO) {
        log.debug("Request to save BizItem : {}", bizItemDTO);
        BizItem bizItem = bizItemMapper.toEntity(bizItemDTO);
        bizItem = bizItemRepository.save(bizItem);
        return bizItemMapper.toDto(bizItem);
    }

    /**
     * Get all the bizItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BizItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BizItems");
        return bizItemRepository.findAll(pageable)
            .map(bizItemMapper::toDto);
    }


    /**
     * Get one bizItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BizItemDTO> findOne(Long id) {
        log.debug("Request to get BizItem : {}", id);
        return bizItemRepository.findById(id)
            .map(bizItemMapper::toDto);
    }

    /**
     * Delete the bizItem by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BizItem : {}", id);
        bizItemRepository.deleteById(id);
    }
}
